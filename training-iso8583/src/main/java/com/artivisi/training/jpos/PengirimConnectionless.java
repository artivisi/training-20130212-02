/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.jpos;

import org.jpos.iso.ISOMsg;
import org.jpos.util.Log4JListener;
import org.jpos.util.LogSource;

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
        
        org.jpos.util.Logger logger = new org.jpos.util.Logger();
        Log4JListener log4JListener = new Log4JListener();
        log4JListener.setLevel("info");
        logger.addListener(log4JListener);
        ((LogSource) channel).setLogger(logger, "client-channel");
        
        ISOMsg msg = IsoConverter.createInquiryRequest();
        channel.connect();
        channel.send(msg);
        
        ISOMsg reply = channel.receive();
        channel.disconnect();
        reply.setPackager(new ArtivisiPackager());
    }
}
