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
            logger.info("Create new client with name 'Lebovski'");
            long clientId= clientService.create("Lebovski");
            String clientName = clientService.getById(clientId); // get new client name by ID
            logger.info("Check creation of new client ID = '{}' NAME = '{}'", clientId, clientName);
            logger.info("Try to change name of client to 'Ken Block' ID = {}", clientId);
            clientService.setName(clientId,"Ken Block");
            clientName = clientService.getById(clientId); // get new name
            logger.info("Get updated name of client ID = '{}' NAME = '{}'", clientId, clientName);
            logger.info("Try to delete client         ID = {}", clientId);
            clientService.deleteById(clientId);
            clientName=clientService.getById(clientId);
            logger.info("Check is client name empty   ID = '{}' NAME = '{}' ",clientId, clientName);
            logger.info("Get list of all clients");
            clientService.listAll().forEach(client->logger.info("ID = {}  NAME = {}",client.getId(),client.getName()));

        }catch(SQLException e){
            logger.error("clientService execution failed!!! ");
        }





    }
}