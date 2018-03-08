/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progmasters004;

import java.util.Scanner;

public class ProgMasters004 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int myInt = scanner.nextInt();
    int[] a = new int[myInt];
    int i;
    for (i = 0; i < myInt; i++) {
        int myInt2 = scanner.nextInt();
        a[i]=myInt2;
    }
    for (i = 0; i < myInt; i++){
    System.out.println(a[i]);
    }
    }
    
}
