package hotel; // Csomag név 
import java.io.*; // 10 modul
import java.util.ArrayList; // Arraylrst modul public eláss Beolvas {
public static void main(String[] args) { // Főfüggvény 
RandomAccessFile raf; // Fiié típus
ArrayList<Hotel> forgalom = new ArrayList<Hotel>(); // HOTEL tip 
try // Próbálja meg a fájlt beolvasni 
{
raf = new RandomAccessFile("C://forras//pitypang.txt","r"); //
do // Csináld amíg a feltétel igaz - hátultesztelős ciklus
{ forgalom.add(new Hotel(raf.readLine().split(" "))); }
// Soronként beolvassuk szóközönként szétdarabolva és betéve a 
while (raf.readLine()	!= null); // Amíg nem találunk üres sort
raf.close(); // Fájl bezárása 
catch (Exception e) { // Hiba esetén itt megy tovább
System.err.println("Fájlbeolvasási hiba " + e.getMessage());
}
for (Hotel foglalások : forgalom) // A forgalom tömblista kiírás 
System.out.println(foglalások) ;
}
}
