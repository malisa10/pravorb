/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Users;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.transform.Transformers;

/**
 *
 * @author
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {

    public UsersFacade() {
        super(Users.class);
    }

    @Override
    public Users authUser(String login, String password) {
        Users res = null;
        this.session.beginTransaction();
        int id = (Integer) session.createSQLQuery("SELECT `pr_user_auth`(:login, :password)")
                .setString("login", login)
                .setString("password", password)
                .uniqueResult();
        this.session.getTransaction().commit();
        if (id > 0) {
            res = this.get(id);
        }
        return res;
    }

    @Override
    public void createUser(String login, String password) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `pr_user_create`(:login, :password)")
                .setString("login", login)
                .setString("password", password)
                .executeUpdate();
        this.session.getTransaction().commit();
    }

    @Override
    public void changePassword(Integer id, String password) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `pr_user_changepassword`(:id, :password)")
                .setLong("id", id)
                .setString("password", password)
                .executeUpdate();
        this.session.getTransaction().commit();
    }

    @Override
    public void changePasswordSecure(Integer id, String oldpassword, String newpassword) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `pr_user_changepasswordsecure`(:id, :oldpassword, :newpassword)")
                .setLong("id", id)
                .setString("oldpassword", oldpassword)
                .setString("newpassword", newpassword)
                .executeUpdate();
        this.session.getTransaction().commit();
    }

    @Override
    public void setGroup(Integer id, Integer g) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `pr_user_setgroup`(:id, :groupid)")
                .setLong("id", id)
                .setLong("groupid", g)
                .executeUpdate();
        this.session.getTransaction().commit();
    }

    @Override
    public List<Users> listUsersOrderByLogin() {
        this.session.beginTransaction();
        List<Users> res = (List<Users>)session.createSQLQuery("SELECT * FROM `users` ORDER BY `login`")
            .setResultTransformer(Transformers.aliasToBean(Users.class)).list();
        this.session.getTransaction().commit();
        return res;
    }
}
