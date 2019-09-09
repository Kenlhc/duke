package duke.commands;

import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

public class ExitCommand extends Command {
    public ExitCommand() {
        super();
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.exit();
    }

    public boolean isExit() {
        return true;
    }
}
