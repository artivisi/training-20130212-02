/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.dao;

import com.artivisi.training.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        
        // inisialisasi Spring Framework
        ApplicationContext spring 
                = new ClassPathXmlApplicationContext("classpath:konfig-spring.xml");
        
        // UserDao minta ke Spring
        UserDao ud = spring.getBean(UserDao.class);
        
        // Tinggal dipakai, tidak perlu repot inisialisasi dan inject
        ud.simpan(u);
    }
}
