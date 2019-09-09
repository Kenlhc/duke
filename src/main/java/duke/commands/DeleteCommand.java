package duke.commands;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;
/**
 * A delete command specified by the user which
 * deletes the selected task number
 */
public class DeleteCommand extends Command {
    /**
     * This method references the user input from the
     * Command parent class and the Parser program
     * @param input The command given by the user
     */
    public DeleteCommand(String input) {
        super();
        this.input = input;
    }
    /**
     * This method deletes the task specified and at the same time
     * store the most recently updated into the file in hard drive
     * @param list The list of tasks the user has to complete
     * @param ui The user interface that the user can interact with
     * @param storage The program responsible for storing and reading the tasks from hard drive
     * @throws DukeException Catches invalid user input
     */
    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        String[] words = input.split(" ", 2);
        if (words.length == 1) {
            throw new DukeException("\u2639 OOPS!!! You did not specify a task number to delete.");
        } else {
            int check = Integer.parseInt(words[1].trim()) - 1;
            list.delete(check);
            storage.writeFile(list);
        }
    }
    /**
     * This method tells the program if the user wants to exit
     * @return true if user types bye, false otherwise
     */
    public boolean isExit() {
        return false;
    }
}
