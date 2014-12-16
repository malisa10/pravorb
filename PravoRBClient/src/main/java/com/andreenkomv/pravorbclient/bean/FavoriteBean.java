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
    public void createByUserAndAct(int user, int act) {        
        try { // Call Web Service Operation
            FavoritesService port = service.getFavoritesServicePort();
            port.createByUserAndAct(user, act);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void deleteByUserAndAct(int user, int act) {
        try { // Call Web Service Operation
            FavoritesService port = service.getFavoritesServicePort();
            port.deleteByUserAndAct(user, act);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
