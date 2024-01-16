import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NeevAuthenticationApp {

    private static final Map<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("3. Sign In with Google");
            System.out.println("4. Sign In with Facebook");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    signIn(scanner);
                    break;
                case 2:
                    signUp(scanner);
                    break;
                case 3:
                    signInWithThirdParty("Google");
                    break;
                case 4:
                    signInWithThirdParty("Facebook");
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void signIn(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (userDatabase.containsKey(email) && userDatabase.get(email).equals(password)) {
            System.out.println("Sign in successful! Welcome, " + email + ".");
        } else {
            System.out.println("Invalid email or password. Sign in failed.");
        }
    }

    private static void signUp(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        if (userDatabase.containsKey(email)) {
            System.out.println("Email already exists. Please choose another email.");
        } else {
            System.out.print("Create a password: ");
            String password = scanner.nextLine();

            userDatabase.put(email, password);
            System.out.println("Sign up successful! You can now sign in.");
        }
    }

    private static void signInWithThirdParty(String provider) {
        // Implement third-party authentication logic (placeholder for demonstration)
        System.out.println("Signing in with " + provider + " (Not implemented in this demo).");
    }
}
