
import java.util.*;


/**
 * Class Square
 */
public class Square extends Shape {

    //
    // Fields
    //

    private int lenght;
    private Point p1;
    
    //
    // Constructors
    //
    public Square () {
        super(0);
     };

    public Square (int lenght, Point p1) {
        super(0);
        this.lenght = lenght;
        this.p1 = p1;
     };
    
    public Square(int id, int lenght, Point p1) {
        super(id);
        this.lenght = lenght;
        this.p1 = p1;
     }
     
    //
    // Methods
    //
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


    public void translate(int deltaX, int deltaY) {
         if (p1 != null) {
             p1.setPos_x(p1.getPos_x() + deltaX);
             p1.setPos_y(p1.getPos_y() + deltaY);
         }
     }


    public void rotate(double angle) {
        // TODO implement here
    }

     public void scale(double factor) {
        // TODO implement here
    }


     public void changeColor(String color) {
        // TODO implement here
    }



     public void resize(double factor) {
        // TODO implement here
    }

     public boolean isSquare() {
        return true;
    }

     public boolean isRectangle() {
        return false;
    }

     public boolean isCircle() {
        return false;
    }

     public boolean isPolygon() {
        return false;
    }


    //
    // Accessor methods
    //

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

    //
    // Other methods
    //

    /**
     */
    public String toString()
    {
        return "Square{" +
                "lenght=" + lenght +
                ", p1=" + p1 +
                '}';
    }


}
