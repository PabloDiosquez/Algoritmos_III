package org.example;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("ChoiceBox");

        TilePane r = new TilePane();
        Label label = new Label("This is a choice box!");
        Label selectionLabel = new Label("Nothing selected");

        String[] colors = { "Red", "Green", "Yellow", "Black" };
        var choiceBox = new ChoiceBox(FXCollections.observableArrayList(colors));

        choiceBox.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> {
            System.out.println(new_value.intValue());
            selectionLabel.setStyle("-fx-background-color: " + colors[new_value.intValue()] + "; -fx-padding: 5px;");
        });

        r.getChildren().add(label);
        r.getChildren().add(choiceBox);
        r.getChildren().add(selectionLabel);

        var scene = new Scene(r, 200, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}