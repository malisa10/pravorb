/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.ejb.GroupsFacadeLocal;
import com.andreenkomv.hibernate.Groups;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author
 */
@Stateless
public class GroupsServiceBean implements GroupsServiceBeanLocal {
    @EJB
    private GroupsFacadeLocal GroupsFacade;

    @Override
    public Groups createGroups(Groups l) {
        return GroupsFacade.create(l);
    }

    @Override
    public void editGroups(Groups l) {
        GroupsFacade.edit(l);
    }

    @Override
    public void deleteGroups(Groups l) {
        GroupsFacade.delete(l);
    }

    @Override
    public Groups getGroups(Integer id) {
        return GroupsFacade.get(id);
    }

    @Override
    public List<Groups> listGroups() {
        return GroupsFacade.list();
    }
    
    @Override
    public int countGroups() {
        return GroupsFacade.count();
    }
}
