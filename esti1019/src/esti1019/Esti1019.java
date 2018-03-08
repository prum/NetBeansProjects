
package esti1019;

public class Esti1019 {

    public static void main(String[] args) {
                int i, max, min, db=0,dbkul=0, n=10, sum=0 , db5=0 ;
        int A[] = new int [n];
        int kul[] = new int [n-1];
        System.out.println("Prog. Tételek");
        for(i=0;i<n;i++)
            {
            A[i]=(int)(Math.random()*1000+1);
            System.out.println((i+1)+"."+A[i]+" ");
            }
     //*   Adja meg hány páratlan 800nál nagyobb szám van! */
            for(i=0;i<n;i++)      
                if ( A[i]>800 && A[i] %2 ==1 )
                    db++;
            System.out.println("\nA 800 nal nagyobb páratlanok: "+db);
            
     //*   Adja meg a legkisebb szám sorszámát!  *//
            min=0;
            for(i=1;i<n;i++) 
                 if ( A[i]<A[min]) min=i;
            System.out.println("\nA legkisebb szám sorszáma: "+(min+1));
            
     //*   Adja meg szerepel-e 950-nél nagyobb érték?  *//
        i=0;
          while (i<n && A[i]<=950)
            i++;
         if (i<n)  
        /*igaz ág*/ System.out.println("VAN 950-nél nagyobb!!");
        else
        /*hamis ág*/System.out.println("NINCS 950-nél nagyobb!!");
            
     //*   Adja meg az utolsó hárommal osztható számot! *//
            i=n-1;
            while (i>=0 && A[i]%3!=0) 
                i--;
            if (i>=0)
                System.out.println("Az utolsó hárommal osztható szám: "+A[i]);
            else
                System.out.println("Nincs hárommal osztható szám. ");   
     
     //*   Adja meg hogy a 7. szám primszám-e?  *//
     
            int j=2;
            while (j<A[6]/2 && A[6] % j != 0)
                j++;
            if (j>=A[6]/2) 
                System.out.println("A 7. primszám: "+A[6]);
            else 
                System.out.println("A hetedik nem primszám. ");
     //*   Adja meg mely szomszédos számok között a legkisebb a különbség! Min keresés számított tömbön*//
            for(i=0;i<n-1;i++) 
                 kul[i]=Math.abs(A[i]-A[i+1]);
            int mink=0;
            for(i=1;i<n-1;i++) 
                 if ( kul[i]<A[mink]) mink=i;
            System.out.println("A legkisebb kulonbseg a: "+(mink+1)+" és a "+(mink+2)+" elem között van.");
            System.out.println("Amely: "+kul[mink]);
            
            
     //*   HF Válogassa ki a 3 jegyű tükörszámokat!*//
            int tukor[] = new int [n];
            for(i=0;i<n;i++)      
                if ( A[i] % 111 ==0 ) 
                {
                    tukor[dbkul]=A[i];
                    dbkul++;
                }
                if ( dbkul > 0)
                {
                    for(j=0;j<dbkul;j++)  
                    System.out.println("\nTükörszám: "+tukor[j]);
                }    
                  else
                    System.out.println("\nNincs tükörszám!");
              
    //*   HF Válogassa ki a 3 jegyű tükörszámokat!*//
           System.out.println("\nA[3]"+A[2]);
           System.out.println("\nAz első szamjegy:"+(int) A[2]/100);
           System.out.println("\nAz utolsó szamjegy:"+(A[2]-((int) A[2]/10)*10));
           db=0;
           int tukor2[] = new int [n];
           for(i=0;i<n;i++)
           {
               if ((int) A[i]/100)==(A[i]-((int) A[i]/10)*10))
                    tukor2[db++]=A[i];
           }
          if (db==0) System.out.println("\nNincs tukorszám! "); 
          else
              
    
                
                    
     
     //*   HF Van e 950-nél nagyobb 3 mal osztható *//,
            i=0;
            while (i<n && (A[i]<=950 || A[i] % 3 !=0) )
                i++;
            if (i<n)
                System.out.println("Van 950-nél nagyobb érték,hárommal osztható pl: "+A[i]);
            else
                System.out.println("Nincs 950-nél nagyobb érték,hárommal osztható!");
           
               
     
     
     
     //*   HF Irja ki a primszámokat 200ig! *//
    System.out.println("PRÍMEK 200ig:");
    for(i=1;i<200;i++)
        {
        j=2; //Prímvizsgálat
        while ( j<i/2 && i % j != 0)
            j++;
        if (j<i/2) ; 
        else System.out.println(i+", ");     
        }

          
  
     //*   Van-e olyan szám, mely nagyobb, mint a közvetlenül mellette levo 2 szám az összege! Ha igen, pl: ELDÖNTÉS*//
     
            i=1;
            while (i<n-1 && A[i]<A[i-1]+A[i+1])
                i++;
            if (i<n-1)
                System.out.println("Van olyan szám, mely nagyobb, mint a közvetlenül mellette levo 2 szám az összege! Pl: "+A[i-1]+", "+A[i]+", "+A[i+1]);
            else
                System.out.println("Nincs!");
            
     //*  Válogassa ki egy uj tömbbe a 300-as elemeket! Irja ki! KIVÁLOGATÁS! *//
            int db300=0;
            int T300[] = new int [n];
            for(i=0;i<n;i++)
                if(A[i]>=300 && A[i]<=399)
                    T300[db300++]=A[i];
                if (db300==0) 
                    System.out.println("Nincs!");
                else
                {
                    System.out.println("300-as szamok:");
                    for(i=0;i<db300;i++)
                        System.out.print(T300[i]+" ");
                }
     //*  Adja meg a második legkisebb elemet! KIVÁLASZTÁS! *//
          
                
            
    }
    
}
