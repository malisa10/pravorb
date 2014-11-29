/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Groups;
import java.util.List;

/**
 *
 * @author
 */
public interface GroupsFacadeLocal {
    void create(Groups g);
    void edit(Groups g);
    void remove(Groups g);
    Groups find(int id);
    List<Groups> findAll();
    int count();
}
