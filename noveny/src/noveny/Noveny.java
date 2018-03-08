
package noveny;
public class Noveny {

    private String nev;
    private String miert;
    private int kezd;
    private int veg;
    private int meddig;
public Noveny(String[]tomb)
{
    nev=tomb[0];
    miert=tomb[1];
    kezd=Integer.parseInt(tomb[2]);
    veg=Integer.parseInt(tomb[3]);
    if (kezd>veg)
        meddig=12-kezd+veg;
    else
        meddig=veg-kezd;
    
}
public String toString()
{
    return "Noveny{"+"nev="+nev+",miert="+miert+",kezd="+kezd+", veg="+veg+" ("+meddig+" honapig)"+'}';
}
public int getMeddig(){
return meddig;
}
public String getNev(){
return nev;
}
}      