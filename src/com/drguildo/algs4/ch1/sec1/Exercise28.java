package com.drguildo.algs4.ch1.sec1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Exercise28 {
  // precondition: array a[] is sorted
  public static int rank(int key, int[] a) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid])
        hi = mid - 1;
      else if (key > a[mid])
        lo = mid + 1;
      else
        return mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] whitelist = new In(args[0]).readAllInts();

    Arrays.sort(whitelist);
    whitelist = com.drguildo.stdlib.Arrays.unique(whitelist);

    // read key; print if not in whitelist
    In keyFile = new In(args[1]);
    while (!keyFile.isEmpty()) {
      int key = keyFile.readInt();
      if (rank(key, whitelist) == -1)
        StdOut.println(key);
    }
  }
}
