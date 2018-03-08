/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progmasters002;

import java.util.Scanner;
public class ProgMasters002 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int myInt = scanner.nextInt();
        if (myInt%2==1)
            System.out.println("Weird");
        else
        {
            if (myInt>=2 && myInt<=5)
            System.out.println("Not Weird");
            else
                if (myInt>=6 && myInt<=20)
                    System.out.println("Weird");
            else
                 if (myInt>20)
                     System.out.println("Not Weird");
        }           
        // If n is odd, print 'Weird'.
        //If n is even and in the inclusive range of 2 to 5, print 'Not Weird'.
        //If n is even and in the inclusive range of 6 to 20, print 'Weird'.
        //If n is even and greater than 20, print 'Not Weird'.
        //Complete the stub code provided in your editor to print whether or not n is weird.

        //Input Format
        //A single line containing a positive integer, n.

        //Constraints
        //1 <= n <= 100

        //Output Format
        //Print 'Weird' if the number is weird; otherwise, print 'Not Weird'.TODO code application logic here
    
    }
    
}
