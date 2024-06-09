package pt.ipp.isep.dei.esoft.project.application.controller.GUIController;

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

public class ListToDoListEntriesControllerGUI implements ControllerWithEmail {

    @FXML
    private ListView<String> toDoListView;

    private String userEmail;

    @Override
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String retrieveUserEmail() {
        return userEmail;
    }

    public void initialize() {
        setUserEmail(GsmUIApplication.getUserEmail());
        loadToDoListEntries();
    }

    private void loadToDoListEntries() {
        ToDoController controller = new ToDoController();
        List<String> toDoEntries = controller.getAllToDoListEntries();

        if (toDoEntries.isEmpty()) {
            displayAlert(Alert.AlertType.INFORMATION, "Information", "No To-Do list entries available.");
        } else {
            for (String entry : toDoEntries) {
                if (entry.contains(retrieveUserEmail())) {
                    toDoListView.getItems().add(entry);
                }
            }
        }
    }

    private void displayAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void handleBack(javafx.event.ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchToScene("/fxml/GsmUIMenu.fxml", "Register Green Space", (Node) actionEvent.getSource(), userEmail);
        } catch (IOException e) {
            displayAlert(Alert.AlertType.ERROR, "Error", "Unable to load the Main Menu.");
        }
    }
}
