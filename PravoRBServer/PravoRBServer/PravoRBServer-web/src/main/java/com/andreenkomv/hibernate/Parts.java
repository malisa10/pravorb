package com.andreenkomv.hibernate;
// Generated 28.11.2014 20:21:44 by Hibernate Tools 4.3.1



/**
 * Parts generated by hbm2java
 */
public class Parts  implements java.io.Serializable {


     private Integer id;
     private int parent;
     private String name;

    public Parts() {
    }

	
    public Parts(int parent, String name) {
        this.parent = parent;
        this.name = name;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getParent() {
        return this.parent;
    }
    
    public void setParent(int parent) {
        this.parent = parent;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


}


