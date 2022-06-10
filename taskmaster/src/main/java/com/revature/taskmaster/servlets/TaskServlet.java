package com.revature.taskmaster.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.taskmaster.dtos.ErrorResponse;
import com.revature.taskmaster.dtos.NewTaskRequest;
import com.revature.taskmaster.dtos.ResourceCreationResponse;
import com.revature.taskmaster.entities.Task;
import com.revature.taskmaster.exceptions.BadRequestException;
import com.revature.taskmaster.exceptions.ResourceNotFoundException;
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

        try {
            if (creatorId != null) {
                resp.getWriter().write(jsonMapper.writeValueAsString(taskService.getTasksByCreatorId(creatorId)));
                return;
            }
        } catch (BadRequestException e) {
            resp.setStatus(400);
            resp.getWriter().write(jsonMapper.writeValueAsString(new ErrorResponse(400, e.getMessage())));
            return;
        } catch (ResourceNotFoundException e) {
            resp.setStatus(404);
            resp.getWriter().write(jsonMapper.writeValueAsString(new ErrorResponse(404, e.getMessage())));
            return;
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
            ErrorResponse err = new ErrorResponse(500, "The server ran into an unhandled exception. Developers please check the server logs");
            resp.getWriter().write(jsonMapper.writeValueAsString(err));
            return;
        }

        resp.setStatus(501);
        resp.setHeader("Retry-After", LocalDateTime.now().plusDays(1).toString());
        resp.getWriter().write("{\"error\":\"No implementation for this operation yet\"}");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[LOG] - TaskServlet#doPost received a request at " + LocalDateTime.now());
        resp.setContentType("application/json");

        try {
            NewTaskRequest reqPayload = jsonMapper.readValue(req.getInputStream(), NewTaskRequest.class);
            ResourceCreationResponse result = taskService.saveNewCard(reqPayload);
            resp.setStatus(201);
            resp.getWriter().write(jsonMapper.writeValueAsString(result));
        } catch (BadRequestException e) {
            resp.setStatus(400);
            resp.getWriter().write(jsonMapper.writeValueAsString(new ErrorResponse(400, e.getMessage())));
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
            ErrorResponse err = new ErrorResponse(500, "The server ran into an unhandled exception. Developers please check the server logs");
            resp.getWriter().write(jsonMapper.writeValueAsString(err));
        }

    }
}
