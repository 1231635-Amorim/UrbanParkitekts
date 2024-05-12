package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;

import java.util.List;

public class ListCollaboratorsUI implements Runnable {
    private final CollaboratorRepository collaboratorRepository = new CollaboratorRepository();

    @Override
    public void run() {
        List<Collaborator> collaborators = collaboratorRepository.getAllCollaborators();
        for (Collaborator c : collaborators) {
            System.out.println(c);
        }
    }
}
