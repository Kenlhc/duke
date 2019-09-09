package duke.ui;

import java.util.Scanner;

/**
 * This User Interface program implements methods for user interaction
 */
public class Ui {
    /**
     * The input from the user to be read
     */
    Scanner obj = new Scanner(System.in);

    /**
     * This method will read the input given by the user
     * @return Scanner to continue scanning the next line of input
     */
    public String readInput() {
        return obj.nextLine();
    }

    /**
     * This method greets the user upon successful launch of Duke
     */
    public void greet() {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }

    /**
     * This method shows the user that an error has occurred when trying to retrieve the
     * saved file
     */
    public void showLoadingError() {
        System.out.println("Sorry. The file does not exist.");
    }

    /**
     * This method tells the user that the program will exit
     */
    public void exit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

}
