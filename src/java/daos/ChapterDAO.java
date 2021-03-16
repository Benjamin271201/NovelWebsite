/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Chapter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import utils.DBConnect;

/**
 *
 * @author ASUS GAMING
 */
public class ChapterDAO {
    //  get all chapters of a specific novel
    public LinkedList<Chapter> getChapters(String novelID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LinkedList<Chapter> lst = new LinkedList<>();
        NovelDAO nDAO = new NovelDAO();
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
                    String nID = rs.getString("novelID");
                    Date uploadDate = rs.getDate("uploadDate");
                    Chapter chapter = new Chapter(chapterID, nDAO.getNovel(nID), chapterName, chapterURL, uploadDate);
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
    
    public int searchChapterInList(LinkedList<Chapter> lst, String novelID, String chapterID){
        for (Chapter chapter : lst) {
//            if(novelID.equalsIgnoreCase(chapter.getNovel()) && chapterID.equalsIgnoreCase(chapter.getChapterID())) return lst.indexOf(chapter);
            if(novelID.equalsIgnoreCase(chapter.getNovel().getNovelID()) && chapterID.equalsIgnoreCase(chapter.getChapterID())) return lst.indexOf(chapter);
        }
        return -1;
    }
    
    public Chapter getChapterByChapterIDNovelID(String novelID, String chapterID){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        NovelDAO nDAO = new NovelDAO();
        String sql = "SELECT * FROM Chapter WHERE chapterID=? AND novelID=?";
        try {
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                ps.setString(1, chapterID);
                ps.setString(2, novelID);
                
                rs = ps.executeQuery();
                if(rs.next()){
                    String cID = rs.getString("chapterID");
                    String nID = rs.getString("novelID");
                    String chapterName = rs.getString("chapterName");
                    String fileURL = rs.getString("fileURL");
                    Date uploadDate = rs.getDate("uploadDate");
                    
                    Chapter chap = new Chapter(cID, nDAO.getNovel(nID), chapterName, fileURL, uploadDate);
                    return chap;
                }
            }
        }
        catch (Exception e) {
        }
        finally{
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(con != null) con.close();
            } 
            catch (Exception e) {
            }
        }
        return null;
    }
    
    public boolean addChapter(Chapter chap){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into Chapter(chapterID, novelID, chapterName, fileURL, uploadDate)"
                + "values(?, ?, ?, ?, ?)";
        try {
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                ps.setString(1, chap.getChapterID());
                ps.setString(2, chap.getNovel().getNovelID());
                ps.setString(3, chap.getChapterName());
                ps.setString(4, chap.getFileURL());
                ps.setDate(5, chap.getUploadDate());
                ps.executeUpdate();
                return true;
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static void main(String[] args) {
        ChapterDAO dao = new ChapterDAO();
        LinkedList<Chapter> lst = dao.getChapters("N000002");
        int index = dao.searchChapterInList(lst, "N000002", "C2");
        System.out.println(index);
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
