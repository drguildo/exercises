package com.drguildo.algs4.ch1.sec1;

public class Exercise13 {
  public static void main(String[] args) {
    boolean[][] a;
    a = new boolean[][] { { true, false } };
    Exercise11.printBooleanArray(a);
    Exercise11.printBooleanArray(transpose(a));

    a = new boolean[][] { { true, false, false }, { false, true, false } };
    Exercise11.printBooleanArray(a);
    Exercise11.printBooleanArray(transpose(a));
  }

  public static boolean[][] transpose(boolean[][] a) {
    boolean b[][] = new boolean[a.length][];
    int M = a.length;
    for (int i = 0; i < M; i++) {
      int N = a[(M - 1) - i].length;
      b[i] = new boolean[N];
      for (int j = 0; j < N; j++)
        b[i][j] = a[(M - 1) - i][(N - 1) - j];
    }
    return b;
  }
}
