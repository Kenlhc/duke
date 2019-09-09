package duke.storage;

import duke.tasklist.TaskList;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;

import java.io.*;
import java.util.ArrayList;

/**
 * This Storage program implements methods to store and read
 * Tasks that have been specified by the user
 */
public class Storage {
    /**
     * The name of the file to save the tasks to as well as read from
     */
    private static String filename;

    /**
     * This method references the filename from the String in the main application
     * @param filename The name of the file to store and read from
     */
    public Storage(String filename) {
        this.filename = filename;
    }

    /**
     * This method stores the tasks specified by the user into a file saved
     * on the hard drive
     * @param list The tasks that has been specified by the user
     */
    public static void writeFile(TaskList list) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < list.getSize(); i++) {
                bufferedWriter.write(list.getTaskList(i) + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("There's no file");
            e.printStackTrace();
        }
    }

    /**
     * This method reads the tasks specified by the user from a file saved
     * on the hard drive
     * @return Task containing the full list of tasks specified
     * @throws FileNotFoundException Catches missing files that are to be read from
     */
    public ArrayList<Task> readFile() throws FileNotFoundException {
        ArrayList<Task> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String input = bufferedReader.readLine();
            int count = 0;
            String status;
            while (input != null) {
                status = input.substring(3, 6);
                if (input.startsWith("[T]")) {
                    input = input.substring(7).trim();
                    Task task = new Todo(input);
                    list.add(task);
                    if (status.equals("[\u2713]")) {
                        list.get(count).markAsDone();
                    }
                    count += 1;
                } else if (input.startsWith("[D]")) {
                    input = input.substring(7);
                    String[] splitter = input.split("\\(by:", 2);
                    String remove_bracket = splitter[1].substring(0, splitter[1].length() - 1);
                    Task task = new Deadline(splitter[0].trim(), remove_bracket.trim());
                    list.add(task);
                    if (status.equals("[\u2713]")) {
                        list.get(count).markAsDone();
                    }
                    count += 1;
                } else if (input.startsWith("[E]")) {
                    input = input.substring(7);
                    String[] splitter = input.split("\\(at:", 2);
                    String remove_bracket = splitter[1].substring(0, splitter[1].length() - 1);
                    Task task = new Event(splitter[0].trim(), remove_bracket.trim());
                    list.add(task);
                    if (status.equals("[\u2713]")) {
                        list.get(count).markAsDone();
                    }
                    count += 1;
                }
                input = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("There's no file");
            e.printStackTrace();
        }
        return list;
    }
}
