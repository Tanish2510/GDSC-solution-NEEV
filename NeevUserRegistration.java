import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NeevUserRegistration {

    private static final Map<String, User> userDatabase = new HashMap<>();
    private static int userIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register User");
            System.out.println("2. View User Details");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    viewUserDetails(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your mobile number: ");
        String mobileNumber = scanner.nextLine();

        System.out.print("Enter your primary goal: ");
        String primaryGoal = scanner.nextLine();

        User user = new User(userIdCounter++, name, mobileNumber, primaryGoal);
        userDatabase.put(user.getMobileNumber(), user);

        System.out.println("User registration successful!");
    }

    private static void viewUserDetails(Scanner scanner) {
        System.out.print("Enter mobile number to view details: ");
        String mobileNumber = scanner.nextLine();

        if (userDatabase.containsKey(mobileNumber)) {
            User user = userDatabase.get(mobileNumber);
            System.out.println("User Details:");
            System.out.println("User ID: " + user.getUserId());
            System.out.println("Name: " + user.getName());
            System.out.println("Mobile Number: " + user.getMobileNumber());
            System.out.println("Primary Goal: " + user.getPrimaryGoal());
        } else {
            System.out.println("User not found with the given mobile number.");
        }
    }
}

class User {
    private final int userId;
    private final String name;
    private final String mobileNumber;
    private final String primaryGoal;

    public User(int userId, String name, String mobileNumber, String primaryGoal) {
        this.userId = userId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.primaryGoal = primaryGoal;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPrimaryGoal() {
        return primaryGoal;
    }
}
 
