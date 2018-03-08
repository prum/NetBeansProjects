
package esti1130;


public class Esti1130 {


    public static void main(String[] args) {
//Hozzon létre egy tömböt , melyet feltölt 20 elemmel a 500 nál kisebb poz. egész számokkal! És oldja meg a következő problémákat! A[20]
    int i,j, szum, max, min, db, n=20;
    int A[] = new int[n];
    System.out.println("Dolgozat 11.30.");
    for(i=0;i<n;i++)
      {
       A[i]=(int)(Math.random()*500);
       
       
      
//1. Írassa ki a számokat egymás mellé sorszámmal, majd két szóközzel elválasztva!
        System.out.print((i+1)+". "+A[i]+", ");
        } 
    System.out.println("\n");
    for(i=0;i<n;i++)
      {
        System.out.print(A[i]+"  ");  
      }
        
//2. Adja meg, a 100-nál kisebb számok átlagát!!
    szum=0;
    db=0;
      for(i=0;i<n;i++)
      {
          if (A[i]<100)
          {
              szum=szum+A[i];
              db++;
          }
      }
      if (db!=0)
          System.out.println("\nA 100-nál kisebb számok átlaga:"+(szum/db)); 
      else
          System.out.println("\nNincs 100-nál kisebb szám.");
//3. Adja meg, szerepel-e a sorozatban egyjegyű szám, ha igen mondjon rá példát!
      i=0;
         while (i<n && A[i]>10)
             i++;
          if (i<n)
             System.out.println("\nVan egyjegyű szám, pl: "+A[i]);
         else
              System.out.println("\nNincs egyjegyű szám!");
//4. Válogassa ki egy új tömbbe a 200 és 400 közé eső páratlan számokat, majd írassa ki őket!
    int B[] = new int[n];
    int db2=0;
    for(i=0;i<n;i++)
      {
      if (A[i]%2==1 && (A[i]>200 && A[i]<400) )
         B[db2++]=A[i];
      }
    if (db2>0)
    {
    System.out.println("\nA 200 és 400 közé eső páratlan számok:");
    for(i=0;i<db2;i++)
      {
        System.out.print(B[i]+"  ");    
      }
    }
    else
    System.out.println("\nNincs 200 és 400 közé eső páratlan szám.");  
//5. Adja meg, hogy az 5. szám (A[4]) prímszám-e?
    boolean prim=true;
             for(i=2;i<A[4]/2;i++)
                 if (A[4] % i == 0)
                 {
                     prim=false;
                 }
             if (prim)  
                 System.out.println("\nA "+A[4]+" prim szám!");
             else
                 System.out.println("\nA "+A[4]+" nem prim szám!");
//6. Adja meg szerepel-e a sorozatban 7-tel osztható 400nál nagyobb szám, ha igen, mondjon példát rá!
         i=0;
         while (i<n && (A[i]<400 || A[i] % 7 != 0 ))
             i++;
          if (i<n)
             System.out.println("\nVan 7-tel osztható 400nál nagyobb szám, pl: "+A[i]);
         else
              System.out.println("\nNincs 7-tel osztható 400nál nagyobb szám!");
//7. Adja meg, melyik szám van legközelebb a sorozat átlagához!! 
    int szum2=0;
    int db3=0;
    int atlag=0;
      for(i=0;i<n;i++)
      {
              szum2=szum2+A[i];
              db3++;
      }
      atlag=szum2/db3;
      
    int KUL[] = new int[n];
    for(i=0;i<n;i++)
        KUL[i]=Math.abs(atlag-A[i]);
    min=0;
    for(i=1;i<n;i++)
        if (KUL[i] < KUL[min]) min=i;
    System.out.println("\nA számok átlaga:"+(atlag));
    System.out.print((min+1)+". elem van legközelebb hozzá, különbségük csupán: "+KUL[min]);
//8. Adja meg van-e olyan hogy az egymást követő számok különbsége nagyobb mint 300, ha igen, mondjon rá példát!
    i=0;
while (i<n-1 && Math.abs(A[i]-A[i+1])<300)
    i++;
if (i<n-1) System.out.println ("\nVan olyan elem amelynek különbsége nagyobb, mint 300. A " + (i+1)+". és az utáni szám." );
    else System.out.println ("\nNincs olyan elem amelynek különbsége nagyobb, mint 300");
    }
    
}
