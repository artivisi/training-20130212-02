/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.ws.spring;

import com.artivisi.internetbanking.schemas.DaftarRoleResponse;
import com.artivisi.internetbanking.schemas.ObjectFactory;
import com.artivisi.training.dao.RoleDao;
import com.artivisi.training.domain.Role;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author endy
 */
@Endpoint
public class RoleEndpoint {
    
    @Autowired private RoleDao roleDao;
    private static final String NAMESPACE_URI = "http://artivisi.com/internetbanking/schemas";
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DaftarRoleRequest") 
    @ResponsePayload
    public DaftarRoleResponse daftarRole(){
        DaftarRoleResponse hasil = new ObjectFactory().createDaftarRoleResponse();
        List<Role> roleDariDb = roleDao.semuaRole();
        for (Role role : roleDariDb) {
            com.artivisi.internetbanking.schemas.Role r 
                    = new com.artivisi.internetbanking.schemas.Role();
            r.setId(new BigInteger(role.getId().toString()));
            r.setKode(role.getKode());
            r.setNama(role.getNama());
            hasil.getDaftarRole().add(r);
        }
        return hasil;
    }
}
