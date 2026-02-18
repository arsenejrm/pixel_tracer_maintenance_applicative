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
    private ArrayList<ArrayList<Character>> pixel_map;
    
    //
    // Constructors
    //
    public PixelTracer (int width, int height) {
        this.pixel_map = new ArrayList<>();
        Character pixel = '.';
        for (int i = 0; i < height; i++) {
            ArrayList<Character> pixel_line = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                pixel_line.add(pixel);
            }
            this.pixel_map.add(pixel_line);
        }
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
    @Override
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
     */
    public void clear_screen()
    {
    }

    public String command_interpreter(String user_input) {
        String error_empty = "commande manquante";
        String error_param = "erreur paramètres, consulter la commande help";

        String[] splitted_input = user_input.split(" ");
        if (splitted_input.length == 0) {
            return error_empty;
        }
        String command_name = splitted_input[0];
        ArrayList<String> command_params = new ArrayList<>();
        for (int i = 1; i < splitted_input.length; i++) {
            command_params.add(splitted_input[i]);
        }

        switch (command_name) {
            case "" -> {
                return error_empty;
            }
            case "help" -> {
                if (!command_params.isEmpty()) {
                    return error_param;
                }
                return  """
                    \t**************************************************\r
                    \t****         VECTOR TEXT-BASED EDITOR         ****\r
                    \t**************************************************\r
                    \t==== Control ====\r
                    \tplot : draw dcreen\r
                    \tclear : clear screen\r
                    \texit : quitter le programme\r
                    \t==== Draw shapes ====\r
                    \tpoint px py : create point a position (px, px)\r
                    \tline x1 y1 x2 x2 : draw line from (x1, y1) to (x1, y1)\r
                    \tsquare x1 y1 l : draw square (x1, y1)  length\r
                    \trectangle x1 y1 w h : draw square (x1, y1)  width height\r
                    \tcircle x y r : center at (x, y) radus r\r
                    \tpolygon x1 y1 x2 y2 ... : draw polygon\r
                    \tcurve x1 y1 x2 y2 x3 y3 x4 y4 : draw Bezier curve\r
                    \t==== Draw manager ====\r
                    \tlist {layers, arias, shapes}\r
                    \tselect {aria, layer} {id}\r
                    \tdelete {aria, layer, shape} {id}\r
                    \tnew {aria, layer}\r
                    \t==== Set ====\r
                    \tset char {border, background} ascii_code\r
                    \tset layer {visible, unvisible} {id}
                """;
            }
                        
            case "plot" -> {
                String string_map = "";

                for (int i = 0; i < pixel_map.size(); i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < pixel_map.get(i).size(); j++) {
                        sb.append(pixel_map.get(i).get(j));
                    }
                    string_map += sb + "\n";
                }
                return string_map;
            }

            case "clear" -> {
                return "clear";
            }

            case "exit" -> {
                return "exit";
            }

            default -> {
                return "command = " + command_name +
                        "Commande inconnue. Tapez 'help' pour voir les commandes disponibles.";
            }
        }
    }
}
