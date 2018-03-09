package meccs;
public class Meccs {// Attribútumok
private int fordulo;
private int hazaigol;
private int vendeggol;
private int fihazaigol;
private int fivendeggol;
private String hazai;
private String vendeg;
private boolean megfordit=false;

public Meccs(String[] adat){ // Konstruktor
fordulo = Integer.parseInt(adat[0]); // konvertáljuk számmá
hazaigol = Integer.parseInt(adat[1]); // konvertáljuk számmá
vendeggol = Integer.parseInt(adat[2]); // konvertáljuk számmá
fihazaigol = Integer.parseInt(adat[3]); // konvertáljuk számmá
fivendeggol = Integer.parseInt(adat[4]); // konvertáljuk számmá
hazai = adat[5]; // string
vendeg = adat[6]; // string

if ((hazaigol>vendeggol && fihazaigol<fivendeggol) || (hazaigol<vendeggol && fihazaigol>fivendeggol))
    megfordit = true;
else
    megfordit = false; 

}
// Adat visszaadó metódusok


public String getHazai() // Visszatér a kerület számával
{return hazai;}
public String getVendeg() // Visszatér a szavazatok számával
{return vendeg;}
public int getFordulo() // Visszatér a hazai golokkal a teljes játékban
{return fordulo;}

public int getVegHazai() // Visszatér a hazai golokkal a teljes játékban
{return hazaigol;}

public int getVegVendeg() // Visszatér a hazai golokkal a teljes játékban
{return vendeggol;}

public int getFelidoHazai() // Visszatér a hazai golokkal a félidőben
{return fihazaigol;}

public int getFelidoVendeg() // Visszatér a vendég golokkal a félidőben 
{return fivendeggol;}

public boolean getMegfordit()
        {   return megfordit;    }

public String getEredmeny() // Visszatér az eredménnyel
{return hazaigol+"-"+vendeggol;}

public String getFEredmeny() // Visszatér az eredménnyel
{return vendeggol+"-"+hazaigol;}

public String toString() // Kiíró metódus
{return fordulo+". "+hazai+" - "+vendeg+" "+hazaigol+"-"+vendeggol+" ("+fihazaigol+"-"+fivendeggol+")";}

}