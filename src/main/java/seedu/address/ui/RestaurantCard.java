package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.restaurant.Restaurant;

/**
 * An UI component that displays information of a {@code Restaurant}.
 */
public class RestaurantCard extends UiPart<Region> {

    private static final String FXML = "RestaurantListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Restaurant restaurant;

    @FXML
    private HBox restaurantCardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private FlowPane visit;
    @FXML
    private Label locationR;
    @FXML
    private Label hours;
    @FXML
    private Label price;
    @FXML
    private Label cuisine;
    @FXML
    private Label remarks;

    public RestaurantCard(Restaurant restaurant, int displayedIndex) {
        super(FXML);
        this.restaurant = restaurant;
        id.setText(displayedIndex + ". ");
        name.setText(restaurant.getName().fullName);
        locationR.setText(restaurant.getLocation().fullLocation);
        hours.setText(restaurant.getHours().hours);
        price.setText(restaurant.getPrice().price);
        cuisine.setText(restaurant.getCuisine().cuisine);
        String visited;
        if (restaurant.getVisit().visit.equals("Yes")) {
            visited = "Visited";
        } else {
            visited = "Not visited";
        }
        visit.getChildren().add(new Label(visited));
        String remarkValue = "";
        int i = 0;
        while (i < restaurant.getRemark().size()) {
            remarkValue += restaurant.getRemark().get(i).value;
            if (i != restaurant.getRemark().size() - 1) {
                remarkValue += ", ";
            }
            i++;
        }
        remarks.setText(remarkValue);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RestaurantCard)) {
            return false;
        }

        // state check
        RestaurantCard card = (RestaurantCard) other;
        return id.getText().equals(card.id.getText())
                && restaurant.equals(card.restaurant);
    }

}