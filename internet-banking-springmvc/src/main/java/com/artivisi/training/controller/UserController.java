/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author endy
 */
@Controller
public class UserController {
    
    @RequestMapping("/user/list")
    public ModelMap daftarUser(){
        ModelMap mm = new ModelMap();
        
        return mm;
    }
}
