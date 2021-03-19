/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AccountDAO;
import daos.NovelDAO;
import dtos.Account;
import dtos.Novel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ManageAccountServlet", urlPatterns = {"/ManageAccountServlet"})
public class ManageAccountServlet extends HttpServlet {

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
        String action = request.getParameter("a");
        HttpSession session = request.getSession(false);
        Account user = (Account) session.getAttribute("user");
        if(user != null){
            if(action == null){
                NovelDAO nDAO = new NovelDAO();
                ArrayList<Novel> nList = nDAO.getUserNovels(user.getUsername());
                request.setAttribute("nList", nList);
                request.setAttribute("currUser", user);
                request.getRequestDispatcher("account_info.jsp").forward(request, response);
            }
            else if(action.equals("updateaccform")){
               request.getRequestDispatcher("update_acc_form.jsp").forward(request, response);
            }
            else if(action.equals("update")){
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                String name = request.getParameter("name");
                String avatarURL = uploadFile(request);
                AccountDAO dao = new AccountDAO();
                if(!email.equals(user.getEmail()) && dao.getAccountbyEmail(email)!=null){
                    request.setAttribute("DUPLICATEDEMAILERROR", "This email has been used by another account");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                else{
                    Account acc;
                    if(avatarURL.equals("")){
                        avatarURL = user.getAvatarURL();
                    }
                    if(user.isIsAdmin() == true){
                        acc = new Account(username, password, email, name, true, avatarURL);
                    }
                    else{
                        acc = new Account(username, password, email, name, false, avatarURL);
                    }
                    boolean up = dao.updateAccount(acc);
                    if(up == false){
                        request.setAttribute("UPDATEFAILDERROR", "Failed to update account");
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                        out.println(up);
                    }
                    else{
                        session.invalidate();
                        session = request.getSession();
                        session.setAttribute("user", acc);
                        response.sendRedirect("ManageAccountServlet");
                    }
                }
            }
        }
        else{
            request.setAttribute("ACCOUNTNOTFOUNDERROR", "Could not find this account");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
    
    private String uploadFile(HttpServletRequest request) throws IOException, ServletException{
        String fileName = "";
        try {
            Part filePart = request.getPart("avatar");
            fileName = (String)getFileName(filePart);
            String applicationPath = request.getServletContext().getRealPath("");
            String basePath = applicationPath + File.separator + "images" + File.separator +"avatars" + File.separator;
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
            catch (IOException e) {
                log("Error Uploading File: " + e.getMessage());
                fileName = "";
            }
            finally{
                if(inputStream != null) inputStream.close();
                if(outputStream != null) outputStream.close();
            }
        }
        catch (IOException | ServletException e) {
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
