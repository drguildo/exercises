package com.drguildo.algs4.ch1.sec1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

public class BruteForceSearch {
  public static int binsearch(int key, int[] a) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
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

  public static int brutesearch(int key, int[] a) {
    for (int i = 0; i < a.length; i++)
      if (a[i] == key)
        return i;
    return -1;
  }

  public static void main(String[] args) {
    int[] largew = new In("data/algs4/largeW.txt").readAllInts();
    int[] larget = new In("data/algs4/largeT.txt").readAllInts();

    Arrays.sort(largew);

    Stopwatch sw;

    sw = new Stopwatch();
    for (int key : larget)
      binsearch(key, largew);
    System.out.println("Binary Search: " + sw.elapsedTime());

    sw = new Stopwatch();
    for (int key : larget)
      brutesearch(key, largew);
    System.out.println("Brute Force Search: " + sw.elapsedTime());
  }
}
