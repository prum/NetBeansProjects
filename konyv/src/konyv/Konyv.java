package konyv;
public class Konyv
{ //Könyv osztály attribútumai
int oldalszam; // hány oldalas
int aktualis; //hol van nyitva
boolean nyitva; //állapot

public Konyv() // jellemzők értékkapása
{ // konstruktor
oldalszam = (int) (Math.random() * 101)+50;
aktualis = 0;
nyitva = false;
}
public void kinyit()
{
if ( nyitva )
System.out.println( "A konyv mar nyitva van." );
else
{
nyitva = true;
aktualis = (int) (Math.random() * oldalszam) + 1;
System.out.println( "Kinyitottad a konyvet a "+aktualis+
" oldalon." ); }
}
public void bezar()
{
if( !nyitva )
{
System.out.println( "A konyv mar be van zarva." );
return;
}
nyitva = false;
aktualis = 0;
System.out.println( "Bezartad a konyvet." );
}

public void nez()
{
if( nyitva )
System.out.println( "A konyv nyitva van a "+aktualis+
" oldalon." );
else
System.out.println( "A konyv zarva van." );
}
public void lapoz( int irany )
{
if( !nyitva )
{
System.out.println( "A konyv zarva van, nem lapozhato." );
return;
}
if( irany > 0 )
{
aktualis++;
System.out.println( "Lapoztal egyet hátra." );
}
else
{
aktualis--;
System.out.println( "Lapoztal egyet elore." );
}

if( aktualis == 0 || aktualis == oldalszam + 1 )
bezar();
}
public void porget( int irany )
{
int elozo, mennyit;
if( !nyitva )
{
System.out.println( "A konyv zarva van, nem porgetheto." );
return;
}
elozo = aktualis;
if( irany > 0 ) // Ha az irány pozitív de az utolsó oldalon tartasz
{
if( aktualis == oldalszam )
{
System.out.println( "Mar az utolso oldalon tartasz, arra nem porgetheted." );
return;
}
// a fennmarado oldalak [aktualis+1;oldalszam]
mennyit = (int)(Math.random()*(oldalszam-aktualis))+aktualis+1;
aktualis = mennyit;
System.out.println( "Hatra porgettel "+
Math.abs(elozo-aktualis)+" oldalt." );
}
// egyebkent hatra fele porgetes
else
{
if( aktualis == 1 )
{
System.out.println( "Mar az elso oldalon tartasz, arra nem porgetheted." );
return;
}

mennyit = (int)(Math.random()*(aktualis-1))+1;
aktualis = mennyit;
System.out.println( "Elore porgettel "+
Math.abs(elozo-aktualis)+" oldalt." );
}
}

public String toString()
{
return "Konyv{" + "oldalszam=" + oldalszam + ", aktualis=" +
aktualis + ", nyitva=" + nyitva + "}";
}
}
