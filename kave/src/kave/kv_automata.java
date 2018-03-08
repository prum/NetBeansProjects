
package kave;
public class kv_automata 
{
private String marka;
private double ar;
private double mennyiseg;
private double kapacitas; 
private int kiurult=1;
public kv_automata (String marka, double ar, double kapacitas){
this.marka = marka;
this.ar = ar;
this.kapacitas = kapacitas;
mennyiseg = kapacitas;
}
public double getAr(){
return ar;
}
public double getMennyiseg(){
return mennyiseg;
}
public double vesz(double menny){
if (menny<=mennyiseg){
mennyiseg-=menny;
return menny*ar;
}
else
return -1;
}
public double feltolt(){
double kell=kapacitas-mennyiseg;
mennyiseg=kapacitas;
kiurult=0;
return kell;
}
public String getMarka(){
return marka;
}
public int getKiurult(){
return kiurult;
}
public String toString(){
return "Márka: "+marka+" Ár: "+ar+" Kapacitás:"+kapacitas+" Mennyiség: "+mennyiseg;
}
}

