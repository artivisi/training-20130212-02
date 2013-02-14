/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.dao;

import com.artivisi.training.domain.User;
import org.junit.Test;
import org.postgresql.ds.PGSimpleDataSource;

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
        
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("internetbanking");
        dataSource.setUser("ib");
        dataSource.setPassword("ib123");
        
        // inject dataSource ke dalam UserDao
        UserDao ud = new UserDao();
        ud.setDataSource(dataSource);
        ud.simpan(u);
    }
}
