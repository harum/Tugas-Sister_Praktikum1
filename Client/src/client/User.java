/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;
// basic java network
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mymessage.Command;

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
    
    private Command command;
    private Command input;
    private ObjectOutputStream ous;
    private ObjectInputStream ois;
    
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
            int mode = 0;
                    
            while(mode!=7)
            {
                
                System.out.println("Pilih mode (menggunakan angka):");
                String[] selectMode = {"1. Hari","2. Tanggal ","3. Bulan ",
                    "4. Tahun ","5. Cuaca ", "6. Semua","7. Keluar"};

                for(int i=0;i<7;i++)
                {
                    System.out.println(selectMode[i]);
                }

                mode = scan.nextInt();

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
                else if(mode == 5)
                {
                    cuaca();
                }
                else if (mode == 6)
                {
                    semua();
                }
                
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
        //input.setCommand("HARI");
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukan nama hari, misalkan : Senin");
        String anggotaHari="Senin,Selasa,Rabu,Kamis,Jumat,Sabtu,Minggu,";
        String upper;
        String harian = scan.next();
        upper=harian+",";
        while(anggotaHari.indexOf(upper)<0)
        {
            System.out.println("input salah, masukan lagi");
            System.out.println("contoh : "+anggotaHari);
            harian = scan.next();
            upper=harian+",";
        }
        harian=upper.replace(",", "");
        //input.setConstraint(harian);
        
        try {
            
            ous = new ObjectOutputStream(clientSocket.getOutputStream());
            command = new Command();
            command.setCommand("HARI");
            command.setConstraint(harian);
            ous.writeObject(command);
            ous.flush();
            
            
            ois = new ObjectInputStream(clientSocket.getInputStream());
            input = (Command) ois.readObject();
            System.out.println("command : "+ input.getCommand());
            System.out.println("result : "+ input.getResult());
            
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void tanggal ()
    {
        //input.setCommand("TANGGAL");
        Scanner scan = new Scanner(System.in);
        String tanggal="";
        System.out.println("Masukan taanggal, misalkan : 11");
        int tanggalnya = scan.nextInt();
        
        System.out.println("Masukan nama bulan, misalkan : Januari");
        String anggotaBulan="Januari,Februari,Maret,April,Mei,Juni,Juli,Agustus,Septemer,November,Desember,";
        String upper;
        String bulanan = scan.next();
        upper=bulanan+",";
        while(anggotaBulan.indexOf(upper)<0)
        {
            System.out.println("input salah, masukan lagi");
            System.out.println("contoh : "+anggotaBulan);
            bulanan = scan.next();
            upper=bulanan+",";
        }
        bulanan=upper.replace(",", "");
        
        System.out.println("Masukan tahun, misalkan : 2014");
        int tahunnya = scan.nextInt();
        
        StringBuilder dummyTanggal = new StringBuilder();
        dummyTanggal.append("");
        dummyTanggal.append(tanggalnya);
        
        StringBuilder dummyTahun = new StringBuilder();
        dummyTahun.append("");
        dummyTahun.append(tahunnya);
        String send=dummyTanggal.toString()+" "+bulanan+" "+dummyTahun.toString();
        
        //input.setConstraint(send);
        
        try {
            
            ous = new ObjectOutputStream(clientSocket.getOutputStream());
            command = new Command();
            command.setCommand("TANGGAL");
            command.setConstraint(send);
            ous.writeObject(command);
            ous.flush();
            
            
            ois = new ObjectInputStream(clientSocket.getInputStream());
            input = (Command) ois.readObject();
            System.out.println("command : "+ input.getCommand());
            System.out.println("result : "+ input.getResult());
            
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void bulan ()
    {
        //input.setCommand("BULAN");
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukan nama bulan, misalkan : Januari");
        String anggotaBulan="Januari,Februari,Maret,April,Mei,Juni,Juli,Agustus,Septemer,November,Desember,";
        String upper;
        String bulanan = scan.next();
        upper=bulanan+",";
        while(anggotaBulan.indexOf(upper)<0)
        {
            System.out.println("input salah, masukan lagi");
            System.out.println("contoh : "+anggotaBulan);
            bulanan = scan.next();
            upper=bulanan+",";
        }
        bulanan=upper.replace(",", "");
        //input.setConstraint(bulanan);
        
        try {
            
            ous = new ObjectOutputStream(clientSocket.getOutputStream());
            command = new Command();
            command.setCommand("BULAN");
            command.setConstraint(bulanan);
            ous.writeObject(command);
            ous.flush();
            
            
            ois = new ObjectInputStream(clientSocket.getInputStream());
            input = (Command) ois.readObject();
            System.out.println("command : "+ input.getCommand());
            System.out.println("result : "+ input.getResult());
            
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void tahun ()
    {
        //input.setCommand("TAHUN");
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukan tahun, misalkan : 2014");
        int tahunnya = scan.nextInt();
        StringBuilder dummyTahun = new StringBuilder();
        dummyTahun.append("");
        dummyTahun.append(tahunnya);
        String send=dummyTahun.toString();
        //input.setConstraint(tahunnya);
        
        try {
            
            ous = new ObjectOutputStream(clientSocket.getOutputStream());
            command = new Command();
            command.setCommand("TAHUN");
            command.setConstraint(send);
            ous.writeObject(command);
            ous.flush();
            
            
            ois = new ObjectInputStream(clientSocket.getInputStream());
            input = (Command) ois.readObject();
            System.out.println("command : "+ input.getCommand());
            System.out.println("result : "+ input.getResult());
            
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cuaca ()
    {
        //input.setCommand("CUACA");
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukan cuaca, misalkan : Hujan");
        String anggotaCuaca="Hujan,Cerah,CerahBerawan,Mendung,";
        String upper;
        String cuacanya = scan.next();
        upper=cuacanya+",";
        while(anggotaCuaca.indexOf(upper)<0)
        {
            System.out.println("input salah, masukan lagi");
            System.out.println("contoh : "+anggotaCuaca);
            cuacanya = scan.next();
            upper=cuacanya+",";
        }
        cuacanya=upper.replace(",", "");
        //input.setConstraint(cuacanya);
        try {
            
            ous = new ObjectOutputStream(clientSocket.getOutputStream());
            command = new Command();
            command.setCommand("CUACA");
            command.setConstraint(cuacanya);
            ous.writeObject(command);
            ous.flush();
            
            
            ois = new ObjectInputStream(clientSocket.getInputStream());
            input = (Command) ois.readObject();
            System.out.println("command : "+ input.getCommand());
            System.out.println("result : "+ input.getResult());
            
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void semua ()
    {
        //input.setCommand("SEMUA");
        System.out.println("Anda merequest semua ramalan cuaca");
        //input.setConstraint("");
        try {
            
            ous = new ObjectOutputStream(clientSocket.getOutputStream());
            command = new Command();
            command.setCommand("SEMUA");
            ous.writeObject(command);
            ous.flush();
            
            
            ois = new ObjectInputStream(clientSocket.getInputStream());
            input = (Command) ois.readObject();
            System.out.println("command : "+ input.getCommand());
            System.out.println("result : "+ input.getResult());
            
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }
    
    
}
