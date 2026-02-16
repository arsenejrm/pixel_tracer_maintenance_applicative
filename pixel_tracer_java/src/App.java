

/**
 * Class App
 */
public class App {
    public static void main(String[] args) {
        Pixel pixel  = new Pixel(12, 14);
        System.out.println(pixel);
        System.out.println(pixel.getX());
        System.out.println(pixel.getY());
        pixel.setX(20);
        pixel.setY(44);
        System.out.println(pixel);
    }
}
