import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskArray;

    public TaskList(ArrayList<Task> taskArray) {
        this.taskArray = taskArray;
    }

    public TaskList() {
        this.taskArray = new ArrayList<>();
    }

    public void printlist(){
        int index = 1;
        for (Task t : taskArray) {
            System.out.println(index + "." + t);
            index++;
        }
    }

    public TaskList addTask (String command, String description) {
        if (command.equals("deadline")) {
            if (description.split(" /by ")[1].split(" ").length == 1) {
                String date = description.split(" /by ")[1].split(" ")[0];
                if (date.contains("/")) {
                    String day = date.split("/")[0];
                    String month = date.split("/")[1];
                    String year = date.split("/")[2];
                    date = year + "-" + month + "-" + day;
                }
                this.taskArray.add(new Deadline(description.split(" /by ")[0], date));
            } else {
                String date = description.split(" /by ")[1].split(" ")[0];
                String time = description.split(" /by ")[1].split(" ")[1];
                if (date.contains("/")) {
                    String day = date.split("/")[0];
                    String month = date.split("/")[1];
                    String year = date.split("/")[2];
                    date = year + "-" + month + "-" + day;
                }
                this.taskArray.add(new Deadline(description.split(" /by ")[0], date, time));
            }
        } else if (command.startsWith("todo")) {
            this.taskArray.add(new Todo(description));
        } else if (command.startsWith("event")) {
            this.taskArray.add(new Event(description.split("/at")[0], description.split("/at")[1]));
        }
        return new TaskList(taskArray);
    }

    public TaskList deleteTask (int target) {
        this.taskArray.remove(target);
        return new TaskList(taskArray);
    }

    public void searchTask (String keyWord) {
        int i = 1;
        for (Task task : taskArray) {
            if (task.getDescription().contains(keyWord)) {
                System.out.println(i + "." + task);
                i++;
            }
        }
    }

    public TaskList markDone(int target) {
        this.taskArray.get(target).markDone();
        return new TaskList(taskArray);
    }

    public Task get(int i) {
        return this.taskArray.get(i);
    }

    public int getSize(){
        return this.taskArray.size();
    }

    public ArrayList<Task> getTaskArray() {
        return this.taskArray;
    }

}
