/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beolvasas;

import java.io.*;
public class Beolvasas {
    public static void main(String[] args) {
    RandomAccessFile raf;
    String sor;
    String[] nevek=new String[100];
    try
    {
        raf=new RandomAccessFile("C:\\TELEPITOK\\file.txt","r");
        int db=0;
        sor=raf.readLine();
        while(sor!=null)
        {
            nevek[db++]=sor;
            sor=raf.readLine();
        }
        System.out.println(db+" nevünk van!");
        for(int i=0; i<db; i++)
            System.out.println(nevek[i]);
        raf.close();
    }
    catch(IOException e)
    {System.out.println("HIBA!");}
    }
    
}
