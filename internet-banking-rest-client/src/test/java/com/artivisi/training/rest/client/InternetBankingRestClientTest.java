/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.rest.client;

import com.artivisi.training.domain.User;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

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
        List<Map<String, String>> hasil = ibrc.semuaUser();
        for (Map<String, String> user : hasil) {
            System.out.println("Username : "+user.get("username"));
        }
    }
}