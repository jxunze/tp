package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.schedule.Schedule;

/**
 * Represents a storage for {@link seedu.address.model.schedule.Schedule}.
 */
public interface ScheduleStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getScheduleFilePath();

    /**
     * Returns Schedule data as a {@link Schedule}.
     * Returns {@code Optional.empty()} if storage file is not found.
     *
     * @throws DataLoadingException if loading the data from storage failed.
     */
    Optional<Schedule> readSchedule() throws DataLoadingException;

    /**
     * @see #getScheduleFilePath()
     */
    Optional<Schedule> readSchedule(Path filePath) throws DataLoadingException;

    /**
     * Saves the given {@link Schedule} to the storage.
     * @param schedule cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveSchedule(Schedule schedule) throws IOException;

    /**
     * @see #saveSchedule(Schedule)
     */
    void saveSchedule(Schedule schedule, Path filePath) throws IOException;

}
