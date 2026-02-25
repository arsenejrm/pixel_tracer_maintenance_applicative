
import java.util.*;


/**
 * La classe Line permet de définir une ligne à partir de deux Point.
 * Elément important de la classe Shape, il compose Polygon, Rectangle et Square.
 */
public class Line extends Shape {

    /**
     * Le Point duquel part l'objet Line
     */
    private Point p1;
    /**
     * Le Point auquel arrive l'objet Line
     */
    private Point p2;
    

    /**
     * Ce constructeur permet de définir une Line à partir de deux Point
     * @param p1 Le Point duquel part l'objet Line
     * @param p2 Le Point auquel arrive l'objet Line
     */
    public Line(Point p1, Point p2) {
        super(0);
        this.p1 = p1;
        this.p2 = p2;
    }


    /**
     * Cette implémentation de la méthode draw() renvoie une liste de Pixel correspondant
     * aux deux Point de départ et d'arrivée de l'objet Line ainsi que 
     * la totalité des Point situés entre ces deux Point, pour dessiner l'objet Line
     */
    @Override
    public ArrayList<Pixel> draw(char drawn_char) {

        ArrayList<Pixel> pixels = new ArrayList<>();

        if (this.p1 == null || this.p2 == null) {
            return pixels;
        }

        int x1 = p1.getPos_x();
        int y1 = p1.getPos_y();
        int x2 = p2.getPos_x();
        int y2 = p2.getPos_y();

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        int err = dx - dy;

        while (true) {
            pixels.add(new Pixel(x1, y1, drawn_char));

            if (x1 == x2 && y1 == y2) {
                break;
            }

            int e2 = 2 * err;

            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }

            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }

        return pixels;
    }

    /**
     * Cette implémentation de la méthode translate() permet de déplacer les deux Point
     * de cet objet de façon à le déplacer d'une distance définie par les deux paramètres
     * delta d'abscisse et d'ordonnée, qu'ils soient positifs ou négatifs
     */
    @Override
    public void translate(int deltaX, int deltaY) {
        p1.setPos_x(p1.getPos_x() + deltaX);
        p1.setPos_y(p1.getPos_y() + deltaY);
        p2.setPos_x(p2.getPos_x() + deltaX);
        p2.setPos_y(p2.getPos_y() + deltaY);
        
    }

    public void rotate(double angle) {
        // TODO implement here
    }   
    
    public void changeColor(String color) {
        // TODO implement here
    }

    public void resize(double factor) {
        // TODO implement here
    }


    /**
     * Set the value of p1
     * @param newVar the new value of p1
     */
    public void setP1 (Point newVar) {
        p1 = newVar;
    }

    /**
     * Get the value of p1
     * @return the value of p1
     */
    public Point getP1 () {
        return p1;
    }

    /**
     * Set the value of p2
     * @param newVar the new value of p2
     */
    public void setP2 (Point newVar) {
        p2 = newVar;
    }

    /**
     * Get the value of p2
     * @return the value of p2
     */
    public Point getP2 () {
        return p2;
    }


    /**
     * Renvoie la classe de la Line et les coordonnées de ses points pour la commande list
     */
    @Override
    public String toString()
    {
        return super.toString() + " LINE " + this.p1.getPos_x() + " " + this.p1.getPos_y() + " " + this.p2.getPos_x() + " " + this.p2.getPos_y();
    }


}
