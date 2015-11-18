package com.drguildo.algs4.ch1.sec1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Exercise23 {
  public static int rank(int key, int[] a) {
    return rank(key, a, 0, a.length - 1, 0);
  }

  public static int rank(int key, int[] a, int lo, int hi, int depth) {
    for (int i = 0; i < depth; i++)
      StdOut.print(' ');
    StdOut.println(lo + ", " + hi);

    // Index of key in a[], if present, is not smaller than lo
    // and not larger than hi.
    if (lo > hi)
      return -1;
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid])
      return rank(key, a, lo, mid - 1, depth + 1);
    else if (key > a[mid])
      return rank(key, a, mid + 1, hi, depth + 1);
    else
      return mid;
  }

  public static void main(String[] args) {
    int[] whitelist = new In(args[0]).readAllInts();

    Arrays.sort(whitelist);

    // read key; print if not in whitelist
    In keyFile = new In(args[1]);
    while (!keyFile.isEmpty()) {
      int key = keyFile.readInt();
      if (args.length > 2 && args[2].equals("-") && rank(key, whitelist) != -1)
        StdOut.println(key);
      else if (rank(key, whitelist) == -1)
        StdOut.println(key);
    }
  }
}
