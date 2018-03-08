package esti1109;
import java.util.Scanner;
public class Esti1109 {
    public static void main(String[] args) {
    int i,j, szum, max, min, db, n=10;
    int A[] = new int[n];
    int B[] = new int[n];
    System.out.println("A sorozat:");
    for(i=0;i<n;i++) 
      {
       A[i]=(int)(Math.random()*90+9);
       System.out.print((i+1)+"."+A[i]+" ");
      }
    System.out.println("\nB sorozat:");
    for(i=0;i<n;i++) 
      {
       B[i]=(int)(Math.random()*90+9);
       System.out.print((i+1)+"."+B[i]+" ");
      }   
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
    //MINKIVÁLASZTÁSOS RENDEZÉS   
    for(i=0;i<n-1;i++) //külső ciklus - i szerint
        {
        min=i;
        for(j=i+1;j<n;j++) //belső ciklus - j szerint
            if (B[j]<B[min])
                min=j;
        int sv=B[i]; //csere
        B[i]=B[min]; //csere
        B[min]=sv; //csere
        }
    System.out.println("\nRENDEZETT 'B' SOROZAT!");
    for(i=0;i<n;i++) 
      System.out.print((i+1)+"."+B[i]+" ");
    
    System.out.println("\nAdjon meg egy sorszámot");
    Scanner beker = new Scanner(System.in);       //bekeres
    int sszam = beker.nextInt()-1;      //egész szám kiszedése
    System.out.println("Az Ön által megadott szám: "+A[sszam]);

    //** Adja meg,szerepel-e valamelyik tömben a 11-es szám, ha igen, melyikben?
         i=0;
         while (i<n && A[i]!=11)
            i++;
         if (i<n)  
        /*igaz ág*/ System.out.println("VAN 11-es az A tömbben");
        else
        /*hamis ág*/System.out.println("NINCS 11-es az A tömbben");
    
         i=0;
         while (i<n && B[i]!=11)
            i++;
         if (i<n)  
        /*igaz ág*/ System.out.println("VAN 11-es az B tömbben");
        else
        /*hamis ág*/System.out.println("NINCS 11-es az B tömbben");
         
         
         
         ///***Adja meg hány olyan elem van A és B sorozatban amely 11-el osztható?
    int szamlalo=0;         
    for(i=0;i<n;i++)
    {
        if (A[i]%11==0) szamlalo++;
        if (B[i]%11==0) szamlalo++;
    }   
    System.out.println("A sorozatokban "+(szamlalo)+" db elem van amely 11-el osztható");
    
    
    
    ///*** Adja meg a rendezett B tömbben mely elemek között van  a legnagyobb különbség
    int kul[] = new int[n-1];
    for(i=0;i<n-1;i++) 
            kul[i]=Math.abs(B[i]-B[i+1]);
            int maxk=0;
            for(i=1;i<n-1;i++) 
                 if ( kul[i]>kul[maxk]) maxk=i;
            System.out.println("A legnagyobb kulonbseg a: "+(maxk+1)+" és a "+(maxk+2)+" elem között van.");
            System.out.println("Amely: "+kul[maxk]);
            
            
            
    ///*** Egy C tömbbe válogassa ki és irja ki A és B tömb közös elemeit! (metszet)
    int C[] = new int[n];
    db=0;
    for(i=0;i<n-1;i++) //*Sorba veszem A elemét
    {
        j=0; //**Eldöntés minden lépésben A[i] benne van e B-ben?
        while (j<n && B[j]!=A[i])
            j++;
        if (j<n) C[db++]=B[j];
    }        
    if (db==0) System.out.println("Nincs közös elem");
        else
    {
        System.out.println("A két tömb közös elemei:");
        for(i=0;i<db;i++)
        System.out.println(C[i]);
    }
    
    //**5. Kérjen be egy számot és irja ki A tömb annyiadik elemét,  valamint azt,
    //**hogy prim e ha nem az akkor a valódi osztóját!
    
    
    //**6. Egy UNIO tömbbe adja meg a 2 tömb unioját! Unio: vagy az egyikben vag a másikban benne vannak.
    
    //**7. Adja meg az A tömb páratlan 50-nél nagyobb 7-tel kezdődő elemeinek számát! Megszámlálás 3 feltétellel.
    
    //**8. Fűzze össze egy harmadik tömbbe A és B rendezett elemeit!***
    
    //** 9. Szerepel-e 30-nál kisebb 7-tel osztható szám a B tömbben? (Eldöntés 2 feltétellel)
    
    
    
    }
}