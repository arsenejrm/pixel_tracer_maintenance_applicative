
import java.util.*;


/**
 * Class Line
 */
public class Line extends Shape {

    //
    // Fields
    //

    private Point p1;
    private Point p2;
    
    //
    // Constructors
    //
    public Line () {
        super(0);
     };
    
    public Line(Point p1, Point p2) {
        super(0);
        this.p1 = p1;
        this.p2 = p2;
    }
    
     public Line(int id, Point p1, Point p2) {
        super(id);
        this.p1 = p1;
        this.p2 = p2;
    }

    //
    // Methods
    //
    @Override
    public ArrayList<Pixel> draw(char drawn_char) {
        // Draw the Line on the canvas
        ArrayList<Pixel> pixels = new ArrayList<>();

        if (this.p1 == null || this.p2 == null) return null;
        pixels.add(new Pixel(p1.getPos_x(), p1.getPos_y(), drawn_char));
        pixels.add(new Pixel(p2.getPos_x(), p2.getPos_y(), drawn_char));

        int x1 = p1.getPos_x();
        int y1 = p1.getPos_y();
        int x2 = p2.getPos_x();
        int y2 = p2.getPos_y();
        
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;
        
        int x = x1;
        int y = y1;
        
        while (true) {
            if (x == x2 && y == y2) break;
            int e2 = 2 * err;
            if (e2 > -dy) err -= dy;
            if (e2 < dx) err += dx;
            x += sx;
            y += sy;
        }
        return pixels;
    }

    public void translate(int deltaX, int deltaY) {
         if (p1 != null) {
             p1.setPos_x(p1.getPos_x() + deltaX);
             p1.setPos_y(p1.getPos_y() + deltaY);
         }
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

    //
    // Other methods
    //

    /**
     */
    public String toString()
    {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }


}
