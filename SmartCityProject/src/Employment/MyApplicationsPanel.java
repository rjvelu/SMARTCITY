/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Employment;
import java.sql.ResultSet;
import Directories.CompanyDirectory;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MyApplicationsPanel extends javax.swing.JPanel {

    CompanyDirectory compDir;
  Connection connection;
  String user;
    public MyApplicationsPanel(CompanyDirectory compDir,Connection connection,String user) {
        initComponents();
        this.compDir = compDir;
       this.user = user;
        this.connection = connection;
        populateCompanies();
        populateJobs();
    }
    private void populateJobs(){
          DefaultTableModel model = (DefaultTableModel) ApplicationsTable.getModel();
          try{
              ResultSet rs = compDir.get_company_applications(user);
              model.setRowCount(0);
              Object row[] = new Object[4];
      while(rs.next()) {
            
            row[0] = rs.getString("comp_apply_id");
            row[1] = rs.getString("company");
            row[2] = rs.getString("role");
            row[3] = rs.getString("status");
            model.addRow(row);
        }
          }
          catch(Exception e){
              
          }
        
    }
    private void populateCompanies(){
        CompaniesDropDown.removeAllItems();
        try { 
              ResultSet  compData;
            compData = compDir.getCompanies();
               while(compData.next()){
                CompaniesDropDown.addItem(compData.getString("name"));
            }} catch (SQLException ex) {
           System.out.println(ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ApplicationsTable = new javax.swing.JTable();
        CompaniesDropDown = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JobsDropDown = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ApplyButton = new javax.swing.JButton();
        BackgroundIMage = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Pristina", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("User Employement Panel");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 760, -1));

        ApplicationsTable.setBackground(new java.awt.Color(255, 204, 204));
        ApplicationsTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ApplicationsTable.setForeground(new java.awt.Color(255, 51, 51));
        ApplicationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Application Id", "Company", "Role", "Status"
            }
        ));
        ApplicationsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(ApplicationsTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 916, 193));

        CompaniesDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Please select an option-" }));
        CompaniesDropDown.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        CompaniesDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompaniesDropDownActionPerformed(evt);
            }
        });
        add(CompaniesDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 264, 38));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Company :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 110, 70));

        JobsDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Please select an option-" }));
        JobsDropDown.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JobsDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JobsDropDownActionPerformed(evt);
            }
        });
        add(JobsDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 264, 38));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Jobs :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 90, 40));

        ApplyButton.setBackground(new java.awt.Color(255, 204, 204));
        ApplyButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ApplyButton.setText("Apply");
        ApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyButtonActionPerformed(evt);
            }
        });
        add(ApplyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 144, 39));

        BackgroundIMage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employs2.jpeg"))); // NOI18N
        add(BackgroundIMage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1090, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void JobsDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JobsDropDownActionPerformed

    }//GEN-LAST:event_JobsDropDownActionPerformed

    private void CompaniesDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompaniesDropDownActionPerformed
JobsDropDown.removeAllItems();
String company = String.valueOf( CompaniesDropDown.getSelectedItem());
 try {
  ResultSet   compData = compDir.getJobs(company);
               while(compData.next()){
                JobsDropDown.addItem(compData.getString("role"));
            }} catch (SQLException ex) {
           System.out.println(ex);
        }
 try{
    ResultSet rs = compDir.getCord(company);
    if(rs.next()){

    lat = rs.getDouble("lat");
    lon = rs.getDouble("lon");
    }
}
catch(Exception e){
    System.out.println(e);
}
    }//GEN-LAST:event_CompaniesDropDownActionPerformed
String comp,job;
double lat,lon;
    private void ApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyButtonActionPerformed
comp = String.valueOf(CompaniesDropDown.getSelectedItem());
job = String.valueOf(JobsDropDown.getSelectedItem());
compDir.newApplicationToCompany(user, comp, job);
compDir.insert_purchase_university(user, comp, lat, lon, "Applied at ");
     JOptionPane.showMessageDialog(this, "Application Submitted");
        populateJobs();
    }//GEN-LAST:event_ApplyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ApplicationsTable;
    private javax.swing.JButton ApplyButton;
    private javax.swing.JLabel BackgroundIMage;
    private javax.swing.JComboBox<String> CompaniesDropDown;
    private javax.swing.JComboBox<String> JobsDropDown;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
