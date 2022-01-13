package mr_ios_pos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    

    private static final String userN = "root";
    private static final String pWord = "DeadFox64!";
    private static final String dbConn = "jdbc:mysql://localhost:3306/mr_ios_pos"; 
    
    private String updateIDPlaceHolder = "";
    
    private Connection sqlConn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private int q, i, id, deleteItem, percentVAT;
    private boolean allowVAT;
    private DefaultTableModel dtm;
    
    
    public POS_Main() {        
        initComponents();        
        updateDB();             
    }
    
    public  void updateDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dbConn,userN,pWord);
            pst = sqlConn.prepareStatement("SELECT * FROM mr_ios_pos.items;");
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            q = stData.getColumnCount();

            if(this.dtm == null){
                dtm = (DefaultTableModel) tableStockView.getModel();
                tableStockView.setModel(dtm);
                dtm.addColumn("Item ID");
                dtm.addColumn("Item Name");
                dtm.addColumn("No In Stock");
                dtm.addColumn("Cost Inc VAT");
                dtm.addColumn("VAT_Input");
                dtm.addColumn("Mark Up");
                dtm.addColumn("Mark Up Type");
                dtm.addColumn("Selling Price");                
                dtm.addColumn("RRP");
                dtm.addColumn("Inc VAT");
            }
            dtm.setRowCount(0);
            
            while(rs.next()){
                Vector colDat = new Vector();
                
                for (i = 1; i <= q; i++) {
                   colDat.add(rs.getString("ItemID"));
                   colDat.add(rs.getString("Item_Name"));
                   colDat.add(rs.getString("No_In_Stock"));
                   colDat.add(rs.getString("Cost_Inc_VAT"));
                   colDat.add(rs.getString("VAT_Input"));
                   colDat.add(rs.getString("markUp"));
                   
                   if(rs.getString("Is_markUp_Percent").equals("1"))
                       colDat.add("%");
                   else
                       colDat.add("£");
                   
                   colDat.add(rs.getString("Selling_Price"));
                   colDat.add(rs.getString("RRP"));
                                     
                   if(rs.getString("Inc_VAT").equals("1"))
                       colDat.add("Yes");
                   else
                       colDat.add("No");
   
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

        Settings = new javax.swing.JFrame();
        SettingsNav = new javax.swing.JTabbedPane();
        Display = new javax.swing.JPanel();
        SystemVariables = new javax.swing.JPanel();
        SysVarApply = new javax.swing.JButton();
        cbSettingVATLicensed = new javax.swing.JCheckBox();
        tfVAT = new javax.swing.JTextPane();
        tfVATName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();
        tfAddItemVATInputA = new javax.swing.JTextField();
        CostAndSellingPrice = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfAddItemCostB = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfAddItemSellingPriceB = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lAddItemMarkUpB = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfAddItemVATInputB = new javax.swing.JTextField();
        comAddItemSelecter = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tfAddItemRRP = new javax.swing.JTextField();
        bAddItemBack = new javax.swing.JButton();
        cbAddItemIncVat = new javax.swing.JCheckBox();
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
        jLabel4 = new javax.swing.JLabel();
        tfUpdateItemVATInputA = new javax.swing.JTextField();
        CostAndSellingPrice1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tfUpdateItemCostB = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfUpdateItemSellingPriceB = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lUpdateItemMarkUpB = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        comUpdateItemSelecter = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        tfUpdateItemRRP = new javax.swing.JTextField();
        bUpdateItemBack = new javax.swing.JButton();
        cbUpdateItemIncVat = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        Edit = new javax.swing.JMenu();
        jMenuItemSettings = new javax.swing.JMenuItem();

        SettingsNav.setToolTipText("");
        SettingsNav.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout DisplayLayout = new javax.swing.GroupLayout(Display);
        Display.setLayout(DisplayLayout);
        DisplayLayout.setHorizontalGroup(
            DisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        DisplayLayout.setVerticalGroup(
            DisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        SettingsNav.addTab("Display", Display);

        SysVarApply.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SysVarApply.setText("Apply");
        SysVarApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SysVarApplyActionPerformed(evt);
            }
        });

        cbSettingVATLicensed.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbSettingVATLicensed.setSelected(true);
        cbSettingVATLicensed.setText("VAT Licensed");

        tfVAT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfVAT.setText("0");

        tfVATName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfVATName.setText("VAT:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("%");

        javax.swing.GroupLayout SystemVariablesLayout = new javax.swing.GroupLayout(SystemVariables);
        SystemVariables.setLayout(SystemVariablesLayout);
        SystemVariablesLayout.setHorizontalGroup(
            SystemVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SystemVariablesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SystemVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SystemVariablesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SysVarApply))
                    .addGroup(SystemVariablesLayout.createSequentialGroup()
                        .addGroup(SystemVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbSettingVATLicensed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(SystemVariablesLayout.createSequentialGroup()
                                .addComponent(tfVATName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 220, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SystemVariablesLayout.setVerticalGroup(
            SystemVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SystemVariablesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSettingVATLicensed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SystemVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SystemVariablesLayout.createSequentialGroup()
                        .addGroup(SystemVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfVATName)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                        .addComponent(SysVarApply))
                    .addGroup(SystemVariablesLayout.createSequentialGroup()
                        .addComponent(tfVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        SettingsNav.addTab("SysVar", SystemVariables);

        javax.swing.GroupLayout SettingsLayout = new javax.swing.GroupLayout(Settings.getContentPane());
        Settings.getContentPane().setLayout(SettingsLayout);
        SettingsLayout.setHorizontalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SettingsNav)
                .addContainerGap())
        );
        SettingsLayout.setVerticalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingsLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(SettingsNav, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
        bStockDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStockDeleteActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("VAT Input £:");

        tfAddItemVATInputA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout CostAndMarkUpLayout = new javax.swing.GroupLayout(CostAndMarkUp);
        CostAndMarkUp.setLayout(CostAndMarkUpLayout);
        CostAndMarkUpLayout.setHorizontalGroup(
            CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndMarkUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CostAndMarkUpLayout.createSequentialGroup()
                        .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lAddItemCost)
                            .addComponent(lAddItemMarkUp))
                        .addGap(18, 18, 18)
                        .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfAddItemMarkUpA, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(tfAddItemCostA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CostAndMarkUpLayout.createSequentialGroup()
                                .addComponent(comAddItemMarkUpTypeA, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(CostAndMarkUpLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfAddItemVATInputA, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))))
                    .addGroup(CostAndMarkUpLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lAddItemSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        CostAndMarkUpLayout.setVerticalGroup(
            CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndMarkUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lAddItemCost)
                        .addComponent(tfAddItemCostA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(CostAndMarkUpLayout.createSequentialGroup()
                        .addComponent(tfAddItemVATInputA)
                        .addGap(2, 2, 2)))
                .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lAddItemMarkUp)
                    .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfAddItemMarkUpA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comAddItemMarkUpTypeA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CostAndMarkUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lAddItemSellingPrice))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        layeredPaneAddItemDetails.add(CostAndMarkUp, "card2");

        CostAndSellingPrice.setPreferredSize(new java.awt.Dimension(547, 126));

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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Input VAT £:");

        tfAddItemVATInputB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
                            .addGroup(CostAndSellingPriceLayout.createSequentialGroup()
                                .addComponent(tfAddItemSellingPriceB, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(23, 23, 23))
                    .addGroup(CostAndSellingPriceLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfAddItemCostB, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAddItemVATInputB, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        CostAndSellingPriceLayout.setVerticalGroup(
            CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndSellingPriceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(tfAddItemCostB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(CostAndSellingPriceLayout.createSequentialGroup()
                        .addComponent(tfAddItemVATInputB)
                        .addGap(2, 2, 2)))
                .addGroup(CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfAddItemSellingPriceB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CostAndSellingPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lAddItemMarkUpB))
                .addContainerGap(25, Short.MAX_VALUE))
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

        cbAddItemIncVat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbAddItemIncVat.setText("Inc Output VAT");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAddItemItemName)
                            .addComponent(tfAddItemNoInStock)))
                    .addGroup(addItemLayout.createSequentialGroup()
                        .addComponent(cbAddItemIncVat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comAddItemSelecter, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addGroup(addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comAddItemSelecter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAddItemIncVat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(layeredPaneAddItemDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("VAT Input £:");

        tfUpdateItemVATInputA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout CostAndMarkUp1Layout = new javax.swing.GroupLayout(CostAndMarkUp1);
        CostAndMarkUp1.setLayout(CostAndMarkUp1Layout);
        CostAndMarkUp1Layout.setHorizontalGroup(
            CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndMarkUp1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CostAndMarkUp1Layout.createSequentialGroup()
                        .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lUpdateItemCost)
                            .addComponent(lUpdateItemMarkUp))
                        .addGap(18, 18, 18)
                        .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfUpdateItemCostA, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(tfUpdateItemMarkUpA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CostAndMarkUp1Layout.createSequentialGroup()
                                .addComponent(comUpdateItemMarkUpTypeA, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(CostAndMarkUp1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfUpdateItemVATInputA, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))))
                    .addGroup(CostAndMarkUp1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lUpdateItemSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        CostAndMarkUp1Layout.setVerticalGroup(
            CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndMarkUp1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndMarkUp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUpdateItemCost)
                    .addComponent(tfUpdateItemCostA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfUpdateItemVATInputA))
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

        CostAndSellingPrice1.setPreferredSize(new java.awt.Dimension(547, 126));

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

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("VAT Input £:");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout CostAndSellingPrice1Layout = new javax.swing.GroupLayout(CostAndSellingPrice1);
        CostAndSellingPrice1.setLayout(CostAndSellingPrice1Layout);
        CostAndSellingPrice1Layout.setHorizontalGroup(
            CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndSellingPrice1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CostAndSellingPrice1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(44, 44, 44)
                        .addComponent(lUpdateItemMarkUpB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CostAndSellingPrice1Layout.createSequentialGroup()
                        .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CostAndSellingPrice1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(74, 74, 74))
                            .addGroup(CostAndSellingPrice1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(16, 16, 16)))
                        .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfUpdateItemSellingPriceB, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(tfUpdateItemCostB))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        CostAndSellingPrice1Layout.setVerticalGroup(
            CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostAndSellingPrice1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(tfUpdateItemCostB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(CostAndSellingPrice1Layout.createSequentialGroup()
                        .addComponent(jTextField2)
                        .addGap(2, 2, 2)))
                .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfUpdateItemSellingPriceB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CostAndSellingPrice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lUpdateItemMarkUpB))
                .addContainerGap(25, Short.MAX_VALUE))
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

        cbUpdateItemIncVat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbUpdateItemIncVat.setText("Inc Output VAT");

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
                        .addComponent(cbUpdateItemIncVat)
                        .addGap(25, 25, 25)
                        .addComponent(comUpdateItemSelecter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UpdateItemLayout.createSequentialGroup()
                        .addComponent(lUpdateItemItemName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfUpdateItemItemName))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UpdateItemLayout.createSequentialGroup()
                        .addComponent(lUpdateItemNoInStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfUpdateItemNoInStock)))
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
                        .addGroup(UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfUpdateItemNoInStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lUpdateItemNoInStock))
                        .addGap(12, 12, 12)
                        .addGroup(UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comUpdateItemSelecter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbUpdateItemIncVat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(layeredPaneUpdateItemDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdateItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfUpdateItemRRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UpdateItemLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(bUpdateItemSubmit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane.add(UpdateItem, "card3");

        Edit.setText("Edit");

        jMenuItemSettings.setText("Settings");
        jMenuItemSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSettingsActionPerformed(evt);
            }
        });
        Edit.add(jMenuItemSettings);

        jMenuBar1.add(Edit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLayeredPane)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLayeredPane)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
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
                int itemID = 1000 + tableStockView.getRowCount();
                String incOutputVAT;
                if(cbAddItemIncVat.isSelected())
                    incOutputVAT = "Yse";
                else
                    incOutputVAT = "No";

                if (comAddItemSelecter.getSelectedIndex() == 0) {

                    String is_percent;
                    if(comAddItemMarkUpTypeA.getSelectedItem().toString() == "%")
                        is_percent = "%";
                    else
                        is_percent = "£";
                    
                    String inputVAT = "0";
                    if(!tfAddItemVATInputA.getText().isEmpty())
                        inputVAT = tfAddItemVATInputA.getText();

                    /*dtm.addRow(new Object[]{
                        itemID,
                        tfAddItemItemName.getText(),
                        Integer.valueOf(tfAddItemNoInStock.getText()),
                        Double.valueOf(tfAddItemCostA.getText()),
                        Double.valueOf(inputVAT),
                        Double.valueOf(tfAddItemMarkUpA.getText()),
                        is_percent,
                        Double.valueOf(lAddItemSellingPrice.getText()),
                        Double.valueOf(tfAddItemRRP.getText()),
                        incOutputVAT
                    });*/

                    Class.forName("com.mysql.jdbc.Driver");
                    sqlConn = DriverManager.getConnection(dbConn, userN, pWord);
                    pst = sqlConn.prepareStatement("insert into mr_ios_pos.items (ItemID, Item_Name, No_In_Stock,  Cost_Inc_VAT, markUp, Is_markUp_Percent, Selling_Price, RRP, Inc_VAT) value(?,?,?,?,?,?,?,?,?,?)");
                    int isPersent = 0;
                    if (is_percent == "%") {
                        isPersent = 1;
                    }
                    pst.setString(1, String.valueOf(itemID));
                    pst.setString(2, tfAddItemItemName.getText());
                    pst.setString(3, tfAddItemNoInStock.getText());
                    pst.setString(4, tfAddItemCostA.getText());
                    pst.setString(5, inputVAT);
                    pst.setString(6, tfAddItemMarkUpA.getText());
                    pst.setString(7, String.valueOf(isPersent));
                    pst.setString(8, lAddItemSellingPrice.getText());
                    pst.setString(9, tfAddItemRRP.getText());
                    pst.setString(10, String.valueOf(cbAddItemIncVat.isSelected()));

                    pst.executeUpdate();
                    updateDB();

                } else {


                    /*dtm.addRow(new Object[]{
                        itemID,
                        tfAddItemItemName.getText(),
                        Integer.valueOf(tfAddItemNoInStock.getText()),
                        Double.valueOf(tfAddItemSellingPriceB.getText()),
                        Double.valueOf(tfAddItemCostB.getText()),
                        Double.valueOf(lAddItemMarkUpB.getText()),
                        false,
                        Double.valueOf(tfAddItemRRP.getText()),
                        cbAddItemIncVat.isSelected()
                    });*/

                    Class.forName("com.mysql.jdbc.Driver");
                    sqlConn = DriverManager.getConnection(dbConn, userN, pWord);
                    pst = sqlConn.prepareStatement("insert into mr_ios_pos.items (ItemID, Item_Name, No_In_Stock,  Cost_Inc_VAT, markUp, Is_markUp_Percent, Selling_Price, RRP, Inc_VAT) value(?,?,?,?,?,?,?,?,?)");
                    
                    pst.setString(1, String.valueOf(itemID));
                    pst.setString(2, tfAddItemItemName.getText());
                    pst.setString(3, tfAddItemNoInStock.getText());
                    pst.setString(5, tfAddItemCostB.getText());
                     pst.setString(6, tfAddItemVATInputB.getText());
                    pst.setString(7, lAddItemMarkUpB.getText());
                    pst.setString(8, "0");
                    pst.setString(4, lAddItemSellingPrice.getText());
                    pst.setString(9, tfAddItemRRP.getText());
                    pst.setString(10, String.valueOf(cbAddItemIncVat.isSelected()));

                    pst.executeUpdate();
                    updateDB();

                }

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
                boolean ok = true;
        int addType = comUpdateItemSelecter.getSelectedIndex();
        String message = "";
        if (tfUpdateItemItemName.getText().isEmpty()) {
            ok = false;
            message += "- The name of the item must be given.\n";
        }

        if (tfUpdateItemNoInStock.getText().isEmpty()) {
            ok = false;
            message += "- The amount of items in stock must be given.\n";
        } else {
            try {
                int test = Integer.valueOf(tfUpdateItemNoInStock.getText());
            } catch (NumberFormatException e2) {
                ok = false;
                message += "- The amount of items in stock must be a number.\n";
            }
        }

        switch (addType) {
            case 0:
                if (tfUpdateItemCostA.getText().isEmpty()) {
                    ok = false;
                    message += "- The cost of the item must be given.\n";
                } else {
                    try {
                        double test = Double.valueOf(tfUpdateItemCostA.getText());
                    } catch (NumberFormatException e2) {
                        ok = false;
                        message += "- The cost of the item must be a number.\n";
                    }
                }

                if (tfUpdateItemMarkUpA.getText().isEmpty()) {
                    ok = false;
                    message += "- The Mark Up must be given.\n";
                } else {
                    try {
                        double test = Double.valueOf(tfUpdateItemMarkUpA.getText());
                    } catch (NumberFormatException e2) {
                        ok = false;
                        message += "- The Mark Up must be a number.\n";
                    }

                }
                break;
            case 1:
                if (tfUpdateItemCostB.getText().isEmpty()) {
                    ok = false;
                    message += "- The cost of the item must be given.\n";
                } else {
                    try {
                        double test = Double.valueOf(tfUpdateItemCostB.getText());
                    } catch (NumberFormatException e2) {
                        ok = false;
                        message += "- The cost of the item must be a number.\n";
                    }
                }

                if (tfUpdateItemSellingPriceB.getText().isEmpty()) {
                    ok = false;
                    message += "- The selling price of the item must be givin.\n";
                } else {
                    try {
                        double test = Double.valueOf(tfUpdateItemCostB.getText());
                    } catch (NumberFormatException e2) {
                        ok = false;
                        message += "- The selling price must be a number.\n";
                    }
                }
                break;
        }

        if (tfUpdateItemRRP.getText().isEmpty()) {
            ok = false;
            message += "- The Recommended Retail Price (RRP) must be given.\n";
        } else {
            try {
                double test = Double.valueOf(tfUpdateItemRRP.getText());
            } catch (NumberFormatException e2) {
                ok = false;
                message += "- The Recommended Retail Price (RRP) must be a number.\n";
            }
        }

        if (ok) {

            try {               

                if (comUpdateItemSelecter.getSelectedIndex() == 0) {

                    boolean is_percent = ("%".equals(comUpdateItemMarkUpTypeA.getSelectedItem().toString()));

                    Class.forName("com.mysql.jdbc.Driver");
                    sqlConn = DriverManager.getConnection(dbConn, userN, pWord);
                    pst = sqlConn.prepareStatement("update items set Item_Name = ?, No_In_Stock = ?, Cost_Inc_VAT = ?, markUp = ?, Is_markUp_Percent = ?, Selling_Price = ?, RRP = ?, Inc_VAT = ? where ItemID = ?");
                    int isPersent = 0;
                    if (is_percent) {
                        isPersent = 1;
                    }
                    pst.setString(0, updateIDPlaceHolder);
                    pst.setString(1, tfUpdateItemItemName.getText());
                    pst.setString(2, tfUpdateItemNoInStock.getText());
                    pst.setString(8, String.valueOf(cbUpdateItemIncVat.isSelected()));
                    pst.setString(4, tfUpdateItemCostA.getText());
                    pst.setString(5, tfUpdateItemMarkUpA.getText());
                    pst.setString(6, String.valueOf(isPersent));
                    pst.setString(3, lUpdateItemSellingPrice.getText());
                    pst.setString(7, tfUpdateItemRRP.getText());                    
                    

                    pst.executeUpdate();
                    updateDB();

                } else {           
                    Class.forName("com.mysql.jdbc.Driver");
                    sqlConn = DriverManager.getConnection(dbConn, userN, pWord);
                    pst = sqlConn.prepareStatement("update items set Item_Name = ?, No_In_Stock = ?,  Cost_Inc_VAT = ?, markUp = ?, Is_markUp_Percent = ?, Selling_Price = ?, RRP = ?, Inc_VAT = ? where ItemID = ?");
                    pst.setString(0, updateIDPlaceHolder);
                    pst.setString(1, tfUpdateItemItemName.getText());
                    pst.setString(2, tfUpdateItemNoInStock.getText());                    
                    pst.setString(4, tfUpdateItemCostA.getText());
                    pst.setString(5, tfUpdateItemMarkUpA.getText());
                    pst.setString(6, "0");
                    pst.setString(3, lUpdateItemSellingPrice.getText());
                    pst.setString(7, tfUpdateItemRRP.getText());
                    pst.setString(8, String.valueOf(cbUpdateItemIncVat.isSelected()));
                    


                    pst.executeUpdate();
                    updateDB();

                }

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

                My.p("\nItem Updated");
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

            int selsectedRow = tableStockView.getSelectedRow();
            
            updateIDPlaceHolder = tableStockView.getValueAt(selsectedRow, 0).toString();
            
            tfUpdateItemItemName.setText(tableStockView.getValueAt(selsectedRow, 1).toString());
            tfUpdateItemNoInStock.setText(tableStockView.getValueAt(selsectedRow, 2).toString());
            
            tfUpdateItemCostA.setText(tableStockView.getValueAt(selsectedRow, 3).toString());
            tfUpdateItemVATInputA.setText(tableStockView.getValueAt(selsectedRow, 4).toString());
            lUpdateItemSellingPrice.setText(tableStockView.getValueAt(selsectedRow, 3).toString());
            tfUpdateItemMarkUpA.setText(tableStockView.getValueAt(selsectedRow, 5).toString());
            tfUpdateItemRRP.setText(tableStockView.getValueAt(selsectedRow, 8).toString());

            if("1".equals(tableStockView.getValueAt(selsectedRow, 6).toString()))
                comUpdateItemMarkUpTypeA.setSelectedIndex(1);
            else
                comUpdateItemMarkUpTypeA.setSelectedIndex(0);
            
            cbUpdateItemIncVat.setSelected(tableStockView.getValueAt(selsectedRow, 9).toString().equals("Yes"));

    }//GEN-LAST:event_tableStockViewMouseClicked

    private void bStockDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStockDeleteActionPerformed
        int selectedRow = tableStockView.getSelectedRow();
        if(selectedRow == -1)
            JOptionPane.showMessageDialog(null, "You must select a row in the table to delete.");
        else{
            int itemID = Integer.parseInt(tableStockView.getValueAt(selectedRow, 0).toString());
            int deleteItem = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete" + itemID + "?", "Warning", JOptionPane.YES_NO_OPTION);
            if(deleteItem == JOptionPane.YES_OPTION){
                try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dbConn, userN, pWord);
                pst = sqlConn.prepareStatement("DELETE FROM mr_ios_pos.items WHERE ItemID = ?;");
                
                pst.setInt(1, itemID);
                pst.executeUpdate();
                updateDB();
                
                } catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.toString());
                } catch(ClassNotFoundException e2){                                
                    JOptionPane.showMessageDialog(null, e2.toString());
                }
            }
            else
                return;
        }
    }//GEN-LAST:event_bStockDeleteActionPerformed

    private void jMenuItemSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSettingsActionPerformed
        // TODO add your handling code here:---------------------------------------------------------------------------------------------------------------------
        Settings = new JFrame();
        Settings.setSize(500, 500);
        Settings.setVisible(true);
        Settings.add(SettingsNav);
        SettingsNav.setVisible(true);
    }//GEN-LAST:event_jMenuItemSettingsActionPerformed

    private void SysVarApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SysVarApplyActionPerformed
        try {
            String varData = "";
            File file = new File("SysVar.txt");

            if (!tfVAT.getText().isEmpty() && cbSettingVATLicensed.isSelected()) {
                allowVAT = true;
                varData += "1|" + tfVAT.getText() + ";";
                 
            }
            else if (cbSettingVATLicensed.isSelected()){
                JOptionPane.showMessageDialog(null, "Please enter a persent in the VAT Text bar");
            }
            else {
                    allowVAT = false;
                    varData += "0|-";

                }
                if (file.exists()) {
                    FileWriter writer = new FileWriter("SysVar.txt");
                    writer.write(varData);
                    writer.close();
                }
            
        } catch (IOException e) {

        }
    }//GEN-LAST:event_SysVarApplyActionPerformed
     
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
    private javax.swing.JPanel Display;
    private javax.swing.JMenu Edit;
    private javax.swing.JFrame Settings;
    private javax.swing.JTabbedPane SettingsNav;
    private javax.swing.JButton SysVarApply;
    private javax.swing.JPanel SystemVariables;
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
    private javax.swing.JCheckBox cbAddItemIncVat;
    private javax.swing.JCheckBox cbSettingVATLicensed;
    private javax.swing.JCheckBox cbUpdateItemIncVat;
    private javax.swing.JComboBox<String> comAddItemMarkUpTypeA;
    private javax.swing.JComboBox<String> comAddItemSelecter;
    private javax.swing.JComboBox<String> comUpdateItemMarkUpTypeA;
    private javax.swing.JComboBox<String> comUpdateItemSelecter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemSettings;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
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
    private javax.swing.JTextField tfAddItemVATInputA;
    private javax.swing.JTextField tfAddItemVATInputB;
    private javax.swing.JTextField tfStockSearch;
    private javax.swing.JTextField tfUpdateItemCostA;
    private javax.swing.JTextField tfUpdateItemCostB;
    private javax.swing.JTextField tfUpdateItemItemName;
    private javax.swing.JTextField tfUpdateItemMarkUpA;
    private javax.swing.JTextField tfUpdateItemNoInStock;
    private javax.swing.JTextField tfUpdateItemRRP;
    private javax.swing.JTextField tfUpdateItemSellingPriceB;
    private javax.swing.JTextField tfUpdateItemVATInputA;
    private javax.swing.JTextPane tfVAT;
    private javax.swing.JLabel tfVATName;
    // End of variables declaration//GEN-END:variables
}
