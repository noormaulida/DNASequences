/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dnasequence;

import java.util.Stack;

/**
 *
 * @author NOOR-MAULIDA
 */
public class Problem {
    private int[][] map=null;
    private String [][] arah=null;
    private int nilaiMaks[]=null;
    private int MAXSIZE_S=0;
    private int MAXSIZE_T=0;
    private int INF=-20000;
    private char S[]=null;
    private int countS=1;
    private char T[]=null;
    private int count = 0;
    private boolean cekCopy=false;
    private boolean cekReplace=false;
    private Stack stack;


    public Problem(String s, String t) {
        S = new char[s.length()+1];
        T = new char[t.length()+1];
        MAXSIZE_S=s.length()+1;
        MAXSIZE_T=t.length()+1;
        stack = new Stack();
        //System.out.println("String s(0): " + s.charAt(0));
        //S[0] = 0;
        for(int i=1; i<MAXSIZE_S; i++) {//MAXSIZE_S+1; i++) {
            S[i] = s.charAt(i-1);
        }

        for(int i=1; i<MAXSIZE_T; i++) {//MAXSIZE_S-1; i++) {
            T[i] = t.charAt(i-1);
        }

        map=new int[MAXSIZE_S][MAXSIZE_T];
        arah=new String[MAXSIZE_S][MAXSIZE_T];

        //System.out.println("maxsize_s " + MAXSIZE_S);
        //System.out.println("maxsize_t " + MAXSIZE_T);
        for(int i=0; i<=(MAXSIZE_S-1); i++) {
            for(int j=0; j<=(MAXSIZE_T-1); j++) {
                map[i][j] = 0;
            }
        }
    }

   public void set() {

       for(int i=0; i<MAXSIZE_S; i++) {
            for(int j=0; j<MAXSIZE_T; j++) {
                map[i][j] = setProblem(i,j);
            }
        }
    }

    public int setProblem(int i, int j) {

        if(i==0 && j==0) {
            arah[i][j] = "First";
            return 0;
        }
        else if(i == 0) {
            arah[i][j] = "Insert ";
            return -2*j;
        }

        else if(j == 0) {
            arah[i][j] = "Delete ";
            return -2*i;
        }

        else {
           int maks=0;
            if(S[i] == T[j]) {
                cekCopy=true;
            }
            if(S[i] != T[j]) {
                //maks=map[i-1][j-1]-1;
                cekReplace=true;
            }
                return max(i, j);
        }
    }

    public void printMap() {
        for(int i=0; i< (MAXSIZE_S); i++) {
            for (int j=0; j<(MAXSIZE_T); j++) {
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println("Score Optimal :" + map[MAXSIZE_S-1][MAXSIZE_T-1]);
    }

    public int max(int i, int j) {
        if(cekCopy==true) {
            int maks = map[i-1][j-1]+1;
            String cek = "Copy   ";
            if(((map[i][j-1])-2) > maks) {
                maks = (map[i][j-1]-2);
                cek = "Insert ";
            }
            if (((map[i-1][j])-2) > maks){
                maks = (map[i-1][j]-2);
                cek = "Delete ";
            }
            cekCopy=false;
            arah[i][j]=cek;
            //System.out.println("S["+ i + "]: " + S[i] +" T[" + j + "], " + T[j] + ", cek: "+ cek + " maks: " + maks);
            return maks;
        }

        else if(cekReplace == true) {
            int maks = map[i-1][j-1]-1;
            String cek = "Replace";
            if(((map[i][j-1])-2) > maks) {
                maks = (map[i][j-1]-2);
                cek = "Insert ";
            }
            if (((map[i-1][j])-2) > maks) {
                maks = (map[i-1][j]-2);
                cek = "Delete ";
            }

            arah[i][j]=cek;
            cekReplace=false;
            //System.out.println("S["+ i + "]: " + S[i] +" T[" + j + "], " + T[j] + ", cek: "+ cek + " maks: " + maks);
            return maks;
        }
        return 0;
    }

    public void printArah() {
       System.out.println("Tabel Arah");
        for(int i=0; i<MAXSIZE_S; i++) {
            for(int j=0; j<MAXSIZE_T;j++) {
                System.out.print(arah[i][j] + " ");
            }
            System.out.println();

        }

//        printHasil(MAXSIZE_S, MAXSIZE_T);
        int i= MAXSIZE_S-1;
        int j= MAXSIZE_T-1;
        while (!arah[i][j].equals("First")) {
            if((arah[i][j].equals("Copy   ")) || (arah[i][j].equals("Replace"))) {
                stack.add(arah[i][j]);
                i--; j--;
            }
            else if(arah[i][j].equals("Insert ")) {
                stack.add(arah[i][j]);
                j--;
            }
            else if(arah[i][j].equals("Delete ")) {
                stack.add(arah[i][j]);
                i--;
            }
        }

        int count1=1;
        while(stack.isEmpty() == false) {
            System.out.println(count1 + ". " + stack.pop());
            count1++;
        }
    }


    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public String[][] getArah() {
        return arah;
    }

    public void setArah(String[][] arah) {
        this.arah = arah;
    }

    public int getMAXSIZE_S() {
        return MAXSIZE_S;
    }

    public void setMAXSIZE_S(int MAXSIZE_S) {
        this.MAXSIZE_S = MAXSIZE_S;
    }

    public int getMAXSIZE_T() {
        return MAXSIZE_T;
    }

    public void setMAXSIZE_T(int MAXSIZE_T) {
        this.MAXSIZE_T = MAXSIZE_T;
    }
}
