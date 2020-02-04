public class Event extends Task {
    private String deadline;

    public Event(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String saveTask(){
        return "E | " + this.binary + " | " + this.description + " | " + this.deadline;
    }

    @Override
    public String toString() {
        return "     [E]" + this.getIcon() + " " + this.description + "(at:" + this.deadline + ")";
    }
}