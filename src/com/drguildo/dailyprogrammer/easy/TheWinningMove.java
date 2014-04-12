package com.drguildo.dailyprogrammer.easy;

import java.util.Scanner;

/**
 * The world championship in Tic Tac Toe, The X-Games is underway. We have been
 * asked to write a program to see if there is a winning move possible. This
 * tool will be used by live commentators to use in their play by play.
 * 
 * URL: http://www.reddit.com/r/dailyprogrammer/comments/22fgs1/472014_challenge_157_easy_the_winning_move_xgames/
 */
public class TheWinningMove {
  private static String player;
  private static String[][] board;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    board = new String[3][3];

    player = scanner.nextLine();

    for (int i = 0; i < 3; i++)
      board[i] = scanner.nextLine().split("");

    scanner.close();

    for (int i = 0; i < 3; i++) {
      // check each row for a winning move
      if (win_state(new String[] { board[i][0], board[i][1], board[i][2] })) {
        System.out.println("row " + i + " matches");
        for (int j = 0; j < 3; j++)
          if (board[i][j].equals("-")) {
            board[i][j] = player;
            print_board();
          }
      }

      // check each column for a winning move
      if (win_state(new String[] { board[0][i], board[1][i], board[2][i] })) {
        System.out.println("column " + i + " matches");
        for (int j = 0; j < 3; j++)
          if (board[j][i].equals("-")) {
            board[j][i] = player;
            print_board();
          }
      }
    }

    // check each diagonal for a winning move
    if (win_state(new String[] { board[0][0], board[1][1], board[2][2] }))
      for (int i = 0; i < 3; i++)
        if (board[i][i].equals("-")) {
          board[i][i] = player;
          print_board();
        }

    if (win_state(new String[] { board[0][2], board[1][1], board[2][0] }))
      for (int i = 0; i < 3; i++)
        if (board[i][2 - i].equals("-")) {
          board[i][2 - i] = player;
          print_board();
        }

    System.out.println("No Winning Move!");

    System.exit(0);
  }

  private static boolean win_state(String[] row) {
    int playercount = 0;
    int emptycount = 0;

    for (String s : row) {
      if (s.equals(player))
        playercount++;
      if (s.equals("-"))
        emptycount++;
    }

    return playercount == 2 && emptycount == 1;
  }

  private static void print_board() {
    for (int i = 0; i < board[0].length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }

    System.exit(0);
  }
}
