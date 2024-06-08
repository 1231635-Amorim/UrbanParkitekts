package pt.ipp.isep.dei.esoft.project.application.controller.GUIController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.ControllerWithEmail;

import java.io.IOException;

/**
 * Controller class for managing the collaborator UI menu GUI.
 */
public class CollaboratorUIMenuControllerGUI implements ControllerWithEmail {

    @FXML
    private Label emailLabel;

    private String userEmail;

    /**
     * Sets the user email.
     *
     * @param userEmail The user email to be set.
     */
    @Override
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        emailLabel.setText(userEmail);
    }

    /**
     * Handles the action of listing tasks.
     */
    @FXML
    private void handleListTasks() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ListTasks.fxml"));
            Parent root = loader.load();

            ListTasksControllerGUI controller = loader.getController();
            controller.setUserEmail(userEmail);

            Stage stage = (Stage) emailLabel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("List Tasks");
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the List Tasks form.");
            e.printStackTrace();
        }
    }

    /**
     * Handles the action of changing task status.
     */
    @FXML
    private void handleChangeTaskStatus() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ChangeTaskStatusCollaborator.fxml"));
            Parent root = loader.load();

            ChangeTaskStatusCollaboratorGUI controller = loader.getController();
            controller.setUserEmail(userEmail);

            Stage stage = (Stage) emailLabel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Change Task Status");
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the Change Task Status form.");
            e.printStackTrace();
        }
    }

    /**
     * Displays an alert dialog.
     *
     * @param alertType The type of the alert.
     * @param title     The title of the alert.
     * @param message   The message of the alert.
     */
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
