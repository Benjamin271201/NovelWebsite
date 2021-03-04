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
    
    //  get tag name based on tagID
    public Tag getTag(String tagID) {
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
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(con != null) con.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //  get tag list of a novel
    public ArrayList<Tag> getTagList(String novelID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Tag> tagList = new ArrayList<>();
        String sql = "SELECT * FROM TagMap WHERE novelID=?";
        try {
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                ps.setString(1, novelID);
                rs = ps.executeQuery();
                while(rs.next()){
                    String tagID = rs.getString("tagID");
                    Tag tag = getTag(tagID);
                    tagList.add(tag);
                }
                return tagList;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(con != null) con.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
