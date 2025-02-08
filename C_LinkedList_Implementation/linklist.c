#include <errno.h>
#include <stdlib.h>
#include <stdbool.h>
#include <stdio.h>

#include "linklist.h"


/**
 * @brief Initialize an existing Node pointer.
 * 
 * When a node is initialized its data should be set to the given data, and the 
 * next node should be reset to NULL.
 * 
 * @param node  An existing Node to be initialized
 * @param data  The value to be stored in this node
 */
void init_Node(Node* node, int data) {
    node->data = data;
    node->next = NULL;
}

/**
 * @brief Allocates memory and initializes a new Node with the given value.
 * 
 * Nodes constructed using this function should be cleaned up using delete_Node
 * 
 * @param data  The value to be stored in this node
 */
Node* new_Node(int data) {
    Node* new = (Node*) calloc(1, sizeof(Node));
    init_Node(new, data);
    return new;
}

/**
 * @brief Deletes a node and frees the memory allocated for it.
 * 
 * @param node  The node to be deleted
 */
void delete_Node(Node* node) {
    node->data = 0;
    node->next = NULL;
    free(node);
}

/**
 * @brief Initialize a list that already exists in memory.
 * 
 * When a list is initialized its length should be set to 0 and the 
 * head node should be set to NULL.
 * 
 * @param list the list to be initialized
 */
void init_List(List* list) {
    list->head = NULL;
    list->length = 0;
}

/**
 * @brief Allocate memory and create a new empty list.
 * 
 * Lists constructed using this function should be cleaned up using delete_List
 * 
 * @return List* to the newly created list
 */
List* new_List() {
    List* new = (List*) calloc(1, sizeof(List));
    init_List(new);
    return new;
}

/**
 * @brief Deletes an entire list freeing memory for all nodes and the list.
 * 
 * @param list the list to be deleted
 */
void delete_List(List* list) {
    List_clear(list);
    free(list);
}

/**
 * @brief Prints out an entire list
 * 
 * @param list the list to be printed
 */
void List_print(List* list) {
    Node* cursor = list->head;
    printf("[ ");
    while (cursor != NULL) {
        printf("%d ", cursor->data);
        cursor = cursor->next;
    }
    printf("]\n");
}

/**
 * @brief Appends the given value to the list.
 * 
 * When a value is appended to a list, it should become the last item in the 
 * list and the length of the list should increase by one. This should function 
 * the same as the add method of Java's LinkedList with no index argument.
 * 
 * @param list The list to which a value should be appended.
 * @param data  The value to be appended to the list
 */
void List_append(List* list, int data) {
    Node* newest = new_Node(data); 
    if (list->length == 0) {
        list->head = newest;
        list->length++;
    } else {
        Node* curr = list->head; 
        while (curr->next != NULL) { // loop until curr is the last Node in the List
            curr = curr->next;
        }
        curr->next = newest; // assign last Node to point to newest instead of NULL
        list->length++; // increment length
    }
}

/**
 * @brief Prepends the given value to the list.
 * 
 * When a value is prepended to a list, it should become the first item in the 
 * list and the length of the list should increase by one and all the old values 
 * should follow the new one maintaining their order. This should function the 
 * same as the add method of Java's LinkedList with 0 as the index argument.
 * 
 * @param node The list to which the value will be appended.
 * @param data The value to be prepended to the list
 */
void List_prepend(List* list, int data) {
    Node* newest = new_Node(data); 
    newest->next = list->head; // make newest point to the current head
    list->head = newest; // move head pointer to newest
    list->length++; // increment length
}

/**
 * @brief Extends list A by adding all elements of list B to the end in order
 * 
 * When a list is extended with another list, all the elements in the second 
 * list are effectively appended to the first list. These elements maintain the 
 * same order they had in their original list. This should NOT be done using 
 * nested loops and repeated calls to List_append since that is terribly 
 * inefficient.
 * 
 * @param listA The list to be extended
 * @param listB The list to be added to the end of list A
 */
void List_extend(List* listA, List* listB) {
    Node* curr = listA->head; 
    while (curr->next != NULL) { // loop until curr is the last Node in listA
        curr = curr->next; 
    }
    curr->next = listB->head;
    listA->length += listB->length;
}

/**
 * @brief Checks whether or not the given list contains the given value
 * 
 * @param list   The list to be checked for the item
 * @param value  The value for which the list should be searched
 * @return true  If the list contains the item
 * @return false If the list does not contain the item
 */
bool List_contains(List* list, int value) {
    Node* curr = list->head; 
    while (curr != NULL) {
        if (curr->data == value) {
            return true;
        }
        curr = curr->next;
    }
    return false;
}

/**
 * @brief Returns the value of the ith node in the list.
 * 
 * @param list  The list to be indexed for the element
 * @param index The index of the node to be retrieved
 * @return      The value in the node at the index
 */
int List_get(List* list, int index) {
    if (index >= list->length || index < 0) {
        printf("Index out of bounds\n");
        return -1;
    }
    Node* curr = list->head;
    for (int i = 0; i < index; i++) {
        curr = curr->next;
    }
    return curr->data;
}

/**
 * @brief Inserts a new value into the list at a particular position
 * 
 * After the insertion, the new value should be at the specified index. Every 
 * item before it should still have the same index, while the index of every 
 * item after it should now have its index increased by one.
 * 
 * @param list  The list into which a node will be inserted
 * @param index The index where the new value should be inserted
 * @param value The value to be inserted into the list
 * 
 * @return      Returns 0 if operation was successful, otherwise 1
 */
int List_insert(List* list, int index, int value) {
    if (index > list->length || index < 0) {
        printf("Index out of bounds\n");
        return 1;
    }
    else if (index == 0) {
        List_prepend(list, value);
    }
    else if (index == list->length) {
        List_append(list, value);
    } 
    else {
        Node* newest = new_Node(value);
        Node* prev = list->head;
        // loop until prev is the node before the node to be inserted
        for (int i = 0; i < (index - 1); i++) {
            prev = prev->next;
        }
        newest->next = prev->next;
        prev->next = newest;
        list->length++;
    }
    return 0;
}

/**
 * @brief Removes and returns the value of the Node at the given index.
 * 
 * This function will remove the Node at the specified index from the list, 
 * safely free the memory allocated for that node, and return the value stored 
 * in that node.
 * 
 * @param list  The list from which a node will be removed
 * @param index The index of the node to be removed
 * @return      The value in the node at index i
 */
int List_remove(List* list, int index) {
    if (index >= list->length || index < 0) {
        printf("Index out of bounds\n");
        return -1;
    }
    int retval;
    Node* curr = list->head;
    if (index == 0) { 
        // save value of node to be removed
        retval = curr->data; 
        // move head pointer to the next node
        list->head = curr->next; 
        // delete curr, decrement length, return saved value from curr
        delete_Node(curr);
        list->length--;
        return retval;
    } else {
        Node* prev = list->head;
        // loop until prev is the node before the node to be removed
        for (int i = 0; i < (index - 1); i++) { 
            prev = prev->next;
        }
        // make pointer to the node to be removed
        Node* curr = prev->next; 
        // save value of node to be removed
        retval = curr->data; 
        // make previous node point to the node after the one to be removed
        prev->next = curr->next; 
        // delete curr, decrement length, return saved value from curr
        delete_Node(curr);
        list->length--; 
        return retval;
    }
}

/**
 * @brief Safely removes and frees memory for all nodes in the list
 * 
 * This function should call delete_Node to safely free memory for every Node in 
 * the list, be careful to ensure that every node is freed without losing track 
 * of later nodes in the list. Once all pointers to a node are lost it cannot be 
 * safely freed!
 * 
 * @param list the list to be reset to an empty list
 */
void List_clear(List* list) {
    // make ref to head, move head, free old head, decrement length 
    while (list->length != 0) { 
        Node* curr = list->head;
        // move head pointer to the next node
        list->head = curr->next; 
        // delete curr, decrement length
        delete_Node(curr);
        list->length--;
    }
    

    // or use List_remove
    // while (list->length != 0) {
    //     List_remove(list, 0);
    // }
}