package seedu.address.testutil;

import java.time.LocalDate;

import seedu.address.model.schedule.ScheduleManager;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalSchedule {
    private static final LocalDate april1 = LocalDate.parse("2024-04-01");
    public static final ScheduleManager SCHEDULE = new ScheduleManagerBuilder()
            .withScheduleDate(new ScheduleDateBuilder(april1.minusDays(1))
                    .withPerson(TypicalPersons.ALICE)
                    .withPerson(TypicalPersons.BENSON).build())
            .withScheduleDate(new ScheduleDateBuilder(april1).withPerson(TypicalPersons.BENSON).build())
            .build();

    private TypicalSchedule() {
    } // prevents instantiation

    public static ScheduleManager getTypicalSchedule() {
        return SCHEDULE;
    }
}
