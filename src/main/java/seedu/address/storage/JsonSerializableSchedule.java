package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.schedule.MonthSchedule;
import seedu.address.model.schedule.Schedule;
import seedu.address.model.schedule.ScheduleDate;

/**
 * An Immutable Schedule that is serializable to JSON format.
 */
@JsonRootName(value = "schedule")
class JsonSerializableSchedule {

    private final List<JsonAdaptedScheduleDate> scheduleDates = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableAddressBook} with the given persons.
     */
    @JsonCreator
    public JsonSerializableSchedule(@JsonProperty("scheduleDates") List<JsonAdaptedScheduleDate> scheduleDates) {
        this.scheduleDates.addAll(scheduleDates);
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableSchedule(Schedule source) {
        scheduleDates.addAll(source.getScheduleDates().stream()
                .map(JsonAdaptedScheduleDate::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Schedule toModelType() throws IllegalValueException {
        Schedule schedule = new MonthSchedule();
        for (JsonAdaptedScheduleDate jsonAdaptedScheduleDate : scheduleDates) {
            ScheduleDate scheduleDate = jsonAdaptedScheduleDate.toModelType();
            schedule.addScheduleDate(scheduleDate);
        }
        return schedule;
    }

}
