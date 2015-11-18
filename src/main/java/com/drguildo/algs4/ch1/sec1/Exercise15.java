package com.drguildo.algs4.ch1.sec1;

import io.sjm.stdlib.Rand;

import java.util.Arrays;

public class Exercise15 {
  public static void main(String[] args) {
    Rand rand = new Rand();
    int[] a = rand.randArrayInt(100, 100);

    System.out.println(Arrays.toString(histogram(a, 100)));
  }

  public static int[] histogram(int[] a, int M) {
    int[] b = new int[M];

    for (int i = 0; i < a.length; i++)
      if (a[i] < b.length)
        b[a[i]]++;

    return b;
  }
}
