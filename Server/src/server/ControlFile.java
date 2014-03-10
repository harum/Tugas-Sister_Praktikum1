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
    
//Fungsi ini berfungsi membaca isi file lalu mengembalikan hasilnya ke string.
    public String prediksiCuaca()
    {
        String isi = "";
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
    
//Fungsi ini membaca seluruh ramalan cuaca yang ada.
    public void bacaSemua()
    {
        String temp;
        String akhir = "";
        int i;
        temp = prediksiCuaca();
        String perBaris [] = temp.split("\n");
        akhir+="=========Ramalan Cuaca Surabaya=========\n";
        for(i=0;i<perBaris.length;i++)
        {
            if(perBaris[i].indexOf(" ") != -1)
            {
                String bagian[] = perBaris[i].split("=");
                akhir+=bagian[0]+", "+bagian[1]+"\n";
                akhir+="\tCuaca : "+bagian[2]+"\n";
                akhir+="\tSuhu : "+bagian[3]+"\u00b0C\n";
                akhir+="\tAngin : "+bagian[4]+"\n";
                akhir+="\tKelembaban : "+bagian[5]+"\n";
            }
        }
        System.out.println(akhir);
    }
    
//Fungsi ini menerima input berupa tanggal, misalkan: "11 Maret 2014"
    //Maka outputnya 
    /*
    =========Ramalan Cuaca tanggal 11 Maret 2014=========
    Senin, 11 Maret 2014
	Cuaca : Hujan
	Suhu : 15°C
	Angin : 48kmh
	Kelembaban : 88%
    */
    public void bacaTanggal(String tanggal)
    {
        String temp;
        String akhir = "";
        int i;
        temp = prediksiCuaca();
        String perBaris [] = temp.split("\n");
        akhir+="=========Ramalan Cuaca tanggal "+tanggal+"=========\n";
        for(i=0;i<perBaris.length;i++)
        {
            if(perBaris[i].indexOf(tanggal) != -1)
            {
                String bagian[] = perBaris[i].split("=");
                akhir+=bagian[0]+", "+bagian[1]+"\n";
                akhir+="\tCuaca : "+bagian[2]+"\n";
                akhir+="\tSuhu : "+bagian[3]+"\u00b0C\n";
                akhir+="\tAngin : "+bagian[4]+"\n";
                akhir+="\tKelembaban : "+bagian[5]+"\n";
            }
        }
        System.out.println(akhir);
    }
    
    
//Fungsi ini menerima input berupa bulan, misalkan: "Maret"
    //Maka outputnya 
    /*
    =========Ramalan Cuaca Bulan Maret=========
    Senin, 11 Maret 2014
	Cuaca : Hujan
	Suhu : 15°C
	Angin : 48kmh
	Kelembaban : 88%
    */
    public void bacaBulan( String bulan)
    {
        String temp;
        String akhir = "";
        int i;
        temp = prediksiCuaca();
        String perBaris [] = temp.split("\n");
        akhir+="=========Ramalan Cuaca Bulan "+bulan+"=========\n";
        for(i=0;i<perBaris.length;i++)
        {
            if(perBaris[i].indexOf(bulan) != -1)
            {
                String bagian[] = perBaris[i].split("=");
                akhir+=bagian[0]+", "+bagian[1]+"\n";
                akhir+="\tCuaca : "+bagian[2]+"\n";
                akhir+="\tSuhu : "+bagian[3]+"\u00b0C\n";
                akhir+="\tAngin : "+bagian[4]+"\n";
                akhir+="\tKelembaban : "+bagian[5]+"\n";
            }
        }
        System.out.println(akhir);
    }
    
//Fungsi ini menerima input berupa tahun, misalkan: "2014"
    //Maka outputnya 
    /*
   =========Ramalan Cuaca Tahun 2014=========
   Senin, 11 Maret 
	Cuaca : Hujan
	Suhu : 15°C
	Angin : 48kmh
	Kelembaban : 88%
    */
    public void bacaTahun( String tahun)
    {
        String temp;
        String akhir = "";
        int i;
        temp = prediksiCuaca();
        String perBaris [] = temp.split("\n");
        akhir+="=========Ramalan Cuaca Tahun "+tahun+"=========\n";
        for(i=0;i<perBaris.length;i++)
        {
            if(perBaris[i].indexOf(tahun) != -1)
            {
                String bagian[] = perBaris[i].split("=");
                akhir+=bagian[0]+", "+bagian[1].replace(tahun, "")+"\n";
                akhir+="\tCuaca : "+bagian[2]+"\n";
                akhir+="\tSuhu : "+bagian[3]+"\u00b0C\n";
                akhir+="\tAngin : "+bagian[4]+"\n";
                akhir+="\tKelembaban : "+bagian[5]+"\n";
            }
        }
        System.out.println(akhir);
    }
    
    
//Fungsi ini menerima input berupa hari, misalkan: "Senin"
    //Maka outputnya 
    /*
    =========Ramalan Cuaca Hari Senin=========
    11 Maret 2014
	Cuaca : Hujan
	Suhu : 15°C
	Angin : 48kmh
	Kelembaban : 88%
    */
    public void bacaHari( String hari)
    {
        String temp;
        String akhir = "";
        int i;
        temp = prediksiCuaca();
        String perBaris [] = temp.split("\n");
        akhir+="=========Ramalan Cuaca Hari "+hari+"=========\n";
        for(i=0;i<perBaris.length;i++)
        {
            if(perBaris[i].indexOf(hari) != -1)
            {
                String bagian[] = perBaris[i].split("=");
                akhir+=bagian[1]+"\n";
                akhir+="\tCuaca : "+bagian[2]+"\n";
                akhir+="\tSuhu : "+bagian[3]+"\u00b0C\n";
                akhir+="\tAngin : "+bagian[4]+"\n";
                akhir+="\tKelembaban : "+bagian[5]+"\n";
            }
        }
        System.out.println(akhir);
    }
    
//Fungsi ini menerima input berupa cuaca, misalkan: "Hujan"
    //Maka outputnya 
    /*
    =========Hujan Akan Terjadi Pada=========
    Senin, 11 Maret 2014
    */
    public void bacaCuaca( String cuaca)
    {
        String temp;
        String akhir = "";
        int i;
        temp = prediksiCuaca();
        String perBaris [] = temp.split("\n");
        akhir+="========="+cuaca+" Akan Terjadi Pada=========\n";
        for(i=0;i<perBaris.length;i++)
        {
            if(perBaris[i].indexOf(cuaca) != -1)
            {
                String bagian[] = perBaris[i].split("=");
                akhir+=bagian[0]+", "+bagian[1]+"\n";
            }

        }
        System.out.println(akhir);
    }
}
