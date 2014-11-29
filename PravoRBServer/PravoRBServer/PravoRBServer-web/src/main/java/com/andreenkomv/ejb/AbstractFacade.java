/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import java.util.List;
import com.andreenkomv.hibernate.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 *
 * @author
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;
    private Session session;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.session.beginTransaction();
    }

    public void create(T entity) {
        try {
            session.save(entity);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void edit(T entity) {
        Session session = null;
        try {
            session.update(entity);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void remove(T entity) {
        Session session = null;
        try {
            session.delete(entity);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public T find(int id) {
        T res = null;
        try {
            res = (T)session.get(entityClass, id); 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return res;
    }

    public List<T> findAll() {
        List entities = new ArrayList<T>();
        try {
            entities = session.createCriteria(entityClass).list(); 
        } catch (Exception e) {
            System.err.println("ОШИБКА findAll: "+e.getMessage());
        }
        return entities;
    }

    public int count() {
        Long res = (long) 0;
        try {
            res = (Long)session.createCriteria(entityClass).setProjection(Projections.rowCount()).uniqueResult();            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return res.intValue();
    }
}
