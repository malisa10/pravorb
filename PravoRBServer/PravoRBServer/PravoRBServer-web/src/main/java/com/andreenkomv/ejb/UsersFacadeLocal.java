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

    void create(Users u);
    void edit(Users u);
    void remove(Users u);
    Users find(int id);
    List<Users> findAll();
    int count();
    
    Users authUser(String login, String password);
    void createUser(String login, String password);
    void changePassword(Integer id, String password);
    void setGroup(Integer id, Integer g);
    
}