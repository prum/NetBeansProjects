
package hotel2;

public class Hotel2 {
private int id;
private int szoba;
private int kezd;
private int veg;	
private int fo;
private int kaja;
private int hossz;

private String nev;

public Hotel2(String[] adat){
id = Integer.parseInt(adat[0]) ; 
szoba = Integer.parseInt(adat[1]) ; 
kezd = Integer.parseInt(adat[2]);
veg = Integer.parseInt(adat[3]);
fo = Integer.parseInt(adat[4]); 
kaja = Integer.parseInt(adat[5]); 
nev = adat[6];
hossz=veg-kezd;
}
public int getHossz()
{
    return veg-kezd;
}

public String getNev()
{
    return nev;
}

public int getKaja()
{
    return kaja;
}

public int getFo()
{
    return fo;
}


public int getSzoba()
        {
            return szoba;
        }
public String toString()
{
return "ID: "+id+" Nev: "+nev+" Szoba: "+szoba+" Kezdonap: " +kezd+" Eltavozas "+veg+" Letszam "+fo+" Etel?: "+kaja+" Hossz?: "+hossz;
}
    
}
