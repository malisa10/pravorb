/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Acts;
import java.util.List;

/**
 *
 * @author
 */
public interface ActsFacadeLocal {
    Acts create(Acts g);
    void edit(Acts g);
    void delete(Acts g);
    Acts get(int id);
    List<Acts> list();
    int count();
    
    List<Acts> listActsByPart(int id);
    Acts getActsByTexts(int id);
}
