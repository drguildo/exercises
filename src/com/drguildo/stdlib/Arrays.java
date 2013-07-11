package com.drguildo.stdlib;

import java.util.LinkedHashSet;
import java.util.Set;

public class Arrays {
  public static int[] unique(int[] a) {
    Set<Integer> tmp = new LinkedHashSet<Integer>();
    for (Integer n : a) {
      tmp.add(n);
    }

    int[] output = new int[tmp.size()];
    int i = 0;
    for (Integer n : tmp) {
      output[i++] = n;
    }

    return output;
  }

  public static <T> String toString(T[][] a) {
    StringBuilder sb = new StringBuilder();

    sb.append("[");
    for (int i = 0; i < a.length; i++) {
      sb.append("[");
      for (int j = 0; j < a[i].length; j++) {
        sb.append(a[i][j]);
        if (j != a[i].length - 1)
          sb.append(", ");
      }
      sb.append("]");
      if (i != a.length - 1)
        sb.append(", ");
    }
    sb.append("]");

    return sb.toString();
  }

  public static String toString(int[][] a) {
    StringBuilder sb = new StringBuilder();

    sb.append("[");
    for (int i = 0; i < a.length; i++) {
      sb.append("[");
      for (int j = 0; j < a[i].length; j++) {
        sb.append(a[i][j]);
        if (j != a[i].length - 1)
          sb.append(", ");
      }
      sb.append("]");
      if (i != a.length - 1)
        sb.append(", ");
    }
    sb.append("]");

    return sb.toString();
  }

  public static String toString(double[][] a) {
    StringBuilder sb = new StringBuilder();

    sb.append("[");
    for (int i = 0; i < a.length; i++) {
      sb.append("[");
      for (int j = 0; j < a[i].length; j++) {
        sb.append(a[i][j]);
        if (j != a[i].length - 1)
          sb.append(", ");
      }
      sb.append("]");
      if (i != a.length - 1)
        sb.append(", ");
    }
    sb.append("]");

    return sb.toString();
  }

  public static String toString(boolean[][] a) {
    StringBuilder sb = new StringBuilder();

    sb.append("[");
    for (int i = 0; i < a.length; i++) {
      sb.append("[");
      for (int j = 0; j < a[i].length; j++) {
        sb.append(a[i][j]);
        if (j != a[i].length - 1)
          sb.append(", ");
      }
      sb.append("]");
      if (i != a.length - 1)
        sb.append(", ");
    }
    sb.append("]");

    return sb.toString();
  }

  /**
   * Finds the largest value in an array of doubles.
   * 
   * @param a
   *          the array of doubles
   * @return the largest value in the array
   */
  public static double max(double[] a) {
    if (a.length == 0)
      throw new java.lang.IllegalArgumentException("array is empty");

    double m = a[0];

    if (a.length > 1)
      for (int i = 1; i < a.length; i++)
        if (a[i] > m)
          m = a[i];

    return m;
  }

  /**
   * Finds the largest value in an array of integers.
   * 
   * @param a
   *          the array of integers
   * @return the largest value in the array
   */
  public static int max(int[] a) {
    if (a.length == 0)
      throw new java.lang.IllegalArgumentException("array is empty");

    int m = a[0];

    if (a.length > 1)
      for (int i = 1; i < a.length; i++)
        if (a[i] > m)
          m = a[i];

    return m;
  }

  public static void main(String[] args) {
    System.out.println(toString(new String[][] { { "" } }));
  }
}
