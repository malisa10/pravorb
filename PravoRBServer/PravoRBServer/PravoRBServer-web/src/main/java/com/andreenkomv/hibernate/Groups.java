package com.andreenkomv.hibernate;
// Generated 28.11.2014 20:21:44 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Groups generated by hbm2java
 */
public class Groups  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String grouprules;
     private Set userses = new HashSet(0);

    public Groups() {
    }

	
    public Groups(String name, String grouprules) {
        this.name = name;
        this.grouprules = grouprules;
    }
    public Groups(String name, String grouprules, Set userses) {
       this.name = name;
       this.grouprules = grouprules;
       this.userses = userses;
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
    public String getGrouprules() {
        return this.grouprules;
    }
    
    public void setGrouprules(String grouprules) {
        this.grouprules = grouprules;
    }
    public Set getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set userses) {
        this.userses = userses;
    }




}

