package esti1019_tanar;
public class Esti1019_tanar {
    public static void main(String[] args) {
    int i, szum, max, min, db, n=10;
    int A[] = new int[n];
    System.out.println("PROG. TÉTELEK!");
    for(i=0;i<n;i++)
      {
       A[i]=(int)(Math.random()*1000+1);
       System.out.print((i+1)+"."+A[i]+" ");
      } 
    //1 feltételes összegzés
    db=0;
    for(i=0;i<n;i++)
       if (A[i]>800 && A[i] % 2 == 1)
           db++;
    System.out.println("\n"+db+" darab 800nal nagyobb ptl.");
    //2 szélső érték keresés (min-max)
    min=0;
    for(i=1;i<n;i++)
        if (A[i]<A[min]) min=i;
    System.out.println("A legkisebb elem ssz.a: "+(min+1));
    //3 Eldöntés    
    i=0;
    while (i<n && A[i]<=950)
        i++;
    if (i<n)  
    /*igaz ág*/ System.out.println("VAN 950-nél nagyobb!!");
        else
    /*hamis ág*/System.out.println("NINCS 950-nél nagyobb!!");
    //4 Eldöntés - hátulról 
    i=n-1;
    while (i>=0 && A[i] % 3 != 0)
        i--;
    if (i>=0) System.out.println(A[i]+" az utolsó háromma osztható");
    else System.out.println("Nincs hérommal osztható!"); 
    //5 Eldöntés
    int j=2; // i-ve is lehetne!
    while ( j<A[6]/2 && A[6] % j != 0)
        j++;
    if (j>=A[6]/2) System.out.println("A hetedik prímszám "+A[6]); 
    else System.out.println("A hetedik nem prím "+A[6]); 
    //6 Min keresés számított tömbön
    int KUL[]=new int[n-1];
    for(i=0;i<n-1;i++)
        KUL[i]=Math.abs(A[i]-A[i+1]);
    int mink=0;
    for(i=1;i<n-1;i++)
        if (KUL[i]<KUL[mink]) 
            mink=i;
    System.out.println("A legkisebb kul. a "+(mink+1)+" és a "+(mink+2)+" elem...");
    System.out.println("Amely: "+KUL[mink]);
    //7 - ELSŐ SZÁMJEGY 100-al való osztás!!
    //8 - Eldöntés 2 feltétellel!! (Vigyázni a logikai kapcsolatra)
    //9 - Minden cikluslépésben a ciklusváltozó prímvizsgálata
    
    System.out.println("PRÍMEK 200ig:");
    for(i=1;i<1000000;i++)
        {
        j=2; //Prímvizsgálat
        while ( j<i/2 && i % j != 0)
            j++;
        if (j<i/2) ; 
        else System.out.println(i+", ");     
        }
    //10 - eldöntés
    i=1;
    while (i<n-1 && A[i]<=A[i-1]+A[i+1])
        i++;
    if (i<n-1) 
        System.out.println("VAN PL.: "+(i+1));
    else
        System.out.println("NINCS"); 
    //11
    int db300=0;
    int T300[] = new int[n];
    for(i=0;i<n;i++)
        if (A[i]>=300 && A[i]<=399)
            T300[db300++]=A[i];
    
    if (db300==0)  System.out.println("NINCS");
    else
        {
        System.out.println("300as számok: ");
        for(i=0;i<db300;i++)
            System.out.print(T300[i]+"  ");
        }
    
    //12 - MIN keresés!! VIGYÁZNI
    System.out.println("A legkisebb elem ssz.a: "+(min+1));
    int min2=0;
    for(i=1;i<n;i++)
        if (A[i]<A[min2] && i!=min) min2=i;
    System.out.println("A második legkisebb: "+(min2+1));
    //Nem jó megoldás, ha min=0, nem jó megoldást ad!!
    //HF - lekezelni
//1.	Adja meg hány páratlan 800nál nagyobb szám van?
//2.	Adja meg a legkisebb szám sorszámát!
//3.	Adja meg szerepel-e 950-nél nagyobb érték?
//4.	Adja meg az utolsó hárommal osztható számot!
//5.	Adja meg hogy a 7. szám prímszám-e?
//6.	Adja meg mely szomszédos számok között a legkisebb a különbség!
//7.	HF Válogassa ki a háromjegyű tükörszámokat (363)
//8.	HF Van e 950-nél nagyobb hárommal osztható! 
//9.	HF Írja ki a prímszámokat 200-ig!
//10.	Van-e olyan elem, mely nagyobb mint a szomszédos számok összege, ha igen, pl?
//11.	Válogassa ki egy új tömbbe a „300”-as elemeket! Írja is ki!
//12.	Adja meg második legkisebb elemet!
    
    }
}   

