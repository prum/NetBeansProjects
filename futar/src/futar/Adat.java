
package futar;


public class Adat 
{
    private int nap;
    private int hanyadik;
    private int km;

    public Adat(String[] adat)
    {
    nap = Integer.parseInt(adat[0]); 
    hanyadik = Integer.parseInt(adat[1]); 
    km = Integer.parseInt(adat[2]);
    }

public int getNap() 
{return nap;}
public int getHanyadik() 
{return hanyadik;}
public int getKm() 
{return km;}

public String toString()
{return nap+".nap "+hanyadik+".fuvar: "+km+" km";}
}