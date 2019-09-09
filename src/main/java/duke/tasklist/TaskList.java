package duke.tasklist;

import duke.tasks.Task;

import java.util.ArrayList;

/**
 * This TaskList Program implements methods to store and alter
 * tasks that have been specified by the user
 */
public class TaskList {
    /**
     * The list of tasks that the user will specify and store in
     */
    private static ArrayList<Task> list;

    /**
     * Constructor method for TaskList
     */
    public TaskList() {
    }

    /**
     * This method references the list of tasks from the variable
     * declared above
     * @param list The list of tasks specified by the user
     */
    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    /**
     * This method gives the number of tasks currently
     * specified by the user
     * @return Size of the list of tasks
     */
    public int getSize() {
        return list.size();
    }

    /**
     * This method gives the specific task number
     * of the task specified by the user
     * @param i The task number to be shown
     * @return index of the task specified by the user
     */
    public Task getTaskList(int i) {
        return list.get(i);
    }

    /**
     * This method stores all the tasks specified
     * by the user
     * @param a The task to be stored
     */
    public static void store(Task a) {
        list.add(a);
        if (list.size() == 1) {
            System.out.println("Got it. I've added this task:\n"
                    + "   " + a.toString() + "\nNow you have " + list.size() + " task in the list");
        } else {
            System.out.println("Got it. I've added this task:\n"
                    + "   " + a.toString() + "\nNow you have " + list.size() + " tasks in the list");
        }
    }

    /**
     * This method deletes the task at the specified task number
     * @param i The task number of the task to be deleted
     * @throws NumberFormatException Catches invalid number formats
     */
    public static void delete(int i) throws NumberFormatException {
        System.out.println("Noted. I've removed this task:\n" + "   " + list.get(i).toString() );
        list.remove(i);
        System.out.println("Now you have " + list.size() + " tasks in the list");
    }

    /**
     * This method marks a task as complete when specified by the user
     * @param i The task number of the task to be marked as complete
     */
    public static void complete(int i) {
        list.get(i).markAsDone();
        System.out.println("Nice! I've marked this task as done:\n" + "  " + list.get(i).toString());
    }

    /**
     * This method finds tasks which contain a specified keyword from the user
     * @param match The keyword to be found in the current list of tasks
     */
    public static void find(String match) {
        System.out.println("Here are the matching tasks in your lists:");
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).description.contains(match)) {
                System.out.println(count+1 + "." + list.get(i).toString());
                count++;
            }
        }
    }

    /**
     * This method lists all the tasks that the user has specified so far
     */
    public static void listTask() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+1 + "." + list.get(i).toString());
        }
    }
}
