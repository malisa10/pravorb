/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Acts;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Query;

/**
 *
 * @author
 */
@Stateless
public class ActsFacade extends AbstractFacade<Acts> implements ActsFacadeLocal {
    
    public ActsFacade() {
        super(Acts.class);
    }
    
    @Override
    public List<Acts> listActsByPart(int id) {
        this.session.beginTransaction();
        List<Acts> res = (List<Acts>)session.createSQLQuery("SELECT * FROM `acts` WHERE `part`=:part")                
                .addEntity(Acts.class)
                .setLong("part", id).list();
        this.session.getTransaction().commit();
        return res;
    }

    @Override
    public Acts getActsByTexts(int id) {
        this.session.beginTransaction();
        Acts res = (Acts)session.createSQLQuery(
                "SELECT `acts`.* "
                        + "FROM `texts` "
                        + "LEFT JOIN `history` ON `texts`.`id`=`history`.`text` "
                        + "LEFT JOIN `acts` ON `acts`.`id`=`history`.`act` "
                        + "WHERE `texts`.`id`=:id "
                        + "LIMIT 1")
                .addEntity(Acts.class)
                .setLong("id", id).uniqueResult();
        this.session.getTransaction().commit();
        return res;
    }

    @Override
    public boolean inFavorites(int act, int user) {
        boolean res = false;
        session.clear();
        this.session.beginTransaction();
        Query query = session.createSQLQuery("SELECT `pr_act_infavorites`(:act, :user)")
                .setLong("act", act)
                .setLong("user", user);
        String id = query.uniqueResult().toString();
        this.session.getTransaction().commit();
        if (Integer.valueOf(id) > 0) {
            res = true;
        }
        return res;
    }
}
