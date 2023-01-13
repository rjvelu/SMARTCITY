/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Directories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
public class CensorDirectory {
    Connection connection;
    public CensorDirectory(Connection connection){
     this.connection = connection;   
    }
    
    
    public ResultSet getAllApplications(){
         try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("select * from censor_applications");
        return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public ResultSet populateNextApplicationsByAsignee(String user){
         try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("select * from censor_applications  where username = ? app_status = 'Active' or app_status = 'Pending' order by applied_date asc ");
       st.setString(1, user);
        return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public ResultSet getApplicationsByAsignee(String username){
         try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("select * from censor_applications where asignee = ?");
        st.setString(1, username);
        return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public void insertRecord(String name,String dir,String prod,String url,String theatre,String applied_Date,String asignee){
        try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("insert into censor_applications(theatre,movie_name,director,studio,app_status,movie_status,applied_date,url,asignee) values (?,?,?,?,?,?,?,?,?)");
        st.setString(1,theatre);
        st.setString(2,name);
        st.setString(3, dir);
        st.setString(4,prod);
        st.setString(5, "Active");
        st.setString(6, "Pending");
        st.setString(7, applied_Date);
        st.setString(8, url);
        st.setString(9,asignee);
        st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    public  ArrayList getAllCensorAdmins(){
        ArrayList<String> list = new ArrayList<>();
         try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("select username from users where role = ? ");
        st.setString(1,"censoradmin");
      ResultSet rs = st.executeQuery();
      while(rs.next()){
          list.add(rs.getString(1));
      }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    
    public void updateAssignee(String id,String asignee){
         try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("update censor_applications set asignee = ? where application_id = ?");
        st.setString(1, asignee);
        st.setString(2, id);
        st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
     public void updateAppStatus(String id,String status){
         try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("update censor_applications set app_status = ? where application_id = ?");
        st.setString(1, status);
        st.setString(2, id);
        st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
     
     public void updateMovieStatus(String id,String status){
         try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("update censor_applications set movie_status = ? where application_id = ?");
        st.setString(1, status);
        st.setString(2, id);
        st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
      public void insertRecordbyAdmin(String name,String dir,String prod,String url,String theatre,String applied_Date){
        try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("insert into censor_applications(theatre,movie_name,director,studio,app_status,movie_status,applied_date,url) values (?,?,?,?,?,?,?,?)");
        st.setString(1,theatre);
        st.setString(2,name);
        st.setString(3, dir);
        st.setString(4,prod);
        st.setString(5, "Approved");
        st.setString(6, "U/A");
        st.setString(7, applied_Date);
        st.setString(8, url);
        st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
      
      public ResultSet getMovies(String thr){
        try{
             PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from censor_applications where theatre = ? and app_status = ?");
             st.setString(1,thr);
             st.setString(2,"Approved");
        return  st.executeQuery();
        }
         catch(Exception e){
         System.out.println(e);
     }
          return null;
    }
}
