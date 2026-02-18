import java.util.Scanner;

/**
 * Class App
 */
public class App {
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        Boolean run = true;
        try {
            Scanner scanner = new Scanner(System.in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PixelTracer pt = new PixelTracer();
        String response;

        while (run) {
            System.out.print("~> ");
            String user_input = scanner.nextLine();
            response = pt.command_interpreter(user_input);
            if (response.equals("exit")) {
                break;
            }
            System.out.println(response);
            if (response.equals("clear")) {
                try {
                    if (System.getProperty("os.name").contains("Windows")) {
                        new ProcessBuilder("cmd", "/c", "cls")
                                .inheritIO()
                                .start()
                                .waitFor();
                    } else {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                } catch (Exception e) {}
            }
        }
        scanner.close();
    }
}
