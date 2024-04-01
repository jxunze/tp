package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.commands.AddCommand.MESSAGE_DUPLICATE_PERSON;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_UNARCHIVED_PERSONS;

import java.util.List;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.ArchiveStatus;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;

/**
 * Archives an employee from the contact book into the archive book.
 */
public class UnarchiveCommand extends Command {

    public static final String COMMAND_WORD = "unarchive";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Archives a contact. \n"
            + "Parameters: unarchive [EXISTING PHONE NUMBER] \n"
            + "Example: " + COMMAND_WORD + " 98765432";

    public static final String MESSAGE_ARCHIVE_PERSON_SUCCESS = "Un-archived Person: %1$s";

    private final Phone targetPhone;

    public UnarchiveCommand(Phone targetPhone) {
        this.targetPhone = targetPhone;
    }

    /**
     * Creates an archived person based on the person to archive.
     *
     * @param personToUnarchive Person to archive.
     * @return Archived person.
     */
    private static Person createUnarchivedPerson(Person personToUnarchive) {
        assert personToUnarchive != null;

        ArchiveStatus updatedArchiveStatus = new ArchiveStatus(false);

        return new Person(personToUnarchive.getFirstName(), personToUnarchive.getLastName(), personToUnarchive.getPhone(),
                personToUnarchive.getSex(), personToUnarchive.getPayRate(), personToUnarchive.getAddress(),
                personToUnarchive.getBankDetails(), personToUnarchive.getWorkHours(), personToUnarchive.getTags(),
                updatedArchiveStatus);
    }

    /**
     * Archives a person from the contact book.
     *
     * @param model {@code Model} which the command should operate on.
     * @return A command result that indicates the person has been archived.
     * @throws CommandException If the person does not exist in the contact book.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();
        boolean exists = false;
        Person personToUnarchive = null;
        for (Person person : lastShownList) {
            if (person.getPhone().equals(targetPhone)) {
                exists = true;
                personToUnarchive = person;
                break;
            }
        }
        if (!exists) {
            throw new CommandException(Messages.MESSAGE_PERSON_NOT_FOUND);
        }

        Person unarchivedPerson = createUnarchivedPerson(personToUnarchive);

        if (!personToUnarchive.isSamePerson(unarchivedPerson) && model.hasPerson(unarchivedPerson)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.unarchivePerson(personToUnarchive, unarchivedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_UNARCHIVED_PERSONS);
        return new CommandResult(String.format(MESSAGE_ARCHIVE_PERSON_SUCCESS, Messages.format(personToUnarchive)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UnarchiveCommand)) {
            return false;
        }

        // state check
        UnarchiveCommand e = (UnarchiveCommand) other;
        return targetPhone.equals(e.targetPhone);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetPhone", targetPhone)
                .toString();
    }


}
