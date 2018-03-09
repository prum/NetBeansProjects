
package focitanari;
import java.io.*; // IO modul
import java.util.Scanner;
import java.util.ArrayList; // Arraylist modul
public class Foci {
public static void main(String[] args) { // Főfüggvény
RandomAccessFile raf; // File típus
ArrayList<Meccsek> merkozes = new ArrayList<Meccsek>(); // Meccsek tip. tömblista létrehozása
// 1. Olvassa be az szavazatok.txt állományban található foglalások adatát! 
try // Probálja meg a fájlt beolvasni
    {
    raf = new RandomAccessFile("C://forras//meccsek.txt","r"); // Fájl hozzárendelése
    for( String sor = raf.readLine(); sor != null; sor = raf.readLine() )
    merkozes.add(new Meccsek(sor.split(" ")));
    // Soronként beolvassuk szóközönként szétdarabolva és betéve a Szavazatok típusba, hozzáfűzve a tömblistához
    raf.close(); // Fájl bezárása
    } 
catch (Exception e) { // Hiba esetén itt megy tovább
    System.err.println("Fájlbeolvasási hiba " + e.getMessage()); }
for (Meccsek i:merkozes) // Kiírjuk a voksok tömblista elemeit
    System.out.println(i);
//2
System.out.println("Kérem adja meg a keresett forduló számát!");
Scanner beker = new Scanner(System.in);
int fordbe = beker.nextInt();
for (int i=0; i<merkozes.size();i++)
    if ( fordbe == merkozes.get(i).getFord() )//
      System.out.println(merkozes.get(i));  
//3
System.out.println("A köv. csapatoknak sikerült fordítani:");
for (int i=0; i<merkozes.size();i++)
    if ( merkozes.get(i).getMegford())
        if (merkozes.get(i).getVeghazai() > merkozes.get(i).getVegvendeg())
        System.out.println(merkozes.get(i).getHazaics()+" >> "+merkozes.get(i));
        else
        System.out.println(merkozes.get(i).getVendegcs()+" >> "+merkozes.get(i));        
//4
System.out.println("Kérem adja meg az egyik csapat nevét!");
Scanner bekercs = new Scanner(System.in);
String csbe = bekercs.nextLine();
System.out.print("Az Ön által megadott csapat a "+csbe);
int i=0;
while (i<merkozes.size() && !csbe.equals(merkozes.get(i).getHazaics()))
    i++;
if (i<merkozes.size())
    System.out.print(" szerepel a bajnokságban!");
    else 
    System.out.print(" nem szerepel a bajnokságban!");
//5
int szumlott=0;
int szumkapott=0;
for (i=0; i<merkozes.size();i++)
    {
    if (csbe.equals(merkozes.get(i).getHazaics()))
        {
        szumlott+=merkozes.get(i).getVeghazai();
        szumkapott+=merkozes.get(i).getVegvendeg();
        }
    if (csbe.equals(merkozes.get(i).getVendegcs()))
        {
        szumlott+=merkozes.get(i).getVegvendeg();
        szumkapott+=merkozes.get(i).getVeghazai();
        }
    }
System.out.print("\nA kiválasztott csapat "+szumlott+" golt rúgott, illetve"+
                 szumkapott+" gólt kapott"); 
//6
i=0;
while (i<merkozes.size() && !merkozes.get(i).getVgyoz() || !csbe.equals(merkozes.get(i).getHazaics()))
    i++;

if (i>=merkozes.size())
    System.out.println("\nA megadott csapat soha nem kapott ki otthon!");
    else
    {
    int min=100;
    for (int j=0; j<merkozes.size();j++)
        if (merkozes.get(j).getVgyoz() && csbe.equals(merkozes.get(j).getHazaics()) && merkozes.get(j).getFord()<min)
            min=merkozes.get(j).getFord();
    System.out.println("\nA kiválasztott csapat a "+min+". forulóban kapott ki először hazaiként!");
        }

//7
int[][] eredm = new int[10][10];
for (i=0; i<merkozes.size();i++)
    eredm[merkozes.get(i).getVeghazai()][merkozes.get(i).getVegvendeg()]++;

for(i=0;i<10;i++)
    {
    for(int j=0;j<10;j++)
        System.out.print(eredm[i][j]+" ");  
        System.out.print("\n");
    }
try
{
  RandomAccessFile rafki;
  rafki = new RandomAccessFile("C:\\forras\\kimenet.txt","rw");
 
  for(i=0;i<10;i++)
    for(int j=0;j<10;j++)
        if (eredm[i][j] != 0)
            {rafki.writeBytes(i+"-"+j+": "+eredm[i][j]+" darab");
             rafki.writeBytes("\r\n");  }
  rafki.close();
}
catch( IOException e )
    { // Hiba esetén itt megy tovább
    System.err.println("Fájlbeolvasási hiba " + e.getMessage()); }

//+2., Adja meg melyik meccsen volt a legnagyobb gólkülönbség!
int maxkulmeccs=0;
for (i=0; i<merkozes.size();i++)
if (Math.abs(merkozes.get(i).getVeghazai()-merkozes.get(i).getVegvendeg())>Math.abs(merkozes.get(maxkulmeccs).getVeghazai()-merkozes.get(maxkulmeccs).getVegvendeg()))
maxkulmeccs=i;
System.out.println("A legnagyobb golkül. meccs: "+merkozes.get(maxkulmeccs));

//+3.,***Adja meg van-e veretlen csapat?
ArrayList<String> csapatok = new ArrayList<>();
csapatok.add(merkozes.get(0).getHazaics());
for( i=1;i<merkozes.size();i++)
{
int j=0;
while ( j<csapatok.size() && !merkozes.get(i).getHazaics().equals(csapatok.get(j))) 
j++;
if (j>=csapatok.size())
csapatok.add(merkozes.get(i).getHazaics()); 
}
for (String k : csapatok)
System.out.println(k);

for (i=0; i<merkozes.size();i++)
{
if (merkozes.get(i).getHgyoz() && csapatok.indexOf(merkozes.get(i).getVendegcs())>-1)
csapatok.remove(csapatok.indexOf(merkozes.get(i).getVendegcs()));
if (merkozes.get(i).getVgyoz() && csapatok.indexOf(merkozes.get(i).getHazaics())>-1)
csapatok.remove(csapatok.indexOf(merkozes.get(i).getHazaics()));
}

if (csapatok.isEmpty())
System.out.println("Sajnosn nincs veretlen csapat");
else
{
System.out.println("A következő csapatok veretlenek:");
for (String s : csapatok) 
System.out.println(s);
}

//+4., Adja hányszor született 2-nél több gól a 2. félidőben!
int db2nel=0;
for (i=0; i<merkozes.size();i++)
if ((merkozes.get(i).getVeghazai()+merkozes.get(i).getVegvendeg())-(merkozes.get(i).getFelhazai()+merkozes.get(i).getFelvendeg())>2)
db2nel++;
System.out.println(db2nel+" darabszor született 2nél több gól a 2.félidőben!");


}
}