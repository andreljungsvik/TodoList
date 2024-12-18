package se.yrgo.model;

import java.util.*;

/**
 * representerar en användare med ett unikt ID, namn, e-postadress och en lista av todolistor.
 */
public class User {
    private int id;
    private String name;
    private String email;
    private List<TodoList> todoLists;

    /**
     * Skapar en ny användare med ett ID, namn och e-postadress.
     *
     * @param id    användarens unika ID
     * @param name  användarens namn
     * @param email användarens e-postadress
     */
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.todoLists = new ArrayList<>();
    }

    /**
     * lägger till en todolist till användaren om den inte redan finns.
     *
     * @param list todolist som ska läggas till
     */
    public void addTodoList(TodoList list) {
        if (list != null && !todoLists.contains(list)) {
            this.todoLists.add(list);
        }
    }

    /**
     * Hämtar alla todolists som tillhör användaren.
     *
     * @return En lista med alla todolists
     */
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