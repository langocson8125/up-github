#include "stdio.h"
#include "stdlib.h"
#include "string.h"

struct Product{
	char code[11];
	char name[255];
	float price;
	int quantity;
	char dateProduct[11];
	char placeProduct[255];	
};

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

void InitListProduct(Product *&array, int n){
	for(int i = 0; i < n; i++){
		*(array + i) = CreateProduct();
	}	
}

void AddElement(Product *&array, int count, Product PhanTuThem){
	realloc(array, (count + 1) * sizeof(Product *));
	*(array + count) = PhanTuThem;
}

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


Product * FindProductPrice(Product *array, int n, float search){
	int count = 0;
	Product * tmpArray;
	tmpArray = (Product *)malloc(1 * sizeof(Product));
	
	for(int i = 0; i <= n/2; i++){
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
	
	if(count <= 0){
		free(tmpArray);
		return NULL;
	}
	else{
		return tmpArray;
	}
}

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
	
	InitListProduct(listProduct, n);
	ShowProduct(listProduct, n);
	
	// test sau khi xóa
	DeleteProductByCode(listProduct, n, "1");
	ShowProduct(listProduct, n);
	
	//Product * result = FindProductName(listProduct, n, "abc");
	//printf("%s", result->code);
	//free(result);
	printf("%s", (listProduct + n)->code);
	free(listProduct);
	return 0;
}
