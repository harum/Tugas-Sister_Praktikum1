/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;
// paket yang digunakan melakukan hal basic dalam jaringan

/**
 *
 * @author putu
 */
public class Client {
            
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
        
        User dataUser = new User();
        dataUser.UI2();
        
        Connecting connecting = new Connecting( dataUser.getHostname() , dataUser.getServerPort());
        
        if(connecting.connect())
            dataUser.UI1();
    }
 }
    

