/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.helpers;

import javax.servlet.http.HttpServletRequest;
import com.andreenkomv.ws.*;

/**
 *
 * @author Honaht
 */
public class Auth {

    public static boolean isAuth(HttpServletRequest request) {
        return (request.getSession().getAttribute("user") != null && ((Users) request.getSession().getAttribute("user")).getGroups().getId() > 0);
    }

    public static boolean isUser(HttpServletRequest request) {
        return (request.getSession().getAttribute("user") != null && ((Users) request.getSession().getAttribute("user")).getGroups().getId() == 3);
    }

    public static boolean isModerator(HttpServletRequest request) {
        return (request.getSession().getAttribute("user") != null && ((Users) request.getSession().getAttribute("user")).getGroups().getId() == 2);
    }

    public static boolean isAdmin(HttpServletRequest request) {
        return (request.getSession().getAttribute("user") != null && ((Users) request.getSession().getAttribute("user")).getGroups().getId() == 1);
    }

    public static Users getUser(HttpServletRequest request) {
        if (Auth.isAuth(request)) {
            int id = ((Users) request.getSession().getAttribute("user")).getId();
            try { // Call Web Service Operation
                UsersService_Service service = new UsersService_Service();
                UsersService port = service.getUsersServicePort();
                // TODO process result here
                Users result = port.getUsers(id);
                result.setPassword(null);
                return result;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    public static Users Auth(HttpServletRequest request, String login, String password) {
        try { // Call Web Service Operation
            UsersService_Service service = new UsersService_Service();
            UsersService port = service.getUsersServicePort();
            Users user = port.authUser(login, password);
            if (user != null && user.getGroups().getId() > 0) {
                user.setPassword(null);
                request.getSession().setAttribute("user", user);
                return user;
            } else {
                request.getSession().setAttribute("user", null);
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public static void Register(HttpServletRequest request, String login, String password) {
        try { // Call Web Service Operation
            UsersService_Service service = new UsersService_Service();
            UsersService port = service.getUsersServicePort();
            if (!Auth.isAuth(request)) {
                port.createUser(login, password);
                Auth.Auth(request, login, password);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void SetInfo(HttpServletRequest request, String firstname, String lastname, String email, String address, String zipcode, String telephone) {
        try { // Call Web Service Operation
            UsersService_Service service = new UsersService_Service();
            UsersService port = service.getUsersServicePort();
            if (Auth.isAuth(request)) {
                int id = ((Users) request.getSession().getAttribute("user")).getId();
                port.setInfo(id, firstname, lastname, email, address, zipcode, telephone);
                Users user = port.getUsers(id);
                user.setPassword(null);
                request.getSession().setAttribute("user", user);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void ChangePasswordSecure(HttpServletRequest request, String oldpassword, String newpassword) {
        try {
            int id = 0;
            if (Auth.isAuth(request)) {
                ((Users) request.getSession().getAttribute("user")).getId();
            } else {
                return;
            }
            UsersService_Service service = new UsersService_Service();
            UsersService port = service.getUsersServicePort();
            port.changePasswordSecure(id, oldpassword, newpassword);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void Logout(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
    }
}
