/**
 * 
 */
package dataclasses;

/**
 * @author The Gentleman
 *
 */
public class PawnedItem {
	/**
	 * PawnesItem hold the data that represents a pawned item.
	 * */
	
	private String itemID;
	private String itemName;
	private double itemEstimateValue;
	private String itemDescription;
	
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
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the itemEstimateValue
	 */
	public double getItemEstimateValue() {
		return itemEstimateValue;
	}
	/**
	 * @param itemEstimateValue the itemEstimateValue to set
	 */
	public void setItemEstimateValue(double itemEstimateValue) {
		this.itemEstimateValue = itemEstimateValue;
	}
	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}
	/**
	 * @param itemDescription the itemDescription to set
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
}
