/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
/**
 *
 * @author Herleeyandi
 */
public class ControlFile {
    private String pathFile;
    public void bacaSemua()
    {
        String isi = null;
        File fileCuaca = new File("cuaca.txt");
        try {
            FileReader reader = new FileReader(fileCuaca);
            char[] chars = new char[(int) fileCuaca.length()];
            reader.read(chars);
            isi = new String(chars);
            reader.close();
            System.out.println(isi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void bacaTanggal()
    {
        
    }
    
    public void bacaBulan()
    {
        
    }
    
    public void bacaTahun()
    {
        
    }
}
