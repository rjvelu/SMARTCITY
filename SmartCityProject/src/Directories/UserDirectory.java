/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Directories;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDirectory {
    
    Connection connection;
    
    public UserDirectory(Connection connection){
     this.connection   = connection;
    }
    
    
    public String getCanLogin(String username,String password){
        try{
           PreparedStatement st = (PreparedStatement)connection.prepareStatement("select can_login from users where username = ? and passwordFld = ?");
           st.setString(1, username);
           st.setString(2, password);
              return st.executeQuery().getString(1);
        }
        catch(Exception e){
            
        }
     return null;
    }
    public ResultSet getUserData(){
        try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from users");
            return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
     public ResultSet getAdminsData(){
        try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from users where role not in ('User','SystemAdmin')");
            return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
     
     public void addAdmin(String fname,String lname,String uname,String password, String email,String role){
           try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into users(firstname,lastname,username,passwordFld,email,role,can_login) values (?,?,?,?,?,?,?)");
            st.setString(1, fname);
            st.setString(2, lname);
            st.setString(3, uname);
            st.setString(4, password);
            st.setString(5, email);
            st.setString(6, role);
            st.setString(7, "1");
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
     }
     
     
     
     public ResultSet getUserCreditData(){
          try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("select * from credit_applications");
            return st.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e);
        }
          return null;
     }
    public void insertCreditCardAmount(String username,String amount,String balance){
        try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into my_purchases(username,t_type,amount,balance,enterprise) values (?,?,?,?,?)");
            st.setString(1, username);
            st.setString(2, "Credit");
            st.setString(3, amount);
            st.setString(4, balance);
            st.setString(5, "CreditCard");
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public double getUserBalance(String username){
          try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("select balance from users where username = ?");
            st.setString(1,username);
           ResultSet rs =  st.executeQuery();
           if(rs.next())
           return Double.parseDouble(rs.getString(1));
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return 0;
    }
    public void updateCreditApplicationStatus(String status,String id){
         try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("update credit_applications set status = ? where request_id = ?");
            st.setString(1, status);
            st.setString(2,id);
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    public void UpdateUserBalance(String username,double balance){
        System.out.println(username + "  "+balance);
         try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("update users set balance = ? where username = ?");
            st.setString(2, username);
            st.setDouble(1,balance);
            System.out.println(st.executeUpdate());
        }
        catch(SQLException e){
            System.out.println(e);
        }
         
         
    }
    public void createCreditApplication(String username,String card,String amount,String alimit){
               try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("insert into credit_applications(username,cardnumber,amount,alimit,status) values (?,?,?,?,?)");
           st.setString(1,username);
           st.setString(2,card);
           st.setString(3, amount);
            st.setString(4, alimit);
            st.setString(5,"Pending");
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
         }
    
    public boolean isCardValid(String card,String pin){
        try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("select cardnumber,pin from credit_cards");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
             if(rs.getString(1).equals(card) && rs.getString(2).equals(pin))
                 return true;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
    
    public String getCreditCardLimit(String card){
        try{
            PreparedStatement st = (PreparedStatement)connection.prepareStatement("select alimit from credit_cards where cardnumber = ?");
            st.setString(1,card);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            return rs.getString(1); 
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
}
