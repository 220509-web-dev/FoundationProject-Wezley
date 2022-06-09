package com.revature.taskmaster.util;

import com.revature.taskmaster.servlets.TestServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[DEBUG] - Starting up the web container!");
        ServletContext context = sce.getServletContext();

        TestServlet testServlet = new TestServlet();
        context.addServlet("TestServlet", testServlet).addMapping("/test");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[DEBUG] - Shutting down the web container!");
    }
}
