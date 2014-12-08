package com.andreenkomv.ejb.service;

import com.andreenkomv.ejb.UsersFacadeLocal;
import com.andreenkomv.hibernate.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@Stateless
public class UsersServiceBean implements UsersServiceBeanLocal {
    @EJB
    private UsersFacadeLocal UsersFacade;

    @Override
    public Users createUsers(Users l) {
        return UsersFacade.create(l);
    }

    @Override
    public void editUsers(Users l) {
        UsersFacade.edit(l);
    }

    @Override
    public void deleteUsers(Users l) {
        UsersFacade.delete(l);
    }

    @Override
    public Users getUsers(Integer id) {
        return UsersFacade.get(id);
    }

    @Override
    public List<Users> listUsers() {
        return UsersFacade.list();
    }
    
    @Override
    public int countUsers() {
        return UsersFacade.count();
    }

    @Override
    public Users authUser(String login, String password) {
        return UsersFacade.authUser(login, password);
    }

    @Override
    public void createUser(String login, String password) {
        UsersFacade.createUser(login, password);
    }

    @Override
    public void changePassword(Integer id, String password) {
        UsersFacade.changePassword(id, password);
    }

    @Override
    public void changePasswordSecure(Integer id, String oldpassword, String newpassword) {
        UsersFacade.changePasswordSecure(id, oldpassword, newpassword);
    }

    @Override
    public void setGroup(Integer id, Integer g) {
        UsersFacade.setGroup(id, g);
    }

    @Override
    public void setInfo(Integer id, String firstname, String lastname, String email, String address, String zipcode, String telephone) {
        UsersFacade.setInfo(id, firstname, lastname, email, address, zipcode, telephone);
    }

    @Override
    public List<Users> listUsersOrderByLogin() {
        return UsersFacade.listUsersOrderByLogin();
    }
}
