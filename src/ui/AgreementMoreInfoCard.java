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

import dataclasses.PawnAgreement;

import java.awt.FlowLayout;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class AgreementMoreInfoCard {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public AgreementMoreInfoCard(PawnAgreement agreement) {
		JFrame frmAgreement = new JFrame("Client");
		frmAgreement.setTitle("Agreement");
		//frame.setUndecorated(true);
		frmAgreement.setType(Type.POPUP);
		frmAgreement.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAgreement.setBounds(100, 100, 450, 400);
		frmAgreement.getContentPane().setBackground(Color.WHITE);
		frmAgreement.getContentPane().setLayout(new BoxLayout(frmAgreement.getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel moreInfoLabel = new JLabel("more information...");
		moreInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		frmAgreement.getContentPane().add(moreInfoLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frmAgreement.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("ID:");
		panel_1.add(lblNewLabel);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setBackground(Color.WHITE);
		
		textField = new JTextField();
		textField.setText(agreement.getAgreementID());
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		frmAgreement.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Client ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setAlignmentX(0.5f);
		panel_1_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1_1.add(panel_2);
		
		textField_1 = new JTextField();
		textField_1.setText(agreement.getClientID());
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel_2.add(textField_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		frmAgreement.getContentPane().add(panel_1_2);
		panel_1_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Item ID:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setAlignmentX(0.5f);
		panel_1_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_1_2.add(panel_3);
		
		textField_2 = new JTextField();
		textField_2.setText(agreement.getItemID());
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel_3.add(textField_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(Color.WHITE);
		frmAgreement.getContentPane().add(panel_1_3);
		panel_1_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Starting Date:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setAlignmentX(0.5f);
		panel_1_3.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_1_3.add(panel_4);
		
		textField_3 = new JTextField();
		textField_3.setText(agreement.getAgreementStartingDate());
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel_4.add(textField_3);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBackground(Color.WHITE);
		frmAgreement.getContentPane().add(panel_1_4);
		panel_1_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_4 = new JLabel("Ending Date:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setAlignmentX(0.5f);
		panel_1_4.add(lblNewLabel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_1_4.add(panel_5);
		
		textField_4 = new JTextField();
		textField_4.setText(agreement.getAgreementEndingDate());
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		panel_5.add(textField_4);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBackground(Color.WHITE);
		frmAgreement.getContentPane().add(panel_1_5);
		panel_1_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("conditions:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setAlignmentX(0.5f);
		panel_1_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_1_5.add(panel_6);
		
		JTextArea textArea_2 = new JTextArea(agreement.getAgreementConditions());
		panel_6.add(textArea_2);
		
		JPanel panel_1_5_1 = new JPanel();
		panel_1_5_1.setBackground(Color.WHITE);
		frmAgreement.getContentPane().add(panel_1_5_1);
		panel_1_5_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5_1 = new JLabel("description:");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setAlignmentX(0.5f);
		panel_1_5_1.add(lblNewLabel_5_1);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(Color.WHITE);
		panel_1_5_1.add(panel_6_1);
		
		JTextArea textArea = new JTextArea(agreement.getAgreementDescription());
		panel_6_1.add(textArea);
		
		JPanel panel_1_5_2 = new JPanel();
		panel_1_5_2.setBackground(Color.WHITE);
		frmAgreement.getContentPane().add(panel_1_5_2);
		panel_1_5_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5_2 = new JLabel("comments:");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setAlignmentX(0.5f);
		panel_1_5_2.add(lblNewLabel_5_2);
		
		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBackground(Color.WHITE);
		panel_1_5_2.add(panel_6_2);
		
		JTextArea textArea_1 = new JTextArea(agreement.Comments);
		panel_6_2.add(textArea_1);
		
		JPanel panel_7 = new JPanel();
		frmAgreement.getContentPane().add(panel_7);
		
		JButton btnNewButton = new JButton("save");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agreement.setAgreementID(textField.getText());
				agreement.setClientID(textField_1.getText());
				agreement.setItemID(textField_2.getText());
				agreement.setAgreementStartingDate(textField_3.getText());
				agreement.setAgreementEndingDate(textField_4.getText());
				agreement.setAgreementDescription(textArea.getText());
				agreement.setAgreementConditions(textArea_2.getText());
				agreement.Comments = textArea_1.getText();
			}
		});
		panel_7.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("delete");
		panel_7.add(btnNewButton_1);
		
		
		frmAgreement.setVisible(true);
		
	}

}
