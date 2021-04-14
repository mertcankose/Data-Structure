#include <stdio.h>

//call by value
void changeValue(int a, int b) {
    int temp = a;
    a = b;
    b = temp;

    printf("a:%d, b:%d\n",a,b);
}

//call by reference
void changeValue2(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;

    printf("a: %d, b: %d\n", *a, *b);
}

int main() {
    int x = 5, y = 10;

    //call by value
    changeValue(x,y);
    printf("x: %d, y: %d\n",x,y);

    //call by reference
    changeValue2(&x,&y);
    printf("x: %d, y: %d\n",x,y);

    return 0;
}
