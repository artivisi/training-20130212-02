/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.rest.client;

import com.artivisi.training.domain.Role;
import com.artivisi.training.domain.User;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author endy
 */
public class InternetBankingRestClientTest {
    private InternetBankingRestClient ibrc = new InternetBankingRestClient();
    
    public InternetBankingRestClientTest() {
    }

    @Test
    public void testSemuaUser() {
        List<User> hasil = ibrc.semuaUser();
        for (User user : hasil) {
            System.out.println("Username : "+user.getUsername());
        }
    }
    
    @Test
    public void testSimpanUser(){
        Role r = new Role();
        r.setId(1);
        
        User u = new User();
        u.setRole(r);
        u.setUsername("testuser");
        u.setPassword("12345");
        u.setTanggalLahir(new Date());
        
        ibrc.simpan(u);
    }
    
    @Test
    public void testUpdateUser(){
        Role r = new Role();
        r.setId(2);
        
        User u = new User();
        u.setId(1);
        u.setRole(r);
        u.setUsername("dadang");
        u.setPassword("12345");
        u.setTanggalLahir(new Date());
        
        ibrc.simpan(u);
    }
    
    @Test
    public void testCariUserById(){
        User u = ibrc.cariById(1);
        Assert.assertEquals("dadang", u.getUsername());
    }
}