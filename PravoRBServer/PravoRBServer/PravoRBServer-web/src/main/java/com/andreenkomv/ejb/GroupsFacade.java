/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Groups;
import javax.ejb.Stateless;

/**
 *
 * @author
 */
@Stateless
public class GroupsFacade extends AbstractFacade<Groups> implements GroupsFacadeLocal {
    
    public GroupsFacade() {
        super(Groups.class);
    }
}
