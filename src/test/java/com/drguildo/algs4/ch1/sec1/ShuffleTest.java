package com.drguildo.algs4.ch1.sec1;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class ShuffleTest {
  public static void badshuffle(int[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      // Exchange a[i] with random element in a[0..N-1]
      int r = StdRandom.uniform(N);
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  public static void shuffle(int[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      // Exchange a[i] with random element in a[i..N-1]
      int r = i + StdRandom.uniform(N - i);
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  public static void main(String[] args) {
    if (args.length < 2)
      System.exit(-1);

    int m = Integer.parseInt(args[0]);
    int n = Integer.parseInt(args[1]);

    int[] a = new int[m];
    int[][] poscnt = new int[m][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < a.length; j++)
        a[j] = j;

      shuffle(a);
      // badshuffle(a);

      for (int j = 0; j < a.length; j++)
        poscnt[a[j]][j] += 1;
    }

    for (int i = 0; i < poscnt.length; i++) {
      System.out.println(i + ": " + Arrays.toString(poscnt[i]));
    }
  }
}
