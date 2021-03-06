/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.controller;

import com.artivisi.training.dao.RoleDao;
import com.artivisi.training.dao.UserDao;
import com.artivisi.training.domain.Role;
import com.artivisi.training.domain.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author endy
 */
@Controller
public class UserController {
    
    @Autowired private UserDao userDao;
    @Autowired private RoleDao roleDao;
    
    @InitBinder
    public void inisialisasiConverter(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, 
                new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true));
    }
    
    @RequestMapping("/user/list")
    public ModelMap daftarUser(){
        ModelMap mm = new ModelMap();
        
        List<User> semuaUser 
                = userDao.semuaUser(0, userDao.hitungSemuaUser().intValue());
        
        mm.addAttribute("daftarUser", semuaUser);
        
        return mm;
    }
    
    @ModelAttribute("daftarRole")
    public List<Role> semuaRole(){
        return roleDao.semuaRole();
    }
    
    @RequestMapping(value="/user/form", method= RequestMethod.GET)
    public ModelMap tampilkanForm(@RequestParam(required=false) Integer id){
        ModelMap mm = new ModelMap();
        
        User u = userDao.cariById(id);
        if(u == null){
            u = new User();
            Role r = new Role();
            u.setRole(r);
        }
        
        mm.addAttribute("user", u);
        
        return mm;
    }
    
    @RequestMapping(value="/user/form", method= RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid User u, 
                             BindingResult error, 
                             SessionStatus status){
        System.out.println("Username :"+u.getUsername());
        System.out.println("Password :"+u.getPassword());
        System.out.println("ID Role :"+u.getRole().getId());
        
        // kalau error, kembalikan ke form
        if(error.hasErrors()){
            return "/user/form";
        }
        
        userDao.simpan(u);
        status.setComplete();
        return "redirect:list";
    }
}
