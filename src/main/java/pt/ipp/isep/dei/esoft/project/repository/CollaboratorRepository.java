/**
 * The CollaboratorRepository class is responsible for managing the storage and retrieval of collaborator data.
 * It provides methods to add, retrieve, and get all collaborators from the repository.
 * Collaborators are stored in a list.
 *
 * @author [João Amorim]
 */

package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.util.ArrayList;
import java.util.List;

public class CollaboratorRepository {

    private final List<Collaborator> collaborators = new ArrayList<>();

    /**
     * Adds a collaborator to the repository.
     *
     * @param collaborator The collaborator to add.
     * @return The added collaborator if successful, null otherwise.
     */
    public Collaborator add(Collaborator collaborator) {
        if (collaborators.contains(collaborator)) {
            System.out.println("Collaborator already exists!");
            return null;
        }
        collaborators.add(collaborator);
        return collaborator;
    }

    /**
     * Retrieves a collaborator from the repository by name.
     *
     * @param name The name of the collaborator to retrieve.
     * @return The collaborator with the specified name, or null if not found.
     */
    public Collaborator getCollaboratorByName(String name) {
        for (Collaborator collaborator : collaborators) {
            if (collaborator.getName().equalsIgnoreCase(name)) {
                return collaborator;
            }
        }
        return null;
    }

    /**
     * Gets all collaborators from the repository.
     *
     * @return A list containing all collaborators in the repository.
     */
    public List<Collaborator> getAllCollaborators() {
        return List.copyOf(collaborators);
    }



    public void updateCollaborator(Collaborator collaborator) {
    }
    public String getCollaboratorbyName(String name){
        return name;
    }

}
