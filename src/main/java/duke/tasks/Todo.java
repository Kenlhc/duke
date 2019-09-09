package duke.tasks;

/**
 * A todo task specified by the user
 */
public class Todo extends Task {
    /**
     * This method references the details of the todo in the Task parent class
     * @param description The details of the task specified by the user
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * This method generates a simple statement to show details of a todo
     * @return String to show a todo
     */
    @Override
    public String toString() {
        return "[T][" + super.getStatusIcon() + "] " + super.description;
    }
}