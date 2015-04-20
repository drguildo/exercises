package com.drguildo.algs4.ch1.sec1;

import io.sjm.stdlib.Arrays;

public class Matrix {
  // vector dot product
  static double dot(double[] x, double[] y) {
    double sum = 0.0;

    for (int i = 0; i < x.length; i++)
      sum += x[i] * y[i];

    return sum;
  }

  // vector-matrix product
  static double[] mult(double[] y, double[][] a) {
    double[] prod = new double[a.length];

    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < a[i].length; j++)
        prod[i] += y[i] * a[i][j];

    return prod;
  }

  // matrix-vector product
  static double[] mult(double[][] a, double[] x) {
    double[] prod = new double[a.length];

    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < a[i].length; j++)
        prod[i] += x[i] * a[i][j];

    return prod;
  }

  // matrix-matrix product
  static double[][] mult(double[][] a, double[][] b) {
    double[][] prod = new double[a.length][a[0].length];

    for (int i = 0; i < prod.length; i++) {
      for (int j = 0; j < prod[i].length; j++) {
        prod[i][j] = a[i][j] * b[j][i];
      }
    }

    return prod;
  }

  // transpose
  static double[][] transpose(double[][] a) {
    double[][] trans = new double[a[0].length][a.length];

    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < a[i].length; j++)
        trans[j][i] = a[i][j];

    return trans;
  }

  public static void main(String[] args) {
    double[] a = { 0.0, 1.0, 2.0, 3.0, 4.0 };
    double[] b = { 4.0, 3.0, 2.0, 1.0, 0.0 };
    double[][] c = { { 1.0, 2.0 }, { 1.0, 2.0 }, { 1.0, 2.0 } };
    double[][] d = { { 1.0, 2.0, 3.0 }, { 1.0, 2.0, 3.0 } };
    double[][] e = { { 1.0, 2.0 }, { 3.0, 4.0 }, { 5.0, 6.0 } };

    System.out.println(dot(a, b));
    System.out.println(Arrays.toString(mult(c, d)));
    System.out.println(java.util.Arrays.toString(mult(new double[] { 1.0, 1.0,
                                                                    1.0 }, d)));
    System.out.println(java.util.Arrays.toString(mult(d,
        new double[] { 1.0, 1.0, 1.0 })));
    System.out.println(Arrays.toString(transpose(e)));
  }
}
