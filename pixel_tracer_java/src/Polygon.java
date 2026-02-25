import java.util.*;


/**
 * Class Polygon
 */
public class Polygon extends Shape implements Fillable {

    //
    // Fields
    //

    private ArrayList<Point> points;
    private char fillChar = ' ';

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

    @Override
    public void translate(String id, int deltaX, int deltaY) {
        for (Point p : points) {
            p.translate(id, deltaX, deltaY);
        }
    }

    @Override
    public void setFillChar(char c) {
        this.fillChar = c;
    }

    @Override
    public char getFillChar() {
        return fillChar;
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
        return super.toString() + " POLYGON " + points_toString();
    }


}
