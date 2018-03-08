package valasztas;
import java.io.*; // IO modul
import java.util.ArrayList; // Arraylist modul
import java.util.Scanner;
public class Valasztas {
public static void main(String[] args) { // Főfüggvény
RandomAccessFile raf; // File típus
ArrayList<Szavazatok> voksok = new ArrayList<Szavazatok>(); // Szavazatok tip. tömblista létrehozása
// 1. Olvassa be az szavazatok.txt állományban található foglalások adatát! 
try // Probálja meg a fájlt beolvasni
{
raf = new RandomAccessFile("C://TELEPITOK//szavazatok.txt","r"); // Fájl hozzárendelése
for( String sor = raf.readLine(); sor != null; sor = raf.readLine() )
voksok.add(new Szavazatok(sor.split(" ")));
// Soronként beolvassuk szóközönként szétdarabolva és betéve a Szavazatok típusba, hozzáfúzve a tömblistához
raf.close(); // Fájl bezárása
} 
catch (Exception e) { // Hiba esetén itt megy tovább
System.err.println("Fájlbeolvasási hiba " + e.getMessage()); }

for (int i=0; i<voksok.size(); i++) // A forgalom tömblista kiírása foreach cilkussal
System.out.println(voksok.get(i).getVnev()+":"+voksok.get(i).getDarab());
System.out.println("2. Hány képviselőjelölt indult a helyhatósági választáson?"); 
System.out.println("A választásokon "+voksok.size()+" darab jelölt indult!!");
//3. Kérje be egy képviselőjelölt vezetéknevét és utónevét, majd írja ki a képernyőre, hogy az illető hány 
//szavazatot kapott! Ha a beolvasott név nem szerepel a nyilvántartásban, úgy
//jelenjen meg a képernyőn az „Ilyen nevű képviselőjelölt nem szerepel a nyilvántartásban!” figyelmeztetés! 
//A feladat megoldása során feltételezheti, hogy nem indult két azonos nevű képviselőjelölt a választáson.
//------------------------
System.out.println("3. Feladat");
System.out.println("Kérem adja meg a keresett jelölt VEZ. nevét!");
Scanner bev = new Scanner(System.in);
String vnevbe = bev.nextLine();
System.out.println("Kérem adja meg a keresett jelölt KER. nevét!");
Scanner bek = new Scanner(System.in);
String knevbe = bek.nextLine();
System.out.println(vnevbe+" "+knevbe); 
int i=0;
while( i<voksok.size() && (!vnevbe.equals(voksok.get(i).getVnev()) || !knevbe.equals(voksok.get(i).getKnev()) ))
i++;
if (i<voksok.size())
System.out.println(vnevbe+" "+knevbe+":"+voksok.get(i).getDarab()); 
else
System.out.println("Nincs ilyen nevű az adatbázisban!");

//------------------------------
//4. Határozza meg, hányan adták le szavazatukat, és mennyi volt a részvételi arány! 
//(A részvételi arány azt adja meg, hogy a jogosultak hány százaléka vett részt a szavazáson.) 
//A részvételi arányt két tizedesjegy pontossággal, százalékos formában írja
//ki a képernyőre!
//Például:
//A választáson 5001 állampolgár, a jogosultak 40,51%-a vett részt.
//------------------------------
int szav=0;
int ossz=12345;
double szazalek=0;

for (int j=0;j<voksok.size();j++)
                 {
                 szav=szav+voksok.get(j).getDarab();
                 }
                 szazalek=szav*10000/ossz;
        System.out.println("4.Feladat");        
        System.out.println("A választáson "+szav+" állampolgár, a jogosultak "+szazalek/100+"%-a vett részt.");
///-----------------
//5. Határozza meg és írassa ki a képernyőre az egyes pártokra leadott szavazatok arányát az 
//összes leadott szavazathoz képest két tizedesjegy pontossággal! A független jelölteket
//együtt, „Független jelöltek” néven szerepeltesse!
//Például:
//Zöldségevők Pártja= 12,34%
///Független jelöltek= 23,40%
///-----------------
int GYEP=0;
int ZEP=0;
int HEP=0;
int TISZ=0;
int FUGG=0;
double szaz=0;

for (int j=0;j<voksok.size();j++)
       {
          
        if (voksok.get(j).getPart().equals("GYEP"))
             GYEP=GYEP+voksok.get(j).getDarab();  
        if (voksok.get(j).getPart().equals("ZEP"))
             ZEP=ZEP+voksok.get(j).getDarab();
        if (voksok.get(j).getPart().equals("HEP"))
             HEP=HEP+voksok.get(j).getDarab();
        if (voksok.get(j).getPart().equals("TISZ"))
             TISZ=TISZ+voksok.get(j).getDarab();
        if (voksok.get(j).getPart().equals("-"))
             FUGG=FUGG+voksok.get(j).getDarab();
       } 
        szaz=GYEP*10000/szav;
        System.out.println("Gyümölcsevők Pártja: "+GYEP+" szavazat, "+szaz/100+"%.");
        szaz=ZEP*10000/szav;
        System.out.println("Húsevők Pártja: "+ZEP+" szavazat, "+szaz/100+"%.");
        szaz=HEP*10000/szav;
        System.out.println("Gyümölcsevők Pártja: "+HEP+" szavazat, "+szaz/100+"%.");
        szaz=TISZ*10000/szav;
        System.out.println("Tejivók Szövetsége: "+TISZ+" szavazat, "+szaz/100+"%.");
        szaz=FUGG*10000/szav;
        System.out.println("Független jelöltek: "+FUGG+" szavazat, "+szaz/100+"%.");
        
        //-----------
        //6. Melyik jelölt kapta a legtöbb szavazatot? Jelenítse meg a képernyőn a képviselő 
        //vezetékés utónevét, valamint az őt támogató párt rövidítését, vagy azt, hogy független! Ha több
        //ilyen képviselő is van, akkor mindegyik adatai jelenjenek meg!
        //-----------
      int maxInd = 0;  // Maxkiválasztás!!!
      for( int k = 1; k < voksok.size(); ++k )
      {
        if( voksok.get(k).getDarab() > voksok.get(maxInd).getDarab() )
        {
          maxInd = k;
        }
      }
      System.out.println("A legtöbb szavazatot kapó jelölt: "+voksok.get(maxInd).getVnev()+" "+voksok.get(maxInd).getKnev()+" ,pártja: "+voksok.get(maxInd).getPart());
        }
}