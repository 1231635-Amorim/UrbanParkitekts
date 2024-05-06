package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.CreateSkillController;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CreateSkillUI implements Runnable {

    private final CreateSkillController controller;
    private String skillName;
    private String skillDescription;

    public CreateSkillUI() {
        controller = new CreateSkillController();
    }

    private CreateSkillController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Create Skill ------------------------");

        requestData();

        submitData();
    }

    private void submitData() {
        Optional<Skill> skill = getController().createSkill(skillName, skillDescription);

        if (skill.isPresent()) {
            System.out.println("\nSkill successfully created!");
        } else {
            System.out.println("\nSkill not created!");
        }
    }

    private void requestData() {
        //Request the Skill Name from the console
        skillName = requestSkillName();

        //Request the Skill Description from the console
        skillDescription = requestSkillDescription();
    }

    private String requestSkillDescription() {
        Scanner input = new Scanner(System.in);
        System.out.print("Skill Description: ");
        return input.nextLine();
    }

    private String requestSkillName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Skill Name: ");
        return input.nextLine();
    }
}

