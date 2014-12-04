/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Texts;
import javax.ejb.Stateless;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Honaht
 */
@Stateless
public class TextsFacade extends AbstractFacade<Texts> implements TextsFacadeLocal {

    public TextsFacade() {
        super(Texts.class);
    }

    @Override
    public Texts getLastTextsByActs(int id) {
        this.session.beginTransaction();
        Texts res = (Texts)session.createSQLQuery(
                "SELECT `texts`.* "
                        + "FROM `acts` "
                        + "LEFT JOIN `history` ON `acts`.`id`=`history`.`act` "
                        + "LEFT JOIN `texts` ON `texts`.`id`=`history`.`text` "
                        + "WHERE `acts`.`id`=:id "
                        + "ORDER BY `history`.`time_edit` "
                        + "LIMIT 1")
                .setLong("id", id)
            .setResultTransformer(Transformers.aliasToBean(Texts.class)).uniqueResult();
        this.session.getTransaction().commit();
        return res;
    }
    
}
