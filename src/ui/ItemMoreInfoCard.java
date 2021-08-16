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

import dataclasses.PawnedItem;
import dbManagers.ItemsListManager;

import java.awt.FlowLayout;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class ItemMoreInfoCard {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea;
	
	private ListPanelLoader listReloader = new ListPanelLoader();
	
	private JButton btnNewButton_1;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public ItemMoreInfoCard(PawnedItem item, JPanel targetContainer, ItemsListManager targetManager) {
		listReloader.setTargetContainer(targetContainer);
		
		JFrame frame = new JFrame("Item");
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
		textField.setText(item.getItemID());
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
		textField_1.setText(item.getItemName());
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel_2.add(textField_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1_2);
		panel_1_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Value:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setAlignmentX(0.5f);
		panel_1_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_1_2.add(panel_3);
		
		textField_2 = new JTextField();
		textField_2.setText(String.valueOf(item.getItemEstimateValue()));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel_3.add(textField_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1_3);
		panel_1_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Description:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setAlignmentX(0.5f);
		panel_1_3.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_1_3.add(panel_4);
		
		textArea = new JTextArea(item.getItemDescription());
		panel_4.add(textArea);
		
		JPanel panel_7 = new JPanel();
		frame.getContentPane().add(panel_7);
		
		btnNewButton = new JButton("save");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				item.setItemID(textField.getText());
				item.setItemName(textField_1.getText());
				item.setItemEstimateValue(Double.valueOf(textField_2.getText()));
				item.setItemDescription(textArea.getText());
					
				targetManager.changeItem(textField.getText(), item);
				
				targetContainer.removeAll();
				targetContainer.revalidate();
				listReloader.populateListPanel(targetManager, "");
				targetContainer.repaint();
			}
		});
		panel_7.add(btnNewButton);
		
		btnNewButton_1 = new JButton("delete");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				targetManager.deleteItem(item.getItemID());
				
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
	
	public void disableIDTextField() {
		this.textField.setEnabled(false);
	}

}
