#include <stdio.h>
#include <stdlib.h>

//Circular Link List

struct node {
    int value;
    struct node *next;
};
typedef struct node node;

void printElements(node *root) {
    node *iter = root;
    printf("%d ", iter->value);
    iter = iter->next;
    while(iter != root) {
        printf("%d ", iter->value);
        iter = iter->next;
    }
    printf("\n");
}

void addLast(node *root, int val){
    node *iter = root;
    while(iter->next !=root){
        iter = iter->next;
    }
    iter->next = (node *)malloc(sizeof(node));
    iter->next->value = val;
    iter->next->next = root;
}

node * sequentialAdd(node *root, int num) {
    //if link list is empty
    if(root == NULL) {
        root = (node *)malloc(sizeof(node));
        root->next = root;
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

        node *iter = root;
        while(iter->next != root) {
            iter = iter->next;
        }
        iter->next = temp;

        root = temp; //rootun degeri degisti bunu main deki yere bildirmeliyiz.
        return root;
    }
    node *iter;
    iter = root;
    while(iter->next != root && iter->next->value < num) {
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
        while(iter->next != root) {
            iter = iter->next;
        }
        iter->next = root->next;
        free(root);
        return iter->next;
    }
    while(iter->next != root && iter->next->value != num) {
        iter = iter->next;
    }
    if(iter->next == root) {
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

    root = deleteElement(root, 9999);
    root = deleteElement(root, 50);
    printElements(root);

    root = deleteElement(root, 450);
    printElements(root);

    root = deleteElement(root, 4);
    printElements(root);

    addLast(root, 180);
    printElements(root);

    return 0;
}
