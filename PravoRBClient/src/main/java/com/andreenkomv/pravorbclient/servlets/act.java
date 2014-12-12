/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.servlets;

import com.andreenkomv.pravorbclient.bean.ActBeanLocal;
import com.andreenkomv.pravorbclient.helpers.HTMLHelper;
import com.andreenkomv.pravorbclient.bean.HistoryBeanLocal;
import com.andreenkomv.pravorbclient.bean.PartBeanLocal;
import com.andreenkomv.pravorbclient.bean.TextBeanLocal;
import com.andreenkomv.pravorbclient.bean.UserBeanLocal;
import com.andreenkomv.ws.*;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class act extends HttpServlet {
    @EJB
    private UserBeanLocal userBean;
    @EJB
    private HistoryBeanLocal historyBean;
    @EJB
    private PartBeanLocal partBean;
    @EJB
    private ActBeanLocal actBean;
    @EJB
    private TextBeanLocal textBean;
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
        if ((action != null) && (action.equals("show"))) {
            String historyid = request.getParameter("history");
            String actid = request.getParameter("act");
            if (historyid!=null) {
                History history = historyBean.getHistory(Integer.valueOf(historyid));
                request.setAttribute("history", history);
                request.setAttribute("timeedit", HTMLHelper.XMLGregorianCalendarToString(history.getTimeEdit()));
                request.setAttribute("access",userBean.isModeratorRights());
                request.getRequestDispatcher("/act_show.jsp").forward(request, response);
            } else if (actid!=null) {
                History history = historyBean.getLastHistoryByActs(Integer.valueOf(actid));
                request.setAttribute("history", history);
                request.setAttribute("timeedit", HTMLHelper.XMLGregorianCalendarToString(history.getTimeEdit()));
                request.setAttribute("access",userBean.isModeratorRights());
                request.getRequestDispatcher("/act_show.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else if ((action != null) && (action.equals("create")) && userBean.isModeratorRights()) {
            request.getRequestDispatcher("/act_create.jsp").forward(request, response);            
        } else if ((action != null) && (action.equals("delete")) && userBean.isModeratorRights()) {
            String act = request.getParameter("act");
            if (act != null) {                
                actBean.delete(Integer.valueOf(act));
            }
            response.sendRedirect(request.getHeader("referer"));           
        } else if ((action != null) && (action.equals("addedition")) && userBean.isModeratorRights()) {
            String _oldhistory = request.getParameter("oldhistory");
            String _act = request.getParameter("act");
            if (_act==null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
            History oldhistory = null;
            if (_oldhistory!=null) {
                oldhistory = historyBean.getHistory(Integer.valueOf(_oldhistory));
            } else {
                oldhistory = historyBean.getLastHistoryByActs(Integer.valueOf(_act));
            }
            request.setAttribute("history", oldhistory);
            request.getRequestDispatcher("/act_edit.jsp").forward(request, response);
        }else {
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
        String action = request.getParameter("action");
        userBean.setSession(request.getSession());
        if ((action != null) && (action.equals("create")) && userBean.isModeratorRights()) {
            String partid = request.getParameter("part");
            String name = request.getParameter("name");
            String _text = request.getParameter("text");
            Parts part = null;
            if (partid!=null) {
                part = partBean.get(Integer.valueOf(partid));
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
            Acts act = actBean.create(part);
            Texts text = textBean.create(name, _text);
            historyBean.create(act,text,userBean.getUser());
            response.sendRedirect(request.getContextPath() + "/part?action=list&part="+partid);
        } else if((action != null) && (action.equals("addedition")) && userBean.isModeratorRights()) {
           String actid = request.getParameter("act");
            String name = request.getParameter("name");
            String _text = request.getParameter("text");
            Acts act = null;
            if (actid!=null) {
               act = actBean.get(Integer.valueOf(actid));
            } else {
               response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
            Texts text = textBean.create(name, _text);
            historyBean.create(act,text,userBean.getUser());
            response.sendRedirect(request.getContextPath() + "/part?action=list&part="+act.getParts().getId().toString());            
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
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
