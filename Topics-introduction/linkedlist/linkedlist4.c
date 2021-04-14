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
    printf("\n");
}

void addLast(node *root, int val){
    while(root->next !=NULL){
        root = root->next;
    }
    root->next = (node *)malloc(sizeof(node));
    root->next->value = val;
    root->next->next = NULL;
}

node * sequentialAdd(node *root, int num) {
    //if link list is empty
    if(root == NULL) {
        root = (node *)malloc(sizeof(node));
        root->next = NULL;
        root->value = num;
        return root;
    }
    //if num is smaller than value of the root.
    //root will change.
    if(root->value > num) {
        node *temp;
        temp = (node *)malloc(sizeof(node));
        temp->value = num;
        temp->next = root;
        root = temp; //rootun degeri degisti bunu main deki yere bildirmeliyiz.
        return root;
    }
    //if link list is not empty
    node *iter;
    iter = root;
    while(iter->next !=NULL && iter->next->value < num) {
        iter = iter->next;
    }
    node *temp;
    temp = (node *)malloc(sizeof(node));
    temp->value = num;
    temp->next = iter->next;
    iter->next = temp;
    return root;
}
//bastaki eleman silinirse root deðiþebilir

node * deleteElement(node *root, int num) {
    node *iter;
    node *temp;
    iter = root;

    //bastaki elemani silersek
    if(root->value == num) {
        temp = root;
        root = root->next;
        free(temp);
        return root;
    }
    while(iter->next != NULL && iter->next->value != num) {
        iter = iter->next;
    }
    if(iter->next == NULL) {
        printf("Sayi bulunamadi\n");
        return root;
    }
    temp = iter->next;
    iter->next = iter->next->next;
    free(temp);
    return root;
}

int main() {
    node *root;
    root = NULL;
    root = sequentialAdd(root, 400);
    root = sequentialAdd(root, 40);
    root = sequentialAdd(root, 4);
    root = sequentialAdd(root, 450);
    root = sequentialAdd(root, 50);
    printElements(root);
    root = deleteElement(root, 50);
    printElements(root);

    return 0;
}
