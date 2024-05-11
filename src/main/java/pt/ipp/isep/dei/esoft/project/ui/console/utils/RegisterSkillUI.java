package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.RegisterSkillsController;

import java.util.Scanner;

public class RegisterSkillUI implements Runnable {

    private final RegisterSkillsController controller;

    public RegisterSkillUI() {
        this.controller = new RegisterSkillsController();
    }

    public void run() {
        System.out.println("\n\n--- Register Skills ----------------------");

        String skillName = requestSkillName();
        String skillDescription = requestSkillDescription();

        boolean success = controller.registerSkill(skillName, skillDescription);

        if (success) {
            System.out.println("\nSkill successfully registered!");
        } else {
            System.out.println("\nFailed to register skill!");
        }
    }

    private String requestSkillName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter skill name: ");
        return input.nextLine();
    }

    private String requestSkillDescription() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter skill description: ");
        return input.nextLine();
    }
}

