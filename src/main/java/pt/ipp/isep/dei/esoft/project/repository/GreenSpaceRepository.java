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

    /**
     * Loads the configuration for the sorting algorithm from a properties file.
     */
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

    /**
     * Adds a green space to the repository.
     *
     * @param greenSpace the green space to add
     * @throws NullPointerException if the green space is null
     * @throws IllegalArgumentException if the green space is a duplicate
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
     * Retrieves the list of green spaces, sorted according to the configured sorting algorithm.
     *
     * @return a sorted list of green spaces
     */
    public List<GreenSpace> getGreenSpaces() {
        List<GreenSpace> sortedGreenSpaces;
        switch (sortingAlgorithm.toUpperCase()) {
            case "QUICKSORT":
                sortedGreenSpaces = quickSortByAreaDesc(new ArrayList<>(greenSpaces));
                break;
            case "BUBBLESORT":
                sortedGreenSpaces = bubbleSortByAreaDesc(new ArrayList<>(greenSpaces));
                break;
            default:
                sortedGreenSpaces = new ArrayList<>(greenSpaces);
        }
        return sortedGreenSpaces;
    }

    /**
     * Sorts the list of green spaces in descending order by area using the quicksort algorithm.
     *
     * @param list the list to sort
     * @return the sorted list
     */
    private List<GreenSpace> quickSortByAreaDesc(List<GreenSpace> list) {
        if (list.size() <= 1) {
            return list;
        }

        int pivotIndex = list.size() / 2;
        GreenSpace pivot = list.get(pivotIndex);
        List<GreenSpace> less = new ArrayList<>();
        List<GreenSpace> greater = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i == pivotIndex) {
                continue;
            }
            GreenSpace current = list.get(i);
            if (current.getAreaInHectares() >= pivot.getAreaInHectares()) {
                greater.add(current);
            } else {
                less.add(current);
            }
        }

        List<GreenSpace> sorted = new ArrayList<>();
        sorted.addAll(quickSortByAreaDesc(greater));
        sorted.add(pivot);
        sorted.addAll(quickSortByAreaDesc(less));
        return sorted;
    }

    /**
     * Sorts the list of green spaces in descending order by area using the bubblesort algorithm.
     *
     * @param list the list to sort
     * @return the sorted list
     */
    private List<GreenSpace> bubbleSortByAreaDesc(List<GreenSpace> list) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < list.size() - 1; i++) {
                GreenSpace current = list.get(i);
                GreenSpace next = list.get(i + 1);
                if (current.getAreaInHectares() < next.getAreaInHectares()) {
                    list.set(i, next);
                    list.set(i + 1, current);
                    swapped = true;
                }
            }
        } while (swapped);
        return list;
    }

    /**
     * Checks if the repository already contains the specified green space.
     *
     * @param greenSpace the green space to check
     * @return true if the green space is already in the repository, false otherwise
     */
    private boolean containsGreenSpace(GreenSpace greenSpace) {
        return greenSpaces.stream()
                .anyMatch(gs -> gs.equals(greenSpace));
    }

    /**
     * Finds all green spaces associated with the specified user email.
     *
     * @param userEmail the email of the user
     * @return a list of green spaces associated with the user
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
     * Clears all green spaces from the repository.
     */
    public void clear() {
        greenSpaces.clear();
    }
}
