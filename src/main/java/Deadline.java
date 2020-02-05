import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Deadline extends Task {
    private String dateInput;
    private LocalDate date;
    private boolean hasTime;
    private String timeInput;

    public Deadline(String description, String dateInput) {
        super(description);
        this.hasTime = false;
        if (dateInput.split(" ").length > 1) {
            this.dateInput = dateInput.split(" ")[0];
            this.timeInput = dateInput.split(" ")[1];
            this.hasTime = true;
        }
            this.date = LocalDate.parse(this.dateInput);
    }

    public Deadline(String description, String dateInput, String timeInput) {
        super(description);
        this.dateInput = dateInput;
        this.timeInput = timeInput;
        this.date = LocalDate.parse(dateInput);
        this.hasTime = true;
    }

    @Override
    public String saveTask() {
        if (!hasTime) {
            return "D | " + this.binary + " | " + this.description + " | " + this.dateInput;
        } else {
            return "D | " + this.binary + " | " + this.description + " | " + this.dateInput + " " + this.timeInput;
        }
    }

    @Override
    public String toString() {
        if (!hasTime) {
            return "     [D]" + this.getIcon() + " " + this.description + " (by: "
                    + this.date.getDayOfWeek().toString().substring(0,3)  + " "
                    + this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
        } else {
            return "     [D]" + this.getIcon() + " " + this.description + " (by: "
                    + this.date.getDayOfWeek().toString().substring(0,3)  + " "
                    + this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " " + this.timeInput + "hrs)";
        }
    }
}
