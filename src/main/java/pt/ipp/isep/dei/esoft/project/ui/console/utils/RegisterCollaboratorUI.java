package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.RegisterCollaboratorController;
import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegisterCollaboratorUI implements Runnable {
    private final RegisterCollaboratorController controller = new RegisterCollaboratorController();

    public RegisterCollaboratorUI() {

    }

    public void run() {
        System.out.println("\n\n--- Register Collaborator -------------------------");

        String name = requestStringInput("Enter name:");
        Date birthDate = requestDateInput("Enter birth date (yyyy-MM-dd):");
        Date admissionDate = new Date();
        String address = requestStringInput("Enter address:");
        String mobile = requestStringInput("Enter mobile number:");
        String email = requestStringInput("Enter email:");
        String taxpayerNumber = requestStringInput("Enter taxpayer number:");
        String idDocType = requestStringInput("Enter ID document type:");
        String idNumber = requestStringInput("Enter ID document number:");
        Job job = requestJob();

        String result = controller.registerCollaborator(name, birthDate, admissionDate, address, mobile, email,
                taxpayerNumber, idDocType, idNumber, job);

        System.out.println(result);
    }

    private String requestStringInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message + " ");
        return input.nextLine();
    }

    private Date requestDateInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message + " ");
        String dateStr = input.nextLine();
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter in yyyy-MM-dd format.");
            return requestDateInput(message);
        }
    }

    private Job requestJob() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter job name:");
        String jobName = input.nextLine();
        return new Job(jobName);
    }
}


