import java.util.Scanner;

public class Ui {
    public String readInput() {
        Scanner obj = new Scanner(System.in);
        return obj.nextLine();
    }

    public void greet() {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }

    public void showLoadingError() {
        System.out.println("Sorry. The file does not exist.");
    }

    public void exit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

}
