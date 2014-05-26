/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dnasequence;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NOOR-MAULIDA
 */

 public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String s;
            String t;
            System.out.println("Masukkan DNA 1: ");
            s = input.readLine();
            System.out.println("Masukkan DNA 2: ");
            t = input.readLine();
            Problem newProblem = new Problem(s, t);
            newProblem.set();
            newProblem.printMap();
            newProblem.printArah();

            /**/
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}