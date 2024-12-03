package it.unibo.javafx.property;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("Controls Exercise!");
        final VBox mainPane = new VBox();
        final Counter counter = new Counter();
        // TODO aggiungere gli elementi come descritto da readme
        final Label lbl = new Label();
        lbl.textProperty().bind(counter.counterProperty().asString());
        
        final Button btnPlus = new Button("+");
        btnPlus.setMinWidth(100);
        btnPlus.setOnAction(event -> counter.increment());
        
        final Button btnMinus = new Button("-");
        btnMinus.setMinWidth(100);
        btnMinus.setOnAction(event -> counter.decrement());
        
        final HBox buttonBox  = new HBox();
        buttonBox.getChildren().addAll(btnPlus, btnMinus);

        mainPane.getChildren().addAll(lbl, buttonBox);
        
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}
