package com.andreenkomv.hibernate;
// Generated 28.11.2014 20:21:44 by Hibernate Tools 4.3.1



/**
 * Texts generated by hbm2java
 */
public class Texts  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String text;

    public Texts() {
    }

	
    public Texts(String name, String text) {
        this.name = name;
        this.text = text;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }





}


