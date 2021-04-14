#include <stdio.h>
#include <stdlib.h>

struct node {
    int value; //ortadaki veri
    struct node *left; //verinin solu
    struct node *right; //verini saðý
};
typedef struct node node;

node *add(node *tree, int num) {
    if(tree == NULL) {
        node *root = (node *)malloc(sizeof(node));
        root->left = NULL;
        root->right = NULL;
        root->value = num;
        return root;
    }

    if(tree->value < num) {
        tree -> right = add(tree -> right, num);
        return tree;
    }
    tree->left = add(tree->left, num);
    return tree;
}

//small to big
void traversal(node *tree) {
    if(tree == NULL) {
        return;
    }
    traversal(tree->left);
    printf("%d ", tree->value);
    traversal(tree->right);
}

//buyukten kucuge
void traversal2(node *tree) {
    if(tree == NULL) {
        return;
    }
    traversal2(tree->right);
    printf("%d ", tree->value);
    traversal2(tree->left);
}

int search(node *tree, int aranan) {
    if(tree == NULL) {
        return -1;
    }
    if(tree->value == aranan) {
        return 1;
    }
    if(search(tree->right, aranan) == 1) {
        return 1;
    }
    if(search(tree->left, aranan) == 1) {
        return 1;
    }
    return -1;
}

int max(node *tree) {
    while(tree->right != NULL) {
        tree = tree->right;
    }
    return tree->value;
}

int min(node *tree) {
    while(tree->left != NULL) {
        tree = tree->left;
    }
    return tree->value;
}

int main() {
    node *tree = NULL;

    //Insertion
    tree = add(tree, 12);
    tree = add(tree, 200);
    tree = add(tree, 190);
    tree = add(tree, 213);
    tree = add(tree, 56);
    tree = add(tree, 24);
    tree = add(tree, 18);
    tree = add(tree, 27);
    tree = add(tree, 28);

    //Dolasma(traversal)
    traversal(tree);
    printf("\n");
    traversal2(tree);
    printf("\n");

    //Search
    printf("Arama sonucu: %d\n", search(tree,100));
    printf("Arama sonucu: %d\n", search(tree,24));

    //min-max
    printf("max: %d\n", max(tree));
    printf("min: %d\n", min(tree));

    return 0;
}
