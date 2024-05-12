package pt.ipp.isep.dei.esoft.project.application.controller.authorization;


import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;

import java.util.List;
public class AssignSkillsController {

    private final CollaboratorRepository collaboratorRepository;

    public AssignSkillsController() {
        this.collaboratorRepository = new CollaboratorRepository();
    }

    public boolean assignSkills(String name, List<String> skills) {
        // Verifica se o colaborador existe
        Collaborator collaborator = collaboratorRepository.getCollaboratorByName(name);
        if (collaborator == null) {
            System.out.println("Collaborator with the provided email does not exist!");
            return false;
        }

        // Atribui as habilidades ao colaborador
        collaborator.setSkills(skills);
        collaboratorRepository.updateCollaborator(collaborator);
        return true;
    }

}

