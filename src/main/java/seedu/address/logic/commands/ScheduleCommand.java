package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

import java.time.LocalDate;


/**
 * Adds a person to the address book.
 */
public class ScheduleCommand extends Command {

    public static final String COMMAND_WORD = "schedule";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the schedule. "
            + "Parameters: "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_DATE + "DATE ";
    //  + PREFIX_TAG + "owesMoney";

    public static final String MESSAGE_SUCCESS = "New person added to schedule: %1$s";
//    public static final String MESSAGE_DUPLICATE_PERSON = "This person is already working on the specified date. ";
    private final Person person;
    private final LocalDate date;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public ScheduleCommand(Person person, LocalDate date) {
        requireNonNull(person);
        this.person = person;
        this.date = date;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.addPersonToSchedule(person, date);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(person)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ScheduleCommand)) {
            return false;
        }

        ScheduleCommand otherScheduleCommand = (ScheduleCommand) other;
        return person.equals(otherScheduleCommand.person) && date.equals(otherScheduleCommand.date);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("person", person)
                .add("date", date)
                .toString();
    }
}
