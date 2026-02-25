
import java.util.*;


/**
 * La classe Circle dessine un cercle à partir d'un Point qui représente le centre et d'un rayon du cercle
 */
public class Circle extends Shape implements Fillable {

    /**
     * Le rayon du Circle
     */
    private int radius;
    /**
     * Le Point  représentant le centre du Circle
     */
    private Point center;
    private char fillChar = ' ';
    

    /**
     * Ce constructeur permet de définir un Circle à partir d'un Point représentant le centre et le rayon
     */
    public Circle(int radius, Point center) {
        super(0);
        this.radius = radius;
        this.center = center;
    };


    /**
     * Cette implémentation de la méthode draw() renvoie tous les Pixel correspondant au dessin du Circle
     */
    @Override
    public ArrayList<Pixel> draw(char drawn_char) {
                int x = 0;
        int y = this.getRadius();
        int d = this.getRadius() - 1;
        ArrayList<Pixel> pixels_list = new ArrayList<>();

        while (y >= x) {
            pixels_list.add(new Pixel(this.getCenter().getPos_x() + x, this.getCenter().getPos_y() + y, drawn_char));
            pixels_list.add(new Pixel(this.getCenter().getPos_x() + y, this.getCenter().getPos_y() + x, drawn_char));

            pixels_list.add(new Pixel(this.getCenter().getPos_x() - x, this.getCenter().getPos_y() + y, drawn_char));
            pixels_list.add(new Pixel(this.getCenter().getPos_x() - y, this.getCenter().getPos_y() + x, drawn_char));

            pixels_list.add(new Pixel(this.getCenter().getPos_x() + x, this.getCenter().getPos_y() - y, drawn_char));
            pixels_list.add(new Pixel(this.getCenter().getPos_x() + y, this.getCenter().getPos_y() - x, drawn_char));

            pixels_list.add(new Pixel(this.getCenter().getPos_x() - x, this.getCenter().getPos_y() - y, drawn_char));
            pixels_list.add(new Pixel(this.getCenter().getPos_x() - y, this.getCenter().getPos_y() - x, drawn_char));

            if (d >= 2 * x) {
                d -= 2 * x + 1;
                x++;
            } else if (d < 2 * (this.getRadius() - y)) {
                d += 2 * y - 1;
                y--;
            } else {
                d += 2 * (y - x - 1);
                y--;
                x++;
            }
        }
            if (fillChar != ' ') {
                int cx = this.getCenter().getPos_x();
                int cy = this.getCenter().getPos_y();
                int r = this.getRadius();

                for (int i = cx - r; i <= cx + r; i++) {
                    for (int j = cy - r; j <= cy + r; j++) {

                        int dx = i - cx;
                        int dy = j - cy;

                        if (dx * dx + dy * dy <= r * r) {

                            boolean isContour = false;

                            for (Pixel p : pixels_list) {
                                if (p.getX() == i && p.getY() == j) {
                                    isContour = true;
                                    break;
                                }
                            }

                            if (!isContour) {
                                pixels_list.add(new Pixel(i, j, fillChar));
                            }
                        }
                    }
                }
            }
        return pixels_list;
    }

    /**
     * Cette implémentation de la classe translate() permet de déplacer le Point du centre du Circle
     * selon les paramètres delta des abscisses et ordonnées, qu'ils soient positifs ou négatifs
     */
    @Override  
    public void translate(int deltaX, int deltaY) {
        this.center.setPos_x(this.center.getPos_x() + deltaX);
        this.center.setPos_y(this.center.getPos_y() + deltaY);
    }


        @Override
    public void setFillChar(char c) {
        this.fillChar = c;
    }

    @Override
    public char getFillChar() {
        return fillChar;
    }


    /**
     * Scales the circle by the given factor.
     * @param factor The factor to scale by.
     */


    public void changeColor(String color) {
        // TODO implement here
    }

    public void resize(double factor) {
        // TODO implement here
    }


    /**
     * Set the value of radius
     * @param newVar the new value of radius
     */
    public void setRadius (int newVar) {
        radius = newVar;
    }

    /**
     * Get the value of radius
     * @return the value of radius
     */
    public int getRadius () {
        return radius;
    }

    /**
     * Set the value of center
     * @param newVar the new value of center
     */
    public void setCenter (Point newVar) {
        center = newVar;
    }

    /**
     * Get the value of center
     * @return the value of center
     */
    public Point getCenter () {
        return center;
    }


    /**
     * Renvoie la classe ainsi que le Point et les paramètres correspondants pour la commande list
     */
    @Override
    public String toString()
    {
        return super.toString() + " CIRCLE " + this.center.getPos_x() + " " + this.center.getPos_y() + " " + this.radius;
    }


}
