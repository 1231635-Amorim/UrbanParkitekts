package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The MainMenu class serves as the entry point for the JavaFX application.
 * It loads and displays the main menu scene defined in the MainMenu.fxml file.
 */
public class MainMenu extends Application {

    /**
     * Starts the JavaFX application by setting up the primary stage.
     *
     * @param primaryStage The primary stage for this application.
     */
    @Override
    public void start(Stage primaryStage) {
        initializePrimaryStage(primaryStage);
    }

    /**
     * Initializes the primary stage with the main menu scene.
     *
     * @param primaryStage The primary stage to be initialized.
     */
    private void initializePrimaryStage(Stage primaryStage) {
        Parent root = loadFXML("/fxml/MainMenu.fxml");
        if (root != null) {
            Scene scene = new Scene(root);
            configureStage(primaryStage, scene);
        }
    }

    /**
     * Loads an FXML file and returns the corresponding Parent object.
     *
     * @param fxmlPath The path to the FXML file.
     * @return The Parent object loaded from the FXML file, or null if loading fails.
     */
    private Parent loadFXML(String fxmlPath) {
        try {
            return FXMLLoader.load(getClass().getResource(fxmlPath));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Configures the primary stage with the specified scene.
     *
     * @param stage The primary stage to be configured.
     * @param scene The scene to be set on the primary stage.
     */
    private void configureStage(Stage stage, Scene scene) {
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method launches the JavaFX application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
