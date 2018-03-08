package tomblista; import java.util.ArrayList;
public class Tomblista
{
public static void main(String[] args )
{
ArrayList<Integer> szamok = new ArrayList<Integer>();
// töltsük fel a listát
for( int i = 0; i < 20; i++ )
{
szamok.add( (int)(Math.random()*51)-10 );
}
System.out.println("A lista mérete: "+szamok.size());
// írjuk ki az elemeit
for( int i = 0; i < szamok.size(); i++ )
{
System.out.print( szamok.get(i)+" " );
}
System.out.println();
// töröljünk ki a lista legkisebb elemét
// ha több legkisebb van, akkor az elsőt
int min = 0;
for( int i = 0; i < szamok.size(); i++ )
{
if( szamok.get(i) < szamok.get(min) )
{
min = i;
}
}
System.out.println("A legkisebb eleme: "+szamok.get(min));
szamok.remove(min);
System.out.println("A lista merete: "+szamok.size());
// a lista elemei
for (Integer i : szamok)
{
System.out.print(i+" ");
}
System.out.println();
// szúrjunk be egy véletlen elemet a lista elejére
szamok.add( 0, (int)(Math.random()*51)-10 );
for (Integer i : szamok)
{
System.out.print(i+" ");
}
System.out.println();
// nézzük meg, benne van-e az intervallum legnagyobb
// eleme a listában, és ha igen, hol?
int hely = szamok.indexOf(40);
if( hely > -1 )
{
System.out.println("A 40-es elem helye: "+hely);
}
else
{
System.out.println("Nincs 40-es elem a listában.");
}
// vizsgáljuk meg, van-e 0 érték a listában
if( szamok.contains(0) )
{
System.out.println("A lista tartalmaz 0-at.");
}
else
{
System.out.println("A lista NEM tartalmaz 0-at.");
}
// rendezzük a listában szereplő számokat növekvő sorrendbe
int csere;
for (int i = 0; i < szamok.size()-1; i++)
{
for (int j = i+1; j < szamok.size(); j++)
{
if( szamok.get(i) > szamok.get(j) )
{
csere = szamok.get(i);
szamok.set(i, szamok.get(j));
szamok.set(j, csere);
}
}
}
// írjuk ki a rendezett számokat
System.out.println("Rendezett sorrend:");
for (Integer i : szamok)
{
System.out.print(i+" ");
}
System.out.println();
// töröljük ki a negatív elemeket a rendezett listából
for( int i = 0; i < szamok.size(); i++ )
{
if( szamok.get(i) > -1 )
{
szamok.removeAll(szamok.subList(0, i));
break;
}
}
// írjuk ki a listában maradt elemeket
for (Integer i : szamok)
{
System.out.print(i+" ");
}
}
}
/*
8 – Figyeld meg, hogy nem hivatkozok a lista méretére a feltöltésekor, mivel a mérete alaphelyzetben 0. A for ciklusban a futási feltételben számként adom meg, hogy 20x fusson le a ciklus, vagyis 20 elemet fogok eltárolni a listában. Minden elem hozzáadás után a lista mérete eggyel nő.
10 – Itt láthatod, hogyan adunk hozzá egy elemet a listához, ami mindig a lista végére kerül.
12 – A lista méretét a .size() metódussal kaphatod meg.
15 – A .size() már szerepelt, de most már a lista bejárásához használom egy for ciklus futási feltételében.
17 – A lista bármelyik eleme indexelhető, hasonlóan a tömbökhöz, csak itt a hivatkozáshoz a .get(index) metódust használjuk, és nem a tömböknél tanult tomb[index] szerkezetet.
32 – Bármilyen elemet eltávolíthatok az indexe alapján a .remove(index) metódussal. Az utána elhelyezkedő elemek eggyel balra tolódnak és a lista mérete eggyel csökken.
36-39 – Foreach ciklus használható az elemek eléréséhez, például kiíratás esetén. Ha csak az elemek számítanak és az indexük nem, akkor a foreach ciklus mindig használható a for helyett.
43 – Az add(index, elem) metódussal a lista tetszőleges helyére beszúrhatunk egy elemet. Ha nem a lista végére szúrunk be elemet, akkor a beszúrás helyén lévő és a mögötte állók eggyel jobbra tolódnak, vagyis valódi beszúrásról beszélünk, nem cseréről!
53 – Az String kezelésből már ismert .indexOf(elem) metódussal megkaphatjuk egy adott elem helyét a listában. Ha az eredmény -1, akkor nincs a listában. Az indexOf() mindig a lista elejéről indítja a keresést, és több előfordulás esetén az első találat helyét adja meg. A lastIndexOf(), hasonlóan a String témakörben tanulthoz hátulról adja meg az első előfordulás helyét, és -1-et ha nincs találat.
64 – A .contains(elem) logikai választ (boolean) ad arra a kérdésre, hogy az adott elem benne van-e a listában.
82-82 – A set(index, elem) metódus az index helyen lévő elemet cseréli fel az általunk megadottra. Ilyenkor a mögötte álló elemek a helyükön maradnak, vagyis nem beszúrás történik. Jellemzően az elemek felcserélésekor használjuk, hiszen az elemek eltávolítása és hozzáadása nem így történik.
102 – Ez egy komplexebb példa. Egy listából ki lehet törölni egy másik lista elemeit. Jelen esetben a .subList(int start, int end) metódust használom. A for ciklusban megnézem, hogy a rendezett tömbben hol található az első nem negatív elem. Ennek a helye i lesz. A szamok.subList(0, i) azt jelenti, hogy a 0 indextől az i előtti indexig tartó elemeket kiemelem a listából, majd ezt a kapott listát odaadom a removeAll metódusnak, hogy ezeket törölje a szamok listából.
Tömb:
Ha a tanulmányaid elején jársz.
Ha előre tudod, hány elemet szeretnél tárolni, és nem akarod bővíteni a számukat.
Ha csak primitív értékeket tárolsz.
Ha az alap algoritmusokat még nem alkalmazod hibátlanul.
ArrayList:
Ha már az alap algoritmusokat tetszőleges feladatokban hibátlanul alkalmazni tudod.
Ha objektumokkal dolgozol.
Ha a tárolt elemeid száma változhat.
Ha a tömbök már inkább korlátoznak, mint segítenek.
*/
