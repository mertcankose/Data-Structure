#include <stdio.h>
#include <stdlib.h>

struct node {
    int value;
    struct node *next;
};
typedef struct node node;

void printElements(node *root) {
    while(root != NULL) {
        printf("%d ", root->value);
        root = root->next;
    }
}

void addLast(node *root, int val){
    while(root->next !=NULL){
        root = root->next;
    }
    root->next = (node *)malloc(sizeof(node));
    root->next->value = val;
    root->next->next = NULL;
}

int main() {
    node *root;
    root = (node *)malloc(sizeof(node));
    root->value = 10;
    root->next = NULL;

    for(int i = 1;i<=5;i++) {
        addLast(root,i*10);
    }

    printElements(root);

    return 0;
}
