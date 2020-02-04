public class Deadline extends Task {
    private String date;

    public Deadline(String description, String date) {
        super(description);
        this.date = date;
    }

    @Override
    public String saveTask(){
        return "D | " + this.binary + " | " + this.description + " | " + this.date;
    }

    @Override
    public String toString() {
        return "     [D]" + this.getIcon() + " " + this.description + "(by:" + this.date + ")";
    }
}
