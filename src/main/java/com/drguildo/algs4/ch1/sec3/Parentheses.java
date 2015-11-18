package com.drguildo.algs4.ch1.sec3;

import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;

public class Parentheses {
  public static void main(String[] args) {
    Stack<Character> st = new Stack<>();

    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String line = sc.next();
      for (char c : line.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') {
          st.push(c);
          continue;
        }
        if (c == ')') {
          if (st.pop() != '(')
            fail();
          else
            continue;
        }
        if (c == ']') {
          if (st.pop() != '[')
            fail();
          else
            continue;
        }
        if (c == '}') {
          if (st.pop() != '{')
            fail();
          else
            continue;
        }
      }

      sc.close();

      System.out.println(true);
      System.exit(0);
    }
  }

  private static void fail() {
    System.out.println(false);
    System.exit(-1);
  }
}
