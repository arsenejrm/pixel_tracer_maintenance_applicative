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
        String action_completed = "done";

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
                return action_completed;
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
                info_list += action_completed;
                return info_list;
            }

            case "point" -> {
                if (command_params.isEmpty() || command_params.size() == 1) {
                    return error_param;
                } else if (command_params.size() == 2) {
                    try {
                        int px = Integer.parseInt(command_params.get(0));
                        int py = Integer.parseInt(command_params.get(1));
                        this.current_area.getCurrent_layer().add_shape_to_layer(new Point(px, py));
                        return command_interpreter("plot");
                    } catch (NumberFormatException e) {}
                } else {
                    return error_param;
                }
            }

            case "line" -> {
                if (command_params.size() == 4) {
                    try {
                        int x1 = Integer.parseInt(command_params.get(0));
                        int y1 = Integer.parseInt(command_params.get(1));
                        int x2 = Integer.parseInt(command_params.get(2));
                        int y2 = Integer.parseInt(command_params.get(3));
                        this.current_area.getCurrent_layer().add_shape_to_layer(new Line(new Point(x1, y1), new Point(x2, y2)));
                        return command_interpreter("plot");
                    } catch (NumberFormatException e) {}
                } else {
                    return error_param;
                }
            }

            case "square" -> {
                if (command_params.size() == 3) {
                    try {
                        int x1 = Integer.parseInt(command_params.get(0));
                        int y1 = Integer.parseInt(command_params.get(1));
                        int l = Integer.parseInt(command_params.get(2));
                        this.current_area.getCurrent_layer().add_shape_to_layer(new Square(l, new Point(x1, y1)));
                        return command_interpreter("plot");
                    } catch (NumberFormatException e) {}
                } else {
                    return error_param;
                }
            }

            case "rectangle" -> {
                if (command_params.size() == 4) {
                    try {
                        int x1 = Integer.parseInt(command_params.get(0));
                        int y1 = Integer.parseInt(command_params.get(1));
                        int w = Integer.parseInt(command_params.get(2));
                        int h = Integer.parseInt(command_params.get(3));
                        this.current_area.getCurrent_layer().add_shape_to_layer(new Rectangle(h, w, new Point(x1, y1)));
                        return command_interpreter("plot");
                    } catch (NumberFormatException e) {}
                } else {
                    return error_param;
                }
            }

            case "circle" -> {
                if (command_params.size() == 3) {
                    try {
                        int x = Integer.parseInt(command_params.get(0));
                        int y = Integer.parseInt(command_params.get(1));
                        int r = Integer.parseInt(command_params.get(2));
                        this.current_area.getCurrent_layer().add_shape_to_layer(new Circle(r, new Point(x, y)));
                        return command_interpreter("plot");
                    } catch (NumberFormatException e) {}
                } else {
                    return error_param;
                }
            }

            case "polygon" -> {
                if (command_params.size() > 1 && command_params.size() % 2 == 0) {
                    ArrayList<Point> points = new ArrayList<>();
                    int params_couples_counter = 0;
                    try {
                        while (params_couples_counter * 2 < command_params.size()) {
                            int xi = Integer.parseInt(command_params.get(params_couples_counter * 2));
                            int yi = Integer.parseInt(command_params.get(params_couples_counter * 2 + 1));
                            points.add(new Point(xi, yi));
                            params_couples_counter++;
                        }
                        this.current_area.getCurrent_layer().add_shape_to_layer(new Polygon(points));
                        return command_interpreter("plot");
                    } catch (NumberFormatException e) {}
                } else {
                    return error_param;
                }
            }

            case "curve" -> {
                if (command_params.size() == 8) {
                    try {
                        int x1 = Integer.parseInt(command_params.get(0));
                        int y1 = Integer.parseInt(command_params.get(1));
                        int x2 = Integer.parseInt(command_params.get(2));
                        int y2 = Integer.parseInt(command_params.get(3));
                        int x3 = Integer.parseInt(command_params.get(4));
                        int y3 = Integer.parseInt(command_params.get(5));
                        int x4 = Integer.parseInt(command_params.get(6));
                        int y4 = Integer.parseInt(command_params.get(7));
                        this.current_area.getCurrent_layer().add_shape_to_layer(new Curve(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), new Point(x4, y4)));
                        return command_interpreter("plot");
                    } catch (NumberFormatException e) {}
                } else {
                    return error_param;
                }
            }

            case "plot" -> {
                if (!command_params.isEmpty()) {
                    return error_param;
                }
                this.current_area.update_pixel_map();
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
        return "error : command inerpreter did not find any corresponding case";
    }
}
