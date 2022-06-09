package com.revature.taskmaster.util;

import com.revature.taskmaster.dtos.NewTaskRequest;
import com.revature.taskmaster.entities.Task;
import com.revature.taskmaster.exceptions.BadRequestException;

public class ValidatorUtil {

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().equals("");
    }

    public static class TaskValidator {

        public static void isTaskValid(Task task) {

            if (task == null) {
                throw new RuntimeException("Provided task object was null");
            }

            if (isNullOrEmpty(task.getTitle())) {
                throw new RuntimeException("Provided task contained a null or empty title");
            }

            if (task.getTitle().length() > 50) {
                throw new RuntimeException("Provided task contained a title that exceeds 50 characters");
            }

            if (isNullOrEmpty(task.getDescription())) {
                throw new RuntimeException("Provided task contained a null or empty description");
            }

            if (task.getPointValue() < 0 || task.getPointValue() > 99) {
                throw new RuntimeException("Provided task contained a point value that was not between 0 and 100");
            }

            if (isNullOrEmpty(task.getCreator().getId())) {
                throw new RuntimeException("Provided task contained a null or empty creator id");
            }

            if (isNullOrEmpty(task.getAssignee().getId())) {
                throw new RuntimeException("Provided task contained a null or empty assignee id");
            }

            if (isNullOrEmpty(task.getLabel())) {
                throw new RuntimeException("Provided task contained a null or empty label");
            }

        }

        public static void isTaskValid(NewTaskRequest newTaskRequest) {

            if (newTaskRequest == null) {
                throw new RuntimeException("Provided task object was null");
            }

            isTaskValid(newTaskRequest.extractResource());

        }

    }

}
