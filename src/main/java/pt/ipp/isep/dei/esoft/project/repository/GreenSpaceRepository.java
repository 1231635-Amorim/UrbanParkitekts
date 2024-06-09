package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GreenSpaceRepository {

    private static final List<GreenSpace> greenSpaces = new ArrayList<>();
    private static String sortingAlgorithm;

    static {
        loadConfiguration();
    }

    private static void loadConfiguration() {
        try (InputStream input = GreenSpaceRepository.class.getClassLoader().getResourceAsStream("sorting_config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.err.println("Unable to find sorting configuration file. Using default sorting algorithm.");
                sortingAlgorithm = "DEFAULT";
                return;
            }
            prop.load(input);
            sortingAlgorithm = prop.getProperty("sorting_algorithm");
        } catch (IOException ex) {
            System.err.println("Error loading sorting configuration file. Using default sorting algorithm.");
            sortingAlgorithm = "DEFAULT";
        }
    }

    public void addGreenSpace(GreenSpace greenSpace) {
        if (greenSpace == null) {
            throw new NullPointerException("GreenSpace cannot be null");
        }
        if (containsGreenSpace(greenSpace)) {
            throw new IllegalArgumentException("Duplicate GreenSpace cannot be added");
        }
        if (greenSpace.getAreaInHectares() <= 0) {
            throw new IllegalArgumentException("Invalid GreenSpace area");
        }
        greenSpaces.add(greenSpace);
    }

    public List<GreenSpace> getGreenSpaces() {
        return new ArrayList<>(greenSpaces); // Return a copy to prevent direct modification of the repository
    }

    public List<GreenSpace> getGreenSpacesByUserEmail(String userEmail) {
        List<GreenSpace> userGreenSpaces = new ArrayList<>();
        for (GreenSpace greenSpace : greenSpaces) {
            if (greenSpace.getEmail().equals(userEmail)) {
                userGreenSpaces.add(greenSpace);
            }
        }
        return userGreenSpaces;
    }

    private boolean containsGreenSpace(GreenSpace greenSpace) {
        return greenSpaces.contains(greenSpace);
    }

    public void clear() {
        greenSpaces.clear();
    }
}
