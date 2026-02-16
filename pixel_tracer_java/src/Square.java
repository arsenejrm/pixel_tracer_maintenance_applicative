
import java.util.*;


/**
 * Class Square
 */
public class Square extends Shape, Shape, Shape {

    //
    // Fields
    //

    private int lenght;
    private Point p1;
    
    //
    // Constructors
    //
    public Square () { };
    
    //
    // Methods
    //


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
    public void toString()
    {
    }


}
