package se.yrgo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representerar en todolist som hanterar en samlig av uppgifter.
 */
public class TodoList {
    private List<Task> tasks;

    /**
     * Skapar en ny todolist med en tom list.
     */
    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Lägger till en ny uppgift i listan.
     *
     * @param task uppgiften som ska läggas till
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Tar bort en uppgift från listan.
     *
     * @param task uppgiften som ska tas bort
     */
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    /**
     * Ger listan av uppgifter
     *
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * filtrerar uppgifter baserat på deras status
     *
     * @param completed true för att filtrera slutförda uppgifter, annars false
     * @return En lista med uppgifter som matchar det angivna kriteriet
     */
    public List<Task> filterTasks(boolean completed) {
        // Returnerar en tom lista om inga uppgifter matchar kriteriet
        List<Task> filtered = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted() == completed) {
                filtered.add(task);
            }
        }
        return filtered;
    }
}