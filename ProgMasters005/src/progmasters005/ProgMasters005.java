/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progmasters005;

import java.util.Scanner;
public class ProgMasters005 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String myString = scanner.nextLine();
       int start = scanner.nextInt();
       int end = scanner.nextInt();
       String newString=myString.substring(start, end-1);
       System.out.println(newString);
}
