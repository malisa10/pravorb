/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.hibernate.Texts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface TextsServiceBeanLocal {
    public Texts createTexts(Texts l);    
    public void editTexts(Texts l);    
    public void deleteTexts(Texts l);         
    public Texts getTexts(Integer id);
    public List<Texts> listTexts();
    public int countTexts();
    
    Texts getLastTextsByActs(int id);
}
