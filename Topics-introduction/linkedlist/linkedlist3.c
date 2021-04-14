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

    //tek kutuyu ozel olarak dusunmekten kurtulduk.
    /*
    //only one node
    if(root->next == NULL) {
        if(root->value > num) {
            node *temp;
            temp = (node *)malloc(sizeof(node));
            temp->value = num;
            temp->next = root;
            root = temp; //rootun degeri degisti bunu main deki yere bildirmeliyiz.
            return root;
        }else {
            node *temp;
            temp = (node *)malloc(sizeof(node));
            temp->value = num;
            temp->next = NULL;
            root->next = temp;
            return root;
        }
    }
    */
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

    return 0;
}
