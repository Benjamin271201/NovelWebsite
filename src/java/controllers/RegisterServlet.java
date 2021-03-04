/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AccountDAO;
import dtos.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chiuy
 */
public class RegisterServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
       String action = request.getParameter("action");
       
       //if a==null -> redirect to register_form.html
       if(action == null){
           response.sendRedirect("register_form.jsp");
       }
       
       //if a.equals("register") 
       else if(action.equals("register")){
           String username = request.getParameter("username");
           String password = request.getParameter("password");
           String email = request.getParameter("email");
           String name = request.getParameter("name");
           String avatarURL = request.getParameter("avatar");
           
           //search for duplicated username in database
           AccountDAO dao = new AccountDAO();
           Account foundAccount = dao.getAccountByUsername(username);
           
           //if foundAccount!= null -> dispatch to register_form, keep all inputted values except password
           if(foundAccount != null){
               request.setAttribute("username", username);
               request.setAttribute("email", email);
               request.setAttribute("name", name);
               request.setAttribute("avatar", avatarURL);
               request.getRequestDispatcher("register_form.jsp").forward(request, response);
           }
           
           //else -> add account to database, set session, then redirect to NovelServlet
           else{
               Account newAccount = new Account(username, password, email, name, false, avatarURL);
               AccountDAO aDAO = new AccountDAO();
               aDAO.addAccount(newAccount);
               HttpSession session = request.getSession();
               session.setAttribute("username", newAccount.getUsername());
               response.sendRedirect("NovelServlet");
           }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
