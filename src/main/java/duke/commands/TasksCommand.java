package duke.commands;

import duke.ui.Ui;
import duke.data.TaskList;
import duke.storage.Storage;

public class TasksCommand extends Command {

    private String date;

    public TasksCommand(String date) {
        this.date = date;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList taskList) {
        String list = taskList.getTasks(this.date);
        ui.printList(list);
    }
}