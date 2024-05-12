/**
 * The GenerateTeamProposalUI class provides a console-based user interface for generating team proposals.
 * It interacts with the GenerateTeamProposalController to generate the proposal.
 * Users can input the minimum and maximum team size, as well as the required skills.
 *
 * @author [Kevin]
 */

package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.GenerateTeamProposalController;

import java.util.Scanner;

public class GenerateTeamProposalUI implements Runnable {

    private final GenerateTeamProposalController controller;

    /**
     * Constructs a GenerateTeamProposalUI with a GenerateTeamProposalController instance.
     */
    public GenerateTeamProposalUI() {
        this.controller = new GenerateTeamProposalController();
    }

    /**
     * Runs the user interface for generating team proposals.
     */
    public void run() {
        System.out.println("\n\n--- Generate Team Proposal ----------------");

        int minTeamSize = requestMinTeamSize();
        int maxTeamSize = requestMaxTeamSize();
        String[] skills = requestSkills();

        String teamProposal = controller.generateTeamProposal(minTeamSize, maxTeamSize, skills);

        System.out.println("\nGenerated Team Proposal:");
        System.out.println(teamProposal);
    }

    /**
     * Requests the minimum team size from the user.
     *
     * @return The minimum team size input by the user.
     */
    private int requestMinTeamSize() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter minimum team size: ");
        return input.nextInt();
    }

    /**
     * Requests the maximum team size from the user.
     *
     * @return The maximum team size input by the user.
     */
    private int requestMaxTeamSize() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter maximum team size: ");
        return input.nextInt();
    }

    /**
     * Requests the skills required for the team from the user.
     *
     * @return An array of skills input by the user.
     */
    private String[] requestSkills() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter skills separated by semicolon (;): ");
        String skillsInput = input.nextLine();

        String[] skills = skillsInput.split(";");

        for (int i = 0; i < skills.length; i++) {
            skills[i] = skills[i].trim();
        }

        return skills;
    }
}
