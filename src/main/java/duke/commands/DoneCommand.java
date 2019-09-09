package duke.commands;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;
/**
 * A done command specified by the user which marks a task as complete
 */
public class DoneCommand extends Command {
    /**
     * This method references the user input from the
     * Command parent class and the Parser program
     * @param input The command given by the user
     */
    public DoneCommand(String input) {
        super();
        this.input = input;
    }
    /**
     * This method marks a task as done and at the same time
     * store the tasks most recently updated into the file in hard drive
     * @param list The list of tasks the user has to complete
     * @param ui The user interface that the user can interact with
     * @param storage The program responsible for storing and reading the tasks from hard drive
     * @throws DukeException Catches invalid user input
     */
    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        String[] words = input.split(" ", 2);
        if (words.length == 1) {
            throw new DukeException("\u2639 OOPS!!! You did not specify a task to mark as done.");
        }
        int check = Integer.parseInt(words[1].trim()) - 1;
        list.complete(check);
        storage.writeFile(list);
    }
    /**
     * This method tells the program if the user wants to exit
     * @return true if user types bye, false otherwise
     */
    public boolean isExit() {
        return false;
    }
}
