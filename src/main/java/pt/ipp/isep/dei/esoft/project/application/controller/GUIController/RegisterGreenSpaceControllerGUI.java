package pt.ipp.isep.dei.esoft.project.application.controller.GUIController;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpaceType;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.ui.gui.ControllerWithEmail;
import pt.ipp.isep.dei.esoft.project.ui.gui.SceneSwitcher;

import java.io.IOException;

public class RegisterGreenSpaceControllerGUI implements ControllerWithEmail {

    @FXML
    private TextField nameInput;

    @FXML
    private TextField areaInput;

    @FXML
    private ComboBox<String> typeSelectionBox;

    private String email;

    private RegisterGreenSpaceController registerGreenSpaceController;

    private GreenSpaceRepository greenSpaceRepository = new GreenSpaceRepository();

    @Override
    public void setUserEmail(String email) {
        this.email = email;
        this.registerGreenSpaceController = new RegisterGreenSpaceController();
    }

    public String getUserEmail() {
        return email;
    }

    @FXML
    public void initialize() {
        typeSelectionBox.setItems(FXCollections.observableArrayList("Garden", "Medium-Sized Park", "Large-Sized Park"));
    }

    @FXML
    private void registerGreenSpace() {
        String name = nameInput.getText();
        String areaText = areaInput.getText();
        String selectedType = typeSelectionBox.getValue();

        if (!isNameValid(name)) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Name cannot be null or contain special characters.");
            return;
        }

        if (!isAreaValid(areaText)) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Area must be a valid number.");
            return;
        }

        if (selectedType == null) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please select a type of green space.");
            return;
        }

        double area = Double.parseDouble(areaText);
        GreenSpaceType greenSpaceType = mapToGreenSpaceType(selectedType);

        GreenSpace newGreenSpace = registerGreenSpaceController.registerGreenSpace(name, area, greenSpaceType, email);

        greenSpaceRepository.addGreenSpace(newGreenSpace);

        showAlert(Alert.AlertType.INFORMATION, "Success", "Green space registered successfully.");
    }

    private boolean isNameValid(String name) {
        return name != null && name.matches("[a-zA-Z0-9 ]+");
    }

    private boolean isAreaValid(String area) {
        try {
            Double.parseDouble(area);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private GreenSpaceType mapToGreenSpaceType(String type) {
        switch (type) {
            case "Garden":
                return GreenSpaceType.GARDEN;
            case "Medium-Sized Park":
                return GreenSpaceType.MEDIUM_SIZED_PARK;
            case "Large-Sized Park":
                return GreenSpaceType.LARGE_SIZED_PARK;
            default:
                throw new IllegalArgumentException("Invalid green space type: " + type);
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void goBack(javafx.event.ActionEvent event) {
        try {
            SceneSwitcher.switchToScene("/fxml/GsmUIMenu.fxml", "Main Menu", (Node) event.getSource(), email);
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load the Main Menu.");
        }
    }
}
