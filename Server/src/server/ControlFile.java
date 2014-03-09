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
    
    public String readCuaca()
    {
        String isi = null;
        File fileCuaca = new File("cuaca.txt");
        try {
            FileReader reader = new FileReader(fileCuaca);
            char[] chars = new char[(int) fileCuaca.length()];
            reader.read(chars);
            isi = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isi;     
    }
    public void bacaSemua()
    {
        String temp;
        temp = readCuaca();
        System.out.println(temp);
    }
    
    
    public void bacaTanggal(String tanggal)
    {
        String temp;
        int i;
        temp = readCuaca();
        String perBaris [] = temp.split("\n");
        System.out.println(perBaris[0]);
        for(i=0;i<perBaris.length;i++)
        {
            if(perBaris[i].indexOf(tanggal) != -1)
            {
                System.out.println(perBaris[i]);
            }
        }
    }
    
    public void bacaBulan( String bulan)
    {
        String temp;
        int i;
        temp = readCuaca();
        String perBaris [] = temp.split("\n");
        System.out.println(perBaris[0]);
        for(i=0;i<perBaris.length;i++)
        {
            if(perBaris[i].indexOf(bulan) != -1)
            {
                System.out.println(perBaris[i]);
            }
        }
    }
    
    public void bacaTahun( String tahun)
    {
        String temp;
        int i;
        temp = readCuaca();
        String perBaris [] = temp.split("\n");
        System.out.println(perBaris[0]);
        for(i=0;i<perBaris.length;i++)
        {
            if(perBaris[i].indexOf(tahun) != -1)
            {
                System.out.println(perBaris[i]);
            }
        }
    }
    public void bacaHari( String hari)
    {
        String temp;
        int i;
        temp = readCuaca();
        String perBaris [] = temp.split("\n");
        System.out.println(perBaris[0]);
        for(i=0;i<perBaris.length;i++)
        {
            if(perBaris[i].indexOf(hari) != -1)
            {
                System.out.println(perBaris[i]);
            }
        }
    }
}
