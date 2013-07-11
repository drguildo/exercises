package com.drguildo.codingbat;

public class Logic2 {
  // We want to make a row of bricks that is goal inches long. We have a number
  // of small bricks (1 inch each) and big bricks (5 inches each). Return true
  // if it is possible to make the goal by choosing from the given bricks.
  public boolean makeBricks(int small, int big, int goal) {
    return (big * 5) < goal ? small >= (goal - (big * 5)) : (goal % 5) <= small;
  }

  // Given 3 int values, a b c, return their sum. However, if one of the values
  // is the same as another of the values, it does not count towards the sum.
  public int loneSum(int a, int b, int c) {
    int a2 = a == b || a == c ? 0 : a;
    int b2 = b == a || b == c ? 0 : b;
    int c2 = c == a || c == b ? 0 : c;
    return a2 + b2 + c2;
  }

  // Given 3 int values, a b c, return their sum. However, if one of the values
  // is 13 then it does not count towards the sum and values to its right do not
  // count. So for example, if b is 13, then both b and c do not count.
  public int luckySum(int a, int b, int c) {
    if (a == 13)
      return 0;
    else if (b == 13)
      return a;
    else if (c == 13)
      return a + b;
    else
      return a + b + c;
  }

  // Given 3 int values, a b c, return their sum. However, if any of the values
  // is a teen -- in the range 13..19 inclusive -- then that value counts as 0,
  // except 15 and 16 do not count as a teens. Write a separate helper
  // "public int fixTeen(int n) {"that takes in an int value and returns that
  // value fixed for the teen rule. In this way, you avoid repeating the teen
  // code 3 times (i.e. "decomposition"). Define the helper below and at the
  // same indent level as the main noTeenSum().
  public int noTeenSum(int a, int b, int c) {
    return fixTeen(a) + fixTeen(b) + fixTeen(c);
  }

  public int fixTeen(int n) {
    switch (n) {
    case 13:
    case 14:
    case 17:
    case 18:
    case 19:
      return 0;
    default:
      return n;
    }
  }

  // For this problem, we'll round an int value up to the next multiple of 10 if
  // its rightmost digit is 5 or more, so 15 rounds up to 20. Alternately, round
  // down to the previous multiple of 10 if its rightmost digit is less than 5,
  // so 12 rounds down to 10. Given 3 ints, a b c, return the sum of their
  // rounded values. To avoid code repetition, write a separate helper
  // "public int round10(int num) {" and call it 3 times. Write the helper
  // entirely below and at the same indent level as roundSum().
  public int roundSum(int a, int b, int c) {
    return round10(a) + round10(b) + round10(c);
  }

  public int round10(int num) {
    int units = num % 10;
    return units >= 5 ? num + (10 - units) : num - units;
  }

  // Given three ints, a b c, return true if one of b or c is "close" (differing
  // from a by at most 1), while the other is "far", differing from both other
  // values by 2 or more.
  public boolean closeFar(int a, int b, int c) {
    if (Math.abs(a - b) <= 1 && (Math.abs(a - c) >= 2 && Math.abs(b - c) >= 2))
      return true;
    if (Math.abs(a - c) <= 1 && (Math.abs(a - b) >= 2 && Math.abs(c - b) >= 2))
      return true;
    return false;
  }

  // Given 2 int values greater than 0, return whichever value is nearest to 21
  // without going over. Return 0 if they both go over.
  public int blackjack(int a, int b) {
    return Math.max(a > 21 ? 0 : a, b > 21 ? 0 : b);
  }

  // Given three ints, a b c, one of them is small, one is medium and one is
  // large. Return true if the three values are evenly spaced, so the difference
  // between small and medium is the same as the difference between medium and
  // large.
  public boolean evenlySpaced(int a, int b, int c) {
    int min = Math.min(Math.min(a, b), Math.min(b, c));
    int max = Math.max(Math.max(a, b), Math.max(b, c));
    int mid;
    if (a > b)
      if (b > c)
        mid = b;
      else if (a > c)
        mid = c;
      else
        mid = a;
    else if (a > c)
      mid = a;
    else if (b > c)
      mid = c;
    else
      mid = b;

    return mid - min == max - mid;
  }

  // We want make a package of goal kilos of chocolate. We have small bars (1
  // kilo each) and big bars (5 kilos each). Return the number of small bars to
  // use, assuming we always use big bars before small bars. Return -1 if it
  // can't be done.
  public int makeChocolate(int small, int big, int goal) {
    int gap = big * 5 > goal ? goal % 5 : goal - big * 5;
    return small >= gap ? gap : -1;
  }
}
