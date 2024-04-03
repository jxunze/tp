package seedu.address.model.schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class ScheduleDateTest {

    @Test
    public void constructor_validDate_success() {
        LocalDate date = LocalDate.now();
        ScheduleDate scheduleDate = new ScheduleDate(date);
        assertEquals(date, scheduleDate.getDate());
        assertTrue(scheduleDate.getPersons().isEmpty());
    }

    @Test
    public void addPerson_validPerson_success() {
        LocalDate date = LocalDate.now();
        ScheduleDate scheduleDate = new ScheduleDate(date);
        Person person = new PersonBuilder().build();
        scheduleDate.addPerson(person);
        assertTrue(scheduleDate.hasPerson(person));
        assertEquals(1, scheduleDate.getPersons().size());
        assertEquals(person, scheduleDate.getPersons().get(0));
    }

    @Test
    public void removePerson_validPerson_success() {
        LocalDate date = LocalDate.now();
        ScheduleDate scheduleDate = new ScheduleDate(date);
        Person person = new PersonBuilder().build();
        scheduleDate.addPerson(person);
        scheduleDate.removePerson(person);
        assertFalse(scheduleDate.hasPerson(person));
        assertTrue(scheduleDate.getPersons().isEmpty());
    }

    @Test
    public void equals_sameObject_true() {
        LocalDate date = LocalDate.now();
        ScheduleDate scheduleDate = new ScheduleDate(date);
        assertTrue(scheduleDate.equals(scheduleDate));
    }

    @Test
    public void equals_sameValues_true() {
        LocalDate date = LocalDate.now();
        ScheduleDate scheduleDate1 = new ScheduleDate(date);
        ScheduleDate scheduleDate2 = new ScheduleDate(date);
        assertTrue(scheduleDate1.equals(scheduleDate2));
    }

    @Test
    public void equals_differentValues_false() {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now().plusDays(1);
        ScheduleDate scheduleDate1 = new ScheduleDate(date1);
        ScheduleDate scheduleDate2 = new ScheduleDate(date2);
        assertFalse(scheduleDate1.equals(scheduleDate2));
    }
}
