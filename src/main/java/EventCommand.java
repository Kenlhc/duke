import java.text.ParseException;

public class EventCommand extends Command {
    public EventCommand (String input) {
        super();
        this.input = input;
    }

    public void execute(TaskList list, Ui ui, Storage storage) throws DukeException, ParseException {
        String[] words = input.split(" ", 2);
        if (words.length == 1) {
            throw new DukeException("\u2639 OOPS!!! The description of an event cannot be empty.");
        }
        String[] splitter = words[1].split("/at");
        String[] dateTime = splitter[1].trim().split(" ");
        if (dateTime.length > 1) {
            Task task = new Event(splitter[0].trim(), Converter.dateTime(splitter[1].trim()));
            list.store(task);
            storage.writeFile(list);
        } else {
            throw new DukeException("\u2639 OOPS!!! The time for an event cannot be empty.");
        }
    }

    public boolean isExit() {
        return false;
    }
}
