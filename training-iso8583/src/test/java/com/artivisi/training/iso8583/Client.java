/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.iso8583;

import java.net.Socket;

/**
 *
 * @author endy
 */
public class Client {
    public static void main(String[] args) throws Exception {
        String message = "01900200723E440108E1800002003800000000000000000306110600123456789012110600030613030307501000102123456789011234567890121234567890123456123456789012345ArtiVisi Jakarta                      ID0190101111123456789012360";
        
        String serverHost = "localhost";
        Integer serverPort = 20000;
        
        Socket s = new Socket(serverHost, serverPort);
        s.getOutputStream().write(message.getBytes());
        s.getOutputStream().flush();
        
        // baca dulu length
        byte[] byteLength = new byte[4];
        s.getInputStream().read(byteLength);
        String strLength = new String(byteLength);
        System.out.println("Length : "+strLength);
        
        // konversi length menjadi integer
        Integer length = Integer.valueOf(strLength);
        
        StringBuilder response = new StringBuilder();
        Integer currentLength = 0;
        int data;
        while(currentLength < length && ((data = s.getInputStream().read())!= -1)){
            currentLength++;
            response.append((char)data);
        }
        
        System.out.println("Message : "+response);
    }
}
