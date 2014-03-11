/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import mymessage.Command;

/**
 *
 * @author putu
 */
public class ClientRequestProcess extends Thread{
    
    private static Socket clientSocket;
    private static ObjectOutputStream ous;
    private static ObjectInputStream ois;

    ClientRequestProcess(Socket clientSocket) {
        this.clientSocket = clientSocket;
        System.out.println("New ClientRequestProcess created");
    }
    
    public void run()
    {
        System.out.println("Terhubung dengan "
                    + clientSocket.getRemoteSocketAddress());
        
        try {
            ous = new ObjectOutputStream(clientSocket.getOutputStream());
            
            //mengirimkan pemberitahuan ke user bahwa koneksi berhasil
            Command command;
            command = new Command();
            command.setCommand("CONNECT");
            command.setStatus("OK");
            ous.writeObject(command);
            ous.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(ClientRequestProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
