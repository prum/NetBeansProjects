
package mozi_uj;
import java.io.*;
import java.util.Scanner;

public class Mozi_uj {

    public static int countMatches(String s, Character c)
    {
        int sum=0;
        for(int i=0;i<s.length();++i)
        {
            sum=sum+((s.charAt(i)==c)?1:0);
        }
    return  sum;
    }

    public static void main(String[] args) 
    {
         RandomAccessFile fogRaf, katRaf;
         String sor;
         int ind=0;
         String[] foglaltsag= new String[15];
         String[] kategoria= new String[15];
         try
         {
             System.out.println("1.feladat");
             fogRaf=new RandomAccessFile("C:\\TELEPITOK\\foglaltsag.txt","r");
             for(sor=fogRaf.readLine();sor !=null; sor=fogRaf.readLine())
             {
                 foglaltsag[ind++]=sor;
             }
             ind=0;
             katRaf=new RandomAccessFile("C:\\TELEPITOK\\kategoria.txt","r");
             for(sor=katRaf.readLine();sor !=null; sor=katRaf.readLine())
             {
                 kategoria[ind++]=sor;
             }
             System.out.println("2.feladat");
             System.out.println("Kérem a sor számát:");
             Scanner sc= new Scanner(System.in);
             int x =sc.nextInt();
             System.out.println("Kérem a szék számát:");
             int y =sc.nextInt();
             System.out.println("A megadott szék "+((foglaltsag[x-1].charAt(y-1)=='x')?"foglalt.":"szabad."));
             
             System.out.println("3.feladat");
             int sold=0;
             for (String s:foglaltsag)
             {
                  sold=sold+countMatches(s,'x'); 
             }
             double ratio=(sold/(15.0*20.0))*100;
             int intRatio= (int)ratio;
             System.out.println("Az előadásra eddig "+sold+" jegyet adtak el, ez a nézőtér "+intRatio+"%-a."); 
             
             System.out.println("4.feladat");
             int[] sumofCat=new int[5];
             for(int i=0;i<foglaltsag.length;++i)
             {
                 for (int j=0;j<foglaltsag[i].length();++j)
                 {
                     if (foglaltsag[i].charAt(j)=='x')
                     {
                         sumofCat[Character.getNumericValue(kategoria[i].charAt(j))-1]++;
                     }
                 }
             }
             int maxInd=0;
             for (int i=1;i<sumofCat.length;++i)
             {
                if (sumofCat[maxInd]<sumofCat[i])
                {
                    maxInd=i;
                    
                }
             }
             System.out.println("A legtöbb jegyet a(z) "+(maxInd+1)+". árkategoriaban értékesitettek.");
             
             System.out.println("5.feladat");
             int[]szorzo={5000,4000,3000,2000,1500};
             int sum=0;
             for(int i=0;i<foglaltsag.length;++i)
             {
                 for(int j=0;j<foglaltsag[i].length();++j)
                 {
                     if(foglaltsag[i].charAt(j)=='x')
                     {
                         sum=sum+szorzo[Character.getNumericValue(kategoria[i].charAt(j))-1];
                     }
                 }
             }
             System.out.println("A színház bevétele pillanatnyilag "+"eladott jegyek alapján "+sum+" Ft lenne.");
             
             System.out.println("6.feladat");
             int solo=0;
             for(int i=0;i<foglaltsag.length;++i)
             {
                 if (foglaltsag[i].startsWith("ox"))
                 {
                     solo++;
                 }
                 if (foglaltsag[i].endsWith("xo"))
                 {
                     solo++;
                 }
                 for(int j=0;j<foglaltsag[i].length()-2;++j)
                 {
                     if(foglaltsag[i].substring(j, j+3).equals("xox"))
                     {
                         solo++;
                     }
                 }
             }
             System.out.println("A nézőtéren "+solo+" db egyedülálló üres hely van.");
             
             System.out.println("7.feladat");
             StringBuilder ujSor=new StringBuilder();
             RandomAccessFile ki= new RandomAccessFile("C:\\TELEPITOK\\szabad.txt","rw");
             ki.setLength(0);
             for( int i = 0; i < foglaltsag.length; ++i )
      {
        for( int j = 0; j < foglaltsag[i].length(); ++j )
        {
          ujSor.append( foglaltsag[i].charAt( j ) == 'x' ? "x" : kategoria[i].charAt( j ) );
        }
        ujSor.append( System.getProperty( "line.separator" ) );
        ki.writeBytes( ujSor.toString() );
        ujSor.setLength( 0 );
      }
    }
    catch( IOException e )
    {
      System.out.println( "Hiba!" );
    }
  }
}
