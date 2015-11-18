package com.drguildo.algs4.ch1.sec1;

public class Exercise20 {
  public static void main(String[] args) {
    System.out.println(f(1234));
  }

  public static double f(int N) {
    if (N == 1)
      return 0.0;
    return Math.log(N) + f(N - 1);
  }
}
