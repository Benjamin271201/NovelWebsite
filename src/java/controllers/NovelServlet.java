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
import org.apache.tomcat.util.http.fileupload.FileUtils;

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
        ArrayList<Tag> tagList = tDAO.getAllTags();
        getServletContext().setAttribute("tagListObj", tagList);

        HttpSession session = request.getSession(false);
        //  a == null -> display website (index.jsp)
        if (action == null) {
            ArrayList<Novel> novelList = nDAO.getAllNovels();
            request.setAttribute("novelListObj", novelList);
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else if (action.equals("searchname")) {
            String name = request.getParameter("nameSearch");
            name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            ArrayList<Novel> lstName = nDAO.searchNovelByName(name);
            if (lstName.size() > 0) {
                request.setAttribute("novelListObj", lstName);
            } else {
                request.setAttribute("NONOVELERROR", "No novels could be found");
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (action.equals("searchtag")) {
            String tagID = request.getParameter("id");
            Tag foundTag = tDAO.getTag(tagID);
            if (foundTag != null) {
                ArrayList<Novel> novelTagLst = nDAO.searchNovelByTag(tagID);
                if (novelTagLst.size() > 0) {
                    request.setAttribute("novelListObj", novelTagLst);
                    request.setAttribute("tag", tDAO.getTag(tagID));
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
        } // a == novel_info -> display novel info
        else if (action.equals("novel_info")) {
            String novelID = (String) request.getParameter("n");
            ArrayList<Tag> tList = tDAO.getTagList(novelID);
            Novel novelInfo = nDAO.getNovel(novelID);
            Account user = (Account) session.getAttribute("user");
            LinkedList<Chapter> chapterList = cDAO.getChapters(novelID);
            if (user != null) {
                boolean isBookmarked = bDAO.isBookmarked(user.getUsername(), novelID);
                request.setAttribute("bookmark", isBookmarked);
            }
            rd = request.getRequestDispatcher(info);
            request.setAttribute("taglist", tList);
            request.setAttribute("chapterlist", chapterList);
            request.setAttribute("novel", novelInfo);
            rd.forward(request, response);
        } else if (session.getAttribute("user") != null) {
            Account user = (Account) session.getAttribute("user");
            if (action.equals("n_form")) {
                response.sendRedirect("insert_novel_form.jsp");
            } else if (action.equals("n_add")) {
                String novelName = request.getParameter("novelName");
                ArrayList<Novel> nList = nDAO.getAllNovels();
                String[] tagNameList = request.getParameterValues("tag");
                if (tagNameList == null || tagNameList.length > 5) {
                    request.setAttribute("TAGERROR", "Please choose between 1 and 5 tags only");
                    request.setAttribute("novelName", novelName);
                    request.getRequestDispatcher("insert_novel_form.jsp").forward(request, response);
                } else if (nDAO.getNovelByNameAndUsername(novelName, user.getUsername()) != null) {
                    Novel dupNovel = nDAO.getNovelByNameAndUsername(novelName, user.getUsername());
                    request.setAttribute("DUPLICATEDNOVELERROR", "This Novel name has already been added by you. Do you want to add a chapter to this novel ?");
                    request.setAttribute("dupNovelObj", dupNovel);
                    request.setAttribute("novelName", novelName);
                    request.getRequestDispatcher("insert_novel_form.jsp").forward(request, response);
                } else {
                    String novelID = "N1";
                    for (Novel novel : nList) {
                        if (novel.getNovelID().equalsIgnoreCase(novelID)) {
                            novelID = "N" + (Integer.parseInt(novelID.substring(1)) + 1);
                        }
                    }
                    String coverURL = getFileName(request.getPart("coverURL"));
                    if (coverURL.equals("")) {
                        coverURL = "defaultCover.png";
                    }
                    else{
                        coverURL = this.uploadFile(request, novelID);
                    }
                    novelName = new String(novelName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                    Novel newNovel = new Novel(novelID, novelName, user, coverURL);
                    nDAO.addNovel(newNovel);
                    createFolder(novelID);
                    for (String string : tagNameList) {
                        nDAO.addTagMap(novelID, string);
                    }
                    response.sendRedirect("NovelServlet");
                }
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
            else if(action.equals("del")){
                String novelID = request.getParameter("nid");
                Novel n = nDAO.getNovel(novelID);
                if(n ==  null){
                    request.setAttribute("NOVELNOTFOUND", "Could not find this novel");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                    if(!n.getCoverURL().equals("defaultCover.png")){
                        deleteCover(novelID);
                    }
                    nDAO.deleteNovel(n);
                    deleteFile(novelID);
                    response.sendRedirect("NovelServlet");
                }
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
        String path = getServletContext().getRealPath("") + "/novels/" + novelID;
        System.out.println(path);
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }
    
    public void deleteFile(String novelID) throws IOException{
        String filepath = getServletContext().getRealPath("") + "/novels/" + novelID;
        File directory = new File(filepath);
        if(!directory.exists()){
            return;
        }
        else{
            FileUtils.cleanDirectory(directory);
            directory.delete();
        }
    }
    
    public void deleteCover(String novelID){
        String filepath = getServletContext().getRealPath("") + "/images/covers/" + novelID + ".jpg";
        File file = new File(filepath);
        if(!file.exists()) return;
        else file.delete();
    }

    private String uploadFile(HttpServletRequest request, String novelID) throws IOException, ServletException {
        String fileName = "";
        try {
            Part filePart = request.getPart("coverURL");
//            fileName = (String) getFileName(filePart);
            fileName = novelID + ".jpg";
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
            } catch (IOException e) {
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
        } catch (IOException | ServletException e) {
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
