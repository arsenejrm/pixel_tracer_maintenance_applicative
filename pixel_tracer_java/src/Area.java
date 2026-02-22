import java.util.UUID;
import java.util.ArrayList;

/**
 * Class Area
 */
public class Area {

    private UUID id;
    private String name;
    private Integer width;
    private Integer height;
    private ArrayList<Layer> list_layers;
    private Character empty_char;
    private Character full_char;
    

    public Area (int par_width, int par_height, UUID par_id, String par_name) {
        this.width = par_width;
        this.height = par_height;
        this.list_layers = new ArrayList<>();
        this.id = par_id;
        this.empty_char = '.';
        this.full_char = '@';
    };
    

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
    public void setName (String par_name) {
        this.name = par_name;
    }

    /**
     * Get the value of name
     * @return the value of name
     */
    public String getName () {
        return this.name;
    }

    /**
     * Set the value of width
     * @param newVar the new value of width
     */
    public void setWidth (Integer par_width) {
        this.width = par_width;
    }

    /**
     * Get the value of width
     * @return the value of width
     */
    public Integer getWidth () {
        return this.width;
    }

    /**
     * Set the value of height
     * @param newVar the new value of height
     */
    public void setHeight (Integer par_height) {
        this.height = par_height;
    }

    /**
     * Get the value of height
     * @return the value of height
     */
    public Integer getHeight () {
        return this.height;
    }

    /**
     * Get the value of list_layers
     * @return the value of list_layers
     */
    public ArrayList<Layer> getList_layers () {
        return this.list_layers;
    }

    /**
     * Set the value of empty_char
     * @param newVar the new value of empty_char
     */
    public void setEmpty_char (Character par_empty_char) {
        this.empty_char = par_empty_char;
    }

    /**
     * Get the value of empty_char
     * @return the value of empty_char
     */
    public Character getEmpty_char () {
        return this.empty_char;
    }

    /**
     * Set the value of full_char
     * @param newVar the new value of full_char
     */
    public void setFull_char (Character par_full_char) {
        this.full_char = par_full_char;
    }

    /**
     * Get the value of full_char
     * @return the value of full_char
     */
    public Character getFull_char () {
        return this.full_char;
    }

    //
    // Other methods
    //

    /**
     */
    public String toString()
    {
        return "";
    }


    /**
     * @param        layer
     */
    public void add_layer(Layer layer){
        this.list_layers = layer;
    }


    /**
     * @param        layer_id
     */
    public void remove_layer(Integer layer_id)
    {
        if (this.list_layers.getId() == layer_id) {
            this.list_layers = null;
        }
    }


    /**
     */
    public void draw_area(){
        if (this.list_layers != null) {
            this.list_layers.draw_layer();
        }
    }
}
