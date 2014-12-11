/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Parts;
import java.util.List;

public interface PartsFacadeLocal {
    Parts create(Parts g);
    void edit(Parts g);
    void delete(Parts g);
    Parts get(int id);
    List<Parts> list();
    int count();
    
    List<Parts> listPartsByParent(int id);
    void delete(int id);
}
