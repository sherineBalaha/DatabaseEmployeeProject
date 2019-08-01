package databaseemployeeproject;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.*;
import java.io.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 91030283
 */
public class EmployeeFrame extends javax.swing.JFrame {

          ResultSet employeeResultSet =null;
          Statement statment =null;
          String sql="";
          Connection sqlConnection ;
    
//    ResultSet employeeResultSet =null;
//    ResultSetTableModel tableModel;
//    Statement statment =null;
//    String sql="";
//    Connection sqlConnection ;
    /**
     * Creates new form EmployeeFrame
     */
    public EmployeeFrame() {
        initComponents();
        
        try
     {
            int lowestEmpNum = 100;
            sql=  "select * from empdetail " ; //
            sqlConnection = DatabaseConnector.connectToDatabase();
            statment= sqlConnection.createStatement();
            employeeResultSet = statment.executeQuery(sql) ;
            
            //load Metadata panel variables
            ResultSetMetaData RSMetadata =employeeResultSet.getMetaData();
            DatabaseMetaData DBMetadata= sqlConnection.getMetaData();
            String DisplayMetadata="";
            int numbers = 0;
            int columns = RSMetadata.getColumnCount();
            String strColLabelType="";
             
            
            
            String strDBType = DBMetadata.getDatabaseProductName();
            String strDBVersion = DBMetadata.getDatabaseProductVersion();
            String strDBDriver=DBMetadata.getDriverName();
            String strTblName = RSMetadata.getTableName(1);
            
            txtDBType.setText("Database Type:" + strDBType);
            btnDBVersion.setText("Database Version :"+strDBVersion);
            btnDBDriver.setText("Database Driver : "+strDBDriver);
            btnTblName.setText(strTblName);
            
            
            for(int i=1; i<=columns ;i++)
            {
                strColLabelType += "\n"+RSMetadata.getColumnLabel(i)+ "\t" + RSMetadata.getColumnTypeName(i);
                
            }
            txtAreaTblColumns.setText(strColLabelType);
            
            //on load retrieve data
            if (employeeResultSet.next())
            {
                int i=1;
                
                while (employeeResultSet.next())
                {   
                    
                    int newEmpNum ;
                    newEmpNum =Integer.parseInt(employeeResultSet.getString(i));
                    if(newEmpNum < lowestEmpNum )
                    {
                        lowestEmpNum = newEmpNum;
                        i++;
                        
                    }    
                   
               
                }
                
               
              
            }
            
            sql=  "select * from empdetail where EmpID=" +lowestEmpNum; //
            
            statment= sqlConnection.createStatement();
            employeeResultSet = statment.executeQuery(sql) ;
            while (employeeResultSet.next())
                {     
                
                txtEmpNo.setText(employeeResultSet.getString(1));
                txtName.setText(employeeResultSet.getString(2));
                txtAddresse.setText(employeeResultSet.getString(3));
                txtSuburb.setText(employeeResultSet.getString(4));
                txtPostCode.setText(employeeResultSet.getString(5));
                txtPhone.setText(employeeResultSet.getString(6));
                txtMobile.setText(employeeResultSet.getString(7));
                txtEmail.setText(employeeResultSet.getString(8));
                }
            
                DatabaseConnector.closeConnection(sqlConnection);
                statment.close();
            
//                if (employeeResultSet.next())
//            {
//                while (employeeResultSet.next())
//                {
//                txtEmpNo.setText(employeeResultSet.getString(1));
//                txtName.setText(employeeResultSet.getString(2));
//                txtAddresse.setText(employeeResultSet.getString(3));
//                txtSuburb.setText(employeeResultSet.getString(4));
//                txtPostCode.setText(employeeResultSet.getString(5));
//                txtPhone.setText(employeeResultSet.getString(6));
//                txtMobile.setText(employeeResultSet.getString(7));
//                txtEmail.setText(employeeResultSet.getString(8));
//                }

//            }
                
                
                
                
                
                
          
            
     }
     catch (SQLException sqle)
     {
                showExceptionOptionPane(sqle.toString());
                
     }       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exceptOptionPane = new javax.swing.JOptionPane();
        EmployeeDetailsPanel = new java.awt.Panel();
        jLabel4 = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRetrieve = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtEmpNo = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAddresse = new javax.swing.JTextField();
        txtSuburb = new javax.swing.JTextField();
        txtPostCode = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        QueryPanel = new java.awt.Panel();
        txtQuery = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSubmitQuery = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumOfRecords = new javax.swing.JTextField();
        btnReportFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtReportFile = new javax.swing.JTextField();
        metaDataPanel = new java.awt.Panel();
        jLabel12 = new javax.swing.JLabel();
        txtDBType = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnDBVersion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnDBDriver = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnTblName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        paneTblCol = new javax.swing.JScrollPane();
        txtAreaTblColumns = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Form");

        EmployeeDetailsPanel.setName("Employee Details"); // NOI18N

        jLabel4.setText("Employee No:");

        Name.setText("Name:");

        jLabel6.setText("Addresse:");

        jLabel7.setText("Suburb:");

        jLabel8.setText("PostCode:");

        jLabel9.setText("Phone(Home):");
        jLabel9.setToolTipText("");

        jLabel10.setText("Mobile:");

        jLabel11.setText("Email:");

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRetrieve.setText("Retrieve");
        btnRetrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrieveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EmployeeDetailsPanelLayout = new javax.swing.GroupLayout(EmployeeDetailsPanel);
        EmployeeDetailsPanel.setLayout(EmployeeDetailsPanelLayout);
        EmployeeDetailsPanelLayout.setHorizontalGroup(
            EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeeDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNew)
                    .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel4)
                        .addComponent(Name)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EmployeeDetailsPanelLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnRetrieve))
                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtEmpNo, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtAddresse, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtPostCode, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtSuburb, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(11, 11, 11)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        EmployeeDetailsPanelLayout.setVerticalGroup(
            EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeeDetailsPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmpNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAddresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSuburb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(EmployeeDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnAdd)
                    .addComponent(btnRetrieve)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        QueryPanel.setName("Query"); // NOI18N

        jLabel1.setText("Query:");

        btnSubmitQuery.setText("Submit Query");
        btnSubmitQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitQueryActionPerformed(evt);
            }
        });

        jLabel2.setText("Results:");

        jLabel3.setText("Report File:");

        txtNumOfRecords.setEditable(false);

        btnReportFile.setText("Report File");
        btnReportFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportFileActionPerformed(evt);
            }
        });

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblEmployee);

        jLabel5.setText("Number of Records");

        javax.swing.GroupLayout QueryPanelLayout = new javax.swing.GroupLayout(QueryPanel);
        QueryPanel.setLayout(QueryPanelLayout);
        QueryPanelLayout.setHorizontalGroup(
            QueryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QueryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QueryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QueryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QueryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSubmitQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(QueryPanelLayout.createSequentialGroup()
                        .addGroup(QueryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(QueryPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(39, 39, 39)
                                .addComponent(txtNumOfRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 110, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(QueryPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(47, 47, 47)
                .addComponent(txtReportFile, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnReportFile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        QueryPanelLayout.setVerticalGroup(
            QueryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QueryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QueryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(QueryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QueryPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmitQuery))
                    .addGroup(QueryPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(QueryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumOfRecords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(QueryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnReportFile)
                    .addComponent(txtReportFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        jLabel12.setText("Database Type:");

        txtDBType.setEditable(false);

        jLabel13.setText("Database Version:");

        btnDBVersion.setEditable(false);

        jLabel14.setText("Database Driver:");

        btnDBDriver.setEditable(false);

        jLabel15.setText("Table Name:");

        btnTblName.setEditable(false);

        jLabel16.setText("Table Columns:");

        txtAreaTblColumns.setColumns(20);
        txtAreaTblColumns.setRows(5);
        paneTblCol.setViewportView(txtAreaTblColumns);

        javax.swing.GroupLayout metaDataPanelLayout = new javax.swing.GroupLayout(metaDataPanel);
        metaDataPanel.setLayout(metaDataPanelLayout);
        metaDataPanelLayout.setHorizontalGroup(
            metaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metaDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(metaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(27, 27, 27)
                .addGroup(metaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDBType)
                    .addComponent(btnDBVersion)
                    .addComponent(btnDBDriver)
                    .addComponent(btnTblName)
                    .addComponent(paneTblCol, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        metaDataPanelLayout.setVerticalGroup(
            metaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metaDataPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(metaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(metaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnDBVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(metaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(btnDBDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(metaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(btnTblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(metaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(paneTblCol, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EmployeeDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(metaDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QueryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(QueryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EmployeeDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(metaDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        QueryPanel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    
    private void btnSubmitQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitQueryActionPerformed
          ResultSet employeeResultSet =null;
          ResultSetTableModel tableModel;
          Statement statment =null;
          String sql="";
          Connection sqlConnection ;
        
          sql=   txtQuery.getText();  
        
        
        try
        {
            
            sqlConnection = DatabaseConnector.connectToDatabase();
            
            if(txtQuery.getText().contains("select"))
            {
            statment= sqlConnection.createStatement(employeeResultSet.TYPE_SCROLL_SENSITIVE,employeeResultSet.CONCUR_READ_ONLY);
            employeeResultSet = statment.executeQuery(sql) ; 
            
                        
            tableModel= new ResultSetTableModel(employeeResultSet);
            
            tblEmployee.setModel(tableModel);
            this.txtNumOfRecords.setText(String.valueOf(tableModel.rowCount));
            //exceptOptionPane.showMessageDialog(this, String.valueOf(tableModel.rowCount), "Messege", JOptionPane.INFORMATION_MESSAGE);
            DatabaseConnector.closeConnection(sqlConnection);
            statment.close();
           
            }
            else
            {
                showExceptionOptionPane("Only -select- statements are allowed");
                
            }
        }
        catch (SQLException sqle)
        {
                showExceptionOptionPane(sqle.toString());
                
        }

    }//GEN-LAST:event_btnSubmitQueryActionPerformed

    private void btnReportFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportFileActionPerformed
        
        
        String strFilePath=null;
        String strData ="";
        strFilePath= txtReportFile.getText();
        FileWriter Writer= null;
        
        
        ResultSet employeeResultSet =null;
         
        Statement statment =null;
        String sql="";
        Connection sqlConnection ;
        
         // "select * from empdetail";  //  
        try
        {
            sql=   txtQuery.getText();
            sqlConnection = DatabaseConnector.connectToDatabase();
            statment= sqlConnection.createStatement(employeeResultSet.TYPE_SCROLL_SENSITIVE,employeeResultSet.CONCUR_READ_ONLY);
            employeeResultSet = statment.executeQuery(sql) ; 
            boolean boolLabelsNotDone=true;
            ResultSetMetaData RSMetadata =employeeResultSet.getMetaData();
            int columns = RSMetadata.getColumnCount();
            
            
            
            
            if ( (strFilePath != null) && (employeeResultSet != null) )
            {
          
            Writer = new FileWriter(strFilePath);
            
          
            
            
            while(employeeResultSet.next())
            {
                 
                if(boolLabelsNotDone)
                {
                    for(int i=1; i<=columns ;i++)
                     {
                
                        strData += RSMetadata.getColumnLabel(i)+ "|" ;
                        
                     }
                    
                    boolLabelsNotDone=false;
                }    
            
                
                strData += "\n"+ employeeResultSet.getString(1) + "|";
                strData += "\n" +employeeResultSet.getString(2)+ "|";
                strData += "\n"+employeeResultSet.getString(3)+ "|";
                strData += "\n"+employeeResultSet.getString(4)+ "|";
                strData += "\n"+employeeResultSet.getString(5)+ "|";
                strData += "\n"+employeeResultSet.getString(6)+ "|";
                strData += "\n"+employeeResultSet.getString(7)+ "|";
                strData += "\n"+employeeResultSet.getString(8)+ "|" +"\n";
                Writer.write(strData);  
            }    
            
            
            //Writer.write(strData);
            exceptOptionPane.showMessageDialog(this, "Report File has been written and saved!", "Messege", JOptionPane.INFORMATION_MESSAGE);
            Writer.close();
            DatabaseConnector.closeConnection(sqlConnection);
            statment.close();
            

        }
        else 
            {
            showExceptionOptionPane("Please Enter file path Else");
            }    
            
        }
        catch (IOException ioe)
        {
            showExceptionOptionPane("IO Exception has taken place");
        }
        catch (SQLException sqle)
        {
            showExceptionOptionPane("Please Enter file path SQ");
        }
    }//GEN-LAST:event_btnReportFileActionPerformed

    private void btnRetrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrieveActionPerformed
        
    ResultSet employeeResultSet =null;
    Statement statment =null;
    String sql="";
    Connection sqlConnection ;
try
        {
            sql=  "select * from empdetail where EmpID=" + txtEmpNo.getText() ; //
            sqlConnection = DatabaseConnector.connectToDatabase();
            statment= sqlConnection.createStatement();
            employeeResultSet = statment.executeQuery(sql) ;
            
            if (employeeResultSet.next())
            {
                while (employeeResultSet.next())
                {
                txtEmpNo.setText(employeeResultSet.getString(1));
                txtName.setText(employeeResultSet.getString(2));
                txtAddresse.setText(employeeResultSet.getString(3));
                txtSuburb.setText(employeeResultSet.getString(4));
                txtPostCode.setText(employeeResultSet.getString(5));
                txtPhone.setText(employeeResultSet.getString(6));
                txtMobile.setText(employeeResultSet.getString(7));
                txtEmail.setText(employeeResultSet.getString(8));
                }
            
            
         
            DatabaseConnector.closeConnection(sqlConnection);
            statment.close();
            }
            else
            {
                exceptOptionPane.showMessageDialog(this,"No record exist with this Employee ID", "Information Messege", JOptionPane.INFORMATION_MESSAGE);
                
                txtName.setText("");
                txtAddresse.setText("");
                txtSuburb.setText("");
                txtPostCode.setText("");
                txtPhone.setText("");
                txtMobile.setText("");
                txtEmail.setText("");
                
            }

        }
        catch (SQLException sqle)
        {
                showExceptionOptionPane(sqle.toString());
                
        }
        

    }//GEN-LAST:event_btnRetrieveActionPerformed
//////////////////////////////////////
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
          ResultSet employeeResultSet =null;
          ResultSetTableModel tableModel;
          Statement statment =null;
          String sql="";
          Connection sqlConnection ;
        try
        {
            if(txtEmpNo.getText().length() ==0)
            {
                exceptOptionPane.showMessageDialog(this,"Enter Employee No.", "Information Messege", JOptionPane.INFORMATION_MESSAGE);
            }
             //
            sqlConnection = DatabaseConnector.connectToDatabase();
            statment= sqlConnection.createStatement(employeeResultSet.TYPE_SCROLL_SENSITIVE,employeeResultSet.CONCUR_UPDATABLE);
            sql=  "select * from empdetail where EmpID=" + txtEmpNo.getText() ;
            employeeResultSet = statment.executeQuery(sql) ;
            
            
            employeeResultSet.absolute(1);
            employeeResultSet.updateInt(1, Integer.parseInt(txtEmpNo.getText()));
            employeeResultSet.updateString(2, txtName.getText());
            employeeResultSet.updateString(3, txtAddresse.getText());
            employeeResultSet.updateString(4, txtSuburb.getText());
            employeeResultSet.updateString(5, txtPostCode.getText());
            employeeResultSet.updateString(6, txtPhone.getText());
            employeeResultSet.updateString(7, txtMobile.getText());
            employeeResultSet.updateString(8, txtEmail.getText());
            
            employeeResultSet.updateRow();
            exceptOptionPane.showMessageDialog(this,"Record has been updated to table successfully!", "Information Messege", JOptionPane.INFORMATION_MESSAGE);
            statment.close();
            DatabaseConnector.closeConnection(sqlConnection);
            


        }
        catch (SQLException sqle)
        {
                showExceptionOptionPane(sqle.toString());
                
        }
        
        
//////////////////////////////////////////////

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

         ResultSet employeeResultSet =null;
          
          Statement statment =null;
          String sql="";
          Connection sqlConnection ;
        try
        {
            if(txtEmpNo.getText().length() ==0)
            {
                exceptOptionPane.showMessageDialog(this,"Enter Employee No.", "Information Messege", JOptionPane.INFORMATION_MESSAGE);
            }
             //
            sqlConnection = DatabaseConnector.connectToDatabase();
            statment= sqlConnection.createStatement(employeeResultSet.TYPE_SCROLL_SENSITIVE,employeeResultSet.CONCUR_UPDATABLE);
            sql=  "DELETE FROM empdetail WHERE EmpID=" + txtEmpNo.getText() ;
           
            statment.executeUpdate(sql) ;
        
            exceptOptionPane.showConfirmDialog(this,"Record has been deleted from table successfully!", "Information Messege",JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_OPTION,null);
            
            statment.close();
            DatabaseConnector.closeConnection(sqlConnection);

             }
        catch (SQLException sqle)
        {
                showExceptionOptionPane(sqle.toString());
                
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

          ResultSet employeeResultSet =null;
          
          Statement statment =null;
          String sql="";
          Connection sqlConnection ;
        try
        {
            if(txtEmpNo.getText().length() ==0)
            {
                exceptOptionPane.showMessageDialog(this,"Enter Employee No.", "Information Messege", JOptionPane.INFORMATION_MESSAGE);
            }
             //
            sqlConnection = DatabaseConnector.connectToDatabase();
            statment= sqlConnection.createStatement(employeeResultSet.TYPE_SCROLL_SENSITIVE,employeeResultSet.CONCUR_UPDATABLE);
            sql=  "INSERT INTO empdetail VALUES (";
            sql+= txtEmpNo.getText()+",'";
            sql+= txtName.getText()+"','";
            sql+= txtAddresse.getText()+"','";
            sql+= txtSuburb.getText()+"','";
            sql+= txtPostCode.getText()+"','";
            sql+= txtPhone.getText()+"','";
            sql+= txtMobile.getText()+"','";
            sql+= txtEmail.getText()+"')";
            
            
            statment.executeUpdate(sql) ;
    
            exceptOptionPane.showMessageDialog(this,"Record has been added to current table successfully!", "Information Messege", JOptionPane.INFORMATION_MESSAGE);
            statment.close();
            DatabaseConnector.closeConnection(sqlConnection);
            txtName.setText("");
            txtAddresse.setText("");
            txtSuburb.setText("");
            txtPostCode.setText("");
            txtPhone.setText("");
            txtMobile.setText("");
            txtEmail.setText("");


        }
        catch (SQLException sqle)
        {
                showExceptionOptionPane(sqle.toString());
                
        }
        
        

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed

         try
     {
            sql=  "select * from empdetail " ; //
            sqlConnection = DatabaseConnector.connectToDatabase();
            statment= sqlConnection.createStatement();
            employeeResultSet = statment.executeQuery(sql) ;
            
            if (employeeResultSet.next())
            {
                int i=1;
                int highestEmpNum =100 ;
                int newEmpNum ;
                while (employeeResultSet.next())
                {   
                    
                    
                    newEmpNum =Integer.parseInt(employeeResultSet.getString(i));
                    if(newEmpNum > highestEmpNum )
                    {
                        highestEmpNum = newEmpNum;
                        i++;
                        
                    }    
                   
               
                }
                
                highestEmpNum ++;
                String strHighestNum = String.valueOf(highestEmpNum);
                txtEmpNo.setText(strHighestNum);
                txtName.setText("");
                txtAddresse.setText("");
                txtSuburb.setText("");
                txtPostCode.setText("");
                txtPhone.setText("");
                txtMobile.setText("");
                txtEmail.setText("");    
                DatabaseConnector.closeConnection(sqlConnection);
                statment.close();
            }
            
     }
     catch (SQLException sqle)
     {
                showExceptionOptionPane(sqle.toString());
                
     }       
       

    }//GEN-LAST:event_btnNewActionPerformed

    public void showExceptionOptionPane(String strExcep)
    {
        exceptOptionPane.showMessageDialog(this,strExcep, "Error Messege", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel EmployeeDetailsPanel;
    private javax.swing.JLabel Name;
    private java.awt.Panel QueryPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JTextField btnDBDriver;
    private javax.swing.JTextField btnDBVersion;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnReportFile;
    private javax.swing.JButton btnRetrieve;
    private javax.swing.JButton btnSubmitQuery;
    private javax.swing.JTextField btnTblName;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JOptionPane exceptOptionPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel metaDataPanel;
    private javax.swing.JScrollPane paneTblCol;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtAddresse;
    private javax.swing.JTextArea txtAreaTblColumns;
    private javax.swing.JTextField txtDBType;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpNo;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumOfRecords;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPostCode;
    private javax.swing.JTextField txtQuery;
    private javax.swing.JTextField txtReportFile;
    private javax.swing.JTextField txtSuburb;
    // End of variables declaration//GEN-END:variables
}
