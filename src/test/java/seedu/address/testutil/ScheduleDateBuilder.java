package seedu.address.testutil;

import java.time.LocalDate;

import seedu.address.model.person.Person;
import seedu.address.model.schedule.ScheduleDate;

/**
 * A utility class to help with building ScheduleDate objects.
 */
public class ScheduleDateBuilder {
    private ScheduleDate scheduleDate;

    public ScheduleDateBuilder(LocalDate localDate) {
        scheduleDate = new ScheduleDate(localDate);
    }

    public ScheduleDateBuilder(ScheduleDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    /**
    * Adds a new {@code Person} to the {@code ScheduleDate} that we are building.
    */
    public ScheduleDateBuilder withPerson(Person person) {
        scheduleDate.addPerson(person);
        return this;
    }

    public ScheduleDate build() {
        return scheduleDate;
    }
}
