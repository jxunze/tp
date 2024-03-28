package seedu.address.model.schedule;

import seedu.address.model.person.Person;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class MonthSchedule implements Schedule {
    // The schedule is a map of dates to lists of persons.
    private final HashMap<LocalDate, HashSet<Person>> schedule;

    public MonthSchedule() {
        this.schedule = new HashMap<>();
    }

    @Override
    public HashMap<LocalDate, HashSet<Person>> getSchedule() {
        return schedule;
    }

    @Override
    public void addPerson(Person person, LocalDate date) {
        if (schedule.containsKey(date)) {
            schedule.get(date).add(person);
        } else {
            HashSet<Person> persons = new HashSet<>();
            persons.add(person);
            schedule.put(date, persons);
        }
    }

    @Override
    public void deletePerson(Person person, LocalDate date) {
        if (schedule.containsKey(date)) {
            schedule.get(date).remove(person);
        }
    }

    @Override
    public void resetData(Schedule newData) {
        schedule.clear();
        if (newData != null) {
            schedule.putAll(newData.getSchedule());
        }
    }
}
