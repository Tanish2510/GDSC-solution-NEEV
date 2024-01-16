import java.util.HashMap;
import java.util.Map;

// Class to represent user information
class User {
    private String name;
    private String mobileNumber;
    private String primaryGoal;

    public User(String name, String mobileNumber, String primaryGoal) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.primaryGoal = primaryGoal;
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

    
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", primaryGoal='" + primaryGoal + '\'' +
                '}';
    }
}

// Class to manage user data
class UserDataManager {
    private Map<String, User> users;

    public UserDataManager() {
        this.users = new HashMap<>();
    }

    // Add a new user
    public void addUser(String mobileNumber, User user) {
        users.put(mobileNumber, user);
    }

    // Get user information by mobile number
    public User getUser(String mobileNumber) {
        return users.get(mobileNumber);
    }

    // Update user information
    public void updateUser(String mobileNumber, User updatedUser) {
        if (users.containsKey(mobileNumber)) {
            users.put(mobileNumber, updatedUser);
        }
    }

    // Remove user
    public void removeUser(String mobileNumber) {
        users.remove(mobileNumber);
    }

    // Print all users (for demonstration purposes)
    public void printAllUsers() {
        for (Map.Entry<String, User> entry : users.entrySet()) {
            System.out.println("Mobile Number: " + entry.getKey() + ", User: " + entry.getValue());
        }
    }
}

public class NeevAppDataManagement {
    public static void main(String[] args) {
        // Example usage
        UserDataManager dataManager = new UserDataManager();

        // Adding a new user
        User newUser = new User("John Doe", "1234567890", "Learn Programming");
        dataManager.addUser(newUser.getMobileNumber(), newUser);

        // Printing all users
        dataManager.printAllUsers();

        // Retrieving user information
        User retrievedUser = dataManager.getUser("1234567890");
        System.out.println("Retrieved User: " + retrievedUser);

        // Updating user information
        User updatedUser = new User("John Doe", "1234567890", "Learn Data Science");
        dataManager.updateUser(updatedUser.getMobileNumber(), updatedUser);

        // Printing all users after update
        dataManager.printAllUsers();

        // Removing user
        dataManager.removeUser("1234567890");

        // Printing all users after removal
        dataManager.printAllUsers();
    }
}
