/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progmasters001;

import java.util.Scanner;
public class ProgMasters001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     String myString = scanner.nextLine();
     int myInt = scanner.nextInt();
     double myDouble = scanner.nextDouble();
     scanner.close();

     System.out.println("myString is: " + myString);
     System.out.println("myDouble is: " + myDouble);
     System.out.println("myInt is: " + myInt);
     
    }
    
}
