import java.util.*;


/**
 * Class Polygon
 */
public class Polygon extends Shape {

    //
    // Fields
    //

    private ArrayList<Point> points;

    //
    // Constructors
    //
    public Polygon () {
        super(0);
     };
    
    public Polygon(ArrayList<Point> points) {
        super(0);
        this.points = points;
    }

    public Polygon(int id, int n, ArrayList<Point> points) {
        super(id);
        this.points = points;
    }
    
    //
    // Methods
    //
    @Override
    public ArrayList<Pixel> draw(char drawn_char) {
        ArrayList<Pixel> pixels_list = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i+1) % points.size());
            Line line = new Line(p1, p2);
            pixels_list.addAll(line.draw(drawn_char));
        }
        return pixels_list;
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

    public ArrayList<Point> getPoints() {
        return this.points;
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


    public String points_toString() {
        String str_out = "";
        for (Point point : this.getPoints()) {
            str_out += point.getPos_x() + " " + point.getPos_y() + " ";
        }
        return str_out;
    }


    /**
     */
    @Override
    public String toString()
    {
        return super.toString() + " POLYGON " + points.toString();
    }


}
