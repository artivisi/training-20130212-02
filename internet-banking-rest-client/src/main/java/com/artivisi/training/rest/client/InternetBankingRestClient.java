/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.rest.client;

import com.artivisi.training.domain.User;
import java.util.List;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author endy
 */
public class InternetBankingRestClient {
    private String baseUrl = "http://localhost:8080/internet-banking-rest/spring";
    private RestTemplate restTemplate = new RestTemplate();
    
    public List<Map<String, String>> semuaUser(){
        String url = baseUrl + "/user";
        List<Map<String, String>> hasil = restTemplate.getForObject(url, List.class);
        return hasil;
    }
}
