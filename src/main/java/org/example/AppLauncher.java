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
            long clientId= clientService.create("Lebovski");
            String clientName = clientService.getById(clientId);
            logger.info("Check creation: clientId {} name {}",
                    clientId,
                    clientName);
            clientService.listAll().forEach(client->logger.info("ID = {}  NAME = {}",client.getId(),client.getName()));
        }catch(SQLException e){
            logger.error("clientService execution failed!!! ");
        }





    }
}