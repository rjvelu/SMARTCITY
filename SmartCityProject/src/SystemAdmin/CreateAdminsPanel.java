
package SystemAdmin;


import Directories.UserDirectory;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
public class CreateAdminsPanel extends javax.swing.JPanel {


    Connection connection;
    UserDirectory userDir;
    String fname,lname,uname,email,role,pass,cnfpass;
    public CreateAdminsPanel(Connection connection,UserDirectory userDir) {
        initComponents();
        this.connection = connection;
        this.userDir = userDir;
        populateAdmins();
        GreenTick.setVisible(false);
        RedTick.setVisible(false);
        UsernameGreenTick.setVisible(false);
        UsernameRedTick.setVisible(false);
        ConfPasswordListener();
        UsernameListener();
    }
    
    private void populateAdmins(){
         DefaultTableModel model = (DefaultTableModel) UserData.getModel();
          try{
              ResultSet rs = userDir.getAdminsData();
              model.setRowCount(0);
               Object row[] = new Object[6];
      while(rs.next()) {
            row[0] = rs.getString("user_id");
            row[1] = rs.getString("firstname");
            row[2] = rs.getString("lastname");
            row[3] = rs.getString("username");
            row[4] = rs.getString("email");
              row[5] = rs.getString("role");
            model.addRow(row);
            }
          }
          catch(Exception e){
              System.out.println(e);
          }
    }
    
    
     private void UsernameListener(){
    DocumentListener documentListener = new DocumentListener() {
      @Override
      public void changedUpdate(DocumentEvent documentEvent) {
         if(!UsernameExists(UName.getText()) && UName.getText().length() > 8){
            UsernameGreenTick.setVisible(true);
            UsernameRedTick.setVisible(false);
          }else{
              UsernameRedTick.setVisible(true);
              UsernameGreenTick.setVisible(false);
          }
      }
      @Override
      public void insertUpdate(DocumentEvent documentEvent) {
          
          if(!UsernameExists(UName.getText()) && UName.getText().length() > 8){
            UsernameGreenTick.setVisible(true);
            UsernameRedTick.setVisible(false);
          }else{
              UsernameRedTick.setVisible(true);
              UsernameGreenTick.setVisible(false);
          }
      }
      @Override
      public void removeUpdate(DocumentEvent documentEvent) {
           if(!UsernameExists(UName.getText()) && UName.getText().length() > 8){
            UsernameGreenTick.setVisible(true);
            UsernameRedTick.setVisible(false);
          }else{
              UsernameRedTick.setVisible(true);
              UsernameGreenTick.setVisible(false);
          }
      }
    };
    UName.getDocument().addDocumentListener(documentListener);
}
     
     private boolean matchpasswords(){
         String pass = String.valueOf(password.getPassword());
         String cnfpass = String.valueOf(cnfpassword.getPassword());
         return pass.equals(cnfpass);
     }
    private void ConfPasswordListener(){
    DocumentListener documentListener = new DocumentListener() {
      @Override
      public void changedUpdate(DocumentEvent documentEvent) {
         if(matchpasswords()){
            GreenTick.setVisible(true);
            RedTick.setVisible(false);
          }else{
              RedTick.setVisible(true);
              GreenTick.setVisible(false);
          }
      }
      @Override
      public void insertUpdate(DocumentEvent documentEvent) {
          
          if(matchpasswords()){
            GreenTick.setVisible(true);
            RedTick.setVisible(false);
          }else{
              RedTick.setVisible(true);
              GreenTick.setVisible(false);
          }
      }
      @Override
      public void removeUpdate(DocumentEvent documentEvent) {
           if(matchpasswords()){
            GreenTick.setVisible(true);
            RedTick.setVisible(false);
          }else{
              RedTick.setVisible(true);
              GreenTick.setVisible(false);
          }
      }
    };
    cnfpassword.getDocument().addDocumentListener(documentListener);
}
 public boolean UsernameExists(String username){
     try {
                    PreparedStatement st = (PreparedStatement)connection.prepareStatement("Select username from users");
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        System.out.println(username + "   "+rs.getString(1));
                        if(rs.getString(1).equals(username))
                            return true;
                    }
                } catch (HeadlessException | SQLException sqlException) {
                    sqlException.printStackTrace();
                } 
     return false;
 }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserData = new javax.swing.JTable();
        FName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        LName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        UName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailfld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rolefld = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        cnfpassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        CreateButton = new javax.swing.JButton();
        GreenTick = new javax.swing.JLabel();
        RedTick = new javax.swing.JLabel();
        UsernameGreenTick = new javax.swing.JLabel();
        UsernameRedTick = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Create Admins");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        UserData.setBackground(new java.awt.Color(255, 204, 204));
        UserData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "User Id", "FirstName", "LastName", "Username", "Email", "Role"
            }
        ));
        jScrollPane1.setViewportView(UserData);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 93, 940, 180));

        FName.setBackground(new java.awt.Color(255, 204, 204));
        add(FName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 315, 207, 36));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FirstName :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 324, -1, -1));

        LName.setBackground(new java.awt.Color(255, 204, 204));
        add(LName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 378, 207, 36));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LastName :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 387, -1, -1));

        UName.setBackground(new java.awt.Color(255, 204, 204));
        add(UName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 207, 36));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 449, -1, -1));

        emailfld.setBackground(new java.awt.Color(255, 204, 204));
        add(emailfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 506, 207, 36));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 515, -1, -1));

        rolefld.setBackground(new java.awt.Color(255, 204, 204));
        rolefld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "mcreator", "tcreator", "ucreator", "ccreator", "compcreator", "jobscreator", "gadmin", "censoradmin", "citycomm", "coursecreator", "courseregadmin", " " }));
        add(rolefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 313, 207, 39));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Role :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 324, -1, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 387, -1, -1));

        password.setBackground(new java.awt.Color(255, 204, 204));
        add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 378, 207, 36));

        cnfpassword.setBackground(new java.awt.Color(255, 204, 204));
        add(cnfpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 440, 207, 36));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirm Password :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 449, -1, -1));

        CreateButton.setBackground(new java.awt.Color(255, 0, 51));
        CreateButton.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        CreateButton.setForeground(new java.awt.Color(255, 255, 255));
        CreateButton.setText("Create");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });
        add(CreateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, 128, 41));

        GreenTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-approval-25.png"))); // NOI18N
        add(GreenTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(932, 451, -1, -1));

        RedTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cross-mark-25.png"))); // NOI18N
        add(RedTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 450, -1, -1));

        UsernameGreenTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-approval-25.png"))); // NOI18N
        add(UsernameGreenTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 440, -1, -1));

        UsernameRedTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cross-mark-25.png"))); // NOI18N
        add(UsernameRedTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 440, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 204, 204));
        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/createadmin.jpeg"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1200, 630));
    }// </editor-fold>//GEN-END:initComponents

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed

        fname = FName.getText();
        lname = LName.getText();
        uname = UName.getText();
        email = emailfld.getText();
        role = rolefld.getSelectedItem().toString();
        pass = String.valueOf(password.getPassword());
        cnfpass = String.valueOf(cnfpassword.getPassword());
        userDir.addAdmin(fname, lname, uname, pass, email, role);
        JOptionPane.showMessageDialog(this, "User Added.");
        populateAdmins();
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateButton;
    private javax.swing.JTextField FName;
    private javax.swing.JLabel GreenTick;
    private javax.swing.JTextField LName;
    private javax.swing.JLabel RedTick;
    private javax.swing.JTextField UName;
    private javax.swing.JTable UserData;
    private javax.swing.JLabel UsernameGreenTick;
    private javax.swing.JLabel UsernameRedTick;
    private javax.swing.JPasswordField cnfpassword;
    private javax.swing.JTextField emailfld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox<String> rolefld;
    // End of variables declaration//GEN-END:variables
}
