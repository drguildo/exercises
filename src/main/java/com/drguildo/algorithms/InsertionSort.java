package com.drguildo.algorithms;

/**
 * An implementation of insertion sort that operates on an array of integers.
 * 
 * @author Simon Morgan <sjm@sjm.io>
 * 
 */
public class InsertionSort {
  /**
   * Sorts an array of integers and returns the sorted array.
   * 
   * Insertion sort works by taking a section of a list, initially consisting of
   * a single element, and iterating through the remaining elements and
   * inserting them into that section in the correct (i.e. sorted) location.
   * 
   * @param a
   *          an array of integers to be sorted
   * @return a sorted array of integers
   */
  public static int[] sort(int[] a) {
    int key;

    for (int i = 1; i < a.length; i++) {
      key = a[i];
      int j = i - 1;
      while (j >= 0 && key < a[j]) {
        a[j + 1] = a[j];
        j--;
      }
      a[j + 1] = key;
    }

    return a;
  }
}
