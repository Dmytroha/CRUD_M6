package org.example.dbservicies;

import org.example.entities.Client;
import java.sql.*;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientService {
    private final Connection connection;
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
    public ClientService(Connection connection) {
        this.connection = connection;
    }

    public long create(String name) throws SQLException, IllegalArgumentException {
        Long id = -1L;
        ResultSet resultSet;
        try(
                PreparedStatement statement = connection.prepareStatement("insert into client (name) values (?)",
                Statement.RETURN_GENERATED_KEYS)
        )
        {
            statement.setString(1, name);
            statement.execute();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                id=resultSet.getLong(1);
                return id;
            }
            return id;
        }
    }
   public String getById(long id){

        return "";
   }
    public void setName(long id, String name){
// update name in table client where client.id=id
    }
    public void deleteById(long id){
// delete client where id = id
    }
 public List<Client> listAll() throws SQLException {
     Client client;
     ResultSet resultSet;
        List<Client> clientList = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement("select * from client")){
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                clientList.add(client);
            }
        }catch(SQLException e){
            logger.error("Sql statement error!!!");
            throw e;
        }
      return clientList;
    }

   
}
