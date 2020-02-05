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
            this.taskArray.add(new Deadline(description.split("/by")[0], description.split("/by")[1]));
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
