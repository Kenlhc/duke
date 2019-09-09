import duke.commands.Command;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * This is a Personal Task Manager called Duke that can aid
 * in storing your tasks as a todo, deadline or event with
 * status icons to signify completion.
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    /**
     * This method initialises the variables required
     * @param filename The name of the file to be read from
     */
    public Duke (String filename) {
        ui = new Ui();
        storage = new Storage(filename);
        parser = new Parser();
        try {
            tasks = new TaskList(storage.readFile());
        } catch (FileNotFoundException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * This method runs the entire program by taking in user input
     * and understanding them as commands to either add, delete, find, list
     * or mark as done before exiting when the user types bye
     */
    public void run() {
        ui.greet();
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.readInput();
                Command command = parser.parse(input);
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            } catch (DukeException e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a task.");
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter date in the correct format dd/mm/yyyy hhmm");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Please specify a task number to delete.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                System.out.println("The task number you entered does not exist.");
            }
        }
    }

    /**
     * This is the main method of the program
     * @param args The main argument of the program
     */
    public static void main(String[] args) {
        new Duke("C:\\Users\\user\\Desktop\\duke\\data\\tasks.txt").run();
    }
}