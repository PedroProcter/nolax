package dbManagers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dataclasses.PawnAgreement;

public class AgreementsListManager implements CanGetDBConnection {
    /**
     * This class provides method to manage an ArrayList of pawn agreements
     */

    private Connection dbConnection;
    private ArrayList<PawnAgreement> pawnAgreements = new ArrayList<PawnAgreement>();
    private String changeHistory = "";

    @Override
    public void setDBConnection(Connection dbConnection) {

       this.dbConnection = dbConnection;
        
    }

    /**
     * 
     * Gets all the rows of the table agreements
     * 
     */
    public void loadAllAgreements() {
        String sqlQuery = "SELECT * FROM agreements";

        try (Statement statement = this.dbConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()) {
                PawnAgreement pawnAgreement = new PawnAgreement();

                pawnAgreement.setClientID(resultSet.getString("client_id"));
                pawnAgreement.setItemID(resultSet.getString("item_id"));
                pawnAgreement.setAgreementID(resultSet.getString("agreement_id"));
                pawnAgreement.setAgreementDescription(resultSet.getString("description"));
                pawnAgreement.setAgreementConditions(resultSet.getString("conditions"));
                pawnAgreement.setAgreementStartingDate(resultSet.getString("start_date"));
                pawnAgreement.setAgreementEndingDate(resultSet.getString("end_date"));

                this.pawnAgreements.add(pawnAgreement);
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
    public void dumpAllAgreements() {

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
     * Add a PawnAgreement object to the ArrayList
     * @param agreement
     */
    public void addAgreement(PawnAgreement agreement) {


        this.pawnAgreements.add(agreement);

        String sqlQuery = "INSERT INTO agreements " + "(client_id,item_id,start_date,end_date,conditions,description) " + 
        "VALUES ('"+agreement.getClientID()+"', "+Integer.valueOf(agreement.getItemID())+", '"+agreement.getAgreementStartingDate()+"', "+
        "'"+agreement.getAgreementEndingDate()+"', "+
        "'"+agreement.getAgreementConditions()+"', "+
        "'"+agreement.getAgreementDescription()+"');";

        changeHistory += sqlQuery;
    }

    /**
     * Find the index of an PawnAgreement object in the ArrayList
     * @param agreementID
     * @return The index in the Arraylist of the PawnAgreement
     */
    private int findItemIndex(String agreementID){
        int indexOfTheAgreement = -1;

        for(int index = 0; index < pawnAgreements.size(); index++){
        	PawnAgreement agreement = pawnAgreements.get(index);
        	
            if(agreement.getAgreementID().equals(agreementID)){
                indexOfTheAgreement = this.pawnAgreements.indexOf(agreement);
            }
        }

        return indexOfTheAgreement;
    }

    /**
     * Delete a PawnAgreement object from the ArrayList
     * @param agreementID
     */
    public void deleteAgreement(String agreementID) {
        
        String sqlQuery = 
        "DELETE FROM agreements WHERE agreement_id = "+agreementID+";";

        changeHistory += sqlQuery;

        this.pawnAgreements.remove(findItemIndex(agreementID));
    }

    /**
     * Return (based on it's id) a PawnAgreement from the ArrayList
     * @param agreementID
     * @return
     */
    public PawnAgreement getAgreement(String agreementID) {
        return this.pawnAgreements.get(this.findItemIndex(agreementID));
    }

     /**
     * @param oldId,newAgreement
     * @return change the values of our Agreements
     */

    public void changeAgreement(String oldId, PawnAgreement newAgreement){
        
    	if (findItemIndex(oldId) != -1) {
    		PawnAgreement oldAgreement = pawnAgreements.get(findItemIndex(oldId));

        	String sqlQuery = "UPDATE agreements"+
	        " SET client_id = '"+ newAgreement.getClientID()+"',"+
	        "item_id = "+ Integer.valueOf(newAgreement.getItemID())+","+
	        "start_date = '"+ newAgreement.getAgreementStartingDate()+"',"+
	        "end_date = '"+ newAgreement.getAgreementEndingDate()+"',"+
	        "conditions = '"+ newAgreement.getAgreementConditions()+"',"+
	        "description = '"+ newAgreement.getAgreementDescription()+
	        "' WHERE agreement_id = "+ newAgreement.getAgreementID()+";";
	
	        changeHistory += sqlQuery;
	
	        oldAgreement.setClientID(newAgreement.getClientID());
	        oldAgreement.setItemID(newAgreement.getItemID());
	        oldAgreement.setAgreementStartingDate(newAgreement.getAgreementStartingDate());
	        oldAgreement.setAgreementEndingDate(newAgreement.getAgreementEndingDate());
	        oldAgreement.setAgreementConditions(newAgreement.getAgreementConditions());
	        oldAgreement.setAgreementDescription(newAgreement.getAgreementDescription());
        }else {
        	this.addAgreement(newAgreement);
        }

     }
    
    /**
     * @param 
     * @return all the Agreements 
     */

    public  ArrayList<PawnAgreement> getAllAgreements(){
       
        return(pawnAgreements);

     }


}
