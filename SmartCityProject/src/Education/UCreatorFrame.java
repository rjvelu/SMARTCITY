/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Education;

import Directories.CityDirectory;
import Directories.UserCoordinatesDirectory;
import SystemAdmin.MapsFrame;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.UserCoordinates;
import smartcityproject.MainJFrame;

/**
 *
 * @author Ruthvik Garlapati
 */
public class UCreatorFrame extends javax.swing.JFrame {

    /**
     * Creates new form UCreatorFrame
     */
    Connection connection;
CityDirectory cityDir;
UserCoordinatesDirectory usercordDir;
UserCoordinates newOne;
String user;
    public UCreatorFrame(String user,Connection connection,CityDirectory cityDir,UserCoordinatesDirectory usercordDir) {
        initComponents();
          this.usercordDir = usercordDir;
          this.cityDir = cityDir;
         newOne = usercordDir.addNew();
         
         this.user = user;
         cordfld.setEditable(false);
         unamelbl.setText(user);
         populateUniversities();
    }

    private UCreatorFrame() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void populateUniversities(){
         DefaultTableModel model = (DefaultTableModel) universitydropdown1.getModel();
         System.out.println(user);
          try{
              ResultSet rs = cityDir.getAllApplicationsByAsignee(user);
              model.setRowCount(0);
               Object row[] = new Object[7];
      while(rs.next()) {
          if(rs.getString("type").equals("University")){
            row[0] = rs.getString("application_id");
            row[1] = rs.getString("name");
            row[2] = rs.getString("owner");
            row[3] = rs.getString("location");
            row[4] = rs.getString("lat");
              row[5] = rs.getString("lon");
              row[6] = rs.getString("application_status");
            model.addRow(row);
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
        jLabel2 = new javax.swing.JLabel();
        unamelbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        universitydropdown1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        namefld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        deanfld = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        locfld = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cordfld = new javax.swing.JTextField();
        stloclbl = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-logout-rounded-70.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1141, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel2.setText("Hi");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 15, -1, -1));

        unamelbl.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        unamelbl.setText("jLabel3");
        getContentPane().add(unamelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 15, -1, -1));

        universitydropdown1.setBackground(new java.awt.Color(204, 255, 255));
        universitydropdown1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "University Id", "Name", "Dean", "Location", "Latitude", "Longitude", "Status"
            }
        ));
        jScrollPane2.setViewportView(universitydropdown1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 1011, 190));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Name :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, -1, -1));

        namefld.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(namefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 240, 40));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Dean :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        deanfld.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(deanfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 357, 240, 40));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("Location :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, -1, -1));

        locfld.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(locfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 240, 40));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setText("Co-Ordinates :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, -1, -1));

        cordfld.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(cordfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, 240, 40));

        stloclbl.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        stloclbl.setText("Set Location");
        stloclbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stloclblMouseClicked(evt);
            }
        });
        getContentPane().add(stloclbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, -1, -1));

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 570, 110, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/university.jpeg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1210, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stloclblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stloclblMouseClicked
        MapsFrame frame  = new MapsFrame(newOne);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                cordfld.setText(newOne.getLat()+","+newOne.getLon());
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_stloclblMouseClicked
String name,dean,location,cord;
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        name = namefld.getText();
        dean = deanfld.getText();
        location = locfld.getText();
        newOne.setUsername(name);
        cityDir.addUniversity(name, dean, location, newOne.getLat(), newOne.getLon(),user);
        JOptionPane.showMessageDialog(this, "Added Successfully");
        populateUniversities();
        namefld.setText("");
        deanfld.setText("");
        locfld.setText("");
        cordfld.setText("");
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
MainJFrame frame = new MainJFrame();
frame.setVisible(true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(UCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UCreatorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField cordfld;
    private javax.swing.JTextField deanfld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField locfld;
    private javax.swing.JTextField namefld;
    private javax.swing.JLabel stloclbl;
    private javax.swing.JLabel unamelbl;
    private javax.swing.JTable universitydropdown1;
    // End of variables declaration//GEN-END:variables
}
