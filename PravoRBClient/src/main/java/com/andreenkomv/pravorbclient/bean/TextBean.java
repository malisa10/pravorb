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
public class TextBean implements TextBeanLocal {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PravoRBServer-web/TextsService.wsdl")
    private TextsService_Service service;

    @Override
    public Texts create(String name, String text) {
        Texts result = null;
        try { // Call Web Service Operation
            TextsService port = service.getTextsServicePort();
            // TODO initialize WS operation arguments here
            Texts l = new Texts();
            l.setName(name);
            l.setText(text);
            // TODO process result here
            result = port.createTexts(l);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return result;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
