/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Account;
import utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author chiuy
 */
public class AccountDAO {
    public Account getAccountByUsername(String username) throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = DBConnect.makeConnection();
            if(con != null){
                 ps = con.prepareStatement("SELECT * FROM Account WHERE username = ?");
                ps.setString(1, username);
                rs = ps.executeQuery();
                if(rs.next()){
                    String user = rs.getString("username");
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    String name = rs.getString("name");
                    boolean isAdmin = Boolean.parseBoolean(rs.getString("isAdmin"));
                    String avatarURL = rs.getString("avatarURL");
                    Account acc = new Account(user, password, email, name, isAdmin, avatarURL);
                    return acc;
                }
            }
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(con != null) con.close();
            }
            catch(Exception e){
                e.printStackTrace();
        }
    }
           
        return null;
    }
    
    public boolean checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
                Connection con = null;
                PreparedStatement pstm = null;
                ResultSet rs = null;
                String url = "select * from Account where username=? and password=?";
                
                con = DBConnect.makeConnection();
                try {
                        if(con != null) {
                                pstm = con.prepareStatement(url);
                                pstm.setString(1, username);
                                pstm.setString(2, password);
                                rs = pstm.executeQuery();
                                return rs.next();
                        }
                } catch(SQLException e) {
                        e.printStackTrace();
                }
                return false;
       }
    
    public boolean addAccount(Account a){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO Account(username, email, password, name, isAdmin,avatarURL)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                ps.setString(1, a.getUsername());
                ps.setString(2, a.getEmail());
                ps.setString(3, a.getPassword());
                ps.setString(4, a.getName());
                ps.setString(5, "false");
                ps.setString(6, a.getAvatarURL());
                
                ps.executeUpdate();
                return true;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        finally{
            try {
                if(ps != null) ps.close();
                if(con != null) con.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public Account getAccountbyEmail(String emailForm){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement("SELECT * FROM Account WHERE email=?");
                ps.setString(1, emailForm);
                rs = ps.executeQuery();
                if(rs.next()){
                    String user = rs.getString("username");
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    String name = rs.getString("name");
                    boolean isAdmin = Boolean.parseBoolean(rs.getString("isAdmin"));
                    String avatarURL = rs.getString("avatarURL");
                    Account acc = new Account(user, password, email, name, isAdmin, avatarURL);
                    return acc;
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AccountDAO dao = new AccountDAO();
        Account acc = dao.getAccountByUsername("chiuycuong");
        System.out.println(acc.getUsername());
        System.out.println(acc.getName());
    }
}
