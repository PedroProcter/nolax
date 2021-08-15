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
    public void loadAllClients() {
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

    /**
     * 
     * Syncronize all the change that were make in local with the table clients
     * 
     */
    public void dumpAllClients() {}
    
    /**
     * Adds a client to the ArraList
     * @param client
     */
    public void addClient(Client client) {
        this.clients.add(client);
    }

    /**
     * Returns the index of a client
     * @param clientId
     * @return The index in the Arralist of the client
     */
    private int findClientIndex(String clientId) {
        int indexOfTheClient = -1;

        for (Client client: (Client[]) this.clients.toArray()) {
            if (client.getClientID().equals(clientId)) {
                indexOfTheClient = this.clients.indexOf(client);
            }
        }

        return indexOfTheClient;
    }

    /**
     * Deletes a client from the ArrayList
     * @param clientId
     */
    public void deleteClient(String clientId) {
        this.clients.remove(this.findClientIndex(clientId));
    }

    /**
     * Returns a client object
     * @param clientId
     * @return The Client found. If there if no client found, then return null
     */
    public Client getClient(String clientId) {
        Client clientFound = null;

        clientFound = this.clients.get(this.findClientIndex(clientId));

        return clientFound;
    }

}

