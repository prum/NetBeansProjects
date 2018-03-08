/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progmasters006;

import java.util.Scanner;
import java.lang.*;
import java.io.*;
/**
 *
 * @author info
 */
public class ProgMasters006 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String myString = scanner.nextLine();
       String newString="";
       int hossz=myString.length();
        char [] a = myString.toCharArray();
        char [] b = new char[hossz];
        int j=0;
        for (int i = hossz-1; i>=0; i--,j++)
        {
            b[j]=a[i];
        }
        for (int i = 0; i<hossz; i++)
        {
          newString=newString+b[i];   
        }
        //System.out.println(newString);
        if (newString.equals(myString))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    
}
