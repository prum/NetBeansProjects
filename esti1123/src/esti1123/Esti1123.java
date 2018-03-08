
package esti1123;

public class Esti1123 {

    public static void main(String[] args) {
//11.23. Olimpiai gerelyhajító versenyen a döntősök (10 db) két sorozatot dobnak! A dobásaik 40 és 100 méter közöttiek lehetnek. A hatvan méter alatti dobások érvénytelennek számítanak!
    int i,j, szum, max, min, db, n=10;
    int A[] = new int[n];
    int B[] = new int[n];
    System.out.println("Olipiai gerely döntő");
    for(i=0;i<n;i++)
      {
       A[i]=(int)(Math.random()*60+40);
       B[i]=(int)(Math.random()*60+40);
       System.out.print((i+1)+"A:"+A[i]+" ");
       System.out.print((i+1)+"B:"+B[i]+" ");
      } 
//Készítsen programot, amely meghatározza a következőket!
//1. Hány érvénytelen dobás született a második sorozatban?
    db=0;
     for(i=0;i<n;i++)
      {
      if (B[i]<60)
          db++;
      }
      System.out.println("\nÖsszesen: "+db+" db érvénytelen dobás született a 2. sorozatban!");
//2. Mennyi lett az összes érvényes dobás átlaga?
    int db2=0;
    szum=0;
     for(i=0;i<n;i++)
      {
       if (B[i]>=60)
       {
           db2++;
           szum=szum+B[i];
       }
       if (A[i]>=60)
       {
           db2++;
           szum=szum+A[i];
       }
      }
      System.out.println("\nAz összes érvényes dobás átlaga: "+szum/db2);
//3. Mekkora lett az első sorozat legnagyobb dobása és hányadik versenyző dobta?
    max=A[0];
    int memo=0;
    for(i=1;i<n;i++)
      {
          if (max<A[i]) 
             {
              max=A[i];
              memo=i;
             }
      }
     System.out.println("\nAz első sorozat legnagyobb dobása: "+max+" és a "+(memo+1)+". versenyző dobta.");
          
//4. Ki javult a legtöbbet az első dobásához képest?
    int kul=0;
    max=0;
    int ki=0;
    for(i=0;i<n;i++)
      {
        kul=B[i]-A[i];
        if (kul>max)
        {
            max=kul;
            ki=i;
        }
      }
        System.out.println("\nA "+(ki+1)+" javult a legtöbbet az első dobásához képest.");
//5. Válogassa ki egy új tömbbe a világrekordhoz közeli dobásokat! (95 felettiek)
    System.out.println("\nA világrekordhoz közeli dobások: ");
    int C[] = new int[2*n];
    int db3=0;
    for(i=0;i<n;i++)
      {
          if (A[i]>95)
              C[db3++]=A[i];
          if (B[i]>95)
              C[db3++]=B[i];
      }
    if (db3>0)
    {
        for(i=0;i<db3;i++)
      {
           System.out.print(C[i]+", ");
      }
    }
    else
    System.out.println("\nNincs világrekordhoz közeli dobás"); 
//6. Volt-e olyan az első sorozatban, hogy két érvénytelen dobás követte egymást? Pl?
         i=1;
         while (i<n && (A[i-1]>60 || A[i]>60) )
             i++;
         if (i<n)
             System.out.println("\nVan olyan az első sorozatban, hogy két érvénytelen dobás követte egymást, pl: "+A[i-1]+", "+A[i]);
         else
              System.out.println("\nNincs olyan az első sorozatban, hogy két érvénytelen dobás követte egymást!");
        
//7. Ki lett az olimpiai bajnok. (A két dobás közül a nagyobbik számít!)
    int bajnok=0;
    max=0;
    for(i=0;i<n;i++)
      {
       if (A[i]>max)
       {
              max=A[i];
              bajnok=i;
       }
       if (B[i]>max)
       {
              max=B[i];
              bajnok=i;
       }
      }
    
    System.out.println("Az olimpiai bajnok a "+(bajnok+1)+". versenyző lett a "+max+" méteres dobással");
//8. Volt-e olyan versenyző akinek mind2 dobása érvénytelen lett? Pl?
        i=0;
         while (i<n && (A[i]>=60 || B[i]>=60) )
             i++;
         if (i<n)
             System.out.println("Van olyan versenyző akinek mind2 dobása érvénytelen lett. Pl: "+(i+1));
         else
              System.out.println("Nincs olyan olyan versenyző akinek mind2 dobása érvénytelen lett!");
//9. Hány olyan esett volt, amikor az egymást követő dobók javítottak az eredményükön?
    int db4=0;
    for(i=1;i<n;i++)
      {
          if (A[i-1]<B[i-1] && A[i]<B[i])
              db4++;
      }
     if (db4>0)
             System.out.println("Összesen: "+db4+" db volt, amikor az egymást követő dobók javítottak az eredményükön.");
         else
              System.out.println("Nem volt amikor az egymást követő dobók javítottak az eredményükön!");
     
     
     //+1: Szerepelt-e azonos dobás a két sorozatban, ha igen, pl? (Metszet)
     
     
     //+2: Volt-e olyan hogy 3 egymást követő versenyző is javított! (6. módosítása!)
     i=0;
         while (i<n-2 && (B[i]>A[i] || B[i+1]>A[i+1] || B[i+2]>A[i+2]) )
             i++;
         if (i<n)
             System.out.println("\nVolt 3 egymást követő javitás "+A[i]+", "+A[i+1]+", "+A[i+2]);
         else
              System.out.println("\nNem volt 3 egymást követő javitás!");
        
    }
    
}
