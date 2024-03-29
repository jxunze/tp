package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's bank details in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidBankAccount(String)}
 */
public class BankDetails {

    public static final String MESSAGE_CONSTRAINTS = "Bank details should be in this format: "
        + "<bank name> <account number> \n"
        + "Accepted banks and corresponding digit length: OCBC {7}, POSB {9}, UOB {10}, DBS {10}, "
        + "Standard Chartered {10}, HSBC {any length}, Others {any length}\n"
        + "Examples: -b posb 1234567890/ -b hsbc 172002492/ -b other maybank 712834957521";
    public static final String DBS_UOB_STANDARD_REGEX = "(?:dbs|uob|standard chartered)\\s+\\d{10}";
    public static final String POSB_REGEX = "posb\\s+\\d{9}";
    public static final String OCBC_REGEX = "ocbc\\s+\\d{7}";
    public static final String HSBC_REGEX = "hsbc\\s+\\d+";
    public static final String OTHERS_REGEX = "other\\s+\\w+\\s+\\d+";

    public static final String VALIDATION_REGEX = DBS_UOB_STANDARD_REGEX + "|"
        + POSB_REGEX + "|" + OCBC_REGEX + "|" + HSBC_REGEX + "|" + OTHERS_REGEX;

    public final String value;

    /**
     * Constructs an {@code BankDetails}.
     *
     * @param bankDetails A valid bank account.
     */
    public BankDetails(String bankDetails) {
        requireNonNull(bankDetails);
        checkArgument(isValidBankAccount(bankDetails), MESSAGE_CONSTRAINTS);
        value = bankDetails;
    }

    /**
     * Returns true if a given string is a valid bank account.
     */
    public static boolean isValidBankAccount(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof BankDetails)) {
            return false;
        }

        BankDetails otherBankDetails = (BankDetails) other;
        return value.equals(otherBankDetails.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
