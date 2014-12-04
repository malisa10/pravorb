/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.hibernate.Parts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface PartsServiceBeanLocal {
    public Parts createParts(Parts l);    
    public void editParts(Parts l);    
    public void deleteParts(Parts l);         
    public Parts getParts(Integer id);
    public List<Parts> listParts();
    public int countParts();
    
    public List<Parts> listPartsByParent(int id);    
}
