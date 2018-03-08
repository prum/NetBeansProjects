package hotel; 
public class Hotel { 
private int id;
private int szoba;
private int kezd;
private int veg;	
private int fo;
private int kaja; 
private String nev;

public Hotel(String[] adat){
id = Integer.parselnt(adat[0]) ; 
szoba = Integer.parselnt(adat[1]) ; 
kezd = Integer.parselnt(adat[2]);
veg = Integer.parselnt(adat[3]);
fo = Integer.parselnt(adat[4]); 
kaja = Integer.parselnt(adat[5]); 
nev = adat[6];
}
public String toString()
{
return "ID: "+id+" Nev: "+nev+" Szoba: "+szoba+" Kezdonap: " +kezd+" Eltavozas "+veg+" Letszam "+fo+" Etel?: "+kaja;
}
}
