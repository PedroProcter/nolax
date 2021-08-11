<<<<<<< Updated upstream
package dbManager;
=======
package dbManagers;
>>>>>>> Stashed changes

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

<<<<<<< Updated upstream
import dataclasses.Client;

public class ItemsListManage implements CanGetConnection {
=======
import dataclasses.PawnedItem;

public class ItemsListManage implements CanGetDBConnection {
>>>>>>> Stashed changes
    /*
    This class provides method to manage an ArrayList of clients
    
    */
    
    private Connection dbConnecion;
<<<<<<< Updated upstream
    private ArrayList<PawnedItem> clients = new ArrayList<PawnedItem>();
=======
    private ArrayList<PawnedItem> items = new ArrayList<PawnedItem>();
>>>>>>> Stashed changes
    
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
                
<<<<<<< Updated upstream
                item.setItemID(resultSet.getString("client_id"));
                item.setItemName(resultSet.getString("name"));
                item.setITemEstimateValue(resultSet.getInt("price"));
                item.setItemDescription(resultSet.getString("description"));
                
                item.add(PawnedItem);
=======
                item.setItemID(resultSet.getString("item_id"));
                item.setItemName(resultSet.getString("name"));
                item.setItemEstimateValue(resultSet.getDouble("price"));
                item.setItemDescription(resultSet.getString("description"));
                
                items.add(item);
>>>>>>> Stashed changes
                
                
            }
        } catch(SQLException e){e.printStackTrace();}
               
    }
    
}
