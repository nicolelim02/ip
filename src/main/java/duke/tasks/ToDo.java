package duke.tasks;

import java.time.LocalDate;

public class ToDo extends Task {

    /**
     * Constructs a new ToDo
     * @param description The description of the task
     */
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Gets the date of the task
     * @return The date of the task
     */
    @Override
    public LocalDate getDate() {
        return null;
    }

    /**
     * Gets the task type
     * @return The task type
     */
    @Override
    public String getTaskType() {
        return "T";
    }
}
