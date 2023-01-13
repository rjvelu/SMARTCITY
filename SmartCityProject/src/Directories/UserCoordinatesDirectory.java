
package Directories;

import java.util.ArrayList;
import model.UserCoordinates;
import java.sql.*;

public class UserCoordinatesDirectory {
    ArrayList<UserCoordinates> list;
    Connection connection;
    
   public UserCoordinatesDirectory(Connection connection){
      this.list = new ArrayList<>();
      this.connection  = connection;
   }

    public ArrayList<UserCoordinates> getList() {
        return list;
    }

    public void setList(ArrayList<UserCoordinates> list) {
        this.list = list;
    }
    public UserCoordinates addNew(){
     UserCoordinates temp = new UserCoordinates();
     list.add(temp);
     return temp;
    }
   
    public  void updateProfile(String fname,String lname,String email,String address,double lat,double lon,String username){
        try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("update users set firstname = ?,lastname = ?, email = ?,address = ?, lat = ?,lon = ? where username = ?");
            st.setString(1,fname);
            st.setString(2, lname);
            st.setString(3,email);
            st.setString(4, address);
            st.setDouble(5,lat);
            st.setDouble(6, lon);
            st.setString(7,username);
            st.executeUpdate();
        }
        catch(Exception e){
            
        }
    }
     public ResultSet getUserData(String name){
        try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from users where username = ?");
            st.setString(1,name);
            return st.executeQuery();
        }
        catch(SQLException e){
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
}
