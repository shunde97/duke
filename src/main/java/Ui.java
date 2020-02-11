import java.util.ArrayList;

public class Ui {

    private Storage storage;
    public TaskList tasks;
    private boolean isFinished;
    private String effect;

    public Ui() {
        this.isFinished = false;
        this.effect = "************************************************************";
    }

    public void greet(String effect) {
        String logo = " ____        _        \n"
                   + "|  _ \\ _   _| | _____ \n"
                   + "| | | | | | | |/ / _ \\\n"
                   + "| |_| | |_| |   <  __/\n"
                   + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(effect +"\nHi! I'm\n"+logo);
        System.out.println("What can I do for you?\n"+effect);
    }

    public TaskList handleInput(String userInput, TaskList tasks) {
        Parser parser = new Parser(userInput);
        String command = parser.getCommand();
        String description = parser.getDescription();
        if (command.equals("list")) {
            System.out.println(this.effect);
            if (tasks.getSize() == 0) {
                System.out.println("😊 You have 0 tasks in your list! 😊");
            } else {
                System.out.println("Here are the tasks in your list:");
                tasks.printlist();
            }
            System.out.println(this.effect);
        } else if (command.equals("done") && ((Integer.parseInt(description) - 1) <= tasks.getSize())) {
            System.out.println(this.effect + "\nNice! I've marked this task as done:");
            tasks = tasks.markDone(Integer.parseInt(description) - 1);
            System.out.println(tasks.get(Integer.parseInt(description) - 1));
            System.out.println(this.effect);
        } else if (command.equals("delete") && ((Integer.parseInt(description) - 1) <= tasks.getSize())) {
            System.out.println(this.effect + "\nNoted. I've removed this task:");
            System.out.println(tasks.get(Integer.parseInt(description) - 1));
            tasks = tasks.deleteTask(Integer.parseInt(description) - 1);
            System.out.println("Now you have " + tasks.getSize() + " tasks in the list.");
            System.out.println(this.effect);
        } else if (command.equals("bye")) {
            this.isFinished = true;
        } else if (((command.equals("todo")) || (command.equals("deadline")) || (command.equals("event"))) && (!description.isBlank())) {
            tasks = tasks.addTask(command, description);
            System.out.println(this.effect + "\nGot it! I've added this task:\n" + tasks.get(tasks.getSize() - 1));
            System.out.println("Now you have " + tasks.getSize() + " tasks in the list.");
            System.out.println(this.effect);
        }
        return tasks;
    }

    public void farewell() {
        System.out.println("\n" + "Bye! :) Hope to see you again soon!\n");
    }

    public void showLoadingError(DukeException e) {
        e.printStackTrace();
        System.out.println("☹ OOPS!!! LOADING ERROR...");
    }

    public boolean checkFinished() {
        return this.isFinished;
    }
}
