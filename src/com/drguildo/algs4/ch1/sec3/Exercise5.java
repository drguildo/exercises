package com.drguildo.algs4.ch1.sec3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise5 {
  public static void main(String[] args) {
    foo(50);
  }

  private static void foo(int N) {
    Stack<Integer> stack = new Stack<Integer>();
    while (N > 0) {
      stack.push(N % 2);
      N = N / 2;
    }
    for (int d : stack)
      StdOut.print(d);
    StdOut.println();
  }
}
