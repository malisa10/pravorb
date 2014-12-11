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
public class PartBean implements PartBeanLocal {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PravoRBServer-web/PartsService.wsdl")
    private PartsService_Service service;

    @Override
    public List<Parts> listRoot() {
        List<Parts> result = null;
        try { // Call Web Service Operation
            PartsService port = service.getPartsServicePort();
            result = port.listPartsByParent(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Parts> listParent(int id) {
        List<Parts> result = null;
        try { // Call Web Service Operation
            PartsService port = service.getPartsServicePort();
            result = port.listPartsByParent(id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }
    
    @Override
    public List<Parts> list() {
        List<Parts> result = null;
        try { // Call Web Service Operation
            PartsService port = service.getPartsServicePort();
            result = port.listParts();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public void create(int parent, String name) {
try { // Call Web Service Operation
            PartsService port = service.getPartsServicePort();
            Parts part = new Parts();
            part.setName(name);
            part.setParent(parent);
            port.createParts(part);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void edit(int id, int parent, String name) {
        try { // Call Web Service Operation
            PartsService port = service.getPartsServicePort();
            Parts part = port.getParts(id);
            part.setName(name);
            part.setParent(parent);
            port.editParts(part);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try { // Call Web Service Operation
            PartsService port = service.getPartsServicePort();
            port.deletePartsById(id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public Parts get(int id) {
        Parts part = null;
        try { // Call Web Service Operation
            PartsService port = service.getPartsServicePort();
            part = port.getParts(id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return part;
    }
}
