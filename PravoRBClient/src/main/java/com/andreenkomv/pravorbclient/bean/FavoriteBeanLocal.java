/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.bean;

import com.andreenkomv.ws.Acts;
import com.andreenkomv.ws.Users;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface FavoriteBeanLocal {
    public void createByUserAndAct(int user, int act);
    public void deleteByUserAndAct(int user, int act);
}
