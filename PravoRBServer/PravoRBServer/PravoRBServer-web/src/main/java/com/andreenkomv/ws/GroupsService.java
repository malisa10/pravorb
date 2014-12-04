/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ws;

import com.andreenkomv.ejb.service.GroupsServiceBeanLocal;
import com.andreenkomv.hibernate.Groups;
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
@WebService(serviceName = "GroupsService")
public class GroupsService {
    @EJB
    private GroupsServiceBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createGroups")
    public Groups createGroups(@WebParam(name = "l") Groups l) {
        return ejbRef.createGroups(l);
    }

    @WebMethod(operationName = "editGroups")
    @Oneway
    public void editGroups(@WebParam(name = "l") Groups l) {
        ejbRef.editGroups(l);
    }

    @WebMethod(operationName = "deleteGroups")
    @Oneway
    public void deleteGroups(@WebParam(name = "l") Groups l) {
        ejbRef.deleteGroups(l);
    }

    @WebMethod(operationName = "getGroups")
    public Groups getGroups(@WebParam(name = "id") Integer id) {
        return ejbRef.getGroups(id);
    }

    @WebMethod(operationName = "listGroups")
    public List<Groups> listGroups() {
        return ejbRef.listGroups();
    }

    @WebMethod(operationName = "countGroups")
    public int countGroups() {
        return ejbRef.countGroups();
    }
    
}
