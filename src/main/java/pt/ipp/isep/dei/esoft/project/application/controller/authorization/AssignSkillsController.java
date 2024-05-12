/**
 * The AssignSkillsController class is responsible for managing the assignment of skills to collaborators.
 * It interacts with the CollaboratorRepository to retrieve and update collaborator data.
 *
 * @author [Alexandre]
 */

package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;

import java.util.List;

public class AssignSkillsController {

    private final CollaboratorRepository collaboratorRepository;

    /**
     * Constructs an AssignSkillsController with a CollaboratorRepository instance.
     */
    public AssignSkillsController() {
        this.collaboratorRepository = new CollaboratorRepository();
    }

    /**
     * Assigns skills to a collaborator.
     *
     * @param name   The name of the collaborator.
     * @param skills The list of skills to assign.
     * @return True if the skills are assigned successfully, false otherwise.
     */
    public boolean assignSkills(String name, List<String> skills) {
        // Check if the collaborator exists
        Collaborator collaborator = collaboratorRepository.getCollaboratorByName(name);
        if (collaborator == null) {
            System.out.println("Collaborator with the provided email does not exist!");
            return false;
        }

        // Assign the skills to the collaborator
        collaborator.setSkills(skills);
        collaboratorRepository.updateCollaborator(collaborator);
        return true;
    }
}


