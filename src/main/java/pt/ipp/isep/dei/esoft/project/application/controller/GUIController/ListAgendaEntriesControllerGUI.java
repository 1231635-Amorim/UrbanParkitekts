package pt.ipp.isep.dei.esoft.project.application.controller.GUIController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AgendaController;
import pt.ipp.isep.dei.esoft.project.domain.AgendaEntry;
import pt.ipp.isep.dei.esoft.project.ui.gui.ControllerWithEmail;
import pt.ipp.isep.dei.esoft.project.ui.gui.SceneSwitcher;

import java.io.IOException;
import java.util.List;

/**
 * The ListAgendaEntriesControllerGUI class represents the controller for listing agenda entries in the GUI.
 */
public class ListAgendaEntriesControllerGUI implements ControllerWithEmail {

    private String userEmail;
    private AgendaController agendaController;

    @FXML
    private ListView<AgendaEntry> agendaListView;

    /**
     * Sets the user's email.
     *
     * @param userEmail the email of the user
     */
    @Override
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Initializes the controller.
     */
    public void initialize() {
        agendaController = new AgendaController();
        List<AgendaEntry> agendaEntries = agendaController.getAllAgendaEntries();
        if (agendaEntries.isEmpty()) {
        } else {
            ObservableList<AgendaEntry> items = FXCollections.observableArrayList(agendaEntries);
            agendaListView.setItems(items);
        }
    }

    /**
     * Handles the event of clicking the "Back" button.
     *
     * @param actionEvent the ActionEvent representing the event
     */
    @FXML
    public void handleBack(javafx.event.ActionEvent actionEvent) {
        try {
            SceneSwitcher.switchToScene("/fxml/GsmUIMenu.fxml", "Register Green Space", (Node) actionEvent.getSource(), userEmail);
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the Main Menu.");
        }
    }

    /**
     * Shows an alert dialog with the specified type, title, and message.
     *
     * @param alertType the type of the alert dialog
     * @param title     the title of the alert dialog
     * @param message   the message of the alert dialog
     */
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
