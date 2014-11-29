/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ws.users;

import com.andreenkomv.ejb.UsersFacadeLocal;
import com.andreenkomv.hibernate.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author
 */
@WebService(serviceName = "UsersService")
public class UsersService {
    @EJB
    private UsersFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "u") Users u) {
        ejbRef.create(u);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "u") Users u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "u") Users u) {
        ejbRef.remove(u);
    }

    @WebMethod(operationName = "find")
    public Users find(@WebParam(name = "id") int id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Users> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
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

    @WebMethod(operationName = "setGroup")
    @Oneway
    public void setGroup(@WebParam(name = "id") Integer id, @WebParam(name = "g") Integer g) {
        ejbRef.setGroup(id, g);
    }
    
}
