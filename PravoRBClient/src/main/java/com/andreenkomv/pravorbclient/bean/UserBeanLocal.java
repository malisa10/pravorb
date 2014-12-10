/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.bean;

import com.andreenkomv.ws.Users;
import java.util.List;
import javax.ejb.Local;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@Local
public interface UserBeanLocal {
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
    public void ChangePassword(String oldpassword, String newpassword);
    public void Logout();
    
    //Admin
    public Users getUser(int id);
    public void Create(String login, String password);
    public void SetInfo(int id, String firstname, String lastname, String email, String address, String zipcode, String telephone);
    public void ChangePassword(int id, String newpassword);
    public void SetGroup(int id, int group);
    public void Delete(int id);
    public List<Users> List();
    
}
