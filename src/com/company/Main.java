package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void printBoard(String[][] board) {

        System.out.print(board[0][0] + " | ");
        System.out.print(board[0][1] + " | ");
        System.out.println(board[0][2] + " | ");
        System.out.print(board[1][0] + " | ");
        System.out.print(board[1][1] + " | ");
        System.out.println(board[1][2] + " | ");
        System.out.print(board[2][0] + " | ");
        System.out.print(board[2][1] + " | ");
        System.out.print(board[2][2] + " |  ");
        System.out.println();
    }

    public static boolean placement(String[][] board, int row, int col) {
        if (board[row][col].equals("X") || board[row][col].equals("O")) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        String board[][] = new String[3][3];
        System.out.println("Welcome to tic-tac-toe...do you want to be X or O");
        String ans = input.next();
        if (ans.equalsIgnoreCase("x")) {
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    board[0][0] = "0,0";
                    board[0][1] = "0,1";
                    board[0][2] = "0,2";
                    board[1][0] = "1,0";
                    board[1][1] = "1,1";
                    board[1][2] = "1,2";
                    board[2][0] = "2,0";
                    board[2][1] = "2,1";
                    board[2][2] = "2,2";
                }
            }
        }
        printBoard(board);
        System.out.println("Enter the first number of the order pair you want to move in");
        int pos = input.nextInt();
        System.out.println("Enter the second number of the order pair you want to move in");
        int pos2 = input.nextInt();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pos == i && pos2 == j) {
                    board[i][j] = "X";
                    printBoard(board);
                }
            }
        }
        System.out.println();
        System.out.println("Computer's first number");
        Random ran = new Random();
        int x = ran.nextInt(2);
        System.out.println(x);
        System.out.println("Computer's second number");
        int y = ran.nextInt(2) + 1;
        while (y == x) {
            y = ran.nextInt(2) + 1;
        }
        System.out.println(y);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (x == i && y == j) {
                    board[i][j] = "O";
                    printBoard(board);

                }
            }
        }
        System.out.println();
        System.out.println("Player's turn:");
        System.out.println("Enter the first number of the order pair you want to move in");
         pos = input.nextInt();
        System.out.println("Enter the second number of the order pair you want to move in");
         pos2 = input.nextInt();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pos == i && pos2 == j) {
                    board[i][j] = "X";
                    printBoard(board);
                }
            }
        }


    }

}

