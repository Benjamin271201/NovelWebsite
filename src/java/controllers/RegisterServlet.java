/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AccountDAO;
import dtos.Account;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

@MultipartConfig(
        fileSizeThreshold = 10*1024*1024,
        maxFileSize = 1024*1024*50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})

public class RegisterServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "avatars";
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
       PrintWriter out = response.getWriter();
       
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
           String avatarURL = uploadFile(request);
           
           //search for duplicated username in database
           AccountDAO dao = new AccountDAO();
           Account foundAccount = dao.getAccountByUsername(username);
           Account foundAccountByEmail = dao.getAccountbyEmail(email);
           
           //if foundAccount!= null -> dispatch to register_form, keep all inputted values except password
           if(foundAccount != null){
               request.setAttribute("username", username);
               request.setAttribute("email", email);
               request.setAttribute("name", name);
               request.setAttribute("avatar", avatarURL);
               request.setAttribute("duplicatedUser", foundAccount);
               request.getRequestDispatcher("register_form.jsp").forward(request, response);
           }
           if(foundAccountByEmail != null){
               request.setAttribute("username", username);
               request.setAttribute("email", email);
               request.setAttribute("name", name);
               request.setAttribute("avatar", avatarURL);
               request.setAttribute("duplicatedEmail", foundAccountByEmail);
               request.getRequestDispatcher("register_form.jsp").forward(request, response);
           }
           
           //else -> add account to database, set session, then redirect to NovelServlet
           else{
               if(avatarURL.equals("")){
                   avatarURL = "defaultAvatar.jpg";
               }
               Account newAccount = new Account(username, password, email, name, false, avatarURL);
               AccountDAO aDAO = new AccountDAO();
               aDAO.addAccount(newAccount);
               HttpSession session = request.getSession();
               session.setAttribute("user", newAccount);
               response.sendRedirect("NovelServlet");
           }
       }
    }
    
    private String uploadFile(HttpServletRequest request) throws IOException, ServletException{
        String fileName = "";
        try {
            Part filePart = request.getPart("avatar");
            fileName = (String)getFileName(filePart);
            
            String applicationPath = request.getServletContext().getRealPath("");
            String basePath = applicationPath + File.separator + "images" + File.separator + UPLOAD_DIR + File.separator;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                File outputFilePath = new File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);
                int read = 0;
                final byte[] bytes = new byte[1024];
                while((read = inputStream.read(bytes)) != -1){
                    outputStream.write(bytes, 0, read);
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
                fileName = "";
            }
            finally{
                if(inputStream != null) inputStream.close();
                if(outputStream != null) outputStream.close();
            }
        }
        catch (Exception e) {
            fileName = "";
        }
        return fileName;
    }
    
    private String getFileName(Part part){
        for (String content : part.getHeader("content-disposition").split(";")) {
            if(content.trim().startsWith("filename")){
                return content.substring(content.indexOf('=')+1).trim().replace("\"", "");
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
