package com.drguildo.algs4.ch1.sec3;

import edu.princeton.cs.algs4.Stack;

public class CopyStack {
  public static void main(String[] args) {
    Stack<String> src = new Stack<>();
    Stack<String> dst = new Stack<>();

    src.push("first");
    src.push("second");
    src.push("third");
    src.push("fourth");

    copy(src, dst);

    System.out.print("src: |");
    for (String s : src)
      System.out.print(s + "|");
    System.out.println();

    System.out.print("dst: |");
    for (String s : dst)
      System.out.print(s + "|");
    System.out.println();
  }

  private static void copy(Stack<String> src, Stack<String> dst) {
    String[] elems = new String[src.size()];

    int i = src.size() - 1;
    for (String s : src)
      elems[i--] = s;

    for (String s : elems)
      dst.push(s);
  }
}
