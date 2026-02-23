import java.util.ArrayList;
import java.util.UUID;

/**
 * Class Shape
 */
public abstract class Shape {

    //
    // Fields
    //

    private UUID id;
    private boolean fill;
    private int thickness;
    private double rotation;
    
    //
    // Constructors
    //
    public Shape(int id) {
        this.id = UUID.randomUUID();
        this.fill = false;
        this.thickness = 1;
        this.rotation = 0.0;
    }
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of id
     * @param newVar the new value of id
     */
    public void setId (UUID newVar) {
        id = newVar;
    }

    /**
     * Get the value of id
     * @return the value of id
     */
    public UUID getId () {
        return id;
    }

    /**
     * Set the value of fill
     * @param newVar the new value of fill
     */
    public void setFill (boolean newVar) {
        fill = newVar;
    }

    /**
     * Get the value of fill
     * @return the value of fill
     */
    public boolean getFill () {
        return fill;
    }

    /**
     * Set the value of thickness
     * @param newVar the new value of thickness
     */
    public void setThickness (int newVar) {
        thickness = newVar;
    }

    /**
     * Get the value of thickness
     * @return the value of thickness
     */
    public int getThickness () {
        return thickness;
    }

    /**
     * Set the value of rotation
     * @param newVar the new value of rotation
     */
    public void setRotation (double newVar) {
        rotation = newVar;
    }

    /**
     * Get the value of rotation
     * @return the value of rotation
     */
    public double getRotation () {
        return rotation;
    }

    //
    // Other methods
    //


    // Dessine la forme dans la grille
    // Draw the shape in the grid
    public abstract ArrayList<Pixel> draw(char drawn_char);


    /**
     */
    @Override
    public String toString() {
        return this.id.toString();
    }


}
