package duke.commands;

import duke.exception.DukeException;
import duke.parser.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandsTest {

    @Test
    public void exitCommandTest() throws DukeException {
        Assertions.assertEquals(new ExitCommand(), Parser.parse("bye"));
    }

    @Test
    public void listCommandTest() throws DukeException {
        Assertions.assertEquals(new ListCommand(), Parser.parse("list"));
    }

    @Test
    public void doneCommandTest() throws DukeException {
        Assertions.assertEquals(new DoneCommand("done 1"), Parser.parse("done 1"));
    }

    @Test
    public void deleteCommandTest() throws DukeException {
        Assertions.assertEquals(new DeleteCommand("delete 1"), Parser.parse("delete 1"));
    }

    @Test
    public void findCommandTest() throws DukeException {
        Assertions.assertEquals(new FindCommand("find ST"), Parser.parse("find ST"));
    }

    @Test
    public void todoCommandTest() throws DukeException {
        assertEquals(new TodoCommand("todo test"), Parser.parse("todo test"));
    }

    @Test
    public void deadlineCommandTest() throws DukeException {
        assertEquals(new DeadlineCommand("deadline test /by 19/12/2019 2359"), Parser.parse("deadline test /by 19/12/2019 2359"));
    }

    @Test
    public void eventCommandTest() throws DukeException {
        assertEquals(new EventCommand("event test /at 19/12/2019 2359"), Parser.parse("event test /at 19/12/2019 2359"));
    }
}
