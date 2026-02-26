#include <stdio.h>
#include <stdlib.h>
#include "pixel_tracer.h"
#include "command.h"




/**
 * FR : Point d'entrée principal de l'application Pixel Tracer.
 *      Initialise l'application, gère la boucle principale et le rendu.
 *
 * EN : Main entry point of the Pixel Tracer application.
 *      Initializes the application, handles the main loop and rendering.
 */
int main() {
    Pixel_tracer_app app;
    init_app(&app);
    clear_screen();
    draw_all_layers(app.current_area);
    draw_area(app.current_area);

    while (1) {
        int err = read_exec_command(&app);
        if (err == 0 || err == 6) {
            clear_screen();
            draw_all_layers(app.current_area);  // make pixels
            draw_area(app.current_area);        // render
        }
        if (err == 6) {
            clear_screen();
            draw_all_layers(app.current_area);  // make pixels
            draw_area(app.current_area);        // render
        }
        if (err == 4) {
            break;
        }
        if (err == 5) {
            clear_screen();
        }
        if (err == 7 || err == 8) {
            continue;
        }
    }

    destry_app(&app);
}
