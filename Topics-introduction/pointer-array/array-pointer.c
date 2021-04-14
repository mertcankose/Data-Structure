#include <stdio.h>

int findMax(int arr[], int len) {
    int max = arr[0];

    int i;
    for(i = 1; i < len; i++) {
        if(arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}
//same way
int findMax2(int *arr, int len) {
    int max = arr[0];

    int i;
    for(i = 1; i < len; i++) {
        if(arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

void test(int arr[], int len) {
    arr[2] = 10;
}


int main() {
    int numbers[5] = {3,4,42,98,1};

    //int *p = &numbers[0];
    int *p = numbers; //It's same the above code

    //addresses
    printf("%u\n",p); //6618624
    printf("%u\n",p+1); //6618628
    printf("%u\n",p+2); //6618632
    printf("%u\n",p+3); //6618636
    printf("%u\n",p+4); //6618640

    //values
    printf("%u\n",*p); //3
    printf("%u\n",*(p+1)); //4
    printf("%u\n",*(p+2)); //42
    printf("%u\n",*(p+3)); //98
    printf("%u\n",*(p+4)); //1

    //actually arrays are too a pointer

    //*(p)   --------> p[0]
    //*(p+1) --------> p[1]
    //*(p+2) --------> p[2]
    //*(p+3) --------> p[3]
    //*(p+4) --------> p[4]

    printf("%u\n",p[0]); //3
    printf("%u\n",p[1]); //4
    printf("%u\n",p[2]); //42
    printf("%u\n",p[3]); //98
    printf("%u\n",p[4]); //1

    //send a function
    int max;
    printf("max: %d\n", findMax(numbers,5));
    printf("max: %d\n", findMax2(numbers,5));

    test(numbers,5);
    printf("test: %d", numbers[2]);
    //test function change the second position of the array because arrays works as call by reference!!

    return 0;
}
