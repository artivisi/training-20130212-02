/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.iso8583;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author endy
 */
public class Server {
    public static void main(String[] args) throws Exception {
        Integer port = 20000;
        ServerSocket server = new ServerSocket(port);
        
        System.out.println("Server ready di port "+port);
        
        Socket s = server.accept();
        
        // baca dulu length
        byte[] byteLength = new byte[4];
        s.getInputStream().read(byteLength);
        String strLength = new String(byteLength);
        System.out.println("Length : "+strLength);
        
        // konversi length menjadi integer
        Integer length = Integer.valueOf(strLength);
        
        StringBuilder request = new StringBuilder();
        Integer currentLength = 0;
        int data;
        while(currentLength < length && ((data = s.getInputStream().read())!= -1)){
            currentLength++;
            request.append((char)data);
        }
        
        System.out.println("Message : "+request);
        
        
        String response = "0"+ request.length() + request.toString();
        s.getOutputStream().write(response.getBytes());
        s.getOutputStream().flush();
        s.close();
    }
}
