package com.drguildo.algs4.ch1.sec1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise07 {
  public static void main(String[] args) {
    fragmentOne();

    fragmentTwo();

    fragmentThree();
  }

  public static void fragmentThree() {
    // c.
    // 1 + 2 + 4 + 8 + 16 + ... + 512
    // I'm guessing "N" should be "i".
    int sum = 0;
    for (int i = 1; i < 1000; i *= 2) {
      StdOut.print(i + " ");
      for (int j = 0; j < i; j++)
        sum++;
    }
    StdOut.println();
    StdOut.println("Output: " + sum);
  }

  public static void fragmentTwo() {
    // b.
    // The sum of all the integers from 1 to 999 inclusive.
    // (999+1) * (999 / 2)
    int sum = 0;
    for (int i = 1; i < 1000; i++) {
      StdOut.print(i + " ");
      for (int j = 0; j < i; j++)
        sum++;
    }
    StdOut.println();
    StdOut.println("Output: " + sum);
  }

  public static void fragmentOne() {
    // a.
    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001) {
      StdOut.printf("%.5f ", t);
      t = (9.0 / t + t) / 2.0;
    }
    StdOut.printf("\nOutput: %.5f\n", t);
  }
}
