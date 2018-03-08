
package hotel2;

import java.io.*;
import java.util.ArrayList;

public class beolvasas {
    public static void main(String[] args) {
        RandomAccessFile raf;
        ArrayList <Hotel2> forgalom = new ArrayList<Hotel2>();
        try
        {
            raf = new RandomAccessFile("C://telepitok//pitypang.txt","r");
            do
                { forgalom.add(new Hotel2(raf.readLine().split(" "))); 
                    
                }
            while (raf.readLine()	!= null);
            raf.close();
            
        }
            catch (Exception e) {
                    System.err.println("Fájlbeolvasási hiba " + e.getMessage());
            }
        
            for (Hotel2 foglalások : forgalom)
                System.out.println(foglalások) ;
                    
             int max=0;
             int hely=0;
             for (int i=0;i<forgalom.size();i++)
             {
                 if (forgalom.get(i).getHossz()>forgalom.get(max).getHossz())
                     max=i;
                 hely=max+1;
             }
             System.out.println(forgalom.get(max).getNev()+" hely:"+hely+" nap:"+forgalom.get(max).getHossz());
             //3
             /*int SZOBA[]=new int[27];
             for(int i=0;i<forgalom.size();i++)
             {
                 
                
             }*/
             
             for (int i=0;i<forgalom.size();i++)
             {
                 if (forgalom.get(i).getFo()==2 && forgalom.get(i).getKaja()==1)
                     System.out.println(forgalom.get(i).getNev());
                     
             }
             System.out.println("-----------------------");
             for(int i=0; i<forgalom.size(); i++)
                for(int j=i+1; j<forgalom.size(); j++)
                    if (forgalom.get(i).getNev().equals( forgalom.get(j).getNev()))
                        System.out.println(forgalom.get(i).getNev());
    }
    
    }
           
           
                    
            }
    
