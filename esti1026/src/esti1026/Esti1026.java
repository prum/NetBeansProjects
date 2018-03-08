
package esti1026;

public class Esti1026 {

    public static void main(String[] args) {
        //*Adott egy 15 elemü tömb,amely 2jegyű véletlen számokat tartalmaz. A[15]
        //1., Írja ki a számokat sorszámmal ellátva! A sorszámok 1-től induljanak!
        //2., Adja meg páros számok átlagát!
        //3., Adja meg szerepel-e a sorozatban 11-el osztható szám, ha igen sorszámmal mondjon rá egy példát!
        //4., Hozzon létre egy új tömböt, melybe fordított sorrendben átmásoljuk ’A’ tömb elemeit!
        //5., Adja meg hány olyan elem van, amely páratlan, harmincnál kisebb, és hárommal is osztható?
        //6., Van-e ismétlődő szám a sorozatban?
        //7., Múlt heti házi feladatok!
        //8., Van-e olyan elem melynek bármelyik rákövetkező szomszédja 60-nál kisebb Ha igen, pl.:
        
        //-------------------------------
        //1., Írja ki a számokat sorszámmal ellátva! A sorszámok 1-től induljanak!
        int i, max, min, db=0,dbkul=0, n=15, sum=0 , db5=0 ;
        int A[] = new int [n];
        System.out.println("Prog. Tételek");
        for(i=0;i<n;i++)
            {
            A[i]=(int)(Math.random()*90+10);
            System.out.println((i+1)+"."+A[i]+" ");
            }
        //2., Adja meg páros számok átlagát!
        for(i=0;i<n;i++)
        {
            if (A[i] % 2 ==0)
            {
                sum=sum+A[i];
                db++;
            }
            
        }
        System.out.println("Páros számok átlaga:"+sum/db);
        
        //3., Adja meg szerepel-e a sorozatban 11-el osztható szám, ha igen sorszámmal mondjon rá egy példát!
         i=0;
         while (i<n && A[i]%11!=0)
            i++;
         if (i<n)  
        /*igaz ág*/ System.out.println("VAN 11-el osztható!! Pl. "+(i+1)+".");
        else
        /*hamis ág*/System.out.println("NINCS 11-el osztható!!");
        
        //4., Hozzon létre egy új tömböt, melybe fordított sorrendben átmásoljuk ’A’ tömb elemeit!
        int B[] = new int [n];
        int j=0;
        for(i=n-1;i>0;i--)
        {
            B[j]=A[i];
            j++;
        }
            B[j]=A[i];
            for(i=0;i<n;i++)
            {
            System.out.println((i+1)+"."+B[i]+" ");
            }
         //4., Hozzon létre egy új tömböt, melybe fordított sorrendben átmásoljuk ’A’ tömb elemeit!   
         for(i=0;i<n;i++)
                B[i]=A[(n-1)-i];
         for(i=0;i<n;i++)
            {
            System.out.println((i+1)+"."+B[i]+" ");
            }    
         
         
        //5., Adja meg hány olyan elem van, amely páratlan, harmincnál kisebb, és hárommal is osztható?
        db=0;
        for(i=0;i<n;i++)
        {
            if (A[i] % 2 ==1 && A[i]<30 && A[i] % 3 ==0)
            {
                db++;
                System.out.println((i+1)+". "+A[i]);
            }
            
        }
        if (db==0) System.out.println("Nincs!!");
        else
        System.out.println("Páratlan, harmincnál kisebb, és hárommal is osztható!! "+db+" db.");
        
        //6., Van-e ismétlődő szám a sorozatban?
        int k=0;
        for(i=0;i<n-1;i++)
        {
            for(j=i+1;j<n;j++)
            {
            if (A[i]==A[j])
                k=i;
            }
         
        }
        if (k==0)
             System.out.println("Nincs ismétlődő!! ");
         else
             System.out.println("Van ismétlődő!! "+(k+1));
        
        
        //8., Van-e olyan elem melynek bármelyik rákövetkező szomszédja 60-nál kisebb Ha igen, pl.:
        i=0;
         while (i<n-1 && Math.abs(A[i]-A[i+1])<=60)
            i++;
        if (i<n)
             System.out.println("Van! Pl: "+(i+1));
         else
             System.out.println("Nincs!! ");         
         
        //9., Van-e olyan elem amely osztója egy másik elemnek? Ha igen, pl.: 
        k=0;
        int f;
        for(i=0;i<n-1;i++)
        {
            for(j=i+1;j<n;j++)
            
            if (A[i] > A[j])
            {
                if (A[i]%A[j]==0)
                {
                    k=i;
                    f=j;
                }
                else
                  if (A[j]%A[i]==0)
                  {
                      k=i;
                      f=j;
                  }        
                 
            }}
        if (k==0)
            System.out.println("Nincs!! ");  
        else
            System.out.println("Van! Pl: "+(k+1)+" és"+(f+1));
          
        
    }
    
}
