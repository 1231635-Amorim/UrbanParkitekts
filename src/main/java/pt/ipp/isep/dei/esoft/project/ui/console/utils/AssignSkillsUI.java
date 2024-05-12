/**
 * The AssignSkillsUI class provides a console-based user interface for assigning skills to collaborators.
 * It interacts with the AssignSkillsController to perform the assignment.
 * Users can input the name of the collaborator and the skills to assign.
 *
 * @author [Alexandre]
 */

package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AssignSkillsController;

import java.util.List;
import java.util.Scanner;

public class AssignSkillsUI implements Runnable {

    private final AssignSkillsController controller;

    /**
     * Constructs an AssignSkillsUI with an AssignSkillsController instance.
     */
    public AssignSkillsUI() {
        this.controller = new AssignSkillsController();
    }

    /**
     * Runs the user interface for assigning skills to a collaborator.
     */
    public void run() {
        System.out.println("\n\n--- Assign Skills to Collaborator ---------");

        // Requests collaborator name and skills from the user
        String collaboratorName = requestCollaboratorName();
        List<String> skills = requestSkills();

        // Calls the controller to assign the skills to the collaborator
        boolean success = controller.assignSkills(collaboratorName, skills);

        // Displays the result of the skill assignment operation
        if (success) {
            System.out.println("\nSkills successfully assigned to collaborator!");
        } else {
            System.out.println("\nFailed to assign skills to collaborator!");
        }
    }

    /**
     * Requests the name of the collaborator from the user.
     *
     * @return The name of the collaborator input by the user.
     */
    private String requestCollaboratorName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter collaborator name: ");
        return input.nextLine();
    }

    /**
     * Requests the skills to be assigned from the user.
     *
     * @return A list of skills input by the user.
     */
    private List<String> requestSkills() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter skills (separated by comma): ");
        String skillsInput = input.nextLine();
        String[] skillsArray = skillsInput.split(",");
        return List.of(skillsArray);
    }
}

