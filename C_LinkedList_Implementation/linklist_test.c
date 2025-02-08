#include <stdlib.h>
#include <stdio.h>

#include "linklist.h"

List* buildList(int a, int b, int c);
void append_test();
void prepend_test();
void insert_test();
void remove_test();
void extend_test();
void clear_test();
void contains_and_get_test();

int main(int argc, char* argv[]) {
    // TEST: new_List, init_List, List_prepend, new_Node, and init_Node
    List* listA = buildList(1, 2, 3);
    List* listB = buildList(5, 7, 8);
    // TEST: List_print
    List_print(listA);
    // TEST: List_append
    List_append(listA, 4);
    List_print(listA);
    // TEST: List_contains
    if (!List_contains(listA, 5)) {
        printf("List does not contain 5\n");
    }
    if (List_contains(listA, 4)) {
        printf("List contains 4\n");
    }
    // TEST: List_insert
    List_print(listB);
    List_insert(listB, 1, 6);
    List_print(listB);
    // TEST: List_get
    int val = List_get(listB, 2);
    printf("The value of listB at index %d is %d\n", 2, val);
    // TEST: List_extend
    List_extend(listA, listB);
    List_print(listA);
    // TEST: List_remove
    List_remove(listA, 7);
    List_remove(listA, 1);
    List_remove(listA, 0);
    List_print(listA);
    // TEST: delete_List, List_remove, delete_Node
    delete_List(listA);

    printf("------------------------------\n");
    printf("My Tests\n");
    printf("------------------------------\n");
    printf("Append Test\n");
    printf("------------------------------\n");
    append_test();
    printf("------------------------------\n");
    printf("Prepend Test\n");
    printf("------------------------------\n");
    prepend_test();
    printf("------------------------------\n");
    printf("Insert Test\n");
    printf("------------------------------\n");
    insert_test();
    printf("------------------------------\n");
    printf("Remove Test\n");
    printf("------------------------------\n");
    remove_test();
    printf("------------------------------\n");
    printf("Extend Test\n");
    printf("------------------------------\n");
    extend_test();
    printf("------------------------------\n");
    printf("Clear Test\n");
    printf("------------------------------\n");
    clear_test();
    printf("------------------------------\n");
    printf("Contains and Get Test\n");
    printf("------------------------------\n");
    contains_and_get_test();
    printf("------------------------------\n");

    return EXIT_SUCCESS;
}

/* CORRECT OUTPUT
[ 1 2 3 ]
[ 1 2 3 4 ]
List does not contain 5
List contains 4
[ 5 7 8 ]
[ 5 6 7 8 ]
The value of listB at index 2 is 7
[ 1 2 3 4 5 6 7 8 ]
[ 3 4 5 6 7 ]
*/

List* buildList(int a, int b, int c) {
    List* list = new_List();
    List_prepend(list, c);
    List_prepend(list, b);
    List_prepend(list, a);
    return list;
}

void append_test() {
    List* A = new_List();
    printf("Initial list: ");
    List_print(A);
    
    printf("Append even numbers:\n");
    List_append(A, 2);
    List_print(A);
    List_append(A, 4);
    List_print(A);
    List_append(A, 6);
    List_print(A);
    List_append(A, 8);
    List_print(A);
    List_append(A, 10);
    List_print(A);

    delete_List(A);
}

void prepend_test() {
    List* A = new_List();
    printf("Initial List: ");
    List_print(A);
    printf("Prepend 5-1:\n");
    List_prepend(A, 5);
    List_print(A);
    List_prepend(A, 4);
    List_print(A);
    List_prepend(A, 3);
    List_print(A);
    List_prepend(A, 2);
    List_print(A);
    List_prepend(A, 1);
    List_print(A);

    delete_List(A);
}

void insert_test() {
    List* A = buildList(2, 4, 6);

    printf("Initial List:\n");
    List_print(A);

    printf("Insert 1, 3, 5:\n");
    List_insert(A, 0, 1);
    List_print(A);
    List_insert(A, 2, 3);
    List_print(A);
    List_insert(A, 4, 5);
    List_print(A);

    printf("Insert 7 at index 6:\n");
    List_insert(A, 6, 7);
    List_print(A);

    printf("Try to insert -1 at index -1:\n");
    List_insert(A, -1, -1);
    List_print(A);

    printf("Insert 0 at index 0:\n");
    List_insert(A, 0, 0);
    List_print(A);

    printf("Try to insert 9 at index 9:\n");
    List_insert(A, 9, 9);
    List_print(A);

    delete_List(A);
}

void remove_test() {
    List* A = buildList(1, 2, 3);
    List_append(A, 4);
    List_append(A, 5);
    List_append(A, 6);
    List_append(A, 7);

    printf("Initial List:\n");
    List_print(A);

    printf("Remove 7:\n");
    List_remove(A, 6);
    List_print(A);

    printf("Remove 1:\n");
    List_remove(A, 0);
    List_print(A);

    printf("Remove 4:\n");
    List_remove(A, 2);
    List_print(A);

    delete_List(A);
} 

void extend_test() {
    List* A = buildList(1, 2, 3);
    List* B = buildList(4, 5, 6);
    List* C = buildList(7, 8, 9);

    printf("List A:\n");
    List_print(A);
    printf("List B:\n");
    List_print(B);
    printf("List C:\n");
    List_print(C);

    printf("Extend B with C:\n");
    List_extend(B, C);
    List_print(B);

    printf("Extend A with B:\n");
    List_extend(A, B);
    List_print(A);

    delete_List(A);
}

void clear_test() {
    List* A = buildList(1, 2, 3);
    printf("Initial List:\n");
    List_print(A);

    printf("Clear List:\n");
    List_clear(A);
    List_print(A);

    printf("Append List:\n");
    List_append(A, 2);
    List_print(A);

    printf("Prepend List:\n");
    List_prepend(A, 1);
    List_print(A);

    delete_List(A);
}

void contains_and_get_test() {
    List* A = buildList(1, 2, 3);
    printf("Initial List:\n");
    List_print(A);

    if (List_contains(A, 1)) {
        int x = List_get(A, 0);
        printf("List contains %d\n", x);
    }

    if (!List_contains(A, 999)) {
        printf("List does not contain 999\n");
    }

    printf("Try to get index 3:\n");
    int y = List_get(A, 3);

    delete_List(A);
}
