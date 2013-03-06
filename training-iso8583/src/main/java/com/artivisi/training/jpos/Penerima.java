/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.jpos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOServer;
import org.jpos.iso.ISOSource;
import org.jpos.iso.ServerChannel;
import org.jpos.util.Log4JListener;
import org.jpos.util.LogSource;

/**
 *
 * @author endy
 */
public class Penerima {
    public static void main(String[] args) throws Exception {
        int port = 20000;
        
        ServerChannel channel = new GspChannel(new ArtivisiPackager());
        
        ISOServer server = new ISOServer(port, channel, null);
        
        server.addISORequestListener(new ISORequestListener() {
            public boolean process(ISOSource pengirim, ISOMsg request) {
                try {
                    ISOMsg response = (ISOMsg) request.clone();
                    response.setMTI("0210");
                    response.set(39, "0000");
                    pengirim.send(response);
                    return true;
                } catch (Exception ex) {
                    Logger.getLogger(Penerima.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
        });
        
        // pasang logger
        org.jpos.util.Logger logger = new org.jpos.util.Logger();
        Log4JListener log4JListener = new Log4JListener();
        log4JListener.setLevel("info");
        logger.addListener(log4JListener);
        ((LogSource) channel).setLogger(logger, "server-channel");
        server.setLogger(logger, "server");
        
        new Thread(server).start();
        System.out.println("Server siap di port "+port);
    }
}
