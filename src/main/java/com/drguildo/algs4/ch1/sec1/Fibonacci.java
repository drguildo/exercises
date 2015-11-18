package com.drguildo.algs4.ch1.sec1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Fibonacci {
  static final long[] a = new long[100];

  public static long F(int N) {
    if (N == 0)
      return 0;
    if (N == 1)
      return 1;
    return F(N - 1) + F(N - 2);
  }

  public static long F2(int N) {
    if (N > 99)
      throw new IllegalArgumentException("lolnope");
    if (N == 0)
      return 0;
    if (N == 1)
      return 1;
    if (a[N] == 0)
      a[N - 1] = F2(N - 1);
    if (a[N - 2] == 0)
      a[N - 2] = F2(N - 2);
    return a[N - 1] + a[N - 2];
  }

  public static void main(String[] args) {
    Stopwatch sw;
    for (int N = 0; N < 100; N++) {
      sw = new Stopwatch();
      StdOut.println("fast: " + N + " " + F2(N) + " " + sw.elapsedTime()
          + "sec");
      sw = new Stopwatch();
      StdOut
          .println("slow: " + N + " " + F(N) + " " + sw.elapsedTime() + "sec");
    }
  }
}
