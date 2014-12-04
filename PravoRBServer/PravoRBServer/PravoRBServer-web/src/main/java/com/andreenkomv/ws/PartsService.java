/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ws;

import com.andreenkomv.ejb.service.PartsServiceBeanLocal;
import com.andreenkomv.hibernate.Parts;
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
@WebService(serviceName = "PartsService")
public class PartsService {
    @EJB
    private PartsServiceBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createParts")
    public Parts createParts(@WebParam(name = "l") Parts l) {
        return ejbRef.createParts(l);
    }

    @WebMethod(operationName = "editParts")
    @Oneway
    public void editParts(@WebParam(name = "l") Parts l) {
        ejbRef.editParts(l);
    }

    @WebMethod(operationName = "deleteParts")
    @Oneway
    public void deleteParts(@WebParam(name = "l") Parts l) {
        ejbRef.deleteParts(l);
    }

    @WebMethod(operationName = "getParts")
    public Parts getParts(@WebParam(name = "id") Integer id) {
        return ejbRef.getParts(id);
    }

    @WebMethod(operationName = "listParts")
    public List<Parts> listParts() {
        return ejbRef.listParts();
    }

    @WebMethod(operationName = "countParts")
    public int countParts() {
        return ejbRef.countParts();
    }

    @WebMethod(operationName = "listPartsByParent")
    public List<Parts> listPartsByParent(@WebParam(name = "id") int id) {
        return ejbRef.listPartsByParent(id);
    }
    
}
