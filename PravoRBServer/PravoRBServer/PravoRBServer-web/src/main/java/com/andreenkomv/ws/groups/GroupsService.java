/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ws.groups;

import com.andreenkomv.ejb.GroupsFacadeLocal;
import com.andreenkomv.hibernate.Groups;
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
@WebService(serviceName = "GroupsService")
public class GroupsService {
    @EJB
    private GroupsFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "g") Groups g) {
        ejbRef.create(g);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "g") Groups g) {
        ejbRef.edit(g);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "g") Groups g) {
        ejbRef.remove(g);
    }

    @WebMethod(operationName = "find")
    public Groups find(@WebParam(name = "id") int id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Groups> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
