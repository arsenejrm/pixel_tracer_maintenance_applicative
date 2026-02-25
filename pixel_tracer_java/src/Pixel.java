

/**
 * La classe Pixel est l'unité d'affichage utilisée pour afficher le projet dans la console.
 */
public class Pixel {

    // Coordonnées
    private int x;
    private int y;
    private Character color_char;
    
    /**
     * Constructeur de la classe Pixel, avec comme paramètres les coordonnées du pixel
     * @param par_x La valeur de x sur laquelle le pixel se placera en longueur
     * @param par_y La valeur de y sur laquelle le pixel se placera en hauteur
     */
    public Pixel(int par_x, int par_y, Character par_color_char) {
        this.x = par_x;
        this.y = par_y;
        this.color_char = par_color_char;
    };



    /**
     * Détermine la valeur de la coordonnée x
     * @param par_x La valeur de x sur laquelle le pixel se placera en longueur
     */
    public void setX (int par_x) {
        this.x = par_x;
    }

    /**
     * Renvoie la valeur de la coordonnée x
     * @return La valeur de la coordonnée x
     */
    public int getX () {
        return this.x;
    }

    /**
     * Détermine la valeur de la coordonnée y
     * @param par_y La valeur de y sur laquelle le pixel se placera en hauteur
     */
    public void setY (int par_y) {
        this.y = par_y;
    }

    /**
     * Renvoie la valeur de la coordonnée y
     * @return La valeur de la coordonnée y
     */
    public int getY () {
        return this.y;
    }

    /**
     * Détermine le caracère utilisé pour dessiner ce pixel
     * @param par_color_char Le caractère utilisé
     */
    public void setChar (Character par_color_char) {
        this.color_char = par_color_char;
    }

    /**
     * Renvoie la valeur de la coordonnée y
     * @return La valeur de la coordonnée y
     */
    public Character getColor_char () {
        return this.color_char;
    }



    /**
     * Renvoie les coordonnées du pixel sous la forme (x, y)
     */
    @Override
    public String toString()
    {
        return "(" + this.x + ", " + this.y + "), char = '" + this.color_char + "'";
    }
}
