package com.drguildo.algs4.ch1.sec1;

public class Exercise29 {
  public static int rank(int key, int[] a) {
    int count = 0;

    for (int n : a)
      if (n < key)
        count++;

    return count;
  }

  public static int count(int key, int[] a) {
    int count = 0;

    for (int n : a)
      if (n == key)
        count++;

    return count;
  }
}
