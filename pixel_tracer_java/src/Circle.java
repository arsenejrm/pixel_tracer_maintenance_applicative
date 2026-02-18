
import java.util.*;


/**
 * Class Circle
 */
public class Circle extends Shape {

    //
    // Fields
    //

    private int radius;
    private Point center;
    
    //
    // Constructors
    //
    public Circle () {
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


    public void scale(double factor) {
        // TODO implement here
    }   

    public void changeColor(String color) {
        // TODO implement here
    }

    public void resize(double factor) {
        // TODO implement here
    }

     public boolean isCircle() {
        return true;
    }


    //
    // Accessor methods
    //

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

    //
    // Other methods
    //

    /**
     */
    public String toString()
    {
        return "Circle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }


}
