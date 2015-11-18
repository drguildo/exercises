package com.drguildo.algs4.ch1.sec3;

import edu.princeton.cs.algs4.Stack;

public class Exercise3 {
  private static int pos;
  private static Stack<Integer> s;

  public static void main(String[] args) {
    // a. 4 3 2 1 0 9 8 7 6 5
    reset();
    System.out.print("a. ");
    pushPop(5, 5);
    pushPop(5, 5);
    System.out.println(" ✓");

    // b. 4 6 8 7 5 3 2 9 0 1
    reset();
    System.out.print("b. ");
    pushPop(5, 1);
    pushPop(2, 1);
    pushPop(2, 5);
    pushPop(1, 3);
    System.out.println(" ✗");

    // c. 2 5 6 7 4 8 9 3 1 0
    reset();
    System.out.print("c. ");
    pushPop(3, 1);
    pushPop(3, 1);
    pushPop(1, 1);
    pushPop(1, 2);
    pushPop(1, 1);
    pushPop(1, 4);
    System.out.println(" ✓");

    // d. 4 3 2 1 0 5 6 7 8 9
    reset();
    System.out.print("d. ");
    pushPop(5, 5);
    pushPop(1, 1);
    pushPop(1, 1);
    pushPop(1, 1);
    pushPop(1, 1);
    pushPop(1, 1);
    System.out.println(" ✓");

    // e. 1 2 3 4 5 6 9 8 7 0
    reset();
    System.out.print("e. ");
    pushPop(2, 1);
    pushPop(1, 1);
    pushPop(1, 1);
    pushPop(1, 1);
    pushPop(1, 1);
    pushPop(1, 1);
    pushPop(3, 4);
    System.out.println(" ✓");

    // f. 0 4 6 5 3 8 1 7 2 9
    reset();
    System.out.print("f. ");
    pushPop(1, 1);
    pushPop(4, 1);
    pushPop(2, 3);
    pushPop(2, 4);
    pushPop(1, 1);
    System.out.println(" ✗");

    // g. 1 4 7 9 8 6 5 3 0 2
    reset();
    System.out.print("g. ");
    pushPop(2, 1);
    pushPop(3, 1);
    pushPop(3, 1);
    pushPop(2, 7);
    System.out.println(" ✗");

    // h. 2 1 4 3 6 5 8 7 9 0
    reset();
    System.out.print("h. ");
    pushPop(3, 2);
    pushPop(2, 2);
    pushPop(2, 2);
    pushPop(2, 2);
    pushPop(1, 2);
    System.out.println(" ✓");
  }

  private static void pushPop(int m, int n) {
    for (int i = pos; i < pos + m; i++) {
      s.push(i);
    }

    pos = pos + m;

    for (int i = 0; i < n; i++)
      System.out.print(s.pop() + " ");
  }

  private static void reset() {
    pos = 0;
    s = new Stack<>();
  }
}
