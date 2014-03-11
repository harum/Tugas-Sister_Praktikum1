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
import java.net.SocketException;
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
    private Command command;
    private Command result;

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
            
            replayCommand();
            
        } catch (IOException ex) {
            Logger.getLogger(ClientRequestProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void replayCommand()
    {
        while (clientSocket.isConnected())
        {
            System.out.println("Menunggu request client "+clientSocket.getRemoteSocketAddress());
            try {
                ois = new ObjectInputStream(clientSocket.getInputStream());
                ous = new ObjectOutputStream(clientSocket.getOutputStream());
                
                System.out.println("Membaca request client");
                command = (Command) ois.readObject();
                System.out.println("command : "+ command.getCommand());
                System.out.println("Selesai Membaca request client");
                
                result = new Command();
                ControlFile controlFile = new ControlFile();
                result = controlFile.cekCommand(command);
                
                ous.writeObject(result);
                ous.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(ClientRequestProcess.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientRequestProcess.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
