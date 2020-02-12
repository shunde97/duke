import java.util.Scanner;





public class Duke {

    private Storage storage;
    private Ui ui;
    private String effect;
    private TaskList tasks;

    public Duke(String filePath) {
        this.effect = "************************************************************";
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError(e);
            this.tasks = new TaskList();
        }
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        ui.greet(this.effect);
        while(!ui.checkFinished()) {
            String userInput = sc.nextLine();
            Parser parser = new Parser(userInput);
            parser.verifyCommand(this.tasks);
            this.tasks = ui.handleInput(userInput, tasks);
        }
        ui.farewell();
        storage.saveCurrentList(this.tasks.getTaskArray());
    }


    public static void main(String[] args) {
        System.out.println("booting up...");
        new Duke("data/data.txt").run();
    }
}


