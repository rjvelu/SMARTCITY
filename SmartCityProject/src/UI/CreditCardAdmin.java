
package UI;

import Directories.UserDirectory;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import smartcityproject.MainJFrame;


public class CreditCardAdmin extends javax.swing.JFrame {

 UserDirectory userdir;
    public CreditCardAdmin(UserDirectory userdir) {
        initComponents();
        this.userdir = userdir;
        populateApplications();
    }

    private CreditCardAdmin() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void populateApplications(){
         DefaultTableModel model = (DefaultTableModel) UserCreditData.getModel();
          try{
              ResultSet rs = userdir.getUserCreditData();
              model.setRowCount(0);
      while(rs.next()) {
            Object row[] = new Object[6];
            row[0] = rs.getString("request_id");
            row[1] = rs.getString("username");
            row[2] = rs.getString("cardnumber");
            row[3] = rs.getString("amount");
            row[4] = rs.getString("alimit");
               row[5] = rs.getString("status");
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
        UserCreditData = new javax.swing.JTable();
        StatusDropDown = new javax.swing.JComboBox<>();
        Submit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 0, 36)); // NOI18N
        jLabel1.setText("Credit Card Admin");

        UserCreditData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request Id", "User", "Card Number", "Amount", "Limit", "Status"
            }
        ));
        jScrollPane1.setViewportView(UserCreditData);

        StatusDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Approved", "Rejected" }));

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        jLabel2.setText("Status :");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-logout-rounded-70.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Submit)
                    .addComponent(StatusDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(490, 490, 490))
            .addGroup(layout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(StatusDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(Submit)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
int index1 = UserCreditData.getSelectedRow();
        if (index1 < 0) {
            JOptionPane.showMessageDialog(this, "Please select a request....!");
            return;
        }
         DefaultTableModel model2 = (DefaultTableModel) UserCreditData.getModel();
        String amount  = String.valueOf(model2.getValueAt(index1, 3));
        String limit = String.valueOf(model2.getValueAt(index1, 4));
        String app_status = String.valueOf(model2.getValueAt(index1, 5));
        String id = String.valueOf(model2.getValueAt(index1, 0));
        String username = String.valueOf(model2.getValueAt(index1, 1));
        String selected = String.valueOf(StatusDropDown.getSelectedItem());
        double bal = userdir.getUserBalance(username);
       if(!app_status.equals("Pending")){
           JOptionPane.showMessageDialog(this, "Status cannot be updated");
            return;
       }
        if(selected.equals("Select")){
            JOptionPane.showMessageDialog(this, "Select  a status to update");
            return;
        }else if(selected.equals("Approved")){
            
            bal += Double.parseDouble(amount);
            if(bal > Double.parseDouble(limit)){
                JOptionPane.showMessageDialog(this, "Cannot Approve limit exceeded.");
            return;
            }
            userdir.insertCreditCardAmount(username, amount,bal+"");
            userdir.UpdateUserBalance(username,bal);
            userdir.updateCreditApplicationStatus("Approved",id);
            populateApplications();
        }else if(selected.equals("Rejected")){
             userdir.updateCreditApplicationStatus("Rejected",id);
                populateApplications();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_SubmitActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

MainJFrame frame = new MainJFrame();
frame.setVisible(true);
dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new CreditCardAdmin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> StatusDropDown;
    private javax.swing.JButton Submit;
    private javax.swing.JTable UserCreditData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
