/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.hibernate.History;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface HistoryServiceBeanLocal {
    public History createHistory(History l);    
    public void editHistory(History l);    
    public void deleteHistory(History l);         
    public History getHistory(Integer id);
    public List<History> listHistory();
    public int countHistory();
    
    List<History> listHistoryByActs(int id);
    List<History> listHistoryByUser(int id);
    List<History> listLastActsHistoryByPart(int id);
    List<History> listLastActsHistoryByUserFavorites(int id);
    History getHistoryByTexts(int id);
    public History getLastHistoryByActs(int id);
    public List<History> listHistoryBySearch(String search);
}
