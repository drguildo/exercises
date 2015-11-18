package com.drguildo.dailyprogrammer.easy;

import java.util.Arrays;
import java.util.Scanner;

/*
 * It can be helpful sometimes to rotate a string 90-degrees, like a big
 * vertical "SALES" poster or your business name on vertical neon lights. Your
 * goal is to write a program that does this, but for multiples lines of text.
 * This is very similar to a Matrix Transposition , since the order we want
 * returned is not a true 90-degree rotation of text.
 * 
 * URL: http://www.reddit.com/r/dailyprogrammer/comments/1m1jam/081313_challenge_137_easy_string_transposition/
 */
public class StringTransposition {
  public static void main(String[] args) {
    Scanner scanner = new Scanner("5\n" + "Kernel\n" + "Microcontroller\n"
        + "Register\n" + "Memory\n" + "Operator");

    int n = scanner.nextInt();
    scanner.nextLine();

    String[] strings = new String[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      strings[i] = scanner.nextLine();
      if (strings[i].length() > max)
        max = strings[i].length();
    }

    scanner.close();

    System.out.println(Arrays.toString(strings));

    for (int i = 0; i < max; i++) {
      for (int j = 0; j < n; j++)
        if (strings[j].length() >= i + 1)
          System.out.print(strings[j].charAt(i));
        else
          System.out.print(" ");
      System.out.println();
    }
  }
}
