package dbManagers;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataclasses.PawnedItem;

public class ItemsListManager implements CanGetDBConnection {
    /**
    *This class provides method to manage an ArrayList of items
    */
    
    private Connection dbConnection;
    private ArrayList<PawnedItem> items = new ArrayList<PawnedItem>();
    private String changeHistory = "";
    
    @Override
    public void setDBConnection(Connection dbConnection){

        this.dbConnection = dbConnection;
        
    }
    
    /**
    *Get rows of the table items
    */
    public void loadAllItems(){
        String query = "SELECT * FROM items";
        
        items.clear();
        
        try(Statement statement = this.dbConnection.createStatement()){
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
     * Synchronize all the change that were make in local with the table Items
     * 
     */

    public void dumpAllItems(){
    	

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
     * Adds a items to the ArrayList
     * @param items
     */

    public void addItem(PawnedItem items){

        String sqlQuery = "INSERT INTO items(name,price,description) " + 
        "VALUES('"+
        items.getItemName()+"', "+
        items.getItemEstimateValue()+", "+
        "'"+items.getItemDescription()+"');";
        
        changeHistory += sqlQuery;

        this.items.add(items);
    }

    /**
     * Returns the index of a item
     * @param ItemId
     * @return The index in the Arraylist of the item
     */

     private int findItemIndex(String itemID){
         int indexOfTheItem = -1;

         for(int index = 0; index < items.size(); index++){
        	 PawnedItem item = items.get(index);
        	 
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
        
        String sqlQuery = 
        "DELETE FROM items WHERE item_id = "+itemId+";";
        changeHistory += sqlQuery;


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
    	
    	if (findItemIndex(oldId) != -1) {PawnedItem oldItem = items.get(findItemIndex(oldId));
	        String sqlQuery = "UPDATE items"+
	        		" SET name = '"+ newItem.getItemName()+"', "+"price = " + newItem.getItemEstimateValue() + ", "+"description = '" + newItem.getItemDescription() +"'"+" "
	        		+ "WHERE item_id = "+oldId+";";
	        changeHistory += sqlQuery;
	        
	        oldItem.setItemName(newItem.getItemName());
	        oldItem.setItemEstimateValue(newItem.getItemEstimateValue());
	        oldItem.setItemDescription(newItem.getItemDescription());
        }else {
        	this.addItem(newItem);
        }
        

     }

    /**
     * @param 
     * @return all the Items 
     */

     public  ArrayList<PawnedItem> getAllItems(){
       
        return(items);

     }

}
