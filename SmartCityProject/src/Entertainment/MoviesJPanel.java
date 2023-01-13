/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Entertainment;
import Directories.CensorDirectory;
import Directories.TheatreDirectory;
import java.awt.HeadlessException;
import java.sql.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MoviesJPanel extends javax.swing.JPanel {
    Connection c;
    String user;
    TheatreDirectory thdir;
    CensorDirectory cendir;
    public MoviesJPanel(Connection c,String user,TheatreDirectory thdir,CensorDirectory cendir) {
        initComponents();
        this.c = c;
        this.thdir = thdir;
        this.cendir = cendir;
        this.user = user;
        populateApplications();
        populateTheatres();
    }
     private void populateApplications(){
         DefaultTableModel model = (DefaultTableModel) bookings.getModel();
          try{
              ResultSet rs = thdir.get_bookings(user);
              model.setRowCount(0);
              Object row[] = new Object[5];
      while(rs.next()) {
            row[0] = rs.getString("booking_code");
            row[1] = rs.getString("theatre");
            row[2] = rs.getString("movie");
            row[3] = rs.getString("movie_date");
            row[4] = rs.getString("tickets");
            model.addRow(row);
        }
          }
          catch(Exception e){
              System.out.println(e);
          }
    }
     
      private void populateMovies(String thr){
    MoviesDropDown.removeAllItems();
     try{
         ResultSet rs = cendir.getMovies(thr);
         while(rs.next()){
         MoviesDropDown.addItem(rs.getString("Movie_name"));
         }
     }
     catch(Exception e){
         System.out.println(e);
         
     }
 }
private void populateTheatres(){

     TheatreDropDown.removeAllItems();
     try{
         ResultSet rs = thdir.getTheatres();
         while(rs.next()){
         TheatreDropDown.addItem(rs.getString("name"));
         }
     }
     catch(Exception e){
         System.out.println(e);
         
     }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TheatreDropDown = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookings = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        MoviesDropDown = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TicketsDropDown = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        bookButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        dateTxt = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 65)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 255));
        jLabel2.setText("Welcome to the Movies Dashboard! ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 1030, -1));

        TheatreDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        TheatreDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TheatreDropDownActionPerformed(evt);
            }
        });
        jPanel1.add(TheatreDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 150, 30));

        bookings.setBackground(new java.awt.Color(204, 204, 255));
        bookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Booking Code", "Theatre", "Movie", "Date", "No_of_Seats"
            }
        ));
        jScrollPane1.setViewportView(bookings);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 610, 350));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 255));
        jLabel1.setText("Your Bookings :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        MoviesDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", " " }));
        MoviesDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoviesDropDownActionPerformed(evt);
            }
        });
        jPanel1.add(MoviesDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 147, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 102, 255));
        jLabel3.setText("Theatre :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 90, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 153, 255));
        jLabel4.setText("Movie :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 153, 255));
        jLabel6.setText("Date :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 60, -1));

        TicketsDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        TicketsDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TicketsDropDownActionPerformed(evt);
            }
        });
        jPanel1.add(TicketsDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 147, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 153, 255));
        jLabel7.setText("Tickets :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 360, 80, -1));

        bookButton.setBackground(new java.awt.Color(255, 153, 255));
        bookButton.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        bookButton.setText("Book");
        bookButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookButtonActionPerformed(evt);
            }
        });
        jPanel1.add(bookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 147, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 153, 255));
        jLabel8.setText("Book - $9.99 per Ticket");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 250, 40));
        jPanel1.add(dateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 150, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/movi1.jpg"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
double lat,lon;
    private void TheatreDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TheatreDropDownActionPerformed
       String thr  = String.valueOf(TheatreDropDown.getSelectedItem());
populateMovies(thr);
try{
    ResultSet rs = thdir.getCord(thr);
    if(rs.next()){
    lat = rs.getDouble("lat");
    lon = rs.getDouble("lon");
    }
}
catch(Exception e){
    System.out.println(e);
}
    }//GEN-LAST:event_TheatreDropDownActionPerformed

    private void MoviesDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoviesDropDownActionPerformed
       
    }//GEN-LAST:event_MoviesDropDownActionPerformed

    private void TicketsDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicketsDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TicketsDropDownActionPerformed

    private void bookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookButtonActionPerformed
        
        int noft = Integer.parseInt(String.valueOf(TicketsDropDown.getSelectedItem()));
        String theatre = String.valueOf(TheatreDropDown.getSelectedItem());
        java.util.Date date = dateTxt.getDate();
        String movie = String.valueOf(MoviesDropDown.getSelectedItem());
         SimpleDateFormat ft = 
      new SimpleDateFormat (" yyyy-MM-dd");
      String applied_date  = ft.format(date);
       thdir.book_ticket(user, theatre, movie, noft, applied_date);
       JOptionPane.showMessageDialog(this, "Tickets Booked");
      populateApplications();
      thdir.insert_purchase_university(user, theatre, lat, lon, "Booked Tickets at ");
      thdir.updateBalance(user, (9.99*noft));
    }//GEN-LAST:event_bookButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> MoviesDropDown;
    private javax.swing.JComboBox<String> TheatreDropDown;
    private javax.swing.JComboBox<String> TicketsDropDown;
    private javax.swing.JButton bookButton;
    private javax.swing.JTable bookings;
    private com.toedter.calendar.JDateChooser dateTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
