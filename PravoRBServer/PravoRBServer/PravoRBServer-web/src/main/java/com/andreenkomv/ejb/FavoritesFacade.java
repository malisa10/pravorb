/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Acts;
import com.andreenkomv.hibernate.Favorites;
import com.andreenkomv.hibernate.Users;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.criterion.Restrictions;

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

    @Override
    public List<Favorites> listFavoritesByUser(int user) {
        this.session.beginTransaction();
        List<Favorites> res = (List<Favorites>)session.createCriteria(Favorites.class)
                .add(Restrictions.eq("users",session.load(Users.class, user)))
                .list();
        this.session.getTransaction().commit();
        return res;
    }

    @Override
    public Favorites getByUserAndAct(int user, int act) {
        this.session.beginTransaction();
        Favorites res = (Favorites)session.createCriteria(Favorites.class)
                .add(Restrictions.eq("acts", session.load(Acts.class, act)))
                .add(Restrictions.and(Restrictions.eq("users",session.load(Users.class, user))))
                .uniqueResult();
        this.session.getTransaction().commit();
        return res;
    }
    
    @Override
    public int createByUserAndAct(int user, int act) {
        this.session.beginTransaction();
        session.createSQLQuery("INSERT INTO `favorites` (`favorites`.`user`, `favorites`.`act`) VALUES (:user, :act)")
                .setLong("user", user)
                .setLong("act", act)
                .executeUpdate();
        Integer lastid = ((BigInteger)(session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult())).intValue();
        this.session.getTransaction().commit();
        return lastid;
    }
    
    @Override
    public void deleteByUserAndAct(int user, int act) {
        this.session.beginTransaction();
        session.createSQLQuery("DELETE FROM `favorites` WHERE `favorites`.`user`=:user AND `favorites`.`act`=:act")
                .setLong("user", user)
                .setLong("act", act)
                .executeUpdate();
        this.session.getTransaction().commit();
    }
}
