import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


public class Storage {
    private Storage storage;
    private String fileName;
    private String stringSplitter = " " + "\\|" + " ";

    public Storage(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineRead = bufferedReader.readLine();
            while (lineRead != null) {
                String[] dataLine = lineRead.split(stringSplitter);
                Task task = new Task("");
                    if (dataLine[0].equals("T")) {
                        task = new Todo(dataLine[2]);
                    } else if (dataLine[0].equals("E")) {
                        task = new Event(dataLine[2], dataLine[3]);
                    } else if (dataLine[0].equals("D")) {
                        task = new Deadline(dataLine[2], dataLine[3]);
                    }
                    if (dataLine[1].equals("1")) {
                        task.markDone();
                    }
                    tasks.add(task);
                lineRead = bufferedReader.readLine();
            }
            if (tasks.size() == 0) {
                System.out.println("File is empty");
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found at: " + fileName);
            System.out.println("Creating one now...");
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
        }
        System.out.println("done with loading");
        return tasks;
    }

    public void saveCurrentList(ArrayList<Task> list) {
        try {
            FileWriter fileWriter = new FileWriter(this.fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                Task task = list.get(i);
                bufferedWriter.write(task.saveTask());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
