/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ws;

import com.andreenkomv.ejb.service.UsersServiceBeanLocal;
import com.andreenkomv.hibernate.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Honaht
 */
@WebService(serviceName = "UsersService")
public class UsersService {
    @EJB
    private UsersServiceBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createUsers")
    public Users createUsers(@WebParam(name = "l") Users l) {
        return ejbRef.createUsers(l);
    }

    @WebMethod(operationName = "editUsers")
    @Oneway
    public void editUsers(@WebParam(name = "l") Users l) {
        ejbRef.editUsers(l);
    }

    @WebMethod(operationName = "deleteUsers")
    @Oneway
    public void deleteUsers(@WebParam(name = "l") Users l) {
        ejbRef.deleteUsers(l);
    }

    @WebMethod(operationName = "getUsers")
    public Users getUsers(@WebParam(name = "id") Integer id) {
        return ejbRef.getUsers(id);
    }

    @WebMethod(operationName = "listUsers")
    public List<Users> listUsers() {
        return ejbRef.listUsers();
    }

    @WebMethod(operationName = "countUsers")
    public int countUsers() {
        return ejbRef.countUsers();
    }

    @WebMethod(operationName = "authUser")
    public Users authUser(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        return ejbRef.authUser(login, password);
    }

    @WebMethod(operationName = "createUser")
    @Oneway
    public void createUser(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        ejbRef.createUser(login, password);
    }

    @WebMethod(operationName = "changePassword")
    @Oneway
    public void changePassword(@WebParam(name = "id") Integer id, @WebParam(name = "password") String password) {
        ejbRef.changePassword(id, password);
    }

    @WebMethod(operationName = "changePasswordSecure")
    @Oneway
    public void changePasswordSecure(@WebParam(name = "id") Integer id, @WebParam(name = "oldpassword") String oldpassword, @WebParam(name = "newpassword") String newpassword) {
        ejbRef.changePasswordSecure(id, oldpassword, newpassword);
    }

    @WebMethod(operationName = "setGroup")
    @Oneway
    public void setGroup(@WebParam(name = "id") Integer id, @WebParam(name = "g") Integer g) {
        ejbRef.setGroup(id, g);
    }

    @WebMethod(operationName = "listUsersOrderByLogin")
    public List<Users> listUsersOrderByLogin() {
        return ejbRef.listUsersOrderByLogin();
    }
    
}
