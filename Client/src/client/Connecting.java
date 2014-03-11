/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import mymessage.Command;


/**
 *
 * @author Prana Pratistha
 */
public class Connecting {
    
    private static String serverName;
    private static int serverPort;
    private static Socket clientSocket;
    
    Connecting(String serverName, int serverPort)
    {
        Connecting.serverName = serverName;
        Connecting.serverPort = serverPort;
    }

    /**
     * @return the serverName
     */
    public static String getServerName() {
        return serverName;
    }

    /**
     * @param aServerName the serverName to set
     */
    public static void setServerName(String aServerName) {
        serverName = aServerName;
    }

    /**
     * @return the serverPort
     */
    public static int getServerPort() {
        return serverPort;
    }

    /**
     * @param aServerPort the serverPort to set
     */
    public static void setServerPort(int aServerPort) {
        serverPort = aServerPort;
    }

    /**
     * @return the clientSocket
     */
    public static Socket getClientSocket() {
        return clientSocket;
    }

    /**
     * @param aClientSocket the clientSocket to set
     */
    public static void setClientSocket(Socket aClientSocket) {
        clientSocket = aClientSocket;
    }
    
    public boolean connect()
    {
        boolean status = false;
        
        try {    
            System.err.println("Menghubungi server ...");
            clientSocket = new Socket(Connecting.getServerName() , Connecting.getServerPort());
            Connecting.setClientSocket(clientSocket);
            User.setClientSocket(clientSocket);
            
            //membaca balasan pertama dari server
            ObjectInputStream ois = new ObjectInputStream(Connecting.getClientSocket().getInputStream());
            
            Command command;
            try {
                command = (Command) ois.readObject();
                System.out.println("command : "+ command.getCommand());
                System.out.println("status : "+ command.getStatus());
            
                System.out.println("Berhasil terhubung dengan server.");
                status=true;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Connecting.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Connecting.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
}
