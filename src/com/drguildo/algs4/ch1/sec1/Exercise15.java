package com.drguildo.algs4.ch1.sec1;

import java.util.Arrays;

import com.drguildo.stdlib.Random;

public class Exercise15 {
  public static void main(String[] args) {
    Random rand = new Random();
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
