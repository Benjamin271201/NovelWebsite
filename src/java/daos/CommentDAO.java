/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Comment;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import utils.DBConnect;

/**
 *
 * @author chiuy
 */
public class CommentDAO {
    public LinkedList<Comment> searchCommentsByChapter(String novelID, String chapterID){
        LinkedList<Comment> lst = new LinkedList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Comment WHERE novelID=? AND chapterID=?";
        try {
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                ps.setString(1, novelID);
                ps.setString(2, chapterID);
                rs = ps.executeQuery();
                while(rs.next()){
                    String commentID = rs.getString("commentID");
                    String commentNovelID = rs.getString("novelID");
                    String commentChapterID = rs.getString("chapterID");
                    String username = rs.getString("username");
                    String context = rs.getString("context");
                    Date commentDate = rs.getDate("commentDate");
                    
                    Comment com = new Comment(commentID, novelID, chapterID, username, context, (java.sql.Date) commentDate);
                    lst.add(com);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(con != null) con.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lst;
    }
    
    public boolean addComment(String username, String context, String chapterID, String novelID){
        Connection con = null;
        PreparedStatement ps = null;
        LinkedList<Comment> lst = this.searchCommentsByChapter(novelID, chapterID);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String commentDate = format.format(date);
        String sql = "INSERT INTO Comment(commentID, novelID, chapterID, username, context, commentDate)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                if(lst.size()>0){
                    ps.setString(1,  "CM" + (Integer.parseInt(String.valueOf(lst.getLast().getCommentID().substring(2))) +1));
                }
                else{
                    ps.setString(1, "CM1");
                }
                ps.setString(2, novelID);
                ps.setString(3, chapterID);
                ps.setString(4, username);
                ps.setString(5, context);
                ps.setString(6, commentDate);
                
                ps.executeUpdate();
                return true;
            }
        } 
        catch (Exception e) {
        }
        finally{
            try {
                if(ps != null) ps.close();
                if(con != null) con.close();
            } catch (Exception e) {
            }
        }
        
        return false;
    }
    
    public boolean deleteComment(String commentID){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM Comment WHERE commentID=?";
        try {
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                ps.setString(1, commentID);
                
                ps.executeUpdate();
                return true;
            }
        } 
        catch (Exception e) {
        }
        finally{
            try {
                if(ps != null) ps.close();
                if(con != null) con.close();
            } catch (Exception e) {
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        CommentDAO dao = new CommentDAO();
        dao.addComment("admin", "bad", "C1", "N000002");
         LinkedList<Comment> lst = dao.searchCommentsByChapter("N000002", "C1");
         for (Comment comment : lst) {
             System.out.println(comment.getCommentID());
        }
    }
}
