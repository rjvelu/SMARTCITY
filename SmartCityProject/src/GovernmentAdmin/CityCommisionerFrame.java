
package GovernmentAdmin;
import Directories.CityDirectory;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import smartcityproject.MainJFrame;

public class CityCommisionerFrame extends javax.swing.JFrame {

  Connection connection;
  String user;
  CityDirectory cityDir;
    public CityCommisionerFrame(Connection connection,String user,CityDirectory cityDir) {
        initComponents();
        this.connection = connection;
        this.user  = user;
        this.cityDir = cityDir;
        populateApplications();
        USernameLbl.setText(user);
    }

    private CityCommisionerFrame() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

  private void populateApplications(){
      
       DefaultTableModel model = (DefaultTableModel) ApplicationsTable.getModel();
          try{
              ResultSet rs = cityDir.getAllApplications();
              model.setRowCount(0);
      while(rs.next()) {
            Object row[] = new Object[7];
             row[0] = rs.getString(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            row[4] = rs.getString(5);
            row[5] = rs.getString(9);
              row[6] = (rs.getString(6)+","+rs.getString(7));
            model.addRow(row);
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
        LogoutButton = new javax.swing.JLabel();
        USernameLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ApplicationsTable = new javax.swing.JTable();
        status = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        UpdateStatus = new javax.swing.JButton();
        ViewonMap = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Hi!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 15, 180, 70));

        LogoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        LogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutButtonMouseClicked(evt);
            }
        });
        getContentPane().add(LogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, -1, -1));

        USernameLbl.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        getContentPane().add(USernameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 19, 371, 35));

        ApplicationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Application Id", "Name", "Type", "Owner", "Location", "Application Status", "Co-Ordinates"
            }
        ));
        ApplicationsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(ApplicationsTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 979, 184));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Please Select-", "In-review", "Approved", "Rejected" }));
        status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 214, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("Status :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        UpdateStatus.setBackground(new java.awt.Color(255, 204, 204));
        UpdateStatus.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        UpdateStatus.setText("Update");
        UpdateStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        UpdateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateStatusActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 140, 30));

        ViewonMap.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        ViewonMap.setForeground(new java.awt.Color(255, 0, 0));
        ViewonMap.setText("View Location on Map");
        ViewonMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewonMapActionPerformed(evt);
            }
        });
        getContentPane().add(ViewonMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, 242, 54));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/city board2.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateStatusActionPerformed
int index1 = ApplicationsTable.getSelectedRow();
        if (index1 < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Application....!");
            return;
        }
         DefaultTableModel model2 = (DefaultTableModel) ApplicationsTable.getModel();
        String id  = String.valueOf(model2.getValueAt(index1, 0));
        String stat = String.valueOf(status.getSelectedItem());
        cityDir.UpdateStatus(id, stat);
        JOptionPane.showMessageDialog(this, "Update Success");
        populateApplications();
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateStatusActionPerformed

    private void LogoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButtonMouseClicked

MainJFrame frame = new MainJFrame();
frame.setVisible(true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutButtonMouseClicked

    private void ViewonMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewonMapActionPerformed
int index1 = ApplicationsTable.getSelectedRow();
        if (index1 < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Application....!");
            return;
        }
         DefaultTableModel model2 = (DefaultTableModel) ApplicationsTable.getModel();
        String cord  = String.valueOf(model2.getValueAt(index1, 6));
        System.out.println(cord);
        CityMapsFrame frame = new CityMapsFrame(cord);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
    }//GEN-LAST:event_ViewonMapActionPerformed

  
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
            java.util.logging.Logger.getLogger(CityCommisionerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CityCommisionerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CityCommisionerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CityCommisionerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CityCommisionerFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ApplicationsTable;
    private javax.swing.JLabel LogoutButton;
    private javax.swing.JLabel USernameLbl;
    private javax.swing.JButton UpdateStatus;
    private javax.swing.JButton ViewonMap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
