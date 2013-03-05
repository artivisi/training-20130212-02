/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.rest.client;

import com.artivisi.training.domain.User;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author endy
 */
public class InternetBankingRestClientTest {
    
    public InternetBankingRestClientTest() {
    }

    @Test
    public void testSemuaUser() {
        InternetBankingRestClient ibrc = new InternetBankingRestClient();
        List<User> hasil = ibrc.semuaUser();
        for (User user : hasil) {
            System.out.println("Username : "+user.getUsername());
        }
    }
}