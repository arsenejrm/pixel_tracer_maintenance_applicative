import java.util.UUID;

/**
 * Class Layer
 */
public class Layer {

    //
    // Fields
    //

    private UUID id;
    private String name;
    private Boolean visible;
    private Shape list_shapes;

    
    //
    // Constructors
    //
    public Layer () {
        
     };
    
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
    public void setId (UUID par_id) {
        this.id = par_id;
    }

    /**
     * Get the value of id
     * @return the value of id
     */
    public UUID getId () {
        return this.id;
    }

    /**
     * Set the value of name
     * @param newVar the new value of name
     */
    public void setName (String newVar) {
        name = newVar;
    }

    /**
     * Get the value of name
     * @return the value of name
     */
    public String getName () {
        return name;
    }

    /**
     * Set the value of visible
     * @param newVar the new value of visible
     */
    public void setVisible (Boolean newVar) {
        visible = newVar;
    }

    /**
     * Get the value of visible
     * @return the value of visible
     */
    public Boolean getVisible () {
        return visible;
    }

    /**
     * Set the value of list_shapes
     * @param newVar the new value of list_shapes
     */
    public void setList_shapes (Shape newVar) {
        list_shapes = newVar;
    }

    /**
     * Get the value of list_shapes
     * @return the value of list_shapes
     */
    public Shape getList_shapes () {
        return list_shapes;
    }

    //
    // Other methods
    //

    /**
     */
    public String toString()
    {
        return "Layer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", visible=" + visible +
                ", list_shapes=" + list_shapes +
                '}';
    }


    /**
     * @return       Layer
     * @param        id
     * @param        name
     */
    public Layer Layer(Integer id, String name)
    {
        return new Layer();
    }


    /**
     * @param        visible
     */
    public void set_visibility(Boolean visible)
    {
    }


    /**
     * @param        shape
     */
    public void add_shape_to_layer(Shape shape)
    {
        this.list_shapes = shape;   
    }


    /**
     * @param        id
     */
    public void remove_shape_from_layer(Integer id)
    {
        if (this.list_shapes.getId() == id) {
            this.list_shapes = null;
        }
    }


}
