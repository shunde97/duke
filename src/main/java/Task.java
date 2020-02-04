public class Task {
    protected String description;
    protected boolean isDone;
    protected String binary;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.binary = "0";
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getDescription(){
        return this.description;
    }

    public String getIcon() {
        if (isDone) {
            return "[\u2713]";
        } else {
            return "[\u2718]";
        }
    }

    public void markDone() {
        this.isDone = true;
        this.binary = "1";
    }

    public String saveTask(){
        return "T | " + this.binary + " | " + this.description;
    }

    @Override
    public String toString(){
        return this.getIcon() + " " + this.description;
    }
}
