/**
 * 
 */
package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import dataclasses.*;

/**
 * @author The Gentleman
 *
 */
public class ListPanelLoader {
	
	private JPanel targetContainer;
	
	private Color light_gray = new Color(253, 253, 253);

	public void setTargetContainer(JPanel container) {
		targetContainer = container;
	}
	
	public void populateListPanel(ArrayList<Client> clients, int k) {
		
		for (int index = 0; index < clients.size(); index++) {
			Client client = clients.get(index);
			
			JPanel cardContainer = new JPanel();
			cardContainer.setBackground(light_gray);
			JPanel card = new JPanel();
			card.setBackground(light_gray);
			card.setBorder(new LineBorder(Color.GRAY, 1, true));
			card.setCursor(new Cursor(Cursor.HAND_CURSOR));
			cardContainer.add(card);
			
			JLabel clientInfoLabel = new JLabel(client.getClientID() + "        " + client.getClientName() + "  " + client.getClientLastname() + "        " + client.getClientEmail());
			card.add(clientInfoLabel);
			
			card.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					@SuppressWarnings("unused")
					ClientMoreInfoCard popup = new ClientMoreInfoCard(client);
				}
			});
			
			targetContainer.add(cardContainer);
		}
	}
	

	public void populateListPanel(ArrayList<PawnAgreement> agreements, double k) {
		
		for (int index = 0; index < agreements.size(); index++) {
			PawnAgreement agreement = agreements.get(index);
			
			JPanel cardContainer = new JPanel();
			cardContainer.setBackground(light_gray);
			JPanel card = new JPanel();
			card.setBackground(light_gray);
			card.setBorder(new LineBorder(Color.GRAY, 1, true));
			card.setCursor(new Cursor(Cursor.HAND_CURSOR));
			cardContainer.add(card);
			
			JLabel agreementInfoLabel = new JLabel(agreement.getAgreementID() + "        " + agreement.getItemID() + "        " + agreement.getAgreementStartingDate() + "    " + agreement.getAgreementEndingDate());
			card.add(agreementInfoLabel);
			
			card.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					@SuppressWarnings("unused")
					AgreementMoreInfoCard popup = new AgreementMoreInfoCard(agreement);
				}
			});
			
			targetContainer.add(cardContainer);
		}
	}
	

	public void populateListPanel(ArrayList<PawnedItem> items) {
		
		for (int index = 0; index < items.size(); index++) {
			PawnedItem item = items.get(index);
			
			JPanel cardContainer = new JPanel();
			cardContainer.setBackground(light_gray);
			JPanel card = new JPanel();
			card.setBackground(light_gray);
			card.setBorder(new LineBorder(Color.GRAY, 1, true));
			card.setCursor(new Cursor(Cursor.HAND_CURSOR));
			cardContainer.add(card);
			
			JLabel itemInfoLabel = new JLabel(item.getItemID() + "        " + item.getItemName() + "        " + item.getItemEstimateValue());
			card.add(itemInfoLabel);
			
			card.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					@SuppressWarnings("unused")
					ItemMoreInfoCard popup = new ItemMoreInfoCard(item);
				}
			});
			
			targetContainer.add(cardContainer);
		}
	}

}
