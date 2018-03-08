
package mozi;
import java.util.Scanner;

public class Penztar {
    //1.Alakitsa át a programot tömblista használatára
    //2.Akkor álljon le a program, ha az összess film összes jegye elkelt.(ha valamelyik film betelt, ne kinálja fel)
    //3.Ha 2 jegyet kérnek, próbáljon meg egymás melletti helyeket biztositani
    //4.A térkép alapuljon egy logikai mátrixon
public static void main (String[]args){
    Film[] mozifilm;
    mozifilm=new Film[3];
    mozifilm[0]=new Film("Helloka1",1230,10,10,120);
    mozifilm[1]=new Film("Helloka2",1230,10,5,120);
    mozifilm[2]=new Film("Helloka3",1230,4,10,120);
int tip, soo,oss;
int i,j;
do{
    Scanner sctip=new Scanner(System.in);
    System.out.println("Melyik filmet választja?");
    for (i=0;i<3;i++)
        System.out.println((i+1)+":"+mozifilm[i]);
        tip=sctip.nextInt();
        Scanner sc=new Scanner(System.in);
        System.out.println("Mennyi jegyet kér?");
        int fiz=mozifilm[tip-1].vesz(sc.nextInt());
        int db=fiz/mozifilm[tip-1].getJegyar();
        if(fiz!=-1)
        {
            System.out.println(fiz+" Ft-ot kell fizetnie!"); 
            System.out.println("A következő jegyeket kapja: ");
            for (i=0;i<db;i++){
                do {
                    //Addig sorsol szék kordinátákat, amíg ürest nem talál.
                    soo=(int)Math.round(Math.random()*(mozifilm[tip-1].getSor()-1));
                    oss=(int)Math.round(Math.random()*(mozifilm[tip-1].getOszlop()-1));
                }
                while(mozifilm[tip-1].helyvizsgal(soo, oss));
                mozifilm[tip-1].helybefoglal(soo, oss);
                System.out.println("S: "+soo+" Os: "+oss);
            }
        }    
        else
                System.out.println("Nincs már annyi hely!\n");
            System.out.println("FOGALÁSI TÉRKÉP");
            for(i=0;i<mozifilm[tip-1].getSor();i++)
            {
                for (j=0;j<mozifilm[tip-1].getOszlop();j++)
                    if(mozifilm[tip-1].helyvizsgal(i,j))
                        System.out.print("x ");
                    else
                        System.out.print("_ ");
                System.out.print("\n");
            }
}while(mozifilm[tip-1].getMaradek()>0);

            }
        }
        