
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
    public void draw(char[][] canvas) {
        if (p1 == null || lenght <= 0 || canvas == null) {
            return;
        }
        
        int x = p1.getPos_x();
        int y = p1.getPos_y();
        
        for (int i = 0; i < lenght && y + i < canvas.length; i++) {
            for (int j = 0; j < lenght && x + j < canvas[0].length; j++) {
                canvas[y + i][x + j] = '#';
            }
        }
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
