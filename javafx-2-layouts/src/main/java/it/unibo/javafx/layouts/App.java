package it.unibo.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Il root è un BorderPane, che divide la finestra in 5 aree: top, bottom, left, right, center.
        // Noi usiamo solo left e center.
        BorderPane root = new BorderPane();

        // Left Pane, contiene il titolo e il form per aggiungere nuovi task.
        VBox leftPane = new VBox();
        leftPane.setId("left-pane");

        // TODO aggiungere il titolo e i pulsanti
        final Label lblLeftPane = new Label("Todo App");
        final TextField textInput = new TextField();
        final Button addButton = new Button("Add");

        // Aggiungo i nodi al leftPane
        leftPane.getChildren().addAll(lblLeftPane, textInput, addButton);
        leftPane.setAlignment(Pos.TOP_CENTER);

        VBox rightPane = new VBox();
        rightPane.setId("right-pane");
        final Label lblRightPane = new Label("Tasks");
        rightPane.setAlignment(Pos.TOP_CENTER);

        final HBox taskBox = new HBox();
        VBox.setVgrow(taskBox, Priority.ALWAYS);
        taskBox.setId("tasks-area");

        VBox tasksTodo = new VBox();
        tasksTodo.setAlignment(Pos.TOP_CENTER);
        VBox tasksDone = new VBox();
        tasksDone.setAlignment(Pos.TOP_CENTER);
        final Label lblTasksTodo = new Label("Todo");
        final Label lblTasksDone = new Label("Done");
        tasksTodo.getChildren().add(lblTasksTodo);
        tasksDone.getChildren().add(lblTasksDone);

        HBox.setHgrow(tasksTodo, Priority.ALWAYS);
        HBox.setHgrow(tasksDone, Priority.ALWAYS);
        taskBox.getChildren().addAll(tasksTodo, tasksDone);

        rightPane.getChildren().addAll(lblRightPane, taskBox);

        // Imposto i pannelli sinistro e centrale come figli del root.
        root.setLeft(leftPane);
        root.setCenter(rightPane);

        // Set scene and stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("ToDo List App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Main {
        public static void main(String... args) {
            Application.launch(App.class, args);
        }
    }

    // Crea un todo composto da una label e un bottone per segnare il task come completato.
    public static Node createTaskSection(String content) {
        final HBox task = new HBox();
        Label taskLabel = new Label(content);
        VBox textBox = new VBox(taskLabel);
        Button doneButton = new Button("X");
        HBox.setHgrow(textBox, Priority.ALWAYS);
        task.getChildren().addAll(textBox, doneButton);
        return task;
    }
}