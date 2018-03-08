package raktaresti;
import java.util.Scanner;
import java.util.ArrayList;
public class RaktarProgram {
public static void main(String [] args){ 
ArrayList<Aru> zoldseg = new ArrayList<>();
int melyik;
zoldseg.add(new Aru("Paradicsom ",150));
zoldseg.add(new Aru("Paprika ",230));
zoldseg.add(new Aru("Hagyma ",170));
zoldseg.add(new Aru("Uborka ",320));
for(int i=0;i<zoldseg.size();i++)
zoldseg.get(i).hozzatesz(150);
for(Aru Z : zoldseg) {
    System.out.print("\n"+Z);
    };
do {

System.out.println("\nVálassza ki a zöldséget!");
System.out.println("1.Paradicsom/2.paprika/3.Hagyma/4.Uborka");
Scanner beker = new Scanner(System.in);
melyik = beker.nextInt()-1;
System.out.println(zoldseg.get(melyik).getNev());
System.out.println("1.Elad/2.Bevételez");
Scanner beker2 = new Scanner(System.in);
int irany = beker2.nextInt()-1;
if (irany==0)
    System.out.println("1.Elad");
else
    System.out.println("2.Bevételez");

System.out.println("Mennyiség?");
Scanner beker3 = new Scanner(System.in);
int kg = beker3.nextInt();
if (irany==0)
    zoldseg.get(melyik).elvesz(kg);
else
    zoldseg.get(melyik).hozzatesz(kg);
System.out.println(zoldseg.get(melyik).getNev()+": "+kg+"kg Fizetendő:"+zoldseg.get(melyik).getEgysegar()*kg*1.27);
for(Aru Z : zoldseg)
System.out.print("\n"+Z);
} while ( zoldseg.get(melyik).getMenny() > 10 );
System.out.println("\nSajnos a "+zoldseg.get(melyik).getNev()+" mennyisége 10 kg alá csökkent!");
}
}

//1. Irja ki az AFA-s arat is!
//2. Kérjen be egy értéket a felhasználótól és használja azt valamelyik metodusban!
//3. Ha valamelyik áruból 10 kg-nál kevesebb van, figyelmeztessen!
//4. Tegye a kiiratást szebbé és átláthatóbbá!
//5. Készítsen egy kis menüt amellyel irányithathja a Zöldséges programot!
//6. Próbáld meg tömbbel vagy tömblistával kezelni a zöldségeket!

