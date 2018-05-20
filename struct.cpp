#include "stdio.h"
#include "stdlib.h"
#include "string.h"

struct Product{
	char code[11];
	char name[255];
	float price;
	int quantity;
	char dateProduct[255];
	char placeProduct[255];	
};

Product CreateProduct(){
	Product created;
	created.price = 0;
	printf("---------------------------------\n");
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


void ShowProduct(Product *array, int n = 1){
	printf("Danh sach san pham\n");
	for(int i = 0; i < n; i++){
		printf("--------------------------------------------------------\n");
		printf("Code: %s | ", (array + i)->code);
		printf("Name: %s | ", (array + i)->name);
		printf("Price: %3.2f | ", (array + i)->price);
		printf("Quantity: %d | ", (array + i)->quantity);
		printf("Date product: %s | ", (array + i)->dateProduct);
		printf("Place product: %s\n", (array + i)->placeProduct);
	}	
}

void InsertMoreProduct(Product *&array, int n){
	for(int i = 0; i < n; i++){
		*(array + i) = CreateProduct();
	}	
}

void InsertOneProduct(Product *&array, int &n, Product PhanTuThem){
	realloc(array, (n + 1) * sizeof(Product *));
	*(array + n) = PhanTuThem;
}

Product * FindProductCode(Product *array, int n, char* search){
	for(int i = 0; i < n/2; i++){
		if((array + i)->code == search){
			return (array + i);
		}
		else if((array + n - 1 - i)->code == search){
			return (array + n - 1 - i);
		}
	}
	return NULL;
}

Product * FindProductName(Product *array, int n, char* search){
	for(int i = 0; i < n/2; i++){
		if((array + i)->name == search){
			return (array + i);
		}
		else if((array + n - 1 - i)->name == search){
			return (array + n - 1 - i);
		}
	}
	return NULL;
}


Product * FindProductPrice(Product *array, int n, float search){
	int count = 0;
	Product * tmpArray;
	tmpArray = (Product *)malloc(count * sizeof(Product));
	
	for(int i = 0; i < n/2; i++){
		if((array + i)->price == search){
			count++;
			InsertOneProduct(tmpArray, count, *(array + i));
		}
		else if((array + n - 1 - i)->price == search){
			count++;
			InsertOneProduct(tmpArray, count, *(array + n - 1 - i));
		}
	}
	return tmpArray;
}

int main(){
	int n;
	do{
		printf("\nNhap so luong san pham: ");
		scanf("%d", &n);
		if(n < 0){
			printf("\nError!!!.");
		}
	}
	while(n <= 0);
	
	Product *listProduct;
	listProduct = (Product *)malloc(n * sizeof(Product));
	
	if(n == 1){
		*listProduct = CreateProduct();
		//ShowProduct(listProduct);
	}
	else {
		InsertMoreProduct(listProduct, n);
		//ShowProduct(listProduct, n);
	}
	
	if(FindProductPrice(listProduct, n, 1) == NULL){
		printf("Khong tim thay san pham nao");
	}
	else{
		printf("San pham can tim: %p\n", FindProductPrice(listProduct, n, 1));
	}
	
	free(listProduct);
	return 0;
}
