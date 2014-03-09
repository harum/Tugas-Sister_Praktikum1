/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;
// basic java network
import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author Prana Pratistha
 */
public class User {
    private static String username;
    private static String password;
    private static String hostname;
    private static int serverPort = 8888;
    private static Socket clientSocket;
    private static boolean loginStatus;
    private static ArrayList<String> cuaca = new ArrayList<>();
    
    /**
     * @return the username
     */
    public static String getUsername() {
        return username;
    }

    /**
     * @param aUsername the username to set
     */
    public static void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param aPassword the password to set
     */
    public static void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * @return the hostname
     */
    public static String getHostname() {
        return hostname;
    }

    /**
     * @param aHostname the hostname to set
     */
    public static void setHostname(String aHostname) {
        hostname = aHostname;
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

    /**
     * @return the loginStatus
     */
    public static boolean isLoginStatus() {
        return loginStatus;
    }

    /**
     * @param aLoginStatus the loginStatus to set
     */
    public static void setLoginStatus(boolean aLoginStatus) {
        loginStatus = aLoginStatus;
    }

    static void setServerPort() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
