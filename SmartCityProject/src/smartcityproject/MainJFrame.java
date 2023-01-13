/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package smartcityproject;
import Directories.CensorDirectory;
import Directories.CityDirectory;
import Directories.CompanyDirectory;
import Directories.EducationDirectory;
import Directories.TheatreDirectory;
import Directories.UserCoordinatesDirectory;
import Directories.UserDirectory;
import Education.CourseCreatorFrame;
import Education.UCreatorFrame;
import Employment.CompanyCreatorFrame;
import Employment.JobsCreatorFrame;
import Entertainment.MoviesCreatorAdmin;
import Entertainment.TheatreCreatorFrame;
import GovernmentAdmin.CensorBoardAdminFrame;
import GovernmentAdmin.CityCommisionerFrame;
import GovernmentAdmin.CourseRegAdmin;
import GovernmentAdmin.GAdminLandingPage;
import SystemAdmin.SysAdminJFrame;
import UI.CreditCardAdmin;
import UI.SignUPJPanel;
import UI.SignUpJFrame;
import UI.UserLandingJPanel;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

import java.sql.*;

public class MainJFrame extends javax.swing.JFrame {

   
    CompanyDirectory compDir;
    Connection connection;
      UserDirectory userDir;
      CensorDirectory cenDir;
      UserCoordinatesDirectory coordDir;
      CityDirectory cityDir;
      TheatreDirectory thDir;
      EducationDirectory edudir;
    public MainJFrame() {
         connectDatabase();
        compDir = new CompanyDirectory(connection);
        userDir = new UserDirectory(connection);
        cenDir = new CensorDirectory(connection);
        coordDir = new UserCoordinatesDirectory(connection);
        cityDir = new CityDirectory(connection);
        this.thDir = new TheatreDirectory(connection);
        this.edudir = new EducationDirectory(connection);
        initComponents();
       
    }
    
    public final void connectDatabase(){
     try{
         connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test2","root", "root");
        }
        catch(SQLException e){
            System.out.println("Unable to connect to Database");
        }
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        MainJPanel = new javax.swing.JPanel();
        UsernameFld = new javax.swing.JTextField();
        RegisterButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();
        PasswordImage = new javax.swing.JLabel();
        UserNameImage = new javax.swing.JLabel();
        TitleImage = new javax.swing.JLabel();
        PasswordFld = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        container.setLayout(new java.awt.CardLayout());

        MainJPanel.setBackground(new java.awt.Color(0, 153, 153));
        MainJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsernameFld.setBackground(new java.awt.Color(0, 153, 153));
        UsernameFld.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        UsernameFld.setText("Username");
        UsernameFld.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        MainJPanel.add(UsernameFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 260, 40));

        RegisterButton.setBackground(new java.awt.Color(0, 153, 153));
        RegisterButton.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        RegisterButton.setText("Register");
        RegisterButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });
        MainJPanel.add(RegisterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 280, 40));

        LoginButton.setBackground(new java.awt.Color(0, 153, 153));
        LoginButton.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(51, 51, 51));
        LoginButton.setText("Login");
        LoginButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        MainJPanel.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 280, 40));

        PasswordImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-unlock-private-20.png"))); // NOI18N
        MainJPanel.add(PasswordImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 20, 30));

        UserNameImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-user-20.png"))); // NOI18N
        MainJPanel.add(UserNameImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 20, 30));

        TitleImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-smart-city-64.png"))); // NOI18N
        MainJPanel.add(TitleImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 70, 90));

        PasswordFld.setBackground(new java.awt.Color(0, 153, 153));
        PasswordFld.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        PasswordFld.setText("password");
        PasswordFld.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        PasswordFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFldActionPerformed(evt);
            }
        });
        MainJPanel.add(PasswordFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, 260, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screenshot_20221123_190801.png"))); // NOI18N
        MainJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 700));

        container.add(MainJPanel, "card2");

        getContentPane().add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFldActionPerformed
String username;
  String pwd ;

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        username = UsernameFld.getText();
      pwd = String.valueOf(PasswordFld.getPassword());
        System.out.println(username + pwd);
        try {
         
            ResultSet rs =userDir.getUserData();
            while (rs.next()) {
                if(rs.getString(4).equals(username) && rs.getString(6).equals(pwd)){
                     flag = false;
                        if(rs.getString(8).equals("1")){
                            System.out.println(rs.getString("role"));
                            if(rs.getString("role").equals("User")){
                                flag = true;
                            UserLandingJPanel panel2 = new UserLandingJPanel(connection,username,compDir,coordDir,userDir,edudir,cenDir,thDir);
                            container.add("UserLandingJPanel",panel2);
                            CardLayout layout = (CardLayout) container.getLayout();
                            layout.next(container);
                            }
                            if(rs.getString("role").equals("SystemAdmin")){
                                flag = true;
                            SysAdminJFrame frame = new SysAdminJFrame(connection,username,userDir,thDir,cityDir,coordDir,cenDir,edudir,compDir);
                          frame.setVisible(true);
                           dispose();
                            }
                            if(rs.getString("role").equals("gadmin")){
                                flag = true;
                           GAdminLandingPage frame = new GAdminLandingPage(cenDir,username,cityDir,edudir);
                           frame.setVisible(true);
                           dispose();
                            }
                             if(rs.getString("role").equals("censoradmin")){
                                flag = true;
                           CensorBoardAdminFrame frame = new CensorBoardAdminFrame(connection,cenDir,username);
                           frame.setVisible(true);
                           dispose();
                            }
                               if(rs.getString("role").equals("mcreator")){
                                flag = true;
                          MoviesCreatorAdmin frame = new MoviesCreatorAdmin(connection,username,cenDir,cityDir);
                           frame.setVisible(true);
                           dispose();
                            }
                                if(rs.getString("role").equals("citycomm")){
                                flag = true;
                          CityCommisionerFrame frame = new CityCommisionerFrame(connection,username,cityDir);
                           frame.setVisible(true);
                           dispose();
                            }
                                  if(rs.getString(9).equals("ccadmin")){
                                flag = true;
                          CreditCardAdmin frame = new CreditCardAdmin(userDir);
                           frame.setVisible(true);
                           dispose();
                            }
                                    if(rs.getString(9).equals("compadmin")){
                                flag = true;
                          CompanyCreatorFrame frame = new CompanyCreatorFrame(compDir,cityDir,coordDir,username);
                           frame.setVisible(true);
                           dispose();
                            }
                                     if(rs.getString(9).equals("jobscreator")){
                                flag = true;
                          JobsCreatorFrame frame = new JobsCreatorFrame(compDir,cityDir);
                           frame.setVisible(true);
                           dispose();
                            }
                                        if(rs.getString(9).equals("tcreator")){
                                flag = true;
                          TheatreCreatorFrame frame = new TheatreCreatorFrame(cityDir,username,coordDir);
                           frame.setVisible(true);
                           dispose();
                            }
                                         if(rs.getString(9).equals("ucreator")){
                                flag = true;
                          UCreatorFrame frame = new UCreatorFrame(username,connection,cityDir,coordDir);
                           frame.setVisible(true);
                           dispose();
                            }
                                          if(rs.getString(9).equals("coursecreator")){
                                flag = true;
                          CourseCreatorFrame frame = new CourseCreatorFrame(username,edudir,cityDir);
                           frame.setVisible(true);
                           dispose();
                            }
                                            if(rs.getString(9).equals("courseregadmin")){
                                flag = true;
                          CourseRegAdmin frame = new CourseRegAdmin();
                           frame.setVisible(true);
                           dispose();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "Email not Verified.");
                        }
                }
            }
            if(!flag)
            JOptionPane.showMessageDialog(this, "Username Not Found.");
        } catch (HeadlessException | SQLException sqlException) {
            sqlException.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
      SignUpJFrame frame = new SignUpJFrame(connection);
      frame.setVisible(true);
      dispose();
    }//GEN-LAST:event_RegisterButtonActionPerformed
boolean flag = false;
   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel MainJPanel;
    private javax.swing.JPasswordField PasswordFld;
    private javax.swing.JLabel PasswordImage;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel TitleImage;
    private javax.swing.JLabel UserNameImage;
    private javax.swing.JTextField UsernameFld;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
