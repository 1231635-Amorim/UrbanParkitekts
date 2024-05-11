package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import java.util.List;
import java.util.Random;

public class GenerateTeamProposalController {

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
                teamProposal.append("; "); // Adiciona ponto e vírgula para separar as habilidades
            }
        }

        return teamProposal.toString();
    }
}

