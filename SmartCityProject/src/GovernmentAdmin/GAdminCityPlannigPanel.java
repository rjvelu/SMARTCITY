
package GovernmentAdmin;

import Directories.CityDirectory;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import smartcityproject.MainJFrame;


public class GAdminCityPlannigPanel extends javax.swing.JPanel {

  

    String user;
    CityDirectory cityDir;
    public GAdminCityPlannigPanel(String user,CityDirectory cityDir) {
        initComponents();
       this.user = user;
       this.cityDir = cityDir;
       populateApplications();
    }

     private void populateApplicationsByType(String type){
      
       DefaultTableModel model = (DefaultTableModel) ApplicationsTable.getModel();
          try{
              ResultSet rs = cityDir.getAllApplications();
              model.setRowCount(0);
               Object row[] = new Object[8];
      while(rs.next()) {
           if(rs.getString("type").equals(type)){
             row[0] = rs.getString(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            row[4] = rs.getString(8);
            row[5] = rs.getString(5);
            row[6] = rs.getString(9);
              row[7] = (rs.getString(6)+","+rs.getString(7));
            model.addRow(row);
           }
        }
          }
          catch(Exception e){
              System.out.println(e);
          }
  }
     private void populateApplications(){
      
       DefaultTableModel model = (DefaultTableModel) ApplicationsTable.getModel();
          try{
              ResultSet rs = cityDir.getAllApplications();
              model.setRowCount(0);
      while(rs.next()) {
            Object row[] = new Object[8];
             row[0] = rs.getString(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            row[4] = rs.getString(8);
            row[5] = rs.getString(5);
            row[6] = rs.getString(9);
              row[7] = (rs.getString(6)+","+rs.getString(7));
            model.addRow(row);
        }
          }
          catch(Exception e){
              System.out.println(e);
          }
  }
     
     
     private void populateAsignees(String role){
         CityCommDropDown.removeAllItems();
         try{
             ResultSet rs = cityDir.getUserData();
             while(rs.next()){
                 if(rs.getString("role").equals(role)){
                     CityCommDropDown.addItem(rs.getString("username"));
                 }
             }
         }
         catch(Exception e){
             System.out.println(e);
         }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ApplicationsTable = new javax.swing.JTable();
        CityCommDropDown = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        uasignee = new javax.swing.JButton();
        UpdateButton1 = new javax.swing.JButton();
        tasignee = new javax.swing.JButton();
        casignee = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 51));
        setForeground(new java.awt.Color(0, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("City  Planning Applications");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 500, -1));

        ApplicationsTable.setBackground(new java.awt.Color(204, 255, 255));
        ApplicationsTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ApplicationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Application Id", "Name", "Type", "Owner", "Asignee", "Location", "Application Status", "Co-Ordinates"
            }
        ));
        ApplicationsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jScrollPane1.setViewportView(ApplicationsTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1030, 180));

        CityCommDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Please Select-" }));
        CityCommDropDown.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(CityCommDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 234, 57));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Asignee :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 100, -1));

        uasignee.setBackground(new java.awt.Color(204, 204, 255));
        uasignee.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        uasignee.setText("Load University Data");
        uasignee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uasigneeMouseClicked(evt);
            }
        });
        add(uasignee, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, -1, 40));

        UpdateButton1.setBackground(new java.awt.Color(204, 204, 255));
        UpdateButton1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        UpdateButton1.setText("Update");
        UpdateButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateButton1MouseClicked(evt);
            }
        });
        add(UpdateButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 140, 40));

        tasignee.setBackground(new java.awt.Color(204, 204, 255));
        tasignee.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        tasignee.setText("Load Theatre Data");
        tasignee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tasigneeMouseClicked(evt);
            }
        });
        add(tasignee, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 270, 40));

        casignee.setBackground(new java.awt.Color(204, 204, 255));
        casignee.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        casignee.setText("Load Company Data");
        casignee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                casigneeMouseClicked(evt);
            }
        });
        add(casignee, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 300, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/city planning2.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -330, -1, 1460));
    }// </editor-fold>//GEN-END:initComponents

    private void tasigneeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tasigneeMouseClicked
populateApplicationsByType("Theatre");
populateAsignees("citycomm");

        // TODO add your handling code here:
    }//GEN-LAST:event_tasigneeMouseClicked

    private void UpdateButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButton1MouseClicked
int index1 = ApplicationsTable.getSelectedRow();
        if (index1 < 0) {
            JOptionPane.showMessageDialog(this, "Please select a application");
            return;
        }
         DefaultTableModel model2 = (DefaultTableModel) ApplicationsTable.getModel();
        String id  = String.valueOf(model2.getValueAt(index1, 0));
        String uname = String.valueOf(CityCommDropDown.getSelectedItem());
        
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateButton1MouseClicked

    private void casigneeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_casigneeMouseClicked
       populateApplicationsByType("Company");
       populateAsignees("compadmin");
        // TODO add your handling code here:
    }//GEN-LAST:event_casigneeMouseClicked

    private void uasigneeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uasigneeMouseClicked
populateApplicationsByType("University");
populateAsignees("uniadmin");
        // TODO add your handling code here:
    }//GEN-LAST:event_uasigneeMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

MainJFrame frame = new MainJFrame();
frame.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ApplicationsTable;
    private javax.swing.JComboBox<String> CityCommDropDown;
    private javax.swing.JButton UpdateButton1;
    private javax.swing.JButton casignee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tasignee;
    private javax.swing.JButton uasignee;
    // End of variables declaration//GEN-END:variables
}
