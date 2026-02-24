
import java.util.*;


/**
 * Class Point
 */
public class Point extends Shape {

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

    @Override
    public ArrayList<Pixel> draw(char drawn_char) {
        return new ArrayList<>(Arrays.asList(new Pixel(this.getPos_x(), this.getPos_y(), drawn_char)));
    }

    @Override
    public void translate(UUID id, int deltaX, int deltaY) {
        this.pos_x += deltaX;
        this.pos_y += deltaY;
    }
    
    public void changeColor(String color) {
        // TODO implement here
    }

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

    /**
     */
    @Override
    public String toString()
    {
        return super.toString() + " POINT " + this.pos_x + " " + this.pos_y;
    }


}
