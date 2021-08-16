package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import config_manager.ConfigParser;
import config_manager.ConfigurationFileManager;
import dbManagers.*;

import javax.swing.ScrollPaneConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class NolaxMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField searchTextField;
	
	private Color light_gray = new Color(253, 253, 253);
	private Color dark_blue = new Color(0, 0, 51);
	private Color enteredZoneColor = new Color(51, 0, 51);
	
	private AgreementsListManager agreementsManager = new AgreementsListManager();
	private ClientsListManager clientsManager = new ClientsListManager();
	private ItemsListManager itemsManager = new ItemsListManager();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NolaxMainFrame frame = new NolaxMainFrame();
					//frame.initializeManagers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Initialize all the data manager
	 */
	public void initializeManagers() {
		ConfigurationFileManager fileManager = new ConfigurationFileManager();
		fileManager.loadContent();
		
		ConfigParser fileParser = new ConfigParser(fileManager.getFileContent());
		
		String host, hostPort, dbName, username, password;
		
		host = fileParser.getAttributeValueForName("Host");
		hostPort = fileParser.getAttributeValueForName("HostPort");
		dbName = fileParser.getAttributeValueForName("DBName");
		username = fileParser.getAttributeValueForName("Username");
		password = fileParser.getAttributeValueForName("Password");
		
		DBCon dbConnector = new DBCon(host, hostPort, dbName, username, password);
		
		dbConnector.getConection(agreementsManager);
		dbConnector.getConection(clientsManager);
		dbConnector.getConection(itemsManager);
		
		agreementsManager.loadAllAgreements();
		clientsManager.loadAllClients();
		itemsManager.loadAllItems();
	}

	/**
	 * Create the frame.
	 */
	public NolaxMainFrame() {
		this.initializeManagers();
		
		setTitle("Nolax");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel sideBarContainer = new JPanel();
		sideBarContainer.setBackground(this.dark_blue);
		contentPane.add(sideBarContainer, BorderLayout.WEST);
		sideBarContainer.setLayout(new BoxLayout(sideBarContainer, BoxLayout.Y_AXIS));
		
		JPanel sideBar = new JPanel();
		sideBar.setBackground(this.dark_blue);
		sideBarContainer.add(sideBar);
		sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
		
		JPanel sideBarSpacer_2 = new JPanel();
		sideBarSpacer_2.setMaximumSize(new Dimension(32767, 60));
		sideBarSpacer_2.setBackground(this.dark_blue);
		sideBar.add(sideBarSpacer_2);
		
		JLabel logoLabel = new JLabel("Nolax");
		logoLabel.setToolTipText("Nolax");
		logoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		logoLabel.setForeground(Color.WHITE);
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sideBar.add(logoLabel);
		
		JPanel sideBarSpacer_1 = new JPanel();
		sideBarSpacer_1.setPreferredSize(new Dimension(10, 80));
		sideBarSpacer_1.setMinimumSize(new Dimension(10, 80));
		sideBarSpacer_1.setMaximumSize(new Dimension(32767, 80));
		sideBarSpacer_1.setBackground(this.dark_blue);
		FlowLayout fl_sideBarSpacer_1 = (FlowLayout) sideBarSpacer_1.getLayout();
		fl_sideBarSpacer_1.setVgap(10);
		sideBar.add(sideBarSpacer_1);
		
		JPanel buttonPanelAgreements = new JPanel();
		buttonPanelAgreements.setMaximumSize(new Dimension(32767, 60));
		
		buttonPanelAgreements.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonPanelAgreements.setBackground(this.dark_blue);
		sideBar.add(buttonPanelAgreements);
		buttonPanelAgreements.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel agreementsButtonLabel = new JLabel("Agreements");
		agreementsButtonLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		agreementsButtonLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonPanelAgreements.add(agreementsButtonLabel);
		agreementsButtonLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		agreementsButtonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		agreementsButtonLabel.setForeground(Color.WHITE);
		
		JPanel emptySpace = new JPanel();
		emptySpace.setMaximumSize(new Dimension(20, 60));
		emptySpace.setBackground(dark_blue);
		sideBar.add(emptySpace);
		
		JPanel buttonPanelClients = new JPanel();
		buttonPanelClients.setMaximumSize(new Dimension(32767, 60));
		buttonPanelClients.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonPanelClients.setMinimumSize(new Dimension(40, 40));
		buttonPanelClients.setBackground(this.dark_blue);
		sideBar.add(buttonPanelClients);
		buttonPanelClients.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel clientsButtonLabel = new JLabel("Clients");
		clientsButtonLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		clientsButtonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clientsButtonLabel.setForeground(Color.WHITE);
		clientsButtonLabel.setAlignmentX(0.5f);
		buttonPanelClients.add(clientsButtonLabel);
		
		JPanel emptySpace_1 = new JPanel();
		emptySpace_1.setMaximumSize(new Dimension(20, 60));
		emptySpace_1.setBackground(dark_blue);
		sideBar.add(emptySpace_1);
		
		JPanel buttonPanelItems = new JPanel();
		buttonPanelItems.setMaximumSize(new Dimension(32767, 60));
		buttonPanelItems.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonPanelItems.setBackground(this.dark_blue);
		sideBar.add(buttonPanelItems);
		buttonPanelItems.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel itemsButtonLabel = new JLabel("Items");
		itemsButtonLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		itemsButtonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemsButtonLabel.setForeground(Color.WHITE);
		itemsButtonLabel.setAlignmentX(0.5f);
		buttonPanelItems.add(itemsButtonLabel);
		
		JPanel emptySpace_2 = new JPanel();
		emptySpace_2.setMaximumSize(new Dimension(20, 60));
		emptySpace_2.setBackground(dark_blue);
		sideBar.add(emptySpace_2);
		
		JPanel spaceReserver = new JPanel();
		spaceReserver.setBackground(this.dark_blue);
		FlowLayout fl_spaceReserver = (FlowLayout) spaceReserver.getLayout();
		fl_spaceReserver.setVgap(200);
		fl_spaceReserver.setHgap(65);
		sideBarContainer.add(spaceReserver);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(this.light_gray);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerPanelTopBar = new JPanel();
		centerPanelTopBar.setBackground(this.light_gray);
		centerPanel.add(centerPanelTopBar, BorderLayout.NORTH);
		centerPanelTopBar.setLayout(new BoxLayout(centerPanelTopBar, BoxLayout.X_AXIS));
		
		JPanel sectionTitleContainer = new JPanel();
		sectionTitleContainer.setBackground(this.light_gray);
		FlowLayout fl_sectionTitleContainer = (FlowLayout) sectionTitleContainer.getLayout();
		fl_sectionTitleContainer.setAlignment(FlowLayout.LEFT);
		centerPanelTopBar.add(sectionTitleContainer);
		
		JLabel listTitle = new JLabel("Agreements");
		sectionTitleContainer.add(listTitle);
		listTitle.setToolTipText("section\r\n");
		listTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		listTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel searchComponentsContainer = new JPanel();
		searchComponentsContainer.setBackground(this.light_gray);
		FlowLayout fl_searchComponentsContainer = (FlowLayout) searchComponentsContainer.getLayout();
		fl_searchComponentsContainer.setAlignOnBaseline(true);
		fl_searchComponentsContainer.setAlignment(FlowLayout.RIGHT);
		centerPanelTopBar.add(searchComponentsContainer);
		
		JLabel searchLabel = new JLabel("search:");
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchComponentsContainer.add(searchLabel);
		searchLabel.setDisplayedMnemonic('s');
		
		ListPanelLoader listFiller = new ListPanelLoader();
		
		searchTextField = new JTextField(20);
		searchTextField.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		searchComponentsContainer.add(searchTextField);
		
		JPanel listContainer = new JPanel();
		listFiller.setTargetContainer(listContainer);
		listContainer.setAutoscrolls(true);
		listContainer.setBackground(this.light_gray);
		centerPanel.add(listContainer, BorderLayout.CENTER);
		GridLayout listContainerLayout = new GridLayout(25, 0, 0, 0);
		listContainer.setLayout(listContainerLayout);
		
		listFiller.populateListPanel(agreementsManager, "");
		
		JScrollPane scrollPane = new JScrollPane(listContainer);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setAutoscrolls(true);
		scrollPane.setViewportBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				listContainer.removeAll();
				listContainerLayout.setRows(listContainerLayout.getRows() + 1);
				
				switch (listTitle.getText()) {
				
					case "Clients": 
						listFiller.populateListPanel(clientsManager, searchTextField.getText());
						break;
				
					case "Agreements": 						
						listFiller.populateListPanel(agreementsManager, searchTextField.getText());
						break;
						
					case "Items": 
						listFiller.populateListPanel(itemsManager, searchTextField.getText());
						break;
					
					default:
						break;
				}
				listContainer.revalidate();
				listContainer.repaint();
			}
		});
		
		buttonPanelClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonPanelClients.setBackground(enteredZoneColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonPanelClients.setBackground(dark_blue);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				listTitle.setText("Clients");
				listContainer.removeAll();
				listContainer.revalidate();
				listContainer.repaint();
				listContainerLayout.setRows(listContainerLayout.getRows() + 1);
				listFiller.populateListPanel(clientsManager, "");
				
			}
		});
		
		buttonPanelAgreements.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonPanelAgreements.setBackground(enteredZoneColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonPanelAgreements.setBackground(dark_blue);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				listTitle.setText("Agreements");
				listContainer.removeAll();
				listContainer.revalidate();
				listContainer.repaint();
				listContainerLayout.setRows(listContainerLayout.getRows() + 1);
				listFiller.populateListPanel(agreementsManager, "");
			}
		});
		
		buttonPanelItems.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonPanelItems.setBackground(enteredZoneColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonPanelItems.setBackground(dark_blue);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				listTitle.setText("Items");
				listContainer.removeAll();
				listContainer.revalidate();
				listContainer.repaint();
				listContainerLayout.setRows(listContainerLayout.getRows() + 1);
				listFiller.populateListPanel(itemsManager, "");
				itemsManager.dumpAllItems();
				
			}
		});
	}
}
