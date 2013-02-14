/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.dao;

import com.artivisi.training.domain.User;
import org.junit.Test;

/**
 *
 * @author endy
 */
public class UserDaoTest {
    
    @Test
    public void testInsert() throws Exception {
        User u = new User();
        u.setUsername("endy");
        u.setPassword("123");
        
        UserDao ud = new UserDao();
        ud.simpan(u);
    }
}
