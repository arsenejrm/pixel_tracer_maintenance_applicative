
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

        for (double t = 0; t <= 1.0; t += 0.0005) {

            Point p = cj_calc(controlPoints, controlPoints.size(), t).get(0);

            int x = p.getPos_x();
            int y = p.getPos_y();
            pixels.add(new Pixel(x, y, drawn_char));
        }
        return pixels;
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
    
    public void translate(int x, int y) {
        // TODO implement here
    }
    
    public void rotate(double angle) {
        // TODO implement here
    }
    
    public void scale(double factor) {
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
     * Set the value of p1
     * @param newVar the new value of p1
     */
    public void setP1 (Point newVar) {
        p1 = newVar;
    }

    /**
     * Get the value of p1
     * @return the value of p1
     */
    public Point getP1 () {
        return p1;
    }

    /**
     * Set the value of p2
     * @param newVar the new value of p2
     */
    public void setP2 (Point newVar) {
        p2 = newVar;
    }

    /**
     * Get the value of p2
     * @return the value of p2
     */
    public Point getP2 () {
        return p2;
    }

    /**
     * Set the value of p3
     * @param newVar the new value of p3
     */
    public void setP3 (Point newVar) {
        p3 = newVar;
    }

    /**
     * Get the value of p3
     * @return the value of p3
     */
    public Point getP3 () {
        return p3;
    }

    /**
     * Set the value of p4
     * @param newVar the new value of p4
     */
    public void setP4 (Point newVar) {
        p4 = newVar;
    }

    /**
     * Get the value of p4
     * @return the value of p4
     */
    public Point getP4 () {
        return p4;
    }

    //
    // Other methods
    //

    /**
     */
    public void toString()
    {
    }


}
