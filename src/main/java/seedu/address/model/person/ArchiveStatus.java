package seedu.address.model.person;

import seedu.address.logic.commands.ArchiveCommand;

/**
 * Represents the archive status of a person in the contact book.
 */
public class ArchiveStatus {

    public static final String MESSAGE_CONSTRAINTS = "Archive status can only be '0' for not archived or "
        + "'1' for archived.";
    private int archiveStatus;

    /**
     * Constructor for ArchiveStatus that initializes the archive status to not archived.
     */
    public ArchiveStatus(boolean isArchived) {
        if (isArchived) {
            this.archiveStatus = 1;
        } else {
            this.archiveStatus = 0;
        }
    }

    /**
     * Sets the archive status of a person to be archived.
     */
    public void setArchiveStatusTrue() {
        this.archiveStatus = 1;
    }

    /**
     * Sets the archive status of a person to be not archived.
     */
    public void setArchiveStatusFalse() {
        this.archiveStatus = 0;
    }

    @Override
    public String toString() {
        return archiveStatus == 1 ? "Archived" : "Not Archived";
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ArchiveStatus // instanceof handles nulls
            && archiveStatus == ((ArchiveStatus) other).archiveStatus); // state check
    }
}
