package duke.commands;

import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;
/**
 * An exit command specified by the user which exits the program
 */
public class ExitCommand extends Command {
    /**
     * This method references the user input from the
     * Command parent class
     */
    public ExitCommand() {
        super();
    }
    /**
     * This method exits the program once the user types bye
     * @param list The list of tasks the user has to complete
     * @param ui The user interface that the user can interact with
     * @param storage The program responsible for storing and reading the tasks from hard drive
     */
    public void execute(TaskList list, Ui ui, Storage storage) {
        ui.exit();
    }
    /**
     * This method tells the program if the user wants to exit
     * @return true if user types bye, false otherwise
     */
    public boolean isExit() {
        return true;
    }
}
