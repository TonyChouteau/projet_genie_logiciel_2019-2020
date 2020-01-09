package gui;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX");

        Scene scene = new Scene((Parent) JavafxLoader.loadFxml("scene.fxml"), 1600, 900);
        primaryStage.setScene(scene);

        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(394);

        primaryStage.show();
    }
}