public class ListCommand extends Command {
    public ListCommand() {
        super();
    }

    public void execute(TaskList list, Ui ui, Storage storage) {
        list.echo();
    }

    public boolean isExit() {
        return false;
    }
}
