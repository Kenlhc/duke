import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

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


    public static void main(String[] args) {
        new Duke("C:\\Users\\user\\Desktop\\duke\\data\\tasks.txt").run();
    }
}