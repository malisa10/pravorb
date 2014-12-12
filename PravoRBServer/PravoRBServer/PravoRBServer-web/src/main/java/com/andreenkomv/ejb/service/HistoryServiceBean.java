/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.ejb.HistoryFacadeLocal;
import com.andreenkomv.hibernate.History;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class HistoryServiceBean implements HistoryServiceBeanLocal {
    @EJB
    private HistoryFacadeLocal HistoryFacade;

    @Override
    public History createHistory(History l) {
        return HistoryFacade.create(l);
    }

    @Override
    public void editHistory(History l) {
        HistoryFacade.edit(l);
    }

    @Override
    public void deleteHistory(History l) {
        HistoryFacade.delete(l);
    }

    @Override
    public History getHistory(Integer id) {
        return HistoryFacade.get(id);
    }

    @Override
    public List<History> listHistory() {
        return HistoryFacade.list();
    }
    
    @Override
    public int countHistory() {
        return HistoryFacade.count();
    }

    @Override
    public List<History> listHistoryByActs(int id) {
        return HistoryFacade.listHistoryByActs(id);
    }

    @Override
    public List<History> listHistoryByUser(int id) {
        return HistoryFacade.listHistoryByUser(id);
    }

    @Override
    public History getHistoryByTexts(int id) {
        return HistoryFacade.getHistoryByTexts(id);
    }

    @Override
    public List<History> listLastActsHistoryByPart(int id) {
        return HistoryFacade.listLastActsHistoryByPart(id);
    }
    
    @Override
    public History getLastHistoryByActs(int id) {
        return HistoryFacade.getLastHistoryByActs(id);
    }
}
