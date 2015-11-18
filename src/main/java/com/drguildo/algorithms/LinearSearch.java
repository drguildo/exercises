package com.drguildo.algorithms;

/**
 * @author Simon Morgan <sjm@eml.cc>
 * 
 */
public class LinearSearch {
  public static int search(int[] a, int n) {
    for (int i = 0; i < a.length; i++)
      if (n == a[i])
        return i;
    return -1;
  }
}
