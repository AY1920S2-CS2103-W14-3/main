package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

import seedu.address.model.assignment.Assignment;
import seedu.address.model.assignment.AssignmentList;

/**
 * Wraps all data at the scheduler level.
 * Duplicates are not allowed (by .isSameAssignment comparison)
 */
public class Scheduler implements ReadOnlyScheduler {
    private final AssignmentList assignments;

    {
        assignments = new AssignmentList();
    }

    public Scheduler() {}

    /**
     * Creates an AssignmentList using the Assignments in the {@code toBeCopied}
     */
    public Scheduler(ReadOnlyScheduler toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Resets the existing data of this {@code AssignmentList} with {@code newData}.
     */
    public void resetData(ReadOnlyScheduler newData) {
        requireNonNull(newData);
        setAssignments(newData.getAssignmentsList());
    }

    /**
     * Replaces the contents of the assignment list with {@code assignments}.
     * Must not contain duplicate assignments.
     */
    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments.setAssignments(assignments);
    }

    @Override
    public ArrayList<Assignment> getAssignmentsList() {
        return assignments.getAssignments();
    }

    /**
     * Adds an assignment to the scheduler.
     * The assignment must not already exist.
     */
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    /**
     * Returns true if an identical assignment as {@code assignment} exists in the scheduler.
     */
    public boolean hasAssignment(Assignment assignment) {
        requireNonNull(assignment);
        return assignments.contains(assignment);
    }

    public void setAssignment(Assignment target, Assignment markedAssignment) {
        requireNonNull(markedAssignment);

        assignments.setAssignment(target, markedAssignment);
    }
}
