/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author endy
 */
@Entity @Table(name="t_permission")
public class Permission {
    
    @Id @GeneratedValue
    private Integer id;
    private String action;
    private String keterangan;
}
