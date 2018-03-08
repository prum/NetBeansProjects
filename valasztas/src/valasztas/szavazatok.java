package valasztas;
public class Szavazatok {
private int ker;
private int darab;
private String vnev;
private String knev;
private String part;

public Szavazatok(String[] adat){
ker = Integer.parseInt(adat[0]); // konvertáljuk számmá
darab = Integer.parseInt(adat[1]); // konvertáljuk számmá
vnev = adat[2]; // string
knev = adat[3]; // string
part = adat[4]; // string
}

public int getKer() // Visszatér a kerület számával
{return ker;}
public int getDarab() // Visszatér a szavazatok számával
{return darab;}
public String getVnev() // Visszatér a vez.névvel
{return vnev;}
public String getKnev() // Visszatér a ker.névvel
{return knev;}
public String getPart() // Visszatér a párt névvel
{return part;}

}


