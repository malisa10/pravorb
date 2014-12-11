/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.ejb.PartsFacadeLocal;
import com.andreenkomv.hibernate.Parts;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class PartsServiceBean implements PartsServiceBeanLocal {
    @EJB
    private PartsFacadeLocal PartsFacade;

    @Override
    public Parts createParts(Parts l) {
        return PartsFacade.create(l);
    }

    @Override
    public void editParts(Parts l) {
        PartsFacade.edit(l);
    }

    @Override
    public void deleteParts(Parts l) {
        PartsFacade.delete(l);
    }

    @Override
    public Parts getParts(Integer id) {
        return PartsFacade.get(id);
    }

    @Override
    public List<Parts> listParts() {
        return PartsFacade.list();
    }
    
    @Override
    public int countParts() {
        return PartsFacade.count();
    }

    @Override
    public List<Parts> listPartsByParent(int id) {
        return PartsFacade.listPartsByParent(id);
    }

    @Override
    public void deletePartsById(int id) {
        PartsFacade.delete(id);
    }
}
