package dbManager;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataclasses.Client;

public class ItemsListManage implements CanGetConnection {
    /*
    This class provides method to manage an ArrayList of clients
    
    */
    
    private Connection dbConnecion;
    private ArrayList<PawnedItem> clients = new ArrayList<PawnedItem>();
    
    @Override
    public void setDBConnection(Connection dbConnection){
        
    }
    
    /*
    Get rows of the table items
    */
    public void getAllItems(){
        String query = "SELECT * FORM items";
        
        try(Statement statement = this.dbConnecion.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                
                PawnedItem item = new PawnedItem();
                
                item.setItemID(resultSet.getString("client_id"));
                item.setItemName(resultSet.getString("name"));
                item.setITemEstimateValue(resultSet.getInt("price"));
                item.setItemDescription(resultSet.getString("description"));
                
                item.add(PawnedItem);
                
                
            }
        } catch(SQLException e){e.printStackTrace();}
               
    }
    
}
