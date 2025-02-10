package org.example;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
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

        String[] st = { "Arnab", "Andrew", "Ankit", "None" };
        var choiceBox = new ChoiceBox(FXCollections.observableArrayList(st));

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            // if the item of the list is changed
            public void changed(ObservableValue ov, Number value, Number new_value)
            {

                // set the text for the label to the selected item
                selectionLabel.setText(st[new_value.intValue()] + " selected");
            }
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