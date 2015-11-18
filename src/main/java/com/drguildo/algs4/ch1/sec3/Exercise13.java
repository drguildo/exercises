package com.drguildo.algs4.ch1.sec3;

import edu.princeton.cs.algs4.Queue;

public class Exercise13 {
  private static int pos;
  private static Queue<Integer> s;

  public static void main(String[] args) {
    // a. 0 1 2 3 4 5 6 7 8 9
    reset();
    System.out.print("a. ");
    for (int i = 0; i < 10; i++)
      enqDeq(1, 1);
    System.out.println(" ✓");

    // b. 4 6 8 7 5 3 2 9 0 1
    reset();
    System.out.print("b. ");
    enqDeq(5, 1);
    System.out.println(" ✗");

    // c. 2 5 6 7 4 8 9 3 1 0
    reset();
    System.out.print("c. ");
    enqDeq(3, 1);
    System.out.println(" ✗");

    // d. 4 3 2 1 0 5 6 7 8 9
    reset();
    System.out.print("d. ");
    enqDeq(5, 1);
    System.out.println(" ✗");

  }

  private static void enqDeq(int m, int n) {
    for (int i = pos; i < pos + m; i++) {
      s.enqueue(i);
    }

    pos = pos + m;

    for (int i = 0; i < n; i++)
      System.out.print(s.dequeue() + " ");
  }

  private static void reset() {
    pos = 0;
    s = new Queue<>();
  }
}
