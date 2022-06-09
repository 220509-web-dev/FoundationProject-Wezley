package com.revature.taskmaster.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connectionFactory = new ConnectionFactory();

    public static ConnectionFactory getInstance() {
        return connectionFactory;
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load PostgreSQL JDBC Driver");
        }
    }

    private final Properties props = new Properties();

    private ConnectionFactory() {
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load DB properties");
        }
    }

    public Connection getConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(props.getProperty("db-url"), props.getProperty("db-username"), props.getProperty("db-password"));

        if (conn == null) {
            throw new RuntimeException("Failed to establish a connection to the database");
        }

        return conn;

    }

}
