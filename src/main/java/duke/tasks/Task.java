package duke.tasks;

/**
 * This is the Parent class of all the subclasses of Task
 */
public class Task {
    /**
     * The details of the task specified by the user
     */
    public String description;
    /**
     * The status of the task whether it has been completed or not
     */
    protected boolean isDone;

    /**
     * This method references the details and status of the task
     * from the variables declared above
     * @param description The details of the task specified by the user
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * This method shows the current status of the task
     * @return Status Icon of the task specified
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * This method will mark a task as completed
     */
    public void markAsDone() {
        isDone = true;
    }
}
