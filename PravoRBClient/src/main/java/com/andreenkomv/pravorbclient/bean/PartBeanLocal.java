/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.bean;

import com.andreenkomv.ws.Parts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface PartBeanLocal {
    public List<Parts> list();
    public List<Parts> listRoot();
    public List<Parts> listParent(int id);
    public Parts get(int id);
    public void create(int parent, String name);
    public void edit(int id, int parent, String name);
    public void delete(int id);
}
