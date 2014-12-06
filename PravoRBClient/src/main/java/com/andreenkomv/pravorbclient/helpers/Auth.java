/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.helpers;

import com.andreenkomv.ws.Users;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Honaht
 */
public class Auth {
    public static boolean isAuth(HttpServletRequest request) {
        return (request.getSession().getAttribute("user")!=null && ((Users)request.getSession().getAttribute("user")).getGroups().getId()>0);
    }
    
    public static boolean isUser(HttpServletRequest request) {
        return (request.getSession().getAttribute("user")!=null && ((Users)request.getSession().getAttribute("user")).getGroups().getId()==3);
    }
    
    public static boolean isModerator(HttpServletRequest request) {
        return (request.getSession().getAttribute("user")!=null && ((Users)request.getSession().getAttribute("user")).getGroups().getId()==2);
    }
    
    public static boolean isAdmin(HttpServletRequest request) {
        return (request.getSession().getAttribute("user")!=null && ((Users)request.getSession().getAttribute("user")).getGroups().getId()==1);
    }
}
