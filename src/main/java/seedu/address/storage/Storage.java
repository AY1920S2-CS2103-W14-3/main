package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyAssignmentSchedule;
import seedu.address.model.ReadOnlyEventSchedule;
import seedu.address.model.ReadOnlyRestaurantBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends AddressBookStorage, RestaurantBookStorage, UserPrefsStorage,
        AssignmentScheduleStorage, EventScheduleStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getAddressBookFilePath();

    @Override
    Path getRestaurantBookFilePath();

    @Override
    Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException;

    @Override
    Optional<ReadOnlyRestaurantBook> readRestaurantBook() throws DataConversionException, IOException;

    @Override
    void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException;

    @Override
    void saveRestaurantBook(ReadOnlyRestaurantBook restaurantBook) throws IOException;

    @Override
    Path getAssignmentScheduleFilePath();

    @Override
    Optional<ReadOnlyAssignmentSchedule> readAssignmentSchedule() throws DataConversionException, IOException;

    @Override
    void saveAssignmentSchedule(ReadOnlyAssignmentSchedule scheduler) throws IOException;

    @Override
    Path getEventScheduleFilePath();

    @Override
    Optional<ReadOnlyEventSchedule> readEventSchedule() throws DataConversionException, IOException;

    @Override
    void saveEventSchedule(ReadOnlyEventSchedule eventSchedule) throws IOException;

}
