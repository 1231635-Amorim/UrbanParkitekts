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

        public GenerateTeamProposalUI() {
            controller = new GenerateTeamProposalController();
        }

        public void run() {
            System.out.println("\n\n--- Generate Team Proposal ------------------------");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter max team size: ");
            int maxSize = sc.nextInt();
            System.out.print("Enter min team size: ");
            int minSize = sc.nextInt();

            System.out.print("Enter required skills (comma separated): ");
            sc.nextLine(); // Consuming the newline character
            String skillsInput = sc.nextLine();
            String[] skills = skillsInput.split(",");

            // Implementar a lógica de geração de proposta de equipe usando o controller
            boolean success = controller.generateTeamProposal(maxSize, minSize, skills);

            if (success) {
                System.out.println("Team proposal generated successfully!");
            } else {
                System.out.println("Failed to generate team proposal.");
            }
        }
    }





