/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.bean;

import com.andreenkomv.ws.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Admin
 */
@Stateless
public class HistoryBean implements HistoryBeanLocal {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PravoRBServer-web/HistoryService.wsdl")
    private HistoryService_Service service;

    @Override
    public List<History> getLastActsHistoryByPart(int id) {
        List<History> result = null;
        try { // Call Web Service Operation
            HistoryService port = service.getHistoryServicePort();
            // TODO process result here
            result = port.listLastActsHistoryByPart(id);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return result;
    }

    @Override
    public History getHistory(int id) {
      History result = null;
        try { // Call Web Service Operation
            HistoryService port = service.getHistoryServicePort();
            // TODO process result here
            result = port.getHistory(id);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return result;
    }

    @Override
    public History getLastHistoryByActs(int id) {
      History result = null;
        try { // Call Web Service Operation
            HistoryService port = service.getHistoryServicePort();
            // TODO process result here
            result = port.getLastHistoryByActs(id);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return result;
    }

    @Override
    public History create(Acts act, Texts text, Users user) {
        History result = null;
        try { // Call Web Service Operation
            HistoryService port = service.getHistoryServicePort();
            // TODO initialize WS operation arguments here
            History l = new History();
            l.setActs(act);
            l.setTexts(text);
            l.setUsers(user);
            // TODO process result here
            result = port.createHistory(l);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return result;
    }

    @Override
    public List<History> listHistoryByActs(int id) {
        List<History> result = null;
        try { // Call Web Service Operation
            HistoryService port = service.getHistoryServicePort();
            // TODO process result here
            result = port.listHistoryByActs(id);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return result;
    }
}
