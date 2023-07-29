package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Database {
    private static final Logger loggerDatabase = LoggerFactory.getLogger(Database.class);
    private static final String DB_URL = "jdbc:h2:file:./crud_migration_m6";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    public static final String DEFAULT_SCHEMA = "PUBLIC";

    private static Database databaseInstance = new Database();
    private Connection connection;



    private Database(){

    }
    public static Database getInstance(){
        if (Objects.isNull(databaseInstance)) {
            databaseInstance = new Database();
        }
        return databaseInstance;

    }

    public Connection getConnection(){
        if (Objects.isNull(connection)) {
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                loggerDatabase.info("Successfully connected to database {}", DB_URL);
                return connection;
            } catch (SQLException e1) {
                loggerDatabase.error("Database connection failed.");
            }
        }
        return connection;
    }



}
