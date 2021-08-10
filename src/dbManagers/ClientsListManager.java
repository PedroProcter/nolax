package dbManagers;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataclasses.Client;

public class ClientsListManager implements CanGetDBConnection {
    /**
     * This class provides method to manage an ArrayList of clients
     */

    private Connection dbConnection;
    private ArrayList<Client> clients = new ArrayList<Client>();

    @Override
    public void setDBConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    /**
     * 
     * Gets all the rows of the table clients
     * 
     */
    public void getAllClients() {
        String sqlQuery = "SELECT * FROM clients";

        try (Statement statement = this.dbConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()) {
                Client client = new Client();

                client.setClientID(resultSet.getString("client_id"));
                client.setClientName(resultSet.getString("name"));
                client.setClientLastname(resultSet.getString("last_name"));
                client.setClientTelephoneNumber(resultSet.getString("phone"));
                client.setClientEmail(resultSet.getString("email"));
                client.setClientAddress(resultSet.getString("address"));

                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

