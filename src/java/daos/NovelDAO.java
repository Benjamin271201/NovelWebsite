/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Account;
import dtos.Novel;
import dtos.Tag;
import utils.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chiuy
 */
public class NovelDAO {
    public ArrayList<Novel> getAllNovels() throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Novel> lst = new ArrayList<>();
        String sql = "SELECT * FROM Novel";
        try{
            con = DBConnect.makeConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    String novelID = rs.getString("novelID");
                    String novelName = rs.getString("name");
                    int views = rs.getInt("views");
                    String author = rs.getString("author");
                    Date uploadDate = rs.getDate("uploadDate");
                    String coverURL = rs.getString("coverURL");
                    AccountDAO accDAO = new AccountDAO();
                    Account acc = accDAO.getAccountByUsername(author);
                    Novel n = new Novel(novelID, novelName, views, acc, uploadDate, coverURL);
                    lst.add(n);
                }
            }
        }
        finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
        return lst;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        NovelDAO dao = new NovelDAO();
        ArrayList<Novel> lst = new ArrayList<>();
        lst = dao.getAllNovels();
        for (Novel novel : lst) {
            System.out.println(novel.getNovelID());
            System.out.println(novel.getAuthor().getName());
        }
    }
}
