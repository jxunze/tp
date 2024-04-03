package seedu.address.model.person;

/**
 * Represents the archive status of a person in the contact book.
 */
public class ArchiveStatus {

    public static final String MESSAGE_CONSTRAINTS = "Archive status can only be '0' for not archived or "
        + "'1' for archived.";
    private boolean isArchived;

    /**
     * Constructor for ArchiveStatus that initializes the archive status to not archived.
     */
    public ArchiveStatus(boolean isArchived) {
        this.isArchived = isArchived;
    }

    public boolean getArchiveStatus() {
        return isArchived;
    }

    /**
     * Sets the archive status of a person to be archived.
     */
    public void setArchiveStatusTrue() {
        this.isArchived = true;
    }

    /**
     * Sets the archive status of a person to be not archived.
     */
    public void setArchiveStatusFalse() {
        this.isArchived = false;
    }

    @Override
    public String toString() {
        return isArchived ? "Archived" : "Not Archived";
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ArchiveStatus // instanceof handles nulls
            && isArchived == ((ArchiveStatus) other).isArchived); // state check
    }
}
