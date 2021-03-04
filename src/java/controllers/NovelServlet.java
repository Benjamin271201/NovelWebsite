/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AccountDAO;
import daos.NovelDAO;
import daos.TagDAO;
import dtos.Account;
import dtos.Novel;
import dtos.Tag;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chiuy
 */
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
        
        String info = "novel_info.jsp";
        String action = request.getParameter("a");
        PrintWriter out = response.getWriter();
        NovelDAO nDAO = new NovelDAO();
        TagDAO tDAO = new TagDAO();
        AccountDAO aDao = new AccountDAO();
        RequestDispatcher rd = null;
        
        //  a == null -> display website (index.jsp)
        if(action == null){
            ArrayList<Novel> novelList = nDAO.getAllNovels();
            request.setAttribute("novelListObj", novelList);
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
        // a == novel_info -> display novel info
        else if (action.equals("novel_info")) {
            String novelID = (String) request.getParameter("n");
            ArrayList<Tag> tagList = tDAO.getTagList(novelID);
            Novel novelInfo = nDAO.getNovel(novelID);
            rd = request.getRequestDispatcher(info);
            request.setAttribute("taglist", tagList);
            System.out.println(tagList);
            request.setAttribute("novel", novelInfo);
            rd.forward(request, response);
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
