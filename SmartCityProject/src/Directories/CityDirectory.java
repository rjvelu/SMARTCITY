
package Directories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDirectory {
     Connection connection;
    public CityDirectory(Connection connection){
     this.connection = connection;   
    }
    
    public ResultSet getAllApplications(){
     try{
        PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from city_applications");
        return st.executeQuery();
     }
     catch(SQLException e){
         System.out.println(e);
    }
     return null;
    }
     public ResultSet getAllApplicationsByAsignee(String username){
         System.out.println(username+"sdvdfgdg");
     try{
        PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from city_applications where asignee = ?");
        st.setString(1,username);
        return st.executeQuery();
     }
     catch(SQLException e){
         System.out.println(e);
    }
     return null;
    }
     
     
     public void addUniversityBySystemAdmin(String name,String owener,String location,double lat,double lon){
         try{
          PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into city_applications(name,type,owner,location,lat,lon,asignee,application_status) values (?,?,?,?,?,?,?,?)");
          st.setString(1,name);
          st.setString(2,"University");
          st.setString(3, owener);
          st.setString(4, location);
          st.setDouble(5,lat);
          st.setDouble(6, lon);
          st.setString(7, "N/A");
          st.setString(8, "Approved");
             st.executeUpdate();
         }
         catch(SQLException e){
             System.out.println(e);
         }
     }
     
       public void addTheatreBySystemAdmin(String name,String owener,String location,double lat,double lon){
         try{
          PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into city_applications(name,type,owner,location,lat,lon,asignee,application_status) values (?,?,?,?,?,?,?,?)");
          st.setString(1,name);
          st.setString(2,"Theatre");
          st.setString(3, owener);
          st.setString(4, location);
          st.setDouble(5,lat);
          st.setDouble(6, lon);
          st.setString(7, "N/A");
          st.setString(8, "Approved");
             st.executeUpdate();
         }
         catch(SQLException e){
             System.out.println(e);
         }
     }
       public void addCompanyBySystemAdmin(String name,String owener,String location,double lat,double lon){
         try{
          PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into city_applications(name,type,owner,location,lat,lon,asignee,application_status) values (?,?,?,?,?,?,?,?)");
          st.setString(1,name);
          st.setString(2,"Company");
          st.setString(3, owener);
          st.setString(4, location);
          st.setDouble(5,lat);
          st.setDouble(6, lon);
          st.setString(7, "N/A");
          st.setString(8, "Approved");
             st.executeUpdate();
         }
         catch(SQLException e){
             System.out.println(e);
         }
     }
     
     public ResultSet getApprovedBuildings(){
      try{   
          PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from city_applications where application_status = 'Approved'");
          return st.executeQuery();
      }
      catch(SQLException e){
          System.out.println(e);
      }
      return null;
     }
     
     public ResultSet getUserData(){
        try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("select username,role from users");
            return st.executeQuery();
        }
        catch(Exception e){
            System.out.println(e);
        }
         return null;
     }
      public void addTheatre(String name,String owener,String location,double lat,double lon,String user){
         try{
          PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into city_applications(name,type,owner,location,lat,lon,asignee,application_status) values (?,?,?,?,?,?,?,?)");
          st.setString(1,name);
          st.setString(2,"Theatre");
          st.setString(3, owener);
          st.setString(4, location);
          st.setDouble(5,lat);
          st.setDouble(6, lon);
          st.setString(7, user);
          st.setString(8, "Pending");
             st.executeUpdate();
         }
         catch(SQLException e){
             System.out.println(e);
         }
      }
           public ResultSet getTheatreData(String user){
         try{
          PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from city_applications where asignee = ?");
         st.setString(1, user);
              return st.executeQuery();
         }
         catch(SQLException e){
             System.out.println(e);
         }
         return null;
     }
           
           
           public void UpdateStatus(String id,String status){
                try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("update city_applications set application_status = ? where application_id = ?");
        st.setString(1, status);
        st.setString(2, id);
        st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
           }
           
           
            public void addUniversity(String name,String owener,String location,double lat,double lon,String user){
         try{
          PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into city_applications(name,type,owner,location,lat,lon,asignee,application_status) values (?,?,?,?,?,?,?,?)");
          st.setString(1,name);
          st.setString(2,"University");
          st.setString(3, owener);
          st.setString(4, location);
          st.setDouble(5,lat);
          st.setDouble(6, lon);
          st.setString(7, user);
          st.setString(8, "Pending");
             st.executeUpdate();
         }
         catch(SQLException e){
             System.out.println(e);
         }
      }
}
