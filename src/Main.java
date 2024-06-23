import system.WebsiteMonitorSystem;
import controller.RegistrationController;
import view.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WebsiteMonitorSystem system = new WebsiteMonitorSystem();
        RegistrationController controller = new RegistrationController(system);


        UserInterface userInterface = new UserInterface(controller);


        Scanner scanner = new Scanner(System.in);


        userInterface.start();


        scanner.close();
    }
}
