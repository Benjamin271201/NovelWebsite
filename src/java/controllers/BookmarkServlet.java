/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.BookmarkDAO;
import daos.NovelDAO;
import dtos.Account;
import dtos.Novel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS GAMING
 */
@WebServlet(name = "BookmarkServlet", urlPatterns = {"/BookmarkServlet"})
public class BookmarkServlet extends HttpServlet {

    private String test = "test";
    
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
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);
            Account user = (Account) session.getAttribute("user");
            String novelID = request.getParameter("id");
            String SUCCESS = "NovelServlet";
            String ERROR = "error.jsp";
            BookmarkDAO bdao = new BookmarkDAO();
            NovelDAO ndao = new NovelDAO();
            String action = request.getParameter("a");
            if (user == null) {
                response.sendRedirect("LoginServlet");
            } else {
                //  action == null -> add/remove bookmark of a novel
                if (action == null) {
                    if (user != null) {
                        if (bdao.bookmarkHandler(user.getUsername(), novelID)) {
                            request.getRequestDispatcher("NovelServlet?a=novel_info&n=" + novelID).forward(request, response);
                        } else {
                            response.sendRedirect(ERROR);
                        }
                    } else {
                        response.sendRedirect("login_form.jsp");
                    }
                } else if (action.equals("bookmark_list")) {
                    ArrayList<String> idList = bdao.getBookmarkIDList(user);
                    ArrayList<Novel> nList = ndao.getNovelListByID(idList);
                    if (nList.size() > 0) {
                        request.setAttribute("novelListObj", nList);
                        request.setAttribute("BOOKMARKFLAG", "Your Bookmarks");
                    } else {
                        request.setAttribute("EMPTYBOOKMARK", "You haven't bookmarked any novel yet!");
                        request.setAttribute("flag", "");
                    }
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
