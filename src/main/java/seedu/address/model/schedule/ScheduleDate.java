package seedu.address.model.schedule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import seedu.address.model.person.Person;

/**
 * Represents a date in the schedule.
 */
public class ScheduleDate {
    private final LocalDate date;
    private final List<Person> persons;

    /**
     * Constructs a {@code ScheduleDate} with the given {@code LocalDate}.
     */
    public ScheduleDate(LocalDate date) {
        this.date = date;
        this.persons = new ArrayList<>();
    }

    /**
     * Constructs a {@code ScheduleDate} with the given {@code LocalDate} and {@code List<Person>}.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns the list of people working on this date.
     */
    public List<Person> getPersons() {
        return persons;
    }

    /**
     * Adds someone working on this date.
     */
    public void addPerson(Person person) {
        persons.add(person);
    }

    /**
     * Removes someone working on this date.
     */
    public void removePerson(Person person) {
        persons.remove(person);
    }

    /**
     * Returns true if the person is working on this date.
     */
    public boolean hasPerson(Person person) {
        return persons.contains(person);
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

}
