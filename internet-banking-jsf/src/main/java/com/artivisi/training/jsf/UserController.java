/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.jsf;

import com.artivisi.training.dao.RoleDao;
import com.artivisi.training.dao.UserDao;
import com.artivisi.training.domain.Role;
import com.artivisi.training.domain.User;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author endy
 */
@Controller
@Scope("session")
public class UserController {
    @Autowired private UserDao userDao;
    @Autowired private RoleDao roleDao;
    
    private User currentUser;
    private ListDataModel<User> listDataModelUser;

    public List<Role> getDaftarRole(){
        List<Role> daftarRole = roleDao.semuaRole();
        
        for (Role role : daftarRole) {
            role.setDaftarPermission(null);
            role.setDaftarUser(null);
        }
        
        return daftarRole;
    }
    
    public ListDataModel<User> getListDataModelUser() {
        listDataModelUser = new ListDataModel<User>(getDaftarUser());
        return listDataModelUser;
    }
    
    public List<User> getDaftarUser(){
        return userDao.semuaUser(0, userDao.hitungSemuaUser().intValue());
    }
    
    public String tambah(){
        refreshCurrentUser();
        return "form?faces-redirect=true";
    }
    
    public String edit(){
        currentUser = listDataModelUser.getRowData();
        return "form?faces-redirect=true";
    }
    
    public String simpan(){
        userDao.simpan(currentUser);
        refreshCurrentUser();
        return "list?faces-redirect=true";
    }

    public User getCurrentUser() {
        return currentUser;
    }

    private void refreshCurrentUser() {
        currentUser = new User();
        Role r = new Role();
        currentUser.setRole(r);
    }
    
    
}
