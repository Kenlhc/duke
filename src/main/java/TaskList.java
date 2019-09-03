import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> list;

    public TaskList() {
    }

    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public int getSize() {
        return list.size();
    }

    public Task getTaskList(int i) {
        return list.get(i);
    }

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

    public static void delete(int i) throws NumberFormatException {
        System.out.println("Noted. I've removed this task:");
        System.out.println("   " + list.get(i).toString());
        list.remove(i);
        System.out.println("Now you have " + list.size() + " tasks in the list");
    }

    public static void complete(int i) {
        list.get(i).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(list.get(i).toString());
    }

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

    public static void echo() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+1 + "." + list.get(i).toString());
        }
    }
}
