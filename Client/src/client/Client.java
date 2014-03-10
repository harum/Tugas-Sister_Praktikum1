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
    
    static void hari ()
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
    
    static void tanggal ()
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
    

