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
    private ArrayList<PawnAgreement> pawnAgreements;

    @Override
    public void setDBConnection(Connection dbConnection) {

       this.dbConnection = dbConnection;
        
    }

    /**
     * 
     * Gets all the rows of the table agreements
     * 
     */
    public void loadAllClients() {
        String sqlQuery = "SELECT * FROM clients";

        try (Statement statement = this.dbConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()) {
                PawnAgreement pawnAgreement = new PawnAgreement();

                pawnAgreement.setClientID(resultSet.getString("client_id"));
                pawnAgreement.setItemID(resultSet.getString("item_id"));
                pawnAgreement.setAgreementID(
                    pawnAgreement.getClientID().substring(0, 10) + 
                    pawnAgreement.getItemID().substring(0, 0)
                    );
                pawnAgreement.setAgreementDescription(resultSet.getString("description"));
                pawnAgreement.setAgreementConditions(resultSet.getString("conditions"));
                pawnAgreement.setAgreementStartingDate(resultSet.getString("start_date"));
                pawnAgreement.setAgreementEndingDate("end_date");

                this.pawnAgreements.add(pawnAgreement);
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
     * Add a PawnAgreement object to the ArrayList
     * @param agreement
     */
    public void addAgreement(PawnAgreement agreement) {
        this.pawnAgreements.add(agreement);
    }

    /**
     * Find the index of an expecific PawnAgreement object in the ArrayList
     * @param agreementID
     * @return The index in the Arralist of the PawnAgreement
     */
    private int findItemIndex(String agreementID){
        int indexOfTheAgreement = -1;

        for(PawnAgreement agreement:(PawnAgreement[]) this.pawnAgreements.toArray()){
            if(agreement.getItemID().equals(agreementID)){
                indexOfTheAgreement = this.pawnAgreements.indexOf(agreement);
            }
        }

        return indexOfTheAgreement;
    }

    /**
     * Delete a PawnAgreement object fomr the ArraList
     * @param agreementID
     */
    public void deleteAgreement(String agreementID) {
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
        
        PawnAgreement oldAgreement = pawnAgreements.get(findItemIndex(oldId));
        oldAgreement.setClientID(newAgreement.getClientID());;
        oldAgreement.setItemID(newAgreement.getItemID());
        oldAgreement.setAgreementStartingDate(newAgreement.getAgreementStartingDate());
        oldAgreement.setAgreementEndingDate(newAgreement.getAgreementEndingDate());
        oldAgreement.setAgreementConditions(newAgreement.getAgreementConditions());
        oldAgreement.setAgreementDescription(newAgreement.getAgreementDescription());
     }
    
}
