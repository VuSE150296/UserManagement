package sample.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.users.UserDAO;

/**
 *
 * @author Vu Dang
 */
//@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SUCCESS="search.html";
    private static final String ERROR="invalid.html";
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, SQLException {
        resp.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try{
            String userID=req.getParameter("userID");
            String password=req.getParameter("password");
            UserDAO dao= new UserDAO();
            String fullName=dao.checkLogin(userID, password);
            if(!fullName.equals("")){
                HttpSession session=req.getSession();
                session.setAttribute("LOGIN_USER", fullName);
                url=SUCCESS;
            }
        }catch(Exception e){
            log("Error at LoginServlet: " + e.toString());
        }finally{
            req.getRequestDispatcher(url).include(req, resp);
        }
    }

//    @Override
//    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        resp.setContentType("text/html;charset=UTF-8");
//        String url=ERROR;
//        try {
//            String idToken = req.getParameter("id_token");
//            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
//            String email = payLoad.getEmail();
//            System.out.println("User email: " + email);
//            
//            HttpSession session = req.getSession(true);
//            req.getServletContext().getRequestDispatcher(SUCCESS).forward(req, resp);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

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
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
