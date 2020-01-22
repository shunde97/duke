import java.util.Scanner;
import java.util.ArrayList;

public class Duke{
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Hi! I'm\n" + logo);
        String effect = "************************************************************";
        System.out.println(effect + "\nHi! I'm\n" + logo);
        System.out.println("What can I do for you?\n" + effect);
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while(!command.equals("bye")) {
            System.out.println(effect);
            if (command.equals("list")) {
                int index = 1;
                for (String s : list) {
                    System.out.println(index + ". " + s);
                    index++;
                }
            }
            else {
                list.add(command);
                System.out.println("added: " + command);
            }
            System.out.println(effect);
            command = sc.nextLine();
        }
        System.out.println(effect + "\n" + "Bye! :) Hope to see you again soon!\n" + effect);
    }
}
