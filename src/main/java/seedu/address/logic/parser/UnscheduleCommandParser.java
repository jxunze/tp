package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.time.LocalDate;

import seedu.address.logic.commands.HoursCommand;
import seedu.address.logic.commands.UnscheduleCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Phone;

/**
 * Parses input arguments and creates a new ScheduleCommand object
 */
public class UnscheduleCommandParser implements Parser<UnscheduleCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ScheduleCommand
     * and returns a ScheduleCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public UnscheduleCommand parse(String args) throws ParseException {
        String[] tokens = args.trim().split("\\s+");
        if (tokens.length != 2) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HoursCommand.MESSAGE_USAGE));
        }
        Phone phoneNumber = ParserUtil.parsePhone(tokens[0]);
        LocalDate date = ParserUtil.parseDate(tokens[1]);
        return new UnscheduleCommand(phoneNumber, date);
    }
}
