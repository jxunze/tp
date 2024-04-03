package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ScheduleCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Phone;


public class UnscheduleCommandParserTest {

    private final ScheduleCommandParser parser = new ScheduleCommandParser();

    @Test
    public void parse_validArgs_returnsScheduleCommand() throws ParseException {
        String args = "12345678 2022-12-31";
        ScheduleCommand expectedCommand = new ScheduleCommand(new Phone("12345678"), LocalDate.parse("2022-12-31"));
        assertEquals(expectedCommand, parser.parse(args));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        String args = "12345678";
        assertThrows(ParseException.class, () -> parser.parse(args));
    }

    @Test
    public void parse_invalidDate_throwsParseException() {
        String args = "12345678 invalidDate";
        assertThrows(ParseException.class, () -> parser.parse(args));
    }
}
