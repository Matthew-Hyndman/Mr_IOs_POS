package mr_ios_pos;

//package Mr_IOs_POS_System;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import javax.swing.*;
//
//public class GUI extends JFrame implements ActionListener {
//
//	// var declaration
//	GridBagConstraints gc = new GridBagConstraints();
//
//	private ArrayList<StockItem> arrList = new ArrayList<>();
//	private DefaultListModel<StockItem> defaultListModel = new DefaultListModel<>();
//
//	private JLabel lTitle, lnItemName, lnPrice, lnNoInStock, lnRRP, lnMarkUp, lnCost;
//
//	private JButton bMakeRecite, bStock, bDeleteItem, bAddItem, bSubmitNewItem, bStockSearch, bStockEdit, bStockDetails,
//			bBack;
//
//	private JTextField tfItemName, tfPrice, tfNoInStock, tfRRP, tfMarkUp, tfCost, tfStockSearch;
//
//	private JList<Object> listStockViewArea;
//	private JScrollPane listStockViewAreaScrollPane;
//
//	private String[] markUpOptions = { "%", "�" };
//	private JComboBox<String> cbMarkUpBox;
//
//	// GUI Constructor
//	public GUI() {
//		try {
//
//			getContentPane().setLayout(new GridBagLayout());
//
//			// general
//			bBack = new JButton("<");
//			bBack.setFont(new Font("Arial", Font.BOLD, 25));
//			bBack.addActionListener(this);
//			bBack.setVisible(false);
//
//			// Home
//			lTitle = new JLabel("Mr.IO's POS ");
//			lTitle.setFont(new Font("Arial", Font.BOLD, 30));
//
//			bMakeRecite = new JButton("Make a Receipt");
//			bMakeRecite.setFont(new Font("Arial", Font.BOLD, 25));
//			bMakeRecite.addActionListener(this);
//
//			bStock = new JButton("Stock Items");
//			bStock.setFont(new Font("Arial", Font.BOLD, 25));
//			bStock.addActionListener(this);
//
//			// Stock Items
//			bDeleteItem = new JButton("Delete");
//			bDeleteItem.setFont(new Font("Arial", Font.BOLD, 25));
//			bDeleteItem.addActionListener(this);
//			bDeleteItem.setVisible(false);
//
//			bStockEdit = new JButton("Edit");
//			bStockEdit.setFont(new Font("Arial", Font.BOLD, 25));
//			bStockEdit.addActionListener(this);
//			bStockEdit.setVisible(false);
//
//			bStockDetails = new JButton("Details");
//			bStockDetails.setFont(new Font("Arial", Font.BOLD, 25));
//			bStockDetails.addActionListener(this);
//			bStockDetails.setVisible(false);
//
//			bAddItem = new JButton("Add Item");
//			bAddItem.setFont(new Font("Arial", Font.BOLD, 25));
//			bAddItem.addActionListener(this);
//			bAddItem.setVisible(false);
//
//			tfStockSearch = new JTextField();
//			tfStockSearch.setFont(new Font("Arial", Font.BOLD, 25));
//			tfStockSearch.setVisible(false);
//
//			// populateArrList();// this method is only for testing purposes
//			populateArrListFromFile();
//
//			listStockViewArea = new JList<>(defaultListModel.getListDataListeners());
//			listStockViewArea.setFont(new Font("Arial", Font.BOLD, 15));
//			listStockViewArea.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//			listStockViewArea.setLayoutOrientation(JList.VERTICAL);
//			listStockViewArea.setLayoutOrientation((int) JList.LEFT_ALIGNMENT);
//			listStockViewArea.setVisible(false);
//			listStockViewArea.setAutoscrolls(true);
//
//			listStockViewAreaScrollPane = new JScrollPane(listStockViewArea);
//			listStockViewAreaScrollPane.setVisible(false);
//
//			bStockSearch = new JButton("Search");
//			bStockSearch.setFont(new Font("Arial", Font.BOLD, 25));
//			bStockSearch.addActionListener(this);
//			bStockSearch.setVisible(false);
//
//			// AddStock
//
//			lnItemName = new JLabel("Item Name: ");
//			lnItemName.setFont(new Font("Arial", Font.BOLD, 15));
//			lnItemName.setVisible(false);
//
//			tfItemName = new JTextField();
//			tfItemName.setFont(new Font("Arial", Font.BOLD, 15));
//			tfItemName.setVisible(false);
//
//			lnPrice = new JLabel("Item Price: ");
//			lnPrice.setFont(new Font("Arial", Font.BOLD, 15));
//			lnPrice.setVisible(false);
//
//			tfPrice = new JTextField();
//			tfPrice.setFont(new Font("Arial", Font.BOLD, 15));
//			tfPrice.setVisible(false);
//
//			lnNoInStock = new JLabel("Item Number of Items in stock: ");
//			lnNoInStock.setFont(new Font("Arial", Font.BOLD, 15));
//			lnNoInStock.setVisible(false);
//
//			tfNoInStock = new JTextField();
//			tfNoInStock.setFont(new Font("Arial", Font.BOLD, 15));
//			tfNoInStock.setVisible(false);
//
//			bSubmitNewItem = new JButton("Submit");
//			bSubmitNewItem.setFont(new Font("Arial", Font.BOLD, 25));
//			bSubmitNewItem.addActionListener(this);
//			bSubmitNewItem.setVisible(false);
//
//			lnRRP = new JLabel("RRP:");
//			lnRRP.setFont(new Font("Arial", Font.BOLD, 15));
//			lnRRP.setVisible(false);
//
//			lnMarkUp = new JLabel("Mark Up:");
//			lnMarkUp.setFont(new Font("Arial", Font.BOLD, 15));
//			lnMarkUp.setVisible(false);
//
//			lnCost = new JLabel("Cost:");
//			lnCost.setFont(new Font("Arial", Font.BOLD, 15));
//			lnCost.setVisible(false);
//
//			tfRRP = new JTextField();
//			tfRRP.setFont(new Font("Arial", Font.BOLD, 15));
//			tfRRP.setVisible(false);
//
//			tfMarkUp = new JTextField();
//			tfMarkUp.setFont(new Font("Arial", Font.BOLD, 15));
//			tfMarkUp.setVisible(false);
//
//			tfCost = new JTextField();
//			tfCost.setFont(new Font("Arial", Font.BOLD, 15));
//			tfCost.setVisible(false);
//
//			cbMarkUpBox = new JComboBox<String>(markUpOptions);
//			cbMarkUpBox.setFont(new Font("Arial", Font.BOLD, 15));
//			cbMarkUpBox.setVisible(false);
//
//			// addcomp(Component c, posX, posY, wide, height, weiX, weiY)
//			// Home Page
//			addcomp(lTitle, 0, 0, 5, 1, 1, 1);
//			addcomp(bMakeRecite, 1, 1, 1, 1, 1, 1);
//			addcomp(bStock, 3, 1, 1, 1, 1, 1);
//
//			// Stock view
//			addcomp(bBack, 0, 0, 1, 1, 1, 1);
//			addcomp(tfStockSearch, 1, 0, 3, 1, 1, 1);
//			addcomp(bStockSearch, 4, 0, 1, 1, 1, 1);
//			addcomp(listStockViewAreaScrollPane, 0, 1, 5, 3, 1, 3);
//			addcomp(bDeleteItem, 0, 4, 1, 1, 1, 1);
//			addcomp(bStockEdit, 1, 4, 1, 1, 1, 1);
//			addcomp(bStockDetails, 2, 4, 1, 1, 1, 1);
//			addcomp(bAddItem, 3, 4, 1, 1, 1, 1);
//
//			// AddItem
//			addcomp(lnItemName, 1, 0, 1, 1, 1, 1);
//			addcomp(tfItemName, 2, 0, 3, 1, 1, 1);
//			addcomp(lnNoInStock, 1, 1, 1, 1, 1, 1);
//			addcomp(tfNoInStock, 2, 1, 3, 1, 1, 1);
//			addcomp(lnPrice, 1, 3, 1, 1, 1, 1);
//			addcomp(tfPrice, 2, 3, 3, 1, 1, 1);
//			addcomp(lnRRP, 1, 4, 1, 1, 1, 1);
//			addcomp(tfRRP, 2, 4, 3, 1, 1, 1);
//			addcomp(lnMarkUp, 1, 5, 1, 1, 1, 1);
//			addcomp(tfMarkUp, 2, 5, 3, 1, 1, 1);
//			addcomp(cbMarkUpBox, 5, 5, 1, 1, 1, 1);
//			addcomp(lnCost, 1, 6, 1, 1, 1, 1);
//			addcomp(tfCost, 2, 6, 3, 1, 1, 1);
//			addcomp(bSubmitNewItem, 5, 6, 1, 1, 1, 1);
//
//			My.p("\nGUI Loaded successfully");
//
//			My.p("\nApp successfully started\n");
//
//		} catch (Exception e) {
//			My.p("\nGUI unsuccessfully Load:\nError: " + e.toString());
//			e.printStackTrace();
//			My.c();
//		}
//	}
//
//	//adds the new item to the arrList and defaultListModel
//	private void addItem(StockItem stockItem) {
//		arrList.add(stockItem);
//		defaultListModel.addElement(stockItem);
//	}
//	
//	private void populateArrList() {
//		// StockItem(itemName, noInStock, sellingPrice, cost, markUp, rrp)
//		addItem(new StockItem("Sleeping bag (black)", 20, 20, 15, 25, true, 30));
//		addItem(new StockItem("Sleeping bag (blue)", 23, 20, 15, 25, true, 30));
//		addItem(new StockItem("Sleeping bag (orange)", 47, 20, 15, 25, true, 30));
//		addItem(new StockItem("Sleeping bag (white)", 10, 20, 15, 25, true, 30));
//		My.p("\nArrayList populated via hard code");
//
//	}
//
//	private void populateArrListFromFile() {
//		File file = new File("StoreFile.txt");
//		if (file.exists()) {
//			try {
//
//				Scanner readerScanner = new Scanner(file);
//				int varCounter = 0;
//				String itemName = "", noInStock = "", sellingPrice = "", cost = "", markUp = "", rrp = "";
//				boolean markUpType = false;
//
//				while (readerScanner.hasNextLine()) {
//
//					String data = readerScanner.nextLine();
//
//					switch (varCounter) {
//					case 0:
//						itemName = data;
//						varCounter++;
//						break;
//					case 1:
//						noInStock = data;
//						varCounter++;
//						break;
//					case 2:
//						sellingPrice = data;
//						varCounter++;
//						break;
//					case 3:
//						cost = data;
//						varCounter++;
//						break;
//					case 4:
//						markUp = data;
//						varCounter++;
//						break;
//					case 5:
//						markUpType = Boolean.valueOf(data);
//						break;
//					case 6:
//						rrp = data;
//						varCounter++;
//						break;
//					default:
//						addItem(new StockItem(itemName, Integer.valueOf(noInStock), Double.valueOf(sellingPrice),
//								Double.valueOf(cost), Double.valueOf(markUp), markUpType, Double.valueOf(rrp)));
//						varCounter = 0;
//					}
//
//				}
//				readerScanner.close();
//				My.p("\nArrayList populated via file (" + file.getName() + ")");
//			} catch (FileNotFoundException e) {
//
//				My.p("\nData load unsuccessful:\nError: " + e.toString());
//				e.printStackTrace();
//				My.c();
//			}
//		} else {
//			My.p("\nFile created: " + file.getName());
//		}
//	}
//
//	public void displayAddItem() {
//		lnItemName.setVisible(true);
//		tfItemName.setVisible(true);
//		lnNoInStock.setVisible(true);
//		tfNoInStock.setVisible(true);
//		lnPrice.setVisible(true);
//		tfPrice.setVisible(true);
//		lnRRP.setVisible(true);
//		tfRRP.setVisible(true);
//		lnMarkUp.setVisible(true);
//		tfMarkUp.setVisible(true);
//		cbMarkUpBox.setVisible(true);
//		lnCost.setVisible(true);
//		tfCost.setVisible(true);
//		bSubmitNewItem.setVisible(true);
//	}
//
//	public void hideAddItem() {
//		lnItemName.setVisible(false);
//		tfItemName.setVisible(false);
//		lnNoInStock.setVisible(false);
//		tfNoInStock.setVisible(false);
//		lnPrice.setVisible(false);
//		tfPrice.setVisible(false);
//		lnRRP.setVisible(false);
//		tfRRP.setVisible(false);
//		lnMarkUp.setVisible(false);
//		tfMarkUp.setVisible(false);
//		cbMarkUpBox.setVisible(false);
//		lnCost.setVisible(false);
//		tfCost.setVisible(false);
//		bSubmitNewItem.setVisible(false);
//	}
//
//	public void displayStock() {
//		bBack.setVisible(true);
//		tfStockSearch.setVisible(true);
//		bStockSearch.setVisible(true);
//		listStockViewArea.setVisible(true);
//		listStockViewAreaScrollPane.setVisible(true);
//		bDeleteItem.setVisible(true);
//		bStockEdit.setVisible(true);
//		bStockDetails.setVisible(true);
//		bAddItem.setVisible(true);
//	}
//
//	public void hideStock() {
//		tfStockSearch.setVisible(false);
//		bStockSearch.setVisible(false);
//		listStockViewArea.setVisible(false);
//		listStockViewAreaScrollPane.setVisible(false);
//		bDeleteItem.setVisible(false);
//		bStockEdit.setVisible(false);
//		bStockDetails.setVisible(false);
//		bAddItem.setVisible(false);
//	}
//
//	public void displayHome() {
//		bBack.setVisible(false);
//		lTitle.setVisible(true);
//		bMakeRecite.setVisible(true);
//		bStock.setVisible(true);
//	}
//
//	public void hideHome() {
//		lTitle.setVisible(false);
//		bMakeRecite.setVisible(false);
//		bStock.setVisible(false);
//	}
//
//	// this method sets the components position, height, width and weight
//	public void addcomp(Component c, int posX, int posY, int wide, int height, int weiX, int weiY) {
//
//		gc.fill = GridBagConstraints.BOTH;
//		gc.insets = new Insets(5, 5, 5, 5);
//		gc.gridx = posX;
//		gc.gridy = posY;
//		gc.gridwidth = wide;
//		gc.gridheight = height;
//		gc.weightx = weiX;
//		gc.weighty = weiY;
//		getContentPane().add(c, gc);
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		if (e.getSource() == bStock) {
//			hideHome();
//			displayStock();
//			My.p("\nStock Successfully loaded");
//		} else if (e.getSource() == bBack) {
//			if (listStockViewArea.isVisible()) {
//				hideStock();
//				displayHome();
//				My.p("\nHome Successfully loaded");
//			} else if (bSubmitNewItem.isVisible()) {
//				hideAddItem();
//				displayStock();
//				My.p("\nStock Successfully loaded");
//			}
//		} else if (e.getSource() == bAddItem) {
//			hideStock();
//			displayAddItem();
//			My.p("\nAdd Item Successfully loaded");
//
//		} else if (e.getSource() == bSubmitNewItem) {
//			boolean ok = true;
//			String message = "";
//			if (tfItemName.getText().isEmpty()) {
//				ok = false;
//				message += "- The name of the item must be given.\n";
//			}
//
//			if (tfNoInStock.getText().isEmpty()) {
//				ok = false;
//				message += "- The amount of items in stock must be given.\n";
//			} else {
//				try {
//					int test = Integer.valueOf(tfNoInStock.getText());
//				} catch (NumberFormatException e2) {
//					ok = false;
//					message += "- The amount of items in stock must be a number.\n";
//				}
//			}
//
//			if (tfPrice.getText().isEmpty()) {
//				ok = false;
//				message += "- The selling price of the item must be givin.\n";
//			} else {
//				try {
//					double test = Double.valueOf(tfPrice.getText());
//				} catch (NumberFormatException e2) {
//					ok = false;
//					message += "- The selling price must be a number.\n";
//				}
//			}
//
//			if (tfMarkUp.getText().isEmpty()) {
//				ok = false;
//				message += "- The Mark Up must be given.\n";
//			} else {
//				try {
//					double test = Double.valueOf(tfMarkUp.getText());
//				} catch (NumberFormatException e2) {
//					ok = false;
//					message += "- The Mark Up must be a number.\n";
//				}
//			}
//
//			if (tfCost.getText().isEmpty()) {
//				ok = false;
//				message += "- The cost of the item must be given.\n";
//			} else {
//				try {
//					double test = Double.valueOf(tfCost.getText());
//				} catch (NumberFormatException e2) {
//					ok = false;
//					message += "- The cost of the item must be a number.\n";
//				}
//			}
//
//			if (tfRRP.getText().isEmpty()) {
//				ok = false;
//				message += "- The Recommended Retail Price (RRP) must be given.\n";
//			} else {
//				try {
//					double test = Double.valueOf(tfRRP.getText());
//				} catch (NumberFormatException e2) {
//					ok = false;
//					message += "- The Recommended Retail Price (RRP) must be a number.\n";
//				}
//			}
//
//			if (ok) {
//
//				//add Item to array list
//
//				boolean markUpType = cbMarkUpBox.getSelectedItem().toString() == "%";
//				
//				////////////////////////////////
//				// Still dose not work
//				///////////////////////////////
//				addItem(new StockItem(tfItemName.getText(), Integer.valueOf(tfNoInStock.getText()),
//						Double.valueOf(tfPrice.getText()), Double.valueOf(tfCost.getText()),
//						Double.valueOf(tfMarkUp.getText()), markUpType, Double.valueOf(tfRRP.getText())));
//				
//				tfItemName.setText("");
//				tfNoInStock.setText("");
//				tfPrice.setText("");
//				tfMarkUp.setText("");
//				tfRRP.setText("");
//				tfCost.setText("");
//				
//				My.p("\nItem Added");
//
//			} else {
//				My.p("Add validation triggered\n");
//				JFrame frame = new JFrame();
//				JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
//			}
//		}
//
//	}
//
//	// opens the window
//	public void openWindow() {
//		JFrame window = new JFrame("");
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setPreferredSize(new Dimension(1025, 800));
//		window.setResizable(true);
//		window.pack();
//		window.setVisible(true);
//		window.setContentPane(this);
//
//	}
//
//}
