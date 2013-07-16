package com.drguildo.algs4.ch1.sec2;

public class Exercise6 {
  public static boolean isCircularRotation(String s1, String s2) {
    if (s1.length() == 0 && s2.length() == 0)
      return true;
    if (s1.length() != 0 && s2.length() == 0)
      return false;
    if (s1.length() == 0 && s2.length() != 0)
      return false;

    String s;
    int nextIndex = s1.indexOf(s2.charAt(0), 0);
    while (nextIndex != -1) {
      s = s1.substring(nextIndex) + s1.substring(0, nextIndex);
      // System.out.println("Comparing against " + s);
      if (s.equals(s2))
        return true;
      nextIndex = s1.indexOf(s2.charAt(0), nextIndex + 1);
    }
    return false;
  }

  public static void main(String[] args) {
    if (args.length < 2)
      System.exit(-1);

    System.out.println(isCircularRotation(args[0], args[1]));
  }
}
