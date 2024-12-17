package se.yrgo.model;

public class Task {
    private String title;
    private String description;
    private boolean completed;

    // Konstruktor
    public Task(String title, String description) {
        setTitle(title); // Använd setTitle för att dra nytta av valideringen
        setDescription(description); // Använd setDescription för att dra nytta av valideringen
        this.completed = false; // Standardvärde för completed
    }

    // Getters och Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return String.format(
                "Task {title='%s', description='%s', completed=%s}",
                title, description, completed
        );
    }
}
