import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static ArrayList<Task> list = new ArrayList<>();

    private static void greet() {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }

    private static void exit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    private static void store(Task a) {
        list.add(a);
        if (list.size() == 1) {
            System.out.println("Got it. I've added this task:\n"
                    + "   " + a.toString()
                    + "\nNow you have " + list.size() + " task in the list");
        } else {
            System.out.println("Got it. I've added this task:\n"
                    + "   " + a.toString()
                    + "\nNow you have " + list.size() + " tasks in the list");
        }
    }

    private static void echo() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+1 + "." + list.get(i).toString());
        }
    }

    private static void taskComplete(int i) {
        list.get(i).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(list.get(i).toString());
    }

    private static void removeTask(int i) {
        System.out.println("Okay! I've removed this task:");
        System.out.println(list.get(i).toString());
        list.remove(i);
    }

    public static void main(String[] args) {
        greet();
        Scanner obj = new Scanner(System.in);
        String input;
        while (!(input = obj.nextLine()).equals("bye")) {
            if (input.equals("list")) {
                echo();
            } else if (input.isEmpty()) {
                System.out.println("You did not enter a task, what can I do for you?");
            } else {
                String[] words = input.split(" ", 2);
                if (words[0].equals("done") || words[0].equals("Done")) {
                    int check = Integer.parseInt(words[1]) - 1;
                    taskComplete(check);
                } else if (words[0].equals("remove") || words[0].equals("Remove")) {
                    int check = Integer.parseInt(words[1]) - 1;
                    removeTask(check);
                } else if (words[0].equals("todo")) {
                    Task task = new Todo(words[1]);
                    store(task);
                } else if (words[0].equals("deadline")) {
                    String[] splitter = words[1].split("/by");
                    Task task = new Deadline(splitter[0].trim(), splitter[1].trim());
                    store(task);
                } else if (words[0].equals("event")) {
                    String[] splitter = words[1].split("/at");
                    Task task = new Event(splitter[0].trim(), splitter[1].trim());
                    store(task);
                }
            }
        }
        exit();
    }

}