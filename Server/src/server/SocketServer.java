/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Herleeyandi
 */
public class SocketServer {
    private static final int LISTENING_PORT = 9090;

    /**
     * @return the LISTENING_PORT
     */
    public static int getLISTENING_PORT() {
        return LISTENING_PORT;
    }
    
    public void makeConnection()
    {
        //membuat server socket
        ServerSocket serverSocket;
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(SocketServer.getLISTENING_PORT());
            System.out.println("Ramalan Cuaca Sister start the service on port " + SocketServer.getLISTENING_PORT());
            
        } catch (IOException ex) {
            System.out.println("Ramalan Cuaca Sister FAILED start the service on port " + SocketServer.getLISTENING_PORT());
            Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        
        //listening client yang melakukan koneksi
        while (true){
             try {
                    System.out.println("Menunggu client ...");
                    Socket clientSocket = serverSocket.accept();
                    
                    Thread thread1 = new ClientRequestProcess(clientSocket);
                    thread1.setDaemon(true);
                    System.out.println("Starting ClientRequestProcess thread...");
                    thread1.start();
                    
                } catch (IOException ex) {
                    System.out.println("Client gagal melakukan koneksi.");
                    Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
}
