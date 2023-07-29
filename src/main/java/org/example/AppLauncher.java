package org.example;

import lombok.SneakyThrows;
import org.apache.log4j.BasicConfigurator;
import org.example.dbservicies.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class AppLauncher {
    private static final Logger logger = LoggerFactory.getLogger(AppLauncher.class);
    @SneakyThrows
    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Application started.");
        ClientService clientService = new ClientService(Database.getInstance().getConnection());
        try{
            Long clientId= clientService.create("Lebovski");
            logger.info("clientId {} ",clientId);
            logger.info("name {}",clientService.getById(clientId.longValue()));

        }catch(SQLException e){

            logger.error("clientService.create(); failed!!! ");

        }





    }
}