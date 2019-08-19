import java.util.Scanner;

public class Duke {
    private static void Greet() {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }

    private static void Echo(String a) {
        System.out.println(a);
    }

    private static void Exit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void main(String[] args) {
        Greet();
        Scanner obj = new Scanner(System.in);
        String input;
        while (!(input = obj.nextLine()).equals("bye")) {
            Echo(input);
        }
        Exit();
    }

}
