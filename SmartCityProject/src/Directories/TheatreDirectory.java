/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Directories;


import java.sql.*;
public class TheatreDirectory {
   Connection connection;
   
   public TheatreDirectory(Connection connection){
    this.connection = connection;   
   }
   public ResultSet getTheatreData(){
        try{
        PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from city");
        return st.executeQuery();
     }
     catch(SQLException e){
         System.out.println(e);
    }
     return null;
   }
    public  ResultSet  getTheatres(){
          try{   
         PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from city_applications where type = 'Theatre' and application_status = 'Approved'");
        return  st.executeQuery();
     }
     catch(Exception e){
         System.out.println(e);
     }
          return null;
    }
    public void insert_purchase_university(String username,String enter,double lat, double lon,String message){
        try{
             PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into my_applications(username,enterprise,lat,lon,message) values (?,?,?,?,?)");
             st.setString(1,username);
             st.setString(2, enter);
             st.setDouble(3,lat);
             st.setDouble(4, lon);
             st.setString(5,message);
             st.executeUpdate();
             }
         catch(SQLException e){
         System.out.println(e);
        }
     }
    
    public ResultSet getCord(String name){
         try{
             PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from city_applications where name = ?");
           st.setString(1, name);
             return st.executeQuery();
             }
         catch(SQLException e){
         System.out.println(e);
        }
         return null;
    }
    
    
    public void book_ticket(String uname,String theatre,String movie,int tickets,String applied_date){
         try{
             PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into movie_bookings(username,theatre,movie,tickets,movie_date) values(?,?,?,?,?)");
           st.setString(1, uname);
           st.setString(2, theatre);
           st.setString(3, movie);
           st.setInt(4, tickets);
          st.setString(5, applied_date);
             st.executeUpdate();
             }
         catch(SQLException e){
         System.out.println(e);
        }
    }
    
    public ResultSet get_bookings(String name){
         try{
             PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from movie_bookings  where username = ?");
           st.setString(1, name);
             return st.executeQuery();
             }
         catch(SQLException e){
         System.out.println(e);
        }
         return null;
    }
    
    public void updateBalance(String uname,double bal){
        try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("select balance from users where username = ?");
            st.setString(1, uname);
            ResultSet rs = st.executeQuery();
            double balance = 0;
            if(rs.next()){
                balance = rs.getDouble(1);
            }
            PreparedStatement st2 = (PreparedStatement)connection.prepareStatement("update users set balance = ? where username = ?");
            st2.setDouble(1, balance-bal);
            st2.setString(2, uname);
            st2.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
