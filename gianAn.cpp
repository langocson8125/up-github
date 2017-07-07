#include "stdio.h"

int main(){
	int m, n,result = 0;
	scanf("%d %d",&m,&n); //m dong, n cot
	int a[m][n];
	for( int i = 0; i < m  ; i++){
		for( int j = 0; j < n; j++){
			scanf("%d",&a[i][j]);
		}
	}
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(a[i-1][j] > a[i][j-1]){
				a[i][j] += a[i-1][j];
			}
			else if(a[i-1][j] <= a[i][j-1]){
				a[i][j] += a[i][j-1];
			}
		}
	}
	printf("\n");
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			printf("%d ",a[i][j]);	
		}
		printf("\n");
	}
	return 0;
}
