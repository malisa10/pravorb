/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.ejb.TextsFacadeLocal;
import com.andreenkomv.hibernate.Texts;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class TextsServiceBean implements TextsServiceBeanLocal {
    @EJB
    private TextsFacadeLocal TextsFacade;

    @Override
    public Texts createTexts(Texts l) {
        return TextsFacade.create(l);
    }

    @Override
    public void editTexts(Texts l) {
        TextsFacade.edit(l);
    }

    @Override
    public void deleteTexts(Texts l) {
        TextsFacade.delete(l);
    }

    @Override
    public Texts getTexts(Integer id) {
        return TextsFacade.get(id);
    }

    @Override
    public List<Texts> listTexts() {
        return TextsFacade.list();
    }
    
    @Override
    public int countTexts() {
        return TextsFacade.count();
    }

    @Override
    public Texts getLastTextsByActs(int id) {
        return TextsFacade.getLastTextsByActs(id);
    }
}
