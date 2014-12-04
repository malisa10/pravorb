/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Texts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface TextsFacadeLocal {
    Texts create(Texts g);
    void edit(Texts g);
    void delete(Texts g);
    Texts get(int id);
    List<Texts> list();
    int count();
    
    Texts getLastTextsByActs(int id);
}
