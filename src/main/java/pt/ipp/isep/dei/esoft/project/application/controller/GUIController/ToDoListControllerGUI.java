package pt.ipp.isep.dei.esoft.project.application.controller.GUIController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.ToDoController;
import pt.ipp.isep.dei.esoft.project.ui.gui.ControllerWithEmail;
import pt.ipp.isep.dei.esoft.project.ui.gui.GsmUIApplication;
import pt.ipp.isep.dei.esoft.project.ui.gui.SceneSwitcher;

import java.io.IOException;
import java.util.List;

/**
 * The ToDoListControllerGUI class represents the controller for managing the To-Do list in the GUI.
 */
public class ToDoListControllerGUI implements ControllerWithEmail {

    @FXML
    private ListView<String> toDoListView;

    private String userEmail;

    /**
     * Sets the email of the current user.
     *
     * @param userEmail the email of the current user
     */
    @Override
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Retrieves the email of the current user.
     *
     * @return the email of the current user
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Initializes the controller.
     */
    public void initialize() {
        setUserEmail(GsmUIApplication.getUserEmail());
        displayToDoList();
    }

    private void displayToDoList() {
        ToDoController controller = new ToDoController();
        List<String> toDoLists = controller.getAllToDoListEntries();

        if (toDoLists.isEmpty()) {
            showAlert(Alert.AlertType.INFORMATION, "Information", "No To-Do list entries registered.");
        } else {
            for (String toDoList : toDoLists) {
                if (toDoList.contains(getUserEmail())) {
                    toDoListView.getItems().add(toDoList);
                }
            }
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Handles the event of adding a new entry to the To-Do list.
     *
     * @param event the ActionEvent representing the event
     */
    @FXML
    private void handleAddEntryAction(ActionEvent event) {
        try {
            SceneSwitcher.switchToScene("/fxml/AddToDoListEntry.fxml", "Add New To-Do List Entry", (Node) event.getSource(), userEmail);
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the Add New To-Do List Entry form.");
        }
    }

    /**
     * Handles the event of listing all entries in the To-Do list.
     *
     * @param event the ActionEvent representing the event
     */
    @FXML
    private void handleListToDoEntriesAction(ActionEvent event) {
        try {
            SceneSwitcher.switchToScene("/fxml/ListToDoEntries.fxml", "List To-Do List Entries", (Node) event.getSource(), userEmail);
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the To-Do List Entries form.");
        }
    }

    /**
     * Handles the event of navigating back to the previous scene.
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
