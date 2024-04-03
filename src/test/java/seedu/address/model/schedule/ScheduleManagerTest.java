package seedu.address.model.schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;


public class ScheduleManagerTest {
    private ScheduleManager scheduleManager;

    @BeforeEach
    public void setUp() {
        scheduleManager = new ScheduleManager();
    }

    @Test
    public void addPerson_validPersonAndDate_personAddedToSchedule() {
        Person person = new PersonBuilder().build();
        LocalDate date = LocalDate.now();

        scheduleManager.addPerson(person, date);

        assertTrue(scheduleManager.getScheduleDates().stream()
                .anyMatch(scheduleDate -> scheduleDate.getDate().equals(date)
                        && scheduleDate.hasPerson(person)));
    }

    @Test
    public void addPerson_existingPersonAndDate_personNotAddedToSchedule() {
        Person person = new PersonBuilder().build();
        LocalDate date = LocalDate.now();

        scheduleManager.addPerson(person, date);
        scheduleManager.addPerson(person, date);

        assertEquals(1, scheduleManager.getScheduleDates().stream()
                .filter(scheduleDate -> scheduleDate.getDate().equals(date)
                        && scheduleDate.hasPerson(person))
                .count());
    }

    @Test
    public void deletePerson_existingPersonAndDate_personRemovedFromSchedule() {
        Person person = new PersonBuilder().build();
        LocalDate date = LocalDate.now();

        scheduleManager.addPerson(person, date);
        scheduleManager.deletePerson(person, date);

        assertFalse(scheduleManager.getScheduleDates().stream()
                .anyMatch(scheduleDate -> scheduleDate.getDate().equals(date)
                        && scheduleDate.hasPerson(person)));
    }

    @Test
    public void resetData_nullData_scheduleCleared() {
        Person person = new PersonBuilder().build();
        LocalDate date = LocalDate.now();

        scheduleManager.addPerson(person, date);
        scheduleManager.resetData(null);

        assertTrue(scheduleManager.getScheduleDates().isEmpty());
    }

    @Test
    public void resetData_nonNullData_scheduleUpdated() {
        Person person = new PersonBuilder().build();
        LocalDate date = LocalDate.now();
        ScheduleManager newData = new ScheduleManager();
        newData.addPerson(person, date);

        scheduleManager.addPerson(person, date);
        scheduleManager.resetData(newData);

        assertEquals(newData.getScheduleDates(), scheduleManager.getScheduleDates());
    }
}
