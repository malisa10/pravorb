/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ws;

import com.andreenkomv.ejb.service.HistoryServiceBeanLocal;
import com.andreenkomv.hibernate.History;
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
@WebService(serviceName = "HistoryService")
public class HistoryService {
    @EJB
    private HistoryServiceBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createHistory")
    public History createHistory(@WebParam(name = "l") History l) {
        return ejbRef.createHistory(l);
    }

    @WebMethod(operationName = "editHistory")
    @Oneway
    public void editHistory(@WebParam(name = "l") History l) {
        ejbRef.editHistory(l);
    }

    @WebMethod(operationName = "deleteHistory")
    @Oneway
    public void deleteHistory(@WebParam(name = "l") History l) {
        ejbRef.deleteHistory(l);
    }

    @WebMethod(operationName = "getHistory")
    public History getHistory(@WebParam(name = "id") Integer id) {
        return ejbRef.getHistory(id);
    }

    @WebMethod(operationName = "listHistory")
    public List<History> listHistory() {
        return ejbRef.listHistory();
    }

    @WebMethod(operationName = "countHistory")
    public int countHistory() {
        return ejbRef.countHistory();
    }

    @WebMethod(operationName = "listHistoryByActs")
    public List<History> listHistoryByActs(@WebParam(name = "id") int id) {
        return ejbRef.listHistoryByActs(id);
    }

    @WebMethod(operationName = "listHistoryByUser")
    public List<History> listHistoryByUser(@WebParam(name = "id") int id) {
        return ejbRef.listHistoryByUser(id);
    }

    @WebMethod(operationName = "listLastActsHistoryByPart")
    public List<History> listLastActsHistoryByPart(@WebParam(name = "id") int id) {
        return ejbRef.listLastActsHistoryByPart(id);
    }

    @WebMethod(operationName = "listLastActsHistoryByUserFavorites")
    public List<History> listLastActsHistoryByUserFavorites(@WebParam(name = "id") int id) {
        return ejbRef.listLastActsHistoryByUserFavorites(id);
    }

    @WebMethod(operationName = "getHistoryByTexts")
    public History getHistoryByTexts(@WebParam(name = "id") int id) {
        return ejbRef.getHistoryByTexts(id);
    }

    @WebMethod(operationName = "getLastHistoryByActs")
    public History getLastHistoryByActs(@WebParam(name = "id") int id) {
        return ejbRef.getLastHistoryByActs(id);
    }

    @WebMethod(operationName = "listHistoryBySearch")
    public List<History> listHistoryBySearch(@WebParam(name = "search") String search) {
        return ejbRef.listHistoryBySearch(search);
    }
    
}
