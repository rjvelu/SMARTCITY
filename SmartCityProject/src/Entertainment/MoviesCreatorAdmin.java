
package Entertainment;

import Directories.CensorDirectory;
import Directories.CityDirectory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import smartcityproject.MainJFrame;

public class MoviesCreatorAdmin extends javax.swing.JFrame {

    Connection connection;
    String user;
    CensorDirectory cenDir;
    CityDirectory citydir;
    public MoviesCreatorAdmin(Connection connection,String user,CensorDirectory cenDir,CityDirectory citydir) {
        initComponents();
        this.connection = connection;
        this.user  = user;
        this.cenDir = cenDir;
        this.citydir = citydir;
        UsernameLbl.setText(user);
        populateApplications();
        populateTheatres();
    }
    
    private void populateTheatres(){
        TheatresDropDown.removeAllItems();
        try{
        ResultSet rs = citydir.getApprovedBuildings();
        while(rs.next()){
            if(rs.getString("type").equals("Theatre")){
                TheatresDropDown.addItem(rs.getString("name"));
            }
        }
        }
        catch(Exception e){
         System.out.println(e);   
        }
        
    }
    
     private void populateApplications(){
         DefaultTableModel model = (DefaultTableModel) ApplicationsTableData.getModel();
          try{
              ResultSet rs = cenDir.getApplicationsByAsignee(user);
              model.setRowCount(0);
      while(rs.next()) {
            Object row[] = new Object[9];
             row[0] = rs.getString(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            row[4] = rs.getString(5);
            row[5] = rs.getString(8);
              row[6] = rs.getString(6);
            row[7] = rs.getString(7);
            row[8] = rs.getString(9);
            model.addRow(row);
        }
          }
          catch(Exception e){
              System.out.println(e);
          }
    }

    private MoviesCreatorAdmin() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UsernameLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ApplicationsTableData = new javax.swing.JTable();
        NameFld = new javax.swing.JTextField();
        DirectorFld = new javax.swing.JTextField();
        StudioFld = new javax.swing.JTextField();
        UrlFld = new javax.swing.JTextField();
        TheatresDropDown = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SaveFld = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-logout-rounded-70.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1216, 18, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 204));
        jLabel2.setText("Hello!!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 28, -1, -1));

        UsernameLbl.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        UsernameLbl.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(UsernameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 610, 43));

        ApplicationsTableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Application Id", "Theatre", "Name", "Director", "Producer/Studio", "Applied Date", "Application Status", "Movie Status", "Url"
            }
        ));
        ApplicationsTableData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(ApplicationsTableData);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 92, 1268, 188));
        getContentPane().add(NameFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 324, 308, 41));
        getContentPane().add(DirectorFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 383, 308, 41));
        getContentPane().add(StudioFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 442, 308, 41));
        getContentPane().add(UrlFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 501, 308, 41));

        TheatresDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        getContentPane().add(TheatresDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 560, 308, 49));

        jLabel4.setForeground(new java.awt.Color(255, 204, 204));
        jLabel4.setText("Name :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 335, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 204, 204));
        jLabel5.setText("Director :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 394, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 204, 204));
        jLabel6.setText("Producer/Studio :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 453, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 204, 204));
        jLabel7.setText("Url :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 512, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 204, 204));
        jLabel8.setText("Theatre :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 575, -1, -1));

        SaveFld.setText("Save");
        SaveFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFldActionPerformed(evt);
            }
        });
        getContentPane().add(SaveFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 627, 148, 35));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/511033.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1310, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents
String name,dir,prod,url,theatre,applied_date;
    private void SaveFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFldActionPerformed
name = NameFld.getText();
dir = DirectorFld.getText();
prod = StudioFld.getText();
url = UrlFld.getText();
theatre = String.valueOf(TheatresDropDown.getSelectedItem());
String asignee = ""+user;
   Date dNow = new Date( );
      SimpleDateFormat ft = 
      new SimpleDateFormat (" yyyy-MM-dd");
      String applied_date  = ft.format(dNow);
      System.out.println(name);
     cenDir.insertRecord(name, dir, prod, url, theatre, applied_date,asignee);
     populateApplications();
    }//GEN-LAST:event_SaveFldActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
MainJFrame frame = new MainJFrame();
frame.setVisible(true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(MoviesCreatorAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoviesCreatorAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoviesCreatorAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoviesCreatorAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoviesCreatorAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ApplicationsTableData;
    private javax.swing.JTextField DirectorFld;
    private javax.swing.JTextField NameFld;
    private javax.swing.JButton SaveFld;
    private javax.swing.JTextField StudioFld;
    private javax.swing.JComboBox<String> TheatresDropDown;
    private javax.swing.JTextField UrlFld;
    private javax.swing.JLabel UsernameLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
