/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.servlets;

import com.andreenkomv.pravorbclient.bean.ActBeanLocal;
import com.andreenkomv.pravorbclient.bean.FavoriteBeanLocal;
import com.andreenkomv.pravorbclient.bean.HistoryBeanLocal;
import com.andreenkomv.pravorbclient.bean.UserBeanLocal;
import com.andreenkomv.pravorbclient.helpers.HTMLHelper;
import com.andreenkomv.ws.History;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class favorites extends HttpServlet {
    @EJB
    private UserBeanLocal userBean;
    @EJB
    private FavoriteBeanLocal favoriteBean;    
    @EJB
    private ActBeanLocal actBean;    
    @EJB
    private HistoryBeanLocal historyBean;


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
        if (action!=null && action.equals("create") && userBean.isAuth()) {
            String act=request.getParameter("act");
            if (act!=null) {                
                favoriteBean.create(actBean.get(Integer.valueOf(act)), userBean.getUser());
                response.sendRedirect(request.getContextPath()+"/favorites?action=list");
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else if (action!=null && action.equals("delete") && userBean.isAuth()) {
            String act=request.getParameter("act");
            if (act!=null) {                
                favoriteBean.delete(actBean.get(Integer.valueOf(act)), userBean.getUser());
                response.sendRedirect(request.getContextPath()+"/favorites?action=list");
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }        
        } else if (action!=null && action.equals("list") && userBean.isAuth()) {            
            List<History> histories = historyBean.getLastActsHistoryByUserFavorites(userBean.getUser().getId()); 
            request.setAttribute("rowsActs", HTMLHelper.getActsListValues(histories, request.getContextPath(),userBean.getUser().getGroups().getId(), actBean, userBean.getUser()));
            request.getRequestDispatcher("/favorites_list.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
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
