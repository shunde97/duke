import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    private Storage storage;
    private Ui ui;
    private String effect;
    private TaskList tasks;

    public Duke(String filePath) {
        this.ui = new Ui();
        this.effect = "************************************************************";
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError(e);
            tasks = new TaskList();
        }
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        ui.greet(this.effect);
        while(!ui.isFinished()) {
            String userInput = sc.nextLine();
            ui.handleInput(userInput, effect);
            command = sc.nextLine();
        }
    }


    Scanner sc = new Scanner(System.in);
    String command = sc.nextLine();
        System.out.println(command.split(" ")[0]);
        while(!command.equals("bye"))

    {


        System.out.println(effect +"\n"+"Bye! :) Hope to see you again soon!\n"+effect);
}

    public static ArrayList<Task> listAction(ArrayList<Task> list, String command, String effect) {
        System.out.println(effect);
        if (command.equals("list")) {
            System.out.println("Here are the tasks in your list:");
            int index = 1;
            for (Task t : list) {
                System.out.println(index + "." + t);
                index++;
            }
        } else if (command.split(" ")[0].equals("done")) {
            int target = Integer.parseInt(command.substring(5));
            Task taskDone = list.get(target - 1);
            taskDone.markDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(taskDone);
        } else if (command.split(" ")[0].equals("delete")) {
            System.out.println("Noted. I've removed this task:");
            System.out.println(list.get(Integer.parseInt(command.substring(7)) - 1));
            list.remove(Integer.parseInt(command.substring(7)) - 1);
            System.out.println("Now you have " + list.size() + " tasks in the list.");
        } else {
            if (command.startsWith("deadline")) {
                list.add(new Deadline(command.substring(9).split("/by")[0], command.substring(9).split("/by")[1]));
            } else if (command.startsWith("todo")) {
                list.add(new Todo(command.substring(5)));
            } else if (command.startsWith("event")) {
                list.add(new Event(command.substring(6).split("/at")[0], command.substring(6).split("/at")[1]));
            }
            System.out.println("Got it! I've added this task:\n" + list.get(list.size() - 1));
            System.out.println("Now you have " + list.size() + " tasks in the list.");
        }
        System.out.println(effect);
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        new Duke("data/data.txt").run();
    }
}


