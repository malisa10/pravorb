/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.ejb;

import java.util.List;
import com.andreenkomv.hibernate.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

/**
 *
 * @author
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;
    protected Session session;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public T create(T entity) {
        try {
            this.session.beginTransaction();
            session.save(entity);
            this.session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return entity;
    }

    public void edit(T entity) {
        Session session = null;
        try {
            this.session.beginTransaction();
            session.update(entity);
            this.session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(T entity) {
        Session session = null;
        try {
            this.session.beginTransaction();
            session.delete(entity);
            this.session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public T get(int id) {
        T res = null;
        try {
            session.clear();
            this.session.beginTransaction();
            res = (T)session.get(entityClass, id); 
            this.session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return res;
    }

    public List<T> list() {
        List entities = new ArrayList<T>();
        try {
            session.clear();
            this.session.beginTransaction();
            entities = session.createCriteria(entityClass).list(); 
            this.session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("ОШИБКА findAll: "+e.getMessage());
        }
        return entities;
    }

    public int count() {
        Long res = (long) 0;
        try {
            session.clear();
            this.session.beginTransaction();
            res = (Long)session.createCriteria(entityClass).setProjection(Projections.rowCount()).uniqueResult();  
            this.session.getTransaction().commit();          
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return res.intValue();
    }
}
