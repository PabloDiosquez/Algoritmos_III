package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Move the mouse!");

        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 300, 200);

        scene.setOnMouseMoved(mouseEvent -> {
            label.setText(String.format("Coordinates: (%.2f, %.2f)", mouseEvent.getX(), mouseEvent.getY()));
        });

        stage.setScene(scene);
        stage.setTitle("Mouse Tracker");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
