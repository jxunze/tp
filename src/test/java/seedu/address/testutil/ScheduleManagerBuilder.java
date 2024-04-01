package seedu.address.testutil;

import seedu.address.model.schedule.ScheduleDate;
import seedu.address.model.schedule.ScheduleManager;

/**
 * A utility class to help with building ScheduleManager objects.
 */
public class ScheduleManagerBuilder {
    private ScheduleManager scheduleManager;

    public ScheduleManagerBuilder() {
        scheduleManager = new ScheduleManager();
    }

    public ScheduleManagerBuilder(ScheduleManager scheduleManager) {
        this.scheduleManager = scheduleManager;
    }

    /**
    * Adds a new {@code ScheduleDate} to the {@code ScheduleManager} that we are building.
    */
    public ScheduleManagerBuilder withScheduleDate(ScheduleDate scheduleDate) {
        scheduleManager.addScheduleDate(scheduleDate);
        return this;
    }

    public ScheduleManager build() {
        return scheduleManager;
    }
}
