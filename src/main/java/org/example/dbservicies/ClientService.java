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

    public long create(String name) throws SQLException {
        long id = -1L;
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
   public String getById(long id) throws SQLException {
        ResultSet resultSet;
        String result="";
        try(PreparedStatement statement = connection.prepareStatement("select name from client where id = ?")){
            statement.setLong(1,id);
            statement.execute();
            resultSet = statement.getResultSet();
            if(resultSet.next()) result=resultSet.getString("name");

        }catch(SQLException e){
           logger.error("select by id fail!!!");
           throw e;
        }
        return result;
   }
    public void setName(long id, String name) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement("update client set name = ? where id = ?")){
            statement.setString(1, name);
            statement.setLong(2,id);
            statement.execute();

        }catch(SQLException e){
            logger.error("update fail!");
            throw e;
        }

    }
    public void deleteById(long id) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement("delete from client where id = ?")){
            statement.setLong(1,id);
            statement.execute();

        }catch(SQLException e){
            logger.error("delete fail!");
            throw e;
        }
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
            logger.error("listAll  fail! ");
            throw e;
        }
      return clientList;
    }

   
}
