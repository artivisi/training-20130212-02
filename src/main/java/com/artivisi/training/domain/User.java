/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author endy
 */
@Entity @Table(name="t_user")
public class User {
    @Id @GeneratedValue
    private Integer id;
    
    @Column(nullable=false,unique=true)
    private String username;
    private String password;
    
    @ElementCollection
    @CollectionTable(
            name="t_user_email", 
            joinColumns=@JoinColumn(name="id_user")
    )
    @Column(name="email")
    private List<String> daftarEmail 
            = new ArrayList<String>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
