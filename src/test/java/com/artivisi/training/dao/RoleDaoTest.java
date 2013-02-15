/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.dao;

import com.artivisi.training.domain.Role;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author endy
 */
public class RoleDaoTest {
    @Test
    public void testInsert() throws Exception {
        Role u = new Role();
        u.setKode("admin");
        u.setNama("Administrator");
        
        // inisialisasi Spring Framework
        ApplicationContext spring 
                = new ClassPathXmlApplicationContext("classpath:konfig-spring.xml");
        
        // UserDao minta ke Spring
        RoleDao ud = spring.getBean(RoleDao.class);
        
        // Tinggal dipakai, tidak perlu repot inisialisasi dan inject
        ud.simpan(u);
    }
}
