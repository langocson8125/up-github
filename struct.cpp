#include "stdio.h"
#include "stdlib.h"
#include "string.h"

// khởi tạo cấu trúc cho một sản phẩm
struct Product{
	char code[11];
	char name[255];
	float price;
	int quantity; // số lượng 
	char dateProduct[11];
	char placeProduct[255];	
};

// hàm tạo sản phẩm
Product CreateProduct(){
	Product created; // tạo một biến chứa sản phẩm
	printf("Insert product(s)\n");
	fflush(stdin);
	printf("Code:");
	gets(created.code); // nhập code
	printf("Name:");
	gets(created.name); // nhập tên
	
	do{
		printf("Price:");
		scanf("%f", &created.price);
		fflush(stdin);
		if(created.price <= 0){
			printf("Insert invalid price! Try again\n");
		}
	}
	while(created.price <= 0); // nhập giá
	
	do{
		printf("Quantity:");
		scanf("%d", &created.quantity);
		fflush(stdin);
		if(created.quantity < 0){
			printf("Insert invalid quantity! Try again\n");
		}
	}
	while(created.price <= 0); // nhập số lượng

	printf("Date product:");
	gets(created.dateProduct); // nhập ngày sản xuất
	
	printf("Place product:");
	gets(created.placeProduct); // nhập nơi sản xuất
	
	// trả về sản phẩm sau khi tạo
	return created;
}

// hảm hiển thị các sản phẩm
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

// hàm thêm nhiều sản phẩm
void InitListProduct(Product *&array, int n){
	for(int i = 0; i < n; i++){
		*(array + i) = CreateProduct();
	}	
}

// hàm thêm một sản phẩm 
void AddElement(Product *&array, int &n, Product PhanTuThem){
	realloc(array, (n + 1) * sizeof(Product *));
	*(array + n) = PhanTuThem;
}

// ERROR!!!
// tìm sản phẩm theo code
Product * FindProductCode(Product *array, int n, char* search){
	for(int i = 0; i < n/2; i++){
		if(strcmp((array + i)->code, search) == 0){
			return (array + i);
		}
		else if(strcmp((array + n - 1 - i)->code, search) == 0){
			return (array + n - 1 - i);
		}
	}
	return NULL;
}

// ERROR!!!
// tìm sản phẩm theo tên
Product * FindProductName(Product *array, int n, char* search){
	for(int i = 0; i < n/2; i++){
		if(strcmp((array + i)->name, search) == 0){
			return (array + i);
		}
		else if(strcmp((array + n - 1 - i)->name, search) == 0){
			return (array + n - 1 - i);
		}
	}
	return NULL;
}

// tìm sản phẩm theo giá
// vì trong danh sách các sản phẩm có sẽ có các sản phẩm trùng giá nên cần tạo một mảng chứa các kết quả tìm được
Product * FindProductPrice(Product *array, int n, float search){
	int count = 0;
	Product * tmpArray;
	// vì trong danh sách các sản phẩm có sẽ có các sản phẩm trùng giá nên cần tạo một mảng chứa các kết quả tìm được
	
	tmpArray = (Product *)malloc(count * sizeof(Product));
	
	for(int i = 0; i < n/2; i++){
		if((array + i)->price == search){
			count++;
			// đưa kết quả đó vào mảng tạm
			AddElement(tmpArray, count, *(array + i));
		}
		else if((array + n - 1 - i)->price == search){
			count++;
			// đưa kết quả đó vào mảng tạm
			AddElement(tmpArray, count, *(array + n - 1 - i));
		}
	}
	
	// test thử xem số sản phẩm tìm được có bằng biến count hay k;
	printf("Tim thay %d san pham\n", sizeof(tmpArray) / sizeof(Product));
	
	// trả về kết quả tiềm kiếm
	if(count <= 0){
		free(tmpArray);
		return NULL;
	}
	else{
		return tmpArray;
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
	while(n <= 0); // nhập số sản phẩm cần tạo
	
	// tạo mảng chứa các sản phẩm
	Product *listProduct;
	// cấp phát ô nhớ cho mảng đó
	listProduct = (Product *)malloc(n * sizeof(Product));
	
	// nhập n sản phẩm đó
	InitListProduct(listProduct, n);
	// hiển thị ra danh sách các sản phẩm đã nhập
	ShowProduct(listProduct, n);
	
	if(FindProductPrice(listProduct, n, 1) == NULL){
		printf("Khong tim thay san pham nao");
	}
	else{
		printf("San pham can tim: %p\n", FindProductPrice(listProduct, n, 1));
	}
	
	// xóa bộ nhớ của mảng
	free(listProduct);
	return 0;
}
