public class Parser {
    private String userInput;
    private String command;
    private String description;

    public Parser (String userInput) {
        this.userInput = userInput;
        this.command = userInput.split(" ")[0];
        if (userInput.split(" ").length > 1) {
            this.description = userInput.split(" ", 2)[1];
        } else {
            this.description = "";
        }
    }

    public String getCommand() {
        return this.command;
    }

    public void verifyCommand(TaskList tasks) {
        CommandChecker commandChecker = new CommandChecker();
        try{
            commandChecker.checkCommand(userInput, tasks.getTaskArray());
        } catch (DukeException e)  {
            System.err.println(e);
        }
    }

    public String getDescription() {
        return this.description;
    }

}
