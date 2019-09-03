public class TodoCommand extends Command {
    public TodoCommand(String input) {
        super();
        this.input = input;
    }

    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException {
        String[] words = input.split(" ", 2);
        if (words.length == 1) {
            throw new DukeException("\u2639 OOPS!!! The description of a todo cannot be empty.");
        }
        Task task = new Todo(words[1].trim());
        list.store(task);
        storage.writeFile(list);
    }

    public boolean isExit() {
        return false;
    }
}
