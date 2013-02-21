/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.controller;

import com.artivisi.training.dao.UserDao;
import com.artivisi.training.domain.Role;
import com.artivisi.training.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(value="/user/form", method= RequestMethod.GET)
    public ModelMap tampilkanForm(){
        ModelMap mm = new ModelMap();
        
        User u = new User();
        Role r = new Role();
        u.setRole(r);
        
        mm.addAttribute("user", u);
        
        return mm;
    }
    
    @RequestMapping(value="/user/form", method= RequestMethod.POST)
    public String prosesForm(@ModelAttribute User u){
        System.out.println("Username :"+u.getUsername());
        System.out.println("Password :"+u.getPassword());
        System.out.println("ID Role :"+u.getRole().getId());
        
        userDao.simpan(u);
        
        return "redirect:list";
    }
}
