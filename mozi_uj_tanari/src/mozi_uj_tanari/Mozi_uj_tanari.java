package mozi_uj_tanari;
import java.io.*;
import java.util.Scanner;
import java.io.BufferedWriter;
public class Mozi_uj_tanari {

public static int countMatches(String s, Character c)
  { int sum = 0;
    for( int i = 0; i < s.length(); ++i )
      sum = sum + ((s.charAt( i ) == c) ? 1 : 0);
    return sum; }
  
public static void main(String[] args)
  {
    RandomAccessFile fogRaf, katRaf; // két fájl beolvasása
    String sor; // szöveges változó
    int ind = 0; //index
    String[] foglaltsag = new String[15]; // foglaltság tömb
    String[] kategoria = new String[15]; // kategória tömb
    try
    {
      System.out.println( "1. feladat" );
      fogRaf = new RandomAccessFile( "C:\\TELEPITOK\\foglaltsag.txt", "r" );
      for( sor = fogRaf.readLine(); sor != null; sor = fogRaf.readLine() ) //amíg nem üres a sor beolvas
      {
        foglaltsag[ind++] = sor; // minden sor egy tömbelem
      }
      ind = 0; // index újra nullára
      katRaf = new RandomAccessFile( "C:\\TELEPITOK\\kategoria.txt", "r" );
      for( sor = katRaf.readLine(); sor != null; sor = katRaf.readLine() )
      {
        kategoria[ind++] = sor; // másik fájl beolvasása
      }
      System.out.println( "2. feladat" );
      System.out.println( "Kerem a sor szamat: " ); // érték beolvasása
      Scanner sc = new Scanner( System.in );
      int x = sc.nextInt(); // x - az adott sor száma
      System.out.println( "Kerem a szek szamat: " );
      int y = sc.nextInt(); // y az adott oszlop száma
      System.out.println( "A megadott szek "+ ((foglaltsag[x - 1].charAt( y - 1 ) == 'x') ? "foglalt." : "szabad.") );
      // kiíratás            megadott sor    adott karaktere (oszlop) ha = x akkor foglalt, különben szabad
      System.out.println( "3. feladat" );
      int sold = 0;
      for( String s : foglaltsag ) // for each ciklus
      {
        sold = sold + countMatches( s, 'x' ); // talált karakter egyezés
      }
      double ratio = (sold / (15.0 * 20.0)) * 100;
      int intRatio = (int) ratio;
      System.out.println( "Az eloadasra eddig " + sold + " jegyet adtak el, ez a nezoter " + intRatio + "%-a." );
            System.out.println( "4. feladat" );
      int[] sumofCat = new int[5]; // 5 elemű tömb a kategóriáknak
      for( int i = 0; i < foglaltsag.length; ++i )
      {         // Sorra vesszük a sorokat
        for( int j = 0; j < foglaltsag[i].length(); ++j )
        {   // Minden lépésben végigmegyünk az oszlopokon is
          if( foglaltsag[i].charAt( j ) == 'x' )
          {     // ha a foglaltsági "mátrix" adott helyén érték van 
            sumofCat[Character.getNumericValue( kategoria[i].charAt( j ) ) - 1]++;
          }     // akkor a hozzá tartozó értéket számmá alakítva, növeli adott helyet
        }
      }
      int maxInd = 0;  // Maxkiválasztás!!!
      for( int i = 1; i < sumofCat.length; ++i )
      {
        if( sumofCat[maxInd] < sumofCat[i] )
        {
          maxInd = i;
        }
      }
      System.out.println( "A legtobb jegyet a(z) " + (maxInd + 1) + ". arkategoriaban ertekesitettek." );
 
      System.out.println( "5. feladat" );
      int[] szorzo = { 5000, 4000, 3000, 2000, 1500 };
      int sum = 0;
      for( int i = 0; i < foglaltsag.length; ++i )
      {
        for( int j = 0; j < foglaltsag[i].length(); ++j )
        {
          if( foglaltsag[i].charAt( j ) == 'x' )
          {
            sum = sum + szorzo[Character.getNumericValue( kategoria[i].charAt( j ) ) - 1];
          }
        }
      }
      System.out.println( "A szinhaz bevetele a pillanatnyilag "
        + "eladott jegyek alapjan " + sum + "Ft lenne." );
 
      System.out.println( "6. feladat" );
      int solo = 0;
      for( int i = 0; i < foglaltsag.length; ++i )
      {
        if( foglaltsag[i].startsWith( "ox" ) )
        {
          solo++;
        }
        if( foglaltsag[i].endsWith( "xo" ) )
        {
          solo++;
        }
        for( int j = 0; j < foglaltsag[i].length() - 2; ++j )
        {
          if( foglaltsag[i].substring( j, j + 3 ).equals( "xox" ) )
          {
            solo++;
          }
        }
      }
      System.out.println( "A nezoteren " + solo + " db egyedulallo ures hely van." );
      System.out.println( "7. feladat" );
      StringBuilder ujSor = new StringBuilder();
      RandomAccessFile ki = new RandomAccessFile( "C:\\TELEPITOK\\szabad2.txt", "rw" );
      ki.setLength( 0 );
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

