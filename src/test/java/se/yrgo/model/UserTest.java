package se.yrgo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class UserTest {

    @Test
    public void testUserCreation() {
        User user = new User(1, "test", "test@gmail.com");

        assertEquals(1, user.getId());
        assertEquals("test", user.getName());
        assertEquals("test@gmail.com", user.getEmail());
        assertTrue(user.getTodoLists().isEmpty());
    }

    @Test
    public void testAddTodoList() {
        User user = new User(1, "Anna", "anna@example.com");
        TodoList list1 = new TodoList();
        TodoList list2 = new TodoList();

        user.addTodoList(list1);
        user.addTodoList(list2);
        user.addTodoList(list1); // Försöker lägga till samma lista igen

        List<TodoList> lists = user.getTodoLists();

        assertEquals(2, lists.size());
        assertTrue(lists.contains(list1));
        assertTrue(lists.contains(list2));
    }

    @Test
    public void testUpdateNameAndEmail() {
        User user = new User(1, "Anna", "anna@example.com");

        user.setName("Anna Svensson");
        user.setEmail("anna.svensson@example.com");

        assertEquals("Anna Svensson", user.getName());
        assertEquals("anna.svensson@example.com", user.getEmail());
    }
}