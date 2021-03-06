package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCardDetail extends UiPart<Region> {

    private static final String FXML = "PersonListCardDetail.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPaneDetail;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private FlowPane tags;
    @FXML
    private Label remark;
    @FXML
    private Label birthday;
    @FXML
    private Label organization;

    public PersonCardDetail(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        name.setText(person.getName().fullName);
        name.setWrapText(true);
        phone.setText("Phone: " + person.getPhone().value);
        address.setText("Address: " + person.getAddress().value);
        address.setWrapText(true);
        email.setText("Email: " + person.getEmail().value);
        email.setWrapText(true);
        birthday.setText("Birthday: " + person.getBirthday().toString());
        organization.setText("Organization: " + person.getOrganization().toString());
        organization.setWrapText(true);
        String remarkValue = "\nRemarks:\n";
        int i = 0;
        while (i < person.getRemark().size()) {
            int index = i + 1;
            remarkValue += index + ". " + person.getRemark().get(i).value;
            if (i != person.getRemark().size() - 1) {
                remarkValue += "\n";
            }
            i++;
        }
        remark.setText(remarkValue);
        remark.setWrapText(true);
        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        PersonCardDetail card = (PersonCardDetail) other;
        return id.getText().equals(card.id.getText())
                && person.equals(card.person);
    }

}
