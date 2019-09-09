package duke.commands;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

public class DoneCommand extends Command {
    public DoneCommand(String input) {
        super();
        this.input = input;
    }

    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        String[] words = input.split(" ", 2);
        if (words.length == 1) {
            throw new DukeException("\u2639 OOPS!!! You did not specify a task to mark as done.");
        }
        int check = Integer.parseInt(words[1].trim()) - 1;
        list.complete(check);
        storage.writeFile(list);
    }

    public boolean isExit() {
        return false;
    }
}
