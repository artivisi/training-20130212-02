/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.dao;

import com.artivisi.training.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.postgresql.ds.PGSimpleDataSource;

/**
 *
 * @author endy
 */
public class UserDao {
    private PGSimpleDataSource dataSource;
    
    // constructor injection
    public UserDao(PGSimpleDataSource ds){
        dataSource = ds;
    }
    
    public void simpan(User u) throws Exception {
        String sql = "insert into t_user (username, password) values (?,?)";
        
        Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ps.executeUpdate();
    }
}
