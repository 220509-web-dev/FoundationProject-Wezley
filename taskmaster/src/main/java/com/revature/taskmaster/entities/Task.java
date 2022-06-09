package com.revature.taskmaster.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents a task record within the data source
 */
public class Task {

    /** A generated string of characters that is used to uniquely define a task record within the data source */
    private String id;

    /** A brief title for the task - must not be null or empty; maximum length of 50 characters */
    private String title;

    /** A full description of the task - must not be null or empty */
    private String description;

    /** The point value of this task - must be greater than 0 and less than 100 */
    private int pointValue;

    /** The user who created this task - must not be null and have a valid/known user record id **/
    private User creator;

    /** The user to whom this task is assigned - nullable, but if not null it must have a valid/known user record id */
    private User assignee;

    /** A list of labels used to describe this task and assist with filtering queries - must contain at least one value */
    private List<String> labels;

    public Task() {
        super();
        this.labels = new ArrayList<>();
    }

    public Task(String title, String description, int pointValue, User creator, User assignee) {
        this.title = title;
        this.description = description;
        this.pointValue = pointValue;
        this.creator = creator;
        this.assignee = assignee;
        this.labels = new ArrayList<>();
    }
    public Task(String title, String description, int pointValue, User creator, User assignee, List<String> labels) {
        this(title, description, pointValue, creator, assignee);
        this.labels = labels;
    }

    public Task(String id, String title, String description, int pointValue, User creator, User assignee, List<String> labels) {
        this(title, description, pointValue, creator, assignee, labels);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public void addLabels(String... labels) {

        if (this.labels == null) {
            this.labels = new ArrayList<>();
        }

        if (labels != null) {
            this.labels.addAll(Arrays.asList(labels));
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return pointValue == task.pointValue && Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(creator, task.creator) && Objects.equals(assignee, task.assignee) && Objects.equals(labels, task.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, pointValue, creator, assignee, labels);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pointValue=" + pointValue +
                ", creator=" + creator +
                ", assignee=" + assignee +
                ", labels=" + labels +
                '}';
    }

}
