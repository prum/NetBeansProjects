package beolvasas004;
import java.io.*;
public class Beolvasas004 {
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
        int max=0;
        for(int i=1; i<db; i++)
        {
            if (ev[max]<ev[i])
                max=i;
        }  
        System.out.println("A legidősebb ember:");
        System.out.println(nev[max]+" "+ev[max]+" éves.");
        int db2=0;
        for(int i=0; i<db; i++)
        {
            if (ev[i]>=65)
                db2++;
        }  
        System.out.println("Összesen "+db2+" db nyugdijas van.");
        int i=0;
        while (i<db && ev[i]>30)
            i++;
        if (i<db)  
        /*igaz ág*/ System.out.println("VAN 30 évesnél fiatalabb "+nev[i]);
        else
        /*hamis ág*/System.out.println("NINCS 30 évesnél fiatalabb.");
  
        
        
        raf.close();
    }
    catch(IOException e)
    {System.out.println("HIBA!");}

 
    
    
    
    
    }
    
}