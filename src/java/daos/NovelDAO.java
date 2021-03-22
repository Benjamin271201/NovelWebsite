/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.Account;
import dtos.Novel;
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
public class NovelDAO {

    public ArrayList<Novel> getAllNovels() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Novel> lst = new ArrayList<>();
        String sql = "SELECT * FROM Novel";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String novelID = rs.getString("novelID");
                    String novelName = rs.getString("name");
                    String author = rs.getString("author");
                    String coverURL = rs.getString("coverURL");
                    AccountDAO accDAO = new AccountDAO();
                    Account acc = accDAO.getAccountByUsername(author);
                    Novel n = new Novel(novelID, novelName, acc, coverURL);
                    lst.add(n);
                }
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
        return lst;
    }
    
    // update a novel based on novelID
    public boolean updateNovel(Novel n) throws SQLException {
        Connection con = null;
                PreparedStatement ps = null;
                String sql =  "UPDATE Novel SET name=?, author=?, coverURL=? WHERE novelID=?";
                try {
                        con = DBConnect.makeConnection();
                        if(con != null) {
                                ps = con.prepareStatement(sql);
                                ps.setString(1, n.getNovelName());
                                ps.setString(2, n.getAuthor().getUsername());
                                ps.setString(3, n.getCoverURL());
                                ps.setString(4, n.getNovelID());
                                ps.executeUpdate();
                                return true;
                        }    
                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                         if (ps != null) {
                                ps.close();
                        }
                        if (con != null) {
                                con.close();
                        }
                }
                return false;
    }

    //  get a novel based on novelID
    public Novel getNovel(String novelID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Novel WHERE novelID=?";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, novelID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String novelName = rs.getString("name");
                    String author = rs.getString("author");
                    String coverURL = rs.getString("coverURL");
                    AccountDAO accDAO = new AccountDAO();
                    Account acc = accDAO.getAccountByUsername(author);
                    Novel n = new Novel(novelID, novelName, acc, coverURL);
                    return n;
                }
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

    public boolean addNovel(Novel n) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO Novel(novelID, name, author, coverURL)"
                + "VALUES(?, ?, ?, ?)";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, n.getNovelID());
                ps.setString(2, n.getNovelName());
                ps.setString(3, n.getAuthor().getUsername());
                ps.setString(4, n.getCoverURL());

                ps.executeUpdate();
                return true;
            }
        } catch (Exception e) {
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public ArrayList<Novel> getUserNovels(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Novel> lst = new ArrayList<>();

        String sql = "SELECT * FROM Novel WHERE author=?";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, username);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String novelID = rs.getString("novelID");
                    String novelName = rs.getString("name");
                    String coverURL = rs.getString("coverURL");
                    AccountDAO accDAO = new AccountDAO();
                    Account acc = accDAO.getAccountByUsername(username);
                    Novel n = new Novel(novelID, novelName, acc, coverURL);
                    lst.add(n);
                }
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
        return lst;
    }

    public ArrayList<Novel> searchNovelByName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Novel> lst = new ArrayList<>();
        String sql = "SELECT * FROM Novel WHERE name LIKE '%" + name + "%'";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
//                ps.setString(1, name);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String novelID = rs.getString("novelID");
                    String novelName = rs.getString("name");
                    String author = rs.getString("author");
                    String coverURL = rs.getString("coverURL");
                    AccountDAO accDAO = new AccountDAO();
                    Account acc = accDAO.getAccountByUsername(author);
                    Novel n = new Novel(novelID, novelName, acc, coverURL);
                    lst.add(n);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public ArrayList<Novel> searchNovelByTag(String tagid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Novel> lst = new ArrayList<>();
        String sql = "SELECT * FROM TagMap WHERE tagID=?";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, tagid);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String novelID = rs.getString("novelID");
                    Novel n = getNovel(novelID);
                    lst.add(n);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lst;
    }

    public Novel getNovelByNameAndUsername(String novelName, String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Novel WHERE name=? AND author=?";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, novelName);
                ps.setString(2, username);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String novelID = rs.getString("novelID");
                    String coverURL = rs.getString("coverURL");
                    AccountDAO accDAO = new AccountDAO();
                    Account acc = accDAO.getAccountByUsername(username);
                    Novel n = new Novel(novelID, novelName, acc, coverURL);
                    return n;
                }
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

    public ArrayList<Novel> getNovelListByID(ArrayList<String> idList) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Novel> lst = new ArrayList<>();
        AccountDAO accDAO = new AccountDAO();

        String sql = "SELECT * FROM Novel WHERE novelID=?";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                for (String id : idList) {
                    ps.setString(1, id);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        String novelName = rs.getString("name");
                        String coverURL = rs.getString("coverURL");
                        String author = rs.getString("author");
                        Account acc = accDAO.getAccountByUsername(author);
                        Novel n = new Novel(id, novelName, acc, coverURL);
                        lst.add(n);
                    }
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
        return lst;
    }

    public boolean addTagMap(String novelID, String tagID) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO TagMap(novelID, tagID)"
                + "VALUES(?, ?)";
        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, novelID);
                ps.setString(2, tagID);
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public boolean deleteNovel(Novel n) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from Bookmark where novelID = ?\n"
                + "delete from Comment where novelID = ?\n"
                + "delete from Chapter where novelID =?\n"
                + "delete from TagMap where novelID = ?\n"
                + "delete from Novel where novelID = ?";

        try {
            con = DBConnect.makeConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, n.getNovelID());
                ps.setString(2, n.getNovelID());
                ps.setString(3, n.getNovelID());
                ps.setString(4, n.getNovelID());
                ps.setString(5, n.getNovelID());

                ps.executeUpdate();
                return true;
            }
        } catch (Exception e) {
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        NovelDAO dao = new NovelDAO();
        ArrayList<Novel> lst = dao.searchNovelByName("god");
        for (Novel novel : lst) {
            System.out.println(novel.getNovelID());
        }

    }
}
