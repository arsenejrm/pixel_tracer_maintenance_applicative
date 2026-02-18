

/**
 * La classe Pixel est l'unité d'affichage utilisée pour afficher le projet dans la console.
 */
public class Pixel {

    // Coordonnées
    private int x;
    private int y;
    
    /**
     * Constructeur de la classe Pixel, avec comme paramètres les coordonnées du pixel
     * @param par_x La valeur de x sur laquelle le pixel se placera en longueur
     * @param par_y La valeur de y sur laquelle le pixel se placera en hauteur
     */
    public Pixel(int par_x, int par_y) {
        this.x = par_x;
        this.y = par_y;
    };



    /**
     * Détermine la valeur de la coordonnée x
     * @param par_x La valeur de x sur laquelle le pixel se placera en longueur
     */
    public void setX (int par_x) {
        x = par_x;
    }

    /**
     * Renvoie la valeur de la coordonnée x
     * @return La valeur de la coordonnée x
     */
    public int getX () {
        return x;
    }

    /**
     * Détermine la valeur de la coordonnée y
     * @param par_y La valeur de y sur laquelle le pixel se placera en hauteur
     */
    public void setY (int par_y) {
        y = par_y;
    }

    /**
     * Renvoie la valeur de la coordonnée y
     * @return La valeur de la coordonnée y
     */
    public int getY () {
        return y;
    }



    /**
     * Renvoie les coordonnées du pixel sous la forme (x, y)
     */
    public String toString()
    {
        return "(" + this.x + ", " + this.y + ")";
    }
}
