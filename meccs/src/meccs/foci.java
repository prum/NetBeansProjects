
package meccs;
import java.io.*; // IO modul
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList; // Arraylist modul
public class foci {
     public static void main(String[] args) {
     RandomAccessFile raf; // File típus
     ArrayList<Meccs> foci = new ArrayList<Meccs>(); // foci tip. tömblista létrehozása
     
// 1. Olvassa be az meccs.txt állományban található foglalások adatát! 
try // Probálja meg a fájlt beolvasni
    {
    raf = new RandomAccessFile("C://TELEPITOK//meccs.txt","r"); // Fájl hozzárendelése
    for( String sor = raf.readLine(); sor != null; sor = raf.readLine() )
    foci.add(new Meccs(sor.split(" ")));
    // Soronként beolvassuk szóközönként szétdarabolva és betéve a Szavazatok típusba, hozzáfűzve a tömblistához
    raf.close(); // Fájl bezárása
    } 
catch (Exception e) { // Hiba esetén itt megy tovább
    System.err.println("Fájlbeolvasási hiba " + e.getMessage()); }
for (Meccs i:foci) // Kiírjuk a Meccs tömblista elemeit
    System.out.println(i);
    int tomb[][] = new int [foci.size()][3];
//*Kérje be a felhasználótól egy forduló számát, majd írja a képernyőre a bekért forduló
//*mérkőzéseinek adatait a következő formában: Edes-Savanyu: 2-0 (1-0)! Soronként
//*egy mérkőzést tüntessen fel! A különböző sorokban a csapatnevek ugyanazon a pozíción
//*kezdődjenek!
    System.out.println("Kérem a forduló számát:");
    Scanner scanner = new Scanner(System.in);
    int myInt = scanner.nextInt();
    System.out.println(myInt);
    int i;
    for (i=0; i<foci.size(); i++) // Végigvesszük az eredményeket 
    if (foci.get(i).getFordulo()==myInt)
            {
               System.out.println(foci.get(i).toString());  
            }
    
    //*Határozza meg, hogy a bajnokság során mely csapatoknak sikerült megfordítaniuk az állást
    //*a második félidőben! Ez azt jelenti, hogy a csapat az első félidőben vesztésre állt
    //*ugyan, de sikerült a mérkőzést megnyernie. A képernyőn soronként tüntesse fel a forduló
    //*sorszámát és a győztes csapat nevét!
    System.out.println("Ezeknek a csapatoknak sikerült megfordítaniuk az állást a második félidőben:");
    for (i=0; i<foci.size(); i++) // Végigvesszük az eredményeket 
    if (foci.get(i).getMegfordit())
            {
               System.out.println(foci.get(i).toString());  
            }
    
    //*Kérje be a felhasználótól egy csapat nevét, és tárolja el! A következő két feladat megoldá-
    //*sához ezt a csapatnevet használja! Ha nem tudta beolvasni, használja a Lelkesek csapatnevet!
    System.out.println("Kérem a csapat nevét:");
    Scanner scanner2 = new Scanner(System.in);
    String myCsapat = scanner2.nextLine();
    if (myCsapat.equals(""))
        myCsapat="Lelkesek";
    //*Határozza meg, majd írja ki, hogy az adott csapat összesen hány gólt lőtt és hány gólt kapott!
    System.out.println(myCsapat);
    int golkapottdb=0;
    int goladottdb=0;
    for (i=0; i<foci.size(); i++) // Végigvesszük az eredményeket 
    {
        if (foci.get(i).getHazai().equals(myCsapat))
        {
            golkapottdb=golkapottdb+foci.get(i).getVegVendeg();
            goladottdb=goladottdb+foci.get(i).getVegHazai();
        }
        if (foci.get(i).getVendeg().equals(myCsapat))
        {
            golkapottdb=golkapottdb+foci.get(i).getVegHazai();
            goladottdb=goladottdb+foci.get(i).getVegVendeg();
        }  
        
    }
    System.out.println("Kapott: "+golkapottdb+" Lőtt: "+goladottdb);
    System.out.println(myCsapat+" az alábbi fordulóban kapott ki először:");
    //Határozza meg, hogy az adott csapat otthon melyik fordulóban kapott ki először és melyik
    //csapattól! Ha egyszer sem kapott ki (ilyen csapat például a Bogarak), akkor „A csapat
    //otthon veretlen maradt.” szöveget írja a képernyőre! 
     for (i=0; i<foci.size(); i++) // Végigvesszük az eredményeket 
    {
        if (foci.get(i).getHazai().equals(myCsapat) && foci.get(i).getVegHazai()<foci.get(i).getVegVendeg())
        {
            break;
        }
        
        }
     if (i>=foci.size())
        System.out.println("A csapat otthon veretlen maradt");
     else
        System.out.println(foci.get(i).toString()); 
    
   // while (i<foci.size() || foci.get(i).getHazai().equals(myCsapat))
   //     i++;
   // if (i>=foci.size()) 
   //     System.out.println("A csapat otthon veretlen maradt.");
   //else
   //    System.out.println(foci.get(i).toString());
   
    //Készítsen statisztikát, amely megadja, hogy az egyes végeredmények hány alkalommal
    //fordultak elő! Tekintse egyezőnek a fordított eredményeket (például 4-2 és 2-4)! A nagyobb
    //számot mindig előre írja! Az elkészült listát a stat.txt állományban helyezze el!
    // Például:
    //2-1: 18 darab
    //4-0: 2 darab
    //2-0: 19 darab 

    String[] erLista = new String[foci.size()];
    int[] gyakorisag = new int[foci.size()];
    String aktEr,aktFer;
    int erDb = 0;
    int j;
    for (i = 1; i <= foci.size()-1; i++) {
        j = 1;
        aktEr = foci.get(i).getEredmeny();
        while ((j <= erDb) && !(aktEr.equals(erLista[j - 1])))
        {
            j++;
        }
    if (j <= erDb) {
    gyakorisag[j - 1]++;
    } 
    else {
    erDb++;
    erLista[erDb - 1] = aktEr;
    gyakorisag[erDb - 1] = 1;
    }
    }
    for (i=0; i<foci.size(); i++) 
    {
        if (gyakorisag[i]>0)
        System.out.println(erLista[i]+": "+gyakorisag[i]+" darab");
    }
    // A statisztika fájlba írása
    //PrintWriter kiir = new PrintWriter(new FileWriter("stat.txt"));
    //for (i = 1; i <= erDb; i++) {
    //kiir.println(erLista[i - 1] + ": " + gyakorisag[i - 1] + " darab");
    //}
    //kiir.close();
    //System.out.println("A stat.txt fájl kiírása befejeződött. \n");
	try{

	FileWriter kimenet = new FileWriter("C://TELEPITOK//stat.txt");

	

	for (i = 0; i <= erDb-1; i++) {

	kimenet.write(erLista[i] + ": " + gyakorisag[i] + " darab \n");

	}

	kimenet.close();
        System.out.println("A stat.txt fájl kiírása befejeződött. \n");
	}catch (IOException e){System.out.print(e);}

        //1., Adja meg a Lelkesek csapata hány meccset játszott otthon?
        int meccsekdb=0;
        for (i=0; i<foci.size(); i++) 
            {
            if (foci.get(i).getHazai().equals("Lelkesek"))
                meccsekdb++;        
            }
        System.out.println("A Lelkesek csapata "+meccsekdb+" meccset játszott otthon.");
        
        //2., Adja meg melyik meccsen volt a legnagyobb gólkülönbség!
        int aktkul=0;
        int maxkul=0;
        int maxIndex=0;
        for (i=0; i<foci.size()-1; i++) 
            {
                aktkul=Math.abs(foci.get(i).getVegHazai()-foci.get(i).getVegVendeg());
                //System.out.println(aktkul);
            if (aktkul>maxkul)
            {
                maxkul=aktkul;
                maxIndex=i;
            }
            }
            System.out.println("A legnagyobb gólkülönbség: "+maxkul+" a "+foci.get(i).toString()+" meccsen volt.");
     //4., Adja hányszor született 2-nél több gól a 2. félidőben!
     int goldb=0;
     for (i=0; i<foci.size()-1; i++) 
            {
                if ((foci.get(i).getVegHazai()+foci.get(i).getVegVendeg()-(foci.get(i).getFelidoHazai()+foci.get(i).getFelidoVendeg()))>2 )
                    goldb++;
            }
            System.out.println("2-nél több gól a 2. félidőben "+goldb+" szor volt.");
     }
    }
    

