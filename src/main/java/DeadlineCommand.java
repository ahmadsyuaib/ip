import StobberiException.EmptyStobberiException;
import StobberiException.StobberiException;
import StobberiException.WrongDateTimeStobberiException;

import java.time.format.DateTimeParseException;

public class DeadlineCommand extends Command {
    private TaskList taskList;
    private String descriptions;
    public DeadlineCommand(TaskList taskList, String descriptions) {
        this.taskList = taskList;
        this.descriptions = descriptions;
    }

    @Override
    public void execute() throws StobberiException {
        if (descriptions.isEmpty()) {
            throw new EmptyStobberiException("Where is the task?");
        }
        String[] parts = descriptions.split(" /by ");
        try {
            taskList.addTask(new Deadline(parts[0], parts[1]));
        } catch (DateTimeParseException e) {
            throw new WrongDateTimeStobberiException("Date and Time needs to be in the format dd-MM-yyyy HHmm'hrs'\n Example: 27-12-2004 1700hrs\n");
        }
    }
}