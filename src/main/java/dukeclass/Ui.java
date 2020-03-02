package dukeclass;

import java.util.ArrayList;

/**
 * CS2103 Individual Project.
 * The Ui class encapsulates all the methods dealing with user interactions. It takes in user input
 * and determines the corresponding action. It contains a boolean to determine if the user wants to end
 * the chat bot operations.
 * @author Chiang Shun De
 */
public class Ui {

    private Storage storage;
    public TaskList tasks;
    private boolean isFinished;


    /**
     * Constructor method to create an instance of Ui.
     */
    public Ui() {
        this.isFinished = false;
        this.storage = new Storage("data/data.txt");
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            showLoadingError(e);
            this.tasks = new TaskList();
        }
    }

    /**
     * Method to print out the greeting messages to welcome the user to the chat bot.
     * @return A string greeting for the chatbot.
     */
    public String greet() {
        return "Hello I'm Double McSpicy!\nWhat can I do for you?";
    }

    /**
     * This method takes in the user input and perform the required actions based on user input.
     *
     * @param userInput String containing user input
     */
    public String handleInput(String userInput) {
        try {
            Parser parser = new Parser(userInput);
            String command = parser.getCommand();
            String description = parser.getDescription();
            switch (command) {
                case "list":
                    if (this.tasks.getSize() == 0) {
                        return "YAY You have 0 tasks in your list! :)";
                    } else {
                        return "Here are the tasks in your list:" + this.tasks.printTasks();
                    }
                case "done":
                    if ((Integer.parseInt(description)) <= this.tasks.getSize()) {
                        this.tasks.markDone(Integer.parseInt(description) - 1);
                        return "Nice! I've marked this task as done: \n" + this.tasks.get(Integer.parseInt(description) - 1);
                    } else {
                        return "the number u keyed in is too high ";
                    }
                case "delete":
                    if ((Integer.parseInt(description)) <= this.tasks.getSize()) {
                        System.out.println();
                        Task temp = this.tasks.get(Integer.parseInt(description) - 1);
                        this.tasks.deleteTask(Integer.parseInt(description) - 1);
                        return "Noted. I've removed this task: \n" + temp.toString() + "\nNow you have " + Integer.valueOf(this.tasks.getSize()).toString() + " tasks in the list.";
                    } else {
                        return "the number u keyed in is too high ";
                    }
                case "massdelete":
                    ArrayList<Task> massTasks = new ArrayList<>();
                    massTasks = this.tasks.searchTask(description);
                    StringBuilder massDeleteString = new StringBuilder("");
                    for (Task t : massTasks) {
                        massDeleteString.append("\n" + t.toString());
                    }
                    this.tasks.massDelete(description);
                    if (description.equals("all")) {
                        return "Noted. I've removed all tasks! \n Now you have 0 tasks! :)";
                    } else {

                        return "Noted. I've removed these tasks with the keyword: " + description + massDeleteString.toString() + "\nNow you have " + Integer.valueOf(this.tasks.getSize()).toString() + " tasks in the list.";
                    }
                case "massdone":
                    this.tasks.massDone(description);
                    if (description.equals("all")) {
                        return "Noted. I've marked all tasks as done!" + "\nNow you have " + Integer.valueOf(this.tasks.getSize()).toString() + " tasks in the list.";
                    } else {
                        return "Noted. I've marked done these tasks with the keyword: " + description + "\nNow you have " + Integer.valueOf(this.tasks.getSize()).toString() + " tasks in the list.";
                    }
                case "todo":
                case "deadline":
                case "event":
                    this.tasks.addTask(command, description);
                    return "Got it! I've added this task:\n" + this.tasks.get(this.tasks.getSize() - 1) + "\n" + "Now you have " + Integer.valueOf(this.tasks.getSize()).toString() + " tasks in the list.";
                case "find":
                    ArrayList<Task> correctTasks = new ArrayList<>();
                    correctTasks = this.tasks.searchTask(description);
                    StringBuilder matchingTasks = new StringBuilder("Here are the matching tasks in your list:");
                    for (Task t : correctTasks) {
                        matchingTasks.append("\n" + t.toString());
                    }
                    return matchingTasks.toString();
                case "bye":
                    storage.saveCurrentList(this.tasks.getTaskArray());
                    return this.farewell();
                default:
                    return "sorry got error";
            }
        } catch (DukeException e) {
            return e.getMessage();
        }
    }

    /**
     * To bid farewell to the user before the chat bot closes.
     * @return A string representation of the bot farewell
     */
    public String farewell() {
        return "Bye! :') Hope to see you again soon!\n";
    }

    public void showLoadingError(DukeException e) {
        e.printStackTrace();
        System.out.println(":( OOPS!!! LOADING ERROR...");
    }

    /**
     * Checks if the user has keyed in "bye" to end chat bot operations.
     * @return true if there are still actions to be inputted, false if the user has keyed in "bye".
     */
    public boolean checkFinished() {
        return this.isFinished;
    }

    public void updateTaskList(TaskList taskList) {
        this.tasks = taskList;
    }
}
