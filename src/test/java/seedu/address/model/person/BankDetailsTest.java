package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class BankDetailsTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new BankDetails(null));
    }

    @Test
    public void constructor_invalidBankDetails_throwsIllegalArgumentException() {
        String invalidBankDetails = "32132-423421";
        assertThrows(IllegalArgumentException.class, () -> new BankDetails(invalidBankDetails));
    }

    @Test
    public void isValidBankDetails() {
        // null BankDetails number
        assertThrows(NullPointerException.class, () -> BankDetails.isValidBankAccount(null));

        // invalid BankDetails numbers
        assertFalse(BankDetails.isValidBankAccount("mt"));
        assertFalse(BankDetails.isValidBankAccount("1231-421321"));
        assertFalse(BankDetails.isValidBankAccount("1234567890"));

        // valid BankDetails numbers
        assertTrue(BankDetails.isValidBankAccount("posb 123456789"));
        assertTrue(BankDetails.isValidBankAccount("ocbc 1234567"));
        assertTrue(BankDetails.isValidBankAccount("dbs 1234567890"));
        assertTrue(BankDetails.isValidBankAccount("uob 1234567890"));
        assertTrue(BankDetails.isValidBankAccount("standard chartered 1234567890"));
        assertTrue(BankDetails.isValidBankAccount("hsbc 12345678901234"));
        assertTrue(BankDetails.isValidBankAccount("other maybank 1234567890123"));
    }

    @Test
    public void equals() {
        BankDetails bankDetails = new BankDetails("posb 123123123");

        // same values -> returns true
        assertTrue(bankDetails.equals(new BankDetails("posb 123123123")));

        // same object -> returns true
        assertTrue(bankDetails.equals(bankDetails));

        // null -> returns false
        assertFalse(bankDetails.equals(null));

        // different types -> returns false
        assertFalse(bankDetails.equals(5.0f));

        // different values -> returns false
        assertFalse(bankDetails.equals(new BankDetails("3987398782")));
    }
}
