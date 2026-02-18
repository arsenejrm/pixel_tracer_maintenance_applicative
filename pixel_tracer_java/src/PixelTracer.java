

/**
 * Class PixelTracer
 */
public class PixelTracer {

    //
    // Fields
    //

    private Area list_areas;
    private Area current_area;
    private Layer current_layer;
    private Shape current_shape;
    
    //
    // Constructors
    //
    public PixelTracer () {
     };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of list_areas
     * @param newVar the new value of list_areas
     */
    public void setList_areas (Area newVar) {
        list_areas = newVar;
    }

    /**
     * Get the value of list_areas
     * @return the value of list_areas
     */
    public Area getList_areas () {
        return list_areas;
    }

    /**
     * Set the value of current_area
     * @param newVar the new value of current_area
     */
    public void setCurrent_area (Area newVar) {
        current_area = newVar;
    }

    /**
     * Get the value of current_area
     * @return the value of current_area
     */
    public Area getCurrent_area () {
        return current_area;
    }

    /**
     * Set the value of current_layer
     * @param newVar the new value of current_layer
     */
    public void setCurrent_layer (Layer newVar) {
        current_layer = newVar;
    }

    /**
     * Get the value of current_layer
     * @return the value of current_layer
     */
    public Layer getCurrent_layer () {
        return current_layer;
    }

    /**
     * Set the value of current_shape
     * @param newVar the new value of current_shape
     */
    public void setCurrent_shape (Shape newVar) {
        current_shape = newVar;
    }

    /**
     * Get the value of current_shape
     * @return the value of current_shape
     */
    public Shape getCurrent_shape () {
        return current_shape;
    }

    //
    // Other methods
    //

    /**
     */
    public String toString()
    {
        return "PixelTracer{" +
                "list_areas=" + list_areas +
                ", current_area=" + current_area +
                ", current_layer=" + current_layer +
                ", current_shape=" + current_shape +
                '}';
    }


    /**
     * @param        area
     */
    public void add_area(Area area)
    {
    }


    /**
     * @param        id_area
     */
    public void remove_area(Integer id_area)
    {
    }


    /**
     * @return       PixelTracer
     */
    public PixelTracer PixelTracer()
    {
        return new PixelTracer();
    }


    /**
     */
    public void clear_screen()
    {
    }


}
