import java.util.ArrayList;

/**
 * Class Rectangle
 */
public class Rectangle extends Shape {

    /**
     * La valeur e hauteur du Rectangle
     */
    private int height;
    /**
     * La valeur de longueur du Rectangle
     */
    private int width;
    /**
     * Le Point en haut à gauche du Rectangle
     */
    private Point p1;
    
    
    /**
     * Ce constructeur permet de définir un Rectangle à partir du Point en haut à gauche, de sa hauteur et de sa largeur
     * @param height La hauteur du Rectangle
     * @param width La longueur du Rectangle
     * @param p1 le Point en haut à gauche du Rectangle
     */
    public Rectangle (int height, int width, Point p1) {
        super(0);
        this.height = height;
        this.width = width;
        this.p1 = p1;
    };


    /**
     * Cette implémentation de la méthode draw() renvoie la liste des Pixel dessinant le Rectangle
     */
    @Override
    public ArrayList<Pixel> draw(char drawn_char) {

        ArrayList<Pixel> pixels = new ArrayList<>();

        if (p1 == null || width <= 0 || height <= 0) {
            return pixels;
        }

        int x = p1.getPos_x();
        int y = p1.getPos_y();

        // Coins
        Point topLeft = new Point(x, y);
        Point topRight = new Point(x + width - 1, y);
        Point bottomLeft = new Point(x, y + height - 1);
        Point bottomRight = new Point(x + width - 1, y + height - 1);

        // 4 côtés via Line
        Line top = new Line(topLeft, topRight);
        Line right = new Line(topRight, bottomRight);
        Line bottom = new Line(bottomRight, bottomLeft);
        Line left = new Line(bottomLeft, topLeft);

        pixels.addAll(top.draw(drawn_char));
        pixels.addAll(right.draw(drawn_char));
        pixels.addAll(bottom.draw(drawn_char));
        pixels.addAll(left.draw(drawn_char));

        // Remplissage si activé
        if (getFill()) {
            for (int i = y + 1; i < y + height - 1; i++) {
                Line fillLine = new Line(
                        new Point(x + 1, i),
                        new Point(x + width - 2, i)
                );
                pixels.addAll(fillLine.draw(drawn_char));
            }
        }

        return pixels;
    }

    /**
     * Cette implémentation de la méthode translate() déplace le Point du Rectangle 
     * selon les paramètres delta des abscisses et des ordonnées, qu'ils soient positifs ou négatifs
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
        height = (int)(height * factor);
        width = (int)(width * factor);
    }

    public void fill(String color) {
        // Fill logic
    }

    public void unfill() {
        // Unfill logic
    }


    /**
     * Set the value of height
     * @param newVar the new value of height
     */
    public void setHeight (int newVar) {
        this.height = newVar;
    }

    /**
     * Get the value of height
     * @return the value of height
     */
    public int getHeight () {
        return this.height;
    }

    /**
     * Set the value of width
     * @param newVar the new value of width
     */
    public void setWidth (int newVar) {
        this.width = newVar;
    }

    /**
     * Get the value of width
     * @return the value of width
     */
    public int getWidth () {
        return this.width;
    }

    /**
     * Set the value of p1
     * @param newVar the new value of p1
     */
    public void setP1 (Point newVar) {
        this.p1 = newVar;
    }

    /**
     * Get the value of p1
     * @return the value of p1
     */
    public Point getP1 () {
        return this.p1;
    }


    /**
     * Renvoie la classe ainsi que les coordonnées et paramètres de l'objet Rectangle
     */
    @Override
    public String toString()
    {
        return super.toString() + " RECTANGLE " + this.p1.getPos_x() + " " + this.p1.getPos_y() + " " + this.width + " " + this.height;
    }
}
