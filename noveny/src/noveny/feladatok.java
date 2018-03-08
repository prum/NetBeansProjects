
package noveny;

import java.io.*;
import java.util.ArrayList;
public class feladatok {
public static void main(String[]args)
{
   ArrayList<String> hosszu = new ArrayList<String>();
   RandomAccessFile raf;
   String sor;
   int db;
   try
   {
       raf=new RandomAccessFile("C:\\TELEPITOK\\nov.txt","r");
       db=0;
       sor=raf.readLine();
       while(sor!=null)
       {
           db++;
           sor=raf.readLine();
           
       }
       Noveny[]novenyek=new Noveny[db];
       db=0;
       raf.seek(0);
       sor=raf.readLine();
       while(sor!=null)
       {
           novenyek[db++]=new Noveny(sor.split(";"));
           sor=raf.readLine();
       }
       for (Noveny n:novenyek)
       {
           System.out.println(n.toString());
           if (n.getMeddig()>=4)
               hosszu.add(n.getNev());
       }
       System.out.println("Legalább 4 hónapig gyűjtik: "+hosszu);
   }
   catch (IOException e)
   {
       System.out.println("HIBA!"); 
   }
}
}
