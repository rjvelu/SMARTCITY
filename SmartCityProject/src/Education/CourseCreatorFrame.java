/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Education;

import Directories.CityDirectory;
import Directories.EducationDirectory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import smartcityproject.MainJFrame;

/**
 *
 * @author Ruthvik Garlapati
 */
public class CourseCreatorFrame extends javax.swing.JFrame {

    /**
     * Creates new form CourseCreatorFrame
     */
    EducationDirectory edudir;
     CityDirectory citydir;
     String user;
    public CourseCreatorFrame(String user,EducationDirectory edudir,CityDirectory citydir) {
        initComponents();
        this.edudir = edudir;
        this.citydir = citydir;
        this.user = user;
        populateApplications();
        populateUni();
    }

    private CourseCreatorFrame() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SaveButton = new javax.swing.JButton();
        UploadButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        unidropdown = new javax.swing.JComboBox<>();
        namefld = new javax.swing.JTextField();
        proffld = new javax.swing.JTextField();
        filelbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CourseData = new javax.swing.JTable();
        dowfld = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SaveButton.setBackground(new java.awt.Color(0, 153, 153));
        SaveButton.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 570, -1, -1));

        UploadButton.setBackground(new java.awt.Color(204, 255, 255));
        UploadButton.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        UploadButton.setText("Upload");
        UploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadButtonActionPerformed(evt);
            }
        });
        jPanel1.add(UploadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 110, 20));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setText("Course Description :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("Day of Week :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Professor :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Name :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("University :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, -1));

        unidropdown.setBackground(new java.awt.Color(204, 255, 255));
        unidropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(unidropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 192, -1));

        namefld.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.add(namefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 192, -1));

        proffld.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.add(proffld, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 192, -1));
        jPanel1.add(filelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 228, 24));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-repeat-25.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 119, 987, 174));

        dowfld.setBackground(new java.awt.Color(204, 255, 255));
        dowfld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        jPanel1.add(dowfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, 192, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Add Courses");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 200, -1));

        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 20, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-logout-rounded-70.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add courses.jpeg"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1140, 630));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String uni,name,prof,dow,fileurl;
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
        edudir.AddCourse(uni,name,prof,dow,fileurl,applied_date,user);
        JOptionPane.showMessageDialog(this, "Course Added");
        populateApplications();
        namefld.setText("");
        proffld.setText("");
        filelbl.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonActionPerformed

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
              ResultSet rs = edudir.getCoursesByAsignee(user);
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
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        populateUni();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
MainJFrame frame  = new MainJFrame();
frame.setVisible(true);
dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(CourseCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseCreatorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CourseData;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton UploadButton;
    private javax.swing.JComboBox<String> dowfld;
    private javax.swing.JLabel filelbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField namefld;
    private javax.swing.JTextField proffld;
    private javax.swing.JComboBox<String> unidropdown;
    // End of variables declaration//GEN-END:variables
}
