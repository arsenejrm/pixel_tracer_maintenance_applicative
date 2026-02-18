import java.util.ArrayList;

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

    public String command_interpreter(String user_input) {
        String[] splitted_input = user_input.split(" ");
        String command_name = splitted_input[0];
        ArrayList<String> command_params = new ArrayList<>();
        for (int i = 1; i < splitted_input.length; i++) {
            command_params.add(splitted_input[i]);
        }
        String error_param = "erreur paramètres, consulter la commande help";

        if (command_name.equals("help")) {
            if (!command_params.isEmpty()) {
                return error_param;
            }
            return  "        **************************************************\r\n" + //
                    "        ****         VECTOR TEXT-BASED EDITOR         ****\r\n" + //
                    "        **************************************************\r\n" + //
                    "        ==== Control ====\r\n" + //
                    "        plot : draw dcreen\r\n" + //
                    "        clear : clear screen\r\n" + //
                    "        exit : quitter le programme\r\n" + //
                    "        ==== Draw shapes ====\r\n" + //
                    "        point px py : create point a position (px, px)\r\n" + //
                    "        line x1 y1 x2 x2 : draw line from (x1, y1) to (x1, y1)\r\n" + //
                    "        square x1 y1 l : draw square (x1, y1)  length\r\n" + //
                    "        rectangle x1 y1 w h : draw square (x1, y1)  width height\r\n" + //
                    "        circle x y r : center at (x, y) radus r\r\n" + //
                    "        polygon x1 y1 x2 y2 ... : draw polygon\r\n" + //
                    "        curve x1 y1 x2 y2 x3 y3 x4 y4 : draw Bezier curve\r\n" + //
                    "        ==== Draw manager ====\r\n" + //
                    "        list {layers, arias, shapes}\r\n" + //
                    "        select {aria, layer} {id}\r\n" + //
                    "        delete {aria, layer, shape} {id}\r\n" + //
                    "        new {aria, layer}\r\n" + //
                    "        ==== Set ====\r\n" + //
                    "        set char {border, background} ascii_code\r\n" + //
                    "        set layer {visible, unvisible} {id}";
        } else if (command_name.equals("plot")) {
            return "Bam t'as l'affichage (c'est faux)";
        } else if (command_name.equals("clear")) {
            return "Bam tout l'affichage dégage (c'est faux)";
        } else if (command_name.equals("exit")) {
            return "Bam fin de programme (c'est faux)";
        }
        return "command = " + command_name + 
            "Commande inconnue. Tapez 'help' pour voir les commandes disponibles.";
    }
}
