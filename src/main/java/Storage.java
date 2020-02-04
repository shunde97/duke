import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


public class Storage {
    ArrayList<Task> listOfTasks = new ArrayList<>();
    private Storage storage;
    String fileName = "data/data.txt";
    public Storage() {
    }

    public ArrayList<Task> loadCurrentData() {
        try {
            FileReader fileReader = new FileReader(this.fileName);
            BufferedReader bufferedReader = new BufferedReader(this.fileName);
            while (bufferedReader.readLine() != null) {
                String[] dataLine = bufferedReader.readLine().split(" | ");
                Task task;
                if (dataLine[0].startsWith("T")) {
                    task = new Todo(dataLine[2]);
                } else if (dataLine[0].startsWith("E")) {
                    task = new Event(dataLine[2], dataLine[3]);
                } else if (dataLine[0].startsWith("D")) {
                    task = new Deadline(dataLine[2], dataLine[3]);
                }
                if (dataLine[1].equals("1")) {
                    task.markDone();
                }
                listOfTasks.add(task);
            }
            if (listOfTasks.size() == 0) {
                System.out.println("File is empty");
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
        }
        return listOfTasks;
    }

    public void saveCurrentList(ArrayList<Task> list) {
        FileWriter fileWriter = new FileWriter(this.fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(this.fileName);
        try {
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
