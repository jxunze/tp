package seedu.address.storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;
import seedu.address.model.schedule.ScheduleDate;

/**
 * Jackson-friendly version of {@link ScheduleDate}.
 */
class JsonAdaptedScheduleDate {
    private final String date;
    private final List<JsonAdaptedPerson> persons = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedScheduleDate} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedScheduleDate(@JsonProperty("date") String date,
                                   @JsonProperty("persons") List<JsonAdaptedPerson> persons) {
        this.date = date;
        if (persons != null) {
            this.persons.addAll(persons);
        }
    }

    /**
     * Converts a given {@code ScheduleDate} into this class for Jackson use.
     */
    public JsonAdaptedScheduleDate(ScheduleDate source) {
        date = source.getDate().toString();
        persons.addAll(source.getPersons().stream()
            .map(JsonAdaptedPerson::new)
            .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code ScheduleDate} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public ScheduleDate toModelType() throws IllegalValueException {
        final List<Person> persons = new ArrayList<>();
        for (JsonAdaptedPerson person : this.persons) {
            persons.add(person.toModelType());
        }
        final LocalDate modelDate = LocalDate.parse(date);
        ScheduleDate scheduleDate = new ScheduleDate(modelDate);
        for (Person person : persons) {
            scheduleDate.addPerson(person);
        }
        return scheduleDate;
    }

}
