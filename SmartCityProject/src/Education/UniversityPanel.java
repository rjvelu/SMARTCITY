/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Education;

import Directories.EducationDirectory;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ruthvik Garlapati
 */

public class UniversityPanel extends javax.swing.JPanel {
EducationDirectory edudir;
String user;

 public  UniversityPanel(EducationDirectory edudir,String user) {
        initComponents();
        this.edudir = edudir;
        this.user = user;
        populateUniversities();
        populateApplications();
    }
 
     private void populateApplications(){
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
          try{
              ResultSet rs = edudir.get_university_applications(user);
              model.setRowCount(0);
              Object row[] = new Object[4];
      while(rs.next()) {
            row[0] = rs.getString("uni_apply_id");
            row[1] = rs.getString("university");
            row[2] = rs.getString("course");
            row[3] = rs.getString("status");
            model.addRow(row);
        }
          }
          catch(Exception e){
              System.out.println(e);
          }
    }
    
 
 private void populateCourses(String uni){
    CourseDropDown.removeAllItems();
     try{
         ResultSet rs = edudir.getCourses(uni);
         while(rs.next()){
         CourseDropDown.addItem(rs.getString("coursename"));
         }
     }
     catch(Exception e){
         System.out.println(e);
         
     }
 }
private void populateUniversities(){

     UniversityDropDown.removeAllItems();
     try{
         ResultSet rs = edudir.getUniversities();
         while(rs.next()){
         UniversityDropDown.addItem(rs.getString("name"));
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
        jTable1 = new javax.swing.JTable();
        UniversityDropDown = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        CourseDropDown = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ApplyButton = new javax.swing.JButton();
        WithdrawButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("University Panel");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Application Id", "University", "Course", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 999, 232));

        UniversityDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UniversityDropDownActionPerformed(evt);
            }
        });
        add(UniversityDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 252, 42));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("University :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        CourseDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseDropDownActionPerformed(evt);
            }
        });
        add(CourseDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 252, 41));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, -1, -1));

        ApplyButton.setText("Apply");
        ApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyButtonActionPerformed(evt);
            }
        });
        add(ApplyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, 134, 34));

        WithdrawButton.setText("View Course Desc");
        WithdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WithdrawButtonActionPerformed(evt);
            }
        });
        add(WithdrawButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, 160, 34));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/university.jpeg"))); // NOI18N
        jLabel4.setText("jLabel4");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 630));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel5");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
double lat,lon;
    private void ApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyButtonActionPerformed
String uni  = String.valueOf(UniversityDropDown.getSelectedItem());
String course = String.valueOf(CourseDropDown.getSelectedItem());
edudir.insert_university_application(uni, course, user);
edudir.insert_purchase_university(user, uni, lat, lon, "Applied at ");
JOptionPane.showMessageDialog(this, "Application Submitted");
populateApplications();
        // TODO add your handling code here:
    }//GEN-LAST:event_ApplyButtonActionPerformed

    private void CourseDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseDropDownActionPerformed
    }//GEN-LAST:event_CourseDropDownActionPerformed

    private void UniversityDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UniversityDropDownActionPerformed

        String uni  = String.valueOf(UniversityDropDown.getSelectedItem());
populateCourses(uni);
try{
    ResultSet rs = edudir.getCord(uni);
    if(rs.next()){

    lat = rs.getDouble("lat");
    lon = rs.getDouble("lon");
    }
}
catch(Exception e){
    System.out.println(e);
}
        // TODO add your handling code here:
    }//GEN-LAST:event_UniversityDropDownActionPerformed

    private void WithdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WithdrawButtonActionPerformed
String uni  = String.valueOf(UniversityDropDown.getSelectedItem());
String course = String.valueOf(CourseDropDown.getSelectedItem());
        String  path = edudir.getCourseFile(course, uni);
    try {
        Desktop.getDesktop().open(new java.io.File(path));
       
    } catch (IOException ex) {
      System.out.println(ex);
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_WithdrawButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplyButton;
    private javax.swing.JComboBox<String> CourseDropDown;
    private javax.swing.JComboBox<String> UniversityDropDown;
    private javax.swing.JButton WithdrawButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
