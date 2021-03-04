/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS GAMING
 */
public class DBConnect {
    
    public static Connection makeConnection() {
        try {
            //  TDBC Native Protocol
            // 1
            /*Khai báo Driver dùng để kết nối với CSDL*/
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // 2
            /*Tạo đối tượng kết nối CSDL*/
            String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ301_Assignment_G5";
            Connection c = DriverManager.getConnection(url, "Dung", "123456");  // Ba tham số: url, username và password
            return c;
        }
        catch (ClassNotFoundException e) {
            //  TODO: handle exception
            e.printStackTrace();
        }
        catch (SQLException e){
            //  TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
}
