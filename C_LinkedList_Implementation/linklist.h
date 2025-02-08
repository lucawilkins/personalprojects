#ifndef COMP230_LINKLIST_H
#define COMP230_LINKLIST_H

#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <errno.h>

extern int errno;

typedef struct Node {
    int data;
    struct Node* next;
} Node; 


typedef struct List {
    int length;
    Node* head;
} List; 



void init_Node(Node* node, int data);
Node* new_Node(int data);
void delete_Node(Node* node);

void init_List(List* list);
List* new_List();
void delete_List(List* list);

void List_print(List* list);
void List_append(List* list, int data);
void List_prepend(List* list, int data);
void List_extend(List* listA, List* listB);
bool List_contains(List* list, int value);

int List_get(List* list, int index);
int List_insert(List* list, int index, int value);
int List_remove(List* list, int index);
void List_clear(List* list);

#endif /* COMP230_LINKLIST_H */