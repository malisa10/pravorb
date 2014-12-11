/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Favorites;
import java.util.List;

/**
 *
 * @author Honaht
 */
public interface FavoritesFacadeLocal {
    Favorites create(Favorites g);
    void edit(Favorites g);
    void delete(Favorites g);
    Favorites get(int id);
    List<Favorites> list();
    int count();
    
    List<Favorites> listFavoritesByUser(int user);
    Favorites getByUserAndAct(int user, int act);
}
