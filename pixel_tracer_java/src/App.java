import java.util.Scanner;

/**
 * Class App
 */
public class App {
    public static void main(String[] args) {
        Boolean run = true;
        Scanner scanner = new Scanner(System.in);
        PixelTracer pt = new PixelTracer();
        String response;

        while (run) {
            System.out.print("~> ");
            String user_input = scanner.nextLine();
            response = pt.command_interpreter(user_input);
            if (response.equals("program_end")) {
                break;
            }
            System.out.println(response);
        }
        scanner.close();
    }
}
