/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.hibernate.Groups;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author
 */
@Local
public interface GroupsServiceBeanLocal {        
    public Groups createGroups(Groups l);    
    public void editGroups(Groups l);    
    public void deleteGroups(Groups l);         
    public Groups getGroups(Integer id);
    public List<Groups> listGroups();
    public int countGroups();
}
