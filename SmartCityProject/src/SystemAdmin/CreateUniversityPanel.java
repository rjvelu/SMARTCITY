/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package SystemAdmin;

/**
 *
 * @author Ruthvik Garlapati
 */

import Directories.CityDirectory;
import Directories.UserCoordinatesDirectory;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.UserCoordinates;
public class CreateUniversityPanel extends javax.swing.JPanel {
Connection connection;
CityDirectory cityDir;
UserCoordinatesDirectory usercordDir;
UserCoordinates newOne;
    public CreateUniversityPanel(Connection connection,CityDirectory cityDir,UserCoordinatesDirectory usercordDir) {
        initComponents();
        this.connection = connection;
        this.cityDir = cityDir;
        this.usercordDir = usercordDir;
         newOne = usercordDir.addNew();
         populateUniversities();
         cordfld.setEditable(false);
           }
private void populateUniversities(){
         DefaultTableModel model = (DefaultTableModel) universitydropdown.getModel();
          try{
              ResultSet rs = cityDir.getApprovedBuildings();
              model.setRowCount(0);
               Object row[] = new Object[6];
      while(rs.next()) {
          if(rs.getString("type").equals("University")){
            row[0] = rs.getString("application_id");
            row[1] = rs.getString("name");
            row[2] = rs.getString("owner");
            row[3] = rs.getString("location");
            row[4] = rs.getString("lat");
              row[5] = rs.getString("lon");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        universitydropdown = new javax.swing.JTable();
        namefld = new javax.swing.JTextField();
        deanfld = new javax.swing.JTextField();
        locfld = new javax.swing.JTextField();
        cordfld = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        stloclbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add University");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 230, -1));

        universitydropdown.setBackground(new java.awt.Color(204, 255, 255));
        universitydropdown.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "University Id", "Name", "Dean", "Location", "Latitude", "Longitude"
            }
        ));
        jScrollPane1.setViewportView(universitydropdown);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 1011, 190));

        namefld.setBackground(new java.awt.Color(204, 255, 255));
        add(namefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 316, 233, -1));

        deanfld.setBackground(new java.awt.Color(204, 255, 255));
        add(deanfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 357, 233, -1));

        locfld.setBackground(new java.awt.Color(204, 255, 255));
        add(locfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 398, 233, -1));

        cordfld.setBackground(new java.awt.Color(204, 255, 255));
        add(cordfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 439, 233, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 319, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dean :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 360, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Location :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 401, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Co-Ordinates :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 442, -1, -1));

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 494, 110, 40));

        stloclbl.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        stloclbl.setForeground(new java.awt.Color(255, 255, 255));
        stloclbl.setText("Set Location");
        stloclbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stloclblMouseClicked(evt);
            }
        });
        add(stloclbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 442, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/university.jpeg"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 630));
    }// </editor-fold>//GEN-END:initComponents
String name,dean,location,cord;

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
name = namefld.getText();
dean = deanfld.getText();
location = locfld.getText();
newOne.setUsername(name);
        cityDir.addUniversityBySystemAdmin(name, dean, location, newOne.getLat(), newOne.getLon());
        JOptionPane.showMessageDialog(this, "Added Successfully");
        populateUniversities();
          namefld.setText("");
        deanfld.setText("");
        locfld.setText("");
        cordfld.setText("");
    }//GEN-LAST:event_SaveButtonActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locfld;
    private javax.swing.JTextField namefld;
    private javax.swing.JLabel stloclbl;
    private javax.swing.JTable universitydropdown;
    // End of variables declaration//GEN-END:variables
}
