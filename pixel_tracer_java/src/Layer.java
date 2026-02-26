import java.util.ArrayList;
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
    private ArrayList<Shape> list_shapes;
    private Character drawn_char = '@';

    
    //
    // Constructors
    //
    public Layer () {
        this.id = UUID.randomUUID();
        this.name = "Layer 1";
        this.visible = true;
        this.list_shapes = new ArrayList<>();
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
     * Récupérer une forme par son id
     * @return the value of shape_by_id
     * @param id
     */
    public Shape getShapeById(String id) {
        for (Shape shape : this.list_shapes) {
            if (shape.getId().toString().equals(id)) {
                return shape;
            }
        }
    return null;
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
     * Get the value of list_shapes
     * @return the value of list_shapes
     */
    public ArrayList<Shape> getList_shapes () {
        return list_shapes;
    }

    /**
     * Set the value of visible
     * @param newVar the new value of visible
     */
    public void setDrawn_char (char par_drawn_char) {
        this.drawn_char = par_drawn_char;
    }

    /**
     * Get the value of visible
     * @return the value of visible
     */
    public Character getDrawn_char () {
        return this.drawn_char;
    }

    //
    // Other methods
    //

    /**
     * toString
     */
    @Override
    public String toString()
    {
        return this.id + " " + ((this.visible) ? "(V)" : "(H)") + " " + this.name;
    }


    /**
     * met la visibilité du layer sur visible ou non
     * @param        visible
     */
    public void set_visibility(Boolean visible)
    {
    }


    /**
     * ajoute une forme dans le layer
     * @param        shape
     */
    public void add_shape_to_layer(Shape shape)
    {
        this.list_shapes.add(shape);   
    }


    /**
     * supprime une forme du layer
     * @param        id
     */
    public void remove_shape_from_layer(UUID id)
    {
        for (Shape shape : this.list_shapes) {
            if (shape.getId() == id) {
                this.list_shapes.remove(shape);
            }
        }
    }

    /** 
    public ArrayList<Pixel> pixel_layer() {
        ArrayList<Pixel> pixels_layer_list = new ArrayList<>();
        for (Shape shape : this.list_shapes) {
            if (shape instanceof Point point) {
                pixels_layer_list.add(pixel_point(point));
            } else if (shape instanceof Line line) {
                pixels_layer_list.addAll(pixel_line(line));
            } else if (shape instanceof Circle circle) {
                pixels_layer_list.addAll(pixel_circle(circle));
            } else if (shape instanceof Rectangle rectangle) {
                pixels_layer_list.addAll(pixel_rectangle(rectangle));
            } else if (shape instanceof Square square) {
                pixels_layer_list.addAll(pixel_square(square));
            } else if (shape instanceof Polygon polygon) {
                pixels_layer_list.addAll(pixel_polygon(polygon));
            } else if (shape instanceof Curve curve) {
                pixels_layer_list.addAll(pixel_curve(curve));
            }
        }
        return pixels_layer_list;
    }
    */

    
    /**
     * dessine le layer
     * @return        ArrayList<Pixel>
     * */
    public ArrayList<Pixel> draw() {

        ArrayList<Pixel> pixels = new ArrayList<>();

        if (!this.visible) {
            return null;
        }

        for (Shape shape : list_shapes) {
            pixels.addAll(shape.draw(this.drawn_char));
        }

        return pixels;
    }

}
