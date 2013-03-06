/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.jpos;

import org.jpos.iso.ISOMsg;
import org.junit.Test;

/**
 *
 * @author endy
 */
public class IsoConverterTest {
    

    @Test
    public void testCreateInquiryRequest() throws Exception {
        byte trailer = -1;
        System.out.println("Trailer = "+new String(new byte[]{trailer}));
        
        ArtivisiPackager packager = new ArtivisiPackager();
        ISOMsg hasil = IsoConverter.createInquiryRequest();
        hasil.setPackager(packager);
        String msg = new String(hasil.pack());
        System.out.println("Message : "+msg);
    }
}