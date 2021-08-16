package ui;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.LineBorder;

import dataclasses.Client;
import dbManagers.ClientsListManager;

import java.awt.FlowLayout;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientMoreInfoCard {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	private ListPanelLoader listReloader = new ListPanelLoader();
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Create the frame.
	 */
	public ClientMoreInfoCard(Client client, JPanel targetContainer, ClientsListManager targetManager) {		
		listReloader.setTargetContainer(targetContainer);
		
		JFrame frame = new JFrame("Client");
		frame.setType(Type.POPUP);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 350);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel moreInfoLabel = new JLabel("more information...");
		moreInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(moreInfoLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("ID:");
		panel_1.add(lblNewLabel);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setBackground(Color.WHITE);
		
		textField = new JTextField();
		textField.setText(client.getClientID());
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setAlignmentX(0.5f);
		panel_1_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1_1.add(panel_2);
		
		textField_1 = new JTextField();
		textField_1.setText(client.getClientName());
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel_2.add(textField_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1_2);
		panel_1_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Lastname:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setAlignmentX(0.5f);
		panel_1_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_1_2.add(panel_3);
		
		textField_2 = new JTextField();
		textField_2.setText(client.getClientLastname());
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel_3.add(textField_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1_3);
		panel_1_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("telephone number:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setAlignmentX(0.5f);
		panel_1_3.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_1_3.add(panel_4);
		
		textField_3 = new JTextField();
		textField_3.setText(client.getClientTelephoneNumber());
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel_4.add(textField_3);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1_4);
		panel_1_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_4 = new JLabel("email:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setAlignmentX(0.5f);
		panel_1_4.add(lblNewLabel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_1_4.add(panel_5);
		
		textField_4 = new JTextField();
		textField_4.setText(client.getClientEmail());
		textField_4.setColumns(20);
		textField_4.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel_5.add(textField_4);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1_5);
		panel_1_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("address:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setAlignmentX(0.5f);
		panel_1_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_1_5.add(panel_6);
		
		textField_5 = new JTextField();
		textField_5.setText(client.getClientAddress());
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel_6.add(textField_5);
		
		JPanel panel_7 = new JPanel();
		frame.getContentPane().add(panel_7);
		
		btnNewButton = new JButton("save");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				client.setClientID(textField.getText());
				client.setClientName(textField_1.getText());
				client.setClientLastname(textField_2.getText());
				client.setClientTelephoneNumber(textField_3.getText());
				client.setClientEmail(textField_4.getText());
				client.setClientAddress(textField_5.getText());
				
				targetContainer.removeAll();
				targetContainer.revalidate();
				listReloader.populateListPanel(targetManager, "");
				targetContainer.repaint();
				
				targetManager.changeItem(textField.getText(), client);
			}
		});
		panel_7.add(btnNewButton);
		
		btnNewButton_1 = new JButton("delete");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				targetManager.deleteClient(client.getClientID());


				targetContainer.removeAll();
				targetContainer.revalidate();
				listReloader.populateListPanel(targetManager, "");
				targetContainer.repaint();
			}
		});
		panel_7.add(btnNewButton_1);
		
		
		frame.setVisible(true);
		
	}
	
	public void disableDeleteButton() {
		btnNewButton_1.setEnabled(false);
	}
	

}
