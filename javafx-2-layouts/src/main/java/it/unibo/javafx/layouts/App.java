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
    private VBox tasksTodo; // Lista dei task da completare
    private VBox tasksDone; // Lista dei task completati

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        // Left Pane
        VBox leftPane = new VBox();
        leftPane.setId("left-pane");
        final Label lblLeftPane = new Label("Todo App");
        final TextField textInput = new TextField();
        final Button addButton = new Button("Add");

        // Inizializza tasksTodo e tasksDone
        tasksTodo = new VBox();
        tasksTodo.setAlignment(Pos.TOP_CENTER);
        final Label lblTasksTodo = new Label("Todo");
        tasksTodo.getChildren().add(lblTasksTodo);

        tasksDone = new VBox();
        tasksDone.setAlignment(Pos.TOP_CENTER);
        final Label lblTasksDone = new Label("Done");
        tasksDone.getChildren().add(lblTasksDone);

        // Right Pane
        VBox rightPane = new VBox();
        rightPane.setId("right-pane");
        final Label lblRightPane = new Label("Tasks");
        rightPane.setAlignment(Pos.TOP_CENTER);

        final HBox taskBox = new HBox();
        VBox.setVgrow(taskBox, Priority.ALWAYS);
        taskBox.setId("tasks-area");

        HBox.setHgrow(tasksTodo, Priority.ALWAYS);
        HBox.setHgrow(tasksDone, Priority.ALWAYS);
        taskBox.getChildren().addAll(tasksTodo, tasksDone);

        rightPane.getChildren().addAll(lblRightPane, taskBox);

        // Aggiungi logica per il pulsante "Add"
        addButton.setOnAction(event -> {
            String taskContent = textInput.getText().trim();
            if (!taskContent.isEmpty()) {
                Node newTask = createTaskSection(taskContent, tasksDone);
                tasksTodo.getChildren().add(newTask);
                textInput.clear();
            }
        });

        leftPane.getChildren().addAll(lblLeftPane, textInput, addButton);
        leftPane.setAlignment(Pos.TOP_CENTER);

        // Imposta i pannelli sinistro e centrale
        root.setLeft(leftPane);
        root.setCenter(rightPane);

        // Configura scena e stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("ToDo List App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Crea un todo composto da una label e un bottone per segnare il task come completato.
    public static Node createTaskSection(String content, VBox tasksDone) {
        final HBox task = new HBox();
        Label taskLabel = new Label(content);
        VBox textBox = new VBox(taskLabel);
        Button doneButton = new Button("X");

        // Logica del pulsante "X"
        doneButton.setOnAction(e -> {
            ((VBox) task.getParent()).getChildren().remove(task); // Rimuovi dalla lista Todo
            tasksDone.getChildren().add(task); // Aggiungi alla lista Done
        });

        HBox.setHgrow(textBox, Priority.ALWAYS);
        task.getChildren().addAll(textBox, doneButton);
        return task;
    }

    public static class Main {
        public static void main(String... args) {
            Application.launch(App.class, args);
        }
    }
}
