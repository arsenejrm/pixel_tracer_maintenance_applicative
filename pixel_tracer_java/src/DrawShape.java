

/**
 * Class DrawShape
 */
public class DrawShape {

    //
    // Fields
    //

    private Pixel pixel_list;
    
    //
    // Constructors
    //
    public DrawShape () { };
    
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of pixel_list
     * @param newVar the new value of pixel_list
     */
    public void setPixel_list (Pixel newVar) {
        pixel_list = newVar;
    }

    /**
     * Get the value of pixel_list
     * @return the value of pixel_list
     */
    public Pixel getPixel_list () {
        return pixel_list;
    }

    //
    // Other methods
    //

    /**
     */
    public void toString()
    {
    }


    /**
     * @return       Pixel
     * @param        point
     */
    public Pixel pixel_point(Point point)
    {
    }


    /**
     * @param        new_parameter
     */
    public void pixel_line(Line new_parameter)
    {
    }


    /**
     * @param        cercle
     */
    public void pixel_circle(Circle cercle)
    {
    }


    /**
     * @param        rectangle
     */
    public void pixel_rectangle(Rectangle rectangle)
    {
    }


    /**
     * @param        square
     */
    public void pixel_square(Square square)
    {
    }


    /**
     * @param        polygon
     */
    public void pixel_polygon(Polygon polygon)
    {
    }


    /**
     * @return       Point
     * @param        p1
     * @param        p2
     * @param        t
     */
    public Point calc_median(Point p1, Point p2, double t)
    {
    }


    /**
     * @return       Point
     * @param        points
     * @param        num_pt
     * @param        t
     */
    public Point calc_casteljau(Point points, Integer num_pt, double t)
    {
    }


    /**
     * @param        curve
     */
    public void pixel_curve(Curve curve)
    {
    }


    /**
     * @param        x
     * @param        y
     * @param        dx
     * @param        dy
     * @param        color
     */
    private void draw_segment(Integer x, Integer y, Integer dx, Integer dy, Integer color)
    {
    }


}
