package duke.commands;

import duke.converter.Converter;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.tasks.Deadline;
import duke.tasks.Task;
import duke.ui.Ui;

import java.text.ParseException;

/**
 * A deadline command specified by the user which adds deadline as a task
 */
public class DeadlineCommand extends Command {
    /**
     * This method references the user input from the
     * Command parent class and the Parser program
     * @param input The command given by the user
     */
    public DeadlineCommand (String input) {
        super();
        this.input = input;
    }

    /**
     * This method stores the task as a deadline and at the same time
     * store the tasks recorded so far into the file in hard drive
     * @param list The list of tasks the user has to complete
     * @param ui The user interface that the user can interact with
     * @param storage The program responsible for storing and reading the tasks from hard drive
     * @throws DukeException Catches invalid user input
     * @throws ParseException Catches invalid date format
     */
    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException, ParseException {
        String[] words = input.split(" ", 2);
        if (words.length == 1) {
            throw new DukeException("\u2639 OOPS!!! The description of a deadline cannot be empty.");
        }
        String[] splitter = words[1].split("/by");
        String[] dateTime = splitter[1].trim().split(" ");
        if (dateTime.length > 1) {
            Task task = new Deadline(splitter[0].trim(), Converter.dateTime(splitter[1].trim()));
            list.store(task);
            storage.writeFile(list);
        } else {
            throw new DukeException("\u2639 OOPS!!! The time for a deadline cannot be empty.");
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
