package pt.ipp.isep.dei.esoft.project.application.controller.GUIController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.ControllerWithEmail;

import java.io.IOException;

public class GsmUIMenuControllerGUI implements ControllerWithEmail {

    @FXML
    private Label emailLabel;

    private String userEmail;

    /**
     * Sets the user email and updates the email label.
     *
     * @param userEmail The email of the user.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        emailLabel.setText(userEmail);
    }

    @FXML
    private void handleRegisterGreenSpace(ActionEvent event) {
        loadScene(event, "/fxml/RegisterGreenSpace.fxml", "Register Green Space", new RegisterGreenSpaceControllerGUI());
    }

    @FXML
    private void handleListGreenSpaces(ActionEvent event) {
        loadScene(event, "/fxml/ListGreenSpaces.fxml", "List Green Spaces", new ListGreenSpacesControllerGUI());
    }

    /**
     * Loads a new scene from an FXML file and sets the user email on the controller.
     *
     * @param event         The action event triggering the scene change.
     * @param fxmlFile      The path to the FXML file.
     * @param title         The title of the new scene.
     * @param controllerClass The class of the controller to set the user email.
     */
    private void loadScene(ActionEvent event, String fxmlFile, String title, ControllerWithEmail controllerClass) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            ControllerWithEmail controller = loader.getController();
            controller.setUserEmail(userEmail);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the " + title + " form.");
            e.printStackTrace();
        }
    }

    /**
     * Displays an alert with the specified title.
     *
     * @param title The title of the alert.
     */
    private void showAlert(String title) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(title + " button clicked!");
        alert.showAndWait();
    }

    /**
     * Displays an alert with the specified type, title, and message.
     *
     * @param alertType The type of the alert.
     * @param title     The title of the alert.
     * @param message   The message to display in the alert.
     */
    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
