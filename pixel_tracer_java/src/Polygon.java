
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
