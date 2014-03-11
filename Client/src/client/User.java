/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;
// basic java network
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Prana Pratistha
 */
public class User {
    private static String username;
    private static String password;
    private static String hostname;
    private static int serverPort = 9090;
    private static Socket clientSocket;
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
    
    public void UI1 ()
        {      
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Pilih mode (menggunakan angka):");
            String[] selectMode = {"1. Hari","2. Tanggal ","3. Bulan ",
                "4. Tahun ","5. Cuaca " };
            
            for(int i=0;i<5;i++)
            {
                System.out.println(selectMode[i]);
            }
            
            int mode = scan.nextInt();
            
            if(mode == 1)
            {
                hari();
            }
            else if(mode == 2)
            {
                tanggal();
            }
            else if(mode == 3)
            {
                bulan();
            }
            else if(mode == 4)
            {
                tahun();
            }
            else 
            {
                cuaca();
            }
        
        }
    
     public void UI2 ()
        {
            System.out.println("Masukan alamat server :");
            Scanner scan = new Scanner(System.in);
            String host = scan.next();
            User.setHostname(host);
        }
    
    public void hari ()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pilih hari (menggunakan kata, harus sama):");
         String[] selectHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat",
         "Sabtu","Minggu"};
            for(int i=0;i<7;i++)
            {
                System.out.println(selectHari[i]);
            }
            
            int same=0;
            
            while(same==0)
            {
                String harian = scan.next();
                for(int i=0;i<7;i++)
                {
                     if(harian.equals(selectHari[i]))
                        same++;
                } 
                if(same>0)
                    System.out.println("masuk");
                else
                    System.out.println("error");
            }
    }
    
    public void tanggal ()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pilih tanggal (menggunakan kata, harus sama):");
        int[] selectTanggal = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19
                ,20,21,22,23,24,25,26,27,28,29,30,31};

            for(int i=0;i<7;i++)
            {
                System.out.println(selectTanggal[i]);
            }
            
            int same=0;
            
            while(same==0)
            {
                int tanggal = scan.nextInt();
                for(int i=0;i<7;i++)
                {
                     if(tanggal == (selectTanggal[i]))
                        same++;
                } 
                if(same>0)
                    System.out.println("masuk");
                else
                    System.out.println("error");
            }
            
            
    }
    
    
    public void bulan ()
    {
        
    }
    public void tahun ()
    {
        
    }
    public void cuaca ()
    {
        
    }
}
