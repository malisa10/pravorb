/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Favorites;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class FavoritesFacade  extends AbstractFacade<Favorites> implements FavoritesFacadeLocal {

    public FavoritesFacade() {
        super(Favorites.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
