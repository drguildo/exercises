package com.drguildo.algs4.ch1.sec1;

public class Exercise11 {
  public static void main(String[] args) {
    printBooleanArray(new boolean[][] {});

    System.out.println("--");

    printBooleanArray(new boolean[][] { {}, {} });

    System.out.println("--");

    printBooleanArray(new boolean[][] { { true, false, false },
        { false, true, false }, { false, false, true } });

    System.out.println("--");

    printBooleanArray(new boolean[][] { { true, false, false },
        { false, true, false } });
  }

  public static void printBooleanArray(boolean[][] a) {
    if (a.length == 0) {
      System.out.println("No rows.");
      return;
    }

    int maxLen = 0;

    // Find the largest number of columns in the array.
    for (int i = 0; i < a.length; i++)
      if (a[i].length > maxLen)
        maxLen = a[i].length;

    if (maxLen == 0) {
      System.out.println("No columns.");
      return;
    }

    // Print the column header.
    System.out.print(" ");
    for (int i = 0; i < maxLen; i++)
      System.out.print(" " + i);
    System.out.println();

    // Print each row.
    for (int i = 0; i < a.length; i++) {
      System.out.print(i);
      for (int j = 0; j < a[i].length; j++)
        System.out.print(a[i][j] == true ? " *" : "  ");
      System.out.println();
    }
  }
}
