/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.hibernate.Favorites;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Honaht
 */
@Local
public interface FavoritesServiceBeanLocal {
    public Favorites createFavorites(Favorites l);    
    public void editFavorites(Favorites l);    
    public void deleteFavorites(Favorites l);         
    public Favorites getFavorites(Integer id);
    public List<Favorites> listFavorites();
    public int countFavorites();
}
