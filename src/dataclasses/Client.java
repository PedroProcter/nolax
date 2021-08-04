/**
 * 
 */
package dataclasses;

/**
 * @author The Gentleman
 *
 */
public class Client {
	/**
	 * Client hold the data that represents a client.
	 * */
	
	private String clientID;
	private String clientName;
	private String clientLastname;
	private String clientTelephoneNumber;
	private String clientEmail;
	private String clientAddress;
	
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
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @return the clientLastname
	 */
	public String getClientLastname() {
		return clientLastname;
	}
	/**
	 * @param clientLastname the clientLastname to set
	 */
	public void setClientLastname(String clientLastname) {
		this.clientLastname = clientLastname;
	}
	/**
	 * @return the clientTelephoneNumber
	 */
	public String getClientTelephoneNumber() {
		return clientTelephoneNumber;
	}
	/**
	 * @param clientTelephoneNumber the clientTelephoneNumber to set
	 */
	public void setClientTelephoneNumber(String clientTelephoneNumber) {
		this.clientTelephoneNumber = clientTelephoneNumber;
	}
	/**
	 * @return the clientEmail
	 */
	public String getClientEmail() {
		return clientEmail;
	}
	/**
	 * @param clientEmail the clientEmail to set
	 */
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	/**
	 * @return the clientAddress
	 */
	public String getClientAddress() {
		return clientAddress;
	}
	/**
	 * @param clientAddress the clientAddress to set
	 */
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	
}