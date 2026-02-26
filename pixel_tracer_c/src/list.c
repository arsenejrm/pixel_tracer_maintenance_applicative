#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "list.h"


/*
 * FR :
 * Crée un nouveau noeud de liste doublement chaînée.
 * Le noeud est initialisé avec les données fournies et
 * ses pointeurs next et prev sont mis à NULL.
 *
 * ENG :
 * Creates a new doubly linked list node.
 * The node is initialized with the given data and
 * its next and prev pointers are set to NULL.
 */
lnode *lst_create_lnode(void *dat) {
    lnode *ptmp = (lnode *) malloc(sizeof(lnode));
    ptmp->data = dat;
    ptmp->next = NULL;
    ptmp->prev = NULL;
    return ptmp;
}


/*
 * FR :
 * Crée une nouvelle liste doublement chaînée vide.
 * Les pointeurs head et tail sont initialisés à NULL.
 *
 * ENG :
 * Creates a new empty doubly linked list.
 * The head and tail pointers are initialized to NULL.
 */
list *lst_create_list() {
    list *lst = (list *) malloc(sizeof(list));
    lst->head = NULL;
    lst->tail = NULL;
    return lst;
}

/*
 * FR :
 * Supprime complètement une liste.
 * Tous les noeuds sont libérés avant de libérer la structure liste.
 *
 * ENG :
 * Deletes an entire list.
 * All nodes are freed before freeing the list structure itself.
 */
void lst_delete_list(list * lst) {
    lst_erase(lst);
    free(lst);
}

/*
 * FR :
 * Insère un noeud en tête de liste.
 * Si la liste est vide, le noeud devient head et tail.
 *
 * ENG :
 * Inserts a node at the head of the list.
 * If the list is empty, the node becomes both head and tail.
 */
void lst_insert_head(list * lst, lnode * pnew) {
    if (lst->head == NULL) {
        lst->head = pnew;
        lst->tail = pnew;
        return;
    }
    pnew->next = lst->head;
    pnew->prev = NULL;
    lst->head = pnew;
    pnew->next->prev = pnew;
}

/*
 * FR :
 * Insère un noeud en fin de liste.
 * Si la liste est vide, le noeud devient head et tail.
 *
 * ENG :
 * Inserts a node at the end of the list.
 * If the list is empty, the node becomes both head and tail.
 */
void lst_insert_tail(list * lst, lnode * pnew) {
    if (lst->head == NULL) {
        lst->head = pnew;
        lst->tail = pnew;
        return;
    }
    pnew->next = NULL;
    pnew->prev = lst->tail;
    lst->tail = pnew;
    pnew->prev->next = pnew;
}

/*
 * FR :
 * Insère un noeud après un noeud donné.
 * Si le noeud de référence est le dernier, l’insertion
 * est équivalente à une insertion en fin de liste.
 *
 * ENG :
 * Inserts a node after a given node.
 * If the reference node is the tail, this is equivalent
 * to inserting at the end of the list.
 */
void lst_insert_after(list * lst, lnode * pnew, lnode * ptr) {
    if (lst->head == NULL) {
        lst->head = pnew;
        lst->tail = pnew;
    } else if (ptr == NULL) {
        return;
    } else if (lst->tail == ptr) {
        lst_insert_tail(lst, pnew);
    } else {
        pnew->next = ptr->next;
        pnew->prev = ptr;
        pnew->next->prev = pnew;
        pnew->prev->next = pnew;
    }
}

/*
 * FR :
 * Supprime le premier noeud de la liste.
 * Met à jour head et tail si la liste devient vide.
 *
 * ENG :
 * Deletes the first node of the list.
 * Updates head and tail if the list becomes empty.
 */
void lst_delete_head(list * lst) {
    if (lst->head->next == NULL) {
        free(lst->head);
        lst->head = NULL;
        lst->tail = NULL;
        return;
    }
    lst->head = lst->head->next;
    free(lst->head->prev);
    lst->head->prev = NULL;
}
/*
 * FR :
 * Supprime le dernier noeud de la liste.
 * Met à jour head et tail si la liste devient vide.
 *
 * ENG :
 * Deletes the last node of the list.
 * Updates head and tail if the list becomes empty.
 */
void lst_delete_tail(list * lst) {
    if (lst->tail->prev == NULL) {
        free(lst->tail);
        lst->head = NULL;
        lst->tail = NULL;
        return;
    }
    lst->tail = lst->tail->prev;
    free(lst->tail->next);
    lst->tail->next = NULL;
}

/*
 * FR :
 * Supprime un noeud spécifique de la liste.
 * Gère correctement les cas head et tail.
 *
 * ENG :
 * Deletes a specific node from the list.
 * Correctly handles head and tail cases.
 */
void lst_delete_lnode(list * lst, lnode * ptr) {
    if (ptr == NULL)
        return;
    if (ptr == lst->head) {
        lst_delete_head(lst);
        return;
    }
    if (ptr == lst->tail) {
        lst_delete_tail(lst);
        return;
    }
    ptr->next->prev = ptr->prev;
    ptr->prev->next = ptr->next;
    free(ptr);
}
/*
 * FR :
 * Supprime tous les noeuds de la liste sans supprimer
 * la structure list elle-même.
 *
 * ENG :
 * Removes all nodes from the list without deleting
 * the list structure itself.
 */
void lst_erase(list * lst) {
    if (lst->head == NULL)
        return;
    while (lst->head != lst->tail) {
        lst->head = lst->head->next;
        free(lst->head->prev);
    }
    free(lst->head);
    lst->head = NULL;
    lst->tail = NULL;
}
/*
 * FR :
 * Retourne le premier noeud de la liste.
 *
 * ENG :
 * Returns the first node of the list.
 */
lnode *get_first_node(list * lst) {
    if (lst->head == NULL)
        return NULL;
    return lst->head;
}
/*
 * FR :
 * Retourne le dernier noeud de la liste.
 *
 * ENG :
 * Returns the last node of the list.
 */
lnode *get_last_node(list * lst) {
    if (lst->tail == NULL)
        return NULL;
    return lst->tail;
}
/*
 * FR :
 * Retourne le noeud suivant dans la liste.
 *
 * ENG :
 * Returns the next node in the list.
 */
lnode *get_next_node(list * lst, lnode * lnode) {
    if (lnode == NULL)
        return NULL;
    return lnode->next;
}
/*
 * FR :
 * Retourne le noeud précédent dans la liste.
 *
 * ENG :
 * Returns the previous node in the list.
 */
void *get_previous_elem(list * lst, lnode * lnode) {
    if (lnode == NULL)
        return NULL;
    return lnode->prev;
}
