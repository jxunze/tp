package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.UnarchiveCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Phone;

/**
 * Parses input arguments and creates a new ArchiveCommand object
 */
public class UnarchiveCommandParser implements Parser<UnarchiveCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ArchiveCommand
     * and returns an ArchiveCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public UnarchiveCommand parse(String args) throws ParseException {
        try {
            Phone number = ParserUtil.parsePhone(args);
            return new UnarchiveCommand(number);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnarchiveCommand.MESSAGE_USAGE), pe);
        }
    }
}

