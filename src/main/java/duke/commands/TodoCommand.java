package duke.commands;

import duke.ui.Ui;
import duke.data.TaskList;
import duke.tasks.ToDo;
import duke.data.exception.DukeException;
import duke.storage.Storage;

public class TodoCommand extends Command {

    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Storage storage, TaskList taskList) throws DukeException {
        ToDo toDo = new ToDo(this.description);
        taskList.addToList(toDo);
        storage.save(taskList);
        ui.printAddTask(toDo, taskList.getSize());
    }
}