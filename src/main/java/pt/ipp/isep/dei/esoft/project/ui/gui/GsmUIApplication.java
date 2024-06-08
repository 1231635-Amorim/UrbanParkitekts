package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.GUIController.GsmUIMenuControllerGUI;

public class GsmUIApplication extends Application {
    private static String userEmail;

    /**
     * Sets the user email.
     *
     * @param email The email to set.
     */
    public static void setUserEmail(String email) {
        userEmail = email;
    }

    /**
     * Gets the user email.
     *
     * @return The user email.
     */
    public static String getUserEmail() {
        return userEmail;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/GsmUIMenu.fxml"));
        Scene mainScene = new Scene(fxmlLoader.load());

        GsmUIMenuControllerGUI menuController = fxmlLoader.getController();
        menuController.setUserEmail(userEmail);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Green Space Manager Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
