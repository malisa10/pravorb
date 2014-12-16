/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.bean;

import com.andreenkomv.ws.*;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface ActBeanLocal {
    public Acts create(Parts part);
    public Acts get(int id);
    public void delete(int id);
    public int count();
    public boolean inFavorites(int act, int user);
}
