/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financialmanagement;

import DBLib.ConnectionLib;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Font;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author Minh Tân
 */
public class FinancialManagement extends javax.swing.JFrame {

    //declare variable
    private static Statement st;
    private static PreparedStatement pst;
    private static ResultSet rs;
    private CostModel cm = new CostModel();
    private Controller ctrler = new Controller();
    private CheckValidate chkValid = new CheckValidate();
    private boolean checkValue = true, checkdate = true, checkData = true;
    private boolean isTableClicked = false;          //check users have click to table
    Scanner cin = new Scanner(System.in);

    /**
     * Creates new form FinancialManagement
     */
    public FinancialManagement() {
        initComponents();
        designTable();
        this.setLocationRelativeTo(null);
        try {
            //connect to mysql
            Connection con = ConnectionLib.getConnection();
            System.out.println("Sucessful");
        } catch (SQLException ex) {
            Logger.getLogger(FinancialManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Design table
     */
    public void designTable() {
        //allocates memory for CellRender
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        //set 3 column text alignment in table to center
        cellRender.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < 3; i++) {
            tblFinancial.getColumnModel().getColumn(i).setCellRenderer(cellRender);
        }

        //change header's font and text
        JTableHeader tblHeader = tblFinancial.getTableHeader();
        tblHeader.setForeground(Color.BLACK);   //set foreground header to color Black
        tblHeader.setFont(new Font("Tamaho", Font.BOLD, 26)); //change font of header
        ((DefaultTableCellRenderer) tblHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    /**
     * load data from database into table
     *
     * @param model
     * @throws SQLException
     */
    private void ShowData(DefaultTableModel model) throws SQLException {
        ctrler.getAllFinance(calendarDate.getDate(), model);
        ctrler.showInOutcome(calendarDate.getDate(), lblShowIncome, lblShowOutcome, lblShowMoney);
    }

    /**
     * get ID on database from Index in table
     * @return
     * @throws SQLException
     * @throws NullPointerException 
     */
    private long getID() throws SQLException, NullPointerException {
        int index = tblFinancial.getSelectedRow();
        cm.Select(calendarDate.getDate());
        long id = cm.getIdFromTable(index);
        return id;
    }

    /**
     * get value on database from Index in table
     * @return
     * @throws SQLException 
     */
    private long getValue() throws SQLException {
        int index = tblFinancial.getSelectedRow();
        cm.Select(calendarDate.getDate());
        long value = cm.getValueFromTable(index);
        return value;
    }

    /**
     * check data from table, textFields
     * @return
     * @throws NullPointerException
     * @throws Exception 
     */
    public boolean checkData() throws NullPointerException, Exception {
        String value = txtInOutcome.getText();
        String description = txtDescription.getText();
        cm.Select(calendarDate.getDate());
        //iftable no have data then throw exception
        if (cm.getList().size() <= 0) {
            throw new NullPointerException("No have data on this day!\n"
                    + "Can't Update or Delete!");
        } else if (!isTableClicked || value.equals("") || description.equals("")) {
            //if users no have click to table then throw exeption
            throw new Exception("\"Please click on table to choose ID!\n");
        }
        return true;
    }

    /**
     * after insert, update or delete then clear on data in textFields
     */
    private void resetText() {
        //clear text
        txtDescription.setText("");
        txtInOutcome.setText("");
        lblShowID.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        tblFinancial = new javax.swing.JTable();
        pnlFinanceManagement = new javax.swing.JPanel();
        lblIncome = new javax.swing.JLabel();
        lblMoney = new javax.swing.JLabel();
        lblOutcome = new javax.swing.JLabel();
        lblShowIncome = new javax.swing.JLabel();
        lblShowOutcome = new javax.swing.JLabel();
        lblShowMoney = new javax.swing.JLabel();
        calendarDate = new com.toedter.calendar.JCalendar();
        pnlInput = new javax.swing.JPanel();
        lblInOutcome = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblDescription = new javax.swing.JLabel();
        txtInOutcome = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblShowID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Financial Management");
        setBackground(new java.awt.Color(0, 255, 0));
        setResizable(false);

        tblFinancial.setBackground(new java.awt.Color(51, 255, 51));
        tblFinancial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblFinancial.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        tblFinancial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "ID", "Money", "Note"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFinancial.setIntercellSpacing(new java.awt.Dimension(1, 4));
        tblFinancial.setRowHeight(30);
        tblFinancial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFinancialMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(tblFinancial);
        if (tblFinancial.getColumnModel().getColumnCount() > 0) {
            tblFinancial.getColumnModel().getColumn(0).setResizable(false);
            tblFinancial.getColumnModel().getColumn(1).setResizable(false);
            tblFinancial.getColumnModel().getColumn(2).setResizable(false);
        }

        pnlFinanceManagement.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Financial Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        lblIncome.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblIncome.setText("Total Income");

        lblMoney.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblMoney.setText("Total Money");

        lblOutcome.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblOutcome.setText("Total OutCome");

        lblShowIncome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblShowIncome.setForeground(new java.awt.Color(0, 0, 255));
        lblShowIncome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblShowOutcome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblShowOutcome.setForeground(new java.awt.Color(204, 0, 0));
        lblShowOutcome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblShowMoney.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblShowMoney.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlFinanceManagementLayout = new javax.swing.GroupLayout(pnlFinanceManagement);
        pnlFinanceManagement.setLayout(pnlFinanceManagementLayout);
        pnlFinanceManagementLayout.setHorizontalGroup(
            pnlFinanceManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinanceManagementLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlFinanceManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMoney, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFinanceManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFinanceManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblShowIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(lblShowOutcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblShowMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFinanceManagementLayout.setVerticalGroup(
            pnlFinanceManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinanceManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFinanceManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblShowIncome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFinanceManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblShowOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFinanceManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(lblShowMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        calendarDate.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        calendarDate.setDecorationBackgroundColor(new java.awt.Color(0, 204, 0));
        calendarDate.setDecorationBordersVisible(true);
        calendarDate.setFocusCycleRoot(true);
        calendarDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        calendarDate.setTodayButtonVisible(true);
        calendarDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarDatePropertyChange(evt);
            }
        });

        pnlInput.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblInOutcome.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblInOutcome.setText("In/Outcome");

        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(97, 41));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblDescription.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblDescription.setText("Description");

        txtInOutcome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        txtDescription.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        lblID.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("ID");

        lblShowID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblShowID.setForeground(new java.awt.Color(0, 204, 0));

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblInOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDescription, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtInOutcome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlInputLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblShowID, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblShowID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInOutcome)
                    .addComponent(txtInOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFinanceManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendarDate, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(calendarDate, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFinanceManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * event calendar has been changed
     *
     * @param evt
     */
    private void calendarDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarDatePropertyChange
        try {
            System.out.println(calendarDate.getDate());
            DefaultTableModel model = (DefaultTableModel) tblFinancial.getModel();
            ShowData(model);
        } catch (SQLException ex) {
            Logger.getLogger(FinancialManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_calendarDatePropertyChange

    /**
     * Insert data into database
     *
     * @param evt
     */
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        String inOutCome = txtInOutcome.getText();
        String description = txtDescription.getText();
        java.util.Date date = calendarDate.getDate();
        //format date to String
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String Date = sf.format(date);
        System.out.println(date);
        try {
            //check data
            checkValue = chkValid.checkMoneyInsert(date, Long.parseLong(inOutCome));
            checkdate = chkValid.checkdate(date);
            //if users choose date in future
            if (!checkdate) {
                JOptionPane.showMessageDialog(this, "You can't Insert a day in the future!",
                        "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (!checkValue) {
                //if insert invalid value
                JOptionPane.showMessageDialog(this, "Total outcome can't be greater than total income!",
                        "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                //insert to database
                cm.insert(description, Integer.parseInt(inOutCome), Date);
                //load table again
                DefaultTableModel model = (DefaultTableModel) tblFinancial.getModel();
                ShowData(model);
                
                //notify insert successful
                JOptionPane.showMessageDialog(this, "Insert Successful", "Insert",
                        JOptionPane.INFORMATION_MESSAGE);
                //clear text
                resetText();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "\"Description\" and \"In/outcome\" can't be empty!\n"
                    + "And \"In/outcome\" must be a number!",
                    "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    /**
     * Update data on database
     * @param evt 
     */
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            //get data
            long id = getID();
            long valueUpdate = getValue();
            String description = txtDescription.getText();
            String value = txtInOutcome.getText();
            java.util.Date date = calendarDate.getDate();
            //check data 
            checkValue = chkValid.checkMoneyUpdate(date, valueUpdate,
                    Long.parseLong(value));
            checkdate = chkValid.checkdate(date);
            //if users choose date in future
            if (!checkdate) {
                JOptionPane.showMessageDialog(this, "You can't Update a day in the future!",
                        "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (!checkValue) {
                //if users update invalid value
                JOptionPane.showMessageDialog(this, "Total outcome can't be greater than total income!",
                        "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                //update data to mysql
                ctrler.UpdateData(id, description, Integer.parseInt(value), date);
                //load table again
                DefaultTableModel model = (DefaultTableModel) tblFinancial.getModel();
                ShowData(model);
                
                //notify update sucessfull
                JOptionPane.showMessageDialog(this, "Update Successful", "Update",
                        JOptionPane.INFORMATION_MESSAGE);
                //clear text
                resetText();
            }
        } catch (NullPointerException ex) {
               JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Warning", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
//            Logger.getLogger(FinancialManagement.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "\"Description\" and \"In/outcome\" can't be empty!\n"
                    + "And \"In/outcome\" must be a number!",
                    "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * Delete data on database
     * @param evt 
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            //get data
            long id = getID();
            String description = txtDescription.getText();
            String value = txtInOutcome.getText();
            //check data
            checkValue = checkData();
            //delete data
            ctrler.DeleteData(id);
            //lead table again
            DefaultTableModel model = (DefaultTableModel) tblFinancial.getModel();
            ShowData(model);
            
            //notify delete sucessful
            JOptionPane.showMessageDialog(this, "Delete Successful", "Delete",
                    JOptionPane.INFORMATION_MESSAGE);
            //clear text
            resetText();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Warning", JOptionPane.ERROR_MESSAGE);
//            Logger.getLogger(FinancialManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * event users click to table
     * @param evt 
     */
    private void tblFinancialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFinancialMouseClicked
        try {
            isTableClicked = true;
            System.out.println("done");
            cm.Select(calendarDate.getDate());
            //get row table
            JTable source = (JTable) evt.getSource();
            int rowIndex = source.rowAtPoint(evt.getPoint());
            long id = cm.getIdFromTable(rowIndex);
            //set value for txtFields and label
            txtInOutcome.setText(String.valueOf(ctrler.getList().get(rowIndex).getC_value()));
            txtDescription.setText(ctrler.getList().get(rowIndex).getC_description());
            lblShowID.setText(String.valueOf(rowIndex + 1));
            System.out.println(rowIndex);
            System.out.println(id);
            System.out.println(isTableClicked);
        } catch (SQLException ex) {
            Logger.getLogger(FinancialManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblFinancialMouseClicked

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
            java.util.logging.Logger.getLogger(FinancialManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinancialManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinancialManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinancialManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinancialManagement().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JCalendar calendarDate;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblInOutcome;
    private javax.swing.JLabel lblIncome;
    private javax.swing.JLabel lblMoney;
    private javax.swing.JLabel lblOutcome;
    private javax.swing.JLabel lblShowID;
    private javax.swing.JLabel lblShowIncome;
    private javax.swing.JLabel lblShowMoney;
    private javax.swing.JLabel lblShowOutcome;
    private javax.swing.JPanel pnlFinanceManagement;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTable tblFinancial;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtInOutcome;
    // End of variables declaration//GEN-END:variables
}
