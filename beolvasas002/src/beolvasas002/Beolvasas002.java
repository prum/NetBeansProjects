package beolvasas002;
import java.io.*;
public class Beolvasas002 {
    public static void main(String[] args) {
    RandomAccessFile raf;
    String sor;
    int szamok[] = new int[100];
    try
    {
        raf=new RandomAccessFile("C:\\TELEPITOK\\file3.txt","r");
        int db=0;
        sor=raf.readLine();
        while(sor!=null)
        {
            szamok[db++]=Integer.parseInt(sor);
            sor=raf.readLine();
        }
        System.out.println(db+" szamunk van!");
        for(int i=0; i<db; i++)
        {
            System.out.println(szamok[i]);
        }   
        int max=0;
        for(int i=1; i<db; i++)
        {
            if ( szamok[i]>szamok[max]) max=i;
        }   
        System.out.println("A legnagyobb szám:"+szamok[max]);
        int sum=0;
        int atlag=0;
        for(int i=0; i<db; i++)
        {
            sum=sum+szamok[i];
        }  
        System.out.println("A számok átlaga:"+sum/db);
        
        raf.close();
    }
    catch(IOException e)
    {System.out.println("HIBA!");}
            
    }
    
}
