import java.util.ArrayList;
import java.util.UUID;

/**
 * Class PixelTracer
 */
public class PixelTracer {

    private final Integer width = 80;
    private final Integer height = 40;
    private ArrayList<Area> list_areas;
    private Area current_area;


    public PixelTracer (int width, int height) {
        this.list_areas = new ArrayList<>();
        this.current_area = new Area(width, height, UUID.randomUUID(), "Area1");
        this.list_areas.add(this.current_area);
    };

    /**
     * Get the value of list_areas
     * @return the value of list_areas
     */
    public ArrayList<Area> getList_areas () {
        return this.list_areas;
    }

    /**
     * Set the value of current_area
     * @param newVar the new value of current_area
     */
    public void setCurrent_area (Area par_current_area) {
        this.current_area = par_current_area;
    }

    /**
     * Get the value of current_area
     * @return the value of current_area
     */
    public Area getCurrent_area () {
        return current_area;
    }


    /**
     */
    @Override
    public String toString()
    {
        return "PixelTracer{" +
                "list_areas=" + list_areas +
                ", current_area=" + current_area +
                '}';
    }


    /**
     * @param        area
     */
    public void add_area(Area area)
    {
        this.list_areas.add(area);
    }


    /**
     * @param        id_area
     */
    public void remove_area(UUID id_area)
    {
        for (int i = 0; i < this.list_areas.size(); i++) {
            if (this.list_areas.get(i).getId().equals(id_area)) {
                this.list_areas.remove(i);
            }
        }
    }


    public String command_interpreter(String user_input) {
        String error_unknown = "commande inconnue";
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

            case "new" -> {
                if (command_params.isEmpty()) {
                    return error_param;
                } else if (command_params.get(0).equals("area")) {
                    this.current_area = new Area(this.width, this.height, UUID.randomUUID(), "area_name");
                    this.list_areas.add(this.current_area);
                }
                return "done";
            }

            case "list" -> {
                String info_list = "";
                if (command_params.isEmpty()) {
                    return error_param;
                } else if (command_params.get(0).equals("areas")) {
                    for (Area area : this.list_areas) {
                        if (area == this.current_area) {
                            info_list += " *   ";
                        } else {
                            info_list += " -   ";
                        }
                        info_list += area.toString() + "\n";
                    }
                } else {
                    return error_param;
                }
                info_list += "done";
                return info_list;
            }

            case "plot" -> {
                if (!command_params.isEmpty()) {
                    return error_param;
                }
                ArrayList<ArrayList<Character>> pixel_map = this.current_area.getPixel_map();
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
                if (!command_params.isEmpty()) {
                    return error_param;
                }
                return "clear";
            }

            case "exit" -> {
                if (!command_params.isEmpty()) {
                    return error_param;
                }
                return "exit";
            }

            default -> {
                return error_unknown;
            }
        }
    }
}
