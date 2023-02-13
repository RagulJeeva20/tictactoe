package org.example;



import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class Tictac {
    public static void main(String[] args)
    {


        String[][] arr=new String[3][3];

        game(arr);

    }
    static void game(String[][] arr) {
        Scanner s = new Scanner(System.in);
        PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out));

        int ind = 1;
        for (int i = 0; i < arr.length; i++) {
            ps.print("|");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf(ind);
                ps.print(arr[i][j] + " |");
                ind++;
            }
            ps.println("\n+--+--+--+");


        }
        versus(arr);
    }
        static void versus(String[][] arr)
        {
            Scanner s=new Scanner(System.in);
            PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out));

        ps.println("player 1:x");
        ps.println("player 2:o");

        int pl=1;
        int loop=1;


        HashSet<Integer> hs=new HashSet<>();
        while(loop!=0)
        {

            if (pl>9)
            {
                ps.println("The game has been drawn!");
                break;
            }
            if(pl%2==0)
            {
                ps.println("player 2 can play!");
                int num = s.nextInt();
                if (hs.contains(num))
                {
                    ps.println("This position has already taken enter different position!");
                }
                else {
                    ins(arr, num, pl);
                    loop = winner(arr);
                    hs.add(num);
                    pl++;
                }
            }
            if (pl%2!=0)
            {
                ps.println("player 1 can play!");
                int num = s.nextInt();
                if (hs.contains(num))
                {
                    ps.println("This position is already taken,so enter different position!");
                }
                else
                {
                    ins(arr, num, pl);
                    loop = winner(arr);
                    hs.add(num);
                    pl++;
                }
            }
        }

    }
    static int winner(String[][] arr)


    {
        PrintStream ps=new PrintStream(new FileOutputStream(FileDescriptor.out));

        int n=1;
        for (int i = 0; i <3 ; i++)
        {



        if ((arr[i][0].equals(arr[i][1])) && (arr[i][1].equals(arr[i][2])))
        {
            ps.println(arr[i][0] + " is winner");
            n=0;
            break;
        }
         if ((arr[0][i].equals(arr[1][i])) && (arr[1][i].equals(arr[2][i])))
            {
                ps.println(arr[0][i] + " is winner");
                n=0;

            }
        else if (((arr[0][0].equals(arr[1][1])) &&(arr[1][1].equals(arr[2][2]))) ||((arr[0][2].equals(arr[1][1])) &&(arr[1][1].equals(arr[2][0]))))
        {
            ps.println(arr [1][1] + "is winner");
            n=0;
        }
        }
    return n;
    }
    static void ins(String[][] arr,int n,int pl)
    {

        int col = (n - 1) % 3;
        int row = (n - 1) / 3;
        if (pl%2==0) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[row][col] = "0";
                }
            }
            show(arr);
        }
        if (pl%2!=0) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[row][col] = "x";
                }
            }
            show(arr);
        }
    }
    static void show(String[][] arr)
        {
            PrintStream ps=new PrintStream(new FileOutputStream(FileDescriptor.out));

            for (int i = 0; i < arr.length ; i++)
            {
                ps.print("|");
                for (int j = 0; j <arr[i].length; j++)
                {
                    ps.print( arr[i][j]+ " |");
                }
                ps.println("\n+--+--+--+");
            }
        }
    }

