import java.text.ParseException;

public abstract class Command {
    protected String input;
    public abstract void execute (TaskList taskList, Ui ui, Storage storage) throws DukeException, ParseException;
    public abstract boolean isExit();
}