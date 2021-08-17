/**
 * 
 */
package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import dataclasses.*;
import dbManagers.AgreementsListManager;
import dbManagers.ClientsListManager;
import dbManagers.ItemsListManager;

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
	
	public void populateListPanel(ClientsListManager clientsManager, String onlyIfContains) {
		JPanel rule = new JPanel();
		targetContainer.add(rule);
		rule.setBackground(light_gray);
		JLabel idLabel = new JLabel("|   ID   ");
		rule.add(idLabel);
		JLabel nameLabel = new JLabel("|   Name   |");
		rule.add(nameLabel);
		JLabel emailLabel = new JLabel("   Email   |");
		rule.add(emailLabel);
		
		ArrayList<Client> clients = clientsManager.getAllClients();
		
		for (int index = 0; index < clients.size(); index++) {
			Client client = clients.get(index);
			
			if (client.getClientName().contains(onlyIfContains) || onlyIfContains.isBlank()) {
				JPanel cardContainer = new JPanel();
				cardContainer.setBackground(light_gray);
				JPanel card = new JPanel();
				card.setBackground(light_gray);
				card.setBorder(new LineBorder(Color.GRAY, 1, true));
				card.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cardContainer.add(card);
				
				JLabel clientInfoLabel = new JLabel(client.getClientID() + "    |    " + client.getClientName() + "  " + client.getClientLastname() + "    |    " + client.getClientEmail());
				card.add(clientInfoLabel);
				
				card.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						@SuppressWarnings("unused")
						ClientMoreInfoCard popup = new ClientMoreInfoCard(client, targetContainer, clientsManager);
					}
				});
				
				targetContainer.add(cardContainer);
			}
			
			
		}
	}
	

	public void populateListPanel(AgreementsListManager agreementsManager, String onlyIfContains) {
		JPanel rule = new JPanel();
		targetContainer.add(rule);
		rule.setBackground(light_gray);
		JLabel idLabel = new JLabel("|   ID   |");
		rule.add(idLabel);
		JLabel itemIDLabel = new JLabel("   Item ID   |");
		rule.add(itemIDLabel);
		JLabel nameLabel = new JLabel("   Start   |");
		rule.add(nameLabel);
		JLabel emailLabel = new JLabel("   End   |");
		rule.add(emailLabel);
		
		ArrayList<PawnAgreement> agreements = agreementsManager.getAllAgreements();
		
		for (int index = 0; index < agreements.size(); index++) {
			PawnAgreement agreement = agreements.get(index);
			
			if (agreement.getAgreementID().contains(onlyIfContains) || onlyIfContains.isBlank()) {
				JPanel cardContainer = new JPanel();
				cardContainer.setBackground(light_gray);
				JPanel card = new JPanel();
				card.setBackground(light_gray);
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
				SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
				LocalDateTime now = LocalDateTime.now();
				
				try {
					Date systemDateTime = parser.parse(dtf.format(now));
					Date agreementEndDateTime = parser.parse(agreement.getAgreementEndingDate());
					
					if (systemDateTime.compareTo(agreementEndDateTime) < 0) {
						card.setBorder(new LineBorder(Color.GRAY, 1, true));
					}else if (systemDateTime.compareTo(agreementEndDateTime) > 0) {
						card.setBorder(new LineBorder(Color.RED, 1, true));
					}else if (systemDateTime.compareTo(agreementEndDateTime) == 0) {
						card.setBorder(new LineBorder(Color.GRAY, 1, true));
					}
				} catch (ParseException e1) {
					card.setBorder(new LineBorder(Color.GRAY, 1, true));
					e1.printStackTrace();
				}
				
				card.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cardContainer.add(card);
				
				JLabel agreementInfoLabel = new JLabel(agreement.getAgreementID() + "    |    " + agreement.getItemID() + "    |    " + agreement.getAgreementStartingDate() + "  |  " + agreement.getAgreementEndingDate());
				card.add(agreementInfoLabel);
				
				card.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						@SuppressWarnings("unused")
						AgreementMoreInfoCard popup = new AgreementMoreInfoCard(agreement, targetContainer, agreementsManager);
					}
				});
				
				targetContainer.add(cardContainer);
			}
		}
	}
	

	public void populateListPanel(ItemsListManager itemsManager, String onlyIfContains) {
		JPanel rule = new JPanel();
		targetContainer.add(rule);
		rule.setBackground(light_gray);
		JLabel idLabel = new JLabel("|   ID   ");
		rule.add(idLabel);
		JLabel nameLabel = new JLabel("|   Name   |");
		rule.add(nameLabel);
		JLabel emailLabel = new JLabel("   Value   |");
		rule.add(emailLabel);
		
		ArrayList<PawnedItem> items = itemsManager.getAllItems();
		
		for (int index = 0; index < items.size(); index++) {
			PawnedItem item = items.get(index);
			
			if (item.getItemName().contains(onlyIfContains) || onlyIfContains.isBlank()) {
				JPanel cardContainer = new JPanel();
				cardContainer.setBackground(light_gray);
				JPanel card = new JPanel();
				card.setBackground(light_gray);
				card.setBorder(new LineBorder(Color.GRAY, 1, true));
				card.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cardContainer.add(card);
				
				JLabel itemInfoLabel = new JLabel(item.getItemID() + "   |     " + item.getItemName() + "    |    " + item.getItemEstimateValue());
				card.add(itemInfoLabel);
				
				card.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						@SuppressWarnings("unused")
						ItemMoreInfoCard popup = new ItemMoreInfoCard(item, targetContainer, itemsManager);
					}
				});
				
				targetContainer.add(cardContainer);
			}
		}
	}

}
