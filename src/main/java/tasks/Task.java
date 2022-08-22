package tasks;

import java.time.LocalDate;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor to create a new task.
     * @param description The task description.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * To get the task status
     * @return A string that describes the task status. X indicates that the task is completed.
     */
    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    /**
     * To mark a task as completed.
     * @return A string that notifies the user if the task has been marked as done.
     */
    public String markAsDone() {
        this.isDone = true;
        return String.format("\tNice! I have marked this task as done:\n\t\t%s",
                this);
    }

    /**
     * To mark a task as not completed.
     * @return A string that notifies the user if the task has been marked as not done.
     */
    public String markAsNotDone() {
        this.isDone = false;
        return String.format("\tOkay! I have marked this task as not done:\n\t\t%s",
                this);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), this.description);
    }

    public void setIsDone(boolean value) {
        this.isDone = value;
    }

    public boolean getisDone() {
        return this.isDone;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract LocalDate getDate();

    public abstract String getTaskType();
}
