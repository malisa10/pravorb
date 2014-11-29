/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import com.andreenkomv.hibernate.Users;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {
    @EJB
    private GroupsFacadeLocal groupsFacade;

    public UsersFacade() {
        super(Users.class);
    }

    @Override
    public Users authUser(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createUser(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changePassword(Integer id, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setGroup(Integer id, Integer g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
