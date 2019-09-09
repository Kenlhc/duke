package duke.commands;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.text.ParseException;

/**
 * This is the parent class of all subclasses of Command
 */
public abstract class Command {
    /**
     * The command to be carried out specified by the user
     */
    protected String input;

    /**
     * This method executes the command given
     * @param taskList The list of tasks specified by the user
     * @param ui The user interface that the user can interact with
     * @param storage The program responsible for storing and reading the tasks from hard drive
     * @throws DukeException Catches any invalid input
     * @throws ParseException Catches any invalid date format
     */
    public abstract void execute (TaskList taskList, Ui ui, Storage storage) throws DukeException, ParseException;

    /**
     * This method tells the program if the user wants to exit
     * @return true if user types bye, false otherwise
     */
    public abstract boolean isExit();
}