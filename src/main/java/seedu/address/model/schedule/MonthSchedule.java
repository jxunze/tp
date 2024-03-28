package seedu.address.model.schedule;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Person;

/**
 * Represents a Schedule that maps lists of Persons to dates.
 */
public class MonthSchedule implements Schedule {
    // The schedule is a set of ScheduleDates.
    private final Set<ScheduleDate> schedule;

    /**
     * Creates a MonthSchedule with an empty schedule.
     */
    public MonthSchedule() {
        this.schedule = new HashSet<>();
    }

    @Override
    public Set<ScheduleDate> getSchedule() {
        return schedule;
    }

    @Override
    public void addPerson(Person person, LocalDate date) {
        for (ScheduleDate scheduleDate : schedule) {
            if (scheduleDate.getDate().equals(date)) {
                if (!scheduleDate.hasPerson(person)) {
                    scheduleDate.addPerson(person);
                }
                return;
            }
        }
        ScheduleDate newScheduleDate = new ScheduleDate(date);
        newScheduleDate.addPerson(person);
        schedule.add(newScheduleDate);
    }

    @Override
    public void addScheduleDate(ScheduleDate scheduleDate) {
        schedule.add(scheduleDate);
    }

    @Override
    public void deletePerson(Person person, LocalDate date) {
        for (ScheduleDate scheduleDate : schedule) {
            if (scheduleDate.getDate().equals(date)) {
                if (scheduleDate.hasPerson(person)) {
                    scheduleDate.removePerson(person);
                }
                return;
            }
        }
    }

    @Override
    public void resetData(Schedule newData) {
        schedule.clear();
        if (newData != null) {
            schedule.addAll(newData.getSchedule());
        }
    }
}
