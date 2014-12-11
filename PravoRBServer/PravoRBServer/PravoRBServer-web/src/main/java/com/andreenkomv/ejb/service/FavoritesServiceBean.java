/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb.service;

import com.andreenkomv.ejb.FavoritesFacadeLocal;
import com.andreenkomv.hibernate.Favorites;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class FavoritesServiceBean implements FavoritesServiceBeanLocal {
    @EJB
    private FavoritesFacadeLocal FavoritesFacade;

    @Override
    public Favorites createFavorites(Favorites l) {
        return FavoritesFacade.create(l);
    }

    @Override
    public void editFavorites(Favorites l) {
        FavoritesFacade.edit(l);
    }

    @Override
    public void deleteFavorites(Favorites l) {
        FavoritesFacade.delete(l);
    }

    @Override
    public Favorites getFavorites(Integer id) {
        return FavoritesFacade.get(id);
    }

    @Override
    public List<Favorites> listFavorites() {
        return FavoritesFacade.list();
    }
    
    @Override
    public int countFavorites() {
        return FavoritesFacade.count();
    }

    @Override
    public List<Favorites> listFavoritesByUser(int user) {
         return FavoritesFacade.listFavoritesByUser(user);
    }

    @Override
    public Favorites getByUserAndAct(int user, int act) {
        return FavoritesFacade.getByUserAndAct(user, act);
    }
}
