package beolvasas003;
import java.io.*;
public class Beolvasas003 {
    public static void main(String[] args) {
    RandomAccessFile raf;
    String sor1;
    String sor2;
    int ev[] = new int[100];
    String[] nev=new String[100];
    try
    {
        raf=new RandomAccessFile("C:\\TELEPITOK\\file4.txt","r");
        int db=0;
        sor1=raf.readLine();
        sor2=raf.readLine();
        while(sor1!=null)
        {
            ev[db]=Integer.parseInt(sor2);
            nev[db]=sor1;
            db++;
            sor1=raf.readLine();
            sor2=raf.readLine();
            
        }
        System.out.println(db + " nevünk van!");
        for(int i=0; i<db; i++)
        {
            System.out.println(nev[i]+" "+ev[i]+" éves.");
        }   
        raf.close();
    }
    catch(IOException e)
    {System.out.println("HIBA!");}
    
    
    
    
    
    
    }
    
}