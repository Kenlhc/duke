package duke.commands;

import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

public class ListCommand extends Command {
    public ListCommand() {
        super();
    }

    public void execute(TaskList list, Ui ui, Storage storage) {
        list.listTask();
    }

    public boolean isExit() {
        return false;
    }
}
