import java.util.ArrayList;
import java.util.UUID;

/**
 * Class PixelTracer
 */
public class PixelTracer {

    private final Integer width = 80;
    private final Integer height = 50;
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
        String error_unknown = "commande inconnue\n";
        String error_empty = "commande manquante\n";
        String error_used = "L'objet référencé est en cours d'utilisation\n";
        String error_param = "erreur paramètres, consulter la commande help\n";
        String action_completed = "done\n";

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
                    \tplot : draw screen\r
                    \tclear : clear screen\r
                    \texit : quitter le programme\r
                    \t==== Draw shapes ====\r
                    \tpoint px py : create point a position (px, px)\r
                    \tline x1 y1 x2 y2 : draw line from (x1, y1) to (x2, y2)\r
                    \tsquare x1 y1 l : draw square (x1, y1)  length\r
                    \trectangle x1 y1 w h : draw square (x1, y1)  width height\r
                    \tcircle x y r : center at (x, y) radius r\r
                    \tpolygon x1 y1 x2 y2 ... : draw polygon\r
                    \tcurve x1 y1 x2 y2 x3 y3 ... : draw Bezier curve\r
                    \t==== Draw manager ====\r
                    \tlist {layers, areas, shapes}\r
                    \tselect {area, layer} {id}\r
                    \tdelete {area, layer, shape} {id}\r
                    \tnew {area, layer}\r
                    \t==== Set ====\r
                    \tset char {border, background} character : set character\r
                    \tset layer {visible, unvisible} {id}
                    \t==== Bonus ====\r
                    \ttranslate id dx dy : move shape\r
                    \tfill id char : fill shape (except line, point, curve)\r
                """;
            }

            //                     \trotate id angle : rotate shape (only for line, polygon, curve)\r

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

                // minimum 3 points (6 valeurs)
                if (command_params.size() < 6 || command_params.size() % 2 != 0) {
                    return error_param;
                }

                try {
                    ArrayList<Point> points = new ArrayList<>();

                    for (int i = 0; i < command_params.size(); i += 2) {
                        int x = Integer.parseInt(command_params.get(i));
                        int y = Integer.parseInt(command_params.get(i + 1));
                        points.add(new Point(x, y));
                    }

                    this.current_area
                        .getCurrent_layer()
                        .add_shape_to_layer(new Curve(points));

                    return command_interpreter("plot");

                } catch (NumberFormatException e) {
                    return error_param;
                }
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
                } else if (command_params.get(0).equals("layers")) {
                    for (Layer layer : this.current_area.getList_layers()) {
                        if (layer == this.current_area.getCurrent_layer()) {
                            info_list += " *   ";
                        } else {
                            info_list += " -   ";
                        }
                        info_list += layer.toString() + "\n";
                    }
                } else if (command_params.get(0).equals("shapes")) {
                    for (Shape shape : this.current_area.getCurrent_layer().getList_shapes()) {
                        info_list += " -   " + shape.toString() + "\n";
                    }
                } else {
                    return error_param;
                }
                info_list += action_completed;
                return info_list;
            }

            case "new" -> {
                if (command_params.isEmpty()) {
                    return error_param;
                } else if (command_params.get(0).equals("area")) {
                    this.current_area = new Area(this.width, this.height, UUID.randomUUID(), "area_name");
                    this.list_areas.add(this.current_area);
                } else if (command_params.get(0).equals("layer")) {
                    this.current_area.setCurrent_layer(new Layer());
                    this.current_area.add_layer(this.current_area.getCurrent_layer());
                }
                return action_completed;
            }

            case "select" -> {
                if (command_params.size() == 2) {
                    if (command_params.get(0).equals("area")) {
                        for (Area area : this.list_areas) {
                            System.out.println(area.getId().toString());
                            if (command_params.get(1).equals(area.getId().toString())) {
                                setCurrent_area(area);
                            }
                        }
                    } else if (command_params.get(0).equals("layer")) {
                        for (Layer layer : this.current_area.getList_layers()) {
                            System.out.println(command_params.get(1) + " " + layer.getId().toString());
                            if (command_params.get(1).equals(layer.getId().toString())) {
                                this.current_area.setCurrent_layer(layer);
                            }
                        }
                    }
                    return action_completed;
                }
            }

            case "delete" -> {
                if (command_params.size() == 2) {
                    if (command_params.get(0).equals("area")) {
                        if (this.current_area.getId().toString().equals(command_params.get(1))) {
                            return error_used;
                        }
                        for (Area area : this.list_areas) {
                            if (area.getId().toString().equals(command_params.get(1))) {
                                this.list_areas.remove(area);
                                return action_completed;
                            }
                        }
                    } else if (command_params.get(0).equals("layer")) {
                        if (this.current_area.getCurrent_layer().getId().toString().equals(command_params.get(1))) {
                            return error_used;
                        }
                        for (Layer layer : this.current_area.getList_layers()) {
                            if (layer.getId().toString().equals(command_params.get(1))) {
                                this.current_area.getList_layers().remove(layer);
                                return action_completed;
                            }
                        }
                    } else if (command_params.get(0).equals("shape")) {
                        for (Shape shape : this.current_area.getCurrent_layer().getList_shapes()) {
                            if (shape.getId().toString().equals(command_params.get(1))) {
                                this.current_area.getCurrent_layer().getList_shapes().remove(shape);
                                return action_completed;
                            }
                        }
                    }
                }
            }

            case "set" -> {
                if (command_params.size() == 3) {
                    if (command_params.get(0).equals("char")) {
                        if (command_params.get(1).equals("border")) {
                            try {
                                this.current_area.getCurrent_layer().setDrawn_char(command_params.get(2).charAt(0));
                                return command_interpreter("plot");
                            } catch (NumberFormatException e) {return error_param;}
                        } else if (command_params.get(1).equals("background")) {
                            try {
                                this.current_area.setEmpty_char(command_params.get(2).charAt(0));
                                return command_interpreter("plot");
                            } catch (NumberFormatException e) {return error_param;}
                        }
                    } else if (command_params.get(0).equals("layer")) {
                        for (Layer layer : this.current_area.getList_layers()) {
                            if (layer.getId().toString().equals(command_params.get(2))) {
                                if (command_params.get(1).equals("visible")) {
                                    layer.set_visibility(true);
                                    return command_interpreter("plot");
                                } else if (command_params.get(1).equals("unvisible")) {
                                    layer.set_visibility(false);
                                    return command_interpreter("plot");
                                }
                            }
                        }
                    }
                }
            }

            default -> {
                return error_unknown;
            }

            case "translate" -> {
                if (command_params.size() == 3) {
                    try {
                        String id = command_params.get(0);
                        int dx = Integer.parseInt(command_params.get(1));
                        int dy = Integer.parseInt(command_params.get(2));

                        Shape shape = this.current_area
                                .getCurrent_layer()
                                .getShapeById(id);

                        if (shape == null) {
                            return "shape not found\n";
                        }

                        shape.translate(dx, dy);
                        return command_interpreter("plot");

                    } catch (NumberFormatException e) {
                        return error_param;
                    }
                } else {
                    return error_param;
                }
            }
            case "fill" -> {
                if (command_params.size() == 2) {

                    String id = command_params.get(0);

                    if (command_params.get(1).length() != 1) {
                        return error_param;
                    }

                    char fillChar = command_params.get(1).charAt(0);

                    Shape shape = this.current_area
                            .getCurrent_layer()
                            .getShapeById(id);

                    if (shape == null) {
                        return "shape not found\n";
                    }

                    if (shape instanceof Fillable fillableShape) {
                        fillableShape.setFillChar(fillChar);
                        return command_interpreter("plot");
                    } else {
                        return "This shape cannot be filled\n";
                    }

                } else {
                    return error_param;
                }
            }
        }
        return "error : command interpreter did not find any corresponding case";
    }
}
