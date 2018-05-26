#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "time.h"

struct Product{
	char code[11];
	char name[255];
	float price;
	int quantity;
	char dateProduct[11];
	char placeProduct[255];	
};

// khai báo các hàm
Product CreateProduct();
void ShowProduct(Product *, int);
void InitListProduct(Product *&, int);
void AddElement(Product *&, int, Product);
Product * FindProductCode(Product *, int, char*);
Product * FindProductName(Product *, int, char*);
Product * FindProductPrice(Product *, int, float, int&);
int EditProductByCode(Product *&, int, char*);
int DeleteProductByCode(Product *&, int &, char*);
void SaveFileData(Product *, int, char*);
void ReadFileData(Product *, int, char*);

// mô tả hoạt động của các hàm

// hàm tạo sản phẩm, trả về sản phẩm sau khi tạo
Product CreateProduct(){
	Product created;
	
	printf("Insert product(s)\n");
	fflush(stdin);
	printf("Code:");
	gets(created.code);
	printf("Name:");
	gets(created.name);
	
	do{
		printf("Price:");
		scanf("%f", &created.price);
		fflush(stdin);
		if(created.price <= 0){
			printf("Insert invalid price! Try again\n");
		}
	}
	while(created.price <= 0);
	do{
		printf("Quantity:");
		scanf("%d", &created.quantity);
		fflush(stdin);
		if(created.quantity < 0){
			printf("Insert invalid quantity! Try again\n");
		}
	}
	while(created.price <= 0);

	printf("Date product:");
	gets(created.dateProduct);
	printf("Place product:");
	gets(created.placeProduct);
	return created;
}

// hàm hiển thị ra các sản phẩm
void ShowProduct(Product *array, int n){
	printf("List Product\n");
	for(int i = 0; (array + i) != (array + n); i++){
		printf("--------------------------------------------------------\n");
		printf("Code: %s | ", (array + i)->code);
		printf("Name: %s | ", (array + i)->name);
		printf("Price: %3.2f | ", (array + i)->price);
		printf("Quantity: %d | ", (array + i)->quantity);
		printf("Date product: %s | ", (array + i)->dateProduct);
		printf("Place product: %s\n", (array + i)->placeProduct);
	}	
}

// hàm khởi tạo danh sách các sản phẩm nhập vào
void InitListProduct(Product *&array, int n){
	for(int i = 0; i < n; i++){
		*(array + i) = CreateProduct();
	}	
}

// thêm sản phẩm 
void AddElement(Product *&Array, int count, Product PhanTuThem){
	realloc(Array, count * sizeof(Product *));
	*(Array + count) = PhanTuThem;
}

// tìm kiếm sản phẩm theo mã sản phẩm
Product * FindProductCode(Product *array, int n, char *search){
	for(int i = 0; i <= n/2; i++){	
		if(strcmp((array + i)->code, search) == 0){
			return (array + i);
		}
		else if(strcmp((array + n - 1 - i)->code, search) == 0){
			return (array + n - 1 - i);
		}
	}
	return NULL;
}

// tìm kiếm sản phẩm theo tên
Product * FindProductName(Product *array, int n, char *search){
	for(int i = 0; i <= n/2; i++){
		if(strcmp((array + i)->name, search) == 0){
			return (array + i);
		}
		else if(strcmp((array + n - 1 - i)->name, search) == 0){
			return (array + n - 1 - i);
		}
	}
	return NULL;
}

// tìm kiếm sản phẩm theo giá sản phẩm
Product * FindProductPrice(Product *array, int n, float search, int &numProduct){
	int count = 0;
	Product * tmpArray;
	tmpArray = (Product *)malloc(1 * sizeof(Product));
	if(n % 2 == 0){
		n = n / 2 - 1;
	}
	else{
		n = n / 2;
	}
	for(int i = 0; i <= n; i++){
		if ((i == (n - i - 1)) && ((array + i)->price == search)){
			count++;
			AddElement(tmpArray, count, *(array + i));
		}
		else{
			if((array + i)->price == search){
				count++;
				AddElement(tmpArray, count, *(array + i));
			}
			else if((array + n - 1 - i)->price == search){
				count++;
				AddElement(tmpArray, count, *(array + n - 1 - i));
			}
		}
	}
	numProduct = count;
	if(count <= 0){
		free(tmpArray);
		return NULL;
	}
	else{
		return tmpArray;
	}
}

// chỉnh sửa sản phẩm dựa vào mã sản phẩm
int EditProductByCode(Product *&array, int n, char* code){
	Product * tmpPointer = FindProductCode(array, n, code);
	if(tmpPointer == NULL){
		return 0;
	}
	else{
		*tmpPointer = CreateProduct();
		return 1;
	}
}

// xóa sản phẩm dựa vào mã sản phẩm
int DeleteProductByCode(Product *&array, int &n, char* code){
	Product * tmpPointer = FindProductCode(array, n, code);
	if(tmpPointer == NULL){
		return 0;
	}
	else{
		for(int i = 0; (array + i) != (array + n - 1); i++){
			*(array + i) = *(array + i + 1);
		}
		n--; 
		realloc(array, n * sizeof(Product *)); 
		return 1;
	}
}

// lưu sản phẩm vào file .txt
void SaveFileData(Product *array, int n, char *fileName){
	FILE *file;
	file = fopen(fileName, "w");
	if(!file){
		printf("\nFile not found: %s", fileName);
		return;
	}
	// get system time
	time_t rawtime;
    struct tm * timeinfo;

    time (&rawtime);
    timeinfo = localtime (&rawtime);
	// lưu thời gian ghi file
    fprintf(file, "%s", asctime(timeinfo));
    
    // write data into file
	for(int i = 0; i < n; i++){
		fprintf(file, "Code:%s|", (array + i)->code);
		fprintf(file, "Name:%s|", (array + i)->name);
		fprintf(file, "Price:%3.2f|", (array + i)->price);
		fprintf(file, "Quantity:%d|", (array + i)->quantity);
		fprintf(file, "Date product:%s|", (array + i)->dateProduct);
		fprintf(file, "Place product:%s\n", (array + i)->placeProduct);
	}
	fclose(file);
}

// hàm đọc dũ liệu từ file
void ReadFileData(Product *array, int n, char *fileName){
	/*
	đọc dữ liệu từ file
	hiển thị ra thời gian là dòng đầu tiên trong file
	lưu danh sách các sản phẩm từ file vào mảng
	*/
}

int main(){
	int n;
	int numProduct = 0;
	do{
		printf("\nInsert product quantity: ");
		scanf("%d", &n);
		if(n < 0){
			printf("\nError!!!.");
		}
	}
	while(n <= 0);
	
	// cấp phát n ô nhớ chưa n sản phẩm
	Product * listProduct = (Product *)malloc(n * sizeof(Product));
	
	// khởi tạo danh sách các sản phẩm
	InitListProduct(listProduct, n);
	// hiển thị danh sách sản phẩm sau khi khởi tạo
	ShowProduct(listProduct, n);
	
	// test sau khi xóa
	//DeleteProductByCode(listProduct, n, "2");
	//ShowProduct(listProduct, n);
	//SaveFileData(listProduct, n, "data.txt");
	
	Product *result = FindProductPrice(listProduct, n, 1, numProduct);
	
	if(numProduct <= 0){
		printf("\nNo product found");
	}
	else{
		printf("\nFound product: %d\n", numProduct);
		ShowProduct(result, numProduct);
	}
	
	free(result);
	free(listProduct);
	return 0;
}
