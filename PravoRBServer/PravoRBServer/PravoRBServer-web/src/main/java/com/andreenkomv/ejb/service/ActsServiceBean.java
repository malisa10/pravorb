/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.ejb.ActsFacadeLocal;
import com.andreenkomv.hibernate.Acts;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class ActsServiceBean implements ActsServiceBeanLocal {
    @EJB
    private ActsFacadeLocal ActsFacade;

    @Override
    public Acts createActs(Acts l) {
        return ActsFacade.create(l);
    }

    @Override
    public void editActs(Acts l) {
        ActsFacade.edit(l);
    }

    @Override
    public void deleteActs(Acts l) {
        ActsFacade.delete(l);
    }

    @Override
    public Acts getActs(Integer id) {
        return ActsFacade.get(id);
    }

    @Override
    public List<Acts> listActs() {
        return ActsFacade.list();
    }
    
    @Override
    public int countActs() {
        return ActsFacade.count();
    }

    @Override
    public List<Acts> listActsByPart(int id) {
        return ActsFacade.listActsByPart(id);
    }

    @Override
    public Acts getActsByTexts(int id) {
        return ActsFacade.getActsByTexts(id);
    }

    @Override
    public boolean getActsInFavorites(int act, int user) {
        return ActsFacade.inFavorites(act, user);
    }
    
    
}
