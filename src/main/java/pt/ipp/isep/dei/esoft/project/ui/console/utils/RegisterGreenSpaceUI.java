package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpaceType;

import java.util.List;
import java.util.Scanner;


/**
 * This class provides a user interface for registering green spaces.
 */
public class RegisterGreenSpaceUI implements Runnable {

    /**
     * The scanner used to read input from the user.
     */
    private final Scanner scanner;

    /**
     * The email address of the user who is logged in.
     */
    private final String userEmail;

    /**
     * Constructs a new RegisterGreenSpaceUI object with the specified user email.
     *
     * @param userEmail the email address of the user who is logged in
     */
    public RegisterGreenSpaceUI(String userEmail) {
        this.userEmail = userEmail;
        this.scanner = new Scanner(System.console().reader());
    }

    /**
     * Runs the user interface for registering green spaces.
     */
    public void run() {
        System.out.println("\n--- Green Space Management ---");
        System.out.println("Logged in as: " + userEmail);
        System.out.print("Enter name of the green space: ");
        String name = scanner.nextLine();

        System.out.print("Enter area of the green space in square meters: ");
        double area = scanner.nextDouble();

        System.out.println("Select type of green space:");
        System.out.println("1. Garden");
        System.out.println("2. Medium-Sized Park");
        System.out.println("3. Large-Sized Park");
        int typeChoice = scanner.nextInt();

        GreenSpaceType type;

        switch (typeChoice) {
            case 1:
                type = GreenSpaceType.GARDEN;
                break;
            case 2:
                type = GreenSpaceType.MEDIUM_SIZED_PARK;
                break;
            case 3:
                type = GreenSpaceType.LARGE_SIZED_PARK;
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        RegisterGreenSpaceController.registerGreenSpace(name, area, type, userEmail);
        System.out.println("Green space registered successfully.");

        System.out.println("\n--- Registered Green Spaces ---");
        List<GreenSpace> greenSpaces = RegisterGreenSpaceController.getAllGreenSpaces();
        for (GreenSpace greenSpace : greenSpaces) {
            greenSpace.displayDetails();
        }
    }
}
