

/**
 * Class Area
 */
public class Area {

    //
    // Fields
    //

    private Integer id;
    private String name;
    private Integer width;
    private Integer height;
    private Layer list_layers;
    private Character empty_char;
    private Character full_char;
    
    //
    // Constructors
    //
    public Area () { };
    
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
    public void setId (Integer newVar) {
        id = newVar;
    }

    /**
     * Get the value of id
     * @return the value of id
     */
    public Integer getId () {
        return id;
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
     * Set the value of width
     * @param newVar the new value of width
     */
    public void setWidth (Integer newVar) {
        width = newVar;
    }

    /**
     * Get the value of width
     * @return the value of width
     */
    public Integer getWidth () {
        return width;
    }

    /**
     * Set the value of height
     * @param newVar the new value of height
     */
    public void setHeight (Integer newVar) {
        height = newVar;
    }

    /**
     * Get the value of height
     * @return the value of height
     */
    public Integer getHeight () {
        return height;
    }

    /**
     * Set the value of list_layers
     * @param newVar the new value of list_layers
     */
    public void setList_layers (Layer newVar) {
        list_layers = newVar;
    }

    /**
     * Get the value of list_layers
     * @return the value of list_layers
     */
    public Layer getList_layers () {
        return list_layers;
    }

    /**
     * Set the value of empty_char
     * @param newVar the new value of empty_char
     */
    public void setEmpty_char (Character newVar) {
        empty_char = newVar;
    }

    /**
     * Get the value of empty_char
     * @return the value of empty_char
     */
    public Character getEmpty_char () {
        return empty_char;
    }

    /**
     * Set the value of full_char
     * @param newVar the new value of full_char
     */
    public void setFull_char (Character newVar) {
        full_char = newVar;
    }

    /**
     * Get the value of full_char
     * @return the value of full_char
     */
    public Character getFull_char () {
        return full_char;
    }

    //
    // Other methods
    //

    /**
     */
    public void toString()
    {
    }


    /**
     * @return       Area
     * @param        width
     * @param        height
     * @param        id
     * @param        name
     */
    public Area Area(Integer width, Integer height, Integer id, String name)
    {
    }


    /**
     */
    public void clear()
    {
    }


    /**
     * @param        layer
     */
    public void add_layer(Layer layer)
    {
    }


    /**
     * @param        layer_id
     */
    public void remove_layer(Integer layer_id)
    {
    }


    /**
     */
    public void draw_area()
    {
    }


    /**
     * @param        layer_id
     */
    public void draw_layer(Integer layer_id)
    {
    }


}
