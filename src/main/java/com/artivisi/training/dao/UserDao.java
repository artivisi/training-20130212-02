/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.dao;

import com.artivisi.training.domain.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author endy
 */
@Repository @Transactional
public class UserDao {
    
    @PersistenceContext
    private EntityManager entityManager;
        
    public void simpan(User u) throws Exception {
        if(u.getId() == null){
            entityManager.persist(u);
        } else {
            entityManager.merge(u);
        }
    }
}
