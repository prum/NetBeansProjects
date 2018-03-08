
package kave;
import java.util.Scanner;
public class kv_program {
    public static void main(String[] args){
    kv_automata[] gepek = new kv_automata[10];
    gepek[1] = new kv_automata("Omnia",211,50);
    gepek[2] = new kv_automata("Tchibo",350,70);
    gepek[3] = new kv_automata("Arabica",1600,30);
    int tip;
    do 
    { 
        Scanner beker = new Scanner(System.in); 
        System.out.println("\nMelyik kávét kéri?\n1.Omnia\n2.Tcibo\n3.Arabika"); 
        tip=beker.nextInt();
        System.out.println("\nHány dl-t szeretne?");
        beker=new Scanner(System.in);
        double fiz=gepek[tip].vesz(beker.nextDouble()); 
        if (fiz!=-1)
            System.out.println(fiz+" Ft-ot kell fizetnie");
        else
            System.out.println("Nincs annyi, csak"+gepek[tip].getMennyiseg()+" dl.ig kérhet!");
        for (int i=1;i<4;i++)
            System.out.println(gepek[i]);
    }   
        while(gepek[tip].getMennyiseg()>5); 
        System.out.println("A "+gepek[tip].getMarka()+". kávé kiürült!Feltöltés szükséges!");
        System.out.println("Feltoltes "+gepek[tip].feltolt()+" dl kávé");
        System.out.println(gepek[tip]);
}
}