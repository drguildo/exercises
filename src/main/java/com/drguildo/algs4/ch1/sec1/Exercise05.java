package com.drguildo.algs4.ch1.sec1;

public class Exercise05 {
  public static void main(String[] args) {
    System.out.println(func(0.2, 0.8));
    System.out.println(func(0.0, 0.8));
    System.out.println(func(0.2, 1.0));
    System.out.println(func(0.0, 1.0));
  }

  public static boolean func(double x, double y) {
    return (x > 0.0 && x < 1.0) && (y > 0.0 && y < 1.0);
  }
}
