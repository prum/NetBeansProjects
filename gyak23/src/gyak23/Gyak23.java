package gyak23;
public class Gyak23 {
    public static void main(String[] args) {
      int i, max, min, db, n=20, szum=0, db1, j;
    int A[] = new int [n];
    System.out.println("PROG. Tételek! 2017,10,26");
    for (i=0;i<n;i++)
        
        {
        A[i]= (int)(Math.random()*900+100);
        System.out.print((i+1)+". "+A[i]+"   "); //Kiíratás: x szám . 
        }
        
//Adja meg a páros számok átlagát!
System.out.println ("\n--------------------------------");        
   
db=0;
szum=0;
for (i=0;i<n;i++)
    if (A[i] % 2 == 0)
    {
        db++;
        szum=szum+A[i];
                }
System.out.println ("Páros számok átlaga: " + szum/db);

                
//Adja meg szerepel-e a sorozatban 11-el osztható szám, ha igen melyik az?
System.out.println ("--------------------------------");        
        
i=0;
while (i<n && A[i] % 11 != 0)
        i++;
if (i<n) 
        System.out.println("Van 11-el osztható szám, pl a " +(i+1)+ ". szám a "+ A[i]);
        else
        System.out.println("Nincs 11-el osztható" );       
        
        
//Hozzon létre egy új tömböt, melybe fordított sorrendben átmásoljuk ’A’ tömb elemeit!
System.out.println ("--------------------------------");          
        
int B[]=new int[n];
for (i=0;i<n;i++)
    B[i] = A [(n-1)-i];
for (i=0;i<n;i++)
    System.out.print ((i+1)+". "+B[i]+"   ");

//Adja meg hány olyan elem van, amely páratlan, harmincnál kisebb, és hárommal is osztható?
System.out.println ("\n--------------------------------");             
        
db1=0;
for (i=0;i<n;i++)
    if (A[i] % 2 != 0 && A[i]<30 && A[i] % 3 != 0)
        db1++;
    if (db1==0)
        System.out.println("Nincs 30nál kisebb,páratlan,3-al osztható szám");
        else
        System.out.println("30nál kisebb,páratlan,3-al osztható számok:  " + db1);            


//Van-e ismétlődő szám a sorozatban?
System.out.println ("--------------------------------");           
        
int k=0;
for (i=0;i<n-1;i++)
    for (j=i+1;j<n;j++)
        if (A[i] == A[j])
            k=i;

if (k==0) 
    System.out.println("Nincs ismétlődés");
    else
    System.out.println("Van ismétlődés, pl: "+ (k+1));
        
//Van e 80-nál nagyobb 3-al osztható
System.out.println ("--------------------------------");           
        
i=0;
while (i<n && (A[i]<= 80 || A[i] % 3 != 0)) 
    i++;
    if (i<n) System.out.println("Van 80-nál nagyobb 3-al osztható: " + (i+1));
        else System.out.println("Nincs 80-nál nagyobb 3-al osztható");
        
 //Válogassa ki a 3jegyű tükörszámokat! (Első számjegy 100-al való osztás)
    System.out.println ("--------------------------------");
    
System.out.println ("A [3]: " +A [2]);
System.out.println ("Vagdosás");
System.out.println ("Első számjegy: " +(int)A[2]/100);
System.out.println ("Utolsó számjegy: " +(A[2]-((int)A[2]/10)*10));
db=0;
int tukor[] = new int [n];
for (i=0;i<n;i++)
    if ((int) A[i]/100 == (A[i]-((int)A[i]/10)*10))
        tukor[db++]=A[i];
if (db==0) System.out.println("Nincs tükörszám");
        else System.out.println("Tükörszámok");
        for (i=0;i<db;i++)
            System.out.println(tukor[i]+" ");
 
        
//Van e olyan elem amelynek rákövetk. szomszédja 60-nal kisebb. pl?
    System.out.println ("--------------------------------");
 
i=0;
while (i<n-1 && Math.abs(A[i]-A[i+1])<=60)
    i++;
if (i<n-1) System.out.println ("Van olyan elem amelynek rákövetk. szomszédja 60-nal kisebb: " + (i+1) );
    else System.out.println ("Nincs olyan elem amelynek rákövetk. szomszédja 60-nal kisebb");
       
    
//Van e olyna elem amely osztója egy másik elemnek. pl?
    System.out.println ("--------------------------------");    
 
k=0;
int f=0;
for (i=0;i<n-1;i++)
    for (j=i+1;j<n;j++)
        if (A[i] > A[j])
            if ( A[i] % A[j] == 0)
        {
            k=i;
            f=j;        
        }
        else
            if (A [j] % A[i]  == 0)
            {
                k=i;
                f=j; 
            }
if (f==0) System.out.println("Nincs olyan elem amely osztója egy másik elemnek");
else 
    System.out.println("Van olyan elem amely osztója egy másik elemnek, pl: "+(k+1)+" és "+(f+1)); 

    }
    
}
