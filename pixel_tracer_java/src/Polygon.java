
import java.util.*;


/**
 * Class Polygon
 */
public class Polygon extends Shape {

    //
    // Fields
    //

    private int n;
    
    //
    // Constructors
    //
    public Polygon () {
        super(0);
     };
    
    //
    // Methods
    //

     @Override
     public void draw(char[][] canvas) {
         // Draw the rectangle on the canvas
         if (p1 == null) return;
         
         int x = p1.getPos_x();
         int y = p1.getPos_y();
         
         for (int i = y; i < y + height && i < canvas.length; i++) {
             for (int j = x; j < x + width && j < canvas[i].length; j++) {
                 canvas[i][j] = '*';
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

     public void addPoint(Point p) {
        // TODO implement here
    }
    public void removePoint(Point p) {
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
    

    //
    // Accessor methods
    //

    /**
     * Set the value of n
     * @param newVar the new value of n
     */
    public void setN (int newVar) {
        n = newVar;
    }

    /**
     * Get the value of n
     * @return the value of n
     */
    public int getN () {
        return n;
    }

    //
    // Other methods
    //

    /**
     */
    public String toString()
    {
        return "Polygon{" +
                "n=" + n +
                '}';
    }


}
