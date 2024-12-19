package se.yrgo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void testMarkAsCompleted() {
        Task task = new Task("Test task", "This is a test task");
        assertFalse(task.isCompleted());
        task.markAsCompleted();
        assertTrue(task.isCompleted());
    }
    @Test
    public void testSetTitle() {
        Task task = new Task("Test task", "This is a test task");
        assertEquals("Test task", task.getTitle());
    }
    @Test
    public void testSetTitleException() {
        Task task = new Task("Test", "This is a test task");
        assertThrows(IllegalArgumentException.class, () -> task.setTitle(null));
        assertThrows(IllegalArgumentException.class, () -> task.setTitle(""));
    }
    @Test
    public void testSetDescription() {
        Task task = new Task("Test task", "This is a test task");
        assertEquals("This is a test task", task.getDescription());
    }
    @Test
    public void testSetDescriptionException() {
        Task task = new Task("Test", "This is a test task");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(""));
    }
}
