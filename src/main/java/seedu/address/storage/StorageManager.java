package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyAssignmentSchedule;
import seedu.address.model.ReadOnlyEventSchedule;
import seedu.address.model.ReadOnlyRestaurantBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of AddressBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private AddressBookStorage addressBookStorage;
    private RestaurantBookStorage restaurantBookStorage;
    private AssignmentScheduleStorage assignmentScheduleStorage;
    private EventScheduleStorage eventScheduleStorage;
    private UserPrefsStorage userPrefsStorage;

    public StorageManager(AddressBookStorage addressBookStorage,
                          RestaurantBookStorage restaurantBookStorage,
                          AssignmentScheduleStorage assignmentScheduleStorage,
                          EventScheduleStorage eventScheduleStorage,
                          UserPrefsStorage userPrefsStorage) {
        super();
        this.addressBookStorage = addressBookStorage;
        this.restaurantBookStorage = restaurantBookStorage;
        this.userPrefsStorage = userPrefsStorage;
        this.assignmentScheduleStorage = assignmentScheduleStorage;
        this.eventScheduleStorage = eventScheduleStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ AddressBook methods ==============================

    @Override
    public Path getAddressBookFilePath() {
        return addressBookStorage.getAddressBookFilePath();
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException {
        return readAddressBook(addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return addressBookStorage.readAddressBook(filePath);
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException {
        saveAddressBook(addressBook, addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        addressBookStorage.saveAddressBook(addressBook, filePath);
    }

    // ================ RestaurantBook methods ==============================

    @Override
    public Path getRestaurantBookFilePath() {
        return restaurantBookStorage.getRestaurantBookFilePath();
    }

    @Override
    public Optional<ReadOnlyRestaurantBook> readRestaurantBook() throws DataConversionException, IOException {
        return readRestaurantBook(restaurantBookStorage.getRestaurantBookFilePath());
    }

    @Override
    public Optional<ReadOnlyRestaurantBook> readRestaurantBook(Path filePath) throws DataConversionException,
            IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return restaurantBookStorage.readRestaurantBook(filePath);
    }

    @Override
    public void saveRestaurantBook(ReadOnlyRestaurantBook restaurantBook) throws IOException {
        saveRestaurantBook(restaurantBook, restaurantBookStorage.getRestaurantBookFilePath());
    }

    @Override
    public void saveRestaurantBook(ReadOnlyRestaurantBook restaurantBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        restaurantBookStorage.saveRestaurantBook(restaurantBook, filePath);
    }

    // ============== AssignmentSchedule methods =======================================

    @Override
    public Path getSchedulerFilePath() {
        return assignmentScheduleStorage.getSchedulerFilePath();
    }

    @Override
    public Optional<ReadOnlyAssignmentSchedule> readScheduler() throws DataConversionException, IOException {
        return readScheduler(assignmentScheduleStorage.getSchedulerFilePath());
    }

    @Override
    public Optional<ReadOnlyAssignmentSchedule> readScheduler(Path filePath) throws DataConversionException,
        IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return assignmentScheduleStorage.readScheduler(filePath);
    }

    @Override
    public void saveScheduler(ReadOnlyAssignmentSchedule scheduler) throws IOException {
        saveScheduler(scheduler, assignmentScheduleStorage.getSchedulerFilePath());
    }

    @Override
    public void saveScheduler(ReadOnlyAssignmentSchedule scheduler, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        assignmentScheduleStorage.saveScheduler(scheduler, filePath);
    }

    // ============== Event AssignmentSchedule methods =================================

    @Override
    public Path getEventScheduleFilePath() {
        return eventScheduleStorage.getEventScheduleFilePath();
    }

    @Override
    public Optional<ReadOnlyEventSchedule> readEventSchedule() throws DataConversionException, IOException {
        return readEventSchedule(eventScheduleStorage.getEventScheduleFilePath());
    }

    @Override
    public Optional<ReadOnlyEventSchedule> readEventSchedule(Path filePath)
            throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return eventScheduleStorage.readEventSchedule(filePath);
    }

    @Override
    public void saveEventSchedule(ReadOnlyEventSchedule eventSchedule) throws IOException {
        saveEventSchedule(eventSchedule, eventScheduleStorage.getEventScheduleFilePath());
    }

    @Override
    public void saveEventSchedule(ReadOnlyEventSchedule eventSchedule, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        eventScheduleStorage.saveEventSchedule(eventSchedule, filePath);
    }
}
