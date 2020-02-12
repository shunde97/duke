import java.util.ArrayList;

public class CommandChecker {

    public void checkCommand(String command, ArrayList<Task> list) throws DukeException {
        if (command.length() < 4) {
            if (!command.equals("bye")) {
                throw new DukeException("☹ OOPS!!! I'm sorry, your command is too short \uD83D\uDE09 \n");
            }
        } else if (command.contains("todo") || command.contains("event") || command.contains("deadline") || command.contains("delete") || command.contains("done")) {
            if (command.substring(0, 4).equals("todo")) {
                if (command.equals("todo ") || command.equals("todo")) {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.\n");
                }
            } else if (command.substring(0, 4).equals("done")) {
                if (!command.contains(" ") || command.equals("done")) {
                    throw new DukeException("☹ OOPS!!! What task number have you accomplished?\n");
                }
                if (Integer.parseInt(command.substring(5)) > list.size()) {
                    throw new DukeException("☹ OOPS!!! The number you typed is too high!\n");
                }
                if (Integer.parseInt(command.substring(5)) < 0) {
                    throw new DukeException("☹ OOPS!!! You typed a negative number!\n");
                }
            } else if (command.substring(0, 5).equals("event")) {
                if ((command.equals("event")) || (command.equals("event "))) {
                    throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.\n");
                }
                if (!command.contains("/at")) {
                    throw new DukeException("☹ OOPS!!! Did you forget to add /at for your event???\n");
                }
                if (command.split("/at")[1].length() < 2) {
                    throw new DukeException("☹ OOPS!!! An event should have a day and time!!!\n");
                }
            } else if (command.substring(0, 6).equals("delete")) {
                if (!command.contains(" ") || command.equals("delete")) {
                    throw new DukeException("☹ OOPS!!! What task number did you want to delete?\n");
                }
                if (Integer.parseInt(command.substring(7)) > list.size()) {
                    throw new DukeException("☹ OOPS!!! The number you typed is too high!\n");
                }
                if (Integer.parseInt(command.substring(7)) < 0) {
                    throw new DukeException("☹ OOPS!!! You typed a negative number!\n");
                }
            } else if (command.substring(0, 8).equals("deadline")) {
                if ((command.equals("deadline ")) || (command.equals("deadline"))) {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n");
                }
                if (!command.contains("/by")) {
                    throw new DukeException("☹ OOPS!!! Did you forget to add /by for your deadline???\n");
                }
            }
        } else {
            if (command.contains("list") && !command.equals("list")) {
                throw new DukeException("☹ OOPS!!! did you mean to type \"list\"? ☹ \n");
            }
            if (!command.substring(0, 4).equals("list") && !command.startsWith("find")) {
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means ☹ \n");
            }
        }
    }
}