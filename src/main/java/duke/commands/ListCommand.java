package duke.commands;

import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * A list command specified by the user
 * which lists all the tasks previously stored
 */
public class ListCommand extends Command {
    /**
     * This method references the Command parent class
     */
    public ListCommand() {
        super();
    }
    /**
     * This method lists all the tasks previously stored
     * @param list The list of tasks the user has to complete
     * @param ui The user interface that the user can interact with
     * @param storage The program responsible for storing and reading the tasks from hard drive
     */
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.listTask();
    }
    /**
     * This method tells the program if the user wants to exit
     * @return true if user types bye, false otherwise
     */
    public boolean isExit() {
        return false;
    }
}
