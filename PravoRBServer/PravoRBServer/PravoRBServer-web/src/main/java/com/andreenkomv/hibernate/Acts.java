package com.andreenkomv.hibernate;
// Generated 28.11.2014 20:21:44 by Hibernate Tools 4.3.1


/**
 * Acts generated by hbm2java
 */
public class Acts  implements java.io.Serializable {


     private Integer id;
     private Parts parts;

    public Acts() {
    }

	
    public Acts(Parts parts) {
        this.parts = parts;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Parts getParts() {
        return this.parts;
    }
    
    public void setParts(Parts parts) {
        this.parts = parts;
    }

}


