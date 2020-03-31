package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddAssignmentCommand;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddEventCommand;
import seedu.address.logic.commands.AddInfoCommand;
import seedu.address.logic.commands.AddRestaurantCommand;
import seedu.address.logic.commands.AddRestaurantNoteCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteInfoCommand;
import seedu.address.logic.commands.DeleteRestaurantCommand;
import seedu.address.logic.commands.DoneCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditInfoCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.GetCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListAssignmentCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ListEventCommand;
import seedu.address.logic.commands.ListRestaurantCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.ScheduleCommand;
import seedu.address.logic.commands.ShowBirthdayCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.commands.VisitedRestaurantCommand;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput, Model model) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch (commandWord) {

        case AddRestaurantCommand.COMMAND_WORD:
            return new AddRestaurantCommandParser().parse(arguments, model);

        case DeleteRestaurantCommand.COMMAND_WORD:
            return new DeleteRestaurantCommandParser().parse(arguments, model);

        case ListRestaurantCommand.COMMAND_WORD:
            return new ListRestaurantCommand();

        case VisitedRestaurantCommand.COMMAND_WORD:
            return new VisitedRestaurantCommandParser().parse(arguments, model);

        case AddRestaurantNoteCommand.COMMAND_WORD:
            return new AddRestaurantNoteCommandParser().parse(arguments, model);

        case AddAssignmentCommand.COMMAND_WORD:
            return new AddAssignmentCommandParser().parse(arguments, model);

        case ListAssignmentCommand.COMMAND_WORD:
            return new ListAssignmentCommandParser().parse(arguments, model);

        case AddEventCommand.COMMAND_WORD:
            return new AddEventCommandParser().parse(arguments, model);

        case DoneCommand.COMMAND_WORD:
            return new DoneCommandParser().parse(arguments, model);

        case ListEventCommand.COMMAND_WORD:
            return new ListEventCommandParser().parse(arguments, model);

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments, model);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments, model);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments, model);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments, model);

        case AddInfoCommand.COMMAND_WORD:
            return new AddInfoCommandParser().parse(arguments, model);

        case EditInfoCommand.COMMAND_WORD:
            return new EditInfoCommandParser().parse(arguments, model);

        case DeleteInfoCommand.COMMAND_WORD:
            return new DeleteInfoCommandParser().parse(arguments, model);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommandParser().parse(arguments, model);

        case GetCommand.COMMAND_WORD:
            return new GetCommandParser().parse(arguments, model);

        case ShowBirthdayCommand.COMMAND_WORD:
            return new ShowBirthdayCommand();

        case ScheduleCommand.COMMAND_WORD:
            return new ScheduleCommand();

        case UndoCommand.COMMAND_WORD:
            return new UndoCommand();

        case RedoCommand.COMMAND_WORD:
            return new RedoCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
