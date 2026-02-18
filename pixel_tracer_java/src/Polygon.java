
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

     public void draw(char[][] canvas) {
        // TODO implement here
    }

    public void translate(int x, int y) {
        // TODO implement here
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
