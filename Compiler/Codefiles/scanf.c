#include <stdio.h>

int main(int argc, char *argv[]){
	int a = 1;
	int b = 0;

	if(a){
		if(b){
			printf("%s\n", "B is true");
		}else{
			printf("%s\n", "B is false");
		}
	} else {
		printf("%s\n","A is false" );
	}
}