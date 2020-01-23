import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        ArrayList<Task> list = new ArrayList<>();
        System.out.println("Hi! I'm\n" + logo);
        String effect = "************************************************************";
        System.out.println(effect + "\nHi! I'm\n" + logo);
        System.out.println("What can I do for you?\n" + effect);
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        System.out.println(command.split(" ")[0]);
        while (!command.equals("bye")) {
            CommandChecker cc = new CommandChecker();
            try {
                cc.checkCommand(command, list);
                listAction(list, command, effect);
            } catch (DukeException e) {
                System.err.println(e);
            }
            command = sc.nextLine();
        }
        System.out.println(effect + "\n" + "Bye! :) Hope to see you again soon!\n" + effect);
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
        } else {
            if (command.startsWith("deadline")) {
                list.add(new Deadline(command.substring(9).split("/by")[0], command.substring(9).split("/by")[1]));
            } else if (command.startsWith("todo")) {
                list.add(new Todo(command.substring(5)));
            } else if (command.startsWith("event")) {
                list.add(new Event(command.substring(6).split("/at")[0], command.substring(6).split("/at")[1]));
            }
            System.out.println("Got it. I've added this task:\n" + list.get(list.size() - 1));
            System.out.println("Now you have " + list.size() + " tasks in the list.");
        }
        System.out.println(effect);
        return new ArrayList<>(list);
    }
}


