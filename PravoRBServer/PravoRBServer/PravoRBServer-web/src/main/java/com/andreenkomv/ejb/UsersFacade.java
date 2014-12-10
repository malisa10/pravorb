/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Users;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.criterion.Order;
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
        session.clear();
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
    public void setInfo(Integer id, String firstname, String lastname, String email, String address, String zipcode, String telephone) {    
        this.session.beginTransaction();
        session.createSQLQuery("CALL `pr_user_setinfo`(:id, :firstname, :lastname, :email, :address, :zipcode, :telephone)")
                .setLong("id", id)
                .setString("firstname", firstname)
                .setString("lastname", lastname)
                .setString("email", email)
                .setString("address", address)
                .setString("zipcode", zipcode)
                .setString("telephone", telephone)
                .executeUpdate();
        this.session.getTransaction().commit();
    }
    
    @Override
    public List<Users> listUsersOrderByLogin() {
        session.clear();
        this.session.beginTransaction();
        List<Users> res = (List<Users>)session.createCriteria(Users.class).addOrder(Order.asc("login")).list();
        this.session.getTransaction().commit();
        return res;
    }

}
