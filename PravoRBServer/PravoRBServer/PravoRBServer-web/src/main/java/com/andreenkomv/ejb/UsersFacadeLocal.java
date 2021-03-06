/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Users;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author
 */
public interface UsersFacadeLocal {
    Users create(Users u);
    void edit(Users u);
    void delete(Users u);
    Users get(int id);
    List<Users> list();
    int count();
    
    Users authUser(String login, String password);
    void createUser(String login, String password);
    void changePassword(Integer id, String password);
    void changePasswordSecure(Integer id, String oldpassword, String newpassword);
    void setGroup(Integer id, Integer g);
    void setInfo(Integer id, String firstname, String lastname, String email, String address, String zipcode, String telephone);
    List<Users> listUsersOrderByLogin();
    
}