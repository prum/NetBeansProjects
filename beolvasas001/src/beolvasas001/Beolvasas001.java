
package beolvasas001;
import java.io.*;
public class Beolvasas001 {
    public static void main(String[] args) {
    RandomAccessFile raf;
    String sor;
    String[] nevek=new String[100];
    try
    {
        raf=new RandomAccessFile("C:\\TELEPITOK\\file2.txt","r");
        int db=0;
        sor=raf.readLine();
        db=Integer.parseInt(sor);
        for (int i=0;i<db;i++)
        {
            nevek[i]=raf.readLine();
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
//Ha a file tartalmaz információt arról, hogy hány
//rekordunk van, akkor for ciklust használhatunk
//amennyibe nincs így, akkor elöl vagy hátul tesztelős ciklussal
//olvassuk be addig amííg van érték.
//Fontos, hogy az adat soroknak megfelelő struktúrát a beolvasás elött
//kialakítsuk,ami által az adatokon egyől műveleteket tuduk végezni.