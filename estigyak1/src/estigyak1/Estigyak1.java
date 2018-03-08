package estigyak1;
public class Estigyak1 {
    public static void main(String[] args) {
        int i, max, min, db=0, n=10, sum=0 , db5=0 ;
        int A[] = new int [n];
        int oszt5[] = new int [n];
        System.out.println("Prog. Tételek");
        for(i=0;i<n;i++)
            {
            A[i]=(int)(Math.random()*100+1);
            System.out.print((i+1)+"."+A[i]+" ");
            }
        /*Adja meg az 50-nél kisebb számok átlagát!*/
        for (i=0;i<n;i++)
            {
            if (A[i]<50)
                {
                db=db+1;
                sum=sum+A[i];
                }        
            }
         System.out.println("\nAz 50-nél kisebb számok átlaga: "+sum/db);
         
         /*Van-e 7-tel osztható, ha igen, pl. melyik?*/
         i=0;
         while (i<n && A[i]%7!=0)
             i++;
         if (i<n)
             System.out.println("Van 7-tel osztható, pl: "+A[i]);
         else
              System.out.println("Nincs 7-tel osztható!");
         
         /*Adja meg az 5-telosztható számokat!*/
         for (i=0;i<n;i++)
            { 
                if (A[i] % 5 == 0)
                {
                    oszt5[db5++]=A[i];
             }
                
            }
         if (db5==0)
            System.out.println("Nincs 5-tel osztható!");
         else
         {
            System.out.println("5-tel osztható elemek:");
             for (i=0;i<db5;i++)
                 System.out.println(oszt5[i]);
         }
         
         
         /*Adja meg a 3.elem valódi osztóit!*/
         for (i=2;i<=A[2]/2;i++)
             if (A[2] % i == 0)
                  System.out.println(i+" ");
             int KUL[]=new int[n-1];
         
    }
    
}
