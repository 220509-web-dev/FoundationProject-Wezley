package com.revature.taskmaster.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.taskmaster.daos.TaskDAO;
import com.revature.taskmaster.services.TaskService;
import com.revature.taskmaster.servlets.TaskServlet;
import com.revature.taskmaster.servlets.TestServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[DEBUG] - Starting up the web container!");
        ServletContext context = sce.getServletContext();

        // Instantiate utility classes
        ObjectMapper jsonMapper = new ObjectMapper();

        // Instantiate DAOs
        TaskDAO taskDao = new TaskDAO();

        // Instantiate services
        TaskService taskService = new TaskService(taskDao);

        // Instantiate and map servlets
        TestServlet testServlet = new TestServlet();
        context.addServlet("TestServlet", testServlet).addMapping("/test");

        TaskServlet taskServlet = new TaskServlet(jsonMapper, taskService);
        context.addServlet("TaskServlet", taskServlet).addMapping("/tasks");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[DEBUG] - Shutting down the web container!");
    }
}
