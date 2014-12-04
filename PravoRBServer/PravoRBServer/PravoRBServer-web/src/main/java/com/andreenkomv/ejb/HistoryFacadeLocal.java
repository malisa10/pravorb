/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.History;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface HistoryFacadeLocal {
    History create(History g);
    void edit(History g);
    void delete(History g);
    History get(int id);
    List<History> list();
    int count();
    
    List<History> listHistoryByActs(int id);
    List<History> listHistoryByUser(int id);
    History getHistoryByTexts(int id);
}
