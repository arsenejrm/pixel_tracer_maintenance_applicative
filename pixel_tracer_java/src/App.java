import java.io.IOException;
import java.util.Scanner;

/**
 * Class App
 */
public class App {
    @SuppressWarnings({"ConvertToTryWithResources"})
    public static void main(String[] args) {
        Boolean run = true;
        Scanner scanner = new Scanner(System.in);
        PixelTracer pt = new PixelTracer(80, 50);
        String response;

        while (run) {
            System.out.print("~> ");
            String user_input = scanner.nextLine();
            response = pt.command_interpreter(user_input);
            if (response.equals("exit")) {
                break;
            }
            if (response.equals("clear")) {
                clear_command_line();
            } else {
                System.out.print(response);
            }
        }
        scanner.close();
    }

    public static void clear_command_line() {
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
        } catch (IOException | InterruptedException e) {}
    }
}
