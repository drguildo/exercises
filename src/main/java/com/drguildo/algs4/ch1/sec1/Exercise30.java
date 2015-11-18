package com.drguildo.algs4.ch1.sec1;

import io.sjm.stdlib.Arrays;
import io.sjm.stdlib.Maths;

public class Exercise30 {
  public static boolean[][] relativelyPrimeArray(int x, int y) {
    boolean[][] a = new boolean[x][y];

    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < a[i].length; j++)
        if (Maths.gcd(i, j) == 1)
          a[i][j] = true;
        else
          a[i][j] = false;

    return a;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(relativelyPrimeArray(4, 4)));
  }
}
