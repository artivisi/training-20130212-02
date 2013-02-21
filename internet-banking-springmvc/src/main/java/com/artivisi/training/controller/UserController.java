/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.controller;

import com.artivisi.training.dao.UserDao;
import com.artivisi.training.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author endy
 */
@Controller
public class UserController {
    
    @Autowired private UserDao userDao;
    
    @RequestMapping("/user/list")
    public ModelMap daftarUser(){
        ModelMap mm = new ModelMap();
        
        List<User> semuaUser 
                = userDao.semuaUser(0, userDao.hitungSemuaUser().intValue());
        
        mm.addAttribute("daftarUser", semuaUser);
        
        return mm;
    }
    
    @RequestMapping("/user/form")
    public ModelMap tampilkanForm(){
        ModelMap mm = new ModelMap();
        return mm;
    }
}
