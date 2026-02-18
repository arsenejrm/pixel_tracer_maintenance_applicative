
import java.util.*;


/**
 * Class Polygon
 */
public class Polygon extends Shape {

    //
    // Fields
    //

    private int n;
    private List<Point> points;

    //
    // Constructors
    //
    public Polygon () {
        super(0);
     };
    
    public Polygon(int n, List<Point> points) {
        super(0);
        this.n = n;
        this.points = points;
    }

    public Polygon(int id, int n, List<Point> points) {
        super(id);
        this.n = n;
        this.points = points;
    }
    
    //
    // Methods
    //
    public void draw(char[][] canvas) {
        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i+1)%n);
            Line line = new Line(p1, p2);
            line.draw(canvas);
        }
    }

    public void translate(int x, int y) {
        for (Point p : points) {
            p.setPos_x(p.getPos_x() + x);
            p.setPos_y(p.getPos_y() + y);
        }
    }

     public void rotate(double angle) {
        // TODO implement here
    }

     public void addPoint(Point p) {
        // TODO implement here
    }
    public void removePoint(Point p) {
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
     * Set the value of n
     * @param newVar the new value of n
     */
    public void setN (int newVar) {
        n = newVar;
    }

    /**
     * Get the value of n
     * @return the value of n
     */
    public int getN () {
        return n;
    }

    //
    // Other methods
    //

    /**
     */
    public String toString()
    {
        return "Polygon{" +
                "n=" + n +
                '}';
    }


}
