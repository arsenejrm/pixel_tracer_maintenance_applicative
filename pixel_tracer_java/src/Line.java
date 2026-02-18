
import java.util.*;


/**
 * Class Line
 */
public class Line extends Shape {

    //
    // Fields
    //

    private Point p1;
    private Point p2;
    
    //
    // Constructors
    //
    public Line () {
        super(0);
     };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

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

    //
    // Other methods
    //

    /**
     */
    public String toString()
    {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }


}
