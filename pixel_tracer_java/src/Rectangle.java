
import java.util.*;


/**
 * Class Rectangle
 */
public class Rectangle extends Shape {

    //
    // Fields
    //

    private int height;
    private int width;
    private Point p1;
    
    //
    // Constructors
    //
    public Rectangle () {
        super(0);
     };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of height
     * @param newVar the new value of height
     */
    public void setHeight (int newVar) {
        height = newVar;
    }

    /**
     * Get the value of height
     * @return the value of height
     */
    public int getHeight () {
        return height;
    }

    /**
     * Set the value of width
     * @param newVar the new value of width
     */
    public void setWidth (int newVar) {
        width = newVar;
    }

    /**
     * Get the value of width
     * @return the value of width
     */
    public int getWidth () {
        return width;
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
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                ", p1=" + p1 +
                '}';
    }


}
