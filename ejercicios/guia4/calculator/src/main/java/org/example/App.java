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

    @Override
    public void start(Stage stage) throws Exception {
        var root = new VBox();

        var screen = new TextField();
        var panel = new VBox();
        panel.setId("panelId");

        root.getChildren().add(screen);
        root.getChildren().add(panel);

        var r1 = insertRowInto(panel);
        insertButtonInto(r1, "7");
        insertButtonInto(r1, "8");
        insertButtonInto(r1, "9");
        insertButtonInto(r1, "/");

        var r2 = insertRowInto(panel);
        insertButtonInto(r2, "4");
        insertButtonInto(r2, "5");
        insertButtonInto(r2, "6");
        insertButtonInto(r2, "*");

        var r3 = insertRowInto(panel);
        insertButtonInto(r3, "1");
        insertButtonInto(r3, "2");
        insertButtonInto(r3, "3");
        insertButtonInto(r3, "+");

        var r4 = insertRowInto(panel);
        insertButtonInto(r4, "C");
        insertButtonInto(r4, "0");
        insertButtonInto(r4, "=");
        insertButtonInto(r4, "-");

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

    private Button insertButtonInto(HBox row, String content) {
        var btn = new Button(content);
        row.getChildren().add(btn);
        btn.setOnAction(ActionEvent -> {
            System.out.println();
        });

        return btn;
    }
}