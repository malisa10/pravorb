/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.servlets;

import com.andreenkomv.pravorbclient.bean.AuthBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
    private AuthBeanLocal authBean;

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
        authBean.setSession(request.getSession());
        if ((action != null) && (action.equals("logout"))) {
            authBean.Logout();
            response.sendRedirect(request.getContextPath() + "/user?action=login");
        } else if ((action != null) && (action.equals("login"))) {
            if (!authBean.isAuth()) {
                request.getRequestDispatcher("/user_login.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else if ((action != null) && (action.equals("register"))) {
            if (!authBean.isAuth()) {
                request.getRequestDispatcher("/user_register.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else if ((action != null) && (action.equals("info"))) {
            if (authBean.isAuth()) {
                request.getRequestDispatcher("/user_info.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/user?action=login");
            }
        } else if ((action != null) && (action.equals("list"))) {
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
        authBean.setSession(request.getSession());
        if ((action != null) && (action.equals("login"))) {
            if (!authBean.isAuth()) {
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                if (authBean.Auth(login, password) != null) {
                    response.sendRedirect(request.getContextPath() + "/");
                } else {
                    response.sendRedirect(request.getContextPath() + "/user?action=login");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/");
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
