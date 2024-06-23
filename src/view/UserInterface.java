package view;

import controller.RegistrationController;
import model.NotificationPreferences;
import model.User;
import model.Website;
import system.WebsiteMonitorSystem;

import java.util.Scanner;

import static system.WebsiteMonitorSystem.findUserById;

public class UserInterface {
    private RegistrationController controller;
    private Scanner scanner;

    public UserInterface(RegistrationController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Register new user");
            System.out.println("2. Modify subscription");
            System.out.println("3. Cancel subscription");
            System.out.println("4. Monitor updates");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    modifySubscription();
                    break;
                case 3:
                    cancelSubscription();
                    break;
                case 4:
                    monitorUpdates();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void registerUser() {
        System.out.println("\nEnter user ID:");
        int userId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Enter frequency (in seconds):");
        int frequency = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter preferred communication channel (e.g., email, SMS):");
        String communicationChannel = scanner.nextLine();

        NotificationPreferences preferences = new NotificationPreferences(frequency, communicationChannel);
        User user = new User(userId, username, email, password, preferences);

        System.out.println("Enter website URL to monitor:");
        String url = scanner.nextLine();
        Website website = new Website(url);

        controller.registerUser(user, website);
        System.out.println("User registered successfully.");
    }

    private void modifySubscription() {
        System.out.println("\nEnter user ID:");
        int userId = Integer.parseInt(scanner.nextLine());

        // User objesini bul
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Enter new website URL to monitor:");
        String url = scanner.nextLine();
        Website newWebsite = new Website(url);

        // Controller'a User objesini ve yeni Website objesini iletebiliriz.
        controller.modifySubscription(user, newWebsite);
        System.out.println("Subscription modified successfully.");
    }

    private void cancelSubscription() {
        System.out.println("\nEnter user ID:");
        int userId = Integer.parseInt(scanner.nextLine());

        // User objesini bul
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        // Controller'a User objesini iletebiliriz.
        controller.cancelSubscription(user);
        System.out.println("Subscription cancelled successfully.");
    }

    private void monitorUpdates() {
        System.out.println("\nEnter user ID:");
        int userId = Integer.parseInt(scanner.nextLine());

        User user = WebsiteMonitorSystem.findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        // Start monitoring updates for the user
        System.out.println("Monitoring updates for user " + user.getUsername() + ". Press 'Enter' to return to the main menu.");
        WebsiteMonitorSystem.startMonitoringForUser(userId);

        // Wait for user to press Enter to return to main menu
        scanner.nextLine();  // Wait for user to press Enter

        // Stop monitoring updates for the user
        WebsiteMonitorSystem.stopMonitoringForUser(userId);
    }



}
