package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var root = new VBox();

        var textField = new TextField();
        root.getChildren().add(textField);

        var button = new Button("Click Me!");
        root.getChildren().add(button);

        button.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, String.format("%s", textField.getText()));
            alert.show();
        });

        var scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
