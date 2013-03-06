/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.jpos;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMUX;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequest;

/**
 *
 * @author endy
 */
public class PengirimConnectionOriented {
    public static void main(String[] args) throws Exception{
        String host = "localhost";
        int port = 20000;
        ISOMUX mux = new ISOMUX(new GspChannel(host, port, new ArtivisiPackager())){

            @Override
            protected String getKey(ISOMsg m) throws ISOException {
                if(m.getString(11) == null){
                    return m.getString(7) + m.getString(41);
                }
                return m.getString(11) + m.getString(41); 
            }
            
        };
        
        new Thread(mux).start();
        
        ISOMsg inq = IsoConverter.createInquiryRequest();
        ISORequest req = new ISORequest(inq);
        mux.queue(req);
        
        int timeout = 10 * 1000;
        ISOMsg resp = req.getResponse(timeout);
        
        // kalau null berarti gak ada reply sampai timeout
        if(resp == null){
            System.out.println("Tidak ada response sampai "+timeout+" detik");
        } else {
            System.out.println("Reply : "+new String(resp.pack()));
        }
        
        
    }
}
