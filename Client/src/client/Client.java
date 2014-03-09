/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;
// paket yang digunakan melakukan hal basic dalam jaringan
import java.net.*;
// paket yang digunakan melakukan proses IO
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author putu
 */
public class Client {

    static void UI ()
        {
            System.out.println("Masukan alamat server :");
            Scanner scan = new Scanner(System.in);
            String host = scan.next();
            User.setHostname(host);
        
            System.out.println("Masukan Username :");
            String name = scan.next();
            User.setUsername(name);
        
            System.out.println("Masukan Password :");
            String pass = scan.next();
            User.setPassword(pass);
            
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
    
    static void hari ()
    {
        
    }
    
    static void tanggal ()
    {
        
    }
    static void bulan ()
    {
        
    }
    static void tahun ()
    {
        
    }
    static void cuaca ()
    {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // host adalah alamat dari server
        //String host="localhost";
        // port adalah port yang akan digunakan
        //int port=8888;
        
        //StringBuffer cmd = new StringBuffer();
        
        
        System.out.println("starting up");
        
        UI();
    }
 }
    

