package seedu.address.model.schedule;

import seedu.address.model.person.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthSchedule implements Schedule {
    // The schedule is a map of dates to lists of persons.
    private final HashMap<LocalDate, ArrayList<Person>> schedule;

    public MonthSchedule() {
        this.schedule = new HashMap<>();
    }

    @Override
    public HashMap<LocalDate, ArrayList<Person>> getSchedule() {
        return schedule;
    }

    @Override
    public void addPerson(Person person, LocalDate date) {
        if (schedule.containsKey(date)) {
            schedule.get(date).add(person);
        } else {
            ArrayList<Person> persons = new ArrayList<>();
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
}
