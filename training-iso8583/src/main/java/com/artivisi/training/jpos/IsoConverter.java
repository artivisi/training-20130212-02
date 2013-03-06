/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.jpos;

import org.jpos.iso.ISOMsg;

/**
 *
 * @author endy
 */
public class IsoConverter {
    public static ISOMsg createInquiryRequest() throws Exception {
        ISOMsg msg = new ISOMsg();
        
        msg.setMTI("0200");
        msg.set(2, "00");
        msg.set(3, "380000");
        msg.set(4, "000000000000");
        msg.set(7, "0306110600");
        msg.set(11, "123456789012");
        msg.set(12, "110600");
        msg.set(13, "0306");
        msg.set(14, "1303");
        msg.set(15, "0307");
        msg.set(18, "5010");
        msg.set(22, "001");
        msg.set(32, "12345678901");
        msg.set(37, "123456789012");
        msg.set(41, "1234567890123456");
        msg.set(42, "123456789012345");
        msg.set(43, "ArtiVisi Jakarta                      ID");
        msg.set(48, "0101111123456789012");
        msg.set(49, "360");
        
        return msg;
    }
}
