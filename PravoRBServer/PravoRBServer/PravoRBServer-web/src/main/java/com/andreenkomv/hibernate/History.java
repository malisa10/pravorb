package com.andreenkomv.hibernate;
// Generated 28.11.2014 20:21:44 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * History generated by hbm2java
 */
public class History  implements java.io.Serializable {


     private Integer id;
     private Acts acts;
     private Texts texts;
     private Users users;
     private Date timeEdit;

    public History() {
    }

    public History(Acts acts, Texts texts, Users users, Date timeEdit) {
       this.acts = acts;
       this.texts = texts;
       this.users = users;
       this.timeEdit = timeEdit;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Acts getActs() {
        return this.acts;
    }
    
    public void setActs(Acts acts) {
        this.acts = acts;
    }
    public Texts getTexts() {
        return this.texts;
    }
    
    public void setTexts(Texts texts) {
        this.texts = texts;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public Date getTimeEdit() {
        return this.timeEdit;
    }
    
    public void setTimeEdit(Date timeEdit) {
        this.timeEdit = timeEdit;
    }




}


