
package valasztas_uj;
import java.io.*; // IO modul
import java.util.Scanner;
import java.util.ArrayList; // Arraylist modul
public class Valasztas_uj {
public static void main(String[] args) { // Főfüggvény
RandomAccessFile raf; // File típus
ArrayList<Szavazatok> voksok = new ArrayList<Szavazatok>(); // Szavazatok tip. tömblista létrehozása
// 1. Olvassa be az szavazatok.txt állományban található foglalások adatát! 
try // Probálja meg a fájlt beolvasni
    {
    raf = new RandomAccessFile("C://TELEPITOK//szavazatok.txt","r"); // Fájl hozzárendelése
    for( String sor = raf.readLine(); sor != null; sor = raf.readLine() )
    voksok.add(new Szavazatok(sor.split(" ")));
    // Soronként beolvassuk szóközönként szétdarabolva és betéve a Szavazatok típusba, hozzáfűzve a tömblistához
    raf.close(); // Fájl bezárása
    } 
catch (Exception e) { // Hiba esetén itt megy tovább
    System.err.println("Fájlbeolvasási hiba " + e.getMessage()); }
for (Szavazatok i:voksok) // Kiírjuk a voksok tömblista elemeit
    System.out.println(i);
//2. Hány képviselőjelölt indult a helyhatósági választáson? 
System.out.println("A választáson "+voksok.size()+" darab jelölt indult!");
//3. Kérje be egy képviselőjelölt vezetéknevét és utónevét, majd írja ki a képernyőre, hogy az illető hány szavazatot kapott! 
System.out.println("Kérem adja meg a keresett jelölt VEZ. nevét!");
Scanner bev = new Scanner(System.in); // Vez.név bekérése
String vnevbe = bev.nextLine();
System.out.println("Kérem adja meg a keresett jelölt KER. nevét!");
Scanner bek = new Scanner(System.in); // Ker.név bekérése
String knevbe = bek.nextLine();
System.out.println("Az Ön által megadott név: "+vnevbe+" "+knevbe); 
int i=0; // eldöntés - keresés (két feltétellel)
while( i<voksok.size() && (!vnevbe.equals(voksok.get(i).getVnev()) || !knevbe.equals(voksok.get(i).getKnev()) ))
    i++;
if (i<voksok.size()) // ha talál egyezést, a ciklus idő előtt megáll
    System.out.println(vnevbe+" "+knevbe+":"+voksok.get(i).getDarab()+" szavazat!"); 
else
    System.out.println("Nincs ilyen nevű ember az adatbázisban!");
//4. Határozza meg, hányan adták le szavazatukat, és mennyi volt a részvételi arány! 
int szum=0; // Összegzés tétele
for (i=0; i<voksok.size(); i++)
    szum  =szum + voksok.get(i).getDarab();
System.out.println(szum+" darab szavazó jelent meg,ami az össz szav. "+(szum*100/12345)+"%-a!");
//5 Határozza meg és írassa ki a képernyőre az egyes pártokra leadott szavazatok arányát az összes leadott szavazathoz képest
ArrayList<String> P = new ArrayList<String>(); // Létrehozzuk a pártok tömblistát
P.add(voksok.get(0).getPart()); // Az első pártot betesszük a 0. helyre
for (i=1; i<voksok.size(); i++) // Végigvesszük a többi pártot
    { //Minden cikluslépésben futtatunk egy eldöntést hogy szerepel-e már a listában
    int j=0;
    while (j<P.size() && !voksok.get(i).getPart().equals(P.get(j)))
        j++;
    if (j>=P.size()) // Ha nem szerepel az eldöntés "túlfut"
       P.add(voksok.get(i).getPart()); // És felvesszük következő tömblistaelemként
    }
int[] PSZAV= new int[P.size()]; // Létrehozunk egy tömböt melybe a pártszavazatokat tesszük
for (i=0; i<voksok.size(); i++)
    {
    int j=0; // kiválasztás tétele
    while (!voksok.get(i).getPart().equals(P.get(j)))
        j++; // ahol megtalálta, ott megáll, annál a sorszámnál növeli a szavazatszámlálót
    PSZAV[j]=PSZAV[j]+voksok.get(i).getDarab();
    }
for(i=0;i<P.size();i++)
    {
    if (P.get(i).equals("-")) // Ha nincs párt akkor független
        System.out.println("Független jelölt: "+PSZAV[i]+" szavazat, mely aránya: "+(PSZAV[i]*100)/szum+"%");
    else
        System.out.println(P.get(i)+": "+PSZAV[i]+" szavazat, mely aránya: "+(PSZAV[i]*100)/szum+"%");
    }
//6. Melyik jelölt kapta a legtöbb szavazatot? 
int max=0; // Maximumkiválasztás
for (i=0; i<voksok.size(); i++)
    if (voksok.get(i).getDarab() > voksok.get(max).getDarab())
        max=i;
System.out.println("Legtöbb. szav.kap: " + voksok.get(max).getVnev()+ " "+voksok.get(max).getKnev());    
//7. Határozza meg, hogy az egyes választókerületekben kik lettek a képviselők! 
Szavazatok[] MAXOK = new Szavazatok[30]; //Kerületi győzteseknek létrehozunk egy tömböt
for (i=0; i<voksok.size(); i++) // Végigmegyünk az embereken
    {
    if ( MAXOK[voksok.get(i).getKer()] == null) // Ha adott helyen nincs még kerületi győztes, beteszem az elsőt
        MAXOK[voksok.get(i).getKer()]=voksok.get(i);
    else // Ha van benne, megnézem hogy az aktuális szavazatszáma nagyobb-e
        if (voksok.get(i).getDarab()> MAXOK[voksok.get(i).getKer()].getDarab())
            MAXOK[voksok.get(i).getKer()] = voksok.get(i); // Ha igen, új ember kerül az adott helyre (ker)
}
for(i=0;i<30;i++) 
    if (MAXOK[i] != null ) // Amelyik kerületben szerepel elem, azt kiírjuk!
        System.out.println(i+".kerület győztese "+MAXOK[i]);


//1.	Volt-e olyan ember, aki 50.nél kevesebb szavazatot kapott, ha igen mondjon rá példát!
i=0; // 
while( i<voksok.size() && voksok.get(i).getDarab()>=50)
    i++;
if (i<voksok.size()) // ha talál egyezést, a ciklus idő előtt megáll
    System.out.println(voksok.get(i).getVnev()+" "+voksok.get(i).getKnev()+" "+voksok.get(i).getDarab()); 
else
    System.out.println("Nincs olyan ember aki 50.nél kevesebb szavazatot kapott!");
    
//2.	Hány ember indult a HEP párt színeiben?
int emberek=0;
for (i=0; i<voksok.size(); i++) // Végigmegyünk az embereken
    {
    if (voksok.get(i).getPart().equals("HEP"))
        emberek++;
    }
    System.out.println(emberek+" db indult HEP párt színeiben.");

//3.	Írja ki azokat a jelölteket, akiknek valamelyik neve A betűvel kezdődik!*
//String.charAt(i) - adott String i. karaktere
for (i=0; i<voksok.size(); i++) // Végigmegyünk az embereken
    {
    if (voksok.get(i).getKnev().charAt(0)=='A' || voksok.get(i).getVnev().charAt(0)=='A')
        System.out.println(voksok.get(i).getVnev()+" "+voksok.get(i).getKnev());
    }

//4.	Hány párt színeiben indultak el?
ArrayList<String> Part = new ArrayList<String>(); // Létrehozzuk a pártok tömblistát
Part.add(voksok.get(0).getPart()); // Az első pártot betesszük a 0. helyre
for (i=1; i<voksok.size(); i++) // Végigvesszük a többi pártot
    { //Minden cikluslépésben futtatunk egy eldöntést hogy szerepel-e már a listában
    int j=0;
    while (j<Part.size() && !voksok.get(i).getPart().equals(Part.get(j)))
        j++;
    if (j>=Part.size()) // Ha nem szerepel az eldöntés "túlfut"
       Part.add(voksok.get(i).getPart()); // És felvesszük következő tömblistaelemként
    }
    System.out.println(Part.size()+" párt színeiben indultak el.");
    //5.	A 6. kerületben ki kapta a legkevesebb szavazatot?
     // Minkiválasztás!!!
    int minInd = 0;
    for (i=0; i<voksok.size(); i++) // Végigmegyünk az embereken
    {
        if (voksok.get(i).getKer()==6)
        {
        if( voksok.get(i).getDarab() < voksok.get(minInd).getDarab() )
            {
            minInd = i;
            }    
    
        }
    
    }
    System.out.println("A 6. kerületben  a legkevesebb szavazatot "+voksok.get(minInd).getVnev()+" "+voksok.get(minInd).getKnev()+" kapta. "+voksok.get(minInd).getDarab()+" szavazattal.");
 //6.	Ki volt leghosszabb nevű jelölt?

     
    }
}