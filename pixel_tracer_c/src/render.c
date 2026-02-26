#include "render.h"
#include <string.h>

/*
 * FR :
 * Efface complètement le contenu d’une zone.
 * Toutes les cellules sont remises à l’état vide.
 *
 * ENG :
 * Clears the entire content of an area.
 * All cells are reset to the empty state.
 */
void clear_area(Area * area) {
    for (unsigned int i = 0; i < area->height; i++) {
        for (unsigned int j = 0; j < area->width; j++) {
            area->area[i][j] = EMPTY_CELL;
        }
    }
}
/*
 * FR :
 * Affiche une zone à l’écran en parcourant
 * chaque cellule et en affichant le caractère
 * correspondant à son état.
 *
 * ENG :
 * Displays an area on screen by iterating
 * over each cell and printing the character
 * corresponding to its state.
 */
void draw_area(Area * area) {
    for (unsigned int i = 0; i < area->height; i++) {
        for (unsigned int j = 0; j < area->width; j++) {
            switch (area->area[i][j]) {
            case EMPTY_CELL:
                printf("%c", area->empty_char);
                break;
            case FULL_CHAR:
                printf("%c", area->full_char);
                break;
            }
        }
        printf("\n");
    }
}

/*
 * FR :
 * Efface l’écran du terminal.
 * Implémentation spécifique selon le système d’exploitation.
 *
 * ENG :
 * Clears the terminal screen.
 * Implementation depends on the operating system.
 */
void clear_screen() {

#ifdef __linux__
    printf("\033[H\033[J");
#elif _WIN32
    system("cls");
#else
    printf("\033[H\033[J");
#endif

}

/*
 * FR :
 * Dessine toutes les couches visibles d’une zone.
 * Les couches sont parcourues dans l’ordre de la liste.
 *
 * ENG :
 * Draws all visible layers of an area.
 * Layers are processed in list order.
 */
void draw_all_layers(Area * area) {
    clear_area(area);
    list *layer_list = area->lst_layers;
    lnode *layer_node = get_first_node(layer_list);
    while (layer_node != NULL) {
        Layer *layer = (Layer *) layer_node->data;
        if (layer->visible == LAYER_VISIBLE) {
            draw_layer_shapes(area, layer);
        }
        layer_node = get_next_node(layer_list, layer_node);
    }

}


/*
 * FR :
 * Dessine toutes les formes d’une couche donnée.
 * Chaque forme est convertie en pixels avant d’être appliquée à la zone.
 *
 * ENG :
 * Draws all shapes of a given layer.
 * Each shape is converted into pixels before being applied to the area.
 */
void draw_layer_shapes(Area * area, Layer * layer) {
    list shape_list = layer->shapes;

    lnode *shape_node = get_first_node(&shape_list);
    while (shape_node != NULL) {
        Shape *shp = (Shape *) shape_node->data;

        list *list_pixel = create_shape_to_pixel(shp);

        lnode *pixel_node = get_first_node(list_pixel);
        while (pixel_node != NULL) {
            Pixel *pxl = pixel_node->data;
            if (pxl->px < area->height && pxl->py < area->width)
                area->area[pxl->px][pxl->py] = FULL_CHAR;
            pixel_node = get_next_node(list_pixel, pixel_node);
        }
        void remove_pixel_shape(list * list_pixel);
        shape_node = get_next_node(&shape_list, shape_node);
    }

    return;
}
