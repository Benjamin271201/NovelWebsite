/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ChapterDAO;
import daos.NovelDAO;
import dtos.Chapter;
import dtos.Novel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chiuy
 */
@WebServlet(name = "ChapterServlet", urlPatterns = {"/ChapterServlet"})
public class ChapterServlet extends HttpServlet {

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
        String action = request.getParameter("a");
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("LoginServlet");
        } else {
            if (action.equals("addchapform")) {
                String nid = request.getParameter("nid");
                NovelDAO nDAO = new NovelDAO();
                Novel novel = nDAO.getNovel(nid);
                request.setAttribute("novelObj", novel);
                request.getRequestDispatcher("chap_form.jsp").forward(request, response);
            } else if (action.equals("add")) {
                String novelID = request.getParameter("nid");
                String chapID = "C1";
                String chapName = request.getParameter("chapname");
                String content = request.getParameter("content");
                byte[] bytes = content.getBytes(StandardCharsets.ISO_8859_1);
                content = new String(bytes, StandardCharsets.UTF_8);
                ChapterDAO cDAO = new ChapterDAO();
                LinkedList<Chapter> chapList = cDAO.getChapters(novelID);
                for (Chapter chapter : chapList) {
                    if (chapID.equalsIgnoreCase(chapter.getChapterID())) {
                        chapID = "C" + (Integer.parseInt(chapID.substring(1)) + 1);
                    }
                }
                String fileURL = chapID + ".txt";
                NovelDAO nDAO = new NovelDAO();
                Novel n = nDAO.getNovel(novelID);
                java.sql.Date uploadDate = new Date(System.currentTimeMillis());
                Chapter chap = new Chapter(chapID, n, chapName, fileURL, uploadDate);
                boolean create = createFile(chap, content);
                if (create == false) {
                    response.sendRedirect("error.jsp");
                } else {
                    cDAO.addChapter(chap);
                    response.sendRedirect("NovelServlet");
                }
            }
        }
    }

    public boolean createFile(Chapter chap, String content) throws FileNotFoundException, IOException {
        String filepath = getServletContext().getRealPath("") + "/Novels/" + chap.getNovel().getNovelID() + "/" + chap.getFileURL();
        File f = new File(filepath);
        if (f.exists()) {
            return false;
        } else {
//                FileWriter fw = new FileWriter(f).;
//                fw.write(content);
//                fw.close();
//                return true;
            try {
                Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), StandardCharsets.UTF_8));
                out.append(content);
                out.flush();
                out.close();
                return true;
            }catch(FileNotFoundException e){
                log("ERRORWRITEFILE: " + e.getMessage());
            }

        }
        return false;
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
