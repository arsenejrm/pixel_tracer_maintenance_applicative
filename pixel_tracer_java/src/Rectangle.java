
import java.util.*;


/**
 * Class Rectangle
 */
public class Rectangle extends Shape {

    //
    // Fields
    //

    private int height;
    private int width;
    private Point p1;
    
    //
    // Constructors
    //
    public Rectangle () {
        super(0);
     };
    
    //
    // Methods
    //
     @Override
     public void draw(char[][] canvas) {
         // Draw the rectangle on the canvas
         if (p1 == null) return;
         
         int x = p1.getPos_x();
         int y = p1.getPos_y();
         
         for (int i = y; i < y + height && i < canvas.length; i++) {
             for (int j = x; j < x + width && j < canvas[i].length; j++) {
                 canvas[i][j] = '*';
             }
         }
     }

    public void translate(int deltaX, int deltaY) {
         if (p1 != null) {
             p1.setPos_x(p1.getPos_x() + deltaX);
             p1.setPos_y(p1.getPos_y() + deltaY);
         }
     }

    public void rotate(double angle) {
        // Rotation logic
    }

    public void resize(double factor) {
        height = (int)(height * factor);
        width = (int)(width * factor);
    }



    public void changeColor(String color) {
        // Color change logic
    }

    public void changeThickness(int thickness) {
        // Thickness change logic
    }

     public void fill(String color) {
         // Fill logic
     }

     public void unfill() {
         // Unfill logic
     }

     public void delete() {
         // Delete logic
     }

    public void duplicate() {
        // Duplicate logic
    }

    

    //
    // Accessor methods
    //

    /**
     * Set the value of height
     * @param newVar the new value of height
     */
    public void setHeight (int newVar) {
        height = newVar;
    }

    /**
     * Get the value of height
     * @return the value of height
     */
    public int getHeight () {
        return height;
    }

    /**
     * Set the value of width
     * @param newVar the new value of width
     */
    public void setWidth (int newVar) {
        width = newVar;
    }

    /**
     * Get the value of width
     * @return the value of width
     */
    public int getWidth () {
        return width;
    }

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

    //
    // Other methods
    //

    /**
     */
    public String toString()
    {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                ", p1=" + p1 +
                '}';
    }


}
