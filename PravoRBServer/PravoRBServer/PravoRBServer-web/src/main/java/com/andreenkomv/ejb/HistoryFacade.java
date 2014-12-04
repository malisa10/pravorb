/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.History;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.transform.Transformers;

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
        this.session.beginTransaction();
        List<History> res = (List<History>)session.createSQLQuery("SELECT * FROM `history` WHERE `act`=:act LIMIT 1")
                .setLong("act", id)
            .setResultTransformer(Transformers.aliasToBean(History.class)).list();
        this.session.getTransaction().commit();
        return res;
    }

    @Override
    public List<History> listHistoryByUser(int id) {
        this.session.beginTransaction();
        List<History> res = (List<History>)session.createSQLQuery("SELECT * FROM `history` WHERE `user`=:user LIMIT 1")
                .setLong("user", id)
            .setResultTransformer(Transformers.aliasToBean(History.class)).list();
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
                .setLong("id", id)
            .setResultTransformer(Transformers.aliasToBean(History.class)).uniqueResult();
        this.session.getTransaction().commit();
        return res;
    }
}
