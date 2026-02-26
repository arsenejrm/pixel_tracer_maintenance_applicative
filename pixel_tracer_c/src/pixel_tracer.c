#include "pixel_tracer.h"

/*
 * FR :
 * Initialise l’application Pixel Tracer.
 * Crée une zone par défaut, une couche, et
 * initialise les pointeurs courants.
 *
 * ENG :
 * Initializes the Pixel Tracer application.
 * Creates a default area, a layer, and
 * initializes the current pointers.
 */
void init_app(Pixel_tracer_app * app) {
    app->list_area = create_area_list();
    Area *area = create_area(80, 40, get_next_id(), "Area1");
    add_area_to_list(app->list_area, area);
    app->current_area = area;

    LayersList *layerlst = create_layers_list();
    area->lst_layers = layerlst;
    Layer *layer = create_layer(get_next_id(), "Layer 1");
    add_layer_to_list(layerlst, layer);
    app->current_layer = layer;
    app->current_shape = NULL;
}
/*
 * FR :
 * Détruit l’application Pixel Tracer.
 * Libère les ressources et remet les pointeurs à NULL.
 *
 * ENG :
 * Destroys the Pixel Tracer application.
 * Frees resources and resets pointers to NULL.
 */
void destry_app(Pixel_tracer_app * app) {
    delete_area_list(app->list_area);
    app->current_area = NULL;
    app->current_layer = NULL;
    app->current_shape = NULL;
}
