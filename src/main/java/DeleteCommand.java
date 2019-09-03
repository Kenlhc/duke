public class DeleteCommand extends Command {
    public DeleteCommand(String input) {
        super();
        this.input = input;
    }

    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        String[] words = input.split(" ", 2);
        if (words.length == 1) {
            throw new DukeException ("\u2639 OOPS!!! You did not specify a task number to delete.");
        } else {
            int check = Integer.parseInt(words[1].trim()) - 1;
            list.delete(check);
            storage.writeFile(list);
        }
    }

    public boolean isExit() {
        return false;
    }
}
