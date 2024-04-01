package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.*;

import seedu.address.model.Model;

/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    private final String keyword;

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": List all persons in either the archived or"
            + " unarchived list.\n"
            + "Example: " + COMMAND_WORD + "archive"
            + "Example: " + COMMAND_WORD + "main"
            + "Example: " + COMMAND_WORD + "all";
    public static final String MESSAGE_SUCCESS = "Listed all employees";

    public ListCommand(String keyword) {
        this.keyword = keyword;
    }
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        switch (keyword) {
            case "archive":
                model.updateFilteredPersonList(PREDICATE_SHOW_ALL_ARCHIVED_PERSONS);
                return new CommandResult(MESSAGE_SUCCESS);
            case "main":
                model.updateFilteredPersonList(PREDICATE_SHOW_ALL_UNARCHIVED_PERSONS);
                return new CommandResult(MESSAGE_SUCCESS);
            case "all":
                model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
                return new CommandResult(MESSAGE_SUCCESS);
            default:
                model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
                return new CommandResult(MESSAGE_USAGE);
        }
    }
}
