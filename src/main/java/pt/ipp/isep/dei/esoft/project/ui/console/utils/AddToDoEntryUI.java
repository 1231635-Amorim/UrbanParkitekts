package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.ToDoController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;

import java.util.List;
import java.util.Scanner;

public class AddToDoEntryUI implements Runnable {
    private final Scanner scanner;
    private final String userEmail;
    private final ToDoController controller;

    public AddToDoEntryUI(String userEmail) {
        this.userEmail = userEmail;
        this.scanner = new Scanner(System.in);
        this.controller = new ToDoController();
    }

    @Override
    public void run() {
        List<GreenSpace> greenSpaces = controller.getGreenSpacesByUserEmail(userEmail);
        if (greenSpaces.isEmpty()) {
            System.out.println("No green spaces available.");
            return;
        }

        System.out.println("\n--- Add To-Do Entry ---");
        System.out.print("Enter the task of the to-do entry: ");
        String task = scanner.nextLine();

        System.out.println("\n--- Add To-Do Entry ---");
        System.out.print("Enter the urgency of the to-do entry: ");
        String urgency = scanner.nextLine();

        System.out.println("\n--- Add To-Do Entry ---");
        System.out.print("Enter the duration of the to-do entry in seconds: ");
        Long duration = scanner.nextLong();

        System.out.println("Select green space for the to-do entry:");
        for (int i = 0; i < greenSpaces.size(); i++) {
            System.out.println((i + 1) + ". " + greenSpaces.get(i).getName());
        }

        int greenSpaceChoice = scanner.nextInt();
        if (greenSpaceChoice < 1 || greenSpaceChoice > greenSpaces.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        GreenSpace selectedGreenSpace = greenSpaces.get(greenSpaceChoice - 1);
        controller.addToDoEntry(urgency, selectedGreenSpace, duration,task);
        System.out.println("To-Do entry added successfully.");
    }
}
