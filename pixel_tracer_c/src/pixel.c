#include "pixel.h"

/*
 * FR :
 * Crée un pixel avec une position (x, y) et une couleur.
 * La mémoire est allouée dynamiquement.
 *
 * ENG :
 * Creates a pixel with a position (x, y) and a color.
 * Memory is dynamically allocated.
 */
Pixel *create_pixel(int px, int py, int color) {
    Pixel *pixel = (Pixel *) malloc(sizeof(Pixel));
    pixel->px = px;
    pixel->py = py;
    pixel->color = color;
    return pixel;
}

/*
 * FR :
 * Libère la mémoire associée à un pixel.
 *
 * ENG :
 * Frees the memory associated with a pixel.
 */
void delete_pixel(Pixel * pixel) {
    free(pixel);
}


/*
 * FR :
 * Génère la liste de pixels correspondant à une forme donnée.
 * La forme est convertie en pixels selon son type géométrique.
 *
 * ENG :
 * Generates a list of pixels corresponding to a given shape.
 * The shape is converted into pixels according to its geometry type.
 */
list *create_shape_to_pixel(Shape * shape) {
    if (shape->ptrShape == NULL) {
        return NULL;
    }
    list *lst = lst_create_list();

    switch (shape->shape_type) {
    case POINT:
        pixel_point(shape, lst);
        break;
    case LINE:
        pixel_line(shape, lst);
        break;
    case SQUAR:
        pixel_square(shape, lst);
        break;
    case RECTANGLE:
        pixel_rectangle(shape, lst);
        break;
    case CERCLE:
        pixel_cercle(shape, lst);
        break;
    case POLYGON:
        pixel_polygon(shape, lst);
        break;
    case CURVE:
        pixel_curve(shape, lst);
        break;

    }

    return lst;
}

/*
 * FR :
 * Supprime les pixels associés à une forme.
 * (Fonction non implémentée pour le moment.)
 *
 * ENG :
 * Removes the pixels associated with a shape.
 * (Function not implemented yet.)
 */
void remove_pixel_shape(list * pixel_lst) {

}

/*
 * FR :
 * Génère un pixel à partir d’un point.
 *
 * ENG :
 * Generates a pixel from a point.
 */
void pixel_point(Shape * shape, list * lst) {
    Point *pt = (Point *) shape->ptrShape;
    Pixel *px = create_pixel(pt->pos_x, pt->pos_y, shape->color);
    lst_insert_tail(lst, lst_create_lnode(px));
}

/*
 * FR :
 * Dessine un segment entre deux points
 *
 * ENG :
 * Draws a segment between two points
 */
void draw_segment(int x, int y, int dx, int dy, Color color, list * lst) {
    int i, cumul;
    int xinc, yinc;
    Pixel *px;

    xinc = (dx > 0) ? 1 : -1;
    yinc = (dy > 0) ? 1 : -1;
    dx = abs(dx);
    dy = abs(dy);

    px = create_pixel(x, y, color);
    lst_insert_tail(lst, lst_create_lnode(px));

    if (dx > dy) {
        cumul = dx / 2;
        for (i = 1; i <= dx; i++) {
            x += xinc;
            cumul += dy;
            if (cumul >= dx) {
                cumul -= dx;
                y += yinc;
            }
            px = create_pixel(x, y, color);
            lst_insert_tail(lst, lst_create_lnode(px));
        }
    } else {
        cumul = dy / 2;
        for (i = 1; i <= dy; i++) {
            y += yinc;
            cumul += dx;
            if (cumul >= dy) {
                cumul -= dy;
                x += xinc;
            }
            px = create_pixel(x, y, color);
            lst_insert_tail(lst, lst_create_lnode(px));
        }
    }
}

/*
 * FR :
 * Génère les pixels correspondant à une ligne.
 *
 * ENG :
 * Generates the pixels corresponding to a line.
 */
void pixel_line(Shape * shape, list * lst) {
    Line *p_line = (Line *) shape->ptrShape;
    int dx, dy, x, y;

    x = p_line->p1->pos_x;
    y = p_line->p1->pos_y;
    dx = p_line->p2->pos_x - p_line->p1->pos_x;
    dy = p_line->p2->pos_y - p_line->p1->pos_y;
    draw_segment(x, y, dx, dy, shape->color, lst);
}

/*
 * FR :
 * Génère les pixels d’un cercle
 *
 * ENG :
 * Generates the pixels of a circle
 */
void pixel_cercle(Shape * shashapepe, list * lst) {
    Cercle *p_cercle = (Cercle *) shape->ptrShape;
    int x = 0;
    int y = p_cercle->radus;
    int d = p_cercle->radus - 1;
    Pixel *px;

    while (y >= x) {
        px = create_pixel(p_cercle->center->pos_x + x,
                          p_cercle->center->pos_y + y, shape->color);
        lst_insert_tail(lst, lst_create_lnode(px));
        px = create_pixel(p_cercle->center->pos_x + y,
                          p_cercle->center->pos_y + x, shape->color);
        lst_insert_tail(lst, lst_create_lnode(px));

        px = create_pixel(p_cercle->center->pos_x - x,
                          p_cercle->center->pos_y + y, shape->color);
        lst_insert_tail(lst, lst_create_lnode(px));
        px = create_pixel(p_cercle->center->pos_x - y,
                          p_cercle->center->pos_y + x, shape->color);
        lst_insert_tail(lst, lst_create_lnode(px));

        px = create_pixel(p_cercle->center->pos_x + x,
                          p_cercle->center->pos_y - y, shape->color);
        lst_insert_tail(lst, lst_create_lnode(px));
        px = create_pixel(p_cercle->center->pos_x + y,
                          p_cercle->center->pos_y - x, shape->color);
        lst_insert_tail(lst, lst_create_lnode(px));

        px = create_pixel(p_cercle->center->pos_x - x,
                          p_cercle->center->pos_y - y, shape->color);
        lst_insert_tail(lst, lst_create_lnode(px));
        px = create_pixel(p_cercle->center->pos_x - y,
                          p_cercle->center->pos_y - x, shape->color);
        lst_insert_tail(lst, lst_create_lnode(px));

        if (d >= 2 * x) {
            d -= 2 * x + 1;
            x++;
        } else if (d < 2 * (p_cercle->radus - y)) {
            d += 2 * y - 1;
            y--;
        } else {
            d += 2 * (y - x - 1);
            y--;
            x++;
        }
    }
}
/*
 * FR :
 * Génère les pixels d’un rectangle
 *
 * ENG :
 * Generates the pixels of a rectangle
 */
void pixel_rectangle(Shape * shape, list * lst) {
    Rectangle *p_rec = (Rectangle *) shape->ptrShape;
    draw_segment(p_rec->p1->pos_x, p_rec->p1->pos_y, 0, p_rec->width - 1,
                 shape->color, lst);
    draw_segment(p_rec->p1->pos_x, p_rec->p1->pos_y, p_rec->height - 1, 0,
                 shape->color, lst);
    draw_segment(p_rec->p1->pos_x, p_rec->p1->pos_y + p_rec->width - 1,
                 p_rec->height - 1, 0, shape->color, lst);
    draw_segment(p_rec->p1->pos_x + p_rec->height - 1, p_rec->p1->pos_y, 0,
                 p_rec->width - 1, shape->color, lst);

}
/*
 * FR :
 * Génère les pixels d’un carré
 *
 * ENG :
 * Generates the pixels of a square
 */
void pixel_square(Shape * shape, list * lst) {
    Squar *p_sqaure = (Squar *) shape->ptrShape;
    draw_segment(p_sqaure->p1->pos_x, p_sqaure->p1->pos_y,
                 p_sqaure->length - 1, 0, shape->color, lst);
    draw_segment(p_sqaure->p1->pos_x, p_sqaure->p1->pos_y, 0,
                 p_sqaure->length - 1, shape->color, lst);
    draw_segment(p_sqaure->p1->pos_x,
                 p_sqaure->p1->pos_y + p_sqaure->length - 1,
                 p_sqaure->length - 1, 0, shape->color, lst);
    draw_segment(p_sqaure->p1->pos_x + p_sqaure->length - 1,
                 p_sqaure->p1->pos_y, 0, p_sqaure->length - 1,
                 shape->color, lst);
}
/*
 * FR :
 * Génère les pixels d’un polygone
 *
 * ENG :
 * Generates the pixels of a polygon
 */
void pixel_polygon(Shape * shape, list * lst) {

    Polygon *poly = (Polygon *) shape->ptrShape;
    int i;
    for (i = 1; i < poly->n; i++) {
        Point *p1 = poly->points[i - 1];
        Point *p2 = poly->points[i];
        int dx, dy, x, y;
        x = p1->pos_x;
        y = p1->pos_y;
        dx = p2->pos_x - p1->pos_x;0
        dy = p2->pos_y - p1->pos_y;
        draw_segment(x, y, dx, dy, shape->color, lst);
    }
}


Point calc_point_median(Point * p1, Point * p2, double t) {
    double x = p1->pos_x * (1 - t) + p2->pos_x * t;
    double y = p1->pos_y * (1 - t) + p2->pos_y * t;
    Point result = { x, y };
    return result;
}

// calc courbe de Bezier avec  Casteljau
Point cj_calc(Point ** points, int num_pt, double t) {
    Point tmp_pt[num_pt];
    for (int i = 0; i < num_pt; ++i) {
        tmp_pt[i] = *points[i];
    }
    for (int i = num_pt - 1; i > 0; --i) {
        for (int j = 0; j < i; ++j) {
            tmp_pt[j] = calc_point_median(&tmp_pt[j], &tmp_pt[j + 1], t);
        }
    }
    return tmp_pt[0];
}

/*
 * FR :
 * Génère les pixels d’une courbe
 *
 * ENG :
 * Generates the pixels of a curve
 */
void pixel_curve(Shape * shape, list * lst) {
    Curve *p_curve = (Curve *) shape->ptrShape;
    Point *points[] =
        { p_curve->p1, p_curve->p2, p_curve->p3, p_curve->p4 };
    int num_pt = sizeof(points) / sizeof(Point);
    double t = 0;

    for (t = 0; t < 1.0; t = t + 0.0001) {
        Point cjp1 = cj_calc(points, num_pt, t);
        Pixel *px = create_pixel(cjp1.pos_x, cjp1.pos_y, shape->color);
        lst_insert_tail(lst, lst_create_lnode(px));
    }
}
