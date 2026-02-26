
import java.util.*;


/**
 * La classe Point permet de définir un point avec ses coordonnées.
 * Il est l'objet de base de la famille des Shape et constitue tous les autres formes.
 */
public class Point extends Shape {

    /**
     * Position sur l'axe des abscisses du Point
     */
    private int pos_x;
    /**
     * Position sur l'axe des ordonnées du Point
     */
    private int pos_y;

    /**
     * Ce constructeur définit un point par défaut aux positions (1, 1)
     */
    public Point() {
        this(1, 1);
    }

    /**
     * Ce constructeur, le plus utilisé de la classe Point, 
     * permet de définir un point et ses coordonnées
     * @param pos_x La position sur l'axe des abscisses
     * @param pos_y La position sur l'axe des ordonnées
     */
    public Point(int pos_x, int pos_y) {
        super(0); // id par défaut
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    /**
     * Cette implémentation de la méthode draw() renvoie un Pixel aux mêmes coordonnées que le Point.
     */
    @Override
    public ArrayList<Pixel> draw(char drawn_char) {
        return new ArrayList<>(Arrays.asList(new Pixel(this.getPos_x(), this.getPos_y(), drawn_char)));
    }

    /**
     * Cette implémentation de la méthode translate() change les coordonnées du Point
     * selon les paramètres delta des ordonnées et abscisses, qu'ils soient positifs ou négatifs
     */
    @Override
    public void translate(int deltaX, int deltaY) {
            this.setPos_x(this.getPos_x() + deltaX);
            this.setPos_y(this.getPos_y() + deltaY);
    }

    /**
     * Set the value of pos_x
     * @param newVar the new value of pos_x
     */
    public void setPos_x (int newVar) {
        pos_x = newVar;
    }

    /**
     * Get the value of pos_x
     * @return the value of pos_x
     */
    public int getPos_x () {
        return pos_x;
    }

    /**
     * Set the value of pos_y
     * @param newVar the new value of pos_y
     */
    public void setPos_y (int newVar) {
        pos_y = newVar;
    }

    /**
     * Get the value of pos_y
     * @return the value of pos_y
     */
    public int getPos_y () {
        return pos_y;
    }

    /**
     * Renvoie la classe du Point et ses coordonnées pour la commande list
     */
    @Override
    public String toString()
    {
        return super.toString() + " POINT " + this.pos_x + " " + this.pos_y;
    }


}
