/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.hibernate.Acts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface ActsServiceBeanLocal {
        public Acts createActs(Acts l);    
    public void editActs(Acts l);    
    public void deleteActs(Acts l);         
    public Acts getActs(Integer id);
    public List<Acts> listActs();
    public int countActs();
    
    public List<Acts> listActsByPart(int id);   
    public Acts getActsByTexts(int id);
    public boolean getActsInFavorites(int act, int user);
}
