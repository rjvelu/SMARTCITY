/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GovernmentAdmin;

import Directories.EducationDirectory;
import Directories.UserDirectory;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruthvik Garlapati
 */
public class GAdminCoursePanel extends javax.swing.JPanel {

    /**
     * Creates new form GAdminCoursePanel
     */
    
    EducationDirectory edudir;
    public GAdminCoursePanel(EducationDirectory edudir) {
        initComponents();
        this.edudir = edudir;
        populateApplications();
        popAsignees();
    }
    
    private void popAsignees(){
         asignees.removeAllItems();
         try{
             ResultSet rs = edudir.getAsignees();
             while(rs.next()){
                 asignees.addItem(rs.getString("username"));
             }
         }
         catch(Exception e){
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
               row[6] = rs.getString("asignee");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        CourseData = new javax.swing.JTable();
        asignees = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        CourseData.setBackground(new java.awt.Color(204, 255, 255));
        CourseData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Course Id", "Name", "Professor", "University", "Day of Week", "Descriprtion Pdf", "Status", "Asignee"
            }
        ));
        jScrollPane1.setViewportView(CourseData);

        asignees.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Approved", "Rejected" }));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel1.setText("Course Applications");

        jLabel2.setText("Asignee :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(asignees, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(asignees, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addContainerGap(246, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

String asignee = String.valueOf(asignees.getSelectedItem());
int index1 = CourseData.getSelectedRow();
        if (index1 < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Application....!");
            return;
        }
         DefaultTableModel model2 = (DefaultTableModel) CourseData.getModel();
        String id  = String.valueOf(model2.getValueAt(index1, 0));
        edudir.updateAssignee(id,asignee);
        JOptionPane.showMessageDialog(this, "Update Success");
        populateApplications();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CourseData;
    private javax.swing.JComboBox<String> asignees;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
