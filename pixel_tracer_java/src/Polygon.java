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
    
    /**
     * Constructor
     * @param points
     */
    public Polygon(ArrayList<Point> points) {
        super(0);
        this.points = points;
    }

    /**
     * Constructor
     * @param id
     * @param n
     * @param points
     */
    public Polygon(int id, int n, ArrayList<Point> points) {
        super(id);
        this.points = points;
    }
    
    //
    // Methods
    //

    /**
     * Dessine un Polygon
     * @param drawn_char
     * @return
     */
    @Override
    public ArrayList<Pixel> draw(char drawn_char) {
        ArrayList<Pixel> pixels_list = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i+1) % points.size());
            Line line = new Line(p1, p2);
            pixels_list.addAll(line.draw(drawn_char));
        }
        if (fillChar != ' ') {

            int minY = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE;

            for (Point p : points) {
                minY = Math.min(minY, p.getPos_y());
                maxY = Math.max(maxY, p.getPos_y());
            }

            for (int y = minY; y <= maxY; y++) {
                ArrayList<Integer> intersections = new ArrayList<>();

                for (int i = 0; i < points.size(); i++) {
                    Point p1 = points.get(i);
                    Point p2 = points.get((i + 1) % points.size());

                    int x1 = p1.getPos_x();
                    int y1 = p1.getPos_y();
                    int x2 = p2.getPos_x();
                    int y2 = p2.getPos_y();

                    if (y1 != y2 && y >= Math.min(y1, y2) && y < Math.max(y1, y2)) {
                        int x = x1 + (y - y1) * (x2 - x1) / (y2 - y1);
                        intersections.add(x);
                    }
                }

                Collections.sort(intersections);

                for (int i = 0; i < intersections.size(); i += 2) {
                    if (i + 1 < intersections.size()) {
                        for (int x = intersections.get(i); x <= intersections.get(i + 1); x++) {

                            boolean isContour = false;

                            for (Pixel p : pixels_list) {
                                if (p.getX() == x && p.getY() == y) {
                                    isContour = true;
                                    break;
                                }
                            }

                            if (!isContour) {
                                pixels_list.add(new Pixel(x, y, fillChar));
                            }
                        }
                    }
                }
            }
        }
        return pixels_list;
    }

    /**
     * Déplace le Polygon selon les paramètres delta des abscisses et des ordonnées, qu'ils soient positifs ou négatifs
     * @param deltaX
     * @param deltaY
     * 
     */
    @Override
    public void translate(int deltaX, int deltaY) {
        for (Point p : points) {
            p.translate(deltaX, deltaY);
        }
    }

    /**
     * Modifie le caractère de remplissage du Polygon
     * @param c
     */
    @Override
    public void setFillChar(char c) {
        this.fillChar = c;
    }

    /**
     * Retourne le caractère de remplissage du Polygon
     * @return
     */
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


    /**
     * Renvoie les coordonnées du Polygon pour la commande list
     * @return
     */
    public String points_toString() {
        String str_out = "";
        for (Point point : this.getPoints()) {
            str_out += point.getPos_x() + " " + point.getPos_y() + " ";
        }
        return str_out;
    }


    /**
     * Renvoie la classe du Polygon et ses coordonnées pour la commande list
     */
    @Override
    public String toString()
    {
        return super.toString() + " POLYGON " + points_toString();
    }


}
