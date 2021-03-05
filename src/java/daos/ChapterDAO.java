/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Chapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.DBConnect;

/**
 *
 * @author ASUS GAMING
 */
public class ChapterDAO {
    //  get all chapters of a specific novel
    public ArrayList<Chapter> getChapters(String novelID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Chapter> lst = new ArrayList<>();
        String sql = "SELECT * FROM Chapter WHERE novelID=? ORDER BY CONVERT(DATE, uploadDate) ASC";
        try{
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                ps.setString(1, novelID);
                rs = ps.executeQuery();
                while(rs.next()){
                    String chapterID = rs.getString("chapterID");
                    String chapterName = rs.getString("chapterName");
                    String chapterURL = rs.getString("fileURL");
                    String uploadDate = rs.getString("uploadDate");
                    Chapter chapter = new Chapter(chapterID, novelID, chapterName, chapterURL, uploadDate);
                    lst.add(chapter);
                }
                return lst;
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
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    //  get one specific chapter of a novel
//    public Chapter getOneChapter(String novelID) {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        ArrayList<Chapter> lst = new ArrayList<>();
//        String sql = "SELECT * FROM Chapter WHERE novelID=? ORDER BY CONVERT(DATE, uploadDate) ASC";
//        try{
//            con = DBConnect.makeConnection();
//            if(con != null){
//                ps = con.prepareStatement(sql);
//                ps.setString(1, novelID);
//                rs = ps.executeQuery();
//                while(rs.next()){
//                    String chapterID = rs.getString("chapterID");
//                    String chapterName = rs.getString("chapterName");
//                    String chapterURL = rs.getString("fileURL");
//                    String uploadDate = rs.getString("uploadDate");
//                    Chapter chapter = new Chapter(chapterID, novelID, chapterName, chapterURL, uploadDate);
//                    lst.add(chapter);
//                }
//                return lst;
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally{
//            try {
//                if(rs != null) rs.close();
//                if(ps != null) ps.close();
//                if(con != null) con.close();
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
}
