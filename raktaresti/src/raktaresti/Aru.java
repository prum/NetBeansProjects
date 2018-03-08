package raktaresti;
public class Aru {
private String nev;
private double egysegar;
private double menny;
public Aru(String aNev, double aEgysegar){
nev = aNev;
egysegar = aEgysegar;
menny = 0; }
public String getNev(){
return nev; }
public double getEgysegar(){
return egysegar; }
public double getMenny(){
return menny; }
public void setEgysegar(double aEgysegar){
if (aEgysegar >= 0)
egysegar = aEgysegar; }
public double getAr(){
return menny*egysegar; }
public double getAfasar(){
return ( getAr()*1.27); }
public void hozzatesz(double aMenny){
if (aMenny>0)
menny = menny + aMenny; }
public void elvesz(double aMenny){
if (aMenny>0 && aMenny<=menny)
menny = menny -aMenny; }
public String toString(){
return nev+":\nEgysegar: "+egysegar+"\tMenny: "+menny+"\tAr: "+getAr()+"\tAfasAr: "+getAfasar();
}
}

