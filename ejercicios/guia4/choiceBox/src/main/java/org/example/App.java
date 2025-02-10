package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        HBox header = new HBox();
        TextField textField = new TextField();
        Button btn = new Button("Add task!");
        header.getChildren().addAll(textField, btn);

        VBox taskList = new VBox();

        root.getChildren().addAll(header, taskList);

        btn.setOnAction(event -> {
            String text = textField.getText();
            if (text.isEmpty()) {
                return;
            }
            addTask(taskList, text);
        });

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void addTask(VBox taskList, String task) {
        HBox row = new HBox();
        CheckBox checkBox = new CheckBox(task);
        Button deleteBtn = new Button("\uD83D\uDDD1️");
        row.getChildren().addAll(checkBox, deleteBtn);
        taskList.getChildren().add(row);

        deleteBtn.setOnAction(event -> {
            taskList.getChildren().remove(row);
        });
    }
}
