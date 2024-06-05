package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a repository for managing GreenSpace objects.
 */
public class GreenSpaceRepository {
    /**
     * The list of GreenSpace objects stored in the repository.
     */
    private static List<GreenSpace> greenSpaces = new ArrayList<>();

    /**
     * Adds a GreenSpace object to the repository.
     *
     * @param greenSpace the GreenSpace object to be added
     */
    /**
     * Adds a GreenSpace object to the repository.
     *
     * @param greenSpace the GreenSpace object to be added
     */
    public void addGreenSpace(GreenSpace greenSpace) {
        if (greenSpace == null) {
            throw new NullPointerException("GreenSpace cannot be null");
        }
        if (containsGreenSpace(greenSpace)) {
            throw new IllegalArgumentException("Duplicate GreenSpace cannot be added");
        }
        greenSpaces.add(greenSpace);
    }

    /**
     * Checks if a GreenSpace object exists in the repository.
     *
     * @param greenSpace the GreenSpace object to check for
     * @return true if the GreenSpace object exists in the repository, false otherwise
     */
    private boolean containsGreenSpace(GreenSpace greenSpace) {
        return greenSpaces.stream()
                .anyMatch(gs -> gs.equals(greenSpace));
    }

    /**
     * Retrieves all GreenSpace objects stored in the repository.
     *
     * @return a list of all GreenSpace objects stored in the repository
     */
    public static List<GreenSpace> getGreenSpaces() {
        return new ArrayList<>(greenSpaces);
    }

    /**
     * Retrieves a list of GreenSpace objects associated with a specific user email.
     *
     * @param userEmail the email address of the user to retrieve GreenSpaces for
     * @return a list of GreenSpace objects associated with the specified user email
     */
    public List<GreenSpace> findByUserEmail(String userEmail) {
        List<GreenSpace> userGreenSpaces = new ArrayList<>();
        for (GreenSpace greenSpace : greenSpaces) {
            if (greenSpace.getEmail().equals(userEmail)) {
                userGreenSpaces.add(greenSpace);
            }
        }
        return userGreenSpaces;
    }

    /**
     * Clears all GreenSpace objects from the repository.
     */
    public void clear() {
        greenSpaces.clear();
    }
}
