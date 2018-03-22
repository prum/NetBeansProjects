
package futar;
import java.io.*; // IO modul
import java.util.Scanner;
import java.util.ArrayList; // Arraylist modul
public class Futar {

    public static void main(String[] args) 
    {
       RandomAccessFile raf; // File típus
       ArrayList<Adat> utak = new ArrayList<>();  // Meccsek tip. tömblista létrehozása
        // 1. Olvassa be az szavazatok.txt állományban található foglalások adatát! 
    try // Probálja meg a fájlt beolvasni
        {
            raf = new RandomAccessFile("C://forras//tavok.txt","r"); // Fájl hozzárendelése
            for( String sor = raf.readLine(); sor != null; sor = raf.readLine() )
            utak.add(new Adat(sor.split(" ")));
            raf.close(); // Fájl bezárása
            // Soronként beolvassuk szóközönként szétdarabolva és betéve a Szavazatok típusba, hozzáfűzve a tömblistához
        } 
    catch (Exception e) { // Hiba esetén itt megy tovább
        System.err.println("Fájlbeolvasási hiba " + e.getMessage()); }
    for (Adat i:utak)  // Kiírjuk a voksok tömblista elemeit
    System.out.println(i);
//2. Írja ki a képernyőre, hogy mekkora volt a hét legelső útja kilométerben! Figyeljen arra,
//hogy olyan állomány esetén is helyes értéket adjon, amiben például a hét első napján
//a futár nem dolgozott! 
    int min=0;
    for (int i=1; i<utak.size(); i++)
    if (utak.get(i).getNap()<utak.get(min).getNap())
    min=i;
    for (int i=0; i<utak.size(); i++)
    if (utak.get(i).getNap() == utak.get(min).getNap() && utak.get(i).getHanyadik() == 1)
        System.out.println("A hét első útjának hossza: "+utak.get(i).getKm()+" km");
    
    //3. Írja ki a képernyőre, hogy mekkora volt a hét utolsó útja kilométerben! 
    
    int max=0;
    int maxut=0;
    for (int i=1; i<utak.size(); i++)
    if (utak.get(i).getNap()>utak.get(max).getNap())
    max=i;
    for (int i=1; i<utak.size(); i++)
    if (utak.get(i).getNap() == utak.get(max).getNap() && utak.get(i).getHanyadik() > utak.get(maxut).getHanyadik())
    maxut=i;
    
    System.out.println("A hét utolsó útjának hossza: "+utak.get(maxut).getKm()+" km");
    
    
    //4. Tudjuk, hogy a futár minden héten tart legalább egy szabadnapot. Írja ki a képernyőre, hogy a hét hányadik napjain nem dolgozott a futár! 
System.out.println("A futár nem dolgozott ezeken a napokon: ");
for (int i=1; i<8; i++)
{
int j=0;
while (j<utak.size() && utak.get(j).getNap()!=i)
j++;
if (j>=utak.size())
System.out.print(i+", "); 
}
    
    }
    
}
