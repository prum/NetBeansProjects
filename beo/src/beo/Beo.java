
package beo;
import java.util.ArrayList;
public class Beo {

    public static void main(String[] args) 
    {
        ArrayList<Integer> szamok = new ArrayList<Integer>();
        for (int i=0; i<20 ;i++)
            szamok.add((int)(Math.random()*51)-10);
        System.out.println("A lista mérete: "+szamok.size());
        for(int i = 0; i<szamok.size();i++)
             System.out.print(szamok.get(i)+" ");
        int min =0;
        for(int i = 0; i<szamok.size();i++)
            if (szamok.get(i)<szamok.get(min))
                min=i;
        System.out.println("\nA legkisebb eleme: "+szamok.get(min));
        szamok.remove(min);
        System.out.println("\nA lista mérete: "+szamok.size());
        for (Integer A : szamok)
            System.out.print(A+" ");
        
        if (szamok.indexOf(25)>-1)
            System.out.println("\nSzerepel a 25 itt: "+szamok.indexOf(25));
        else
            System.out.println("\nNem szerepel a 25!");
        szamok.add(0,-100);
        szamok.set(1, 600);
        for (Integer A : szamok)
            System.out.print(A+" ");
        if (szamok.contains(10))
            System.out.println("\nSzerepel a 10");
        else
            System.out.println("\nNem szerepel a 10!");
        
    }
    
}
