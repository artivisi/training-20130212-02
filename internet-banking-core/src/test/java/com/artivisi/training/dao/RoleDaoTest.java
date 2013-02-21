/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.dao;

import com.artivisi.training.domain.Role;
import java.io.File;
import java.sql.Connection;
import javax.sql.DataSource;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author endy
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:konfig-spring.xml")
public class RoleDaoTest {
    @Autowired private RoleDao roleDao;
    @Autowired @Qualifier("dataSource1") 
    private DataSource dataSource;
    
    @Before
    public void resetIsiDatabase() throws Exception {
        Connection conn = dataSource.getConnection();
        DatabaseOperation.CLEAN_INSERT
                .execute(new DatabaseConnection(conn), 
                new FlatXmlDataSetBuilder()
                .build(new File("src/test/resources/sample-data.xml")));
        conn.close();
    }
    
    @Test
    public void testInsert() throws Exception {
        Role u = new Role();
        u.setKode("admin");
        u.setNama("Administrator");
        
        roleDao.simpan(u);
    }
    
    @Test
    public void testCariById(){
        Role r = roleDao.cariById(1);
        
        Assert.assertNotNull(r);
        
        // tidak kena LIE karena Fetch.EAGER
        System.out.println("Jumlah permission : "+r.getDaftarPermission().size());
        
        // kena LIE, by default OneToMany Fetch.LAZY
        System.out.println("Jumlah user : "+r.getDaftarUser().size());
    }
}
