package pt.ipp.isep.dei.esoft.project.ui.console.utils;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AssignSkillsController;

import java.util.List;
import java.util.Scanner;

public class AssignSkillsUI implements Runnable {

    private final AssignSkillsController controller;

    public AssignSkillsUI() {
        this.controller = new AssignSkillsController();
    }

    public void run() {
        System.out.println("\n\n--- Assign Skills to Collaborator ---------");

        // Solicita ao usuário o nome do colaborador e as habilidades a serem atribuídas
        String collaboratorEmail = requestCollaboratorName();
        List<String> skills = requestSkills();

        // Chama o controlador para atribuir as habilidades ao colaborador

        boolean success = controller.assignSkills(requestCollaboratorName(), skills);

        // Exibe o resultado da operação de atribuição de habilidades
        if (success) {
            System.out.println("\nSkills successfully assigned to collaborator!");
        } else {
            System.out.println("\nFailed to assign skills to collaborator!");
        }
    }

    private String requestCollaboratorName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter collaborator name: ");
        return input.nextLine();
    }

    private List<String> requestSkills() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter skills (separated by comma): ");
        String skillsInput = input.nextLine();
        String[] skillsArray = skillsInput.split(",");
        return List.of(skillsArray);
    }
}

