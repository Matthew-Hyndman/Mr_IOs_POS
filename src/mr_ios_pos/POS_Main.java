package mr_ios_pos;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthew
 */
public class POS_Main extends javax.swing.JFrame {
    private ArrayList<StockItem> arrayList;
    

    private static final String userN = "root";
    private static final String pWord = "DeadFox64!";
    private static final String dbConn = "jdbc:mysql://localhost:3306/mr_ios_pos"; 
    
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    DefaultTableModel dtm;
    
    
    public POS_Main() {        
        initComponents();        
        updateDB();
        initVars();
        
    }
    
    public  void updateDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dbConn,userN,pWord);
            pst = sqlConn.prepareStatement("SELECT * FROM mr_ios_pos.items;");
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            q = stData.getColumnCount();

            dtm = (DefaultTableModel)tableStockView.getModel();
            tableStockView.setModel(dtm);
            dtm.addColumn("Item ID");
            dtm.addColumn("Item Name");
            dtm.addColumn("No In Stock");
            dtm.addColumn("Selling Price");
            dtm.addColumn("Cost");
            dtm.addColumn("Mark Up");
            dtm.addColumn("Is Mark Up Percent");
            dtm.addColumn("RRP");

            dtm.setRowCount(0);
            
            while(rs.next()){
                Vector colDat = new Vector();
                
                for (i = 1; i <= q; i++) {
                   colDat.add(rs.getString("ItemID"));
                   colDat.add(rs.getString("Item_Name"));
                   colDat.add(rs.getString("No_In_Stock"));
                   colDat.add(rs.getString("Selling_Price"));
                   colDat.add(rs.getString("Cost"));
                   colDat.add(rs.getString("markUp"));
                   colDat.add(rs.getString("Is_markUp_Percent"));
                   colDat.add(rs.getString("RRP"));
                }
                dtm.addRow(colDat);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane = new javax.swing.JLayeredPane();
        stock = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStockView = new javax.swing.JTable();
        tfStockSearch = new javax.swing.JTextField();
        bStockSearch = new javax.swing.JButton();
        bStockAdd = new javax.swing.JButton();
        bStockEdit = new javax.swing.JButton();
        bStockDelete = new javax.swing.JButton();
        bStockDetails = new javax.swing.JButton();
        bStockReceipt = new javax.swing.JButton();
        addItem = new javax.swing.JPanel();
        bAddItemSubmit = new javax.swing.JButton();
        lAddItemItemName = new javax.swing.JLabel();
        tfAddItemItemName = new javax.swing.JTextField();
        lAddItemNoInStock = new javax.swing.JLabel();
        tfAddItemNoInStock = new javax.swing.JTextField();
        layeredPaneAddItemDetails = new javax.swing.JLayeredPane();
        CostAndMarkUp = new javax.swing.JPanel();
        lAddItemCost = new javax.swing.JLabel();
        tfAddItemCostA = new javax.swing.JTextField();
        lAddItemMarkUp = new javax.swing.JLabel();
        tfAddItemMarkUpA = new javax.swing.JTextField();
        comAddItemMarkUpTypeA = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lAddItemSellingPrice = new javax.swing.JLabel();
        CostAndSellingPrice = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfAddItemCostB = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfAddItemSellingPriceB = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lAddItemMarkUpB = new javax.swing.JLabel();
        comAddItemSelecter = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tfAddItemRRP = new javax.swing.JTextField();
        bAddItemBack = new javax.swing.JButton();
        UpdateItem = new javax.swing.JPanel();
        bUpdateItemSubmit = new javax.swing.JButton();
        lUpdateItemItemName = new javax.swing.JLabel();
        tfUpdateItemItemName = new javax.swing.JTextField();
        lUpdateItemNoInStock = new javax.swing.JLabel();
        tfUpdateItemNoInStock = new javax.swing.JTextField();
        layeredPaneUpdateItemDetails = new javax.swing.JLayeredPane();
        CostAndMarkUp1 = new javax.swing.JPanel();
        lUpdateItemCost = new javax.swing.JLabel();
        tfUpdateItemCostA = new javax.swing.JTextField();
        lUpdateItemMarkUp = new javax.swing.JLabel();
        tfUpdateItemMarkUpA = new javax.swing.JTextField();
        comUpdateItemMarkUpTypeA = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lUpdateItemSellingPrice = new javax.swing.JLabel();
        CostAndSellingPrice1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tfUpdateItemCostB = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfUpdateItemSellingPriceB = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lUpdateItemMarkUpB = new javax.swing.JLabel();
        comUpdateItemSelecter = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        tfUpdateItemRRP = new javax.swing.JTextField();
        bUpdateItemBack = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemFileDelete = new javax.swing.JMenuItem();
        jMenuItemClearFile = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemSettings = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mr. IO's POS");

        jLayeredPane.setToolTipText("");
        jLayeredPane.setLayout(new java.awt.CardLayout());

        stock.setBorder(new javax.swing.border.MatteBorder(null));

        tableStockView.setAutoCreateRowSorter(true);
        tableStockView.setBackground(new java.awt.Color(102, 153, 255));
        tableStockView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableStockView.setColumnSelectionAllowed(false);
        tableStockView.setName(""); // NOI18N
        tableStockView.setShowGrid(true);
        tableStockView.setShowVerticalLines(false);
        tableStockView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStockViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableStockView);

        tfStockSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfStockSearch.setName(""); // NOI18N

        bStockSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bStockSearch.setText("Search");

        bStockAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bStockAdd.setText("Add");
        bStockAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStockAddActionPerformed(evt);
            }
        });

        bStockEdit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bStockEdit.setText("Edit");
        bStockEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStockEditActionPerformed(evt);
            }
        });

        bStockDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bStockDelete.setText("Delete");

        bStockDetails.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bStockDetails.setText("Details");

        bStockReceipt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bStockReceipt.setText("Make Receipt");

        javax.swing.GroupLayout stockLayout = new javax.swing.GroupLayout(stock);
        stock.setLayout(stockLayout);
        stockLayout.setHorizontalGroup(
            stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(stockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stockLayout.createSequentialGroup()
                        .addComponent(bStockAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bStockEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(bStockDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bStockDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(stockLayout.createSequentialGroup()
                        .addComponent(tfStockSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bStockSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addComponent(bStockReceipt)))
                .addContainerGap())
        );
        stockLayout.setVerticalGroup(
            stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfStockSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bStockSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bStockReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bStockEdit)
                    .addComponent(bStockDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bStockDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bStockAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLayeredPane.add(stock, "card2");

        bAddItemSubmit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bAddItemSubmit.setText("Submit");
        bAddItemSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddItemSubmitActionPerformed(evt);
            }
        });

        lAddItemItemName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lAddItemItemName.setText("Item Name:");

        tfAddItemItemName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lAddItemNoInStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lAddItemNoInStock.setText("No In Stock:");

        tfAddItemNoInStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        layeredPaneAddItemDetails.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        layeredPaneAddItemDetails.setLayout(new java.awt.CardLayout());

        lAddItemCost.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lAddItemCost.setText("Cost £:");

        tfAddItemCostA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfAddItemCostA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfAddItemCostAKeyReleased(evt);
            }
        });

        lAddItemMarkUp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lAddItemMarkUp.setText("Mark Up:");

        tfAddItemMarkUpA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfAddItemMarkUpA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfAddItemMarkUpAKeyReleased(evt);
            }
        });

        comAddItemMarkUpTypeA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comAddItemMarkUpTypeA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "£" }));
        comAddItemMarkUpTypeA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comAddItemMarkUpTypeAItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Selling Price £:");

        lAddItemSellingPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lAddItemSellingPrice.setText("- - -");

        javax.swing.GroupLayout CostAndMarkUpLayout = new javax.swing.GroupLayout(CostAndMarkUp);
        CostAndMarkUp.setLayout(CostAndMarkUpLayout);
        CostAndMarkUpLayout.setHorizontalGroup(
            CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndMarkUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CostAndMarkUpLayout.createSequentialGroup()
                        .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lAddItemCost)
                            .addComponent(lAddItemMarkUp))
                        .addGap(18, 18, 18)
                        .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CostAndMarkUpLayout.createSequentialGroup()
                                .addComponent(tfAddItemMarkUpA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comAddItemMarkUpTypeA, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfAddItemCostA, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CostAndMarkUpLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lAddItemSellingPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        CostAndMarkUpLayout.setVerticalGroup(
            CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndMarkUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lAddItemCost)
                    .addComponent(tfAddItemCostA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lAddItemMarkUp)
                    .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfAddItemMarkUpA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comAddItemMarkUpTypeA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lAddItemSellingPrice))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        layeredPaneAddItemDetails.add(CostAndMarkUp, "card2");

        CostAndSellingPrice.setPreferredSize(new java.awt.Dimension(354, 126));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Cost £:");

        tfAddItemCostB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfAddItemCostB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfAddItemCostBKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Selling Price £:");

        tfAddItemSellingPriceB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfAddItemSellingPriceB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfAddItemSellingPriceBKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Mark Up £:");

        lAddItemMarkUpB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lAddItemMarkUpB.setText("- - -");

        javax.swing.GroupLayout CostAndSellingPriceLayout = new javax.swing.GroupLayout(CostAndSellingPrice);
        CostAndSellingPrice.setLayout(CostAndSellingPriceLayout);
        CostAndSellingPriceLayout.setHorizontalGroup(
            CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndSellingPriceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CostAndSellingPriceLayout.createSequentialGroup()
                        .addGroup(CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CostAndSellingPriceLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18))
                            .addGroup(CostAndSellingPriceLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(44, 44, 44)))
                        .addGroup(CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lAddItemMarkUpB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfAddItemSellingPriceB)))
                    .addGroup(CostAndSellingPriceLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(74, 74, 74)
                        .addComponent(tfAddItemCostB, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        CostAndSellingPriceLayout.setVerticalGroup(
            CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndSellingPriceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfAddItemCostB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfAddItemSellingPriceB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lAddItemMarkUpB))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        layeredPaneAddItemDetails.add(CostAndSellingPrice, "card2");

        comAddItemSelecter.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comAddItemSelecter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cost and Mark Up", "Cost and Selling Price" }));
        comAddItemSelecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comAddItemSelecterActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Recommended Retail Price (RRP) £:");

        tfAddItemRRP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        bAddItemBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bAddItemBack.setText("<");
        bAddItemBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddItemBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addItemLayout = new javax.swing.GroupLayout(addItem);
        addItem.setLayout(addItemLayout);
        addItemLayout.setHorizontalGroup(
            addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bAddItemBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addItemLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAddItemRRP))
                    .addComponent(layeredPaneAddItemDetails)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addItemLayout.createSequentialGroup()
                        .addGroup(addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lAddItemItemName)
                            .addComponent(lAddItemNoInStock))
                        .addGroup(addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addItemLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comAddItemSelecter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfAddItemNoInStock)))
                            .addGroup(addItemLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfAddItemItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(bAddItemSubmit)
                .addContainerGap())
        );
        addItemLayout.setVerticalGroup(
            addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addItemLayout.createSequentialGroup()
                .addGroup(addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addItemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lAddItemItemName)
                            .addComponent(tfAddItemItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bAddItemBack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lAddItemNoInStock)
                            .addComponent(tfAddItemNoInStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(comAddItemSelecter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(layeredPaneAddItemDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfAddItemRRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addItemLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(bAddItemSubmit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane.add(addItem, "card3");

        bUpdateItemSubmit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bUpdateItemSubmit.setText("Submit");
        bUpdateItemSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateItemSubmitActionPerformed(evt);
            }
        });

        lUpdateItemItemName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lUpdateItemItemName.setText("Item Name:");

        tfUpdateItemItemName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lUpdateItemNoInStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lUpdateItemNoInStock.setText("No In Stock:");

        tfUpdateItemNoInStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        layeredPaneUpdateItemDetails.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        layeredPaneUpdateItemDetails.setLayout(new java.awt.CardLayout());

        lUpdateItemCost.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lUpdateItemCost.setText("Cost £:");

        tfUpdateItemCostA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfUpdateItemCostA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfUpdateItemCostAKeyReleased(evt);
            }
        });

        lUpdateItemMarkUp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lUpdateItemMarkUp.setText("Mark Up:");

        tfUpdateItemMarkUpA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfUpdateItemMarkUpA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfUpdateItemMarkUpAKeyReleased(evt);
            }
        });

        comUpdateItemMarkUpTypeA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comUpdateItemMarkUpTypeA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "£" }));
        comUpdateItemMarkUpTypeA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comUpdateItemMarkUpTypeAItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Selling Price £:");

        lUpdateItemSellingPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lUpdateItemSellingPrice.setText("- - -");

        javax.swing.GroupLayout CostAndMarkUp1Layout = new javax.swing.GroupLayout(CostAndMarkUp1);
        CostAndMarkUp1.setLayout(CostAndMarkUp1Layout);
        CostAndMarkUp1Layout.setHorizontalGroup(
            CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndMarkUp1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CostAndMarkUp1Layout.createSequentialGroup()
                        .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lUpdateItemCost)
                            .addComponent(lUpdateItemMarkUp))
                        .addGap(18, 18, 18)
                        .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CostAndMarkUp1Layout.createSequentialGroup()
                                .addComponent(tfUpdateItemMarkUpA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comUpdateItemMarkUpTypeA, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfUpdateItemCostA, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CostAndMarkUp1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lUpdateItemSellingPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        CostAndMarkUp1Layout.setVerticalGroup(
            CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndMarkUp1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUpdateItemCost)
                    .addComponent(tfUpdateItemCostA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lUpdateItemMarkUp)
                    .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfUpdateItemMarkUpA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comUpdateItemMarkUpTypeA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lUpdateItemSellingPrice))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        layeredPaneUpdateItemDetails.add(CostAndMarkUp1, "card2");

        CostAndSellingPrice1.setPreferredSize(new java.awt.Dimension(354, 126));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Cost £:");

        tfUpdateItemCostB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfUpdateItemCostB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfUpdateItemCostBKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Selling Price £:");

        tfUpdateItemSellingPriceB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfUpdateItemSellingPriceB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfUpdateItemSellingPriceBKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Mark Up £:");

        lUpdateItemMarkUpB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lUpdateItemMarkUpB.setText("- - -");

        javax.swing.GroupLayout CostAndSellingPrice1Layout = new javax.swing.GroupLayout(CostAndSellingPrice1);
        CostAndSellingPrice1.setLayout(CostAndSellingPrice1Layout);
        CostAndSellingPrice1Layout.setHorizontalGroup(
            CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndSellingPrice1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CostAndSellingPrice1Layout.createSequentialGroup()
                        .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CostAndSellingPrice1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18))
                            .addGroup(CostAndSellingPrice1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(44, 44, 44)))
                        .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lUpdateItemMarkUpB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfUpdateItemSellingPriceB)))
                    .addGroup(CostAndSellingPrice1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(74, 74, 74)
                        .addComponent(tfUpdateItemCostB, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        CostAndSellingPrice1Layout.setVerticalGroup(
            CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndSellingPrice1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfUpdateItemCostB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfUpdateItemSellingPriceB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lUpdateItemMarkUpB))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        layeredPaneUpdateItemDetails.add(CostAndSellingPrice1, "card2");

        comUpdateItemSelecter.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comUpdateItemSelecter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cost and Mark Up", "Cost and Selling Price" }));
        comUpdateItemSelecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comUpdateItemSelecterActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Recommended Retail Price (RRP) £:");

        tfUpdateItemRRP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        bUpdateItemBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bUpdateItemBack.setText("<");
        bUpdateItemBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateItemBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UpdateItemLayout = new javax.swing.GroupLayout(UpdateItem);
        UpdateItem.setLayout(UpdateItemLayout);
        UpdateItemLayout.setHorizontalGroup(
            UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bUpdateItemBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UpdateItemLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfUpdateItemRRP))
                    .addComponent(layeredPaneUpdateItemDetails)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UpdateItemLayout.createSequentialGroup()
                        .addGroup(UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lUpdateItemItemName)
                            .addComponent(lUpdateItemNoInStock))
                        .addGroup(UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpdateItemLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comUpdateItemSelecter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfUpdateItemNoInStock)))
                            .addGroup(UpdateItemLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfUpdateItemItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(bUpdateItemSubmit)
                .addContainerGap())
        );
        UpdateItemLayout.setVerticalGroup(
            UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateItemLayout.createSequentialGroup()
                .addGroup(UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UpdateItemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lUpdateItemItemName)
                            .addComponent(tfUpdateItemItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bUpdateItemBack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lUpdateItemNoInStock)
                            .addComponent(tfUpdateItemNoInStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(comUpdateItemSelecter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(layeredPaneUpdateItemDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfUpdateItemRRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UpdateItemLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(bUpdateItemSubmit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane.add(UpdateItem, "card3");

        jMenu1.setText("File");

        jMenuItemFileDelete.setText("Delete File");
        jMenu1.add(jMenuItemFileDelete);

        jMenuItemClearFile.setText("Clear File");
        jMenu1.add(jMenuItemClearFile);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItemSettings.setText("Settings");
        jMenu2.add(jMenuItemSettings);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initVars(){
        arrayList = new ArrayList<StockItem>();
       
        
    }
    
    private void bStockAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStockAddActionPerformed
        jLayeredPane.removeAll();
        jLayeredPane.add(addItem);
        jLayeredPane.repaint();
        jLayeredPane.revalidate();
    }//GEN-LAST:event_bStockAddActionPerformed

    private void comAddItemSelecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comAddItemSelecterActionPerformed
        if (comAddItemSelecter.getSelectedIndex() == 0) {
            layeredPaneAddItemDetails.removeAll();
            layeredPaneAddItemDetails.add(CostAndMarkUp);
            layeredPaneAddItemDetails.repaint();
            layeredPaneAddItemDetails.revalidate();
        } else {
            layeredPaneAddItemDetails.removeAll();
            layeredPaneAddItemDetails.add(CostAndSellingPrice);
            layeredPaneAddItemDetails.repaint();
            layeredPaneAddItemDetails.revalidate();
        }
    }//GEN-LAST:event_comAddItemSelecterActionPerformed

    private void bAddItemSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddItemSubmitActionPerformed
        // TODO add your handling code here:

        boolean ok = true;
        int addType = comAddItemSelecter.getSelectedIndex();
        String message = "";
        if (tfAddItemItemName.getText().isEmpty()) {
            ok = false;
            message += "- The name of the item must be given.\n";
        }

        if (tfAddItemNoInStock.getText().isEmpty()) {
            ok = false;
            message += "- The amount of items in stock must be given.\n";
        } else {
            try {
                int test = Integer.valueOf(tfAddItemNoInStock.getText());
            } catch (NumberFormatException e2) {
                ok = false;
                message += "- The amount of items in stock must be a number.\n";
            }
        }

        switch (addType) {
            case 0:
                if (tfAddItemCostA.getText().isEmpty()) {
                    ok = false;
                    message += "- The cost of the item must be given.\n";
                } else {
                    try {
                        double test = Double.valueOf(tfAddItemCostA.getText());
                    } catch (NumberFormatException e2) {
                        ok = false;
                        message += "- The cost of the item must be a number.\n";
                    }
                }

                if (tfAddItemMarkUpA.getText().isEmpty()) {
                    ok = false;
                    message += "- The Mark Up must be given.\n";
                } else {
                    try {
                        double test = Double.valueOf(tfAddItemMarkUpA.getText());
                    } catch (NumberFormatException e2) {
                        ok = false;
                        message += "- The Mark Up must be a number.\n";
                    }

                }
                break;
            case 1:
                if (tfAddItemCostB.getText().isEmpty()) {
                    ok = false;
                    message += "- The cost of the item must be given.\n";
                } else {
                    try {
                        double test = Double.valueOf(tfAddItemCostB.getText());
                    } catch (NumberFormatException e2) {
                        ok = false;
                        message += "- The cost of the item must be a number.\n";
                    }
                }

                if (tfAddItemSellingPriceB.getText().isEmpty()) {
                    ok = false;
                    message += "- The selling price of the item must be givin.\n";
                } else {
                    try {
                        double test = Double.valueOf(tfAddItemCostB.getText());
                    } catch (NumberFormatException e2) {
                        ok = false;
                        message += "- The selling price must be a number.\n";
                    }
                }
                break;
        }

        if (tfAddItemRRP.getText().isEmpty()) {
            ok = false;
            message += "- The Recommended Retail Price (RRP) must be given.\n";
        } else {
            try {
                double test = Double.valueOf(tfAddItemRRP.getText());
            } catch (NumberFormatException e2) {
                ok = false;
                message += "- The Recommended Retail Price (RRP) must be a number.\n";
            }
        }

        if (ok) {

            try {
                int itemID = 1000 + 2;//tableStockView.getRowCount();

                if (comAddItemSelecter.getSelectedIndex() == 0) {

                    boolean is_percent = (comAddItemMarkUpTypeA.getSelectedItem().toString() == "%");

                    arrayList.add(new StockItem(itemID, tfAddItemItemName.getText(), Integer.valueOf(tfAddItemNoInStock.getText()),
                            Double.valueOf(lAddItemSellingPrice.getText()), Double.valueOf(tfAddItemCostA.getText()),
                            Double.valueOf(tfAddItemMarkUpA.getText()), is_percent,
                            Double.valueOf(tfAddItemRRP.getText())));

                    dtm.addRow(new Object[]{
                        itemID,
                        tfAddItemItemName.getText(),
                        Integer.valueOf(tfAddItemNoInStock.getText()),
                        Double.valueOf(lAddItemSellingPrice.getText()),
                        Double.valueOf(tfAddItemCostA.getText()),
                        Double.valueOf(tfAddItemMarkUpA.getText()),
                        is_percent,
                        Double.valueOf(tfAddItemRRP.getText())
                    });

                    Class.forName("com.mysql.jdbc.Driver");
                    sqlConn = DriverManager.getConnection(dbConn, userN, pWord);
                    pst = sqlConn.prepareStatement("insert into mr_ios_pos.items (ItemID, Item_Name, No_In_Stock, Selling_Price, Cost, markUp, Is_markUp_Percent, RRP) value(?,?,?,?,?,?,?,?)");
                    int isPersent = 0;
                    if (is_percent) {
                        isPersent = 1;
                    }
                    pst.setString(1, String.valueOf(itemID));
                    pst.setString(2, tfAddItemItemName.getText());
                    pst.setString(3, tfAddItemNoInStock.getText());
                    pst.setString(4, lAddItemSellingPrice.getText());
                    pst.setString(5, tfAddItemCostA.getText());
                    pst.setString(6, tfAddItemMarkUpA.getText());
                    pst.setString(7, String.valueOf(isPersent));
                    pst.setString(8, tfAddItemRRP.getText());

                    pst.executeUpdate();
                    updateDB();

                } else {
                    arrayList.add(new StockItem(itemID, tfAddItemItemName.getText(), Integer.valueOf(tfAddItemNoInStock.getText()),
                            Double.valueOf(tfAddItemSellingPriceB.getText()), Double.valueOf(tfAddItemCostB.getText()),
                            Double.valueOf(lAddItemMarkUpB.getText()), false, Double.valueOf(tfAddItemRRP.getText())));

                    dtm.addRow(new Object[]{
                        itemID,
                        tfAddItemItemName.getText(),
                        Integer.valueOf(tfAddItemNoInStock.getText()),
                        Double.valueOf(tfAddItemSellingPriceB.getText()),
                        Double.valueOf(tfAddItemCostB.getText()),
                        Double.valueOf(lAddItemMarkUpB.getText()),
                        false,
                        Double.valueOf(tfAddItemRRP.getText())
                    });

                    Class.forName("com.mysql.jdbc.Driver");
                    sqlConn = DriverManager.getConnection(dbConn, userN, pWord);
                    pst = sqlConn.prepareStatement("insert into mr_ios_pos.items (ItemID, Item_Name, No_In_Stock, Selling_Price, Cost, markUp, Is_markUp_Percent, RRP) value(?,?,?,?,?,?,?,?)");
                    pst.setString(1, String.valueOf(itemID));
                    pst.setString(2, tfAddItemItemName.getText());
                    pst.setString(3, tfAddItemNoInStock.getText());
                    pst.setString(4, lAddItemSellingPrice.getText());
                    pst.setString(5, tfAddItemCostA.getText());
                    pst.setString(6, tfAddItemMarkUpA.getText());
                    pst.setString(7, "0");
                    pst.setString(8, tfAddItemRRP.getText());

                    pst.executeUpdate();
                    updateDB();

                }

                tfAddItemSellingPriceB.setText("- - -");
                tfAddItemCostB.setText("");
                lAddItemMarkUpB.setText("");
                lAddItemSellingPrice.setText("- - -");
                tfAddItemCostA.setText("");
                tfAddItemMarkUpA.setText("");
                comAddItemMarkUpTypeA.setSelectedIndex(0);
                tfAddItemRRP.setText("");
                tfAddItemItemName.setText("");
                tfAddItemNoInStock.setText("");
                tfAddItemRRP.setText("");

                My.p("\nItem Added");
            } catch (ClassNotFoundException e1) {
                JOptionPane.showMessageDialog(null, e1);
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(null, e2);
            }

        }
        else {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_bAddItemSubmitActionPerformed

    private void tfAddItemMarkUpAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAddItemMarkUpAKeyReleased
        // TODO add your handling code here:
        validateItemSetUp1(this.tfAddItemMarkUpA);
    }//GEN-LAST:event_tfAddItemMarkUpAKeyReleased

    private void tfAddItemCostAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAddItemCostAKeyReleased
        // TODO add your handling code here:
        validateItemSetUp1(this.tfAddItemCostA);
    }//GEN-LAST:event_tfAddItemCostAKeyReleased

    private void comAddItemMarkUpTypeAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comAddItemMarkUpTypeAItemStateChanged
        // TODO add your handling code here:
        if (!tfAddItemCostA.getText().isEmpty() && !tfAddItemMarkUpA.getText().isEmpty()) {

            if (comAddItemMarkUpTypeA.getSelectedIndex() == 1) {
                //if "�"
                double cost = Double.valueOf(tfAddItemCostA.getText());
                double markUp = Double.valueOf(tfAddItemMarkUpA.getText());
                double price = cost + markUp;
                lAddItemSellingPrice.setText(String.valueOf(price));
            } else {
                //if "%"
                double cost = Double.valueOf(tfAddItemCostA.getText());
                double markUp = Double.valueOf(tfAddItemMarkUpA.getText());
                double price = cost + (cost * (markUp / 100));
                lAddItemSellingPrice.setText(String.valueOf(price));
            }
        } else
            lAddItemSellingPrice.setText("- - -");
    }//GEN-LAST:event_comAddItemMarkUpTypeAItemStateChanged

    private void tfAddItemCostBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAddItemCostBKeyReleased
        // TODO add your handling code here:
        validateItemSetUp2(this.tfAddItemCostB);
    }//GEN-LAST:event_tfAddItemCostBKeyReleased

    private void tfAddItemSellingPriceBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAddItemSellingPriceBKeyReleased
        // TODO add your handling code here:
        validateItemSetUp2(this.tfAddItemSellingPriceB);
    }//GEN-LAST:event_tfAddItemSellingPriceBKeyReleased

    private void bAddItemBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddItemBackActionPerformed
        // TODO add your handling code here:
        jLayeredPane.removeAll();
        jLayeredPane.add(stock);
        jLayeredPane.repaint();
        jLayeredPane.revalidate();

        tfAddItemSellingPriceB.setText("- - -");
        tfAddItemCostB.setText("");
        lAddItemMarkUpB.setText("");
        lAddItemSellingPrice.setText("- - -");
        tfAddItemCostA.setText("");
        tfAddItemMarkUpA.setText("");
        comAddItemMarkUpTypeA.setSelectedIndex(0);
        tfAddItemRRP.setText("");
        tfAddItemItemName.setText("");
        tfAddItemNoInStock.setText("");
        tfAddItemRRP.setText("");
    }//GEN-LAST:event_bAddItemBackActionPerformed

    private void bUpdateItemSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateItemSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bUpdateItemSubmitActionPerformed

    private void tfUpdateItemCostAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUpdateItemCostAKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUpdateItemCostAKeyReleased

    private void tfUpdateItemMarkUpAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUpdateItemMarkUpAKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUpdateItemMarkUpAKeyReleased

    private void comUpdateItemMarkUpTypeAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comUpdateItemMarkUpTypeAItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comUpdateItemMarkUpTypeAItemStateChanged

    private void tfUpdateItemCostBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUpdateItemCostBKeyReleased
        // TODO add your handling code here:
        ValUpdateitemSetUp2(this.tfUpdateItemCostB);
    }//GEN-LAST:event_tfUpdateItemCostBKeyReleased

    private void tfUpdateItemSellingPriceBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUpdateItemSellingPriceBKeyReleased
        // TODO add your handling code here:
        ValUpdateitemSetUp2(this.tfUpdateItemSellingPriceB);
    }//GEN-LAST:event_tfUpdateItemSellingPriceBKeyReleased

    private void bUpdateItemBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateItemBackActionPerformed
        jLayeredPane.removeAll();
        jLayeredPane.add(stock);
        jLayeredPane.repaint();
        jLayeredPane.revalidate();

        tfUpdateItemSellingPriceB.setText("- - -");
        tfUpdateItemCostB.setText("");
        lUpdateItemMarkUpB.setText("");
        lUpdateItemSellingPrice.setText("- - -");
        tfUpdateItemCostA.setText("");
        tfUpdateItemMarkUpA.setText("");
        comUpdateItemMarkUpTypeA.setSelectedIndex(0);
        tfUpdateItemRRP.setText("");
        tfUpdateItemItemName.setText("");
        tfUpdateItemNoInStock.setText("");
        tfUpdateItemRRP.setText("");
    }//GEN-LAST:event_bUpdateItemBackActionPerformed

    private void comUpdateItemSelecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comUpdateItemSelecterActionPerformed
        if (comUpdateItemSelecter.getSelectedIndex() == 0) {
            layeredPaneUpdateItemDetails.removeAll();
            layeredPaneUpdateItemDetails.add(CostAndMarkUp1);
            layeredPaneUpdateItemDetails.repaint();
            layeredPaneUpdateItemDetails.revalidate();
        } else {
            layeredPaneUpdateItemDetails.removeAll();
            layeredPaneUpdateItemDetails.add(CostAndSellingPrice1);
            layeredPaneUpdateItemDetails.repaint();
            layeredPaneUpdateItemDetails.revalidate();
        }    }//GEN-LAST:event_comUpdateItemSelecterActionPerformed

    private void bStockEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStockEditActionPerformed
        jLayeredPane.removeAll();
        jLayeredPane.add(UpdateItem);
        jLayeredPane.repaint();
        jLayeredPane.revalidate();    }//GEN-LAST:event_bStockEditActionPerformed

    private void tableStockViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStockViewMouseClicked
        // this dose not work correctly, fix it
            DefaultTableModel dtm = (DefaultTableModel)tableStockView.getModel();
            int selsectedRow = tableStockView.getSelectedRow();
            
            tfUpdateItemItemName.setText(tableStockView.getValueAt(selsectedRow, 2).toString());
            tfUpdateItemNoInStock.setText(tableStockView.getValueAt(selsectedRow, 3).toString());
            
            tfUpdateItemCostA.setText(tableStockView.getValueAt(selsectedRow, 5).toString());
            lUpdateItemSellingPrice.setText(tableStockView.getValueAt(selsectedRow, 4).toString());
            tfUpdateItemMarkUpA.setText(tableStockView.getValueAt(selsectedRow, 6).toString());
            tfUpdateItemRRP.setText(tableStockView.getValueAt(selsectedRow, 8).toString());

            if(tableStockView.getValueAt(selsectedRow, 7).toString() == "1")
                comUpdateItemMarkUpTypeA.setSelectedIndex(0);
            else
                comUpdateItemMarkUpTypeA.setSelectedIndex(1);

 
            
            
    }//GEN-LAST:event_tableStockViewMouseClicked
     
    private void validateItemSetUp1(JTextField jtf) {
        try {
            if (!tfAddItemCostA.getText().isEmpty() && !tfAddItemMarkUpA.getText().isEmpty()) {

                if (comAddItemMarkUpTypeA.getSelectedIndex() == 1) {
                    //if "£"
                    double cost = Double.valueOf(tfAddItemCostA.getText());
                    double markUp = Double.valueOf(tfAddItemMarkUpA.getText());
                    double price = cost + markUp;
                    lAddItemSellingPrice.setText(String.valueOf(price));
                } else {
                    //if "%"
                    double cost = Double.valueOf(tfAddItemCostA.getText());
                    double markUp = Double.valueOf(tfAddItemMarkUpA.getText());
                    double price = cost + (cost * (markUp / 100));
                    lAddItemSellingPrice.setText(String.valueOf(price));
                }                
            }
            else lAddItemSellingPrice.setText("- - -");
                        
        } catch (NumberFormatException e) {
            //this does not catch ArrayIndexOutOfBoundsException... fix this
            char c;
            try {
                c = jtf.getText().toCharArray()[jtf.getText().length() - 1];
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                return;
            }
            if (c != '.' && c != '-') {
                try {
                    jtf.setText(jtf.getText(0, jtf.getText().length() - 1));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(POS_Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private void validateItemSetUp2(JTextField jtf) {
        try {
            if (!tfAddItemCostB.getText().isEmpty() && !tfAddItemSellingPriceB.getText().isEmpty()) {

                //if "�"
                double cost = Double.valueOf(tfAddItemCostB.getText());
                double price = Double.valueOf(tfAddItemSellingPriceB.getText());
                double markUp = 0;
                if (price > cost) {
                    markUp = price - cost;
                } else if (cost > price) {
                    markUp = cost - price;
                }
                lAddItemMarkUpB.setText(String.valueOf(markUp));

            }
        } catch (NumberFormatException e) {
            char ch;
            try {
                ch = jtf.getText().toCharArray()[jtf.getText().length() - 1];
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                return;
            }
            if (ch != '.' && ch != '-') {
                try {
                    tfAddItemCostA.setText(tfAddItemCostA.getText(0, tfAddItemCostA.getText().length() - 1));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(POS_Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


        private void ValUpdateitemSetUp2(JTextField jtf){
        try {
            if (!tfUpdateItemCostB.getText().isEmpty() && !tfUpdateItemSellingPriceB.getText().isEmpty()) {

                //if "£"
                double cost = Double.valueOf(tfUpdateItemCostB.getText());
                double price = Double.valueOf(tfUpdateItemSellingPriceB.getText());
                double markUp = 0;
                if (price > cost) {
                    markUp = price - cost;
                } else if (cost > price) {
                    markUp = cost - price;
                }
                lUpdateItemMarkUpB.setText(String.valueOf(markUp));

            }
        } catch (NumberFormatException e) {
            char ch;
            try {
                ch = jtf.getText().toCharArray()[jtf.getText().length() - 1];
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                return;
            }
            if (ch != '.' && ch != '-') {
                try {
                    tfUpdateItemCostA.setText(tfUpdateItemCostA.getText(0, tfUpdateItemCostA.getText().length() - 1));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(POS_Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    
    private void ValUpdateitemSetUp1(JTextField jtf){
        try {
            if (!tfUpdateItemCostA.getText().isEmpty() && !tfUpdateItemMarkUpA.getText().isEmpty()) {

                if (comUpdateItemMarkUpTypeA.getSelectedIndex() == 1) {
                    //if "£"
                    double cost = Double.valueOf(tfUpdateItemCostA.getText());
                    double markUp = Double.valueOf(tfUpdateItemMarkUpA.getText());
                    double price = cost + markUp;
                    lUpdateItemSellingPrice.setText(String.valueOf(price));
                } else {
                    //if "%"
                    double cost = Double.valueOf(tfUpdateItemCostA.getText());
                    double markUp = Double.valueOf(tfUpdateItemMarkUpA.getText());
                    double price = cost + (cost * (markUp / 100));
                    lUpdateItemSellingPrice.setText(String.valueOf(price));
                }                
            }
            else lUpdateItemSellingPrice.setText("- - -");
                        
        } catch (NumberFormatException e) {
            char c;
            try {
                c = jtf.getText().toCharArray()[jtf.getText().length() - 1];
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                return;
            }
            if (c != '.' && c != '-') {
                try {
                    jtf.setText(jtf.getText(0, jtf.getText().length() - 1));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(POS_Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }


    }
    
    /**
     * @param args the command line arguments
     */       
public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(POS_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POS_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POS_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POS_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new POS_Main().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CostAndMarkUp;
    private javax.swing.JPanel CostAndMarkUp1;
    private javax.swing.JPanel CostAndSellingPrice;
    private javax.swing.JPanel CostAndSellingPrice1;
    private javax.swing.JPanel UpdateItem;
    private javax.swing.JPanel addItem;
    private javax.swing.JButton bAddItemBack;
    private javax.swing.JButton bAddItemSubmit;
    private javax.swing.JButton bStockAdd;
    private javax.swing.JButton bStockDelete;
    private javax.swing.JButton bStockDetails;
    private javax.swing.JButton bStockEdit;
    private javax.swing.JButton bStockReceipt;
    private javax.swing.JButton bStockSearch;
    private javax.swing.JButton bUpdateItemBack;
    private javax.swing.JButton bUpdateItemSubmit;
    private javax.swing.JComboBox<String> comAddItemMarkUpTypeA;
    private javax.swing.JComboBox<String> comAddItemSelecter;
    private javax.swing.JComboBox<String> comUpdateItemMarkUpTypeA;
    private javax.swing.JComboBox<String> comUpdateItemSelecter;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemClearFile;
    private javax.swing.JMenuItem jMenuItemFileDelete;
    private javax.swing.JMenuItem jMenuItemSettings;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lAddItemCost;
    private javax.swing.JLabel lAddItemItemName;
    private javax.swing.JLabel lAddItemMarkUp;
    private javax.swing.JLabel lAddItemMarkUpB;
    private javax.swing.JLabel lAddItemNoInStock;
    private javax.swing.JLabel lAddItemSellingPrice;
    private javax.swing.JLabel lUpdateItemCost;
    private javax.swing.JLabel lUpdateItemItemName;
    private javax.swing.JLabel lUpdateItemMarkUp;
    private javax.swing.JLabel lUpdateItemMarkUpB;
    private javax.swing.JLabel lUpdateItemNoInStock;
    private javax.swing.JLabel lUpdateItemSellingPrice;
    private javax.swing.JLayeredPane layeredPaneAddItemDetails;
    private javax.swing.JLayeredPane layeredPaneUpdateItemDetails;
    private javax.swing.JPanel stock;
    private javax.swing.JTable tableStockView;
    private javax.swing.JTextField tfAddItemCostA;
    private javax.swing.JTextField tfAddItemCostB;
    private javax.swing.JTextField tfAddItemItemName;
    private javax.swing.JTextField tfAddItemMarkUpA;
    private javax.swing.JTextField tfAddItemNoInStock;
    private javax.swing.JTextField tfAddItemRRP;
    private javax.swing.JTextField tfAddItemSellingPriceB;
    private javax.swing.JTextField tfStockSearch;
    private javax.swing.JTextField tfUpdateItemCostA;
    private javax.swing.JTextField tfUpdateItemCostB;
    private javax.swing.JTextField tfUpdateItemItemName;
    private javax.swing.JTextField tfUpdateItemMarkUpA;
    private javax.swing.JTextField tfUpdateItemNoInStock;
    private javax.swing.JTextField tfUpdateItemRRP;
    private javax.swing.JTextField tfUpdateItemSellingPriceB;
    // End of variables declaration//GEN-END:variables
}
