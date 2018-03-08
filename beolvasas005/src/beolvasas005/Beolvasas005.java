package beolvasas005;
import java.io.*;
public class Beolvasas005  {
    public static void main(String[] args) {
    RandomAccessFile raf;
    String sor0;
    String sor1;
    String sor2;

    try
    {
        raf=new RandomAccessFile("C:\\TELEPITOK\\file5.txt","r");
        int db=0;
        int rec=0;
        sor0=raf.readLine();
        sor1=raf.readLine();
        sor2=raf.readLine();
        rec=Integer.parseInt(sor0);
        int ev[] = new int[rec];
        int szev[] = new int[rec];
        int prim[]= new int[rec];
        String[] nev=new String[rec];
        for (int i=0; i<rec; i++)
        {
            nev[db]=sor1;
            ev[db]=Integer.parseInt(sor2);
            szev[db]=2018-Integer.parseInt(sor2);
            db++;
            sor1=raf.readLine();
            sor2=raf.readLine();
            
        }
        System.out.println(db + " nevünk van!");
    
        for(int i=0; i<db; i++)
        {
            System.out.println(nev[i]+" "+ev[i]+" éves.("+szev[i]+")");
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
        i=0;
        while (i<db && Math.abs(ev[i]-ev[i+1])>12)
            i++;
        if (i<db)  
        /*igaz ág*/ System.out.println("VAN 12 évnél kisebb különbség "+nev[i]+" "+nev[i+1]);
        else
        /*hamis ág*/System.out.println("NINCS 12 évnél kisebb különbség.");
        int db3=0;
        for(i=0; i<db; i++)
        {
           int j=2;
        while (j<szev[i]/2 && szev[i] % j != 0)
                j++;
            if (j>=szev[i]/2)
            {
                System.out.println("Primszám: "+szev[i]);
                prim[db3++]=i;
            }
            else 
                System.out.println("A "+szev[i]+" nem primszám.");
        } 
        for(i=0; i<db3; i++)
        {
            System.out.println(nev[prim[i]]+" prim évben született!");
        }
        
        
        raf.close();
    }
    catch(IOException e)
    {System.out.println("HIBA!");}

 
    
    
    
    
    }
    
}
