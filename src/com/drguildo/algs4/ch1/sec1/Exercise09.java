package com.drguildo.algs4.ch1.sec1;

public class Exercise09 {
  public static void main(String[] args) {
    for (int i = 0; i <= 512; i++)
      System.out.println(i + ": " + toBinaryString(i));
  }

  public static String toBinaryString(int N) {
    String s = "";

    while (N > 0) {
      s = N % 2 + s;
      N = N / 2;
    }

    return s;
  }
}
