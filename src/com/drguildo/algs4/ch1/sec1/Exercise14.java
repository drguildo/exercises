package com.drguildo.algs4.ch1.sec1;

import edu.princeton.cs.algs4.Stopwatch;

public class Exercise14 {
  public static void main(String[] args) {
    System.out.println("2^0 = " + pow2(0));
    System.out.println("2^1 = " + pow2(1));
    System.out.println("2^2 = " + pow2(2));
    System.out.println("2^8 = " + pow2(8));

    System.out.println("lg(1) = " + lg(1));
    System.out.println("lg(2) = " + lg(2));
    System.out.println("lg(4) = " + lg(4));
    System.out.println("lg(256) = " + lg(256));
    
    Stopwatch sw = new Stopwatch();
    System.out.println(lg(1 << 30));
    System.out.println(sw.elapsedTime());
  }

  public static int lg(int N) {
    int exp = 0;

    while (pow2(exp) <= N)
      exp++;

    return exp > 1 ? exp - 1 : 1;
  }

  public static long pow2(int n) {
    long x = 2;

    if (n == 0)
      return 1;

    while (n > 1) {
      x = x * 2;
      n--;
    }

    return x;
  }
}
