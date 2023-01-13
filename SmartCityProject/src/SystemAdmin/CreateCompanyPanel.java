/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package SystemAdmin;

import Directories.CityDirectory;
import Directories.CompanyDirectory;
import Directories.UserCoordinatesDirectory;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.UserCoordinates;
public class CreateCompanyPanel extends javax.swing.JPanel {

  
    Connection connection;
    CompanyDirectory compdir;
    CityDirectory citydir;
  UserCoordinatesDirectory usercordDir;
UserCoordinates newOne;
    public CreateCompanyPanel(Connection connection,CompanyDirectory Dir,CityDirectory citydir,UserCoordinatesDirectory usercordDir) {
        initComponents();
        this.connection = connection;
        this.compdir = compdir;
        this.citydir = citydir;
          this.usercordDir = usercordDir;
         newOne = usercordDir.addNew();
         cordfld.setEditable(false);
         GreenTick.setVisible(false);
            RedTick.setVisible(false);
        NameListener();
        populateCompanies();
    }

    
    private void populateCompanies(){
         DefaultTableModel model = (DefaultTableModel) CompanyData.getModel();
          try{
              ResultSet rs = citydir.getApprovedBuildings();
              model.setRowCount(0);
               Object row[] = new Object[6];
      while(rs.next()) {
          if(rs.getString("type").equals("Company")){
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
     private boolean CompanyExists(){
        try{
            ResultSet rs = citydir.getApprovedBuildings();
            while(rs.next()) {
          if(rs.getString("name").equals(namefld.getText()))
              return false;
        }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return true;
    }
  private void NameListener(){
    DocumentListener documentListener = new DocumentListener() {
      @Override
      public void changedUpdate(DocumentEvent documentEvent) {
         if(CompanyExists()){
            GreenTick.setVisible(true);
            RedTick.setVisible(false);
          }else{
              RedTick.setVisible(true);
              GreenTick.setVisible(false);
          }
      }
      @Override
      public void insertUpdate(DocumentEvent documentEvent) {
          
          if(CompanyExists()){
            GreenTick.setVisible(true);
            RedTick.setVisible(false);
          }else{
              RedTick.setVisible(true);
              GreenTick.setVisible(false);
          }
      }
      @Override
      public void removeUpdate(DocumentEvent documentEvent) {
           if(CompanyExists()){
            GreenTick.setVisible(true);
            RedTick.setVisible(false);
          }else{
              RedTick.setVisible(true);
              GreenTick.setVisible(false);
          }
      }
    };
    namefld.getDocument().addDocumentListener(documentListener);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CompanyData = new javax.swing.JTable();
        namefld = new javax.swing.JTextField();
        locfld = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cordfld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        GreenTick = new javax.swing.JLabel();
        RedTick = new javax.swing.JLabel();
        ownerfld = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Add Company");

        CompanyData.setBackground(new java.awt.Color(255, 204, 153));
        CompanyData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Company Id", "Name", "Owner", "Location", "Latitude", "Longitude"
            }
        ));
        jScrollPane1.setViewportView(CompanyData);

        namefld.setBackground(new java.awt.Color(255, 204, 153));

        locfld.setBackground(new java.awt.Color(255, 204, 153));

        SaveButton.setBackground(new java.awt.Color(255, 204, 153));
        SaveButton.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Name :");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Owner :");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Location :");

        cordfld.setBackground(new java.awt.Color(255, 204, 153));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Co-Ordinates :");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("Set Location");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        GreenTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-approval-25.png"))); // NOI18N

        RedTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cross-mark-25.png"))); // NOI18N

        ownerfld.setBackground(new java.awt.Color(255, 204, 153));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add company.jpeg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cordfld, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(locfld)
                            .addComponent(namefld)
                            .addComponent(ownerfld))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(GreenTick)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RedTick))))
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(285, 285, 285))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(namefld, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(GreenTick))
                                    .addComponent(RedTick))
                                .addGap(53, 53, 53))
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(ownerfld, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locfld, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cordfld, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(47, 47, 47)
                        .addComponent(SaveButton)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

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
    }//GEN-LAST:event_jLabel6MouseClicked
    String name,dean,location,cord;
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
name = namefld.getText();
dean = ownerfld.getText();
location = locfld.getText();
newOne.setUsername(name);
        citydir.addCompanyBySystemAdmin(name, dean, location, newOne.getLat(), newOne.getLon());
        JOptionPane.showMessageDialog(this, "Added Successfully");
        populateCompanies();
        
        namefld.setText("");
        ownerfld.setText("");
        locfld.setText("");
        cordfld.setText("");
         GreenTick.setVisible(false);
            RedTick.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CompanyData;
    private javax.swing.JLabel GreenTick;
    private javax.swing.JLabel RedTick;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField cordfld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locfld;
    private javax.swing.JTextField namefld;
    private javax.swing.JTextField ownerfld;
    // End of variables declaration//GEN-END:variables
}
