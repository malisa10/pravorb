/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.bean;

import com.andreenkomv.ws.Users;
import javax.ejb.Local;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@Local
public interface AuthBeanLocal {
    public HttpSession getSession();
    public void setSession(HttpSession session);    
    public boolean isAuth();
    public boolean isUser();
    public boolean isModerator();
    public boolean isAdmin();
    public Users getUser();
    public Users Auth(String login, String password);
    public void Register(String login, String password);
    public void SetInfo(String firstname, String lastname, String email, String address, String zipcode, String telephone);
    public void ChangePasswordSecure(String oldpassword, String newpassword);
    public void Logout();
}
