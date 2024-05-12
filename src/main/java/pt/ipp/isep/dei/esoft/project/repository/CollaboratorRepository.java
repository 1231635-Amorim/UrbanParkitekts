package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollaboratorRepository {

    private final List<Collaborator> collaborators = new ArrayList<>();

    public Collaborator add(Collaborator collaborator) {
        
        if (collaborators.contains(collaborator)) {
            System.out.println("Collaborator already exists!");
            return null;
        }

        collaborators.add(collaborator);
        return collaborator;
    }

    public Collaborator getCollaboratorByName(String name) {
        
        for (Collaborator collaborator : collaborators) {
            if (collaborator.getName().equalsIgnoreCase(name)) {
                return collaborator;
            }
        }
        return null; 
    }

    public List<Collaborator> getAllCollaborators() {
        return List.copyOf(collaborators);
    }
}

