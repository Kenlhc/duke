package duke.tasks;

/**
 * A deadline specified by the user
 */
public class Deadline extends Task {
    /**
     * The date and time you have to finish the task by
     */
    protected String by;

    /**
     * This method references the details of the deadline to be met in the Task
     * parent class as well as the variable declared above
     * @param description The details of the deadline
     * @param by The date and time you have to finish the task by
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * This method generates a simple statement to show details of the deadline
     * @return String to show a deadline
     */
    @Override
    public String toString() {
        return "[D][" + super.getStatusIcon() + "] " + super.description + " (by: " + by + ")";
    }
}
