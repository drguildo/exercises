package com.drguildo.algs4.ch1.sec1;

public class Exercise27 {
  static int[][] a = null;

  public static void main(String[] args) {
    System.out.println(binomial(100, 50, 0));
  }

  public static double binomial(int N, int k, double p) {
    if (a == null)
      a = new int[N][k];

    if ((N == 0) || (k < 0))
      return 1.0;
    return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
  }
}
