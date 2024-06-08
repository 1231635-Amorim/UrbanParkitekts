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

    /**
     * Checks if the provided taxpayer number is already associated with another collaborator.
     *
     * @param taxpayerNumber The taxpayer number to check.
     * @return True if the taxpayer number is duplicate, false otherwise.
     */
    public boolean isTaxpayerNumberDuplicate(int taxpayerNumber) {
        return collaborators.stream()
                .anyMatch(collaborator -> collaborator.getTaxpayerNumber() == taxpayerNumber);
    }

    /**
     * Checks if the provided identification number is already associated with another collaborator.
     *
     * @param biNumber The identification number to check.
     * @return True if the identification number is duplicate, false otherwise.
     */
    public boolean isBINumberDuplicate(long biNumber) {
        return collaborators.stream()
                .anyMatch(collaborator -> collaborator.getBINumber() == biNumber);
    }

    public void updateCollaborator(Collaborator collaborator) {
    }
    public static String getCollaboratorbyName(String name){
        return name;
    }

    public List<Collaborator> getCollaborators() {return collaborators;
    }
}
