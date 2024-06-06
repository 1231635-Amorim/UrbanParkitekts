/**
 * The GenerateTeamProposalController class is responsible for generating team proposals
 * based on specified criteria such as team size and required skills.
 * It ensures that valid parameters are provided for generating the proposal.
 *
 * @author [Kevin]
 */

package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.TeamProposal;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TeamProposalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateTeamProposalController {

    private final TeamProposalRepository teamProposalRepository;
    private final CollaboratorRepository collaboratorRepository;

    public GenerateTeamProposalController() {
        this.teamProposalRepository = Repositories.getInstance().getTeamProposalRepository();
        this.collaboratorRepository = Repositories.getInstance().getCollaboratorRepository();
    }

    public boolean generateTeamProposal(int maxSize, int minSize, String[] requiredSkills) {
        List<Collaborator> collaborators = collaboratorRepository.getCollaborators();

        // Filtra colaboradores que possuem as habilidades necessárias
        List<Collaborator> matchingCollaborators = new ArrayList<>();
        for (Collaborator collaborator : collaborators) {
            if (collaborator.hasSkills(requiredSkills)) {
                matchingCollaborators.add(collaborator);
            }
        }

        if (matchingCollaborators.size() >= minSize && matchingCollaborators.size() <= maxSize) {
            TeamProposal teamProposal = new TeamProposal(maxSize, minSize, List.of(requiredSkills), matchingCollaborators);
            teamProposalRepository.add(teamProposal);
            return true;
        }
        return false;
    }

    public List<TeamProposal> getAllTeamProposals() {
        return teamProposalRepository.getAll();
    }
}



