package duke.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import duke.data.exception.DukeException;
import duke.tasks.Task;

/**
 * This class encapsulates a list of tasks
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Constructs a new Task List
     * @param tasks The list of tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * To list down all the tasks that are added to the list.
     * @return A list of all the tasks added.
     */
    public ArrayList<Task> list() {
        return this.tasks;
    }

    /**
     * Gets all the task that falls on the specified date
     * @param date Date of the tasks
     * @return A string consisting of all the tasks
     */
    public List<Task> getTasks(String date) {
        Predicate<Task> isTaskValid = task -> {
            LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            boolean hasValidTaskType = task.getTaskType().equals("D") || task.getTaskType().equals("E");
            boolean hasCorrectDate = task.getDate() != null && task.getDate().equals(parsedDate);
            return hasValidTaskType && hasCorrectDate;
        };

        List<Task> results = tasks.stream().filter(isTaskValid).collect(Collectors.toList());

        return results;
    }

    /**
     * Adds a task to the list
     * @param task The task to be added
     */
    public void addToList(Task task) {
        this.tasks.add(task);
    }

    /**
     * Gets the number of tasks in the list
     * @return The number of tasks in the list
     */
    public int getSize() {
        return this.tasks.size();
    }

    /**
     * Gets the task at the specified index
     * @param i Index of the task
     * @return The task with the specified index
     * @throws DukeException If the task does not exist
     */
    public Task getTask(int i) throws DukeException {
        if (i > this.tasks.size() || i < 0) {
            throw new DukeException("No such task exists!");
        }

        return this.tasks.get(i);
    }

    /**
     * Deletes the task at the specified index
     * @param i The index of the task
     * @return The deleted task
     * @throws DukeException If the task does not exist
     */
    public Task deleteTask(int i) throws DukeException {
        if (i > this.tasks.size() || i < 0) {
            throw new DukeException("No such task exist!");
        }

        Task task = this.tasks.get(i - 1);
        this.tasks.remove(i - 1);
        return task;
    }

    /**
     * Finds the tasks based on the given keyword
     * @param keywords Keyword used to search for tasks
     * @return A list of tasks containing the keyword provided
     */
    public List<Task> find(String ...keywords) {
        List<Task> results = tasks.stream()
                .filter(task -> containsAllKeywords(task.getDescription(), keywords))
                .collect(Collectors.toList());

        return results;
    }

    private boolean containsAllKeywords(String description, String ...keywords) {
        long numOfKeywords = Arrays.stream(keywords)
                .filter(description::contains)
                .count();

        return numOfKeywords == keywords.length;

    }
}
