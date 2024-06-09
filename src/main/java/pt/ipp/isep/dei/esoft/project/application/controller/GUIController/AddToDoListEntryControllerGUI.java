package pt.ipp.isep.dei.esoft.project.application.controller.GUIController;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.ToDoController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.ui.gui.ControllerWithEmail;
import pt.ipp.isep.dei.esoft.project.ui.gui.GsmUIApplication;
import pt.ipp.isep.dei.esoft.project.ui.gui.SceneSwitcher;

import java.io.IOException;
import java.util.List;

/**
 * This controller manages the GUI for adding entries to the To-Do list.
 */
public class AddToDoListEntryControllerGUI implements ControllerWithEmail {

    @FXML
    private TextField taskDescriptionField;

    @FXML
    private ChoiceBox<String> urgencyChoiceBox;

    @FXML
    private TextField durationField;

    @FXML
    private ChoiceBox<String> greenSpaceChoiceBox;

    @FXML
    private Label feedbackLabel;

    private ToDoController toDoController;
    private String userEmail;

    /**
     * Initializes the controller, setting up necessary data.
     */
    public void initialize() {
        userEmail = GsmUIApplication.getUserEmail();
        setupGreenSpaceChoices();
        urgencyChoiceBox.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));
    }

    /**
     * Sets the email of the current user.
     *
     * @param email the email of the current user
     */
    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    private void setupGreenSpaceChoices() {
        RegisterGreenSpaceController greenSpaceController = new RegisterGreenSpaceController();
        List<GreenSpace> greenSpaces = greenSpaceController.getAllGreenSpaces();
        boolean hasGreenSpaces = false;

        for (GreenSpace greenSpace : greenSpaces) {
            if (greenSpace.getEmail().equals(userEmail)) {
                greenSpaceChoiceBox.getItems().add(greenSpace.getName());
                hasGreenSpaces = true;
            }
        }

        if (!hasGreenSpaces) {
            feedbackLabel.setText("No green spaces registered for this user.");
            greenSpaceChoiceBox.setDisable(true);
        } else {
            feedbackLabel.setText("");
            greenSpaceChoiceBox.setDisable(false);
        }
    }

    /**
     * Handles the event of adding a new entry to the to-do list.
     *
     * @param event the ActionEvent representing the event
     */
    @FXML
    private void handleAddEntry(ActionEvent event) {
        String taskDescription = taskDescriptionField.getText().trim();
        String urgency = urgencyChoiceBox.getValue();
        String durationText = durationField.getText().trim();
        String selectedGreenSpace = greenSpaceChoiceBox.getValue();
        String regex = "^[a-zA-Z\\s]+$";

        if (taskDescription.isEmpty() || urgency == null || durationText.isEmpty() || selectedGreenSpace == null) {
            feedbackLabel.setText("Please fill in all fields with valid data.");
            return;
        }

        if (!taskDescription.matches(regex)) {
            feedbackLabel.setText("Task description can only contain letters and spaces.");
            return;
        }

        int duration;
        try {
            duration = Integer.parseInt(durationText);
            if (duration <= 0) {
                feedbackLabel.setText("Please enter a positive duration.");
                return;
            }
        } catch (NumberFormatException e) {
            feedbackLabel.setText("Please enter a numeric duration.");
            return;
        }

        toDoController.addToDoEntry(urgency, null, (long) duration, taskDescription, userEmail, selectedGreenSpace);
        showAlert(Alert.AlertType.INFORMATION, "Success", "To-Do List entry added successfully.");
    }

    /**
     * Assigns the ToDoController to this controller.
     *
     * @param toDoController the ToDoController to assign
     */
    public void setToDoController(ToDoController toDoController) {
        this.toDoController = toDoController;
    }

    /**
     * Displays an alert dialog with the given parameters.
     *
     * @param alertType the type of alert to display
     * @param title the title of the alert
     * @param message the content of the alert
     */
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Handles the action of navigating back to the previous screen.
     *
     * @param actionEvent the ActionEvent representing the event
     */
    @FXML
    public void handleBack(ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchToScene("/fxml/GsmUIMenu.fxml", "Register Green Space", (Node) actionEvent.getSource(), userEmail);
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the Main Menu.");
        }
    }
}
