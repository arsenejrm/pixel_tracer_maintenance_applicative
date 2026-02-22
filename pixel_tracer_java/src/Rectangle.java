


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

    public Rectangle (int height, int width, Point p1) {
        super(0);
        this.height = height;
        this.width = width;
        this.p1 = p1;
     };
     
    public Rectangle(int id, int height, int width, Point p1) {
        super(id);
        this.height = height;
        this.width = width;
        this.p1 = p1;
     }
     
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

     public void scale(double factor) {
        height = (int)(height * factor);
        width = (int)(width * factor);
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
        this.height = newVar;
    }

    /**
     * Get the value of height
     * @return the value of height
     */
    public int getHeight () {
        return this.height;
    }

    /**
     * Set the value of width
     * @param newVar the new value of width
     */
    public void setWidth (int newVar) {
        this.width = newVar;
    }

    /**
     * Get the value of width
     * @return the value of width
     */
    public int getWidth () {
        return this.width;
    }

    /**
     * Set the value of p1
     * @param newVar the new value of p1
     */
    public void setP1 (Point newVar) {
        this.p1 = newVar;
    }

    /**
     * Get the value of p1
     * @return the value of p1
     */
    public Point getP1 () {
        return this.p1;
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
