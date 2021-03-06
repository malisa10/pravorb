/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.servlets;

import com.andreenkomv.pravorbclient.bean.HistoryBeanLocal;
import com.andreenkomv.pravorbclient.bean.UserBeanLocal;
import com.andreenkomv.pravorbclient.helpers.HTMLHelper;
import com.andreenkomv.ws.History;
import java.io.IOException;
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
public class history extends HttpServlet {
    @EJB
    private UserBeanLocal userBean;
    @EJB
    private HistoryBeanLocal historyBean;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        if ((action != null) && (action.equals("list"))) {
            String _act = request.getParameter("act");
            if (_act != null) {
                List<History> histories = historyBean.listHistoryByActs(Integer.valueOf(_act));
                int access = 999;
                if (userBean.isAuth()) {
                    access = userBean.getUser().getGroups().getId();
                } else {
                    access = 4;
                }
                request.setAttribute("histories", HTMLHelper.getHistoryListValues(histories, request.getContextPath(), access));
                request.getRequestDispatcher("/history_list.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else if ((action != null) && (action.equals("show"))) {
            String historyid = request.getParameter("history");
            if (historyid!=null) {
                History history = historyBean.getHistory(Integer.valueOf(historyid));
                request.setAttribute("history", history);
                request.setAttribute("timeedit", HTMLHelper.XMLGregorianCalendarToString(history.getTimeEdit()));
                request.setAttribute("access",userBean.isModeratorRights());
                request.getRequestDispatcher("/history_show.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else if ((action != null) && (action.equals("delete")) && userBean.isModeratorRights()) {
            String _history = request.getParameter("history");
            if (_history != null) {
                historyBean.delete(Integer.valueOf(_history));
                response.sendRedirect(request.getHeader("referer"));
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
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
        if ((action != null) && (action.equals("search"))) {
            String _searchstring = request.getParameter("searchstring");
                List<History> histories = historyBean.listHistoryBySearch(_searchstring);
                int access = 999;
                if (userBean.isAuth()) {
                    access = userBean.getUser().getGroups().getId();
                } else {
                    access = 4;
                }
                request.setAttribute("histories", HTMLHelper.getHistoryListValues(histories, request.getContextPath(), access));
                request.getRequestDispatcher("/history_list.jsp").forward(request, response);
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
