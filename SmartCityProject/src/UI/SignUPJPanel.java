/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

import java.util.Properties;


import javax.swing.JOptionPane;

import java.sql.*;
import java.util.Random;
import java.util.regex.Pattern;
import javax.mail.Message.RecipientType;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import smartcityproject.MainJFrame;
/**
 *
 * @author Ruthvik Garlapati
 */
public class SignUPJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SignUPJPanel
     */
    JSplitPane pane;
    JPanel mainJ;
    Connection connection;
    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    public SignUPJPanel(JPanel mainJ, Connection connection) {
        initComponents();
        this.pane = pane;
        this.mainJ = mainJ;
        this.connection = connection;
        EmailGreenTick.setVisible(false);
        UsernameGreenTick.setVisible(false);
        EmailRedTick.setVisible(false);
        UsernameRedTick.setVisible(false);
UsernameListener();
        EmailListener();
    }

   private void UsernameListener(){
    DocumentListener documentListener = new DocumentListener() {
      @Override
      public void changedUpdate(DocumentEvent documentEvent) {
         if(!UsernameExists(UsernameFld.getText()) && UsernameFld.getText().length() > 8){
            UsernameGreenTick.setVisible(true);
            UsernameRedTick.setVisible(false);
          }else{
              UsernameRedTick.setVisible(true);
              UsernameGreenTick.setVisible(false);
          }
      }
      @Override
      public void insertUpdate(DocumentEvent documentEvent) {
          
          if(!UsernameExists(UsernameFld.getText()) && UsernameFld.getText().length() > 8){
            UsernameGreenTick.setVisible(true);
            UsernameRedTick.setVisible(false);
          }else{
              UsernameRedTick.setVisible(true);
              UsernameGreenTick.setVisible(false);
          }
      }
      @Override
      public void removeUpdate(DocumentEvent documentEvent) {
           if(!UsernameExists(UsernameFld.getText()) && UsernameFld.getText().length() > 8){
            UsernameGreenTick.setVisible(true);
            UsernameRedTick.setVisible(false);
          }else{
              UsernameRedTick.setVisible(true);
              UsernameGreenTick.setVisible(false);
          }
      }
    };
    UsernameFld.getDocument().addDocumentListener(documentListener);
}
  
   public boolean validEmail(String email){
    return Pattern.compile(regexPattern)
      .matcher(email)
      .matches();   
   }
   private void EmailListener(){
    DocumentListener documentListener = new DocumentListener() {
      @Override
      public void changedUpdate(DocumentEvent documentEvent) {
         if(!EmailExists(EmailFld.getText()) && validEmail(EmailFld.getText())){
            EmailGreenTick.setVisible(true);
            EmailRedTick.setVisible(false);
          }else{
              EmailRedTick.setVisible(true);
                EmailGreenTick.setVisible(false);
          }
      }
      @Override
      public void insertUpdate(DocumentEvent documentEvent) {
       
           if(!EmailExists(EmailFld.getText()) && validEmail(EmailFld.getText())){
            EmailGreenTick.setVisible(true);
            EmailRedTick.setVisible(false);
          }else{
              EmailRedTick.setVisible(true);
                EmailGreenTick.setVisible(false);
          }
      
      }
      @Override
      public void removeUpdate(DocumentEvent documentEvent) {
          
           if(!EmailExists(EmailFld.getText()) && validEmail(EmailFld.getText())){
            EmailGreenTick.setVisible(true);
            EmailRedTick.setVisible(false);
          }else{
              EmailRedTick.setVisible(true);
                EmailGreenTick.setVisible(false);
           } 
      }
    };
    EmailFld.getDocument().addDocumentListener(documentListener);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HomeButton = new javax.swing.JButton();
        FirstNameFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LastNameFld = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        UsernameFld = new javax.swing.JTextField();
        EmailFld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PasswordFld = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        CnfPasswordFld = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        SignUpButton = new javax.swing.JButton();
        VerifyCodeFld = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        VerifyButton = new javax.swing.JButton();
        EmailGreenTick = new javax.swing.JLabel();
        UsernameGreenTick = new javax.swing.JLabel();
        UsernameRedTick = new javax.swing.JLabel();
        EmailRedTick = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HomeButton.setBackground(new java.awt.Color(0, 153, 153));
        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home_24px.png"))); // NOI18N
        HomeButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeButtonMouseClicked(evt);
            }
        });
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });
        add(HomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 6, 42, 45));

        FirstNameFld.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        FirstNameFld.setText("First Name");
        FirstNameFld.setActionCommand("<Not Set>");
        FirstNameFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameFldActionPerformed(evt);
            }
        });
        add(FirstNameFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 88, 213, -1));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        jLabel1.setText("New Registration");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 19, -1, 32));

        jLabel2.setText("FirstName :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 91, -1, -1));

        jLabel3.setText("LastName :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 127, -1, -1));

        LastNameFld.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        LastNameFld.setText("Last Name");
        add(LastNameFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 124, 213, -1));

        jLabel4.setText("Username :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 169, -1, -1));

        UsernameFld.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        UsernameFld.setText("User Name");
        add(UsernameFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 166, 213, -1));

        EmailFld.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        EmailFld.setText("Email");
        add(EmailFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 212, 213, -1));

        jLabel5.setText("Email :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 215, -1, -1));

        PasswordFld.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        PasswordFld.setText("password");
        add(PasswordFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 261, 213, -1));

        jLabel6.setText("Password :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 264, -1, -1));

        CnfPasswordFld.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        CnfPasswordFld.setText("password");
        add(CnfPasswordFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 303, 213, -1));

        jLabel7.setText("Confirm Password :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 306, -1, -1));

        SignUpButton.setBackground(new java.awt.Color(0, 153, 153));
        SignUpButton.setText("Sign Up");
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });
        add(SignUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 345, 112, -1));

        VerifyCodeFld.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        VerifyCodeFld.setText("Code");
        add(VerifyCodeFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 396, 213, -1));

        jLabel8.setText("Verification Code :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 399, -1, -1));

        VerifyButton.setBackground(new java.awt.Color(0, 153, 153));
        VerifyButton.setText("Verify");
        VerifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerifyButtonActionPerformed(evt);
            }
        });
        add(VerifyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 449, 112, -1));

        EmailGreenTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-approval-25.png"))); // NOI18N
        add(EmailGreenTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 212, -1, -1));

        UsernameGreenTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-approval-25.png"))); // NOI18N
        add(UsernameGreenTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 166, -1, -1));

        UsernameRedTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cross-mark-25.png"))); // NOI18N
        add(UsernameRedTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 166, -1, -1));

        EmailRedTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cross-mark-25.png"))); // NOI18N
        add(EmailRedTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 212, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
 public String generateUniqueId(){
        Random random = new Random();
        String res = "";
        int arr[] = {1,2,3,4,5,6,7,8,9};
        for(int i=0;i<6;i++){
            res += arr[random.nextInt(arr.length)];
        }
        return res;
    }
 
  public boolean EmailExists(String email){
     try {
                    PreparedStatement st = (PreparedStatement)connection.prepareStatement("Select email from users");
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        System.out.println(email + "   "+rs.getString(1));
                        if(rs.getString(1).equals(email))
                            return true;
                    }
                } catch (HeadlessException | SQLException sqlException) {
                    sqlException.printStackTrace();
                } 
     return false;
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
  public void send_mail(String to_mail, int code) {
  System.out.println("Sending Mail");
  String email = "ruthvik.vgf58@gmail.com";
  String password = "Lionelmessi10$";
  Properties defaultProps = new Properties();
  defaultProps.setProperty("mail.smtp.auth", "true");
  defaultProps.setProperty("mail.smtp.starttls.enable", "true");
  defaultProps.setProperty("mail.smtp.host", "smtp.gmail.com");
  defaultProps.setProperty("mail.smtp.port", "587");

  Session session = Session.getDefaultInstance(defaultProps, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthenticator() {
      return new PasswordAuthentication(email, password);
    }
  });
  
  try{
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress("outlook@admin.com"));
    message.addRecipient(RecipientType.TO, new InternetAddress(to_mail));
    message.setSubject("AED Project Email Verification");
    message.setText("Hi, \n \n Your Verification code is "+code+"\n \nThanks,\nAdmin Team.");
    Transport.send(message,email,"vmifdghiyfqpkjpy");
    System.out.println("Sent Mail");
    JOptionPane.showMessageDialog(this, "Verification Email Successfully sent.!!");
}
catch( HeadlessException | MessagingException ex){
    System.out.println(""+ex);
}
}
    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
pane.setRightComponent(mainJ);
        // TODO add your handling code here:
    }//GEN-LAST:event_HomeButtonActionPerformed
String fname,lname,uname,email,pass,cnfpass,code;
    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
fname = FirstNameFld.getText();
lname = LastNameFld.getText();
uname = UsernameFld.getText();
email = EmailFld.getText();
pass = String.valueOf(PasswordFld.getPassword());
cnfpass = String.valueOf(CnfPasswordFld.getPassword());
code = generateUniqueId();
try {
  PreparedStatement st = (PreparedStatement) connection.prepareStatement("insert into users values(?,?,?,?,?,?,false)");

  st.setString(1, fname);
  st.setString(2, lname);
  st.setString(3,  uname);
  st.setString(4, email);
  st.setString(5, pass);
  st.setString(6, code);
  st.executeUpdate();
  send_mail(email, Integer.parseInt(code));
} catch (NumberFormatException | SQLException e) {
  System.out.println("" + e);
}
    }//GEN-LAST:event_SignUpButtonActionPerformed

    private void VerifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerifyButtonActionPerformed
 String code = VerifyCodeFld.getText();
        
        try {
                    PreparedStatement st = (PreparedStatement)connection.prepareStatement("Select username,passwordFld,verify_code from users");
                    PreparedStatement st2 = (PreparedStatement)connection.prepareStatement("update users set can_login = ? where username = ? ");
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        if(rs.getString(1).equals(uname) && rs.getString(2).equals(pass)){
                            if(rs.getString(3).equals(code)){
                                st2.setString(1,"1");
                                st2.setString(2,uname);
                                    int executeUpdate = st2.executeUpdate();
                                    System.out.println(executeUpdate);
                                    JOptionPane.showMessageDialog(this, "Email Verified.\n Please proceed to Login.");
                                }else{
                                JOptionPane.showMessageDialog(this, "Incorrect Verification Code");
                            }
                        }
                    }
                } catch (HeadlessException | SQLException sqlException) {
                    sqlException.printStackTrace();
                } 
        // TODO add your handling code here:
    }//GEN-LAST:event_VerifyButtonActionPerformed

    private void FirstNameFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameFldActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameFldActionPerformed

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked
MainJFrame frame = new MainJFrame();
frame.setVisible(true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_HomeButtonMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField CnfPasswordFld;
    private javax.swing.JTextField EmailFld;
    private javax.swing.JLabel EmailGreenTick;
    private javax.swing.JLabel EmailRedTick;
    private javax.swing.JTextField FirstNameFld;
    private javax.swing.JButton HomeButton;
    private javax.swing.JTextField LastNameFld;
    private javax.swing.JPasswordField PasswordFld;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JTextField UsernameFld;
    private javax.swing.JLabel UsernameGreenTick;
    private javax.swing.JLabel UsernameRedTick;
    private javax.swing.JButton VerifyButton;
    private javax.swing.JTextField VerifyCodeFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
