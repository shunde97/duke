public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
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
    }

    @Override
    public String toString(){
        return this.getIcon() + " " + this.description;
    }
}
