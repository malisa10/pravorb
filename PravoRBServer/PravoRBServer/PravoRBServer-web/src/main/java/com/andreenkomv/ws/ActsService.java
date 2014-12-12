/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ws;

import com.andreenkomv.ejb.service.ActsServiceBeanLocal;
import com.andreenkomv.hibernate.Acts;
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
@WebService(serviceName = "ActsService")
public class ActsService {
    @EJB
    private ActsServiceBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createActs")
    public Acts createActs(@WebParam(name = "l") Acts l) {
        return ejbRef.createActs(l);
    }

    @WebMethod(operationName = "editActs")
    @Oneway
    public void editActs(@WebParam(name = "l") Acts l) {
        ejbRef.editActs(l);
    }

    @WebMethod(operationName = "deleteActs")
    @Oneway
    public void deleteActs(@WebParam(name = "l") Acts l) {
        ejbRef.deleteActs(l);
    }

    @WebMethod(operationName = "getActs")
    public Acts getActs(@WebParam(name = "id") Integer id) {
        return ejbRef.getActs(id);
    }

    @WebMethod(operationName = "listActs")
    public List<Acts> listActs() {
        return ejbRef.listActs();
    }

    @WebMethod(operationName = "countActs")
    public int countActs() {
        return ejbRef.countActs();
    }

    @WebMethod(operationName = "listActsByPart")
    public List<Acts> listActsByPart(@WebParam(name = "id") int id) {
        return ejbRef.listActsByPart(id);
    }

    @WebMethod(operationName = "getActsByTexts")
    public Acts getActsByTexts(@WebParam(name = "id") int id) {
        return ejbRef.getActsByTexts(id);
    }

    @WebMethod(operationName = "getActsInFavorites")
    public boolean getActsInFavorites(@WebParam(name = "act") int act, @WebParam(name = "user") int user) {
        return ejbRef.getActsInFavorites(act, user);
    }
    
}
