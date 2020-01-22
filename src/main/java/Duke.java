import java.util.Scanner;
import java.util.ArrayList;

public class Duke{
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
        while(!command.equals("bye")) {
            System.out.println(effect);
            if (command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                int index = 1;
                for (Task t : list) {
                    System.out.println(index + "." + t);
                    index++;
                }
            }
            else if (command.split(" ")[0].equals("done")){
                int target = Integer.parseInt(command.substring(5));
                Task taskDone = list.get(target - 1);
                taskDone.markDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(taskDone);
            }
            else {
                list.add(new Task(command));
                System.out.println("added: " + command);
            }
            System.out.println(effect);
            command = sc.nextLine();
        }
        System.out.println(effect + "\n" + "Bye! :) Hope to see you again soon!\n" + effect);
    }
}
