
package Directories;

/**
 *
 * @author Ruthvik Garlapati
 */

import java.sql.*;
public class EducationDirectory {
    Connection connection;
    public EducationDirectory(Connection connection){
        this.connection = connection;
    }
    
    public ResultSet getCourses(){
        
           try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from course_applications");
           return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    
    public void AddCourseByAdmin(String uni,String name,String prof,String dow,String fileurl,String applied_date){
        try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into course_applications(coursename,university,professor,coursedesc,app_status,applied_date,asignee,dayofweek) values (?,?,?,?,?,?,?,?)");
            st.setString(1,name);
            st.setString(2, uni);
            st.setString(3,prof);
            st.setString(4, fileurl);
            st.setString(5,"Approved");
            st.setString(6,applied_date);
            st.setString(7, "N/A");
            st.setString(8, dow);
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
     public void AddCourse(String uni,String name,String prof,String dow,String fileurl,String applied_date,String user){
        try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into course_applications(coursename,university,professor,coursedesc,app_status,applied_date,asignee,dayofweek) values (?,?,?,?,?,?,?,?)");
            st.setString(1,name);
            st.setString(2, uni);
            st.setString(3,prof);
            st.setString(4, fileurl);
            st.setString(5,"Pending");
            st.setString(6,applied_date);
            st.setString(7, user);
            st.setString(8, dow);
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public ResultSet getCoursesByAsignee(String user){
           try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from course_applications where asignee = ?");
            st.setString(1, user);
           return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    
    
    public ResultSet getAsignees(){
     try{   
         PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from user where role = 'courseregadmin'");
         st.executeQuery();
     }
     catch(Exception e){
         System.out.println(e);
     }
     return null;
    }
    
    
    
    public void updateAssignee(String name,String id){
        try{   
         PreparedStatement st = (PreparedStatement)connection.prepareStatement("update course_applications set asignee = ? where application_id = ?");
         st.setString(1, name);
         st.setString(2, id);
         st.executeQuery();
     }
     catch(Exception e){
         System.out.println(e);
     }
    }
    
    

    public  ResultSet  getUniversities(){
          try{   
         PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from city_applications where type = 'University' and application_status = 'Approved'");
        return  st.executeQuery();
     }
     catch(Exception e){
         System.out.println(e);
     }
          return null;
    }
    
    public ResultSet getCourses(String uni){
        try{
             PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from course_applications where university = ? and app_status = ?");
             st.setString(1,uni);
             st.setString(2,"Approved");
        return  st.executeQuery();
        }
         catch(Exception e){
         System.out.println(e);
     }
          return null;
    }
    public String getCourseFile(String name,String Uni){
        try{
             PreparedStatement st = (PreparedStatement)connection.prepareStatement("select coursedesc from course_applications where university = ? and coursename = ?");
             st.setString(1,Uni);
             st.setString(2,name);
             ResultSet rs = st.executeQuery();
             if(rs.next()){
                 return rs.getString("coursedesc");
             }
        }
         catch(SQLException e){
         System.out.println(e);
     }
        return "";
    }
    
    
    public void insert_university_application(String uni,String course,String user){
        try{
             PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into university_applications(university,username,course,status) values (?,?,?,?)");
             st.setString(1,uni);
             st.setString(2, user);
             st.setString(3, course);
             st.setString(4,"Applied");
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
     public ResultSet get_university_applications(String name){
         try{
             PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from university_applications  where username = ?");
           st.setString(1, name);
             return st.executeQuery();
             }
         catch(SQLException e){
         System.out.println(e);
        }
         return null;
    }
}
