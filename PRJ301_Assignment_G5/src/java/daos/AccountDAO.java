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
                    
                    Account acc = new Account(user, password, email, name, isAdmin);
                    return acc;
                }
            }
           
        }
        finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();
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
