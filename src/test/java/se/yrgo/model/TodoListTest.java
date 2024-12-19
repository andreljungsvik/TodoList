package se.yrgo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TodoListTest {

    @Test
    public void testAddTask() {
        TodoList todoList = new TodoList();
        Task task = new Task("testTask", ".");

        todoList.addTask(task);

        List<Task> tasks = todoList.filterTasks(false);
        assertEquals(1, tasks.size());
        assertEquals("testTask", tasks.get(0).getTitle());
    }

    @Test
    public void testRemoveTask() {
        TodoList todoList = new TodoList();
        Task task = new Task("test", ".");

        todoList.addTask(task);
        todoList.removeTask(task);

        List<Task> tasks = todoList.filterTasks(false);
        assertTrue(tasks.isEmpty());
    }

    @Test
    public void testFilterCompletedTasks() {
        TodoList todoList = new TodoList();
        Task task1 = new Task("test1", "test1");
        Task task2 = new Task("test2", "test2");

        task1.markAsCompleted();

        todoList.addTask(task1);
        todoList.addTask(task2);

        List<Task> completedTasks = todoList.filterTasks(true);
        assertEquals(1, completedTasks.size());
        assertEquals("test1", completedTasks.get(0).getTitle());
    }

    @Test
    public void testFilterNotCompletedTasks() {
        TodoList todoList = new TodoList();
        Task task1 = new Task("test1", "test1");
        Task task2 = new Task("test2", "test2");

        task1.markAsCompleted(); // Endast task2 är ofullständig

        todoList.addTask(task1);
        todoList.addTask(task2);

        List<Task> notCompletedTasks = todoList.filterTasks(false); // Hämta ofullständiga tasks
        assertEquals(1, notCompletedTasks.size());
        assertEquals("test2", notCompletedTasks.get(0).getTitle());
    }

    @Test
    public void testRemoveNonExistentTask() {
        TodoList todoList = new TodoList();
        Task task1 = new Task("test1", "test1");
        Task task2 = new Task("test2", "test2");

        todoList.addTask(task1);

        // Försöker ta bort en uppgift som inte finns
        todoList.removeTask(task2);

        List<Task> tasks = todoList.filterTasks(false);
        assertEquals(1, tasks.size());
        assertEquals("test1", tasks.get(0).getTitle());
    }
}
