package com.revature.taskmaster.services;

import com.revature.taskmaster.daos.TaskDAO;
import com.revature.taskmaster.entities.Task;

import java.util.List;

public class TaskService {

    private final TaskDAO taskDao;

    public TaskService(TaskDAO taskDao) {
        this.taskDao = taskDao;
    }

    public List<Task> getTasksByCreatorId(String creatorId) {

        if (creatorId == null || creatorId.trim().equals("")) {
            throw new RuntimeException("Invalid id provided!");
        }

        List<Task> taskList = taskDao.getTasksByCreatorId(creatorId);

        if (taskList.isEmpty()) {
            throw new RuntimeException("No tasks found with the provided creatorId!");
        }

        return taskList;

    }

}
