///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sample.stackjava;
//
//import java.io.IOException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import sample.users.GooglePojo;
//import sample.utils.GoogleUtils;
//@WebServlet(urlPatterns = {"/login"})
//public class LoginGoogleServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    public LoginGoogleServlet() {
//        super();
//  }
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//    String code = request.getParameter("loginbygoogle");
//    if (code == null || code.isEmpty()) {
//        RequestDispatcher dis = request.getRequestDispatcher("login.html");
//        dis.forward(request, response);
//    } else {
//        String accessToken = GoogleUtils.getToken(code);
//        GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
//        request.setAttribute("id", googlePojo.getId());
//        request.setAttribute("name", googlePojo.getName());
//        request.setAttribute("email", googlePojo.getEmail());
//        RequestDispatcher dis = request.getRequestDispatcher("search.html");
//        dis.forward(request, response);
//    }
//  }
//  @Override
//    protected void doPost (HttpServletRequest req,
//                        HttpServletResponse resp)
//                        throws ServletException, IOException {
//
//        resp.setContentType("text/html");
//
//        try {
//            String idToken = req.getParameter("id_token");
//            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
//            String name = (String) payLoad.get("name");
//            String email = payLoad.getEmail();
//            System.out.println("User name: " + name);
//            System.out.println("User email: " + email);
//
//            HttpSession session = req.getSession(true);
//            session.setAttribute("userName", name);
//            req.getServletContext()
//               .getRequestDispatcher("/welcome-page.jsp").forward(req, resp);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
