
package UI;
import Directories.CensorDirectory;
import Directories.CompanyDirectory;
import Directories.EducationDirectory;
import Directories.TheatreDirectory;
import Directories.UserCoordinatesDirectory;
import Directories.UserDirectory;
import Education.UniversityPanel;
import Employment.MyApplicationsPanel;
import Employment.MyEmpExchangePanel;
import Entertainment.MoviesJPanel;
import java.sql.Connection;
/**
 *
 * @author Ruthvik Garlapati
 */
public class UserLandingJPanel extends javax.swing.JPanel {
    Connection connection;
    String user;
       private static final int MIN_ZOOM = 0;
 private static final int MAX_ZOOM = 21;
 private static int zoomValue = 5;
 CompanyDirectory compDir;
 UserCoordinatesDirectory cord;
 UserDirectory userdir;
 EducationDirectory edudir;
 TheatreDirectory thdir;
 CensorDirectory cendir;
    public UserLandingJPanel(Connection connection,String user,CompanyDirectory compDir,UserCoordinatesDirectory cord,UserDirectory userdir,EducationDirectory edudir,CensorDirectory cendir,TheatreDirectory thdir) {
        initComponents();
        this.connection = connection;
        this.user = user;
        this.compDir = compDir;
        this.cord = cord;
        this.userdir = userdir;
        this.edudir = edudir;
        this.thdir = thdir;
        this.cendir = cendir;
        UsernameLbl.setText(user);
        TabbedPane.add("Profile",new UserProfileJPanel(cord,user));
        TabbedPane.add("Finance",new UserAnalyticsDashboard(user,userdir,connection));
       TabbedPane.add("Education",new UniversityPanel(edudir,user));
       TabbedPane.add("Employement",new MyApplicationsPanel(compDir,connection,user));
       TabbedPane.add("Entertainment",new MoviesJPanel(connection,user,thdir,cendir));
    }

    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPane = new javax.swing.JTabbedPane();
        LogoutLbl = new javax.swing.JLabel();
        UsernameLbl = new javax.swing.JLabel();
        hilbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1080, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        add(TabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1200, 630));

        LogoutLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-logout-rounded-50.png"))); // NOI18N
        LogoutLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutLblMouseClicked(evt);
            }
        });
        add(LogoutLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, -1));

        UsernameLbl.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        add(UsernameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 260, -1));

        hilbl.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        hilbl.setText("Hi..");
        add(hilbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutLblMouseClicked
this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutLblMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoutLbl;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JLabel UsernameLbl;
    private javax.swing.JLabel hilbl;
    // End of variables declaration//GEN-END:variables
}
