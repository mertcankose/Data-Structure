#include <stdio.h>
#include <stdlib.h>

struct node {
    int value;
    struct node *next;
};
typedef struct node node;


node *root = NULL;
node *iter = NULL;

//sona ekle
void enqueue(int num) {
    if(root == NULL) {
        root = (node *)malloc(sizeof(node));
        root->value = num;
        root->next = NULL;
        iter = root;
    }else {
        iter->next = (node *)malloc(sizeof(node));
        iter->next->value = num;
        iter = iter->next;
        iter->next = NULL;
    }
}
//bastan cýkar.
int dequeue() {
    if(root == NULL) {
        printf("Link list is empty");
        return -1;
    }
    int rvalue = root->value;
    node *temp = root;
    root = root->next;
    free(temp);
    return rvalue;
}

int main() {

    for(int i = 0; i< 20; i++) {
        enqueue(i*10);
    }

    for(int i = 0; i<13;i++) {
        printf("%d ", dequeue());
    }
    printf("\n");
    for(int i = 0; i< 20; i++) {
        enqueue(i*10);
    }

    for(int i = 0; i<30;i++) {
        printf("%d ", dequeue());
    }
        printf("\n");

    return 0;
}
