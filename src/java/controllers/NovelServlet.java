/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.BookmarkDAO;
import daos.ChapterDAO;
import daos.CommentDAO;
import daos.NovelDAO;
import daos.TagDAO;
import dtos.Account;
import dtos.Chapter;
import dtos.Comment;
import dtos.Novel;
import dtos.Tag;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author chiuy
 */
@WebServlet(name = "NovelServlet", urlPatterns = {"/NovelServlet"})
@MultipartConfig(
        fileSizeThreshold = 10 * 1024 * 1024,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
public class NovelServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String info = "novel_info.jsp";
        String action = request.getParameter("a");
        
        NovelDAO nDAO = new NovelDAO();
        TagDAO tDAO = new TagDAO();
        ChapterDAO cDAO = new ChapterDAO();
        RequestDispatcher rd = null;
        CommentDAO cmDAO = new CommentDAO();
        BookmarkDAO bDAO = new BookmarkDAO();
        
        
        HttpSession session = request.getSession(false);
        //  a == null -> display website (index.jsp)
        if (action == null) {
            System.out.println(action);
            ArrayList<Novel> novelList = nDAO.getAllNovels();
            request.setAttribute("novelListObj", novelList);
            ArrayList<Tag> tagList = tDAO.getAllTags();
            getServletContext().setAttribute("tagListObj", tagList);
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else if (action.equals("searchname")) {
            String name = request.getParameter("nameSearch");
            ArrayList<Novel> lstName = nDAO.searchNovelByName(name);
            if (lstName.size() > 0) {
                request.setAttribute("novelListObj", lstName);
            } else {
                request.setAttribute("NONOVELERROR", "No novels could be found");
            }
            rd = request.getRequestDispatcher("NovelServlet?");
            rd.forward(request, response);
        } else if (action.equals("searchtag")) {
            String tagID = request.getParameter("id");
            Tag foundTag = tDAO.getTag(tagID);
            if (foundTag != null) {
                ArrayList<Novel> novelTagLst = nDAO.searchNovelByTag(tagID);
                if (novelTagLst.size() > 0) {
                    request.setAttribute("novelListObj", novelTagLst);
                } else {
                    request.setAttribute("NONOVELERROR", "No novels could be found");
                }
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("TAGNOTFOUNDERROR", "Tag not found");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } // a == read -> display a specific chapter
        // based on n(novelID) and c(chapterID)
        else if (action.equals("read")) {
            String nID = request.getParameter("n");
            String cID = request.getParameter("c");
            String filepath = getServletContext().getRealPath("") + "/Novels/" + nID + "/" + cID + ".txt";
            ArrayList<String> linesFromFile = new ArrayList<>();
            linesFromFile = (ArrayList<String>) readFile(filepath);
            Novel currNovel = nDAO.getNovel(nID);
            LinkedList<Chapter> cList = cDAO.getChapters(nID);
            int index = cDAO.searchChapterInList(cList, nID, cID);
            Chapter currChap = cList.get(index);

            //get Previous chapter
            Chapter prevChap = null;
            if (index - 1 >= 0) {
                prevChap = cList.get(index - 1);
            }

            //get next chapter
            Chapter nextChap = null;
            if (index + 1 < cList.size()) {
                nextChap = cList.get(index + 1);
            }
            if (prevChap != null) {
                request.setAttribute("prevChap", prevChap);
            }
            if (nextChap != null) {
                request.setAttribute("nextChap", nextChap);
            }

            //get all comments
            LinkedList<Comment> commentList = cmDAO.searchCommentsByChapter(nID, cID);

            request.setAttribute("comments", commentList);
            request.setAttribute("currNovel", currNovel);
            request.setAttribute("currChap", currChap);
            request.setAttribute("chapLines", linesFromFile);
            request.getRequestDispatcher("chapter.jsp").forward(request, response);
        }
        // a == novel_info -> display novel info
        else if (action.equals("novel_info")) {
            String novelID = (String) request.getParameter("n");
            ArrayList<Tag> tagList = tDAO.getTagList(novelID);
            Novel novelInfo = nDAO.getNovel(novelID);
            Account user = (Account) session.getAttribute("user");
            LinkedList<Chapter> chapterList = cDAO.getChapters(novelID);
            if (user != null) {
                boolean isBookmarked = bDAO.isBookmarked(user.getUsername(), novelID);
                request.setAttribute("bookmark", isBookmarked);
            }
            rd = request.getRequestDispatcher(info);
            request.setAttribute("taglist", tagList);
            request.setAttribute("chapterlist", chapterList);
            request.setAttribute("novel", novelInfo);
            rd.forward(request, response);
        } else if (session != null) {
            if (action.equals("n_form")) {
                response.sendRedirect("insert_novel_form.jsp");
            } else if (action.equals("n_add")) {
                String novelName = request.getParameter("novelName");
                String coverURL = uploadFile(request);
                ArrayList<Novel> nList = nDAO.getAllNovels();
                String novelID = "N1";
                for (Novel novel : nList) {
                    if (novel.getNovelID().equalsIgnoreCase(novelID)) {
                        novelID = "N" + (Integer.parseInt(novelID.substring(1)) + 1);
                    }
                }
                if(coverURL.equals("")){
                    coverURL = "defaultCover.png";
                }
                Account user = (Account) session.getAttribute("user");
                Novel newNovel = new Novel(novelID, novelName, 0, user, coverURL);
                nDAO.addNovel(newNovel);
                createFolder(novelID);
                response.sendRedirect("NovelServlet");
            } else if (action.equals("display")) {
                String username = request.getParameter("u");
                ArrayList<Novel> lst = nDAO.getUserNovels(username);
                if (lst.size() > 0) {
                    request.setAttribute("addFlag", "addFlag");
                    request.setAttribute("novelListObj", lst);
                } else {
                    request.setAttribute("NONOVELERROR", "No novels could be found");
                    request.setAttribute("flag", "");
                }
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } else {
            response.sendRedirect("LoginServlet");
        }
    }

    public List<String> readFile(String filepath) {
        Path path = Paths.get(filepath);
        List<String> linesList = new ArrayList<>();
        try {
            linesList = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String string : linesList) {
                System.out.println(string);
            }
            return linesList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createFolder(String novelID) {
        String path = getServletContext().getRealPath("") + "/Novels/" + novelID;
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
        String fileName = "";
        try {
            Part filePart = request.getPart("coverURL");
            fileName = (String) getFileName(filePart);

            String applicationPath = request.getServletContext().getRealPath("");
            String basePath = applicationPath + File.separator + "images" + File.separator + "covers" + File.separator;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                File outputFilePath = new File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (Exception e) {
                e.printStackTrace();
                fileName = "";
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (Exception e) {
            fileName = "";
        }
        return fileName;
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
