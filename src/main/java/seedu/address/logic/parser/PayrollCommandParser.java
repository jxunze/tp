package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import java.time.LocalDate;
import seedu.address.logic.commands.PayrollCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new PayrollCommand object
 */
public class PayrollCommandParser implements Parser<PayrollCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the PayrollCommand
     * and returns a PayrollCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public PayrollCommand parse(String args) throws ParseException {
        String[] tokens = args.trim().split("\\s+");
        if (tokens.length != 2) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, PayrollCommand.MESSAGE_USAGE));
        }
        LocalDate startDate = ParserUtil.parseDate(tokens[0]);
        LocalDate endDate = ParserUtil.parseDate(tokens[1]);
        return new PayrollCommand(startDate, endDate);
    }
}
