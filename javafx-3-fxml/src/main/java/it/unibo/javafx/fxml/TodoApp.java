package it.unibo.javafx.fxml;

import java.util.List;

/**
 * The interface for the todo application.
 */
public interface TodoApp {
    /**
     * Adds a new todo to the list of todos.
     * @param content the content of the todo
     * @return the todo added
     */
    Todo addNewTodo(String content);

    /**
     * Marks a todo as completed.
     * @param todo the todo to mark as completed
     */
    void completeTodo(Todo todo);

    /**
     * Returns the list of todos.
     * @return the list of todos
     */
    List<Todo> getTodos();
    
    /** Returns the list of completed todos.
     * @return the list of completed todos
     */
    List<Todo> getCompletedTodos();
}
