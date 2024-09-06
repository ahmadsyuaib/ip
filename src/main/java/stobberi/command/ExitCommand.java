package stobberi.command;

import stobberi.components.Ui;

/**
 * Represents a command that terminates the application.
 * This command sets the exit flag to true, indicating that the application should exit.
 */
public class ExitCommand extends Command {

    /**
     * Constructs a new {@code ExitCommand} and initializes the command with the exit flag set to false.
     */
    public ExitCommand() {
        super();
    }

    /**
     * Executes the command by setting the exit flag to true.
     * This indicates that the application should terminate.
     */
    @Override
    public String execute() {
        setExitTrue();
        return Ui.sayGoodbye();
    }
}
