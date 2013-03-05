/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.controller;

import com.artivisi.training.dao.UserDao;
import com.artivisi.training.domain.User;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author endy
 */
@Controller
public class UserControllerREST {
    
    @Autowired
    private UserDao userDao;
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public List<User> semuaUser(){
        List<User> daftarUser = userDao.semuaUser(0, userDao.hitungSemuaUser().intValue());
        
        for (User user : daftarUser) {
            fixLie(user);
        }
        
        return daftarUser;
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User cariUserById(@PathVariable Integer id){
        User user = userDao.cariById(id);
        if(user == null){
            throw new IllegalStateException();
        }
        fixLie(user);
        return user;
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void simpanUser(@RequestBody @Valid User user){
        userDao.simpan(user);
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalStateException.class)
    public void handleIllegalStateException(){}

    private void fixLie(User user) {
        user.setDaftarEmail(null);
        user.setDaftarTelepon(null);
        user.getRole().setDaftarPermission(null);
        user.getRole().setDaftarUser(null);
    }
    
}
