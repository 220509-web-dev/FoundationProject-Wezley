package com.revature.taskmaster.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[DEBUG] - Starting up the web container!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[DEBUG] - Shutting down the web container!");
    }
}
