package se.yrgo.model;

import java.util.*;

public class User {
    private int id;
    private String name;
    private String email;
    private List<TodoList> todoLists;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.todoLists = new ArrayList<>();
    }

    public void addTodoList(TodoList list) {
        if (list != null && !todoLists.contains(list)) {
            this.todoLists.add(list);
        }
    }

    // public void removeTodoList(int listId) {
    //     todoLists.removeIf(list -> list.getId() == listId); 
    // } måste lägga till id i TodoList för att denna ska funka.

    public List<TodoList> getTodoLists() {
        return todoLists;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", todoLists=" + todoLists.size() + // Visar antal listor
                '}';
    }
}
