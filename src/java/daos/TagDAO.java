/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Tag;
import utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chiuy
 */
public class TagDAO {
    public Tag getTagsByID(String tagID) throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Tag WHERE tagID=?";
        try{
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                ps.setString(1, tagID);
                rs = ps.executeQuery();
                while(rs.next()){
                    String tagid = rs.getString("tagID");
                    String tagName = rs.getString("tagName");
                    
                    Tag tag = new Tag(tagid, tagName);
                    return tag;
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
        TagDAO dao = new TagDAO();
        Tag tag = dao.getTagsByID("01");
        System.out.println(tag.getTagName());
    }
}
