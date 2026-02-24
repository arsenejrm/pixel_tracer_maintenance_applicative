
import java.util.*;


/**
 * Class Curve
 */
public class Curve extends Shape {

    //
    // Fields
    //

    private ArrayList<Point> controlPoints;

    //
    // Constructors
    //

    // Constructeur vide
    public Curve() {
        super(0);
        this.controlPoints = new ArrayList<>();
    }

    // Constructeur avec ID
    public Curve(int id, List<Point> points) {
        super(id);
        setControlPoints(points);
    }

    // Constructeur sans ID
    public Curve(List<Point> points) {
        super(0);
        setControlPoints(points);
    }

    // Varargs
    public Curve(Point... points) {
        super(0);
        setControlPoints(Arrays.asList(points));
    }



    //
    // Methods
    //
    private void setControlPoints(List<Point> points) {
    if (points.size() < 3) {
        throw new IllegalArgumentException(
            "Une courbe doit avoir au minimum 3 points"
        );
    }
    this.controlPoints = new ArrayList<>(points);
}

    @Override
    public ArrayList<Pixel> draw(char drawn_char) {

        ArrayList<Pixel> pixels = new ArrayList<>();

        Pixel prev = null;

        for (double t = 0; t <= 1.0; t += 0.001) {

            Point p = cj_calc(controlPoints, controlPoints.size(), t).get(0);

            Pixel curr = new Pixel(
                p.getPos_x(),
                p.getPos_y(),
                drawn_char
            );

            if (prev != null) {
                pixels.addAll(drawSegment(prev, curr, drawn_char));
            } else {
                pixels.add(curr);
            }

            prev = curr;
        }

        return pixels;
    }

    private ArrayList<Pixel> drawSegment(Pixel a, Pixel b, char c) {

    ArrayList<Pixel> pixels = new ArrayList<>();

    int x0 = a.getX();
    int y0 = a.getY();
    int x1 = b.getX();
    int y1 = b.getY();

    int dx = Math.abs(x1 - x0);
    int dy = Math.abs(y1 - y0);
    int sx = x0 < x1 ? 1 : -1;
    int sy = y0 < y1 ? 1 : -1;
    int err = dx - dy;

    while (true) {
        pixels.add(new Pixel(x0, y0, c));
        if (x0 == x1 && y0 == y1) break;
        int e2 = 2 * err;
        if (e2 > -dy) { err -= dy; x0 += sx; }
        if (e2 < dx)  { err += dx; y0 += sy; }
    }

    return pixels;
}
    
    /**
     * @return       Point
     * @param        p1
     * @param        p2
     * @param        t
     */
    public Point calc_median(Point p1, Point p2, double t) {
        double x = p1.getPos_x() * (1 - t) + p2.getPos_x() * t;
        double y = p1.getPos_y() * (1 - t) + p2.getPos_y() * t;
        return new Point((int)Math.round(x), (int)Math.round(y));
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
    
    public void translate(int x, int y) {
        // TODO implement here
    }
    
    public void rotate(double angle) {
        // TODO implement here
    }


    public void changeColor(String color) {
        // TODO implement here
    }   
    
    public void resize(double factor) {
        // TODO implement here
    }
    

    //
    // Accessor methods
    //

        /**
        * Set the value of controlPoints
        * @param newVar the new value of controlPoints
        */
    public void setControlPoints (ArrayList<Point> newVar) {
        controlPoints = newVar;
    }

    /**
     * Get the value of controlPoints
     * @return the value of controlPoints
     */ 
    public ArrayList<Point> getControlPoints () {
        return controlPoints;
    }

    


    //
    // Other methods
    //

    public String points_toString() {
        String str_out = "";
        for (Point point : this.controlPoints) {
            str_out += point.getPos_x() + " " + point.getPos_y() + " ";
        }
        return str_out;
    }


    /**
     */
    @Override
    public String toString()
    {
        return super.toString() + " CURVE" + points_toString();
    }


}
