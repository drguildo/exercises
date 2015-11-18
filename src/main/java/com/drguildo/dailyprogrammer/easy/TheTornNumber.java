package com.drguildo.dailyprogrammer.easy;

public class TheTornNumber {
  public static void main(String[] args) {
    int firstHalf, secondHalf, joined;
    for (int i = 0; i <= 9; i++)
      for (int j = 0; j <= 9; j++)
        for (int k = 0; k <= 9; k++)
          for (int l = 0; l <= 9; l++) {
            if (unique(i, j, k, l)) {
              firstHalf = i * 10 + j;
              secondHalf = k * 10 + l;
              joined = firstHalf * 100 + secondHalf;
              if (Math.pow(firstHalf + secondHalf, 2) == joined)
                System.out.println(String.format("(%d + %d)^2 = %d", firstHalf,
                    secondHalf, joined));
            }
          }
  }

  private static boolean unique(int a, int b, int c, int d) {
    int[] is = new int[] { a, b, c, d };

    for (int i = 0; i < is.length; i++)
      for (int j = i + 1; j < is.length; j++)
        if (is[i] == is[j])
          return false;

    return true;
  }
}
