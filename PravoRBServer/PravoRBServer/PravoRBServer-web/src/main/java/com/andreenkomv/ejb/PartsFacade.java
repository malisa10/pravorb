/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Parts;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.transform.Transformers;

/**
 *
 * @author
 */
@Stateless
public class PartsFacade extends AbstractFacade<Parts>  implements PartsFacadeLocal {

    public PartsFacade() {
        super(Parts.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Parts> listPartsByParent(int id) {
        this.session.beginTransaction();
        List<Parts> res = (List<Parts>)session.createSQLQuery("SELECT * FROM `parts` WHERE `parent`=:parent ORDER BY `name`")
                .setLong("parent", id)
            .setResultTransformer(Transformers.aliasToBean(Parts.class)).list();
        this.session.getTransaction().commit();
        return res;
    }
}
