/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.pravorbclient.bean;

import com.andreenkomv.ws.*;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface TextBeanLocal {
    public Texts create(String name, String text);
}
