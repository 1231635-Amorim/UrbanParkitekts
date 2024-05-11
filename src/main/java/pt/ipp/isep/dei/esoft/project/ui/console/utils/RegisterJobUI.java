package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.RegisterJobController;

import java.util.Scanner;

public class RegisterJobUI implements Runnable {

    private final RegisterJobController controller;

    public RegisterJobUI() {
        this.controller = new RegisterJobController();
    }

    public void run() {
        System.out.println("\n\n--- Register Job -------------------------");

        String jobName = requestJobName();

        boolean success = controller.registerJob(jobName);

        if (success) {
            System.out.println("\nJob successfully registered!");
        } else {
            System.out.println("\nFailed to register job!");
        }
    }

    private String requestJobName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter job name: ");
        return input.nextLine();
    }
}

