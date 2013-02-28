/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.ws.client;

import com.artivisi.training.ws.metro.Role;
import java.util.List;

/**
 *
 * @author endy
 */
public class DemoClientWS {
    public static void main(String[] args) {
        // hello world
        String hasil = hello("endy");
        System.out.println("Hasil : "+hasil);
        
        // daftar Role
        List<Role> daftarRole = daftarRole();
        for (Role role : daftarRole) {
            System.out.println("ID : "+role.getId());
            System.out.println("Kode : "+role.getKode());
            System.out.println("Nama : "+role.getNama());
        }
    }

    private static String hello(java.lang.String name) {
        com.artivisi.training.ws.metro.HaloService_Service service = new com.artivisi.training.ws.metro.HaloService_Service();
        com.artivisi.training.ws.metro.HaloService port = service.getHaloServicePort();
        return port.hello(name);
    }

    private static java.util.List<com.artivisi.training.ws.metro.Role> daftarRole() {
        com.artivisi.training.ws.metro.HaloService_Service service = new com.artivisi.training.ws.metro.HaloService_Service();
        com.artivisi.training.ws.metro.HaloService port = service.getHaloServicePort();
        return port.daftarRole();
    }
}
