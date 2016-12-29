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

    public static boolean checkWinX(String board[][]) {
        if (board[0][0].equalsIgnoreCase("x") && board[0][1].equalsIgnoreCase("x") && board[0][2].equalsIgnoreCase("x") || board[1][0].equalsIgnoreCase("x") && board[1][1].equalsIgnoreCase("X") && board[1][2].equalsIgnoreCase("x") || board[2][0].equalsIgnoreCase("x") && board[2][1].equalsIgnoreCase("x") && board[2][2].equalsIgnoreCase("x")
                || board[0][0].equalsIgnoreCase("x") && board[1][0].equalsIgnoreCase("x") && board[2][0].equalsIgnoreCase("x") || board[0][1].equalsIgnoreCase("x") && board[1][1].equalsIgnoreCase("x") && board[2][1].equalsIgnoreCase("x") || board[0][2].equalsIgnoreCase("X") && board[1][2].equalsIgnoreCase("x") && board[2][2].equalsIgnoreCase("x") ||
                board[0][0].equalsIgnoreCase("x") && board[1][1].equalsIgnoreCase("x") && board[2][2].equalsIgnoreCase("x") || board[0][2].equalsIgnoreCase("x") && board[1][1].equalsIgnoreCase("x") && board[2][0].equalsIgnoreCase("x")) {
            System.out.println("Player X won!");
            return true;

        }
        return false;
    }

    public static boolean checkWinO(String board[][]) {
        if (board[0][0].equalsIgnoreCase("o") && board[0][1].equalsIgnoreCase("o") && board[0][2].equalsIgnoreCase("o") || board[1][0].equalsIgnoreCase("o") && board[1][1].equalsIgnoreCase("o") && board[1][2].equalsIgnoreCase("o") || board[2][0].equalsIgnoreCase("o") && board[2][1].equalsIgnoreCase("o") && board[2][2].equalsIgnoreCase("o")
                || board[0][0].equalsIgnoreCase("o") && board[1][0].equalsIgnoreCase("o") && board[2][0].equalsIgnoreCase("o") || board[0][1].equalsIgnoreCase("o") && board[1][1].equalsIgnoreCase("o") && board[2][1].equalsIgnoreCase("o") || board[0][2].equalsIgnoreCase("o") && board[1][2].equalsIgnoreCase("o") && board[2][2].equalsIgnoreCase("o") ||
                board[0][0].equalsIgnoreCase("o") && board[1][1].equalsIgnoreCase("o") && board[2][2].equalsIgnoreCase("o") || board[0][2].equalsIgnoreCase("o") && board[1][1].equalsIgnoreCase("o") && board[2][0].equalsIgnoreCase("o")) {
            System.out.println("Player O won!");
            return true;

        }
        return false;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int xcount = 0;
        int Ocount = 0;
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
            printBoard(board);
            for (int q = 0; q < 8; q++) {
                System.out.println("Enter the first number of the order pair you want to move in");
                int pos = input.nextInt();
                System.out.println("Enter the second number of the order pair you want to move in");
                int pos2 = input.nextInt();
                if (!placement(board, pos, pos2)) {
                    System.out.println("INVALID MOVE, Please pick again");
                    System.out.println("Enter the first number of the order pair you want to move in");
                    pos = input.nextInt();
                    System.out.println("Enter the second number of the order pair you want to move in");
                    pos2 = input.nextInt();
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (pos == i && pos2 == j) {
                                board[i][j] = "X";
                                checkWinX(board);
                                xcount++;
                            }
                        }
                    }
                    System.out.println();
                }
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (pos == i && pos2 == j) {
                            board[i][j] = "X";
                            checkWinX(board);
                            xcount++;
                        }
                    }
                }
                System.out.println();
                Random ran = new Random();
                int x = ran.nextInt(3);
                int y = ran.nextInt(3);
                if (!placement(board, x, y)) {
                    x = ran.nextInt(3);
                    y = ran.nextInt(3);
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (x == i && y == j) {
                                board[i][j] = "O";
                                printBoard(board);
                                checkWinX(board);
                                System.out.println("Computer moved into position (" + x + "," + y + ")");
                                Ocount++;
                            }
                        }
                    }
                    System.out.println();
                }
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (x == i && y == j) {
                            board[i][j] = "O";
                            printBoard(board);
                            System.out.println("Computer moved into position (" + x + "," + y + ")");
                            Ocount++;

                        }
                    }
                }
                if (xcount == 5 && Ocount == 4 || Ocount == 5 && xcount == 4 && !checkWinO(board) && !checkWinX(board)) {
                    System.out.println("It's a tie!");
                    break;
                }
               else if (checkWinX(board)) {
                    break;
                } else if (checkWinO(board)) {
                    System.out.println("You literally just got beat by the crapiest AI ever");
                    break;
                }

            }
        } else if (ans.equalsIgnoreCase("o")) {
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
            printBoard(board);
            for (int q = 0; q < 8; q++) {
                System.out.println("Enter the first number of the order pair you want to move in");
                int pos = input.nextInt();
                System.out.println("Enter the second number of the order pair you want to move in");
                int pos2 = input.nextInt();
                if (!placement(board, pos, pos2)) {
                    System.out.println("INVALID MOVE, Please pick again");
                    System.out.println("Enter the first number of the order pair you want to move in");
                    pos = input.nextInt();
                    System.out.println("Enter the second number of the order pair you want to move in");
                    pos2 = input.nextInt();
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (pos == i && pos2 == j) {
                                board[i][j] = "O";
                                checkWinX(board);
                                Ocount++;
                            }
                        }
                    }
                    System.out.println();
                }
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (pos == i && pos2 == j) {
                            board[i][j] = "O";
                            checkWinX(board);
                            Ocount++;
                        }
                    }
                }
                System.out.println();
                Random ran = new Random();
                int x = ran.nextInt(3);
                int y = ran.nextInt(3);
                if (!placement(board, x, y)) {
                    x = ran.nextInt(3);
                    y = ran.nextInt(3);
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (x == i && y == j) {
                                board[i][j] = "X";
                                printBoard(board);
                                checkWinX(board);
                                System.out.println("Computer moved into position (" + x + "," + y + ")");
                                xcount++;
                            }
                        }
                    }
                    System.out.println();
                }
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (x == i && y == j) {
                            board[i][j] = "X";
                            printBoard(board);
                            System.out.println("Computer moved into position (" + x + "," + y + ")");
                            xcount++;

                        }
                    }
                }
                if (xcount == 5 && Ocount == 4 || Ocount == 5 && xcount == 4 && !checkWinO(board) && !checkWinX(board)) {
                    System.out.println("It's a tie!");
                    break;
                } else if (checkWinO(board)) {
                    break;
                } else if (checkWinX(board)) {
                    System.out.println("You literally just got beat by the crapiest AI ever");
                    break;
                }

            }


        }
    }
}


