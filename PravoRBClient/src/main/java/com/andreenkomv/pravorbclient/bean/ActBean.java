/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.bean;

import com.andreenkomv.ws.*;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Admin
 */
@Stateless
public class ActBean implements ActBeanLocal {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PravoRBServer-web/ActsService.wsdl")
    private ActsService_Service service;

    @Override
    public Acts create(Parts part) {
        Acts result = null;
        try { // Call Web Service Operation
            ActsService port = service.getActsServicePort();
            Acts l = new Acts();
            l.setParts(part);
            result = port.createActs(l);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void delete(int id) {
        try { // Call Web Service Operation
            ActsService port = service.getActsServicePort();
            Acts act = port.getActs(id);
            port.deleteActs(act);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public Acts get(int id) {
        Acts result = null;
        try { // Call Web Service Operation
            ActsService port = service.getActsServicePort();
            result = port.getActs(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
