
package esti1116;
import java.util.Scanner;
public class Esti1116 {

    public static void main(String[] args) {
    int i,j, szum, max, min, db, n=15;
    int A[] = new int[n];
    System.out.println("PROG. TÉTELEK!");
    for(i=0;i<n;i++)
      {
       A[i]=(int)(Math.random()*100+101);
       System.out.print((i+1)+"."+A[i]+" ");
      } 
      //**1. Írja ki a hárommal osztható számokat és átlagukat!!
      szum=0;
      db=0;
      System.out.println("\n3-mal osztható számok: ");
      for(i=0;i<n;i++) 
      {
                if ( A[i] %3 ==0 )
                {
                 System.out.println("\n "+A[i]);
                 szum=szum+A[i];
                 db++;
                } 
      } 
        if (db==0) 
            System.out.println("Nincs 3-mal osztható szám");
        else
            System.out.println("A szamok átlaga: "+szum/db);
        
        ///***2. Adja meg van-e 11-el osztható szám, ha igen mondjon rá egy példát sorszámmal!
        
         i=0;
         while (i<n && A[i]%11!=0)
             i++;
         if (i<n)
             System.out.println("Van 11-el osztható, pl: "+A[i]);
         else
              System.out.println("Nincs 11-el osztható!");
        
         //*** 3. Válogassa ki egy új tömbbe és írja ki az 150-nél kisebb héttel osztható számokat!
         db=0;
         int B[] = new int[n];
         for(i=0;i<n;i++) 
            {
                if (A[i]<150 && A[i] %7 ==0 )
                {
                  B[db++]=A[i];  
                }
            }
         if (db==0) System.out.println("Nincs 150-nél kisebb héttel osztható szám");
         else
         {
         System.out.println("Van 150-nél kisebb héttel osztható szám");
         for(i=0;i<db;i++)
            System.out.println(" "+B[i]); 
         }
         
         //***4. Kérjen be egy számot és adja meg az azon helyen található számot és valódi osztóit!
         
             System.out.println("\nAdjon meg egy sorszámot");
             Scanner beker = new Scanner(System.in);       //bekeres
             int sszam = beker.nextInt()-1;      //egész szám kiszedése
             System.out.println("Az Ön által megadott szám: "+A[sszam]);
             boolean prim=true;
             for(i=2;i<A[sszam]/2;i++)
                 if (A[sszam] % i == 0)
                 {
                     System.out.println("\n"+i);
                     prim=false;
                 }
             if (prim)  System.out.println("\nNincs valódi osztója, prim szám!");
             
             
             ////**5. Egy új változóba adjon meg egy véletlen számot és adja meg a sorozat mely eleme van hozzá a legközelebb!
             int UJVALT=(int)(Math.random()*100+101);
    int KUL[] = new int[n];
    for(i=0;i<n;i++)
        KUL[i]=Math.abs(UJVALT-A[i]);
    min=0;
    for(i=1;i<n;i++)
        if (KUL[i] < KUL[min]) min=i;
    System.out.print("\nA kisorsolt szám: "+UJVALT+" ");
    System.out.print((min+1)+". elem van legközelebb hozzá, különbségük csupán: "+KUL[min]);
        

             ///**6. Rendezze a sorozatot nagyság szerint emelkedő sorrendbe!
             //BUBORÉKRENDEZÉS
    for(i=n-1;i>0;i--) //külső ciklus - i szerint
        for(j=0;j<i;j++)    //belső ciklus - j szerint
            if (A[j]>A[j+1])
                {
                int sv=A[j]; //csere
                A[j]=A[j+1];
                A[j+1]=sv;
                }
    System.out.println("\nRENDEZETT 'A' SOROZAT!");
    for(i=0;i<n;i++) 
      System.out.print((i+1)+"."+A[i]+" ");
    
    ///***7. Adja meg van-e olyan szomszédos számpáros a rendezett tömbben, melynek különbsége kereken 20, ha van ilyen, mutasson rá példát.
    i=0;
while (i<n-1 && Math.abs(A[i]-A[i+1])!=20)
    i++;
if (i<n-1) System.out.println ("\nVan olyan elem amelynek különbsége kereken 20: " + (i+1) );
    else System.out.println ("\nNincs olyan elem amelynek különbsége kereken 20");
       
    
    
    
    }
    
}
