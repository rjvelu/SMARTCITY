/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package SystemAdmin;

import Directories.CityDirectory;
import Directories.EducationDirectory;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
public class CreateCoursesPanel extends javax.swing.JPanel {

   Connection connection;
   EducationDirectory edudir;
   CityDirectory citydir;
    public CreateCoursesPanel(Connection connection,EducationDirectory edudir,CityDirectory citydir) {
        initComponents();
        this.connection = connection;
        this.edudir = edudir;
        this.citydir = citydir;
        populateApplications();
        populateUni();
    }

    
    private void populateUni(){
        unidropdown.removeAllItems();
        try{
            ResultSet rs = citydir.getApprovedBuildings();
            while(rs.next()){
                if(rs.getString("type").equals("University")){
                    unidropdown.addItem(rs.getString("name"));
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    private void populateApplications(){
         DefaultTableModel model = (DefaultTableModel) CourseData.getModel();
          try{
              ResultSet rs = edudir.getCourses();
              model.setRowCount(0);
      while(rs.next()) {
            Object row[] = new Object[8];
             row[0] = rs.getString("application_id");
            row[1] = rs.getString("coursename");
            row[2] = rs.getString("professor");
            row[3] = rs.getString("university");
            row[4] = rs.getString("dayofweek");
            row[5] = rs.getString("coursedesc");
              row[6] = rs.getString("app_status");
               row[7] = rs.getString("applied_date");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        CourseData = new javax.swing.JTable();
        unidropdown = new javax.swing.JComboBox<>();
        namefld = new javax.swing.JTextField();
        proffld = new javax.swing.JTextField();
        dowfld = new javax.swing.JComboBox<>();
        UploadButton = new javax.swing.JButton();
        filelbl = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Courses");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 200, -1));

        CourseData.setBackground(new java.awt.Color(204, 255, 255));
        CourseData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Course Id", "Name", "Professor", "University", "Day of Week", "Descriprtion Pdf", "Status"
            }
        ));
        jScrollPane1.setViewportView(CourseData);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 119, 987, 174));

        unidropdown.setBackground(new java.awt.Color(204, 255, 255));
        unidropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(unidropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 192, -1));

        namefld.setBackground(new java.awt.Color(204, 255, 255));
        add(namefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 192, -1));

        proffld.setBackground(new java.awt.Color(204, 255, 255));
        add(proffld, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 192, -1));

        dowfld.setBackground(new java.awt.Color(204, 255, 255));
        dowfld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        add(dowfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, 192, -1));

        UploadButton.setBackground(new java.awt.Color(204, 255, 255));
        UploadButton.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        UploadButton.setText("Upload");
        UploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadButtonActionPerformed(evt);
            }
        });
        add(UploadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 110, 20));
        add(filelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 228, 24));

        SaveButton.setBackground(new java.awt.Color(0, 153, 153));
        SaveButton.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 570, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("University :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Professor :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Day of Week :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, -1, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Course Description :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-repeat-25.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add courses.jpeg"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 630));
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
uni = String.valueOf(unidropdown.getSelectedItem());
name  = namefld.getText();
prof = proffld.getText();
dow = String.valueOf(dowfld.getSelectedItem());
fileurl = filelbl.getText();
java.util.Date dNow = new java.util.Date( );
      SimpleDateFormat ft = 
      new SimpleDateFormat (" yyyy-MM-dd");
      String applied_date  = ft.format(dNow);
edudir.AddCourseByAdmin(uni,name,prof,dow,fileurl,applied_date);
JOptionPane.showMessageDialog(this, "Course Added");
populateApplications();
namefld.setText("");
proffld.setText("");
filelbl.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonActionPerformed

    
    
    String uni,name,prof,dow,fileurl;
    private void UploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadButtonActionPerformed
JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int r = file.showSaveDialog(null);
            if (r == JFileChooser.APPROVE_OPTION)
            {
                filelbl.setText(file.getSelectedFile().getAbsolutePath());
            }
            else
                filelbl.setText("N/A");
    }//GEN-LAST:event_UploadButtonActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

populateUni();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CourseData;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton UploadButton;
    private javax.swing.JComboBox<String> dowfld;
    private javax.swing.JLabel filelbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namefld;
    private javax.swing.JTextField proffld;
    private javax.swing.JComboBox<String> unidropdown;
    // End of variables declaration//GEN-END:variables
}
