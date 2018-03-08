package raktarestitamas;
import java.util.ArrayList; 
import java.util.Scanner;
public class RaktarProgram {
public static void main(String [] args){ 
ArrayList<Aru> zoldseg = new ArrayList<Aru>();
int melyik;
zoldseg.add(new Aru("Paradicsom ",150));
zoldseg.add(new Aru("Paprika ",230));
zoldseg.add(new Aru("Hagyma ",170));
zoldseg.add(new Aru("Uborka ",320));
for(int i=0;i<zoldseg.size();i++)
zoldseg.get(i).hozzatesz(150);
for(Aru Z : zoldseg)
System.out.print("\n"+Z);
do {
System.out.println("\nMelyik Zöldségből venne?");
System.out.println("1.Paradicsom/2.paprika/3.Hagyma/4.Uborka");
Scanner beker = new Scanner(System.in);
melyik = beker.nextInt();
System.out.println("Mennyit venne?");
beker = new Scanner(System.in);
int kg = beker.nextInt();
zoldseg.get(melyik-1).elvesz(kg);
System.out.println(zoldseg.get(melyik-1).getNev()+": "+kg+"kg Fizetendő:"+zoldseg.get(melyik-1).getEgysegar()*kg);
for(Aru Z : zoldseg)
System.out.print("\n"+Z);
} while ( zoldseg.get(melyik-1).getMenny() > 50 );
System.out.println("\nSajnos a "+zoldseg.get(melyik-1).getNev()+" mennyisége 50 kg alá csökkent!");
}
}
