package pt.ipp.isep.dei.esoft.project.application.controller.GUIController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.ui.gui.ControllerWithEmail;
import pt.ipp.isep.dei.esoft.project.ui.gui.GsmUIApplication;
import pt.ipp.isep.dei.esoft.project.ui.gui.SceneSwitcher;
import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.*;
import pt.ipp.isep.dei.esoft.project.config.SizeDescendingSorter;
import pt.ipp.isep.dei.esoft.project.config.NameAscendingSorter;

import java.io.IOException;
import java.util.List;

public class ListGreenSpacesControllerGUI implements ControllerWithEmail {

    @FXML
    private ChoiceBox<String> sortingAlgorithmChoiceBox;

    @FXML
    private ListView<String> greenSpaceListView;

    private String userEmail;
    private GreenSpaceSorter sortingAlgorithm;

    /**
     * Sets the user email.
     *
     * @param userEmail the email of the user
     */
    @Override
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets the user email.
     *
     * @return the email of the user
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Initializes the controller, setting up the sorting algorithm choice box and displaying green spaces.
     */
    public void initialize() {
        setUserEmail(GsmUIApplication.getUserEmail());
        setupSortingAlgorithmChoiceBox();
        displayGreenSpaces();
    }

    /**
     * Sets up the sorting algorithm choice box with available sorting options.
     */
    private void setupSortingAlgorithmChoiceBox() {
        sortingAlgorithmChoiceBox.getItems().addAll("Size Descending", "Name Ascending");
        sortingAlgorithmChoiceBox.setValue("Size Descending");
    }

    /**
     * Displays the green spaces in the list view, sorted according to the selected sorting algorithm.
     */
    private void displayGreenSpaces() {
        sortingAlgorithm = null; // Placeholder

        RegisterGreenSpaceController controller = new RegisterGreenSpaceController();
        List<GreenSpace> greenSpaces = controller.getAllGreenSpaces();

        if (sortingAlgorithm != null) {
            greenSpaces = sortingAlgorithm.sort(greenSpaces);
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Sorting algorithm not available.");
            return;
        }

        if (greenSpaces.isEmpty()) {
            showAlert(Alert.AlertType.INFORMATION, "Information", "No green spaces registered.");
        } else {
            greenSpaceListView.getItems().clear();
            for (GreenSpace greenSpace : greenSpaces) {
                if (greenSpace.getEmail().equals(getUserEmail())) {
                    greenSpaceListView.getItems().add(greenSpace.displayDetails());
                }
            }
        }
    }

    /**
     * Shows an alert dialog with the specified parameters.
     *
     * @param alertType the type of the alert
     * @param title the title of the alert
     * @param message the message of the alert
     */
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Handles the back button action, switching to the main menu scene.
     *
     * @param actionEvent the event triggered by the back button
     */
    @FXML
    public void handleBack(ActionEvent actionEvent) {
        try {
            Node source = (Node) actionEvent.getSource();
            SceneSwitcher.switchToScene("/fxml/GsmUIMenu.fxml", "Register Green Space", source, userEmail);
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the Main Menu.");
        }
    }

    /**
     * Updates the sorting algorithm based on the user's selection and refreshes the green spaces list.
     *
     * @param actionEvent the event triggered by the sorting algorithm choice box
     */
    @FXML
    public void updateSortingAlgorithm(ActionEvent actionEvent) {
        String selectedAlgorithm = sortingAlgorithmChoiceBox.getValue();
        GreenSpaceSorter sortingAlgorithm;

        switch (selectedAlgorithm) {
            case "Size Descending":
                sortingAlgorithm = new SizeDescendingSorter();
                break;
            case "Name Ascending":
                sortingAlgorithm = new NameAscendingSorter();
                break;
            default:
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid sorting algorithm selected.");
                return;
        }

        this.sortingAlgorithm = sortingAlgorithm;
        displayGreenSpaces();
    }
}
