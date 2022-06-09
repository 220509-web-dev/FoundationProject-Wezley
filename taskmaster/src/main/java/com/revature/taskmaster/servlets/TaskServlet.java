package com.revature.taskmaster.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.taskmaster.entities.Task;
import com.revature.taskmaster.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class TaskServlet extends HttpServlet {

    private final ObjectMapper jsonMapper;
    private final TaskService taskService;

    public TaskServlet(ObjectMapper jsonMapper, TaskService taskService) {
        this.jsonMapper = jsonMapper;
        this.taskService = taskService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[LOG] - TaskServlet#doGet received a request at " + LocalDateTime.now());
        resp.setContentType("application/json");

        String creatorId = req.getParameter("creatorId");

        if (creatorId != null) {
            resp.getWriter().write(jsonMapper.writeValueAsString(taskService.getTasksByCreatorId(creatorId)));
        }

        resp.setStatus(501);
        resp.setHeader("Retry-After", LocalDateTime.now().plusDays(1).toString());
        resp.getWriter().write("{\"error\":\"No implementation for this operation yet\"}");

    }
}
