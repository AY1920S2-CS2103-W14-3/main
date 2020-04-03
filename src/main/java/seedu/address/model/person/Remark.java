package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid
 */
public class Remark {
    public static final String MESSAGE_CONSTRAINTS =
            "Remarks should not be empty.";
    public final String value;

    public Remark(@JsonProperty("remark")String remark) {
        requireNonNull(remark);
        value = remark;
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + value + ']';
    }

    /**
     * Returns true if a given string is a valid remark.
     */
    public static boolean isValidRemark(String test) {
        return !test.isEmpty();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
