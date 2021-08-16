/**
 * 
 */
package dataclasses;

/**
 * @author The Gentleman
 *
 */
public class PawnAgreement {
	/**
	 * PawnAgreement holds the data that represents a pawn agreement.
	 * */
	
	private String agreementID;
	private String clientID;
	private String itemID;
	private String agreementStartingDate;
	private String agreementEndingDate;
	private String agreementConditions;
	private String agreementDescription;
	public String Comments;
	
	/**
	 * @return the agreementID
	 */
	public String getAgreementID() {
		return agreementID;
	}
	/**
	 * @param agreementID the agreementID to set
	 */
	public void setAgreementID(String agreementID) {
		this.agreementID = agreementID;
	}
	/**
	 * @return the clientID
	 */
	public String getClientID() {
		return clientID;
	}
	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	/**
	 * @return the itemID
	 */
	public String getItemID() {
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	/**
	 * @return the agreementStartingDate
	 */
	public String getAgreementStartingDate() {
		return agreementStartingDate;
	}
	/**
	 * @param agreementStartingDate the agreementStartingDate to set
	 */
	public void setAgreementStartingDate(String agreementStartingDate) {
		this.agreementStartingDate = agreementStartingDate;
	}
	/**
	 * @return the agreementEndingDate
	 */
	public String getAgreementEndingDate() {
		return agreementEndingDate;
	}
	/**
	 * @param agreementEndingDate the agreementEndingDate to set
	 */
	public void setAgreementEndingDate(String agreementEndingDate) {
		this.agreementEndingDate = agreementEndingDate;
	}
	/**
	 * @return the agreementConditions
	 */
	public String getAgreementConditions() {
		return agreementConditions;
	}
	/**
	 * @param agreementConditions the agreementConditions to set
	 */
	public void setAgreementConditions(String agreementConditions) {
		this.agreementConditions = agreementConditions;
	}
	/**
	 * @return the agreementDescription
	 */
	public String getAgreementDescription() {
		return agreementDescription;
	}
	/**
	 * @param agreementDescription the agreementDescription to set
	 */
	public void setAgreementDescription(String agreementDescription) {
		this.agreementDescription = agreementDescription;
	}
}
