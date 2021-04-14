#include <stdio.h>
#include <stdlib.h>

struct node{
    int value;
    struct node *next;
};

typedef struct node node;

int main() {

    node *root;
    root = (node *)malloc(sizeof(node));
    root->value = 10;
    root->next = (node *)malloc(sizeof(node));
    root->next->value = 20;
    root->next->next = (node *)malloc(sizeof(node));
    root->next->next->value = 30;

    root->next->next->next = NULL;

    printf("%d ",root->value);
    printf("%d ",root->next->value);
    printf("%d\n",root->next->next->value);

    node *iter;
    iter = root;

    while(iter->next !=NULL){
        printf("%d ",iter->value);
        iter = iter->next;
    }
    printf("%d ",iter -> value);

    return 0;
}
