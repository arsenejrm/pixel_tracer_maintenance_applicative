import java.util.ArrayList;
import java.util.UUID;


interface Fillable {
    void setFillChar(char c);
    char getFillChar();
}
interface Rotatable {
    void rotate(double angle);
}

/**
 * La classe abstraite Shape permet de réaliser toutes les formes disponibles dans le programme
 */
public abstract class Shape {

    /**
     * L'identifiant de la Shape
     */
    private UUID id;
    /**
     * Indique si la Shape est remplie
     */
    private boolean fill;
    /**
     * Direction dans laquelle la Shape est tournée
     */
    private double rotation;
    

    /**
     * Le constructeur de la classe Shape permet d'instancier les propriétés de la Shape
     * @param id 
     */
    public Shape(int id) {
        this.id = UUID.randomUUID();
        this.fill = false;
        this.rotation = 0.0;
    }


    /**
     * Set the value of id
     * @param newVar the new value of id
     */
    public void setId (UUID newVar) {
        id = newVar;
    }

    /**
     * Get the value of id
     * @return the value of id
     */
    public UUID getId () {
        return id;
    }

    /**
     * Set the value of fill
     * @param newVar the new value of fill
     */
    public void setFill (boolean newVar) {
        fill = newVar;
    }

    /**
     * Get the value of fill
     * @return the value of fill
     */
    public boolean getFill () {
        return fill;
    }

    /**
     * Set the value of rotation
     * @param newVar the new value of rotation
     */
    public void setRotation (double newVar) {
        rotation = newVar;
    }

    /**
     * Get the value of rotation
     * @return the value of rotation
     */
    public double getRotation () {
        return rotation;
    }


    /**
     * La méthode draw() est la méthode qui permet la conversion d'une Shape en liste de Pixel,
     * pour ensuite disposer ces Pixel sur un Layer
     * @param drawn_char Le caractère utilisé pour dessiner les Pixel
     * @return Liste des Pixel correspondants
     */
    public abstract ArrayList<Pixel> draw(char drawn_char);

    /**
     * La méthode translate() permet de bouger les coordonnées d'une Shape selon les 
     * paramètres dx et dy, qu'ils soient positifs ou négatifs
     * @param dx La valeur ajoutée à l'abscisse de la Shape
     * @param dy La valeur ajoutée à l'ordonnée de la Shape
     */
    public abstract void translate(int dx, int dy);


    /**
     * Renvoie l'identifiant de la Shape pour la commande list
     */
    @Override
    public String toString() {
        return this.id.toString();
    }


}
