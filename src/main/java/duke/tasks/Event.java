package duke.tasks;

/**
 * An Event task specified by the user
 */
public class Event extends Task {
    /**
     * The date and time where the event will be held at
     */
    protected String at;

    /**
     * This method references the details of the event in the Task parent
     * class and the variable declared above
     * @param description The details of the event specified by the user
     * @param at The date and time of the event specified by the user
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * This method generates a simple statement to show details of an event
     * @return String to show an event
     */
    @Override
    public String toString() {
        return "[E][" + super.getStatusIcon() + "] " + super.description + " (at: " + at + ")";
    }
}