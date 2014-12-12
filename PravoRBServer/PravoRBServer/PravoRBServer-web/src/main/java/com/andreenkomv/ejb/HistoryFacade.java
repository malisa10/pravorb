/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.History;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Honaht
 */
@Stateless
public class HistoryFacade extends AbstractFacade<History>  implements HistoryFacadeLocal {

    public HistoryFacade() {
        super(History.class);
    }

    @Override
    public List<History> listHistoryByActs(int id) {
        session.clear();
        this.session.beginTransaction();
        List<History> res = (List<History>)session.createSQLQuery("SELECT * FROM `history` WHERE `act`=:act")                
                .addEntity(History.class)
                .setLong("act", id).list();
        this.session.getTransaction().commit();
        return res;
    }

    @Override
    public List<History> listHistoryByUser(int id) {
        session.clear();
        this.session.beginTransaction();
        List<History> res = (List<History>)session.createSQLQuery("SELECT * FROM `history` WHERE `user`=:user")
                .addEntity(History.class)
                .setLong("user", id).list();
        this.session.getTransaction().commit();
        return res;
    }

    @Override
    public History getHistoryByTexts(int id) {
        this.session.beginTransaction();
        History res = (History)session.createSQLQuery(
                "SELECT `history`.* "
                        + "FROM `texts` "
                        + "LEFT JOIN `history` ON `texts`.`id`=`history`.`text` "
                        + "WHERE `texts`.`id`=:id "
                        + "LIMIT 1")
                .addEntity(History.class)
                .setLong("id", id).uniqueResult();
        this.session.getTransaction().commit();
        return res;
    }

    @Override
    public List<History> listLastActsHistoryByPart(int id) {
        session.clear();
        this.session.beginTransaction();
        List<History> res = (List<History>)session.createSQLQuery("SELECT * "
                + "FROM `last_acts` "
                + "WHERE `last_acts`.`part`=:part")
                .addEntity(History.class)
                .setLong("part", id).list();
        this.session.getTransaction().commit();
        return res;
    }

    @Override
    public History getLastHistoryByActs(int id) {
        this.session.beginTransaction();
        History res = (History)session.createSQLQuery("SELECT * "
                + "FROM `last_acts` "
                + "WHERE `last_acts`.`act`=:act")
                .addEntity(History.class)
                .setLong("act", id).uniqueResult();
        this.session.getTransaction().commit();
        return res;
    }

    @Override
    public List<History> listLastActsHistoryByUserFavorites(int id) {
        session.clear();
        this.session.beginTransaction();
        List<History> res = (List<History>)session.createSQLQuery("SELECT * "
                + "FROM `last_acts` "
                + "WHERE `last_acts`.`act` IN (SELECT DISTINCT `favorites`.`act` FROM `favorites` WHERE `favorites`.`user`=:user);")
                .addEntity(History.class)
                .setLong("user", id).list();
        this.session.getTransaction().commit();
        return res;
    }
}
