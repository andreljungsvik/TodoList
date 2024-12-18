package se.yrgo.model;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> filterTasks(boolean completed) {
        //returnera en tom lsita utifall task av förmodan skulle vara null
        List<Task> filtered = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted() == completed) {
                filtered.add(task);
            }
        }
        return filtered;
    }
}
