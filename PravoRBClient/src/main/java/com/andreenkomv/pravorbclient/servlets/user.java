/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.servlets;

import com.andreenkomv.pravorbclient.bean.UserBeanLocal;
import com.andreenkomv.ws.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class user extends HttpServlet {

    @EJB
    private UserBeanLocal userBean;

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
            out.println("<title>Servlet user</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet user at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        userBean.setSession(request.getSession());
        if ((action != null) && (action.equals("logout"))) {
            userBean.Logout();
            response.sendRedirect(request.getContextPath() + "/user?action=login");
        } else if ((action != null) && (action.equals("login"))) {
            if (!userBean.isAuth()) {
                request.getRequestDispatcher("/user_login.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else if ((action != null) && (action.equals("register"))) {
            if (!userBean.isAuth()) {
                request.getRequestDispatcher("/user_register.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else if ((action != null) && (action.equals("info"))) {
            String user = request.getParameter("user");
            if ((user != null) && userBean.isAdmin()) {
                    Users user_info = userBean.getUser(Integer.valueOf(user));
                    request.setAttribute("user_info", user_info);
                    request.getRequestDispatcher("/user_info.jsp").forward(request, response);                
            } else {
                if (userBean.isAuth()) {
                    Users user_info = userBean.getUser();
                    request.setAttribute("user_info", user_info);
                    request.getRequestDispatcher("/user_info.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/user?action=login");
                }
            }
        } else if ((action != null) && (action.equals("changepassword"))) {
            String user = request.getParameter("user");
            if ((user != null) && userBean.isAdmin()) {
                request.getRequestDispatcher("/user_changepassword.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/user_changepasswordsecure.jsp").forward(request, response);
            }
        } else if ((action != null) && (action.equals("list")) && userBean.isAdmin()) {
            List<Users> users = userBean.List();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/user_list.jsp").forward(request, response);
        } else if ((action != null) && (action.equals("create")) && userBean.isAdmin()) {
            request.getRequestDispatcher("/user_create.jsp").forward(request, response);
        } else if ((action != null) && (action.equals("delete")) && userBean.isAdmin()) {
            String user = request.getParameter("user");
            userBean.Delete(Integer.valueOf(user));
            response.sendRedirect(request.getContextPath() + "/user?action=list");
        } else if ((action != null) && (action.equals("setgroup")) && userBean.isAdmin()) {
            String user = request.getParameter("user");
            String group = request.getParameter("group");
            userBean.SetGroup(Integer.valueOf(user), Integer.valueOf(group));
            response.sendRedirect(request.getContextPath() + "/user?action=list");
        } else {
            response.sendRedirect(request.getContextPath() + "/");
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
        String action = request.getParameter("action");
        userBean.setSession(request.getSession());
        if ((action != null) && (action.equals("login"))) {
            if (!userBean.isAuth()) {
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                if (userBean.Auth(login, password) != null) {
                    response.sendRedirect(request.getContextPath() + "/");
                } else {
                    response.sendRedirect(request.getContextPath() + "/user?action=login");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else if ((action != null) && (action.equals("register"))) {
            if (!userBean.isAuth()) {
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                userBean.Register(login, password);
                response.sendRedirect(request.getContextPath() + "/user?action=login");
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else if ((action != null) && (action.equals("info"))) {
            String user = request.getParameter("user");
            if ((user != null) && userBean.isAdmin()) {
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String zipcode = request.getParameter("zipcode");
                String telephone = request.getParameter("telephone");
                userBean.SetInfo(Integer.valueOf(user), firstname, lastname, email, address, zipcode, telephone);
                response.sendRedirect(request.getContextPath() + "/user?action=list");
            } else {
                if (userBean.isAuth()) {
                    String firstname = request.getParameter("firstname");
                    String lastname = request.getParameter("lastname");
                    String email = request.getParameter("email");
                    String address = request.getParameter("address");
                    String zipcode = request.getParameter("zipcode");
                    String telephone = request.getParameter("telephone");
                    userBean.SetInfo(firstname, lastname, email, address, zipcode, telephone);
                    response.sendRedirect(request.getContextPath() + "/user?action=info");
                } else {
                    response.sendRedirect(request.getContextPath() + "/user?action=login");
                }
            }
        } else if ((action != null) && (action.equals("changepassword"))) {
            String user = request.getParameter("user");
            if ((user != null) && userBean.isAdmin()) {
                String newpassword = request.getParameter("newpassword");
                userBean.ChangePassword(Integer.valueOf(user), newpassword);
                response.sendRedirect(request.getContextPath() + "/user?action=info&user="+user);
            } else {
                if (userBean.isAuth()) {
                    String oldpassword = request.getParameter("oldpassword");
                    String newpassword = request.getParameter("newpassword");
                    userBean.ChangePassword(oldpassword, newpassword);
                    response.sendRedirect(request.getContextPath() + "/user?action=info");
                } else {
                    response.sendRedirect(request.getContextPath() + "/user?action=login");
                }
            }
        } else if ((action != null) && (action.equals("create"))) {
            if (userBean.isAdmin()) {
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                userBean.Create(login, password);
                response.sendRedirect(request.getContextPath() + "/user?action=list");
            }
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
