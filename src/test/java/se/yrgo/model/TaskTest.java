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
}
