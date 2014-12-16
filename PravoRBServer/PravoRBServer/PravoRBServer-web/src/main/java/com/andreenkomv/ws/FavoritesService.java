/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ws;

import com.andreenkomv.ejb.service.FavoritesServiceBeanLocal;
import com.andreenkomv.hibernate.Favorites;
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
@WebService(serviceName = "FavoritesService")
public class FavoritesService {
    @EJB
    private FavoritesServiceBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createFavorites")
    public Favorites createFavorites(@WebParam(name = "l") Favorites l) {
        return ejbRef.createFavorites(l);
    }

    @WebMethod(operationName = "editFavorites")
    @Oneway
    public void editFavorites(@WebParam(name = "l") Favorites l) {
        ejbRef.editFavorites(l);
    }

    @WebMethod(operationName = "deleteFavorites")
    @Oneway
    public void deleteFavorites(@WebParam(name = "l") Favorites l) {
        ejbRef.deleteFavorites(l);
    }

    @WebMethod(operationName = "getFavorites")
    public Favorites getFavorites(@WebParam(name = "id") Integer id) {
        return ejbRef.getFavorites(id);
    }

    @WebMethod(operationName = "listFavorites")
    public List<Favorites> listFavorites() {
        return ejbRef.listFavorites();
    }

    @WebMethod(operationName = "countFavorites")
    public int countFavorites() {
        return ejbRef.countFavorites();
    }

    @WebMethod(operationName = "listFavoritesByUser")
    public List<Favorites> listFavoritesByUser(@WebParam(name = "user") int user) {
        return ejbRef.listFavoritesByUser(user);
    }

    @WebMethod(operationName = "getByUserAndAct")
    public Favorites getByUserAndAct(@WebParam(name = "user") int user, @WebParam(name = "act") int act) {
        return ejbRef.getByUserAndAct(user, act);
    }

    @WebMethod(operationName = "createByUserAndAct")
    public int createByUserAndAct(@WebParam(name = "user") int user, @WebParam(name = "act") int act) {
        return ejbRef.createByUserAndAct(user, act);
    }

    @WebMethod(operationName = "deleteByUserAndAct")
    @Oneway
    public void deleteByUserAndAct(@WebParam(name = "user") int user, @WebParam(name = "act") int act) {
        ejbRef.deleteByUserAndAct(user, act);
    }
    
}
