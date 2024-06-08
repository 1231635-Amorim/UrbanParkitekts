package pt.ipp.isep.dei.esoft.project.application.controller.GUIController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.ControllerWithEmail;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * GUI controller for changing the status of tasks assigned to a collaborator.
 */
public class ChangeTaskStatusCollaboratorGUI implements ControllerWithEmail {

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button doneButton;

    private String userEmail;

    /**
     * Initializes the controller. Loads tasks assigned to the user.
     */
    @FXML
    public void initialize() {

    }

    /**
     * Sets the email of the user and reloads the tasks assigned to the user.
     *
     * @param email the email of the user
     */
    @Override
    public void setUserEmail(String email) {
        this.userEmail = email;
        loadUserTasks();  // Reload tasks when user email is set
    }

    /**
     * Loads tasks assigned to the logged-in user with status "Planned" and populates the ChoiceBox.
     */
    private void loadUserTasks() {
        // ...
    }
    /**
     * Handles the action of marking a selected task as "Done".
     */
    @FXML
    private void handleDoneStatus() {
        // ...
    }

    /**
     * Handles the action of navigating back to the Collaborator menu.
     */
    @FXML
    private void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CollaboratorUIMenu.fxml"));
            Parent root = loader.load();

            CollaboratorUIMenuControllerGUI controller = loader.getController();
            controller.setUserEmail(userEmail);

            Stage stage = (Stage) choiceBox.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Collaborator Menu");
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the Collaborator Menu. " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Displays an alert with the given title and message.
     *
     * @param alertType the type of the alert
     * @param title     the title of the alert
     * @param message   the message of the alert
     */
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}