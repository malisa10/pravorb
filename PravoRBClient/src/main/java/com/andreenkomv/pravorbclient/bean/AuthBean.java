/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.bean;

import com.andreenkomv.ws.*;
import javax.ejb.Stateful;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;

@Stateful
public class AuthBean implements AuthBeanLocal {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PravoRBServer-web/UsersService.wsdl")
    private UsersService_Service service;    
    
    private HttpSession session;

    @Override
    public HttpSession getSession() {
        return session;
    }

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }
        
    @Override
    public boolean isAuth() {
        return (session.getAttribute("user") != null && ((Users) session.getAttribute("user")).getGroups().getId() > 0);
    }

    @Override
    public boolean isUser() {
        return (session.getAttribute("user") != null && ((Users) session.getAttribute("user")).getGroups().getId() == 3);
    }

    @Override
    public boolean isModerator() {
        return (session.getAttribute("user") != null && ((Users) session.getAttribute("user")).getGroups().getId() == 2);
    }

    @Override
    public boolean isAdmin() {
        return (session.getAttribute("user") != null && ((Users) session.getAttribute("user")).getGroups().getId() == 1);
    }

    @Override
    public Users getUser() {
        if (this.isAuth()) {
            int id = ((Users) session.getAttribute("user")).getId();
            try { // Call Web Service Operation
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

    @Override
    public Users Auth(String login, String password) {
        try { // Call Web Service Operation
            UsersService port = service.getUsersServicePort();
            Users user = port.authUser(login, password);
            if (user != null && user.getGroups().getId() > 0) {
                user.setPassword(null);
                session.setAttribute("user", user);
                return user;
            } else {
                session.setAttribute("user", null);
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public void Register(String login, String password) {
        try { // Call Web Service Operation
            UsersService port = service.getUsersServicePort();
            if (!this.isAuth()) {
                port.createUser(login, password);
                this.Auth(login, password);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void SetInfo(String firstname, String lastname, String email, String address, String zipcode, String telephone) {
        try { // Call Web Service Operation
            UsersService port = service.getUsersServicePort();
            if (this.isAuth()) {
                int id = ((Users) session.getAttribute("user")).getId();
                port.setInfo(id, firstname, lastname, email, address, zipcode, telephone);
                Users user = port.getUsers(id);
                user.setPassword(null);
                session.setAttribute("user", user);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void ChangePasswordSecure(String oldpassword, String newpassword) {
        try {
            int id = 0;
            if (this.isAuth()) {
                ((Users) session.getAttribute("user")).getId();
            } else {
                return;
            }
            UsersService port = service.getUsersServicePort();
            port.changePasswordSecure(id, oldpassword, newpassword);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Logout() {
        session.setAttribute("user", null);
    }
}
