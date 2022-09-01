package duke.commands;

import java.util.ArrayList;
import java.util.List;

import duke.data.TaskList;
import duke.storage.Storage;
import duke.tasks.Task;
import duke.ui.Ui;

/**
 * This class represents a command to list out the tasks in the task list
 * If a date is provided, tasks that fall on that date will be listed
 */
public class ListCommand extends Command {

    private String date;

    /**
     * Constructs a new list command
     *
     * @param info Essential information for the output list
     */
    public ListCommand(String... info) {
        super();
        if (info.length == 0) {
            this.date = null;
        } else {
            this.date = info[0];
        }
    }

    /**
     * Checks if the command is an Exit Command
     *
     * @return True if it is an Exit Command
     */
    @Override
    public boolean isExit() {
        return false;
    }

    /**
     * Executes the Command
     * @param ui Prints the messages based on the type of Command
     * @param storage Saves the modified list of tasks
     * @param taskList List of tasks
     */
    @Override
    public String execute(Ui ui, Storage storage, TaskList taskList) {
        if (date == null) {
            ArrayList<Task> list = taskList.list();
            return ui.printList(list);
        } else {
            List<Task> list = taskList.getTasks(date);
            return ui.printTasks(list, date);
        }
    }
}
