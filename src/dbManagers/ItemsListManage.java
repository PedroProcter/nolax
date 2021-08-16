package dbManagers;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataclasses.Client;
import dataclasses.PawnAgreement;
import dataclasses.PawnedItem;

public class ItemsListManage implements CanGetDBConnection {
    /*
    This class provides method to manage an ArrayList of items
    
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
    public void loadAllItems(){
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
    
       /**
     * 
     * Syncronize all the change that were make in local with the table Items
     * 
     */

    public void dumpAllItems(){}

      /**
     * Adds a items to the ArrayList
     * @param items
     */

    public void addItem(PawnedItem items){
        this.items.add(items);
    }

    /**
     * Returns the index of a item
     * @param ItemId
     * @return The index in the Arralist of the item
     */

     private int findItemIndex(String itemID){
         int indexOfTheItem = -1;

         for(PawnedItem item:(PawnedItem[]) this.items.toArray()){
             if(item.getItemID().equals(itemID)){
                 indexOfTheItem= this.items.indexOf(item);
             }
         }

         return indexOfTheItem;
     }

     /**
     * Deletes a Item from the ArrayList
     * @param itemtId
     */
     public void deleteItem(String itemId){
        

        this.items.remove(this.findItemIndex(itemId));
     }

     /**
     * Returns a Item object
     * @param ItemId
     * @return The Item found. If there if no Item found, then return null
     */



     public PawnedItem getItem(String itemId){
         PawnedItem itemFound = null;

         itemFound = this.items.get(this.findItemIndex(itemId));
         
         return itemFound;
     }

     /**
     * @param oldId,newItem
     * @return change the values of our items
     */

     public void changeItem(String oldId, PawnedItem newItem){
        
        PawnedItem oldItem = items.get(findItemIndex(oldId));
        oldItem.setItemName(newItem.getItemName());
        oldItem.setItemEstimateValue(newItem.getItemEstimateValue());
        oldItem.setItemDescription(newItem.getItemDescription());

     }

    /**
     * @param 
     * @return all the Items 
     */

     public  ArrayList<PawnedItem> getAllItems(){
       
        return(items);

     }


}
