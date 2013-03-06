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
public class PengirimConnectionless {
    public static void main(String[] args) throws Exception {
        String server = "localhost";
        int port = 20000;
        int timeout = 10 * 1000;
        
        inquiry(server, port, timeout);
        inquiry(server, port, timeout);
        inquiry(server, port, timeout);
        inquiry(server, port, timeout);
        inquiry(server, port, timeout);
        inquiry(server, port, timeout);
        
    }
    
    public static void inquiry(String server, int port, int timeout) throws Exception {
        GspChannel channel = new GspChannel(server, port, new ArtivisiPackager());
        channel.setTimeout(timeout);
        
        ISOMsg msg = IsoConverter.createInquiryRequest();
        channel.connect();
        channel.send(msg);
        
        ISOMsg reply = channel.receive();
        channel.disconnect();
        reply.setPackager(new ArtivisiPackager());
        System.out.println("Reply : "+new String(reply.pack()));
    }
}
