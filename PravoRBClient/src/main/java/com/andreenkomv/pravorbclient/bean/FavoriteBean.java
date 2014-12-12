/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.bean;

import com.andreenkomv.ws.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Honaht
 */
@Stateless
public class FavoriteBean implements FavoriteBeanLocal {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PravoRBServer-web/FavoritesService.wsdl")
    private FavoritesService_Service service;
    
    @Override
    public void create(Acts act, Users user) {        
        try { // Call Web Service Operation
            FavoritesService port = service.getFavoritesServicePort();
            // TODO initialize WS operation arguments here
            Favorites l = new Favorites();
            l.setActs(act);
            l.setUsers(user);
            // TODO process result here
            port.createFavorites(l);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Acts act, Users user) {
        try { // Call Web Service Operation
            FavoritesService port = service.getFavoritesServicePort();
            // TODO initialize WS operation arguments here
            Favorites l = port.getByUserAndAct(user.getId(), act.getId());
            // TODO process result here
            port.deleteFavorites(l);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
