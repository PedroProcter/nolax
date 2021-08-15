/**
 * 
 */
package ui;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dataclasses.*;

/**
 * @author The Gentleman
 *
 */
public class ListPanelLoader {
	
	private JPanel targetContainer;
	

	public void setTargetContainer(JPanel container) {
		targetContainer = container;
	}
	
	public void populateListPanel(ArrayList<Client> clients, int k) {
		
		for (Client client: (Client[]) clients.toArray()) {
			JPanel cardContainer = new JPanel();
			JPanel card = new JPanel();
			cardContainer.add(card);
			
			JLabel clientInfoLabel = new JLabel(client.getClientID() + "\t\t" + client.getClientName() + " " + client.getClientLastname() + "\t\t" + client.getClientEmail());
			card.add(clientInfoLabel);
			
			targetContainer.add(cardContainer);
		}
	}
	

	public void populateListPanel(ArrayList<PawnAgreement> agreements, double k) {
		
		for (PawnAgreement agreement: (PawnAgreement[]) agreements.toArray()) {
			JPanel cardContainer = new JPanel();
			JPanel card = new JPanel();
			cardContainer.add(card);
			
			JLabel agreementInfoLabel = new JLabel(agreement.getAgreementID() + "\t\t" + agreement.getItemID() + "\t\t" + agreement.getAgreementStartingDate() + "\t" + agreement.getAgreementEndingDate());
			card.add(agreementInfoLabel);
			
			targetContainer.add(cardContainer);
		}
	}
	

	public void populateListPanel(ArrayList<PawnedItem> items, char k) {
		
		for (PawnedItem item: (PawnedItem[]) items.toArray()) {
			JPanel cardContainer = new JPanel();
			JPanel card = new JPanel();
			cardContainer.add(card);
			
			JLabel itemInfoLabel = new JLabel(item.getItemID() + "\t\t" + item.getItemName() + "\t\t" + item.getItemEstimateValue());
			card.add(itemInfoLabel);
			
			targetContainer.add(cardContainer);
		}
	}

}
