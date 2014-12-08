/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.hibernate.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author
 */
@Local
public interface UsersServiceBeanLocal {        
    public Users createUsers(Users l);    
    public void editUsers(Users l);    
    public void deleteUsers(Users l);         
    public Users getUsers(Integer id);
    public List<Users> listUsers();
    public int countUsers();
    
    public Users authUser(String login, String password);
    public void createUser(String login, String password);
    public void changePassword(Integer id, String password);
    public void changePasswordSecure(Integer id, String oldpassword, String newpassword);
    public void setGroup(Integer id, Integer g);
    void setInfo(Integer id, String firstname, String lastname, String email, String address, String zipcode, String telephone);
    public List<Users> listUsersOrderByLogin();
}
