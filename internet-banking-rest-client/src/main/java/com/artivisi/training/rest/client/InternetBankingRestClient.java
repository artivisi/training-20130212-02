/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.rest.client;

import com.artivisi.training.domain.User;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author endy
 */
public class InternetBankingRestClient {
    private String baseUrl = "http://localhost:8080/internet-banking-rest/spring";
    private RestTemplate restTemplate = new RestTemplate();
    ParameterizedTypeReference<List<User>> userType = new ParameterizedTypeReference<List<User>>() {};
    
    public List<User> semuaUser(){
        String url = baseUrl + "/user";
        ResponseEntity<List<User>> hasil = restTemplate
                .exchange(url, HttpMethod.GET, 
                HttpEntity.EMPTY, userType);
        return hasil.getBody();
    }
}
