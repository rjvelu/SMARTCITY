
package Directories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class CompanyDirectory {
    Connection connection;
    public CompanyDirectory(Connection connection){
    this.connection = connection;
    }
    public ResultSet getCompanyDirectory(){
        try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("select * from companies");
        return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public ResultSet getJobsByCompany(String comp){
        try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("select j.name from companies c ,jobs j where c.company_id = j.company_id and c.name = ?");
        st.setString(1, comp);
        return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
     public ResultSet getJobDescription(String comp,String role){
        try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("select j.description from companies c ,jobs j where c.company_id = j.company_id and c.name = ? and j.name = ?");
        st.setString(1, comp);
        st.setString(2, role);
        return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
     
     public ResultSet getApplicationByUser(String username){
      try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("select * from applications where username = ?");
        st.setString(1, username);
        return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
      return null;
     }
     public void withdrawApplication(String id){
          try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("update applications set status = ? where application_id = ?");
        st.setString(1,"Withdrawn");
        st.setString(2, id);
        st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
     }
     
     
     public void addNewJobByAdmin(String comp,String role,String desc,String applied_date){
         try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("insert into company_jobs(company,role,roledesc,app_status,asignee,applied_date,applied_by) values(?,?,?,?,?,?,?)");
        st.setString(1,comp);
        st.setString(2, role);
        st.setString(3,desc);
        st.setString(4, "Approved");
        st.setString(5, "N/A");
        st.setString(6, applied_date);
        st.setString(7,"sysadmin");
        st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
     }
     public void addNewJob(String comp,String role,String desc,String applied_date,String asignee,String user){
         try{
        PreparedStatement st= (PreparedStatement)connection.prepareStatement("insert into company_jobs(company,role,roledesc,app_status,asignee,applied_date,applied_by) values(?,?,?,?,?,?,?)");
        st.setString(1,comp);
        st.setString(2, role);
        st.setString(3,desc);
        st.setString(4, "Pending");
        st.setString(5, asignee);
        st.setString(6, applied_date);
        st.setString(7,user);
        st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
     }
     
     public ResultSet getAllJobsByAppliedPerson(String uname){
      try{   
          PreparedStatement st= (PreparedStatement)connection.prepareStatement("select * from company_jobs where applied_by = ? ");
        st.setString(1, uname);
        return st.executeQuery();
      }
      catch(Exception e){
          System.out.println(e);
      }
      return null;
     }
     
     
    public void addCompany(String name,String owener,String location,double lat,double lon,String user){
         try{
          PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into city_applications(name,type,owner,location,lat,lon,asignee,application_status) values (?,?,?,?,?,?,?,?)");
          st.setString(1,name);
          st.setString(2,"Company");
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
    
    
    public void newApplicationToCompany(String uname,String company,String role){
           try {
            PreparedStatement  st = (PreparedStatement) connection.prepareStatement("insert into company_applications(company,username,role,status) values(?,?,?,?)");
            st.setString(1,company);
            st.setString(2, uname);
            st.setString(3, role);
            st.setString(4,"Applied");
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public ResultSet get_company_applications(String name){
         try{
             PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from company_applications  where username = ?");
           st.setString(1, name);
             return st.executeQuery();
             }
         catch(SQLException e){
         System.out.println(e);
        }
         return null;
    }
      public  ResultSet  getCompanies(){
          try{   
         PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from city_applications where type = 'Company' and application_status = 'Approved'");
        return  st.executeQuery();
     }
     catch(Exception e){
         System.out.println(e);
     }
          return null;
    }
        
      public ResultSet getJobs(String comp){
        try{
             PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from company_jobs where company = ? and app_status = ?");
             st.setString(1,comp);
             st.setString(2,"Approved");
        return  st.executeQuery();
        }
         catch(Exception e){
         System.out.println(e);
     }
          return null;
    }
}
