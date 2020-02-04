import java.util.ArrayList;

public class Ui {

    private Storage storage;
    public ArrayList<Task> listOfTasks;
    private boolean isFinished;
    private String effect;

    public Ui() {
        this.listOfTasks = new ArrayList<>();
        this.isFinished = false;
        this.effect = "************************************************************";
    }

    public void greet(String effect) {
        String logo = " ____        _        \n"
                   + "|  _ \\ _   _| | _____ \n"
                   + "| | | | | | | |/ / _ \\\n"
                   + "| |_| | |_| |   <  __/\n"
                   + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hi! I'm\n"+logo);
        System.out.println(effect +"\nHi! I'm\n"+logo);
        System.out.println("What can I do for you?\n"+effect);
        this.listOfTasks = storage.loadCurrentData();
    }

    public void handleAction(String command, String effect) {

    }

}
