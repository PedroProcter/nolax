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
    private String changeHistory = "";

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
    	clients.clear();
    	
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
     * Synchronize all the change that were make in local with the table clients
     * 
     */
    public void dumpAllClients() {

        try(Statement statement = this.dbConnection.createStatement()){

        	if (!changeHistory.isBlank()) {
	        	 String[] changes = changeHistory.split(";");
	             
	             for (int index = 0; index < changes.length; index++) {
	            	 if (!changes[index].isBlank()) {statement.execute(changes[index]);}
	             }
        	}   

        }catch(SQLException e){
            e.printStackTrace();

        }
        
        changeHistory = "";

    }
    
    /**
     * Adds a client to the ArraList
     * @param client
     */
    public void addClient(Client client) {

        String sqlQuery = "INSERT INTO clients (client_id,name,last_name,phone,email,address) " + 
        "VALUES ('"+client.getClientID()+"', '"+
        client.getClientName()+"', "+
        "'"+client.getClientLastname()+"', "+
        "'"+client.getClientTelephoneNumber()+"', "+
        "'"+client.getClientEmail()+"', " +
        "'"+client.getClientAddress()+"');";

        //queryList.add(sqlQuery);
        
        changeHistory += sqlQuery;

        this.clients.add(client);
    }

    /**
     * Returns the index of a client
     * @param clientId
     * @return The index in the Arraylist of the client
     */
    private int findClientIndex(String clientId) {
        int indexOfTheClient = -1;

        for (int index = 0; index < clients.size(); index++){
       	 	Client client = clients.get(index);
       	 	
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

        String sqlQuery = 
        "DELETE FROM clients WHERE client_id = '"+clientId+"';";

        changeHistory += sqlQuery;
        
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

     /**
     * @param currentname,newName,
     * @return change the values of our client
     */

     public void changeItem(String oldId, Client newClient){
        
    	 if (findClientIndex(oldId) != -1) {
    	 
        Client oldClient = clients.get(findClientIndex(oldId));
	        String sqlQuery = "UPDATE clients" +
	        " SET name = '"+ newClient.getClientName()+"', "+
	        "last_name = '"+ newClient.getClientLastname()+"', "+
	        "phone = '"+ newClient.getClientTelephoneNumber()+"', "+
	        "email = '"+ newClient.getClientEmail()+"', "+
	        "address = '"+ newClient.getClientAddress()+"' "+
	        " WHERE client_id = '"+ oldId+"';";
	
	        changeHistory += sqlQuery;
	 
	        oldClient.setClientName(newClient.getClientName());
	        oldClient.setClientLastname(newClient.getClientLastname());
	        oldClient.setClientTelephoneNumber(newClient.getClientTelephoneNumber());
	        oldClient.setClientEmail(newClient.getClientEmail());
	        oldClient.setClientAddress(newClient.getClientAddress());
        }else{
        	this.addClient(newClient);
        }


     }

    /**
     * @param 
     * @return all the clients 
     */

    public  ArrayList<Client> getAllClients(){
       
        return(clients);

     }

}
