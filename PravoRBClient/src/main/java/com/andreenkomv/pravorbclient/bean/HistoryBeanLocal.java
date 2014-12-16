/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.bean;

import com.andreenkomv.ws.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface HistoryBeanLocal {

    public History create(Acts act, Texts text, Users user);
    public void delete(int id);
    public List<History> getLastActsHistoryByPart(int id);    
    public List<History> getLastActsHistoryByUserFavorites(int id);
    public List<History> listHistoryByActs(int id);
    public History getHistory(int id);
    public History getLastHistoryByActs(int id);
    public List<History> listHistoryBySearch(String search);
}
