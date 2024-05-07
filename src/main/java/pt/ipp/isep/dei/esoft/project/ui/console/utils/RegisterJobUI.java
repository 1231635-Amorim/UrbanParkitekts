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

        // Solicita ao usuário os detalhes do novo cargo
        String jobName = requestJobName();

        // Chama o controlador para registrar o novo cargo
        boolean success = controller.registerJob(jobName);

        // Exibe o resultado da operação de registro
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

