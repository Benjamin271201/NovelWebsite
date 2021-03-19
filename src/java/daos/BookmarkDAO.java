/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.DBConnect;

/**
 *
 * @author ASUS GAMING
 */
public class BookmarkDAO {
    
    // add/delete bookmark
    public boolean bookmarkHandler(String username, String novelID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement("SELECT * FROM Bookmark WHERE novelID = ? AND username = ?");
                ps.setString(1, novelID);
                ps.setString(2, username);
                rs = ps.executeQuery();
                // if alr bookmarked -> remove bookmark
                if(rs.next()){
                    ps = con.prepareStatement("DELETE FROM Bookmark WHERE username=? AND novelID=?");
                    ps.setString(1, username);
                    ps.setString(2, novelID);
                    ps.executeUpdate();
                }
                else {
                    ps = con.prepareStatement("INSERT INTO Bookmark(username, novelID) VALUEs(?, ?)");
                    ps.setString(1, username);
                    ps.setString(2, novelID);
                    ps.executeUpdate();
                }
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(con != null) con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    
    //  check if a novel is alr bookmarked by the user
    public boolean isBookmarked(String username, String novelID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement("SELECT * FROM Bookmark WHERE novelID = ? AND username = ?");
                ps.setString(1, novelID);
                ps.setString(2, username);
                rs = ps.executeQuery();
                if(rs.next()){
                    return true;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(con != null) con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    
    //  get all bookmarked books 
    public ArrayList<String> getBookmarkIDList(Account user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> lst = new ArrayList<>();
        
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                ps = con.prepareStatement("SELECT * FROM Bookmark WHERE username=?");
                ps.setString(1, user.getUsername());
                rs = ps.executeQuery();
                while (rs.next()) {
                    String novelID = rs.getString("novelID");
                    lst.add(novelID);
                }
                return lst;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}