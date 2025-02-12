package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Press any key!");
        StackPane root = new StackPane(label);

        root.setFocusTraversable(true);

        Scene scene = new Scene(root, 300, 200);

        root.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            label.setText("Key pressed: " + keyCode.toString());
        });

        stage.setScene(scene);
        stage.setTitle("Key Press Tracker");
        stage.show();

        root.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }
}