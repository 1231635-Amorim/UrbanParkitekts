package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollaboratorRepository {

    private final List<Collaborator> collaborators;

    public CollaboratorRepository() {
        this.collaborators = new ArrayList<>();
    }

    public Optional<Collaborator> add(Collaborator collaborator) {
        
        if (collaborators.contains(collaborator)) {
            System.out.println("Collaborator with the same name already exists!");
            return Optional.empty();
        }

        collaborators.add(collaborator);
        return Optional.of(collaborator);
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
       
        return new ArrayList<>(collaborators);
    }

    public void save(Collaborator collaborator) {
    }
}

