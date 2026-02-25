
import java.util.*;


/**
 * La classe Square permet de définir un carré à partir d'un point et d'une longueur de côté.
 */
public class Square extends Shape {

    /**
     * La longueur du côté du Square
     */
    private int lenght;
    /**
     * le Point en haut à gauche du Square
     */
    private Point p1;
    

    /**
     * Ce constructeur permet de définir un Square à partir d'un Point et de la longueur de ses côtés.
     * @param lenght La longueur des côtés du Square
     * @param p1 Le Point en haut à gauche du Square
     */
    public Square (int lenght, Point p1) {
        super(0);
        this.lenght = lenght;
        this.p1 = p1;
    };
     

    /**
     * Cette implémentation de la méthode draw() renvoie les Pixel des Line qui forment le Square
     */
    @Override
    public ArrayList<Pixel> draw(char drawn_char) {

        ArrayList<Pixel> pixels = new ArrayList<>();

        if (p1 == null || lenght <= 0) {
            return pixels;
        }

        int x = p1.getPos_x();
        int y = p1.getPos_y();

        Point topLeft = new Point(x, y);
        Point topRight = new Point(x + lenght - 1, y);
        Point bottomLeft = new Point(x, y + lenght - 1);
        Point bottomRight = new Point(x + lenght - 1, y + lenght - 1);

        Line top = new Line(topLeft, topRight);
        Line right = new Line(topRight, bottomRight);
        Line bottom = new Line(bottomRight, bottomLeft);
        Line left = new Line(bottomLeft, topLeft);

        pixels.addAll(top.draw(drawn_char));
        pixels.addAll(right.draw(drawn_char));
        pixels.addAll(bottom.draw(drawn_char));
        pixels.addAll(left.draw(drawn_char));

        // Si on veut un carré rempli (à finir d'implementer)
        if (getFill()) {
            for (int i = y + 1; i < y + lenght - 1; i++) {
                Line fillLine = new Line(
                        new Point(x + 1, i),
                        new Point(x + lenght - 2, i)
                );
                pixels.addAll(fillLine.draw(drawn_char));
            }
        }

        return pixels;
    }

    /**
     * Cette implémentation de la méthode translate() change les coordonnées du Point initial du Square
     * selon les paralètres delta des abscisses et ordonnées, qu'ils soient positif ou négatif
     */
    @Override
    public void translate(int deltaX, int deltaY) {
        p1.setPos_x(p1.getPos_x() + deltaX);
        p1.setPos_y(p1.getPos_y() + deltaY);
    }

     public void changeColor(String color) {
        // TODO implement here
    }

     public void resize(double factor) {
        // TODO implement here
    }


    /**
     * Set the value of lenght
     * @param newVar the new value of lenght
     */
    public void setLenght (int newVar) {
        lenght = newVar;
    }

    /**
     * Get the value of lenght
     * @return the value of lenght
     */
    public int getLenght () {
        return lenght;
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
     * Renvoie la classe du Square ainsi que ses coordonnées et autres paramètres pour la commande list
     */
    @Override
    public String toString()
    {
        return super.toString() + " SQUARE " + this.p1.getPos_x() + " " + this.p1.getPos_y() + " " + this.lenght;
    }


}
