/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.users.UserDTO;

/**
 *
 * @author Vu Dang
 */
public class SearchServletResult extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search Result</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session=request.getSession();
            out.println("<h1>Welcome: " + session.getAttribute("LOGIN_USER") + "</h1>");
            out.println("<form action='SearchServlet'>");
            out.println("Search <input type='text' name='search' value=" + request.getParameter("search") + " />");
            out.println("<input type='submit' name='action' value='Search' />");
            out.println("<h3>Result: " + request.getParameter("search") + "</h3>");
            List<UserDTO> list=(List<UserDTO>) request.getAttribute("LIST_USER");
            if(list!=null){
                if(!list.isEmpty()){
                    out.println("<table border='1'>");
            out.println("<thead>");
                out.println("<tr>");
                    out.println("<th>No</th>");
                    out.println("<th>UserID</th>");
                   out.println(" <th>FullName</th>");
                    out.println("<th>RoleID</th>");
                    out.println("<th>Password</th>");
                out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            int no=1;
                    for (UserDTO user : list) {
                        out.println("<tr>");
                            out.println("<td>" + no++ +"</td>");
                            out.println("<td>"+ user.getUserID()+"</td>");
                            out.println("<td>"+ user.getFullName() +"</td>");
                            out.println("<td>"+ user.getRoleID() +"</td>");
                            out.println("<td>"+ user.getPassword() +"</td>");
                        out.println("</tr>");
                    }
                
           out.println("</tbody>");
       out.println("</table>");
                }
            }
            out.println("</body>");
            out.println("</html>");
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
