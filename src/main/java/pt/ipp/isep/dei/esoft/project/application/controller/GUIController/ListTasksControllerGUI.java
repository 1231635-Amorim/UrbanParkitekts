package pt.ipp.isep.dei.esoft.project.application.controller.GUIController;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.project.ui.gui.ControllerWithEmail;
import pt.ipp.isep.dei.esoft.project.ui.gui.GsmUIApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.collections.FXCollections;

/**
 * Controller class for managing the list of tasks GUI.
 */
public class ListTasksControllerGUI implements ControllerWithEmail {

    @FXML
    private TextField startDateField;

    @FXML
    private TextArea taskListArea;

    @FXML
    private TextField endDateField;

    @FXML
    private ComboBox<String> statusComboBox;

    private String userEmail;

    /**
     * Sets the user email.
     *
     * @param userEmail The user email to be set.
     */
    @Override
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Initializes the list tasks GUI.
     */
    public void initialize() {
        statusComboBox.setItems(FXCollections.observableArrayList(
                "All", "Planned", "Postponed", "Canceled", "Done"
        ));
        statusComboBox.getSelectionModel().selectFirst();
        setUserEmail(GsmUIApplication.getUserEmail());
        handleListTasks();
    }

    /**
     * Handles the action of listing tasks based on user input.
     */
    @FXML
    private void handleListTasks() {
        String startDateStr = startDateField.getText();
        String endDateStr = endDateField.getText();
        String status = statusComboBox.getValue();

        if (startDateStr.isEmpty() || endDateStr.isEmpty()) {
            taskListArea.setText("Please enter valid start and end dates.");
            return;
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate;
        LocalDate endDate;
        try {
            startDate = LocalDate.parse(startDateStr, dateFormatter);
            endDate = LocalDate.parse(endDateStr, dateFormatter);

            if (endDate.isBefore(startDate)) {
                taskListArea.setText("End date must be after start date.");
                return;
            }
        } catch (DateTimeParseException e) {
            taskListArea.setText("Invalid date format. Please enter dates in the format DD-MM-YYYY.");
            return;
        }

        displayTasks(startDate, endDate, status);
    }

    /**
     * Displays tasks based on the specified date range and status.
     *
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @param status    The status of the tasks to display.
     */
    public void displayTasks(LocalDate startDate, LocalDate endDate, String status) {
        // Implementation goes here
    }

    /**
     * Checks if a given date is within a specified date range.
     *
     * @param date      The date to check.
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @return True if the date is within the range, false otherwise.
     */
    private boolean isWithinDateRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return (date.isEqual(startDate) || date.isAfter(startDate)) &&
                (date.isEqual(endDate) || date.isBefore(endDate));
    }
}
