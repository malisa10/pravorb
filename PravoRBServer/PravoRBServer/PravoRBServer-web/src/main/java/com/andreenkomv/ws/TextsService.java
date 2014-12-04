/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ws;

import com.andreenkomv.ejb.service.TextsServiceBeanLocal;
import com.andreenkomv.hibernate.Texts;
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
@WebService(serviceName = "TextsService")
public class TextsService {
    @EJB
    private TextsServiceBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createTexts")
    public Texts createTexts(@WebParam(name = "l") Texts l) {
        return ejbRef.createTexts(l);
    }

    @WebMethod(operationName = "editTexts")
    @Oneway
    public void editTexts(@WebParam(name = "l") Texts l) {
        ejbRef.editTexts(l);
    }

    @WebMethod(operationName = "deleteTexts")
    @Oneway
    public void deleteTexts(@WebParam(name = "l") Texts l) {
        ejbRef.deleteTexts(l);
    }

    @WebMethod(operationName = "getTexts")
    public Texts getTexts(@WebParam(name = "id") Integer id) {
        return ejbRef.getTexts(id);
    }

    @WebMethod(operationName = "listTexts")
    public List<Texts> listTexts() {
        return ejbRef.listTexts();
    }

    @WebMethod(operationName = "countTexts")
    public int countTexts() {
        return ejbRef.countTexts();
    }

    @WebMethod(operationName = "getLastTextsByActs")
    public Texts getLastTextsByActs(@WebParam(name = "id") int id) {
        return ejbRef.getLastTextsByActs(id);
    }
    
}
