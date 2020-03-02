package dukeclass;



/**
 * CS2103 Individual Project.
 * Class for Duke chat bot with main class.
 * This program is a chat bot which manages a list of tasks. Upon exit, the tasks will
 * be saved to a data file.
 * @author Chiang Shun De
 */

public class Duke {

    private Storage storage;
    private Ui ui;
    private TaskList tasks;

    /**
     * Constructor method to create an instance of Duke.
     */
    public Duke() {
        ui = new Ui();
    }



    /**
     * Handles the main operations of Duke.
     * A scanner will scan the user input and this method will return the corresponding
     * action. Once the operations has been completed, a file will be saved based on the
     * current list.
     */
    public String run(String userInput) {
        assert userInput.length() > 0 : "The input is not valid.";
        Parser parser = new Parser(userInput);
        parser.verifyCommand(userInput, this.ui.tasks);
        return this.ui.handleInput(userInput);
    }

    /**
     * The main method for Duke.
     * The method creates an instance of Duke based on the file location and starts the
     * operations of Duke.
     */


    protected String getResponse(String input) {
        return this.run(input);
    }





}


