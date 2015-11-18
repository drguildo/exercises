package com.drguildo.algs4.ch1.sec1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise06 {
  /**
   * Prints the first 15 numbers in the Fibonacci sequence.
   */
  public static void main(String[] args) {
    int f = 0;
    int g = 1;
    for (int i = 0; i <= 15; i++) {
      StdOut.println(f);
      f = f + g;
      g = f - g;
    }
  }
}
