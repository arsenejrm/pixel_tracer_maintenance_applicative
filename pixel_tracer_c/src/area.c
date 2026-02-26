#include "area.h"

/*
 * FR :
 * Crée une zone avec une largeur, une hauteur, un identifiant
 * et un nom. Alloue la grille de caractères associée.
 *
 * ENG :
 * Creates an area with a width, a height, an identifier
 * and a name. Allocates the associated character grid.
 */
Area *create_area(unsigned int width,
                  unsigned int height, unsigned char id, char *name) {
    Area *ptr_area = (Area *) malloc(sizeof(Area));
    ptr_area->width = width;
    ptr_area->height = height;
    ptr_area->lst_layers = create_layers_list();
    ptr_area->id = id;
    ptr_area->empty_char = '.';
    ptr_area->full_char = '@';
    strcpy(ptr_area->name, name);
    ptr_area->area = (char **) malloc(height * sizeof(char *));
    for (unsigned int i = 0; i < ptr_area->height; i++) {
        ptr_area->area[i] = (char *) malloc(width * sizeof(char));
    }
    return ptr_area;
}

/*
 * FR :
 * Supprime une zone et libère la mémoire de sa grille.
 * (La suppression des couches n’est pas encore implémentée.)
 *
 * ENG :
 * Deletes an area and frees its grid memory.
 * (Layer deletion is not implemented yet.)
 */
void delete_area(Area * area) {
    // todo: delate layers
    for (unsigned int i = 0; i < area->height; i++) {
        free(area->area[i]);
    }
    free(area);
}

/*
 * FR :
 * Crée une liste de zones.
 *
 * ENG :
 * Creates a list of areas.
 */
AreaList *create_area_list() {
    AreaList *lst_area;
    lst_area = lst_create_list();
    return lst_area;


}

/*
 * FR :
 * Supprime une liste de zones.
 * (La suppression des zones internes n’est pas encore implémentée.)
 *
 * ENG :
 * Deletes an area list.
 * (Internal area deletion is not implemented yet.)
 */
void delete_area_list(AreaList * area_list) {
    /* TODO : delete all layers on the list */
    lst_delete_list(area_list);

}

/*
 * FR :
 * Ajoute une zone à une liste de zones.
 *
 * ENG :
 * Adds an area to an area list.
 */
void add_area_to_list(AreaList * area_list, Area * area) {
    lnode *l = lst_create_lnode(area);
    lst_insert_tail(area_list, l);
}

/*
 * FR :
 * Supprime une zone d’une liste de zones.
 * (Fonction non implémentée.)
 *
 * ENG :
 * Removes an area from an area list.
 * (Function not implemented.)
 */
void remove_area_from_list(AreaList * area_list, Area * area) {
    /* TODO  */

}
