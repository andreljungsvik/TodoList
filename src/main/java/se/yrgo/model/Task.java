package se.yrgo.model;

/**
 * Representerar en uppgift med en titel, beskrivning och status för om den är slutförd.
 * en uppgift kan markeras som slutförd och dess detaljer kan hämtas eller uppdateras.
 */
public class Task {
    private String title;
    private String description;
    private boolean completed;

    /**
     * skapar en ny uppgift med angiven titel och beskrivning.
     *
     * @param title titeln på uppgiften
     * @param description beskrivningen av uppgiften
     */
    public Task(String title, String description) {
        setTitle(title);
        setDescription(description);
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title den nya titeln på uppgiften
     * @throws IllegalArgumentException om titeln är null eller tom
     */
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Titeln kan inte vara null eller tom");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    /**
     * uppdaterar beskrivningen av uppgiften.
     *
     * @param description den nya beskrivningen av uppgiften
     * @throws IllegalArgumentException om beskrivningen är null eller tom
     */
    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Beskrivningen kan inte vara null eller tom");
        }
        this.description = description;
    }

    /**
     * kontrolkerar om uppgiften är slutförd.
     * 
     * @return true om uppgiften är slutförd, annars false
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * uppdaterar status på uppgift
     *
     * @param completed true om uppgiften är slutförd, annars false
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * markerar uppgiften som slutförd.
     */
    public void markAsCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return String.format(
                "Uppgift {titel='%s', beskrivning='%s', slutförd=%s}",
                title, description, completed);
    }
}
