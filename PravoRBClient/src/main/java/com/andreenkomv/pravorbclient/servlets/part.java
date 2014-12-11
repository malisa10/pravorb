/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.servlets;

import com.andreenkomv.peavorbclient.helpers.HTMLHelper;
import com.andreenkomv.pravorbclient.bean.HistoryBeanLocal;
import com.andreenkomv.pravorbclient.bean.PartBeanLocal;
import com.andreenkomv.pravorbclient.bean.UserBeanLocal;
import com.andreenkomv.ws.*;
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
public class part extends HttpServlet {
    @EJB
    private UserBeanLocal userBean;
    @EJB
    private PartBeanLocal partBean;
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
        if ((action != null) && (action.equals("list"))) {
            String part = request.getParameter("part");
            List<Parts> rowsParts = null;
            List<History> lastEditionActs = null;
            List<String> headersParts = null;
            if (part != null) {
                headersParts = HTMLHelper.getPartsListHeader(partBean.get(Integer.valueOf(part)).getName());
                rowsParts = partBean.listParent(Integer.valueOf(part));
                lastEditionActs = historyBean.getLastActsHistoryByPart(Integer.valueOf(part));
            } else {
                headersParts = HTMLHelper.getPartsListHeader("Корневой раздел");
                rowsParts = partBean.listRoot();
            }
            int access = 999;
            if (userBean.isAuth()) {
                access = userBean.getUser().getGroups().getId();
            } else {
                access = 4;
            }
            request.setAttribute("headersParts", headersParts);
            request.setAttribute("rowsParts", HTMLHelper.getPartsListValues(rowsParts, request.getContextPath(),access));
            if (lastEditionActs!=null) {
                request.setAttribute("rowsActs", HTMLHelper.getActsListValues(lastEditionActs, request.getContextPath(),access));                
            }
            request.getRequestDispatcher("/part_list.jsp").forward(request, response);
            
        } else if ((action != null) && action.equals("delete") && userBean.isModeratorRights()) {
            String part = request.getParameter("part");
            if (part != null) {                
                partBean.delete(Integer.valueOf(part));
            }
            response.sendRedirect(request.getHeader("referer"));
            
        } else if ((action != null) && action.equals("edit") && userBean.isModeratorRights()) {
            String id = request.getParameter("part");
            if (id!=null) {
                Parts part = partBean.get(Integer.valueOf(id));
                List<Parts> parts = partBean.list();
                request.setAttribute("part_edit", part);
                request.setAttribute("parentPartSelect", HTMLHelper.getSelect("parent", HTMLHelper.getMapParts(parts), part.getParent(), part.getId()));
                request.getRequestDispatcher("/part_edit.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getHeader("referer"));
            }
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
        String action = request.getParameter("action");
        userBean.setSession(request.getSession());
        if ((action != null) && action.equals("create") && userBean.isModeratorRights()) {
            String name = request.getParameter("name");
            String parent = request.getParameter("parent");
            partBean.create(Integer.valueOf(parent), name);
            response.sendRedirect(request.getContextPath() + "/part?action=list&part="+parent);
        } else if ((action != null) && action.equals("edit") && userBean.isModeratorRights()) {
            String id = request.getParameter("part");
            String name = request.getParameter("name");
            String parent = request.getParameter("parent");
            partBean.edit(Integer.valueOf(id), Integer.valueOf(parent), name);
            response.sendRedirect(request.getContextPath() + "/part?action=list&part="+parent);
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
