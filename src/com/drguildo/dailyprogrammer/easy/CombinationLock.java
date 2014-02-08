package com.drguildo.dailyprogrammer.easy;

import java.util.Scanner;

// http://www.reddit.com/r/dailyprogrammer/comments/1v4cjd/011314_challenge_148_easy_combination_lock/
public class CombinationLock {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();

    scanner.close();

    System.out.println(3 * n + a + b + c);
    System.out.println(((n * 2) + a) + (n + b) + c);
  }
}
