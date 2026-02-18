
import java.util.*;


/**
 * Class Curve
 */
public class Curve extends Shape {

    //
    // Fields
    //

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    
    //
    // Constructors
    //
    public Curve () {
        super(0);
     };
    public Curve (Point p1, Point p2, Point p3, Point p4) {
        super(0);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
     };

    public Curve(int id, Point p1, Point p2, Point p3, Point p4) {
        super(id);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
     }
     
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

    /**
     * Set the value of p3
     * @param newVar the new value of p3
     */
    public void setP3 (Point newVar) {
        p3 = newVar;
    }

    /**
     * Get the value of p3
     * @return the value of p3
     */
    public Point getP3 () {
        return p3;
    }

    /**
     * Set the value of p4
     * @param newVar the new value of p4
     */
    public void setP4 (Point newVar) {
        p4 = newVar;
    }

    /**
     * Get the value of p4
     * @return the value of p4
     */
    public Point getP4 () {
        return p4;
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
