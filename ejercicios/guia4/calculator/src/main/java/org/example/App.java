package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




/**
 * JavaFX App
 */
public class App extends Application {
    private VBox root;
    private TextField supraScreen;
    private TextField screen;
    private VBox panel;

    @Override
    public void start(Stage stage) throws Exception {
        root = new VBox();

        supraScreen = new TextField();
        root.getChildren().add(supraScreen);

        screen = new TextField();
        root.getChildren().add(screen);

        panel = new VBox();
        root.getChildren().add(panel);

        var r1 = insertRowInto(panel);
        insertButtonInto(r1, "7");
        insertButtonInto(r1, "8");
        insertButtonInto(r1, "9");
        insertOpButtonInto(r1, "/");

        var r2 = insertRowInto(panel);
        insertButtonInto(r2, "4");
        insertButtonInto(r2, "5");
        insertButtonInto(r2, "6");
        insertOpButtonInto(r2, "*");

        var r3 = insertRowInto(panel);
        insertButtonInto(r3, "1");
        insertButtonInto(r3, "2");
        insertButtonInto(r3, "3");
        insertOpButtonInto(r3, "+");

        var r4 = insertRowInto(panel);
        insertClearButtonInto(r4, "C");
        insertButtonInto(r4, "0");
        insertEqualButtonInto(r4, "=");
        insertOpButtonInto(r4, "-");

        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private HBox insertRowInto(VBox panel){
        var row = new HBox();

        panel.getChildren().add(row);
        return row;
    }

    private void insertButtonInto(HBox row, String content) {
        var btn = new Button(content);
        row.getChildren().add(btn);
        btn.setOnAction(event -> {
            String supraText = supraScreen.getText() + ((Button)(event.getSource())).getText();
            String newText = screen.getText() + ((Button)(event.getSource())).getText();
            supraScreen.setText(supraText);
            screen.setText(newText);
        });
    }

    private void insertEqualButtonInto(HBox row, String content){
        var btn = new Button(content);
        row.getChildren().add(btn);
        btn.setOnAction(event -> {
            System.out.println("Hi! I'm = :)");
        });
    }

    private void insertClearButtonInto(HBox row, String content) {
        var btn = new Button(content);
        row.getChildren().add(btn);
        btn.setOnAction(actionEvent -> {
            supraScreen.clear();
            screen.clear();
        });
    }

    private void insertOpButtonInto(HBox row, String content) {
        var btn = new Button(content);
        row.getChildren().add(btn);
        btn.setOnAction(event -> {
            String newText = screen.getText() + ((Button)(event.getSource())).getText();
            supraScreen.setText(newText);
            screen.clear();
        });
    }
}