import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static ArrayList<Task> list = new ArrayList<>();
    private static final String FILENAME = "C:\\Users\\user\\Desktop\\duke\\data\\tasks.txt";

    private static void greet() {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }

    private static void exit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    private static void storeTask(Task a) {
        list.add(a);
        writeFile(FILENAME);
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
        writeFile(FILENAME);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(list.get(i).toString());
    }

    private static void removeTask(int i) {
        System.out.println("Okay! I've removed this task:");
        System.out.println(list.get(i).toString());
        list.remove(i);
        writeFile(FILENAME);
    }

    private static void writeFile(String name) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(name));
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i) + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("There's no file");
            e.printStackTrace();
        }
    }

    private static void readFile(String name) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
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
                    String[] splitter = input.split("\\(by:",2);
                    String remove_bracket = splitter[1].substring(0, splitter[1].length()-1);
                    Task task = new Deadline(splitter[0].trim(), remove_bracket.trim());
                    list.add(task);
                    if (status.equals("[\u2713]")) {
                        list.get(count).markAsDone();
                    }
                    count += 1;
                } else if (input.startsWith("[E]")) {
                    input = input.substring(7);
                    String[] splitter = input.split("\\(at:", 2);
                    String remove_bracket = splitter[1].substring(0, splitter[1].length()-1);
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
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("There's no file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        greet();
        Scanner obj = new Scanner(System.in);
        String input;
        readFile(FILENAME);
        while (true) {
            try {
                input = obj.nextLine();
                if (input.equals("bye")) {
                    exit();
                    break;
                } else if (input.equals("list")) {
                    echo();
                } else if (input.isEmpty()) {
                    throw new DukeException("\u2639 OOPS!!! You did not enter anything.");
                } else {
                    String[] words = input.split(" ", 2);
                    switch (words[0]) {
                        case "done":
                        case "Done": {
                            if (words.length == 1) {
                                throw new DukeException("\u2639 OOPS!!! You did not specify a task number to mark as done.");
                            }
                            int check = Integer.parseInt(words[1]) - 1;
                            taskComplete(check);
                            break;
                        }
                        case "remove":
                        case "Remove": {
                            int check = Integer.parseInt(words[1]) - 1;
                            removeTask(check);
                            break;
                        }
                        case "todo": {
                            if (words.length == 1) {
                                throw new DukeException("\u2639 OOPS!!! The description of a todo cannot be empty.");
                            }
                            Task task = new Todo(words[1]);
                            storeTask(task);
                            break;
                        }
                        case "deadline": {
                            if (words.length == 1) {
                                throw new DukeException("\u2639 OOPS!!! The description of a deadline cannot be empty.");
                            }
                            String[] splitter = words[1].split("/by");
                            Task task = new Deadline(splitter[0].trim(), splitter[1].trim());
                            storeTask(task);
                            break;
                        }
                        case "event": {
                            if (words.length == 1) {
                                throw new DukeException("\u2639 OOPS!!! The description of an event cannot be empty.");
                            }
                            String[] splitter = words[1].split("/at");
                            Task task = new Event(splitter[0].trim(), splitter[1].trim());
                            storeTask(task);
                            break;
                        }
                        default:
                            throw new DukeException("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                }
            } catch (DukeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Please enter a task.");
            }
        }
    }
}