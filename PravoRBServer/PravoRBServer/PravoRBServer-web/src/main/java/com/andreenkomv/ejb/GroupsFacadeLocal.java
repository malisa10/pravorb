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
    Groups create(Groups g);
    void edit(Groups g);
    void delete(Groups g);
    Groups get(int id);
    List<Groups> list();
    int count();
}
