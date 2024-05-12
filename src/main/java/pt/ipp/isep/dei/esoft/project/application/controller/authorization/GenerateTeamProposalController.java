/**
 * The GenerateTeamProposalController class is responsible for generating team proposals
 * based on specified criteria such as team size and required skills.
 * It ensures that valid parameters are provided for generating the proposal.
 *
 * @author [Kevin]
 */

package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import java.util.List;
import java.util.Random;

public class GenerateTeamProposalController {

    /**
     * Generates a team proposal with random skills.
     *
     * @param minTeamSize The minimum size of the team.
     * @param maxTeamSize The maximum size of the team.
     * @param skills      The array of skills to be included in the proposal.
     * @return A string representing the generated team proposal.
     * @throws IllegalArgumentException if the parameters are invalid.
     */
    public String generateTeamProposal(int minTeamSize, int maxTeamSize, String[] skills) {
        if (minTeamSize <= 0 || minTeamSize > maxTeamSize || minTeamSize > skills.length) {
            throw new IllegalArgumentException("Invalid parameters for generating team proposal.");
        }

        Random random = new Random();
        int teamSize = random.nextInt(maxTeamSize - minTeamSize + 1) + minTeamSize;

        StringBuilder teamProposal = new StringBuilder();
        for (int i = 0; i < teamSize; i++) {
            int randomSkillIndex = random.nextInt(skills.length);
            teamProposal.append(skills[randomSkillIndex]);
            if (i < teamSize - 1) {
                teamProposal.append("; "); // Add semicolon to separate skills
            }
        }

        return teamProposal.toString();
    }
}


