import java.io.*;
import java.util.ArrayList;

public class Storage {
    private static String filename;

    public Storage(String filename) {
        this.filename = filename;
    }

    public static void writeFile(TaskList list) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\duke\\data\\tasks.txt"));
            for (int i = 0; i < list.getSize(); i++) {
                bufferedWriter.write(list.getTaskList(i) + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("There's no file");
            e.printStackTrace();
        }
    }

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
        } catch (IOException e) {
            System.out.println("There's no file");
            e.printStackTrace();
        }
        return list;
    }
}
