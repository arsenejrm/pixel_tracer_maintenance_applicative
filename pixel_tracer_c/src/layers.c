#include "layers.h"

/**
 * FR : Crée un nouveau layer.
 * EN : Creates a new layer.
 */
Layer *create_layer(int id, char *name) {
    Layer *ptr_layer = (Layer *) malloc(sizeof(Layer));
    ptr_layer->id = id;
    strcpy(ptr_layer->name, name);
    ptr_layer->shapes = *lst_create_list();
    ptr_layer->visible = 1;
    return ptr_layer;
}
/**
 * FR : Supprime un layer et ses shapes.
 * EN : Deletes a layer and its shapes.
 */
void delete_layer(Layer * layer) {
    lst_erase(&layer->shapes);
    free(layer);
}
/**
 * FR : Crée une liste de layers.
 * EN : Creates a layer list.
 */
LayersList *create_layers_list() {
    LayersList *lst_layer;
    lst_layer = lst_create_list();
    return lst_layer;
}
/**
 * FR : Supprime une liste de layers.
 * EN : Deletes a layer list.
 */
void delete_layers_list(LayersList * layer_list) {
    lst_delete_list(layer_list);
}
/**
 * FR : Ajoute un layer à la liste.
 * EN : Adds a layer to the list.
 */
void add_layer_to_list(LayersList * layer_list, Layer * layer) {
    lnode *l = lst_create_lnode(layer);
    lst_insert_tail(layer_list, l);
}

void remove_layer_from_list(LayersList * layer_list, Layer * layer) {
    /* TODO  */
}
/**
 * FR : Rend un layer visible.
 * EN : Makes a layer visible.
 */
void set_layer_visible(Layer * layer) {
    layer->visible = LAYER_VISIBLE;
}
/**
 * FR : Rend un layer invisible.
 * EN : Makes a layer invisible.
 */
void set_layer_unvisible(Layer * layer) {
    layer->visible = LAYER_UNVISIBLE;
}
/**
 * FR : Ajoute une shape à un layer.
 * EN : Adds a shape to a layer.
 */
void add_shape_to_layer(Layer * layer, Shape * shape) {
    lnode *l = lst_create_lnode(shape);
    lst_insert_tail(&(layer->shapes), l);
}
/**
 * FR : Supprime une shape d'un layer.
 * EN : Removes a shape from a layer.
 * TODO : implémentation à faire
 */
void remove_shape_to_from(Layer * layer, Shape * shape) {

}
