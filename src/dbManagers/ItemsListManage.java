package dbManagers;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataclasses.PawnedItem;

public class ItemsListManage implements CanGetDBConnection {
    /*
    This class provides method to manage an ArrayList of clients
    
    */
    
    private Connection dbConnecion;
    private ArrayList<PawnedItem> items = new ArrayList<PawnedItem>();
    
    @Override
    public void setDBConnection(Connection dbConnection){

        this.dbConnecion = dbConnection;
        
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
                
                item.setItemID(resultSet.getString("item_id"));
                item.setItemName(resultSet.getString("name"));
                item.setItemEstimateValue(resultSet.getDouble("price"));
                item.setItemDescription(resultSet.getString("description"));
                
                items.add(item);
                
                
            }
        } catch(SQLException e){e.printStackTrace();}
               
    }
    
}
