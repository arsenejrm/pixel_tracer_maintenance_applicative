import java.util.ArrayList;
import java.util.Arrays;
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
     */
    @Override
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
        this.list_shapes.add(shape);   
    }


    /**
     * @param        id
     */
    public void remove_shape_from_layer(Integer id)
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
    public ArrayList<Pixel> draw() {

        ArrayList<Pixel> pixels = new ArrayList<>();

        if (!this.visible) {
            return pixels;
        }

        for (Shape shape : list_shapes) {
            pixels.addAll(shape.draw());
        }

        return pixels;
    }


    /**
     * @return       Pixel
     * @param        point
     */
    public Pixel pixel_point(Point point)
    {
        return new Pixel(point.getPos_x(), point.getPos_y(), this.drawn_char);
    }


    /**
     * @param        x
     * @param        y
     * @param        dx
     * @param        dy
     * @param        color
     */
    public ArrayList<Pixel> draw_segment(Integer x, Integer y, Integer dx, Integer dy)
    {
        ArrayList<Pixel> pixels_list = new ArrayList<>();
        int i, cumul;
        int xinc, yinc;
        xinc = (dx > 0) ? 1 : -1;
        yinc = (dy > 0) ? 1 : -1;
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        pixels_list.add(new Pixel(x, y, this.drawn_char));
        if (dx > dy) {
            cumul = dx / 2;
            for (i = 1; i <= dx; i++) {
                x += xinc;
                cumul += dy;
                if (cumul >= dx) {
                    cumul -= dx;
                    y += yinc;
                }
                pixels_list.add(new Pixel(x, y, this.drawn_char));
            }
        } else {
            cumul = dy / 2;
            for (i = 1; i <= dy; i++) {
                y += yinc;
                cumul += dx;
                if (cumul >= dy) {
                    cumul -= dy;
                    x += xinc;
                }
                pixels_list.add(new Pixel(x, y, this.drawn_char));
            }
        }
        return pixels_list;
    }


    /**
     * @param        new_parameter
     */
    public ArrayList<Pixel> pixel_line(Line line)
    {
        return draw_segment(line.getP1().getPos_x(), line.getP1().getPos_y(), line.getP2().getPos_x(), line.getP2().getPos_y());
    }


    /**
     * @param        cercle
     */
    public ArrayList<Pixel> pixel_circle(Circle cercle)
    {
        int x = 0;
        int y = cercle.getRadius();
        int d = cercle.getRadius() - 1;
        ArrayList<Pixel> pixels_list = new ArrayList<>();

        while (y >= x) {
            pixels_list.add(new Pixel(cercle.getCenter().getPos_x() + x, cercle.getCenter().getPos_y() + y, this.drawn_char));
            pixels_list.add(new Pixel(cercle.getCenter().getPos_x() + y, cercle.getCenter().getPos_y() + x, this.drawn_char));

            pixels_list.add(new Pixel(cercle.getCenter().getPos_x() - x, cercle.getCenter().getPos_y() + y, this.drawn_char));
            pixels_list.add(new Pixel(cercle.getCenter().getPos_x() - y, cercle.getCenter().getPos_y() + x, this.drawn_char));

            pixels_list.add(new Pixel(cercle.getCenter().getPos_x() + x, cercle.getCenter().getPos_y() - y, this.drawn_char));
            pixels_list.add(new Pixel(cercle.getCenter().getPos_x() + y, cercle.getCenter().getPos_y() - x, this.drawn_char));

            pixels_list.add(new Pixel(cercle.getCenter().getPos_x() - x, cercle.getCenter().getPos_y() - y, this.drawn_char));
            pixels_list.add(new Pixel(cercle.getCenter().getPos_x() - y, cercle.getCenter().getPos_y() - x, this.drawn_char));

            if (d >= 2 * x) {
                d -= 2 * x + 1;
                x++;
            } else if (d < 2 * (cercle.getRadius() - y)) {
                d += 2 * y - 1;
                y--;
            } else {
                d += 2 * (y - x - 1);
                y--;
                x++;
            }
        }
        return pixels_list;
    }


    /**
     * @param        rectangle
     */
    public ArrayList<Pixel> pixel_rectangle(Rectangle rectangle)
    {
        ArrayList<Pixel> pixels_list = new ArrayList<>();
        pixels_list.addAll(draw_segment(rectangle.getP1().getPos_x(), rectangle.getP1().getPos_y(), 0, rectangle.getWidth() - 1));
        pixels_list.addAll(draw_segment(rectangle.getP1().getPos_x(), rectangle.getP1().getPos_y(), rectangle.getHeight() - 1, 0));
        pixels_list.addAll(draw_segment(rectangle.getP1().getPos_x(), rectangle.getP1().getPos_y() + rectangle.getWidth() - 1, rectangle.getHeight() - 1, 0));
        pixels_list.addAll(draw_segment(rectangle.getP1().getPos_x() + rectangle.getHeight() - 1, rectangle.getP1().getPos_y(), 0, rectangle.getWidth() - 1));
        return pixels_list;
    }


    /**
     * @param        square
     */
    public ArrayList<Pixel> pixel_square(Square square)
    {
        ArrayList<Pixel> pixels_list = new ArrayList<>();
        pixels_list.addAll(draw_segment(square.getP1().getPos_x(), square.getP1().getPos_y(), square.getLenght() - 1, 0));
        pixels_list.addAll(draw_segment(square.getP1().getPos_x(), square.getP1().getPos_y(), 0, square.getLenght() - 1));
        pixels_list.addAll(draw_segment(square.getP1().getPos_x(), square.getP1().getPos_y() + square.getLenght() - 1, square.getLenght() - 1, 0));
        pixels_list.addAll(draw_segment(square.getP1().getPos_x() + square.getLenght() - 1, square.getP1().getPos_y(), 0, square.getLenght() - 1));
        return pixels_list;
    }


    /**
     * @param        polygon
     */
    public ArrayList<Pixel> pixel_polygon(Polygon polygon)
    {
        ArrayList<Pixel> pixels_list = new ArrayList<>();
        for (int i = 1; i < polygon.getPoints().size(); i++) {
            Pixel p1 = pixel_point(polygon.getPoints().get(i - 1));
            pixels_list.add(p1);
            Pixel p2 = pixel_point(polygon.getPoints().get(i));
            pixels_list.add(p2);
            int dx, dy, x, y;
            x = p1.getX();
            y = p1.getY();
            dx = p2.getX() - p1.getX();
            dy = p2.getY() - p1.getY();
            pixels_list.addAll(draw_segment(x, y, dx, dy));
        }
        Pixel p1 = pixel_point(polygon.getPoints().get(polygon.getPoints().size() - 1));
        pixels_list.add(p1);
        Pixel p2 = pixel_point(polygon.getPoints().get(0));
        pixels_list.add(p2);
        int dx, dy, x, y;
        x = p1.getX();
        y = p1.getY();
        dx = p2.getX() - p1.getX();
        dy = p2.getY() - p1.getY();
        pixels_list.addAll(draw_segment(x, y, dx, dy));
        return pixels_list;
    }
    


    /**
     * @return       Point
     * @param        p1
     * @param        p2
     * @param        t
     */
    public Point calc_median(Point p1, Point p2, double t)
    {
        int x = (int) (p1.getPos_x() * (1 - t) + p2.getPos_x() * t);
        int y = (int) (p1.getPos_y() * (1 - t) + p2.getPos_y() * t);
        Point result = new Point(x, y);
        return result;
    }


    public ArrayList<Point> cj_calc(ArrayList<Point> points, int num_pt, double t) {
        ArrayList<Point> tmp_points = new ArrayList<>();
        for (int i = 0; i < num_pt; i++) {
            tmp_points.add(points.get(i));
        }
        for (int i = num_pt - 1; i > 0; --i) {
            ArrayList<Point> new_points = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                new_points.add(calc_median(tmp_points.get(j), tmp_points.get(j + 1), t));
            }
            tmp_points = new_points;
        }
        return tmp_points;
    }


    public ArrayList<Pixel> pixel_curve(Curve curve) {
        ArrayList<Point> curve_points = new ArrayList<>(Arrays.asList(curve.getP1(), curve.getP2(), curve.getP3(), curve.getP4()));
        ArrayList<Pixel> pixels_list = new ArrayList<>();
        double t = 0;

        for (t = 0; t < 1.0; t += 0.0001) {
            ArrayList<Point> cjp1 = cj_calc(curve_points, curve_points.size(), t);
            pixels_list.add(new Pixel(cjp1.get(0).getPos_x(), cjp1.get(0).getPos_y(), this.drawn_char));
        }
        return pixels_list;
    }
}
