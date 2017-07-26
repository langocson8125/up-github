#include "sys/socket.h"
#include "netinet/in.h"
#include "arpa/inet.h"
#include "stdio.h"
#include "stdlib.h"
#include "unistd.h"
#include "errno.h"
#include "string.h"
#include "sys/types.h"

struct sockaddr_in c_addr;
char fname[11] = "scrShot.png";

void *SendFileToClient(int *arg){
	
	int connfd = (int)*arg;
	printf("Connected to Client: %s:%d\n",inet_ntoa(c_addr.sin_addr),ntohs(c_addr.sin_port));
	
	write(connfd, fname, 256);
	unsigned long fsize = 0;
	FILE *fs = fopen(fname,"r");
	
	if(fs == NULL){
		printf("Error in opening file");
	}
	
	fseek(fs, 0L, 2);
	fsize = ftell(fs);
	printf("Size: %lu bytes\n", fsize);
	fclose(fs);
	
	char fsz[20];
	sprintf(fsz, "%lu", fsize);
	write(connfd, fsz, 20);
	FILE *fp = fopen(fname, "rb");
	
	if(fp == NULL){
		printf("File open error");
		return 1;
	}
	
	while(1){
		unsigned char buff[1024] = {0};
		int nread = fread(buff, 1, 1024, fp);
		if(nread > 0){
			write(connfd, buff, nread);
		}
		if(nread < 1024){
			if(feof(fp)){
				printf("End of file\n");
				printf("File transfer completed for id: %d\n", connfd);
				
				/*Delete screen shot*/
				system("rm -f scrShot.png");
			}
			if(ferror(fp)){
				printf("Error reading \n");
			}
			break;
		}
	}
	printf("Closing connection for Id: %d\n", connfd);
	close(connfd);
}

int main(int argc, char *argv[]){
	
	
	/*Varivales*/
	int connfd = 0, err;
	pthread_t tid;
	struct sockaddr_in serv_addr;
	size_t clen = 0;
	
	
	/*Create a socket*/
	int listenfd = socket(AF_INET, SOCK_STREAM, 0);
	if(listenfd < 0){
		printf("Error in socket creation\n");
		exit(2);
	}
	printf("Socket retrieve success\n");
	
	serv_addr.sin_family = AF_INET;
	serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
	serv_addr.sin_port = htons(5000);
	
	/*Bind a connection */
	int ret = bind(listenfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr));
	
	if(ret < 0){
		printf("Error in bind\n");
		exit(2);
	}
	/*Listen a connection*/
	if(listen(listenfd, 10) == -1){
		printf("Failed to listen\n");
		return -1;
	}
	
	for(int i = 0; i < 11; i++){
		*(argv + i) = fname[i];
	}
		
	while(1){
		clen = sizeof(c_addr);
		printf("Waiting.......\n");
		
		/*Accept conection*/
		connfd = accept(listenfd, (struct sockaddr *) &c_addr, &clen);
		if(connfd < 0){
			printf("Error in accept\n");
			continue;
		}
		
		//Command from client
		int commandFroCli = 0; 
		recv(listenfd, commandFroCli, sizeof(commandFroCli), 0);
		printf("%d",commandFroCli);
		if(commandFroCli){
			/*Take a screen shot*/
			system("import -window root scrShot.png");
			sleep(2000);
		}
		
		err = pthread_create(&tid, NULL, &SendFileToClient, &connfd);
		if(err != 0)
			printf("\nCannot create thread: [%s]", strerror(err));
	}
	
	/*Close socket*/
	close(connfd);
	return 0;
}
