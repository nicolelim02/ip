public class Deadline extends Task{
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + String.format(" (by: %s)", this.by);
    }

    @Override
    public String getDate() {
        return this.by;
    }

    @Override
    public String getTaskType() {
        return "D";
    }
}
