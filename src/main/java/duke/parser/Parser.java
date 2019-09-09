package duke.parser;

import duke.commands.*;
import duke.exception.DukeException;

public class Parser {

    public static Command parse(String input) throws DukeException {
        String[] words = input.split(" ", 2);
        if (input.equals("bye")) {
            return new ExitCommand();
        } else if (input.equals("list")) {
            return new ListCommand();
        } else if (input.isEmpty()) {
            throw new DukeException("\u2639 OOPS!!! You did not enter anything.");
        } else if (words[0].equals("done") || words[0].equals("Done")) {
            return new DoneCommand(input);
        } else if (words[0].equals("delete") || words[0].equals("Delete")) {
            return new DeleteCommand(input);
        } else if (words[0].equals("find") || words[0].equals("Find")) {
            return new FindCommand(input);
        } else if (words[0].equals("todo") || words[0].equals("Todo")) {
            return new TodoCommand(input);
        } else if (words[0].equals("deadline") || words[0].equals("Deadline")) {
            return new DeadlineCommand(input);
        } else if (words[0].equals("event") || words[0].equals("Event")) {
            return new EventCommand(input);
        } else {
            throw new DukeException("\u2639 OOPS!!! I do not understand what command you just told me.");
        }
    }
}
