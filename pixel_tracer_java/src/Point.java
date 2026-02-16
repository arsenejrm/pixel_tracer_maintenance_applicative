
import java.util.*;


/**
 * Class Point
 */
public abstract class Point extends Shape {

    //
    // Fields
    //

    private int pos_x;
    private int pos_y;

    //
    // Constructors
    //
    public Point() {
        this(0, 0);
    }

    public Point(int pos_x, int pos_y) {
        super(0); // id par défaut
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    public Point(int id, int pos_x, int pos_y) {
        super(id);
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of pos_x
     * @param newVar the new value of pos_x
     */
    public void setPos_x (int newVar) {
        pos_x = newVar;
    }

    /**
     * Get the value of pos_x
     * @return the value of pos_x
     */
    public int getPos_x () {
        return pos_x;
    }

    /**
     * Set the value of pos_y
     * @param newVar the new value of pos_y
     */
    public void setPos_y (int newVar) {
        pos_y = newVar;
    }

    /**
     * Get the value of pos_y
     * @return the value of pos_y
     */
    public int getPos_y () {
        return pos_y;
    }

    //
    // Other methods
    //
    // Déplacement
    public void translate(int dx, int dy) {
        this.pos_x += dx;
        this.pos_y += dy;
    }

    // Distance entre deux points
    public double distance(Point other) {
        int dx = other.pos_x - this.pos_x;
        int dy = other.pos_y - this.pos_y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     */
    @Override
    public String toString()
    {
        return "(" + this.pos_x + this.pos_y + ")";
    }


}
