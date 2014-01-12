package com.drguildo.dailyprogrammer.easy;

import java.util.Scanner;

/**
 * Your goal is to draw a tree given the base-width of the tree (the number of
 * characters on the bottom-most row of the triangle section). This "tree" must
 * be drawn through ASCII art-style graphics[2] on standard console output. It
 * will consist of a 1x3 trunk on the bottom, and a triangle shape on the top.
 * The tree must be centred, with the leaves growing from a base of
 * N-characters, up to a top-layer of 1 character. Each layer reduces by 2
 * character, so the bottom might be 7, while shrinks to 5, 3, and 1 on top
 * layers.
 * 
 * URL: http://www.reddit.com/r/dailyprogrammer/comments/1t0r09/121613_challenge_145_easy_tree_generation/
 */
public class TreeGeneration {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int width = scanner.nextInt();
    String base = scanner.next();
    String leaves = scanner.next();

    scanner.close();

    if (width < 3 || width > 21 || (width % 2) != 1) {
      System.err.println("width must be 3 <= n <= 21 and odd");
      System.exit(-1);
    }

    int padding;
    for (int i = 1; i <= width; i += 2) {
      padding = (width - i) / 2;
      printTimes(" ", padding);
      printTimes(leaves, i);
      printTimes(" ", padding);
      System.out.println();
    }

    printTimes(" ", (width - 3) / 2);
    printTimes(base, 3);
    printTimes(" ", (width - 3) / 2);
    System.out.println();
  }

  private static void printTimes(String s, int n) {
    for (int i = 0; i < n; i++)
      System.out.print(s);
  }
}
