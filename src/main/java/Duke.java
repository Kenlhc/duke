import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static void Greet() {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }

    private static void Exit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    private static void Store(ArrayList<String> a, String b) {
        a.add(b);
        System.out.println("added: " + b);
    }

    private static void Echo(ArrayList<String> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println(i+1 + ". " + a.get(i));
        }
    }

    public static void main(String[] args) {
        Greet();
        Scanner obj = new Scanner(System.in);
        String input;
        ArrayList<String> list = new ArrayList<String>();
        while (!(input = obj.nextLine()).equals("bye")) {
            if (!input.equals("list")) {
                Store(list, input);
            } else {
                Echo(list);
            }
        }
        Exit();
    }

}
